package com.beans;

public class Ville {

	private String insee;
	private String nom;
	private String codePostal;
	private String libelle;
	private String ligne;
	private Coordonnees coord;

	public Ville() {
	}

	public Ville(String insee, String nom, String code, String libelle, String ligne, Coordonnees coord) {
		this.insee = insee;
		this.nom = nom;
		this.codePostal = code;
		this.libelle = libelle;
		this.ligne = ligne;
		this.coord = coord;
	}

	public String getInsee() {
		return insee;
	}

	public void setInsee(String insee) {
		this.insee = insee;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getLigne() {
		return ligne;
	}

	public void setLigne(String ligne) {
		this.ligne = ligne;
	}

	public Coordonnees getCoord() {
		return coord;
	}

	public void setCoord(Coordonnees coord) {
		this.coord = coord;
	}
	
	public double distanceWith(Ville ville) {
		// On utilise la m?thode de haversine
		double latA = Double.parseDouble(this.getCoord().getLatitude())*Math.PI/180;
		double longA = Double.parseDouble(this.getCoord().getLongitude())*Math.PI/180;
		double latB = Double.parseDouble(ville.getCoord().getLatitude())*Math.PI/180;
		double longB = Double.parseDouble(ville.getCoord().getLongitude())*Math.PI/180;
		double a = Math.pow(Math.sin((latB-latA)/2), 2) + Math.cos(latA)*Math.cos(latB)*Math.pow(Math.sin((longB-longA)/2), 2);
		double c = 2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double d = 6371*c;
		return (double) Math.round(d * 100) / 100; // arrondi deux chiffres apr?s la virgule
	}

}
