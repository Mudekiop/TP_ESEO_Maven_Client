package com.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.beans.Ville;
import com.google.gson.Gson;

/**
 * Servlet implementation class VilleController
 */
@WebServlet("/VilleInfoController")
public class VilleInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VilleInfoController() {
		super();
	}

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONArray readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONArray jarray = new JSONArray(jsonText);
			return jarray;
		} finally {
			is.close();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int nbPage = Integer.parseInt(request.getParameter("page"));
		JSONArray jsonArray = null;
		JSONObject json = null;
		List<Ville> listeVille = new ArrayList<Ville>();
		try {
			jsonArray = readJsonFromUrl("http://localhost:8181/ville");
		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < jsonArray.length(); i++) {
			json = jsonArray.getJSONObject(i);
			Ville ville = new Gson().fromJson(json.toString(), Ville.class);
			listeVille.add(ville);
		}
		System.out.println(listeVille.size());
		if(nbPage < 1 || nbPage > listeVille.size()/50 + 1) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/badRequest.jsp").forward(request, response);
		}
		request.setAttribute("listeVille", listeVille);
		this.getServletContext().getRequestDispatcher("/WEB-INF/infosVille.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
