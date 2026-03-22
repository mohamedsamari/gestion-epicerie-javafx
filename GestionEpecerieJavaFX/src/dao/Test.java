package dao;

import model.Utilisateur;

public class Test {
	public static void main(String[] arg) {
		 UtilisateurDAO dao = new UtilisateurDAO();
		 Utilisateur utilisateur1 = dao.login("caisse", "1234");
		if(utilisateur1 != null) {
			System.out.println("Connection reuisi");
			System.out.println("Role:"+ utilisateur1.getRole());
		}else {
            System.out.println("Login incorrect !");
        }
	}

}
