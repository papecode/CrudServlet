package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.esmt.crud.db.DBManager;

import metier.Employe;

public class EmployeDaoImpl implements IEmployeDao {

	@Override
	public Employe save(Employe e) throws Exception {
		try {
			Connection conn = DBManager.getConnection();
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO employe (matricule, nom, prenom, dateEmbauche, service, fonction, sexe, salaire) values (?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, e.getMatricule());
			ps.setString(2, e.getNom());
			ps.setString(3, e.getPrenom());
			ps.setDate(4, (Date) e.getDateEmbauche());
			ps.setString(5, e.getService());
			ps.setString(6, e.getFonction());
			ps.setString(7, e.getSexe());
			ps.setDouble(8, e.getSalaire());
			ps.executeUpdate();

			PreparedStatement ps1 = conn.prepareStatement("SELECT MAX(id) as MAX_ID FROM employe");
			ResultSet rs = ps1.executeQuery();
			if (rs.next()) {
				e.setId(rs.getLong("MAX_ID"));
			}

			ps.close();
			ps1.close();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}

		return e;
	}

	@Override
	public List<Employe> EmployesParMC(String mc) throws Exception {
		List<Employe> empls = new ArrayList<Employe>();
		try {
			Connection conn = DBManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from employe where nom LIKE ?");
			ps.setString(1, "%" + mc + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employe e = new Employe();
				e.setId(rs.getLong("id"));
				e.setMatricule(rs.getString("matricule"));
				e.setNom(rs.getString("nom"));
				e.setPrenom(rs.getString("prenom"));
				e.setDateEmbauche(rs.getDate("dateEmbauche"));
				e.setService(rs.getString("service"));
				e.setFonction(rs.getString("fonction"));
				e.setSexe(rs.getString("sexe"));
				e.setSalaire(rs.getInt("salaire"));
				//
				empls.add(e);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empls;
	}

	@Override
	public Employe getEmploye(Long id) throws Exception {
	    Employe employe = null;
	    try {
	        Connection conn = DBManager.getConnection();
	        PreparedStatement ps = conn.prepareStatement("SELECT * FROM employe WHERE id = ?");
	        ps.setLong(1, id);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            employe = new Employe();
	            employe.setId(rs.getLong("id"));
	            employe.setMatricule(rs.getString("matricule"));
	            employe.setNom(rs.getString("nom"));
	            employe.setPrenom(rs.getString("prenom"));
	            employe.setDateEmbauche(rs.getDate("dateEmbauche"));
	            employe.setService(rs.getString("service"));
	            employe.setFonction(rs.getString("fonction"));
	            employe.setSexe(rs.getString("sexe"));
	            employe.setSalaire(rs.getInt("salaire"));
	        }
	        rs.close();
	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return employe;
	}


	@Override
	public Employe updateEmploye(Employe e) throws Exception {
		try {
	        Connection conn = DBManager.getConnection();
	        PreparedStatement ps = conn.prepareStatement(
	            "UPDATE employe SET matricule=?, nom=?, prenom=?, dateEmbauche=?, service=?, fonction=?, sexe=?, salaire=? WHERE id=?");
	        ps.setString(1, e.getMatricule());
	        ps.setString(2, e.getNom());
	        ps.setString(3, e.getPrenom());
	        ps.setDate(4, (Date) e.getDateEmbauche());
	        ps.setString(5, e.getService());
	        ps.setString(6, e.getFonction());
	        ps.setString(7, e.getSexe());
	        ps.setInt(8, e.getSalaire());
	        ps.setLong(9, e.getId());
	        int rowsUpdated = ps.executeUpdate();
	        ps.close();
	        
	        if (rowsUpdated > 0) {
	            return e;
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        throw new Exception("Erreur lors de la mise à jour de l'employé: " + ex.getMessage());
	    }
	    
	    throw new Exception("Aucune mise à jour effectuée pour l'employé avec l'ID: " + e.getId());
	}

	@Override
	public void deleteEmploye(Long id) throws Exception {
		 Connection conn= DBManager.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM EMPLOYE WHERE ID = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
