package HomeWork4_Java3;

public class Home4_Thread1 implements Runnable {
    Home4 home4;

    public Home4_Thread1(Home4 home4) {
        this.home4 = home4;
    }

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            home4.printTheLetter1();
        }
    }
}
