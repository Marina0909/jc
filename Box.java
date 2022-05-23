package Lesson3;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList <T> box;

    public Box(ArrayList<T> box) {
        this.box = box;
    }

    public ArrayList<T> getBox() {
        return box;
    }

    public void setBox(ArrayList<T> box) {
        this.box = box;
    }


    @Override
    public String toString() {
        return "Box{" +
                "box=" + box +
                '}';
    }

    public double getWeightBox(){
        return box.get(0).getWeight()*box.size();
    }
    public boolean compare(Box box1){
        return this.getWeightBox() == box1.getWeightBox();
    }
    public void move(Box box1){
        if(box.size() == 0){
            System.out.println("Нечего перекладывать - пустая коробка " +this.toString() +
                    " "+ box1.toString());
        } else if(box1.getBox().size() == 0){
            System.out.println("В пустую коробку не добавляем "+ this.toString() +
                    " "+ box1.toString());
        } else if(box.get(0).getClass() != box1.getBox().get(0).getClass()){
            System.out.println("Нельзя пересыпать коробки - разные фрукты "+ this.toString() +
                    " "+ box1.toString());
        } else {
            int s = box.size();
            for (int i = 0; i < s; i++) {
                box1.getBox().add(box.get(0));
                box.remove(0);
            }
            System.out.println("Пересыпано шт. "+ s);
        }
    }

    public static void main(String[] args) {
        Apple apple = new Apple(1.0f);
        Orange orange = new Orange(1.5f);
        Box<Apple> box1 = new Box<>(new ArrayList<>());
        box1.getBox().add(apple);
        box1.getBox().add(apple); //2
        Box<Apple> box2 = new Box<>(new ArrayList<>());
        box2.getBox().addAll(box1.getBox());
        box2.getBox().add(apple); //3
        Box<Apple> box3 = new Box<>(new ArrayList<>());
        box3.getBox().addAll(box1.getBox()); //2
        Box<Orange> box4 = new Box<>(new ArrayList<>());
        box4.getBox().add(orange);
        box4.getBox().add(orange); //2

        System.out.println(box1);
        System.out.println(box2);
        System.out.println(box3);
        System.out.println(box4);
        System.out.println("box1 = box4 "+ box1.compare(box4));
        System.out.println("box1 = box2 "+ box1.compare(box2));
        System.out.println("box1 = box3 "+ box1.compare(box3));
        System.out.println("Вес box3 = "+ box3.getWeightBox());
        System.out.println("Вес box4 = "+ box4.getWeightBox());
        box3.move(box1);
        System.out.println("box3 = " + box3);
        System.out.println("box1 = " + box1);
        box4.move(box2);
        box2.move(box1);
        box1.move(box2);
        box2.move(box1);
    }
}
