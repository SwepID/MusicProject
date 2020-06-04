package dao;

import entities.Album;
import entities.Person;
import entities.Song;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;
import java.util.stream.Collectors;

public class SongsDao {
    public Song findSongById(int song_id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Song.class, song_id);
    }
    public Song findSongByTitle(String title){
        Criteria criteria = HibernateSessionFactoryUtil.getSessionFactory().openSession().createCriteria(Song.class);
        List<Song> songs = criteria.list();
        for (Song song : songs){
            if (song.getSong_title().equals(title)){
                return song;
            }
        }
        return null;
    }
    public List<Song> showAll(){
        Criteria criteria = HibernateSessionFactoryUtil.getSessionFactory().openSession().createCriteria(Song.class);
        return (List<Song>) criteria.list().stream().distinct().collect(Collectors.toList());
    }
    public String updateSongTitleById(int song_id, String title){
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
            Transaction tx = session.beginTransaction();
            String sql = "update Song s set s.song_title = :title where s.song_id = :song_id";
            int updatedEntities = session.createQuery(sql).setString("song_id", Integer.toString(song_id)).setString("title", title).executeUpdate();
            tx.commit();
            return "Entity has been updated";
        }
        catch (Exception e){
            return  e.toString();
        }
    }
    public String deleteSongById(int song_id){
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
            Transaction tx = session.beginTransaction();
            String sql = "delete Song s where s.song_id = :song_id";
            int deletedEntities = session.createQuery(sql).setString("song_id", Integer.toString(song_id)).executeUpdate();
            tx.commit();
            return "Entity has been deleted";
        }
        catch (Exception e){
            return  e.toString();
        }
    }
    public String createSong(String title, Album album){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
        Transaction tx = session.beginTransaction();
        Song song = new Song();
        song.setSong_title(title);
        song.setAlbum(album);
        session.save(song);
        tx.commit();
        return "Entity has been created";
    }
}
