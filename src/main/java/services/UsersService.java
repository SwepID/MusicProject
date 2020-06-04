package services;

import dao.UsersDao;

public class UsersService {
    UsersDao usersDao = new UsersDao();
    public String Registration(String login, String password){
        return usersDao.Registration(login, password);
    }
    public boolean Authorization(String login, String password){
        return usersDao.Authorization(login, password);
    }
}
