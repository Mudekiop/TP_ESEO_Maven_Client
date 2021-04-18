package com.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.beans.Ville;
import com.google.gson.Gson;

/**
 * Servlet implementation class InfoPourVilleController
 */
@WebServlet("/InfoPourVilleController")
public class InfoPourVilleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InfoPourVilleController() {
		super();
	}

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp = 0;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd).replace("[", "").replace("]", "");
			JSONObject object = new JSONObject(jsonText);
			return object;
		} finally {
			is.close();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String insee = (String) request.getParameter("insee");
		JSONObject json = null;
		try {
			json = readJsonFromUrl("http://localhost:8181/ville?codeInsee=" + insee);
		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}
		Ville ville = new Gson().fromJson(json.toString(), Ville.class);
		request.setAttribute("ville", ville);
		this.getServletContext().getRequestDispatcher("/WEB-INF/infoVille.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
