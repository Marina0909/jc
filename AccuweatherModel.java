package Lesson7;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.*;

public class AccuweatherModel implements WeatherModel {
    //http://dataservice.accuweather.com/forecasts/v1/daily/1day/349727
    private static final String PROTOKOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAY = "5day";
    private static final String API_KEY = "ZrIXLqy7OhK82LZ77CWdXZLcM4XTv3X8";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String METRIC_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";
    private static final String TRUE = "true";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    //private DataBaseRepository dataBaseRepository = new DataBaseRepository();

    public void getWeather(String selectedCity, Period period) throws IOException {
        switch (period) {
            case NOW:
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .addQueryParameter(METRIC_QUERY_PARAM, TRUE)
                        .build();

                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();

                Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
                assert oneDayForecastResponse.body() != null;
                String weatherResponse = oneDayForecastResponse.body().string();
                //System.out.println(weatherResponse);
                JsonNode rootNode = objectMapper.readTree(weatherResponse);
                JsonNode headline = rootNode.path("Headline");
                JsonNode daillyForescasts = rootNode.path("DailyForecasts");

                System.out.println("Погода "  +   "в городе "  + selectedCity + ": "+
                        headline.path("Text").asText());

                Iterator<JsonNode> iterator = daillyForescasts.elements();
                System.out.println("Температура воздуха на день: ");
                while (iterator.hasNext()) {
                    JsonNode day = iterator.next();
                    System.out.println("Минимум " + day.path("Temperature").path("Minimum").path("Value").asText() + " " +
                            day.path("Temperature").path("Minimum").path("Unit").asText() +
                            "    Максимум " + day.path("Temperature").path("Maximum").path("Value").asText() + " " +
                            day.path("Temperature").path("Minimum").path("Unit").asText());
                }
                //TODO: сделать человекочитаемый вывод погоды. Выбрать параметры для вывода на свое усмотрение
                //Например: Погода в городе Москва - 5 градусов по цельсию Expect showers late Monday night
                //dataBaseRepository.saveWeatherToDataBase(new Weather()) - тут после парсинга добавляем данные в БД
                break;
            case FIVE_DAYS:
                HttpUrl httpUrl5 = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .addQueryParameter(METRIC_QUERY_PARAM, TRUE)
                        .build();

                Request request5 = new Request.Builder()
                        .url(httpUrl5)
                        .build();

                Response fiveDaysForecastResponse = okHttpClient.newCall(request5).execute();

                assert fiveDaysForecastResponse.body() != null;
                String weatherResponse5 = fiveDaysForecastResponse.body().string();
                //System.out.println(weatherResponse5);
                JsonNode rootNode5 = objectMapper.readTree(weatherResponse5);
                JsonNode headline5 = rootNode5.path("Headline");
                JsonNode daillyForescasts5 = rootNode5.path("DailyForecasts");

                System.out.println("Погода "  +   "в городе "  + selectedCity + ": "+
                        headline5.path("Text").asText());

                Iterator<JsonNode> iterator5 = daillyForescasts5.elements();
                System.out.println("Температура воздуха на 5 дней: ");
                while (iterator5.hasNext()) {
                    JsonNode day = iterator5.next();
                    System.out.println("Минимум " + day.path("Temperature").path("Minimum").path("Value").asText() + " " +
                            day.path("Temperature").path("Minimum").path("Unit").asText() +
                            "    Максимум " + day.path("Temperature").path("Maximum").path("Value").asText() + " " +
                            day.path("Temperature").path("Minimum").path("Unit").asText());
                }

                //TODO*: реализовать вывод погоды на 5 дней
                break;
        }
    }

    /*@Override
    public List<Weather> getSavedToDBWeather() {
        return dataBaseRepository.getSavedToDBWeather();
    }*/

    private String detectCityKey(String selectCity) throws IOException {
        //http://dataservice.accuweather.com/locations/v1/cities/autocomplete
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", selectCity)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        assert response.body() != null;
        String responseString = response.body().string();
        //System.out.println(responseString);
        return objectMapper.readTree(responseString).get(0).at("/Key").asText();
    }
}

