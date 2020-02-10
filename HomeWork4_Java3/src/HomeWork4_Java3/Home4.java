package HomeWork4_Java3;

public class Home4 {

    public static void main(String[] args) {
        Home4 home4 = new Home4();
        Home4_Thread1 thread1 = new Home4_Thread1(home4);
        Home4_Thread2 thread2 = new Home4_Thread2(home4);
        Home4_Thread3 thread3 = new Home4_Thread3(home4);
        new Thread(thread1).start();
        new Thread(thread2).start();
        new Thread(thread3).start();
    }

    private int numInOrder = 1;

    public synchronized void printTheLetter1() {
        while (numInOrder != 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        numInOrder = 2;
        System.out.println("А");
        notifyAll();
    }

    public synchronized void printTheLetter2() {
        while (numInOrder != 2) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        numInOrder = 3;
        System.out.println("B");
        notifyAll();
    }

    public synchronized void printTheLetter3() {
        while (numInOrder != 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        numInOrder = 1;
        System.out.println("C");
        notifyAll();
    }
}
