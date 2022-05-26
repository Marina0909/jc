package Lesson4;

import java.lang.reflect.Array;
import java.util.*;

public class Collection4 {
    //печать телефона из справочника
    static void gets(List<Telephone> a, String s){
        boolean found = false;
        Telephone t;
        for (int i = 0; i < a.size(); i++) {
            t = a.get(i);
            if(t.getSurname().equals(s)){
                System.out.println(t.getSurname() + " тел. "+ t.getTelephoneN());
                found = true;
            }
        }
        if(!found){
            System.out.println(s + " тел. не найден ");
        }
    }

    public static void main(String[] args) {
        // 1.
        String[] name = {"Семен", "Татьяна", "Анна", "Кузьма", "Данил",
                "Антон", "Анна", "Ольга", "Семен", "Константин", "Анастасия", "Анна",
                "Прохор", "Антон", "Вера", "Анна", "Владимир", "Константин", "Вадим"};
        System.out.println(Arrays.toString(name));
        Set<String> setNameH = new HashSet<>();
        for (String t : name) {
            setNameH.add(t);
        }
        System.out.println(setNameH);
        ArrayList<String> arrName= new ArrayList<>(Arrays.asList(name));
        System.out.println(arrName);
        Collections.sort(arrName);
        System.out.println(arrName);
        String tName = "";
        int i = 0;
        for(int j = 0; j < arrName.size(); j++) {
            String sName = arrName.get(j);
            if(sName == tName) {
                i ++;
            } else {
                if (tName != "") {
                    System.out.println(tName + " повторяется " + i + " раз");
                }
                tName = sName;
                i = 1;
            }
        }
        System.out.println(tName + " повторяется " + i + " раз");

        // 2.

        List<Telephone> telephones= new ArrayList<>();

        telephones.add(new Telephone("Петров", "8901000000") );
        telephones.add(new Telephone("Чайковский", "8903000000") );
        telephones.add(new Telephone("Петров", "8902000000") );
        gets(telephones,"Петров");
        gets(telephones,"Чибриков");

    }

}
