package Serlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.userDAO;
import model.user;

@WebServlet({ "/UserList" })
public class userServlet extends HttpServlet {
	userDAO dao;
	user user;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		req.getRequestDispatcher("UserList.jsp").forward(req, resp);
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		userDAO dao;
		user user;
		dao = new userDAO();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		user = new user();
		if (username.equals("")) {
			req.setAttribute("username", "This field cannot be left blank");

		}
		if (password.equals("")) {
			
			req.setAttribute("password", "This field cannot be left blank ");

		}
		if (!username.isEmpty() && !password.isEmpty()) {
			dao= new userDAO();
			user = new user();
			user.setUsername(username);
			user.setPassword(password);
			try {
				dao.add(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				req.setAttribute("list", dao.getAllUser());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.getRequestDispatcher("UserList.jsp").forward(req, resp);
		}
		req.getRequestDispatcher("index.jsp").forward(req, resp);
		
	}
}
