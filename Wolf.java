package Lesson1;

public class Wolf extends Animal implements CanSwim, CanRun {
    private double swimmingSpeed;
    private double runningSpeed;
    private double result;
    private int passed;

    public Wolf(String name, String color, int age) {
        super(name, color, age);
        this.swimmingSpeed = 0;
        this.runningSpeed = 0;
    }

    public Wolf(String name, String color, int age, double swimmingSpeed, double runningSpeed) {
        super(name, color, age);
        this.swimmingSpeed = swimmingSpeed;
        this.runningSpeed = runningSpeed;
    }


    public double getSwimmingSpeed() {
        return swimmingSpeed;
    }
    public void setSwimmingSpeed(double swimmingSpeed) {
        this.swimmingSpeed = swimmingSpeed;
    }
    public double getRunningSpeed() {
        return runningSpeed;
    }

    public void setRunningSpeed(double runningSpeed) {
        this.runningSpeed = runningSpeed;
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

    @Override
    public void voice() {
        System.out.println("Волк воет!");
    }

    @Override
    public String toString() {
        return "Wolf{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age + '\'' +
                ", swimmingSpeed=" + swimmingSpeed +
                ", runningSpeed=" + runningSpeed +
                '}';
    }

    public double swim(Pool pool) {
        System.out.println("Я волк, я плыву!");
        double timeToOvercome = pool.getLenght() / swimmingSpeed;
                System.out.println("Затратил " + timeToOvercome);
        passed +=1;
        return timeToOvercome;
    }

    public double run(Stadium stadium) {
        System.out.println("Я волк, я бегу!");
        double timeToOvercome = stadium.getLenght() / runningSpeed;
        System.out.println("Затратил " + timeToOvercome);
        setPassed(getPassed() +1);
        return timeToOvercome;
    }
}
