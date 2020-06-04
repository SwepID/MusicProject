package services;

import dao.ArtistsDao;
import entities.Artist;
import entities.Country;
import entities.Genre;
import entities.Person;

import java.util.List;

public class ArtistsService {
    ArtistsDao artistsDao = new ArtistsDao();
    public Artist findArtistById(int artist_id){
        return  artistsDao.findArtistById(artist_id);
    }
    public String deleteArtistById(int artist_id){
        return artistsDao.deleteArtistById(artist_id);
    }
    public String updateArtistCountryById(int artist_id, int country_id){
        return artistsDao.updateArtistCountryById(artist_id, country_id);
    }
    public String updateArtistSiteById(int artist_id, String artist_site_url){
        return artistsDao.updateArtistSiteById(artist_id, artist_site_url);
    }
    public String createArtist(int artist_id, Genre genre, Country country, String artist_site_url){
        return artistsDao.createArtist(artist_id, genre, country, artist_site_url);
    }
    public List<Artist> showAll(){
        return artistsDao.showAll();
    }
}
