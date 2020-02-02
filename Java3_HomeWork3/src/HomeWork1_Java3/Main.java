package HomeWork1_Java3;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Задание 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
        Integer arr1[] = {1, 2, 3, 4, 5, 6, 7};
        String arr2[] = {"A", "B", "C"} ;
        swapped(arr1,1,4);
        swapped(arr2,0,2);

        System.out.println("\n----------------------------------------------------------");

        // Задание 2. Написать метод, который преобразует массив в ArrayList;
        String[] arrString = {"A", "B", "C", "D"};
        asList(arrString);

        System.out.println("\n----------------------------------------------------------");

        // Задание 3.
        /*a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
        b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта,
        поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
        c. Для хранения фруктов внутри коробки можете использовать ArrayList;
        d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и
        вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
        e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той,
        которую подадут в compare в качестве параметра, true - если их веса равны,
        false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
        f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в
        другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами),
        соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
        g. Не забываем про метод добавления фрукта в коробку.*/

        // создаем коробки
        Box<Orange> orangeBox = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();
        Box<Apple> appleBox   = new Box<>();
        Box<Apple> appleBox2   = new Box<>();
        // добавляем фрукты
        orangeBox.addFruit(new Orange(),10);
        appleBox.addFruit(new Apple(),10);
        // выведем вес коробок
        System.out.println("Вес orangeBox = "+orangeBox.getWeight());
        System.out.println("Вес orangeBox2 = "+orangeBox2.getWeight());
        System.out.println("Вес appleBox = "+appleBox.getWeight());
        System.out.println("Вес appleBox2 = "+appleBox2.getWeight());
        // сравним по весу
        System.out.println("Сравним вес orangeBox и appleBox: "+orangeBox.compare(appleBox));
        // пересыпаем из коробки в коробку
        System.out.println("Пересыпаем из коробки в коробку.");
        orangeBox.moveToBox(orangeBox2);
        appleBox.moveToBox(appleBox2);
        // выведем вес всех коробок
        System.out.println("Вес коробок после пересыпания:");
        System.out.println("orangeBox = : "+orangeBox.getWeight());
        System.out.println("orangeBox2 = : "+orangeBox2.getWeight());
        System.out.println("appleBox = "+appleBox.getWeight());
        System.out.println("appleBox2 = "+appleBox2.getWeight());

    }

    public static void swapped(Object[] arr, int num1, int num2){
        System.out.println("Массив до изменения: "+ Arrays.toString(arr));
        Object var1 = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = var1;
        System.out.println("Массив после изменения: "+Arrays.toString(arr)+"\n");
    }

    public static <T> void asList(T[]arr){
        ArrayList<T> arrayList = new ArrayList<>(Arrays.asList(arr));
        System.out.println("Массив после преобразования в ArrayList: " + arrayList + "\n");
    }
}