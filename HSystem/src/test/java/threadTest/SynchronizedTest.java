package threadTest;

import org.junit.Test;

public class SynchronizedTest {

    TestVo testvo = null;

    public SynchronizedTest(){
    }

    public SynchronizedTest(TestVo testvo){
        this.testvo = testvo;
    }
    /**
     * synchronized 获取的是this对象的对象锁
     * 如果进入此方法的SynchronizedTest不是同一个对象则不锁定
     * @throws InterruptedException
     */
    public void test1() throws InterruptedException {
        synchronized (this){
            for(int i = 0 ; i < 5 ; i ++){
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
    /**
     *  synchronized (testvo){，获取的是TestVo这个对象的对象锁
     *  哪个线程获取到testvo这个对象的对象锁，synchronized里的代码由哪个线程执行
     * @throws InterruptedException
     */
    public void test2() throws InterruptedException {
        synchronized (testvo){
            for(int i = 0 ; i < 5 ; i ++){
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
            testvo.doTest();
        }
    }

}
