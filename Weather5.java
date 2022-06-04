package Lesson6;

import okhttp3.*;
import java.io.IOException;

public class Weather5 {

    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();
        // GET https://api.weather.yandex.ru/v2/forecast?lat=56.821848&lon=60.567839&land=ru_RU&limit=5&hours=false&extra=true

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("https")
                .host("api.weather.yandex.ru")
                .addPathSegment("v2")
                .addPathSegment("forecast")
                .addQueryParameter("lat", String.valueOf(56.821848))
                .addQueryParameter("lon", String.valueOf(60.567839))
                .addQueryParameter("land", "ru_RU")
                .addQueryParameter("limit", String.valueOf(5))
                .addQueryParameter("hours", String.valueOf(false))
                .addQueryParameter("extra", String.valueOf(true))
                .build();

        String key = "af90db2c-cfc5-4ece-9cbf-c62ad2b70e81";

        Request request = new Request.Builder()
                .url(httpUrl)
                .addHeader("X-Yandex-API-Key", key)
                .build();

        try (Response response = client.newCall(request).execute()) {

            System.out.println(response.isSuccessful());
            if (response.body() != null) {
                String responseBody;
                responseBody = response.body().string();
                System.out.println(responseBody);
            }
        }
    }

}