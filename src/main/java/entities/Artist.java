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
@Table(name = "artists")
public class Artist extends BaseEntity implements Serializable {
    @Id
    @Column(name = "artist_id")
    int artist_id;
    @OneToOne(fetch = FetchType.EAGER, targetEntity = Person.class)
    @JoinColumn(name = "artist_id")
    @JsonManagedReference
    Person person;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Genre.class)
    @JoinColumn(name = "genre_id")
    @JsonManagedReference
    Genre genre;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Country.class)
    @JoinColumn(name = "country_id")
    Country country;
    @Column(name = "artist_site_url")
    String artist_site_url;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "artist", targetEntity = Album.class)
    @JsonBackReference
    Set<Album> albums = new HashSet<Album>();
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Group.class)
    @JoinTable(
            name = "grps_of_artists",
            joinColumns = { @JoinColumn(name = "artist_id") },
            inverseJoinColumns = { @JoinColumn(name = "group_id") }
    )
    @JsonManagedReference
    Set<Group> grps = new HashSet<>();

    public Artist(Person person, Genre genre, Country country, String artist_site_url, HashSet<Album> albums) {
        this.person = person;
        this.genre = genre;
        this.country = country;
        this.artist_site_url = artist_site_url;
        this.albums = albums;
    }

    public Artist(int artist_id, Genre genre, Country country, String artist_site_url) {
        this.genre = genre;
        this.country = country;
        this.artist_site_url = artist_site_url;
        this.artist_id = artist_id;
    }

    public Artist() {
    }

    public Artist(Person person, Genre genre, Country country, String artist_site_url, HashSet<Album> albums, HashSet<Group> groups) {
        this.person = person;
        this.genre = genre;
        this.country = country;
        this.artist_site_url = artist_site_url;
        this.albums = albums;
        this.grps = groups;
    }
    public void addToAlbums(Album album) {albums.add(album);}

    public int getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(int artist_id) {
        this.artist_id = artist_id;
    }

    public Set<Group> getGrps() {
        return grps;
    }

    public void setGrps(Set<Group> grps) {
        this.grps = grps;
    }

    public int getId() {
        return artist_id;
    }

    public void setId(int artist_id) {
        this.artist_id = artist_id;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    public Set<Group> getGroups() {
        return grps;
    }

    public void setGroups(Set<Group> groups) {
        this.grps = groups;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getArtist_site_url() {
        return artist_site_url;
    }

    public void setArtist_site_url(String artist_site_url) {
        this.artist_site_url = artist_site_url;
    }
}
