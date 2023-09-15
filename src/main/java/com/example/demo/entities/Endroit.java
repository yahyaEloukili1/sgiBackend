package com.example.demo.entities;

import javax.persistence.*;
@Entity
public class Endroit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String identifiant;
	private String designation;
	private String adress;
	@ManyToOne()
	private Annexe annexe;
	@ManyToOne()
	private District district;
	private String districtName;
	private String annexeName;
	private String categorieName;
	private int superficie;
	private String contact;
	private String observations;
	private int x;
	private int y;
	@ManyToOne()
	private Categorie categorie;
	public Endroit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Endroit(String designation, String adress, String districtName, String annexeName, String categorieName,
			int superficie, String contact, String observations, int x, int y) {
		super();
		this.designation = designation;
		this.adress = adress;
		this.districtName = districtName;
		this.annexeName = annexeName;
		this.categorieName = categorieName;
		this.superficie = superficie;
		this.contact = contact;
		this.observations = observations;
		this.x = x;
		this.y = y;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Annexe getAnnexe() {
		return annexe;
	}
	public void setAnnexe(Annexe annexe) {
		this.annexe = annexe;
	}
	public District getDistrict() {
		return district;
	}
	public void setDistrict(District district) {
		this.district = district;
	}
	public int getSuperficie() {
		return superficie;
	}
	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	
	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getAnnexeName() {
		return annexeName;
	}

	public void setAnnexeName(String annexeName) {
		this.annexeName = annexeName;
	}

	public String getCategorieName() {
		return categorieName;
	}

	public void setCategorieName(String categorieName) {
		this.categorieName = categorieName;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
}
