package com.sda.hibernate.connection;

import com.sda.hibernate.connection.configuration.HibernateConfiguration;
import com.sda.hibernate.connection.dao.PersonDao;
import com.sda.hibernate.connection.entity.Person;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();

        // CREATE
        Person person = new Person("Henry", "Haines", "HenrySHaines@dayrep.com", "United States");

        personDao.createPerson(person);

        person = personDao.getPerson(1L);

        System.out.println(person.toString());
        System.out.println("---------------------------");

        // UPDATE
        person.setCountry("Canada");
        personDao.updatePerson(person);

        person = personDao.getPerson(1L);

        System.out.println(person.toString());
        System.out.println("---------------------------");

        // DELETE
        personDao.deletePerson(person);

        // READ
        List< Person > persons = personDao.getPersons();
        for(Person p : persons){
            System.out.println(p.toString());
        }

        HibernateConfiguration.shutdown();

    }
}
