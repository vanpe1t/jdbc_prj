package dao.impl;

import model.Employee;
import dao.EmployeeDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    //private final Connection connection;

    public EmployeeDAOImpl() {}

    @Override
    public void create(Employee employee) {

        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }

    }

    @Override
    public Employee readById(int id) {
        Employee employee;
        employee = HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Employee.class, id);
        return employee;
    }

    @Override
    public List<Employee> readAll() {

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        List<Employee> employees = (List<Employee>) session.createQuery("From Employee").list();

        session.close();

        return employees;
    }

    @Override
    public void updateById(Employee employee) {

        if (employee == null) {
            return;
        }
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

            session.update(employee);
            transaction.commit();
        }

    }

    @Override
    public void deleteById(int id) {

        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Employee result = session.get(Employee.class, id);
            if (result != null) {
                session.delete(session.get(Employee.class, id));
                transaction.commit();
            }
        }

    }
}
