package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import dao.UtilisateurDAO;
import model.Utilisateur;

public class LoginController {

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label lblError;

    @FXML
    private void SeConnecterButton() {

        String username = txtUsername.getText();
        String password = txtPassword.getText();

        UtilisateurDAO dao = new UtilisateurDAO();
        Utilisateur user = dao.login(username, password);

        if (user != null) {

            try {
                System.out.println("Connexion réussie !");
                System.out.println("Role : " + user.getRole());

                lblError.setText("Connexion réussie");
                lblError.setTextFill(Color.GREEN);

                
                FXMLLoader loader;
                String title;

                if (user.getRole().equals("ADMIN")) {
                    loader = new FXMLLoader(getClass().getResource("/view/admin.fxml"));
                    title = "Dashboard Admin";
                } else {
                    loader = new FXMLLoader(getClass().getResource("/view/caissier.fxml"));
                    title = "Dashboard Caissier";
                }

                Scene scene = new Scene(loader.load());

                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle(title);
                stage.show();

                ((Stage) txtUsername.getScene().getWindow()).close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}