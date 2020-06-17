package com.Super135.Lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Task №1");
        Integer[] array = new Integer[]{1,2,3,4,5};
        swap(1, 4, array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] +" ");
        }
        System.out.println("");

        System.out.println("Task №2");
        ArrayList<Integer> arrayList = convertMassivInArraList(array);
        System.out.println(arrayList);

        // Task #3
        System.out.println("Task №3");
        List<Orange> arrOrange = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            arrOrange.add(new Orange());
        }


        Box<Orange> orangeBox = new Box<>(arrOrange);
        Box<Apple> appleBox = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        for (int i = 0; i < 12; i++) {
            appleBox.setFrut(new Apple());
            appleBox2.setFrut(new Apple());
        }

        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());
        System.out.println(appleBox.compare(orangeBox));
        appleBox.intersperse(appleBox);
        System.out.println(appleBox);
        appleBox.intersperse(orangeBox);
        appleBox.intersperse(appleBox2);
        System.out.println(appleBox);
        System.out.println(orangeBox);
        System.out.println(appleBox2);

    }

    //Task №1
    private static <T> void swap(int index1, int index2, T[] arr) {
        T element = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = element;
    }

    //Task №2
    private static <T> ArrayList<T> convertMassivInArraList(T[] arr){
        ArrayList<T> list = new ArrayList<>(Arrays.asList(arr));
        return list;
    }

}