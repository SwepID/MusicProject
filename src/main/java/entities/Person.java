package entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.Date;
@Entity
@Table(name = "persons")
public class Person extends  BaseEntity implements Serializable {
    public int getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(int artist_id) {
        this.artist_id = artist_id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Person(int artist_id, String last_name, String fist_name, String birthday, String sex) {
        this.artist_id = artist_id;
        this.last_name = last_name;
        this.birthday = birthday;
        this.sex = sex;
        this.fist_name = fist_name;
    }
    public Person(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int artist_id;
    @Column(name = "first_name")
    String fist_name;

    public String getFist_name() {
        return fist_name;
    }

    public void setFist_name(String fist_name) {
        this.fist_name = fist_name;
    }

    @Column(name = "last_name")
    String last_name;
    @Column(name = "birthday")
    String birthday;
    @Column(name = "sex")
    String sex;
    @OneToOne(fetch = FetchType.EAGER, targetEntity = Artist.class, mappedBy = "person")
    @JsonBackReference
    Artist artist;

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
