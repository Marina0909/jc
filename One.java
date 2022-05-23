package Lesson3;

import java.util.Arrays;

public class One<T> {
    private T[] arr;

    public One(T... arr) {
        this.arr = arr;
    }

    @Override
    public String toString() {
        return "One{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }

    public void ChangeArray(int i, int j){
        if(i < 0 | j < 0 | i >= arr.length | j >= arr.length) {
            System.out.println("Перестановка элементов не выполнена, длина массива " +
                    arr.length + " i=" + i + " j=" + j);
        } else {
            T tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

    }

    public static void main(String[] args) {
        One<String> one1 =  new One<>("ложка", "меда", "бочка","дегтя");
        System.out.println(one1);
        one1.ChangeArray(1,3);
        System.out.println(one1);

        One<Integer> one2 =  new One<>(1, 2, 3, 4, 5);
        System.out.println(one2);
        one2.ChangeArray(0,4);
        System.out.println(one2);
        one2.ChangeArray(1,5);
}


    }
