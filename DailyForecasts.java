package Lesson7;

import java.util.ArrayList;

public class DailyForecasts {
    private String Date;
    private float EpochDate;
    Temperature TemperatureObject;
    Day DayObject;
    Night NightObject;
    ArrayList< Object > Sources = new ArrayList < Object > ();
    private String MobileLink;
    private String Link;


    // Getter Methods

    public String getDate() {
        return Date;
    }

    public float getEpochDate() {
        return EpochDate;
    }

    public Temperature getTemperature() {
        return TemperatureObject;
    }

    public Day getDay() {
        return DayObject;
    }

    public Night getNight() {
        return NightObject;
    }

    public String getMobileLink() {
        return MobileLink;
    }

    public String getLink() {
        return Link;
    }

    // Setter Methods

    public void setDate(String Date) {
        this.Date = Date;
    }

    public void setEpochDate(float EpochDate) {
        this.EpochDate = EpochDate;
    }

    public void setTemperature(Temperature TemperatureObject) {
        this.TemperatureObject = TemperatureObject;
    }

    public void setDay(Day DayObject) {
        this.DayObject = DayObject;
    }

    public void setNight(Night NightObject) {
        this.NightObject = NightObject;
    }

    public void setMobileLink(String MobileLink) {
        this.MobileLink = MobileLink;
    }

    public void setLink(String Link) {
        this.Link = Link;
    }

    @Override
    public String toString() {
        return "DailyForecasts{" +
                "Date='" + Date + '\'' +
                ", EpochDate=" + EpochDate +
                ", TemperatureObject=" + TemperatureObject +
                ", DayObject=" + DayObject +
                ", NightObject=" + NightObject +
                ", Sources=" + Sources +
                ", MobileLink='" + MobileLink + '\'' +
                ", Link='" + Link + '\'' +
                '}';
    }
}
