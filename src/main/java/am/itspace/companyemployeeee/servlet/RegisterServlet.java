package am.itspace.companyemployeeee.servlet;

import am.itspace.companyemployeeee.manager.UserManager;
import am.itspace.companyemployeeee.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    UserManager userManager = new UserManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");

        User userByEmail = userManager.getByEmail(email);

        if (userByEmail == null) {
            String name = req.getParameter("name");
            String surname = req.getParameter("surname");
            String password = req.getParameter("password");

            User user = User.builder()
                    .name(name)
                    .surname(surname)
                    .email(email)
                    .password(password)
                    .build();

            userManager.add(user);

            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/home");
        } else {
            req.getSession().setAttribute("msg", "With This Email have already registered");
            resp.sendRedirect("/");
        }
    }
}
