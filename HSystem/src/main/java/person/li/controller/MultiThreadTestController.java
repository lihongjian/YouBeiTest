package person.li.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import person.li.vo.TheThread;

@Controller
public class MultiThreadTestController {

    @RequestMapping(value = "/multiThreadTest")
    @ResponseBody
    public String multiThreadTest(){
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
        return " test finished !";
    }
}
