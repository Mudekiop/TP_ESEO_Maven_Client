package com.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
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
import com.fasterxml.jackson.databind.ObjectMapper;
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
		if (request.getParameter("insee") == null) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/badRequest.jsp").forward(request, response);
		}
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
		if (request.getParameter("send").equals("Supprimer la ville")) {
			URL url = new URL("http://localhost:8181/ville?insee=" + request.getParameter("insee"));
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("DELETE");
			if (con.getResponseCode() == 200) {
				this.getServletContext().getRequestDispatcher("/WEB-INF/villeSup.jsp").forward(request, response);
			}
		} else if (request.getParameter("send").equals("Mettre a jour")) {
			String choix = (String) request.getParameter("choix");
			String valeur = (String) request.getParameter("chgt");

			String insee = (String) request.getParameter("insee");
			JSONObject json = null;
			try {
				json = readJsonFromUrl("http://localhost:8181/ville?codeInsee=" + insee);
			} catch (IOException | JSONException e) {
				e.printStackTrace();
			}
			Ville ancienneVille = new Gson().fromJson(json.toString(), Ville.class);

			Ville newVille = new Ville();
			newVille.setCoord(ancienneVille.getCoord());
			newVille.setInsee(ancienneVille.getInsee());
			switch (choix) {
			case "Code Postal":
				newVille.setCodePostal(valeur);
				newVille.setLibelle(ancienneVille.getLibelle());
				newVille.setLigne(ancienneVille.getLigne());
				newVille.setNom(ancienneVille.getNom());
				break;
			case "Nom":
				newVille.setCodePostal(ancienneVille.getCodePostal());
				newVille.setLibelle(ancienneVille.getLibelle());
				newVille.setLigne(ancienneVille.getLigne());
				newVille.setNom(valeur);
				break;
			case "Libelle acheminement":
				newVille.setCodePostal(ancienneVille.getCodePostal());
				newVille.setLibelle(valeur);
				newVille.setLigne(ancienneVille.getLigne());
				newVille.setNom(ancienneVille.getNom());
				break;
			case "Ligne":
				newVille.setCodePostal(ancienneVille.getCodePostal());
				newVille.setLibelle(ancienneVille.getLibelle());
				newVille.setLigne(valeur);
				newVille.setNom(ancienneVille.getNom());
				break;
			}
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(newVille);
			URL url = new URL("http://localhost:8181/ville?insee=" + request.getParameter("insee"));
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("PUT");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			OutputStream os = null;
			try {
				os = con.getOutputStream();
				byte[] input = jsonString.getBytes("UTF-8");
				os.write(input, 0, input.length);
			} finally {
				os.close();
			}
			if (con.getResponseCode() == 200) {
				this.doGet(request, response);
			}
		}
	}

}
