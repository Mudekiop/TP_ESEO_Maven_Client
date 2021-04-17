package com.beans;

public class Ville {

	private String insee;
	private String nom;
	private String codePostal;
	private String libelle;
	private String ligne;
	private Coordonnees coord;

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

}
