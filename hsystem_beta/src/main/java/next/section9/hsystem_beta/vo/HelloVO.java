package next.section9.hsystem_beta.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class HelloVO {

    private String  msg ;

    private String toName;

    @JsonFormat(pattern = "yyyyMMdd",locale = "zh",timezone = "GMT+8")
    private Date nowTime;

    private int gender;
    @JsonIgnore
    private String memberShipGrade;

    private String balance;

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getMemberShipGrade() {
        return memberShipGrade;
    }

    public void setMemberShipGrade(String memberShipGrade) {
        this.memberShipGrade = memberShipGrade;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getNowTime() {
        return nowTime;
    }

    public void setNowTime(Date nowTime) {
        this.nowTime = nowTime;
    }

    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }






}
