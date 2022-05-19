package Lesson1;

public class Stadium extends Obstacle{

    public Stadium(String name, double lenght) {
        super(name, lenght);
    }

    @Override
    public String toString() {
        return "Stadium{" +
                "name='" + name + '\'' +
                ", lenght=" + lenght +
                '}';
    }


    public double getTimeToOvercomeStadium(CanRun stadium) {
        return stadium.run(this);
    }
}
