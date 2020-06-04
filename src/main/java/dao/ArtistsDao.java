package dao;

import entities.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ArtistsDao {
    public Artist findArtistById(int artist_id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Artist.class, artist_id);
    }
    public List<Artist> showAll(){
        Criteria criteria = HibernateSessionFactoryUtil.getSessionFactory().openSession().createCriteria(Artist.class);
        return (List<Artist>) criteria.list().stream().distinct().collect(Collectors.toList());
    }

    public String deleteArtistById(int artist_id) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
            Transaction tx = session.beginTransaction();
            String sql = "delete Artist ar where ar.artist_id = :artist_id";
            int deletedEntities = session.createQuery(sql).setString("artist_id", Integer.toString(artist_id)).executeUpdate();
            tx.commit();
            return "Entity has been deleted";
        } catch (Exception e) {
            return e.toString();
        }
    }

    public String updateArtistCountryById(int artist_id, int country_id) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
            Transaction tx = session.beginTransaction();
            String sql = "update Artist ar set ar.country = :country_id where ar.artist_id = :artist_id";
            int updatedEntities = session.createQuery(sql).setString("artist_id", Integer.toString(artist_id)).setString("country_id", Integer.toString(country_id)).executeUpdate();
            tx.commit();
            return "Entity has been update";
        } catch (Exception e) {
            return e.toString();
        }
    }

    public String updateArtistSiteById(int artist_id, String artist_site_url) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
            Transaction tx = session.beginTransaction();
            String sql = "update Artist ar set ar.artist_site_url = :artist_site_url where ar.artist_id = :artist_id";
            int updatedEntities = session.createQuery(sql).setString("artist_id", Integer.toString(artist_id)).setString("artist_site_url", artist_site_url).executeUpdate();
            tx.commit();
            return "Entity has been updated";
        } catch (Exception e) {
            return e.toString();
        }
    }
    public String createArtist(int artist_id, Genre genre, Country country, String artist_site_url){
        try{
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession().getSession();
            Transaction tx = session.beginTransaction();
            Artist artist = new Artist();
            artist.setArtist_id(artist_id);
            artist.setGenre(genre);
            artist.setCountry(country);
            artist.setArtist_site_url(artist_site_url);
            session.save(artist);
            tx.commit();
            return "Entity has been created";
        }catch (Exception e){
            return e.toString();
        }
    }
}
