package services;

import dao.PersonsDao;
import entities.Person;

import java.util.List;

public class PersonsService {
    PersonsDao personsDao = new PersonsDao();
    public Person findPersonById(int artist_id){
        return personsDao.findPersonById(artist_id);
    }
    public List<Person> findPersonByName(String first_name){
        return personsDao.findPersonsByName(first_name);
    }
    public List<Person> showAll(){
        return personsDao.showAll();
    }
    public String updatePersonNameById(int artist_id, String first_name){
        return personsDao.updatePersonNameById(artist_id, first_name);
    }
    public String updatePersonLastNameById(int artist_id, String last_name){
        return personsDao.updatePersonLastNameById(artist_id, last_name);
    }
    public String updatePersonBirthDayById(int artist_id, String birthday){
        return personsDao.updatePersonBirthdayById(artist_id, birthday);
    }
    public String updatePersonSexById(int artist_id, String sex){
        return personsDao.updatePersonSexById(artist_id, sex);
    }
    public String deletePersonById(int artist_id){
        return personsDao.deletePersonById(artist_id);
    }
    public String createPerson(String last_name, String first_name, String birthday, String sex){
        return personsDao.createPerson(last_name, first_name, birthday, sex);
    }
}
