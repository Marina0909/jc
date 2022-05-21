package Lesson2;

public class SumArrInt {

    public static int SumArr(String[][] Arr) {
        if(Arr.length != 4 || Arr[0].length != 4) {
            throw new MyArraySizeException("Передан массив " + Arr.length + "x" + Arr[0].length + ".  Должен быть 4х4");
        }
        int sum = 0;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if (Arr[i][j].matches("[-+]?\\d+")) {
                    sum += Integer.parseInt(Arr[i][j]);
                } else {
                    throw new MyArrayDataException("Элемент  - не число: Arr[" + i + "][" + j + "]");
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String [][] Arr1 = {{"1", "2", "3", "4"},
                {"1", "2", "3", "4"},{"1", "2", "3", "4"},
                {"1", "2", "3", "4"}};
        String [][] Arr2 = {{"1", "2", "3", "4"},
                {"1", "2", "3", "4"}};
        String [][] Arr3 = {{"1", "2", "3", "4"},
                {"1", "2", "3", "Четыре"},{"1", "2", "3", "4"},
                {"1", "2", "3", "4"}};
        System.out.println("Сумма Arr1 " + SumArr(Arr1));
        System.out.println("Сумма Arr2 " + SumArr(Arr2));
        System.out.println("Сумма Arr3 " + SumArr(Arr3));

    }
}
