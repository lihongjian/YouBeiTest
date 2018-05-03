package person.li.service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.li.dao.UserDtoMapper;
import person.li.model.UserDto;

/**
 * Created by hongjian on 2015/10/21.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    UserDtoMapper userDtoMapper;

    @Override
    public UserDto findOne(String pk) {
        JSON.parse("AAA");
        return userDtoMapper.selectByPrimaryKey(pk);
    }

    @Override
    public String doCheck() {
        return "abc";
    }


}
