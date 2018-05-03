package person.li.controller;

import Hsystem.base.Bussiness2Exception;
import Hsystem.base.Bussiness3Exception;
import Hsystem.base.BussinessException;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import person.li.vo.common.UserVo;

/**
 * Created by hongjian on 2015/9/24.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {


    @RequestMapping(value = "/checkUser.do")
    @ResponseBody
    public String checkUser(UserVo userVo){

        System.out.println(userVo.getUserName());
        System.out.println(userVo.getUserPassword());
        String resp = JSON.toJSONString(userVo);

        if(userVo.getUserName().equals("1111")){
            throw new BussinessException("用户名不正确！");
        }

        if(userVo.getUserName().equals("2222")){
            throw new Bussiness2Exception("用户名2不正确！");
        }

        if(userVo.getUserName().equals("3333")){
            throw new Bussiness3Exception("用户名2不正确！");
        }
        return resp;
    }


}
