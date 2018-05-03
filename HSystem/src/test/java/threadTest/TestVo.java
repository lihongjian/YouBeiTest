package threadTest;

public class TestVo {

    public void doTest() {
        for(int i = 0 ; i < 5 ; i ++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "  testvo show : " + i);
        }
    }
}
