package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class CaissierController {

    @FXML
    private TableView<?> tableProduits;

    @FXML
    private TableColumn<?, ?> colProduit;

    @FXML
    private TableColumn<?, ?> colPrix;

    
    @FXML
    private TableView<?> tablePanier;

    @FXML
    private TableColumn<?, ?> colProduitChoisi;

    @FXML
    private TableColumn<?, ?> colPrixChoisi;

    
    @FXML
    private TextField txtSearch;

    
    @FXML
    private TextField lblTotal;

    

    @FXML
    private void btnAjouter() {
        System.out.println("Ajouter produit au panier");
    }

    @FXML
    private void btnRetirer() {
        System.out.println("Retirer produit du panier");
    }

    @FXML
    private void btnEffacer() {
        System.out.println("Vider le panier");
    }

    @FXML
    private void btnPayer() {
        System.out.println("Paiement effectué");
    }

    @FXML
    private void btnChercher() {
        System.out.println("Recherche produit");
    }

    @FXML
    private void btnSupprimer() {
        System.out.println("Supprimer produit");
    }

    @FXML
    private void btnModifier() {
        System.out.println("Modifier produit");
    }

    @FXML
    private void btnEnregistrer() {
        System.out.println("Enregistrer produit");
    }
}