package controller;

import dao.FournisseurDAO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Fournisseur;

import java.util.List;

public class FournisseurController {

    @FXML private TextField nomField;
    @FXML private TextField contactField;
    @FXML private TableView<Fournisseur> tableFournisseur;

    private FournisseurDAO fournisseurDAO = new FournisseurDAO();

    @FXML
    public void initialize() {
        loadFournisseurs();
    }

    private void loadFournisseurs() {
        List<Fournisseur> list = fournisseurDAO.getAllFournisseurs();
        tableFournisseur.setItems(FXCollections.observableArrayList(list));
    }

    @FXML
    private void ajouterFournisseur() {
        Fournisseur f = new Fournisseur(0, nomField.getText(), contactField.getText());
        // à implémenter DAO add si besoin
        System.out.println("Ajout fournisseur (à implémenter)");
    }
}
