package dao;

import entities.Album;
import entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.security.crypto.bcrypt.BCrypt;
import utils.HibernateSessionFactoryUtil;

public class UsersDao {
    public String Registration(String login, String password) {
        try{

            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
            Transaction tx = session.beginTransaction();
            if (HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, login) == null){
                if(login.length() > 0 && password.length() > 0) {
                    String hash = BCrypt.hashpw(password, BCrypt.gensalt());
                    User user = new User(login, hash);
                    session.save(user);
                    tx.commit();
                    return "Successful registration";
                }
                else {
                    return "Login or password isn't correct";
                }
            }
            else {
                return "This login is already registered";
            }

        }
        catch (Exception e){
            return e.toString();
        }
    }
    public boolean Authorization(String login, String password){
        User user = HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, login);
        if (user != null) {
            if (BCrypt.checkpw(password, user.getPassword())) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }

    }
}
