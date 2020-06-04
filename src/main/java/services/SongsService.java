package services;

import dao.SongsDao;
import entities.Album;
import entities.Song;

import java.util.List;

public class SongsService {
    SongsDao songsDao = new SongsDao();
    public Song findSongById(int song_id){
        return songsDao.findSongById(song_id);
    }
    public Song findSongByTitle(String title){
        return songsDao.findSongByTitle(title);
    }
    public List<Song> showAll(){
        return songsDao.showAll();
    }
    public String updateSongTitleById(int song_id, String song_title){
        return songsDao.updateSongTitleById(song_id, song_title);
    }
    public String createSong(String song_title, Album album){
        return songsDao.createSong(song_title, album);
    }
    public String deleteSongById(int song_id){
        return songsDao.deleteSongById(song_id);
    }
}
