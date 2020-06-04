package services;

import dao.GenresDao;
import entities.Genre;

import java.util.List;

public class GenresService {
    private GenresDao genresDao = new GenresDao();

    public Genre getGenreById(int genre_id){
        return  genresDao.findById(genre_id);
    }
    public Genre getGenreByName(String genre_name){
        return genresDao.findByName(genre_name);
    }
    public String updateGenreNameById(String genre_name, int genre_id){
        return genresDao.updateGenreNameById(genre_name, genre_id);
    }
    public String updateGenreNameByName(String old_genre_name, String new_genre_name){
        return  genresDao.updateGenreNameByName(old_genre_name, new_genre_name);
    }
    public String deleteGenreById(int genre_id){
        return genresDao.deleteGenreById(genre_id);
    }
    public String deleteGenreByName(String genre_name){
        return genresDao.deleteGenreByName(genre_name);
    }
    public String createGenre(String genre_name){
        return genresDao.createGenre(genre_name);
    }
    public List<Genre> showAll(){
        return genresDao.showAll();
    }
}
