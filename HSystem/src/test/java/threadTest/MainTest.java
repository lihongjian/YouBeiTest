package threadTest;


import org.junit.Test;

public class MainTest {

    @Test
    public void parentAndChildTest(){
        System.out.println(" mark ! main run start !");

        TheThread A = new TheThread("A : ");
        TheThread B = new TheThread("B : ");

        Thread m = Thread.currentThread();

        Thread TA = new Thread(A,"TA");
//        TA.setDaemon(true);
        TA.start();
        Thread TB = new Thread(B,"TB");
//        TB.setDaemon(true);
        TB.start();

        System.out.println(" mark ! main running !");

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" mark ! main run over !");
    }

    public static void main(String[] args){
        MainTest mt = new MainTest();
        mt.parentAndChildTest();
    }




    @Test
    public  void doTest1(){
        Thread a = new Thread (new Runnable() {
            @Override
            public void run() {
                SynchronizedTest test1 = new SynchronizedTest();
                try {
                    test1.test1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"threada");

        Thread b = new Thread (new Runnable() {
            @Override
            public void run() {
                SynchronizedTest test2 = new SynchronizedTest();
                try {
                    test2.test1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"threadb");
        a.start();
        b.start();
        try {
            a.join();
            b.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void doTest2(){
        final TestVo testvo = new TestVo();
        Thread a = new Thread (new Runnable() {
            @Override
            public void run() {
                SynchronizedTest test1 = new SynchronizedTest(testvo);
                try {
                    test1.test2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"threada");

        Thread b = new Thread (new Runnable() {
            @Override
            public void run() {
                SynchronizedTest test2 = new SynchronizedTest(testvo);
                try {
                    test2.test2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"threadb");
        a.start();
        b.start();
        try {
            a.join();
            b.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
