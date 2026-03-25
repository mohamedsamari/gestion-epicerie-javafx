package dao;

import model.Produit;
import model.Utilisateur;

public class TEST2{
    public static void main(String[] arg) {
        UtilisateurDAO dao = new UtilisateurDAO();
        Utilisateur utilisateur1 = dao.login("caisse", "1234");
        if(utilisateur1 != null) {
            System.out.println("Connection reuisi");
            System.out.println("Role:"+ utilisateur1.getRole());
        }else {
            System.out.println("Login incorrect !");
        }
        // TEST PRODUIT DAO COMPLET
        ProduitDAO dao1 = new ProduitDAO();

//  Ajouter
        Produit p = new Produit(0, "Café", new java.math.BigDecimal("12.5"), 20, 1);
        dao1.ajouterProduit(p);

//  Afficher
        System.out.println("\nListe produits :");
        dao1.getAllProduits().forEach(prod ->
                System.out.println(prod.getId() + " - " + prod.getNom())
        );

// Modifier (exemple id=1)
        Produit modif = new Produit(1, "Eau MINERALE", new java.math.BigDecimal("6"), 150, 1);
        dao1.updateProduit(modif);

//  Supprimer (exemple id=2)
        dao1.deleteProduit(2);
        //  Test Fournisseur
        FournisseurDAO fournisseurDAO = new FournisseurDAO();

        System.out.println("\nListe fournisseurs :");
        fournisseurDAO.getAllFournisseurs().forEach(f ->
                System.out.println(f.getNom() + " - " + f.getContact())
        );
    }


}
