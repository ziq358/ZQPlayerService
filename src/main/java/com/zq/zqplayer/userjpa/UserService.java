package com.zq.zqplayer.userjpa;

import com.zq.zqplayer.ErrorCode;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.zqplayer.model.User;

@Service
public class UserService implements IUserService {
private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    JpaUserRepository jpaUserRepository;

    @Override
    public java.util.List<User> getAllUser() {
        java.util.List<User> users = jpaUserRepository.findAll();
        LOG.info(users.toString());
        return users;
    }

    @Override
    public int addUser(User user) {
        if (jpaUserRepository.existsById(user.getId())){
            LOG.info("userjpa  is existed");
            return ErrorCode.EXISTUSER;
        }
        User saveUser = jpaUserRepository.save(user);
        if (saveUser != null && saveUser.getId() == user.getId()) {
            LOG.info("save success");
            return ErrorCode.ADDSUCCESS;
        } else {
            LOG.info("save failure");
            return ErrorCode.ADDFAIL;
        }
    }

    @Override
    public int deleteUser(long id) {
        if (jpaUserRepository.existsById(id)) {
            jpaUserRepository.deleteById(id);
            LOG.info("删除成功");
            return ErrorCode.DELETESUCCESS;
        }
        LOG.info("删除失败");
        return ErrorCode.NOTEXISTUSER;
    }

    @Override
    public int updateUser(User user) {
        if (jpaUserRepository.existsById(user.getId())){
            jpaUserRepository.save(user);
            LOG.info("更新成功");
            return ErrorCode.UPDATESUCCESS;
        }
        LOG.info("更新失败");
        return ErrorCode.UPDATEFAIL;
    }

    @Override
    public User queryUser(long id) {
        User user = null;
        if (jpaUserRepository.existsById(id)){
            user = jpaUserRepository.findById(id).get();
            LOG.info(user.toString());
        }
        return user;
    }
}