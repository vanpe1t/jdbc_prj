import dao.EmployeeDAO;
import dao.impl.EmployeeDAOImpl;
import model.Employee;

import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        final String user = "postgres";
        final String password = "g@vgth0";
        final String url = "jdbc:postgresql://localhost:5432/skypro";


        EmployeeDAO employeeDAO;
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            employeeDAO = new EmployeeDAOImpl(connection);
            System.out.println(employeeDAO.readById(41));

            Employee employeeForAge = employeeDAO.readById(41);
            employeeForAge.setAge(35);
            employeeDAO.updateById(employeeForAge);
            employeeDAO.deleteById(45);
            employeeDAO.readAll().forEach(System.out::println);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }
}
