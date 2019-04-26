package com.gnnu.springbootmybaties.mapper;

import com.gnnu.springbootmybaties.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    @Select("select * from user where uname=#{uname}")
    public User selectByUname(User uname);

    @Delete("delete from user where uname=#{uname}")
    int deleteByName(String uname);

    @Update("update user set uname = #{uname},pwd = #{pwd} where uname=#{id}")
    int updateUser(User user);

    @Select("select * from user where uname=#{uname} and pwd=#{pwd}")
    int login(User user);
}
