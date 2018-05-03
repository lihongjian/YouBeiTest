package person.li.vo;

public class TheThread implements Runnable {

    private String prefix;

    public TheThread(String prefix){
        this.prefix = prefix;
    }
    @Override
    public void run() {
        for( int i = 0 ; i < 10 ; i ++){
            try {
                Thread.sleep(1000);
                System.out.println(prefix + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
