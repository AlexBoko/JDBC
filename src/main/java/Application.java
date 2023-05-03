package hibernate;

import hibernate.model.City;
import hibernate.model.Employee;
import hibernate.service.CityDaoImpl;
import hibernate.service.CityDao;
import hibernate.service.EmployeeDAOImpl;
import hibernate.service.EmployeeDAO;
import javax.transaction.Transactional;
import java.sql.*;
import java.util.List;
@Transactional

public class Application {
    public static void main(String[] args) throws SQLException {
        final String user = "postgres";
        final String password = "Wertyrwer";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employee " +
                             "INNER JOIN city ON employee.city_id = city.city_id WHERE id = (2)")) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                String city_name = resultSet.getString("city_name");
                System.out.println("Имя: " + first_name);
                System.out.println("Фамилия: " + last_name);
                System.out.println("Пол: " + gender);
                System.out.println("Возраст: " + age);
                System.out.println("Город проживания: " + city_name);
            }
        }catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }
        System.out.println("=========+++++++++=========");
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        employeeDAO.createEmployee(new Employee(1, "Петров", "Александр", "м", 35, new City(1, "")));
        employeeDAO.updateEmployee(5, new Employee(5, "Сергей", "Смирнов", "м", 23, new City(2, "")));
        employeeDAO.deleteEmployee(1);
        employeeDAO.getAllEmployees();
        System.out.println("=========+++++++++=========");
        employeeDAO.getEmployeeById(4);
        employeeDAO = new EmployeeDAOImpl();
        employeeDAO.createEmployee(new Employee(1, "Александр", "Петров", "м", 35, 1));
        employeeDAO.updateEmployee(new Employee(4, "Сергей", "Смирнов", "м", 23, 1), 4);
        employeeDAO.deleteEmployee(new Employee(16, "Александр", "Петров", "м", 35, 2));
        employeeDAO.getAllEmployees().forEach(System.out::println);
        CityDao cityDao = new CityDaoImpl();
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
//        employeeDAO.createEmployee(new Employee(1, "Александр", "Петров", "м", 35, City.builder().city_name("Харьков").employees(List.of()).build()));
//        employeeDAO.updateEmployee(new Employee(4, "Сергей", "Смирнов", "м", 23, new City(1, "Самара", List.of()) ), 4);
//        employeeDAO.deleteEmployee(new Employee(18, "Александр", "Петров", "м", 35, new City(1, "Самара", List.of())));
//        employeeDAO.getAllEmployees();
        System.out.println("=========+++++++++=========");
        //       employeeDAO.getEmployeeById(4);
        City city = new City(6, "Самара", List.of());
        cityDao.create(city);
        Employee employee1 = Employee.builder().first_name("Стив").last_name("Смит").gender("м").city(city).age(38).build();
        Employee employee2 = Employee.builder().first_name("Дональд").last_name("Парк").gender("м").city(city).age(46).build();
        city.setEmployees(List.of(employee1, employee2));
        cityDao.updateCity(new City(12, "Канада", List.of()));
        cityDao.deletedCity(new City(13, "Канада", List.of()));
        cityDao.getAllCities();
        System.out.println("=========+++++++++=========");
        cityDao.getCityById(5);
        System.out.println(cityDao.getAllCities());


    }
}