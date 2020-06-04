import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import entities.*;
import org.hibernate.Criteria;
import services.*;

import java.io.StringWriter;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(final String[] args) throws Exception {
        UsersService usersService = new UsersService();
        int loggingChoice;
        boolean isLogging = false;
        String login;
        String password;
        Scanner in = new Scanner(System.in);
        while (!isLogging){
            System.out.println("1. Registration");
            System.out.println("2. Authorization");
            System.out.println("3. Exit");
            try {
                loggingChoice = in.nextInt();
                switch (loggingChoice){
                    case 1:
                        System.out.print("Enter login = ");
                        in.nextLine();
                        login = in.nextLine();
                        System.out.print("Enter password = ");
                        password = in.nextLine();
                        System.out.println(usersService.Registration(login, password));
                        break;
                    case 2:
                        System.out.print("Enter login = ");
                        in.nextLine();
                        login = in.nextLine();
                        System.out.print("Enter password = ");
                        password = in.nextLine();
                        if (usersService.Authorization(login, password)){
                            System.out.println("Authorization successful");
                            isLogging = true;
                        }
                        else {
                            System.out.println("Authorization failed");
                        }
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Wrong number");
                        break;
                }
            }
            catch (Exception exception){

            }
        }
        AlbumsService albumsService = new AlbumsService();
        GenresService genresService = new GenresService();
        ArtistsService artistsService = new ArtistsService();
        SongsService songsService = new SongsService();
        CountriesService countriesService = new CountriesService();
        PersonsService personsService = new PersonsService();
        GroupsService groupsService = new GroupsService();
        Boolean isRunning = true;
        int choice = 0;
        int choice2 = 0;
        int album_id;
        String year;
        int artist_id;
        String album_title;
        int album_tracks;
        int country_id;
        String artist_site_url;
        String country_name;
        int genre_id;
        String genre_name;
        int group_id;
        String group_name;
        int person_id;
        String first_name;
        String last_name;
        String birthday;
        String sex;
        int song_id;
        String song_title;
        while (isRunning) {
            System.out.println("Select number");
            System.out.println("1. Album");
            System.out.println("2. Artist");
            System.out.println("3. Country");
            System.out.println("4. Genre");
            System.out.println("5. Group");
            System.out.println("6. Person");
            System.out.println("7. Song");
            System.out.println("8. Exit");
            try {
                choice = in.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Select number");
                        System.out.println("1. Find album by id");
                        System.out.println("2. Find album by title");
                        System.out.println("3. Update album title by id");
                        System.out.println("4. Update album title by title");
                        System.out.println("5. Update album year by id");
                        System.out.println("6. Update album tracks by id");
                        System.out.println("7. Delete album by id");
                        System.out.println("8. Delete album by title");
                        System.out.println("9. Create album");
                        System.out.println("10. Show all");
                        System.out.println("11. Exit to main menu");
                        try {
                            choice2 = in.nextInt();
                        } catch (Exception exception2) {

                        }
                        switch (choice2) {
                            case 1:
                                System.out.print("Enter album id = ");
                                album_id = in.nextInt();
                                System.out.println(albumsService.findAlbumById(album_id).toString());
                                break;
                            case 2:
                                System.out.print("Enter album title = ");
                                album_title = in.nextLine();
                                System.out.println(albumsService.findAlbumByName(album_title).toString());
                                break;
                            case 3:
                                System.out.print("Enter album id = ");
                                album_id = in.nextInt();
                                System.out.print("Enter new album title = ");
                                in.nextLine();
                                album_title = in.nextLine();
                                System.out.println(albumsService.updateAlbumTitleById(album_id, album_title));
                                break;
                            case 4:
                                System.out.print("Enter old album title = ");
                                album_title = in.nextLine();
                                in.nextLine();
                                System.out.print("Enter new album title = ");
                                String new_album_title = in.nextLine();
                                System.out.println(albumsService.updateAlbumTitleByTitle(album_title, new_album_title));
                                break;
                            case 5:
                                System.out.print("Enter album id = ");
                                album_id = in.nextInt();
                                System.out.print("Enter album year in format yy-mm-dd = ");
                                in.nextLine();
                                year = in.nextLine();
                                System.out.println(albumsService.updateAlbumYearById(album_id, year));
                                break;
                            case 6:
                                System.out.print("Enter album id = ");
                                album_id = in.nextInt();
                                System.out.print("Enter album tracks = ");
                                int amount = in.nextInt();
                                System.out.println(albumsService.updateAlbumTracksById(album_id, amount));
                                break;
                            case 7:
                                System.out.print("Enter album id = ");
                                in.nextLine();
                                System.out.println(albumsService.deleteAlbumById(in.nextInt()));
                                break;
                            case 8:
                                System.out.print("Enter album_title = ");
                                in.nextLine();
                                System.out.println(albumsService.deleteAlbumByTitle(in.nextLine()));
                                break;
                            case 9:
                                System.out.print("Enter artist id = ");
                                Artist artist = artistsService.findArtistById(in.nextInt());
                                System.out.print("Enter album title = ");
                                in.nextLine();
                                album_title = in.nextLine();
                                System.out.print("Enter album year in format yy-mm-dd = ");
                                year = in.nextLine();
                                System.out.print("Enter album tracks = ");
                                album_tracks = in.nextInt();
                                System.out.println(albumsService.createAlbum(artist, album_title, year, album_tracks));
                                break;
                            case 10:
                                for (Album album : albumsService.showAll()){
                                    System.out.println(album.toString());
                                }
                                break;
                            case 11:

                                break;
                            default:
                                System.out.println("Wrong number");
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("1. Find artist by id");
                        System.out.println("2. Delete artist by id");
                        System.out.println("3. Update artist counrty by id");
                        System.out.println("4. Update artist site url by id");
                        System.out.println("5. Create artist");
                        System.out.println("6. Show all");
                        System.out.println("7. Exit to main menu");
                        try {
                            choice2 = in.nextInt();
                        } catch (Exception exception2) {

                        }
                        switch (choice2){
                            case 1:
                                System.out.print("Enter artist id = ");
                                artist_id = in.nextInt();
                                System.out.println(artistsService.findArtistById(artist_id));
                                break;
                            case 2:
                                System.out.print("Enter artist id = ");
                                artist_id = in.nextInt();
                                System.out.println(artistsService.deleteArtistById(artist_id));
                                break;
                            case 3:
                                System.out.print("Enter artist_id = ");
                                artist_id = in.nextInt();
                                System.out.print("Enter country id = ");
                                country_id = in.nextInt();
                                System.out.println(artistsService.updateArtistCountryById(artist_id, country_id));
                                break;
                            case 4:
                                System.out.print("Enter artist id = ");
                                artist_id = in.nextInt();
                                System.out.print("Enter artist site url = ");
                                in.nextLine();
                                artist_site_url = in.nextLine();
                                System.out.println(artistsService.updateArtistSiteById(artist_id, artist_site_url));
                                break;
                            case 5:
                                System.out.print("Enter artist id = ");
                                artist_id = in.nextInt();
                                System.out.print("Enter genre id = ");
                                Genre genre = genresService.getGenreById(in.nextInt());
                                System.out.print("Enter country id = ");
                                Country country = countriesService.findCountryById(in.nextInt());
                                System.out.print("Enter artist site url = ");
                                in.nextLine();
                                artist_site_url = in.nextLine();
                                System.out.println(artistsService.createArtist(artist_id, genre, country, artist_site_url));
                                break;
                            case 6:
                                for (Artist artist : artistsService.showAll()){
                                    System.out.println(artist.toString());
                                }
                                break;
                            case  7:

                                break;
                            default:
                                System.out.println("Wrong number");
                        }
                        break;
                    case 3:
                        System.out.println("1. Find country by id");
                        System.out.println("2. Show All");
                        System.out.println("3. Create country");
                        System.out.println("4. Update country name by id");
                        System.out.println("5. Delete country by id");
                        System.out.println("6. Delete country by name");
                        System.out.println("7. Exit to main menu");
                        try {
                            choice2 = in.nextInt();
                        } catch (Exception exception2) {

                        }
                        switch (choice2){
                            case 1:
                                System.out.print("Enter country id = ");
                                System.out.println(countriesService.findCountryById(in.nextInt()));
                                break;
                            case 2:
                                for (Country country : countriesService.showAll()){
                                    System.out.println(country);
                                }
                                break;
                            case 3:
                                System.out.print("Enter country name = ");
                                in.nextLine();
                                System.out.println(countriesService.createCountry(in.nextLine()));
                                break;
                            case 4:
                                System.out.print("Enter country id = ");
                                country_id = in.nextInt();
                                System.out.print("Enter country name = ");
                                in.nextLine();
                                country_name = in.nextLine();
                                System.out.println(countriesService.updateCountryNameById(country_id, country_name));
                                break;
                            case 5:
                                System.out.print("Enter country id = ");
                                country_id = in.nextInt();
                                System.out.println(countriesService.deleteCountryById(country_id));
                                break;
                            case 6:
                                System.out.print("Enter country name = ");
                                in.nextLine();
                                country_name = in.nextLine();
                                System.out.println(countriesService.deleteCountryByName(country_name));
                                break;
                            case 7:

                                break;
                            default:
                                System.out.println("Wrong number");
                                break;
                        }
                        break;
                    case 4:
                        System.out.println("1. Find genre by id");
                        System.out.println("2. Find genre by name");
                        System.out.println("3. Show all");
                        System.out.println("4. Update genre name by id");
                        System.out.println("5. Update genre name by name");
                        System.out.println("6. Delete genre by id");
                        System.out.println("7. Delete genre by name");
                        System.out.println("8. Create genre");
                        System.out.println("9. Exit to main menu");
                        try {
                            choice2 = in.nextInt();
                        } catch (Exception exception2) {

                        }
                        switch (choice2){
                            case 1:
                                System.out.print("Enter genre id = ");
                                genre_id = in.nextInt();
                                System.out.println(genresService.getGenreById(genre_id));
                                break;
                            case 2:
                                System.out.print("Enter genre name = ");
                                in.nextLine();
                                genre_name = in.nextLine();
                                System.out.println(genresService.getGenreByName(genre_name));
                                break;
                            case 3:
                                for (Genre genre : genresService.showAll()){
                                    System.out.println(genre);
                                }
                                break;
                            case 4:
                                System.out.print("Enter genre id = ");
                                genre_id = in.nextInt();
                                System.out.print("Enter genre name = ");
                                in.nextLine();
                                genre_name = in.nextLine();
                                System.out.println(genresService.updateGenreNameById(genre_name, genre_id));
                                break;
                            case 5:
                                System.out.print("Enter old genre name = ");
                                in.nextLine();
                                genre_name = in.nextLine();
                                System.out.print("Enter new genre name = ");
                                String new_genre_name = in.nextLine();
                                System.out.println(genresService.updateGenreNameByName(genre_name, new_genre_name));
                                break;
                            case 6:
                                System.out.print("Enter genre id = ");
                                genre_id = in.nextInt();
                                System.out.println(genresService.deleteGenreById(genre_id));
                                break;
                            case 7:
                                System.out.print("Enter genre name = ");
                                in.nextLine();
                                genre_name = in.nextLine();
                                System.out.println(genresService.deleteGenreByName(genre_name));
                                break;
                            case 8:
                                System.out.print("Enter genre name = ");
                                in.nextLine();
                                genre_name = in.nextLine();
                                System.out.println(genresService.createGenre(genre_name));
                                break;
                            case 9:

                                break;
                            default:
                                System.out.println("Wrong number");
                                break;
                        }
                        break;
                    case 5:
                        System.out.println("1. Find group by id");
                        System.out.println("2. Find group by name");
                        System.out.println("3. Show all");
                        System.out.println("4. Update group name by id");
                        System.out.println("5. Update group name by name");
                        System.out.println("6. Delete group by id");
                        System.out.println("7. Delete group by name");
                        System.out.println("8. Create group");
                        System.out.println("9. Exit to main menu");
                        try {
                            choice2 = in.nextInt();
                        } catch (Exception exception2) {

                        }
                        switch (choice2){
                            case 1:
                                System.out.print("Enter group id = ");
                                group_id = in.nextInt();
                                System.out.println(groupsService.findGroupById(group_id));
                                break;
                            case 2:
                                System.out.print("Enter group name = ");
                                in.nextLine();
                                group_name = in.nextLine();
                                System.out.println(groupsService.findGroupByName(group_name));
                                break;
                            case 3:
                                for (Group group : groupsService.showAll()){
                                    System.out.println(group);
                                }
                                break;
                            case 4:
                                System.out.print("Enter group id = ");
                                group_id = in.nextInt();
                                System.out.print("Enter group name = ");
                                in.nextLine();
                                group_name = in.nextLine();
                                System.out.println(groupsService.updateGroupNameById(group_id, group_name));
                                break;
                            case 5:
                                System.out.print("Enter old group name = ");
                                in.nextLine();
                                group_name = in.nextLine();
                                System.out.print("Enter new group name = ");
                                String new_group_name = in.nextLine();
                                System.out.println(groupsService.updateGroupNameByName(group_name, new_group_name));
                                break;
                            case 6:
                                System.out.print("Enter group id = ");
                                group_id = in.nextInt();
                                System.out.println(groupsService.deleteGroupById(group_id));
                                break;
                            case 7:
                                System.out.print("Enter group name = ");
                                in.nextLine();
                                group_name = in.nextLine();
                                System.out.println(groupsService.deleteGroupByName(group_name));
                                break;
                            case 8:
                                System.out.print("Enter group name = ");
                                in.nextLine();
                                group_name = in.nextLine();
                                System.out.println(groupsService.createGroup(group_name));
                                break;
                            case 9:

                                break;
                            default:
                                System.out.println("Wrong number");
                                break;
                        }
                        break;
                    case 6:
                        System.out.println("1. Find person by id");
                        System.out.println("2. Find persons by name");
                        System.out.println("3. Show all");
                        System.out.println("4. Update person first name");
                        System.out.println("5. Update person last name");
                        System.out.println("6. Update person birthday");
                        System.out.println("7. Update person sex");
                        System.out.println("8. Delete person by id");
                        System.out.println("9. Create person");
                        System.out.println("10. Exit to main menu");
                        try {
                            choice2 = in.nextInt();
                        } catch (Exception exception2) {

                        }
                        switch (choice2){
                            case 1:
                                System.out.print("Enter person id = ");
                                person_id = in.nextInt();
                                System.out.println(personsService.findPersonById(person_id));
                                break;
                            case 2:
                                System.out.print("Enter first name = ");
                                in.nextLine();
                                first_name = in.nextLine();
                                for (Person person : personsService.findPersonByName(first_name)){
                                    System.out.println(person);
                                }
                                break;
                            case 3:
                                for (Person person : personsService.showAll()){
                                    System.out.println(person);
                                }
                                break;
                            case 4:
                                System.out.print("Enter person id = ");
                                person_id = in.nextInt();
                                System.out.print("Enter first name = ");
                                in.nextLine();
                                first_name = in.nextLine();
                                System.out.println(personsService.updatePersonNameById(person_id, first_name));
                                break;
                            case 5:
                                System.out.print("Enter person id = ");
                                person_id = in.nextInt();
                                System.out.print("Enter last name = ");
                                in.nextLine();
                                last_name = in.nextLine();
                                System.out.println(personsService.updatePersonLastNameById(person_id, last_name));
                                break;
                            case 6:
                                System.out.print("Enter person id = ");
                                person_id = in.nextInt();
                                System.out.print("Enter birthday in format yy-mm-dd = ");
                                in.nextLine();
                                birthday = in.nextLine();
                                System.out.println(personsService.updatePersonBirthDayById(person_id, birthday));
                                break;
                            case 7:
                                System.out.print("Enter person id = ");
                                person_id = in.nextInt();
                                System.out.print("Enter sex (male or female) = ");
                                in.nextLine();
                                sex = in.nextLine();
                                System.out.println(personsService.updatePersonSexById(person_id, sex));
                                break;
                            case 8:
                                System.out.print("Enter person id = ");
                                person_id = in.nextInt();
                                System.out.println(personsService.deletePersonById(person_id));
                                break;
                            case 9:
                                System.out.print("Enter first name = ");
                                in.nextLine();
                                first_name = in.nextLine();
                                System.out.print("Enter last name = ");
                                last_name = in.nextLine();
                                System.out.print("Enter birthday in format yy-mm-dd = ");
                                birthday = in.nextLine();
                                System.out.print("Enter sex (male or female) = ");
                                sex = in.nextLine();
                                System.out.println(personsService.createPerson(last_name, first_name, birthday, sex));
                                break;
                            case 10:

                                break;
                            default:
                                System.out.println("Wrong number");
                                break;
                        }
                        break;
                    case 7:
                        System.out.println("1. Find song by id");
                        System.out.println("2. Find song by title");
                        System.out.println("3. Show all");
                        System.out.println("4. Update song title");
                        System.out.println("5. Delete song by id");
                        System.out.println("6. Create song");
                        System.out.println("7. Exit to main menu");
                        try {
                            choice2 = in.nextInt();
                        } catch (Exception exception2) {

                        }
                        switch (choice2){
                            case 1:
                                System.out.print("Enter song id = ");
                                song_id = in.nextInt();
                                System.out.println(songsService.findSongById(song_id));
                                break;
                            case 2:
                                System.out.print("Enter song title = ");
                                in.nextLine();
                                song_title = in.nextLine();
                                System.out.println(songsService.findSongByTitle(song_title));
                                break;
                            case 3:
                                for (Song song : songsService.showAll()){
                                    System.out.println(song);
                                }
                                break;
                            case 4:
                                System.out.println("Enter song id = ");
                                song_id = in.nextInt();
                                System.out.print("Enter song title = ");
                                in.nextLine();
                                song_title = in.nextLine();
                                System.out.println(songsService.updateSongTitleById(song_id, song_title));
                                break;
                            case 5:
                                System.out.print("Enter song id = ");
                                song_id = in.nextInt();
                                System.out.println(songsService.deleteSongById(song_id));
                                break;
                            case 6:
                                System.out.print("Enter song title = ");
                                in.nextLine();
                                song_title = in.nextLine();
                                System.out.print("Enter album id = ");
                                album_id = in.nextInt();
                                Album album = albumsService.findAlbumById(album_id);
                                System.out.println(songsService.createSong(song_title, album));
                                break;
                            case 7:

                                break;
                            default:
                                System.out.println("Wrong number");
                                break;
                        }
                        break;
                    case 8:
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Wrong number");
                        break;
                }
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}