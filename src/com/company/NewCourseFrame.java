package com.company;

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
public class NewCourseFrame {

    public NewCourseFrame() {

        Button add = new Button("Add Course");

        TextField TFcourse_id = new TextField();
        TextField TFcourse_title = new TextField();
        TextField TFcourse_credit = new TextField();
        TextField TFtution_perCredit = new TextField();

        TFcourse_id.setMaxSize(200, 50);
        TFcourse_title.setMaxSize(200, 50);
        TFcourse_credit.setMaxSize(200, 50);
        TFtution_perCredit.setMaxSize(200, 50);


        Label LBcourse_id = new Label("CourseId ");
        LBcourse_id.setPadding(new Insets(10, 10, 10, 10));
        LBcourse_id.setMaxSize(100, 50);

        Label LBcourse_title = new Label("Course Title ");
        LBcourse_title.setPadding(new Insets(10, 10, 10, 10));
        LBcourse_title.setMaxSize(100, 50);

        Label LBcourse_credit = new Label("Credit ");
        LBcourse_credit.setPadding(new Insets(10, 10, 10, 10));
        LBcourse_credit.setMaxSize(100, 50);

        Label LBtution_perCredit = new Label("Tuition/Credit ");
        LBtution_perCredit.setPadding(new Insets(10, 10, 10, 10));
        LBtution_perCredit.setMaxSize(100, 50);


        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Add Course Here");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);


        grid.add(LBcourse_id, 0, 1);


        grid.add(TFcourse_id, 1, 1);
        grid.add(LBcourse_title, 0, 2);
        grid.add(TFcourse_title, 1, 2);
        grid.add(LBcourse_credit, 0, 3);
        grid.add(TFcourse_credit, 1, 3);
        grid.add(LBtution_perCredit, 0, 4);
        grid.add(TFtution_perCredit, 1, 4);
        grid.add(add, 1, 5);

        Stage stage = new Stage();
        stage.setTitle("Add New Course");
        Scene scene = new Scene(grid, 400, 500);
        stage.setScene(scene);
        stage.show();

        CourseFactory courseFactory = new CourseFactory();
        Course course = new Course();

        add.setOnAction(event -> {

            course.setId(TFcourse_id.getText().trim().toUpperCase());
            course.setTitle(TFcourse_title.getText().trim());
            course.setCredit(Integer.parseInt(TFcourse_credit.getText().trim()));
            course.setTuitionPerCredit(Integer.parseInt(TFtution_perCredit.getText().trim()));

            courseFactory.addCourse(course);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Course Successfully Added to Database");

            alert.showAndWait();
            TFcourse_id.clear();
            TFcourse_title.clear();
            TFcourse_credit.clear();
            TFtution_perCredit.clear();
        });



}
}
