package com.sda.hibernateconnection.dao;

import com.sda.hibernateconnection.connection.HibernateConfiguration;
import com.sda.hibernateconnection.entity.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PersonDao {
    public void createPerson(Person person) {
        Transaction transaction = null;
        try {
            Session session = HibernateConfiguration.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // save the person object
            session.save(person);
            // commit transaction
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void updatePerson(Person person) {
        Transaction transaction = null;
        try {
            Session session = HibernateConfiguration.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // save the person object
            session.update(person);
            // commit transaction
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void deletePerson(Person person) {
        Transaction transaction = null;
        try {
            Session session = HibernateConfiguration.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // save the person object
            session.delete(person);
            // commit transaction
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public Person getPerson(Long id) {
        try {
            Session session = HibernateConfiguration.getSessionFactory().openSession();
            return session.find(Person.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<Person> getPersons() {
        try {
            Session session = HibernateConfiguration.getSessionFactory().openSession();
            return session.createQuery("from Person", Person.class).list();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
