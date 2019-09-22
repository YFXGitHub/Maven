package com.yfx.springboot.dao;

import com.yfx.springboot.entity.User;
import org.apache.ibatis.annotations.*;

//表名这是一个操作数据的接口
//@Mapper               //@Mapper 表示这是一个操作数据表的一个接口， 一旦接口多了，就表明每个接口上都要加上一个@Mapper,
                        //我们还可在主程序中添加@MapperScan("com.yfx.springboot.dao")   它就会扫描这个路径下的所有接口，这时接口中的@Mapper就可省略！
public interface UserMapper {

    @Select("select * from User where uid = #{uid}")
    public User getById(Integer uid);

    @Options(useGeneratedKeys = true, keyProperty = "uid")      //表示插入数据后获取主键
    @Insert("insert into user values(null,#{uname},#{upwd},#{emial},#{phone})")
    public int add(User user);

    @Update("update user set uname=#{uname},upwd=#{upwd},emial=#{emial},phone=#{phone} where uid=#{uid}")
    public int update(User user);

    @Delete("delete from user where uid=#{uid}")
    public int delete(Integer uid);

}
