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

@WebServlet(urlPatterns = "/updateEmployee")
public class UpdateEmployeeServlet extends HttpServlet {
    private EmployeeManager employeeManager = new EmployeeManager();
    private CompanyManager companyManager = new CompanyManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        Employee employee = employeeManager.getById(id);
        List<Company> companies = companyManager.getCompanies();

        req.setAttribute("companies", companies);
        req.setAttribute("employee", employee);
        req.getRequestDispatcher("/WEB-INF/updateEmployee.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("employeeId"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        int companyId = Integer.parseInt(req.getParameter("companyId"));
        Company companyById = companyManager.getCompanyById(companyId);

        employeeManager.update(Employee.builder()
                .id(id)
                .name(name)
                .email(email)
                .company(companyById)
                .build());

        resp.sendRedirect("/employee");
    }
}
