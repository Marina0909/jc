package Lesson1;

public class Pool extends Obstacle {

    public Pool(String name, double lenght) {
        super(name, lenght);
    }

    @Override
    public String toString() {
        return "Pool{" +
                "name='" + name + '\'' +
                ", lenght=" + lenght +
                '}';
    }

    public double getTimeToOvercomePool(CanSwim swimmer) {
        return swimmer.swim(this);
    }
}
