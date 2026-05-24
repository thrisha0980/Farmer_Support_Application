package com.farmersupport.app.web;

import com.farmersupport.app.dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = new UserDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean isValid = userDao.validate(username, password);

        if (isValid) {
            // Store username in session (you can also store full user later)
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            response.sendRedirect("view/dashboard.jsp");  // change path if needed
        } else {
            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("view/login.jsp").forward(request, response);
        }
    }
}


