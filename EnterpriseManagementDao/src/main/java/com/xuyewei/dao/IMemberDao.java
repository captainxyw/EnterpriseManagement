package com.xuyewei.dao;

import com.xuyewei.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * ClassName:IMemberDao
 * Package:com.xuyewei.dao
 * Description:
 *
 * @Date:2019/11/24 22:36
 * @Author:xuyewei
 */

public interface IMemberDao {
    @Select("select * from member where id=#{id}")
    public Member findById(String id) throws Exception;
}
