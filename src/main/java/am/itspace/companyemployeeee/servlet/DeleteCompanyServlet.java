package am.itspace.companyemployeeee.servlet;

import am.itspace.companyemployeeee.manager.CompanyManager;
import am.itspace.companyemployeeee.manager.EmployeeManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteCompany")
public class DeleteCompanyServlet extends HttpServlet {

    private CompanyManager companyManager = new CompanyManager();
    private EmployeeManager employeeManager = new EmployeeManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        employeeManager.deleteByCompany(id);
        companyManager.delete(id);
        resp.sendRedirect("/company");
    }
}
