package next.section9.hsystem_beta.controller;

import next.section9.hsystem_beta.vo.HelloVO;
import next.section9.hsystem_beta.vo.ServerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @Autowired
    ServerInfo serverInfo;

    @RequestMapping(value = "/hi")
    public String sayHi(String name){
        return "hi : " + name;
    }

    @RequestMapping(value = "/sayHello")
    public HelloVO sayHello(String name){
        HelloVO hv = new HelloVO();
        hv.setToName(name);
        hv.setMsg(serverInfo.getAuthor() + " show his respect!");
        hv.setNowTime(new Date());
        hv.setGender(1);
        hv.setMemberShipGrade("GOLD");
        hv.setBalance("0.01");
        return hv;
    }

}
