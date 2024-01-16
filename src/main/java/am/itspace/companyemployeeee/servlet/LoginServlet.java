package am.itspace.companyemployeeee.servlet;

import am.itspace.companyemployeeee.manager.UserManager;
import am.itspace.companyemployeeee.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private UserManager userManager = new UserManager();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = userManager.getByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/home");
        } else {
            req.getSession().setAttribute("msg", "Invalid E-Mail or PASSWORD !!");
            resp.sendRedirect("/");
        }
    }
}
