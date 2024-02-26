package test;

import java.util.List;

import dao.EmployeDaoImpl;
import metier.Employe;

public class TestDao {

	public static void main(String[] args) {
		EmployeDaoImpl edao = new EmployeDaoImpl();
		try {
			//Employe emp = edao.save(new Employe("123456", "John", "Doe", "2024-02-25", "Service", "Fonction", "M", 500000));
			
			//System.out.println(emp);
			
			List<Employe> empls = edao.EmployesParMC("John");
			
			for (Employe employe : empls) {
				System.out.println(employe);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
