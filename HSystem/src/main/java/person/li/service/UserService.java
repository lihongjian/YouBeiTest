package person.li.service;

import person.li.model.UserDto;

/**
 * Created by hongjian on 2015/10/21.
 */
public interface UserService {

    UserDto findOne(String pk);


    String doCheck();
}
