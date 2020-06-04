package services;

import dao.CountriesDao;
import entities.Country;

import java.util.List;

public class CountriesService {
    CountriesDao countriesDao = new CountriesDao();
    public Country findCountryById(int country_id){
        return countriesDao.findCountryById(country_id);
    }
    public String deleteCountryById(int country_id){
        return countriesDao.deleteCountryById(country_id);
    }
    public String deleteCountryByName(String country_name){
        return countriesDao.deleteCountryByName(country_name);
    }
    public String updateCountryNameById(int country_id, String country_name){
        return countriesDao.updateCountryNameById(country_id, country_name);
    }
    public String createCountry(String country_name){
        return countriesDao.createCountry(country_name);
    }
    public List<Country> showAll(){
        return countriesDao.showAll();
    }
}
