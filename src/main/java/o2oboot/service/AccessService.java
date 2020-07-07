package o2oboot.service;

import o2oboot.entity.Access;

import java.util.List;

public interface AccessService {
    int addAccess(Access access);
    int updateAccess(Access access);
    int deleteAccess(Long accessId);
    Access queryAccessById(Long accessId);
    List <Access> queryAllAccess();
}
