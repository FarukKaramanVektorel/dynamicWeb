package com.web;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/calculate")
public class CalculateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		int sayi1 = Integer.valueOf(request.getParameter("sayi1"));
		int sayi2 = Integer.valueOf(request.getParameter("sayi2"));
		String islem = request.getParameter("islem");
		String sonucString = null;

		switch (islem) {
		case "toplama": {
			sonucString = "Sonuç: " + (sayi1 + sayi2);
			break;
		}
		case "cikarma": {
			sonucString = "Sonuç: " + (sayi1 - sayi2);
			break;
		}
		case "carpma": {
			sonucString = "Sonuç: " + (sayi1 * sayi2);
			break;
		}
		case "bolme": {
			sonucString = "Sonuç: " + (sayi1 / sayi2);
			break;
		}
		default:
			sonucString = "Hatalý iþlem";
		}
		response.getWriter().print(sonucString);
	}

}
