package o2oboot.dao;

import o2oboot.entity.Access;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface AccessDao {

    int insertAccess(Access access);
    Access queryAccessByUrl(String url);
    //TODO 增删改查access
    Access queryAccessById( Long accessId);
    int updateAccess(Access access);
    int deleteAccess(Long accessId);

    List<Access> queryAllAccess();
}
