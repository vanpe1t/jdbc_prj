import dao.CityDAO;
import dao.EmployeeDAO;
import dao.impl.CityDAOImpl;
import dao.impl.EmployeeDAOImpl;
import model.City;
import model.Employee;

import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        EmployeeDAO employeeDAO =  new EmployeeDAOImpl();
        CityDAO cityDAO = new CityDAOImpl();

        City city = new City("Vologda");
        Employee employee = new Employee("Tets", "Test", "maile", 30, city);

        employeeDAO.create(employee);
//
//       System.out.println(employeeDAO.readById(26));
//
//        //Employee employeeNew = new Employee("Новый", "Новиков", "mail", 46);
//        //employeeDAO.create(employeeNew);
//
//        //Employee employeeForAge = employeeDAO.readById(41);
////        if (employeeForAge != null) {
////            employeeForAge.setAge(55);
////            employeeDAO.updateById(employeeForAge);
////        }
////        employeeDAO.deleteById(51);
//
//        employeeDAO.readAll().forEach(System.out::println);
//
//        cityDAO.readAll().forEach(System.out::println);
//        cityDAO.deleteById(1);
//        cityDAO.readAll().forEach(System.out::println);
//        employeeDAO.readAll().forEach(System.out::println);

    }
}
