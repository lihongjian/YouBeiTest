package person.li.dao;


import person.li.model.UserDto;

public interface UserDtoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_user
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String pkUser);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_user
     *
     * @mbggenerated
     */
    int insert(UserDto record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_user
     *
     * @mbggenerated
     */
    int insertSelective(UserDto record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_user
     *
     * @mbggenerated
     */
    UserDto selectByPrimaryKey(String pkUser);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(UserDto record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(UserDto record);
}