package com.sky.demo.unit.web_mock;

public class UserService {

    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void  register(String userName, String password) throws DuplicateUserException {
        User user = userDAO.getUser(userName);
        if (user != null){
            throw new DuplicateUserException(userName);
        }
        userDAO.save(userName,password);
    }
}
