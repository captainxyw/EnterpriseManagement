package com.xuyewei.dao;

import com.xuyewei.domain.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ClassName:IPermissionDao
 * Package:com.xuyewei.dao
 * Description:
 *
 * @Date:2019/11/26 21:56
 * @Author:xuyewei
 */

public interface IPermissionDao {
    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{roleId})")
    public List<Permission> findPermissionByRoleId(String roleId) throws Exception;
}
