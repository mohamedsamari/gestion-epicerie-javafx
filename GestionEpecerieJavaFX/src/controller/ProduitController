package controller;

import dao.ProduitDAO;
import dao.FournisseurDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Produit;
import model.Fournisseur;

import java.math.BigDecimal;
import java.util.List;

public class ProduitController {

    @FXML private TextField nomField;
    @FXML private TextField prixField;
    @FXML private TextField stockField;
    @FXML private ComboBox<Fournisseur> fournisseurCombo;
    @FXML private TableView<Produit> tableProduit;

    private ProduitDAO produitDAO = new ProduitDAO();
    private FournisseurDAO fournisseurDAO = new FournisseurDAO();

    // Initialisation
    @FXML
    public void initialize() {
        loadProduits();
        loadFournisseurs();
    }

    //  Charger produits
    private void loadProduits() {
        List<Produit> list = produitDAO.getAllProduits();
        tableProduit.setItems(FXCollections.observableArrayList(list));
    }

    //  Charger fournisseurs
    private void loadFournisseurs() {
        List<Fournisseur> list = fournisseurDAO.getAllFournisseurs();
        fournisseurCombo.setItems(FXCollections.observableArrayList(list));
    }

    //  Ajouter produit
    @FXML
    private void ajouterProduit() {
        try {
            String nom = nomField.getText();
            BigDecimal prix = new BigDecimal(prixField.getText());
            int stock = Integer.parseInt(stockField.getText());
            Fournisseur f = fournisseurCombo.getValue();

            Produit p = new Produit(0, nom, prix, stock, f.getId());
            produitDAO.ajouterProduit(p);

            loadProduits();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  Supprimer produit
    @FXML
    private void supprimerProduit() {
        Produit selected = tableProduit.getSelectionModel().getSelectedItem();

        if (selected != null) {
            produitDAO.deleteProduit(selected.getId());
            loadProduits();
        }
    }

    // ✏ Modifier produit
    @FXML
    private void modifierProduit() {
        Produit selected = tableProduit.getSelectionModel().getSelectedItem();

        if (selected != null) {
            selected.setNom(nomField.getText());
            selected.setPrix(new BigDecimal(prixField.getText()));
            selected.setQuantiteStock(Integer.parseInt(stockField.getText()));

            produitDAO.updateProduit(selected);
            loadProduits();
        }
    }
}
