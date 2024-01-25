package com.web;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/yashesapla")
public class YasHesaplaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");// T�rk�e karakter sorununu ��zmek i�in
		int dogumYili = Integer.valueOf(request.getParameter("yil"));
		int yas = 2024 - dogumYili;
		response.getWriter().append(dogumYili + " y�l�nda do�mu� oldu�unuza g�re " + yas + " ya��ndas�n�z");
	}

}
