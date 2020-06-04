package dao;

import entities.Album;
import entities.Artist;
import entities.Country;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;
import java.util.stream.Collectors;

public class CountriesDao {
    public Country findCountryById(int country_id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Country.class, country_id);
    }
    public List<Country> showAll(){
        Criteria criteria = HibernateSessionFactoryUtil.getSessionFactory().openSession().createCriteria(Country.class);
        return (List<Country>) criteria.list().stream().distinct().collect(Collectors.toList());
    }
    public String updateCountryNameById(int country_id, String country_name){
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
            Transaction tx = session.beginTransaction();
            String sql = "update Country c set c.country_name = :country_name where c.country_id = :country_id";
            int updatedEntities = session.createQuery(sql).setString("country_name", country_name).setString("country_id", Integer.toString(country_id)).executeUpdate();
            tx.commit();
            return "Entity has been updated";
        } catch (Exception e) {
            return e.toString();
        }
    }
    public String deleteCountryById(int country_id){
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
            Transaction tx = session.beginTransaction();
            String sql = "delete Country c where c.country_id = :country_id";
            int deletedEntities = session.createQuery(sql).setString("country_id", Integer.toString(country_id)).executeUpdate();
            tx.commit();
            return "Entity has been deleted";
        } catch (Exception e) {
            return e.toString();
        }
    }
    public String deleteCountryByName(String country_name){
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
            Transaction tx = session.beginTransaction();
            String sql = "delete Country c where c.country_name = :country_name";
            int deletedEntities = session.createQuery(sql).setString("country_name", country_name).executeUpdate();
            tx.commit();
            return "Entity has been deleted";
        } catch (Exception e) {
            return e.toString();
        }
    }
    public String createCountry(String country_name){
        try{
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
            Transaction tx = session.beginTransaction();
            Country country = new Country();
            country.setCountry_name(country_name);
            session.save(country);
            tx.commit();
            return "Entity has been created";
        }catch (Exception e){
            return e.toString();
        }
    }

}
