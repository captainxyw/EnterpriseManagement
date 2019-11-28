package com.xuyewei.dao;

import com.xuyewei.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ClassName:ISysLogDao
 * Package:com.xuyewei.dao
 * Description:
 *
 * @Date:2019/11/28 22:04
 * @Author:xuyewei
 */

public interface ISysLogDao {
    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    public void save(SysLog sysLog) throws Exception;

    @Select("select * from sysLog")
    List<SysLog> findAll() throws Exception;
}
