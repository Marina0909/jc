package Lesson8;

//import Lesson7.project.entity.Weather;

import Lesson8.entity.Weather;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public interface WeatherModel {
    void getWeather(String selectedCity, Period period) throws IOException, SQLException;

    public List<Weather> getSavedToDBWeather();
}
