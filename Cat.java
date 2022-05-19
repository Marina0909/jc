package Lesson1;

public class Cat extends Animal implements CanSwim, CanRun {
    private double swimmingSpeed;
    private double runningSpeed;
    private double result;
    private int passed;

    public Cat(String name, String color, int age, double swimmingSpeed, double runningSpeed) {
        super(name, color, age);
        this.swimmingSpeed = swimmingSpeed;
        this.runningSpeed = runningSpeed;
    }

    public Cat(String name, String color, int age) {
        super(name, color, age);
        this.swimmingSpeed = 0;
        this.runningSpeed = 0;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Некорректное значение!");
        } else {
            this.age = age;
        }
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
    public String toString() {
        return "Cat{"  +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age + '\'' +
                ", swimmingSpeed=" + swimmingSpeed +
                ", runningSpeed=" + runningSpeed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return this.age == cat.age &&
                this.name.equals(cat.name) &&
                this.color.equals(cat.color);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.color.hashCode() + this.age;
    }

    public void voice() {
        System.out.println("Кот мяукает!");
    }

    public double swim(Pool pool) {
        System.out.println("Я кот, я плыву!");
        double timeToOvercome = pool.getLenght() / swimmingSpeed;
        System.out.println("Затратил " + timeToOvercome);
        passed +=1;
        return timeToOvercome;
    }

    public double run(Stadium stadium) {
        System.out.println("Я кот, я бегу!");
        double timeToOvercome = stadium.getLenght() / runningSpeed;
        System.out.println("Затратил " + timeToOvercome);
        passed +=1;
        return timeToOvercome;
    }

}

