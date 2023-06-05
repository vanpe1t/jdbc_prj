import dao.EmployeeDAO;
import dao.impl.EmployeeDAOImpl;
import model.Employee;

import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) {


        EmployeeDAO employeeDAO =  new EmployeeDAOImpl();
        employeeDAO = new EmployeeDAOImpl();
        System.out.println(employeeDAO.readById(41));

        Employee employeeNew = new Employee("Новый", "Новиков", "mail", 46);
        employeeDAO.create(employeeNew);

        Employee employeeForAge = employeeDAO.readById(41);
        employeeForAge.setAge(55);
        employeeDAO.updateById(employeeForAge);
        employeeDAO.deleteById(51);
        employeeDAO.readAll().forEach(System.out::println);

    }
}
