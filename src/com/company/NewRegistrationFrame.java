<<<<<<< HEAD
package com.company;

/**
 * Created by abidh on 4/6/2017.
 */
public class NewRegistrationFrame {

    /**
     * TODO a frame to be implemented to take registration id
     */
}
=======
package com.company;

import java.awt.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * Created by abidh on 4/6/2017.
 */
public class NewRegistrationFrame {

    public NewRegistrationFrame(){

        Button next = new Button("Next");

        TextField TFstudent_id = new TextField();
        TFstudent_id.setMaxSize(200,200);

        Label LBstudent_id = new Label("ID");
        LBstudent_id.setPadding(new Insets(10,10,10,10));
        LBstudent_id.setMaxSize(100,50);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Enter Student ID Here");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        grid.add(LBstudent_id, 0,1);
        grid.add(TFstudent_id, 1,1);
        grid.add(next,2,2);

        Stage stage = new Stage();
        stage.setTitle("New Registration");
        Scene scene = new Scene(grid,400,500);
        stage.setScene(scene);
        stage.show();

        next.setOnAction(event -> {

            // Todo Set Functionality


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Student ID Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Student ID has been accepted. Proceed to course advising.");
            alert.showAndWait();
            TFstudent_id.clear();
            alert.close();
        });
    }

}
>>>>>>> origin/master
