package com.boot.mvc20220916youri.repository;

import com.boot.mvc20220916youri.domain.User;

public interface UserRepository {
    public int save(User user);
    public User findUserByUserId(String userid);
    public User findUserByUserCode(int userCode);
    public int modify(User user);
    public int remove(int userCode);
}
