package am.itspace.companyemployeeee.servlet;

import am.itspace.companyemployeeee.manager.CompanyManager;
import am.itspace.companyemployeeee.manager.EmployeeManager;
import am.itspace.companyemployeeee.model.Company;
import am.itspace.companyemployeeee.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/addEmployee")
public class AddEmployee extends HttpServlet {

    private CompanyManager companyManager = new CompanyManager();
    private EmployeeManager employeeManager = new EmployeeManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Company> companies = companyManager.getCompanies();
        req.setAttribute("companies", companies);

        req.getRequestDispatcher("/WEB-INF/addEmployee.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        int companyId = Integer.parseInt(req.getParameter("companyId"));
        Company companyById = companyManager.getCompanyById(companyId);

        employeeManager.add(Employee.builder()
                .name(name)
                .email(email)
                .company(companyById)
                .build());

        resp.sendRedirect("employee");
    }
}
