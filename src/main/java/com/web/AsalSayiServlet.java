package com.web;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/asalsayi")
public class AsalSayiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		int sayi = Integer.valueOf(request.getParameter("sayi"));
		String sonucString = null;
		if (asalMi(sayi)) {
			sonucString = "Girmiþ olduðunuz " + sayi + " sayýsý, ASAL sayýdýr";
		} else {
			sonucString = "Girmiþ olduðunuz " + sayi + " sayýsý, ASAL sayý deðildir";
		}

		response.getWriter().print(sonucString);
	}

	public boolean asalMi(int sayi) {
		boolean durum = true;
		for (int i = 2; i < sayi; i++) {
			if (sayi % i == 0) {
				durum = false;
			}
		}
		return durum;
	}

}
