package service;

import entity.User;

public interface LoginService {

    boolean validateUser(String username, String password);
    User getUserByNameAndId(String username, String password);
}
