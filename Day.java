package Lesson7;


public class Day {
    private float Icon;
    private String IconPhrase;
    private boolean HasPrecipitation;
    private String PrecipitationType;
    private String PrecipitationIntensity;


    // Getter Methods

    public float getIcon() {
        return Icon;
    }

    public String getIconPhrase() {
        return IconPhrase;
    }

    public boolean getHasPrecipitation() {
        return HasPrecipitation;
    }

    public String getPrecipitationType() {
        return PrecipitationType;
    }

    public String getPrecipitationIntensity() {
        return PrecipitationIntensity;
    }

    // Setter Methods

    public void setIcon(float Icon) {
        this.Icon = Icon;
    }

    public void setIconPhrase(String IconPhrase) {
        this.IconPhrase = IconPhrase;
    }

    public void setHasPrecipitation(boolean HasPrecipitation) {
        this.HasPrecipitation = HasPrecipitation;
    }

    public void setPrecipitationType(String PrecipitationType) {
        this.PrecipitationType = PrecipitationType;
    }

    public void setPrecipitationIntensity(String PrecipitationIntensity) {
        this.PrecipitationIntensity = PrecipitationIntensity;
    }

    @Override
    public String toString() {
        return "Day{" +
                "Icon=" + Icon +
                ", IconPhrase='" + IconPhrase + '\'' +
                ", HasPrecipitation=" + HasPrecipitation +
                ", PrecipitationType='" + PrecipitationType + '\'' +
                ", PrecipitationIntensity='" + PrecipitationIntensity + '\'' +
                '}';
    }
}



