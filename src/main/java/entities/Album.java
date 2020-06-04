package entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "albums")
public class Album extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int album_id;
    @Column(name = "album_title")
    String album_title;
    @Column(name = "album_year")
    String album_year;
    @Column(name = "album_tracks")
    int album_tracks;

    public Album(int album_id, String album_title, String album_year, int album_tracks) {
        this.album_id = album_id;
        this.album_title = album_title;
        this.album_year = album_year;
        this.album_tracks = album_tracks;
    }

    public Album(String album_title, String album_year, int album_tracks, Artist artist, HashSet<Song> songs) {
        this.album_title = album_title;
        this.album_year = album_year;
        this.album_tracks = album_tracks;
        this.artist = artist;
        this.songs = songs;
    }

    public Album() {
    }


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Artist.class)
    @JoinColumn(name = "artist_id")
    @JsonManagedReference
    Artist artist;
    @OneToMany(fetch = FetchType.EAGER, targetEntity = Song.class, mappedBy = "album")
    @JsonBackReference
    Set<Song> songs = new HashSet<>();

    public Album(int album_id, String album_title, String album_year, int album_tracks, Artist artist, HashSet<Song> songs) {
        this.album_id = album_id;
        this.album_title = album_title;
        this.album_year = album_year;
        this.album_tracks = album_tracks;
        this.artist = artist;
        this.songs = songs;
    }
    public Album(int album_id, String album_title, String album_year, int album_tracks, Artist artist) {
        this.album_id = album_id;
        this.album_title = album_title;
        this.album_year = album_year;
        this.album_tracks = album_tracks;
        this.artist = artist;
    }
    public Album(String album_title, String album_year, int album_tracks, Artist artist) {
        this.album_title = album_title;
        this.album_year = album_year;
        this.album_tracks = album_tracks;
        this.artist = artist;
    }


    public int getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

    public String getAlbum_title() {
        return album_title;
    }

    public void setAlbum_title(String album_title) {
        this.album_title = album_title;
    }

    public String getAlbum_year() {
        return album_year;
    }

    public void setAlbum_year(String album_year) {
        this.album_year = album_year;
    }

    public int getAlbum_tracks() {
        return album_tracks;
    }

    public void setAlbum_tracks(int album_tracks) {
        this.album_tracks = album_tracks;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }
}
