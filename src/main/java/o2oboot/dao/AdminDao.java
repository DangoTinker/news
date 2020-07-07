package o2oboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper

public interface AdminDao {
    int queryAdminSignIn(@Param("adminID") String adminID, @Param("adminPassword") String adminPassword);
}
