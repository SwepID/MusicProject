package services;

import dao.AlbumsDao;
import entities.Album;
import entities.Artist;

import java.util.Date;
import java.util.List;

public class AlbumsService {
    private AlbumsDao albumsDao = new AlbumsDao();
    public AlbumsService(){
    }
    public Album findAlbumById(int album_id){
        return  albumsDao.findAlbumById(album_id);

    }
    public Album findAlbumByName(String title){
        return  albumsDao.findAlbumByTitle(title);
    }
    public String updateAlbumTitleById(int album_id, String album_title){
        return  albumsDao.updateAlbumTitleById(album_id, album_title);
    }
    public String updateAlbumTitleByTitle(String old_title, String new_title){
        return  albumsDao.updateAlbumTitleByTitle(old_title, new_title);
    }
    public String updateAlbumYearById(int album_id, String year){
        return albumsDao.updateAlbumYearById(album_id, year);
    }
    /*public String updateAlbumArtistById(Artist artist, Album album){
        return  albumsDao.updateAlbumArtistById(album, artist);
    }*/
    public String updateAlbumTracksById(int album_id, int album_tracks){
        return  albumsDao.updateAlbumTracksById(album_id, album_tracks);
    }
    public String deleteAlbumById(int album_id){
        return albumsDao.deleteAlbumById(album_id);
    }
    public String deleteAlbumByTitle(String album_title){
        return albumsDao.deleteAlbumByTitle(album_title);
    }
    public String createAlbum(Artist artist, String album_title, String album_year, int album_tracks){
        return albumsDao.createAlbum(artist, album_title, album_year, album_tracks);
    }
    public List<Album> showAll(){
        return albumsDao.showAll();
    }

}
