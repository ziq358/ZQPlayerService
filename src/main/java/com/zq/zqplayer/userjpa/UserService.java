package com.zq.zqplayer.userjpa;

import com.zq.zqplayer.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    JpaUserRepository jpaUserRepository;

    @Override
    public List<User> getAllUser() {
        List<User> users = jpaUserRepository.findAll();
        System.out.println(users.toString());
        return users;
    }

    @Override
    public int addUser(User user) {
        if (jpaUserRepository.existsById(user.getId())){
            System.out.println("userjpa  is existed");
            return ErrorCode.EXISTUSER;
        }
        User saveUser = jpaUserRepository.save(user);
        if (saveUser != null && saveUser.getId() == user.getId()) {
            System.out.println("save success");
            return ErrorCode.ADDSUCCESS;
        } else {
            System.out.println("save failure");
            return ErrorCode.ADDFAIL;
        }
    }

    @Override
    public int deleteUser(long id) {
        if (jpaUserRepository.existsById(id)) {
            jpaUserRepository.deleteById(id);
            System.out.println("删除成功");
            return ErrorCode.DELETESUCCESS;
        }
        System.out.println("删除失败");
        return ErrorCode.NOTEXISTUSER;
    }

    @Override
    public int updateUser(User user) {
        if (jpaUserRepository.existsById(user.getId())){
            jpaUserRepository.save(user);
            System.out.println("更新成功");
            return ErrorCode.UPDATESUCCESS;
        }
        System.out.println("更新失败");
        return ErrorCode.UPDATEFAIL;
    }

    @Override
    public User queryUser(long id) {
        User user = null;
        if (jpaUserRepository.existsById(id)){
            user = jpaUserRepository.findById(id).get();
            System.out.println(user.toString());
        }
        return user;
    }
}