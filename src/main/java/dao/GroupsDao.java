package dao;

import entities.Group;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;
import java.util.stream.Collectors;

public class GroupsDao {
    public Group findGroupById(int group_id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Group.class, group_id);
    }
    public Group findGroupByName(String group_name){
        Criteria criteria = HibernateSessionFactoryUtil.getSessionFactory().openSession().createCriteria(Group.class);

        List<Group> groups = criteria.list();
        for (Group group : groups){
            if (group.getGroup_name().equals(group_name)){
                return  group;
            }
        }
        return  null;
    }
    public List<Group> showAll(){
        Criteria criteria = HibernateSessionFactoryUtil.getSessionFactory().openSession().createCriteria(Group.class);
        return  (List<Group>) criteria.list().stream().distinct().collect(Collectors.toList());
    }
    public String updateGroupNameById(int group_id, String group_name){
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
            Transaction tx = session.beginTransaction();
            String sql = "update Group g set g.group_name = :group_name where g.group_id = :group_id";
            int updatedEntities = session.createQuery(sql).setString("group_id", Integer.toString(group_id)).setString("group_name", group_name).executeUpdate();
            tx.commit();
            return "Entity has been updated";
        }
        catch (Exception e){
            return  e.toString();
        }
    }
    public String updateGroupNameByName(String old_group_name, String group_name){
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
            Transaction tx = session.beginTransaction();
            String sql = "update Group g set g.group_name = :group_name where g.group_name = :old_group_name";
            int updatedEntities = session.createQuery(sql).setString("group_name", group_name).setString("old_group_name", old_group_name).executeUpdate();
            tx.commit();
            return "Entity has been updated";
        }
        catch (Exception e){
            return  e.toString();
        }
    }
    public String deleteGroupById(int group_id){
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
            Transaction tx = session.beginTransaction();
            String sql = "delete Group g where g.group_id = :group_id";
            int deletedEntities = session.createQuery(sql).setString("group_id", Integer.toString(group_id)).executeUpdate();
            tx.commit();
            return "Entity has been deleted";
        }
        catch (Exception e){
            return  e.toString();
        }
    }
    public String deleteGroupByName(String group_name){
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
            Transaction tx = session.beginTransaction();
            String sql = "delete Group g where g.group_name = :group_name";
            int deletedEntities = session.createQuery(sql).setString("group_name", group_name).executeUpdate();
            tx.commit();
            return "Entity has been deleted";
        }
        catch (Exception e){
            return  e.toString();
        }
    }
    public String createGroup(String group_name){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
        Transaction tx = session.beginTransaction();
        session.save(new Group(group_name));
        tx.commit();
        return "Entity has been created";
    }

}
