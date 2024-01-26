package com.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/customers")
public class SQLSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String urlString = "jdbc:mysql://localhost:3306/veresiye_defteri";
		String userString = "root";
		String pasString = "";
		response.setContentType("text/html;charset=UTF-8");
		try {
			Connection cnnConnection = DriverManager.getConnection(urlString, userString, pasString);
			String queryString = "SELECT * FROM customers";
			Statement statement = cnnConnection.createStatement();
			ResultSet rsResultset = statement.executeQuery(queryString);
			String sonucString = "";
			response.getWriter()
					.print("<table border='1'><tr><th>ID</th><th>Surname</th><th>Lastname</th><th>Adress</th></tr>");

			while (rsResultset.next()) {

				response.getWriter().print("<tr>");
				response.getWriter().print("<td>" + rsResultset.getString("id") + "</td>");
				response.getWriter().print("<td>" + rsResultset.getString("first_name") + "</td>");
				response.getWriter().print("<td>" + rsResultset.getString("last_name") + "</td>");
				response.getWriter().print("<td>" + rsResultset.getString("adress") + "</td>");
				response.getWriter().print("</tr>");
			}

			response.getWriter().print("</table>");

		} catch (Exception e) {
			response.getWriter().print(e.getMessage());
		}

	}

}
