package entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name =  "grps")
public class Group extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int group_id;
    @Column(name = "group_name")
    String group_name;
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Artist.class, mappedBy = "grps")
    @JsonBackReference
    List<Artist> artists = new ArrayList<Artist>();

    public Group(String group_name) {
        this.group_name = group_name;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public Group(int group_id, String group_name) {
        this.group_id = group_id;
        this.group_name = group_name;
    }

    public Group() {
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }
}
