package o2oboot.service.impl;

import o2oboot.dao.AccessDao;
import o2oboot.entity.Access;
import o2oboot.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccessServiceImpl implements AccessService {

    @Autowired
    private AccessDao accessDao;

    @Override
    public int addAccess(Access access) {
        return accessDao.insertAccess(access);
    }

    @Override
    public int updateAccess(Access access) {
        return accessDao.updateAccess(access);
    }

    @Override
    public int deleteAccess(Long accessId) {
        return accessDao.deleteAccess(accessId);
    }

    @Override
    public Access queryAccessById(Long accessId) {
        return accessDao.queryAccessById(accessId);
    }

    @Override
    public List<Access> queryAllAccess() {
        return accessDao.queryAllAccess();
    }
}
