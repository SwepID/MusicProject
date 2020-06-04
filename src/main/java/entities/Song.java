package entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "songs")
public class Song extends BaseEntity implements Serializable {
    public int getSong_id() {
        return song_id;
    }

    public void setSong_id(int song_id) {
        this.song_id = song_id;
    }

    public String getSong_title() {
        return song_title;
    }

    public void setSong_title(String song_title) {
        this.song_title = song_title;
    }

    public Song() {
    }

    public Song(int song_id, String song_title) {
        this.song_id = song_id;
        this.song_title = song_title;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Song(int song_id, String song_title, Album album) {
        this.song_id = song_id;
        this.song_title = song_title;
        this.album = album;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int song_id;
    @Column(name = "song_title")
    String song_title;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Album.class)
    @JoinColumn(name = "album_id")
    @JsonManagedReference
    Album album;
}
