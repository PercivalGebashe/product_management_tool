package service.imp;

import dao.LoginDao;
import dao.imp.LoginDaoImp;
import entity.User;
import service.LoginService;

public class LoginServiceImp implements LoginService {

    private final LoginDao loginDao;

    public LoginServiceImp(LoginDao loginDao){
        this.loginDao = loginDao;
    }

    @Override
    public boolean validateUser(String username, String password) {
        User user = getUserByNameAndId(username,password);

        return user != null;
    }

    @Override
    public User getUserByNameAndId(String username, String password){
        return loginDao.findUserByEmailAndPassword(username,password);
    }


}
