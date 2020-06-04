package dao;

import entities.Album;
import entities.Artist;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.Date;
import java.util.List;

public class AlbumsDao {
    public Album findAlbumById(int album_id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Album.class, album_id);
    }
    public Album findAlbumByTitle(String title){
        Criteria criteria = HibernateSessionFactoryUtil.getSessionFactory().openSession().createCriteria(Album.class);

        List<Album> albums = criteria.list();
        for (Album al : albums){
            if (al.getAlbum_title().equals(title)){
                return  al;
            }
        }
        return  null;
    }
    public List<Album> showAll(){
        Criteria criteria = HibernateSessionFactoryUtil.getSessionFactory().openSession().createCriteria(Album.class);
        return criteria.list();
    }
    public String updateAlbumTitleById(int album_id, String album_title){
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
            Transaction tx = session.beginTransaction();
            String sql = "update Album a set a.album_title = :album_title where a.album_id = :album_id";
            int updatedEntities = session.createQuery(sql).setString("album_title", album_title).setString("album_id", Integer.toString(album_id)).executeUpdate();
            tx.commit();
            return "Entity has been updated";
        }catch (Exception e){
            return e.toString();
        }
    }
    public String updateAlbumTitleByTitle(String old_title, String new_title){
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
            Transaction tx = session.beginTransaction();
            String sql = "update Album a set a.album_title = :album_title where a.album_title = :old_title";
            int updatedEntities = session.createQuery(sql).setString("album_title", new_title).setString("old_title", old_title).executeUpdate();
            tx.commit();
            return "Entity has been updated";
        }catch (Exception e){
            return e.toString();
        }
    }
    public String updateAlbumYearById(int album_id, String album_year){
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
            Transaction tx = session.beginTransaction();
            String sql = "update Album a set a.album_year = :album_year where a.album_id = :album_id";
            int updatedEntities = session.createQuery(sql).setString("album_year", album_year).setString("album_id", Integer.toString(album_id)).executeUpdate();
            tx.commit();
            return "Entity has been updated";
        }catch (Exception e){
            return e.toString();
        }
    }
    public String updateAlbumTracksById(int album_id, int album_tracks){
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
            Transaction tx = session.beginTransaction();
            String sql = "update Album a set a.album_tracks = :album_tracks where a.album_id = :album_id";
            int updatedEntities = session.createQuery(sql).setString("album_tracks", Integer.toString(album_tracks)).setString("album_id", Integer.toString(album_id)).executeUpdate();
            tx.commit();
            return "Entity has been updated";
        }catch (Exception e){
            return e.toString();
        }
    }
    public String deleteAlbumById(int album_id){
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
            Transaction tx = session.beginTransaction();
            String sql = "delete Album al where al.album_id = :album_id";
            int updatedEntities = session.createQuery(sql).setString("album_id", Integer.toString(album_id)).executeUpdate();
            tx.commit();
            return "Entity has been deleted";
        }catch (Exception e){
            return e.toString();
        }
    }
    public String deleteAlbumByTitle(String album_title){
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
            Transaction tx = session.beginTransaction();
            String sql = "delete Album al where al.album_title = :album_title";
            int updatedEntities = session.createQuery(sql).setString("album_title", album_title).executeUpdate();
            tx.commit();
            return "Entity has been deleted";
        }catch (Exception e){
            return e.toString();
        }
    }
    public String createAlbum(Artist artist, String album_title, String album_year, int album_tracks){
        try{
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
            Transaction tx = session.beginTransaction();
            Album album = new Album(album_title,album_year, album_tracks, artist);
            session.save(album);
            tx.commit();
            return "Entity has been created";
        }catch (Exception e){
            return e.toString();
        }
    }
}
