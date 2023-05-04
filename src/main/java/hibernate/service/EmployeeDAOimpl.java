package hibernate.service;

import hibernate.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import hibernate.model.Employee;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    public Integer createEmployee(Employee employee) {
        Integer id;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            id = (Integer) session.save(employee);
            transaction.commit();
        }
        System.out.println(employee);
        return id;
    }

    public Employee getEmployeeById(int idEmployee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            System.out.println(session.get(Employee.class, idEmployee));
            return session.get(Employee.class, idEmployee);
        }
    }

    public List getAllEmployees() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Employee").list();
        }
    }

    public void updateEmployee(Employee employee, int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employee.setId(id);
            session.update(employee);
            transaction.commit();
            System.out.println(employee);
        }
    }

    public void deleteEmployee(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
            System.out.println(employee);
        }
    }
}
