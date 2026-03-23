/**
 * 
 */
/**
 * 
 */
module GestionEpecerieJavaFX {
	requires java.sql;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens controller to javafx.fxml;
    opens app to javafx.graphics;
}