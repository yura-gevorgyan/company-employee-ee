package am.itspace.companyemployeeee.manager;

import am.itspace.companyemployeeee.db.DBConnectionProvider;
import am.itspace.companyemployeeee.model.Company;
import am.itspace.companyemployeeee.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {

    Connection connection = DBConnectionProvider.getInstance().getConnection();
    CompanyManager companyManager = new CompanyManager();

    public List<Employee> getEmployees() {
        String sql = "SELECT * FROM employee";
        List<Employee> employees = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                int companyId = resultSet.getInt("company_id");

                Company company = companyManager.getCompanyById(companyId);
                employees.add(Employee.builder()
                        .id(id)
                        .name(name)
                        .email(email)
                        .company(company)
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public void add(Employee employee) {
        String sql = "INSERT INTO employee(name,email,company_id) VALUES (?,?,?)";

        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setInt(3, employee.getCompany().getId());
            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);

                employee.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM employee WHERE id =" + id;

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteByCompany(int id) {
        String sql = "DELETE FROM employee WHERE company_id =" + id;

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Employee getById(int id) {
        String sql = "SELECT * FROM employee WHERE id =" + id;

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                int companyId = resultSet.getInt("company_id");

                Company companyById = companyManager.getCompanyById(companyId);
                return Employee.builder()
                        .id(id)
                        .name(name)
                        .email(email)
                        .company(companyById)
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Employee employee) {
        String sql = "UPDATE employee SET name = ?, email = ?, company_id = ? WHERE id =" + employee.getId();

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setInt(3, employee.getCompany().getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
