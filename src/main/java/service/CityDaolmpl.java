package hibernate.service;

import hibernate.HibernateSessionFactoryUtil;
import hibernate.model.City;
import hibernate.model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CityDaoImpl implements CityDao{

    public City create(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            transaction.commit();
        }
        System.out.println(city);
        return city;
    }

    public City getCityById(int idCity) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            System.out.println(session.get(Employee.class, idCity));
            return session.get(City.class, idCity);
        }
    }

    public List getAllCities() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM City").list();
        }
    }

    public City updateCity(City city) {
        City updated;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            updated = (City) session.merge(city);
        }
        System.out.println(updated);
        return updated;
    }

    public void deletedCity(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
            System.out.println(city);
        }
    }
}