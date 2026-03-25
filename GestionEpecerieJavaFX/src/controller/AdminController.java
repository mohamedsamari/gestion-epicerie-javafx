package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.*;
import javafx.scene.control.cell.PropertyValueFactory;

import model.Produit;
import dao.ProduitDAO;

import java.math.BigDecimal;

public class AdminController {

    // 🔹 Champs formulaire
    @FXML
    private TextField txtNom;

    @FXML
    private TextField txtPrix;

    @FXML
    private TextField txtQuantite;

    // 🔹 TableView
    @FXML
    private TableView<Produit> tableProduits;

    @FXML
    private TableColumn<Produit, Integer> colId;

    @FXML
    private TableColumn<Produit, String> colNom;

    @FXML
    private TableColumn<Produit, BigDecimal> colPrix;

    @FXML
    private TableColumn<Produit, Integer> colQuantite;

    // 🔹 Liste observable
    private ObservableList<Produit> listeProduits;

    // 🔹 DAO
    private ProduitDAO dao = new ProduitDAO();

    // 🔥 INITIALISATION
    @FXML
    public void initialize() {

        // 🔗 Lier colonnes avec attributs de Produit
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        colQuantite.setCellValueFactory(new PropertyValueFactory<>("quantiteStock"));

        // 📥 Charger données
        chargerProduits();

        // 🔥 BONUS PRO : cliquer sur ligne → remplir champs
        tableProduits.setOnMouseClicked(event -> {
            Produit p = tableProduits.getSelectionModel().getSelectedItem();

            if (p != null) {
                txtNom.setText(p.getNom());
                txtPrix.setText(p.getPrix().toString());
                txtQuantite.setText(String.valueOf(p.getQuantiteStock()));
            }
        });
    }

    // 🔹 Charger produits depuis BD
    private void chargerProduits() {
        listeProduits = FXCollections.observableArrayList(dao.getAllProduits());
        tableProduits.setItems(listeProduits);
    }

    // ➕ AJOUTER
    @FXML
    private void ajouterProduit() {

        try {
            String nom = txtNom.getText();
            BigDecimal prix = new BigDecimal(txtPrix.getText());
            int quantite = Integer.parseInt(txtQuantite.getText());

            // ⚠️ fournisseurId = 1 (temporaire)
            Produit p = new Produit(0, nom, prix, quantite, 1);

            dao.ajouterProduit(p);

            chargerProduits();

            viderChamps();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ❌ SUPPRIMER
    @FXML
    private void supprimerProduit() {

        Produit p = tableProduits.getSelectionModel().getSelectedItem();

        if (p != null) {
            dao.deleteProduit(p.getId());
            chargerProduits();
        }
    }

    // ✏️ MODIFIER
    @FXML
    private void modifierProduit() {

        Produit p = tableProduits.getSelectionModel().getSelectedItem();

        if (p != null) {

            try {
                p.setNom(txtNom.getText());
                p.setPrix(new BigDecimal(txtPrix.getText()));
                p.setQuantiteStock(Integer.parseInt(txtQuantite.getText()));

                dao.updateProduit(p);

                chargerProduits();

                viderChamps();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 🔄 ACTUALISER
    @FXML
    private void actualiserProduits() {
        chargerProduits();
    }

    // 🧹 Nettoyer champs
    private void viderChamps() {
        txtNom.clear();
        txtPrix.clear();
        txtQuantite.clear();
    }
}