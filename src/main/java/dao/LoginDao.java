package dao;

import entity.User;

public interface LoginDao {
    User findUserByEmailAndPassword(String email, String password);
}
