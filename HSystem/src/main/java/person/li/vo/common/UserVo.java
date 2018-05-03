package person.li.vo.common;

import person.li.vo.base.ValueObjectVo;

/**
 * Created by hongjian on 2015/9/25.
 */
public class UserVo extends ValueObjectVo{


    String userName;

    String userPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

}
