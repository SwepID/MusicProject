package dao;

import entities.Genre;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import utils.HibernateSessionFactoryUtil;

import javax.persistence.criteria.CriteriaUpdate;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

public class GenresDao {
    public Genre findById(int genre_id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Genre.class, genre_id);
    }
    public Genre findByName(String genre_name){
        Criteria criteria = HibernateSessionFactoryUtil.getSessionFactory().openSession().createCriteria(Genre.class);

        List<Genre> genre = criteria.list();
        for (Genre gen : genre){
            if (gen.getGenre_name().equals(genre_name)){
                return  gen;
            }
        }
        return  null;
    }
    public List<Genre> showAll(){
        Criteria criteria = HibernateSessionFactoryUtil.getSessionFactory().openSession().createCriteria(Genre.class);
        return (List<Genre>) criteria.list().stream().distinct().collect(Collectors.toList());
    }
    public String updateGenreNameById(String genre_name, int genre_id){
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
            Transaction tx = session.beginTransaction();
            String sql = "update Genre g set g.genre_name = :genre_name where g.genre_id = :genre_id";
            int updatedEntities = session.createQuery(sql).setString("genre_name", genre_name).setString("genre_id", Integer.toString(genre_id)).executeUpdate();
            tx.commit();
            return "Entity has been updated";
        }
        catch (Exception e){
            return  e.toString();
        }

    }
    public String updateGenreNameByName(String old_genre_name, String new_genre_name){
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
            Transaction tx = session.beginTransaction();
            String sql = "update Genre g set g.genre_name = :new_genre_name where g.genre_name = :old_genre_name";
            int updatedEntities = session.createQuery(sql).setString("new_genre_name", new_genre_name).setString("old_genre_name", old_genre_name).executeUpdate();
            tx.commit();
            return "Entity has been updated";
        }
        catch (Exception e){
            return  e.toString();
        }

    }
    public String deleteGenreById(int genre_id){
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
            Transaction tx = session.beginTransaction();
            String sql = "delete Genre g where g.genre_id = :genre_id";
            int deletedEntities = session.createQuery(sql).setString("genre_id", Integer.toString(genre_id)).executeUpdate();
            tx.commit();
            return "Entity has been deleted";
        }
        catch (Exception e){
            return  e.toString();
        }

    }
    public String deleteGenreByName(String genre_name){
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
            Transaction tx = session.beginTransaction();
            String sql = "delete Genre g where g.genre_name = :genre_name";
            int deletedEntities = session.createQuery(sql).setString("genre_name", genre_name).executeUpdate();
            tx.commit();
            return "Entity has been deleted";
        }
        catch (Exception e){
            return  e.toString();
        }

    }
    public String createGenre(String genre_name){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
        Transaction tx = session.beginTransaction();
        session.save(new Genre(genre_name));
        tx.commit();
        return "Entity has been created";
    }
}
