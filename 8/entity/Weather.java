package Lesson8.entity;

public class Weather {
    String city;
    String localDate;
    Double minTemperature;
    Double maxTemperature;

    public Weather(String city, String localDate, Double minTemperature, Double maxTemperature) {
        this.city = city;
        this.localDate = localDate;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    @Override
    public String toString() {
        return "Погода " +
                "в городе " + city +
                " на дату " + localDate + " по фаренгейту " +
                "   минимальная температура " + minTemperature +
                "   максимальная температура " + maxTemperature +
                '}';
    }
}
