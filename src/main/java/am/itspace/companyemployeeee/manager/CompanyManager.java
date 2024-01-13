package am.itspace.companyemployeeee.manager;

import am.itspace.companyemployeeee.db.DBConnectionProvider;
import am.itspace.companyemployeeee.model.Company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyManager {

    Connection connection = DBConnectionProvider.getInstance().getConnection();

    public List<Company> getCompanies() {
        String sql = "SELECT * FROM company";
        List<Company> companies = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");

                companies.add(Company.builder()
                        .id(id)
                        .name(name)
                        .address(address)
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companies;
    }

    public void add(Company company) {
        String sql = "INSERT INTO company(name,address) VALUES (?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, company.getName());
            ps.setString(2, company.getAddress());

            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);

                company.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM company WHERE id =" + id;

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Company getCompanyById(int companyId) {
        String sql = "SELECT * FROM company WHERE id =" + companyId;
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                Company company = Company.builder()
                        .id(companyId)
                        .name(name)
                        .address(address)
                        .build();

                return company;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
