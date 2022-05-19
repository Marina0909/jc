package Lesson1;

public abstract class Animal  {
    protected String name;
    protected String color;
    protected int age;
    protected double result; //время по дистанции
    protected int passed;  //пройдено препятствий


    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
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
        this.age = age;
    }


    public double getResult() {
        return result;
    }

    public int getPassed() {
        return passed;
    }

    public void setPassed(int passed) {
        this.passed = passed;
    }

    public void setResult(double result) {
        this.result = result;
    }
    public abstract void voice();

}
