package web;

import java.util.ArrayList;
import java.util.List;

import metier.Employe;

public class EmployeModel {
	private String motCle;
	private List<Employe> employes = new ArrayList<>();

	public String getMotCle() {
		return motCle;
	}

	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}
}
