import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class BddToArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/users";
			String user = "root";
			String pwd = "o08080";
			
			Connection cn = (Connection) DriverManager.getConnection(url, user, pwd);
			
			Statement st = (Statement) cn.createStatement();
			
			String sql = "SELECT * FROM personne";
			
			ResultSet result = (ResultSet) st.executeQuery(sql);
			
			ArrayList<Personne> listePersonne = new ArrayList<Personne>();
			
			while(result.next()) {
				Personne p = new Personne();
				
				p.setNom(result.getString("nom"));
				p.setPrenom(result.getString("prenom"));
				p.setAge(result.getInt("age"));
				p.setEmail(result.getString("email"));
				p.setTelephone(result.getString("telephone"));
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
