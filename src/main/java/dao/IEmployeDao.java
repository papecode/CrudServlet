package dao;

import java.util.List;

import metier.Employe;

public interface IEmployeDao {
	public Employe save(Employe e) throws Exception;

	public List<Employe> EmployesParMC(String mc) throws Exception;

	public Employe getEmploye(Long id) throws Exception;

	public Employe updateEmploye(Employe e) throws Exception;

	public void deleteEmploye(Long id) throws Exception;
}
