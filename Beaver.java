package Lesson1;

public class Beaver extends Animal implements CanSwim{
    private double swimmingSpeed;

    private double result;
    private int passed;

    public Beaver(String name, String color, int age, double swimmingSpeed) {
        super(name, color, age);
        this.swimmingSpeed = swimmingSpeed;
    }

    public Beaver(String name, String color, int age) {
        super(name, color, age);
        this.swimmingSpeed = 0;
    }

    public double getSwimmingSpeed() {
        return swimmingSpeed;
    }

    public void setSwimmingSpeed(double swimmingSpeed) {
        this.swimmingSpeed = swimmingSpeed;
    }
    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public int getPassed() {
        return passed;
    }

    public void setPassed(int passed) {
        this.passed = passed;
    }

    public void voice() {
        System.out.println("Бобер фыркает");
    }

    @Override
    public String toString() {
        return "Beaver{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age + '\'' +
                ", simmingSpeed=" + swimmingSpeed +
                '}';
    }

    public double swim(Pool pool) {
        System.out.println("Я бобер я плыву!");
        double timeToOvercome = pool.getLenght() / swimmingSpeed;
        System.out.println("Затратил " + timeToOvercome);
        passed +=1;
        return timeToOvercome;
    }
}
