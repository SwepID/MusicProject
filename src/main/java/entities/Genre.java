package entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name =  "genres")
public class Genre extends BaseEntity implements Serializable {
    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int genre_id;

    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }

    @Column(name = "genre_name")
    private String genre_name;

    public Set<Artist> getArtists() {
        return artists;
    }

    public void setArtists(Set<Artist> artists) {
        this.artists = artists;
    }

    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Artist> artists = new HashSet<>();

    public Genre(int genre_id, String genre_name) {
        this.genre_id = genre_id;
        this.genre_name = genre_name;
    }

    public Genre(String genre_name) {
        this.genre_name = genre_name;
    }

    public Genre() {
    }
}
