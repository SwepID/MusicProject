package entities;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "countries")
public class Country extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int country_id;
    @Column(name = "country_name")
    String country_name;
    @OneToMany(fetch = FetchType.EAGER, targetEntity = Artist.class, mappedBy = "country")
    List<Artist> artists = new ArrayList<Artist>();

    public Country(String country_name) {
        this.country_name = country_name;
    }

    public Country(int country_id, String country_name) {
        this.country_id = country_id;
        this.country_name = country_name;
    }

    public Country() {
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }
}
