package dao;

import entities.Group;
import entities.Person;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonsDao {
    public Person findPersonById(int id_artist){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Person.class, id_artist);
    }
    public List<Person> findPersonsByName(String first_name){
        Criteria criteria = HibernateSessionFactoryUtil.getSessionFactory().openSession().createCriteria(Person.class);
        List<Person> resultList = new ArrayList<>();
        List<Person> persons = criteria.list();
        for (Person person : persons){
            if (person.getFist_name().equals(first_name)){
                resultList.add(person);
            }
        }
        return resultList;
    }
    public List<Person> showAll(){
        Criteria criteria = HibernateSessionFactoryUtil.getSessionFactory().openSession().createCriteria(Person.class);
        return (List<Person>) criteria.list().stream().distinct().collect(Collectors.toList());
    }
    public String updatePersonNameById(int id_artist, String first_name){
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
            Transaction tx = session.beginTransaction();
            String sql = "update Person p set p.fist_name = :first_name where p.artist_id = :id_artist";
            int updatedEntities = session.createQuery(sql).setString("id_artist", Integer.toString(id_artist)).setString("first_name", first_name).executeUpdate();
            tx.commit();
            return "Entity has been updated";
        }
        catch (Exception e){
            return  e.toString();
        }
    }
    public String updatePersonLastNameById(int id_artist, String last_name){
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
            Transaction tx = session.beginTransaction();
            String sql = "update Person p set p.last_name = :last_name where p.artist_id = :id_artist";
            int updatedEntities = session.createQuery(sql).setString("id_artist", Integer.toString(id_artist)).setString("last_name", last_name).executeUpdate();
            tx.commit();
            return "Entity has been updated";
        }
        catch (Exception e){
            return  e.toString();
        }
    }
    public String updatePersonBirthdayById(int artist_id, String birthday){
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
            Transaction tx = session.beginTransaction();
            String sql = "update Person p set p.birthday = :birthday where p.artist_id = :id_artist";
            int updatedEntities = session.createQuery(sql).setString("id_artist", Integer.toString(artist_id)).setString("birthday", birthday).executeUpdate();
            tx.commit();
            return "Entity has been updated";
        }
        catch (Exception e){
            return  e.toString();
        }
    }
    public String updatePersonSexById(int artist_id, String sex){
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
            Transaction tx = session.beginTransaction();
            String sql = "update Person p set p.sex = :sex where p.artist_id = :id_artist";
            int updatedEntities = session.createQuery(sql).setString("id_artist", Integer.toString(artist_id)).setString("sex", sex).executeUpdate();
            tx.commit();
            return "Entity has been updated";
        }
        catch (Exception e){
            return  e.toString();
        }
    }
    public String deletePersonById(int artist_id){
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
            Transaction tx = session.beginTransaction();
            String sql = "delete Person p where p.artist_id = :id_artist";
            int updatedEntities = session.createQuery(sql).setString("id_artist", Integer.toString(artist_id)).executeUpdate();
            tx.commit();
            return "Entity has been deleted";
        }
        catch (Exception e){
            return  e.toString();
        }
    }
    public String createPerson(String last_name, String first_name, String birthday, String sex){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
        Transaction tx = session.beginTransaction();
        Person person = new Person();
        person.setLast_name(last_name);
        person.setFist_name(first_name);
        person.setBirthday(birthday);
        person.setSex(sex);
        session.save(person);
        tx.commit();
        return "Entity has been created";
    }
}
