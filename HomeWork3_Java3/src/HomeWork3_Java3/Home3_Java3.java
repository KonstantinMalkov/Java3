package HomeWork3_Java3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Home3_Java3 {
    public static void main(String[] args) throws IOException {
        task1();
        task2();
        task3();
    }

    // Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль
    public static void task1() throws IOException{
        File file = new File("123/4/test1.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i;
        while ((i = bufferedInputStream.read()) != -1){
            byteArrayOutputStream.write(i);
        }
        byte[] b = byteArrayOutputStream.toByteArray();
        System.out.println(Arrays.toString(b));
        bufferedInputStream.close();
        byteArrayOutputStream.close();
    }

    // Последовательно сшить 5 файлов в один (файлы примерно 100 байт).
    // Может пригодиться следующая конструкция: ArrayList<InputStream> al = new ArrayList<>();
    // ... Enumeration<InputStream> e = Collections.enumeration(al);
    public static void task2() throws IOException{
        ArrayList<InputStream> arrayList = new ArrayList<>();
        arrayList.add(new FileInputStream("123/4/1.txt"));
        arrayList.add(new FileInputStream("123/4/2.txt"));
        arrayList.add(new FileInputStream("123/4/3.txt"));
        arrayList.add(new FileInputStream("123/4/4.txt"));
        arrayList.add(new FileInputStream("123/4/5.txt"));
        SequenceInputStream sq = new SequenceInputStream(Collections.enumeration(arrayList));
        int x;
        while ((x = sq.read()) != -1){
            System.out.print((char) x);
        }
        sq.close();
    }

    // Написать консольное приложение, которое умеет постранично читать текстовые файлы (размером > 10 mb).
    // Вводим страницу (за страницу можно принять 1800 символов), программа выводит ее в консоль.
    // Контролируем время выполнения: программа не должна загружаться дольше 10 секунд, а чтение – занимать свыше 5 секунд.
    public static void task3() throws IOException {
        final int PAGE_SIZE = 1800; // принимаем страницу за 1800 знаков
        // создаем raf для считывания с любой части текста
        RandomAccessFile raf = new RandomAccessFile("123/1.txt", "r");

        // через сканер получаем номер страницы, которую хочет получить пользователь
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите страницу: ");
        int p = sc.nextInt() - 1;

        // засекаем время начала
        long t = System.currentTimeMillis();
        raf.seek(p * PAGE_SIZE);
        byte[] barr = new byte[1800];
        raf.read(barr);

        // выводим страницу
        System.out.println(new String(barr));
        raf.close();
        System.out.println();
        // выводим время окончания
        System.out.println(System.currentTimeMillis() - t);
    }

}
