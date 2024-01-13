package am.itspace.companyemployeeee.servlet;

import am.itspace.companyemployeeee.manager.EmployeeManager;
import am.itspace.companyemployeeee.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {

    private EmployeeManager employeeManager = new EmployeeManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> employees = employeeManager.getEmployees();

        req.setAttribute("employees", employees);
        req.getRequestDispatcher("/WEB-INF/employee.jsp").forward(req, resp);
    }
}
