package metier;

import java.io.Serializable;
import java.util.Date;

public class Employe implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String matricule;
	private String nom;
	private String prenom;
	private Date dateEmbauche;
	private String service;
	private String fonction;
	private String sexe;
	private Integer salaire;

	public Employe() {
	}

	public Employe(String matricule, String nom, String prenom, Date dateEmbauche, String service, String fonction,
			String sexe, Integer salaire) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.dateEmbauche = dateEmbauche;
		this.service = service;
		this.fonction = fonction;
		this.sexe = sexe;
		this.salaire = salaire;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public Integer getSalaire() {
		return salaire;
	}

	public void setSalaire(Integer salaire) {
		this.salaire = salaire;
	}

	@Override
	public String toString() {
		return "Employe [id=" + id + ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom
				+ ", dateEmbauche=" + dateEmbauche + ", service=" + service + ", fonction=" + fonction + ", sexe="
				+ sexe + ", salaire=" + salaire + "]";
	}
	
	

}
