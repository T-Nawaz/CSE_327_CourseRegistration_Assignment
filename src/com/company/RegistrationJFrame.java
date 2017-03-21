package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * Created by Abid Hasan on 2/28/2017.
 */
public class RegistrationJFrame extends Application {


    //UI COMPONENTS
    Stage window;
    TableView<Course> courseTable;
    TextField courseAdd;
    TextField subTotalTuition;
    Label courseAddLabel;
    Label totalTuitionLabel;
    Button newRegistration;
    Button addCourse;

    //NEW REGISTRATION CLASS OBJECT
    RegistrationCourseController courseController = new RegistrationCourseController();


    public static void main(String[] args) {
        // write your code here

        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Registration");

        //default registration
        courseController.makeNewRegistration();

        //COLUMNS OF TABLE
        TableColumn<Course, String> id_coloum = new TableColumn<>("Course");
        id_coloum.setMinWidth(200);
        id_coloum.setCellValueFactory(new PropertyValueFactory<Course, String>("id"));

        TableColumn<Course, String> title_coloum = new TableColumn<>("Title");
        title_coloum.setMinWidth(200);
        title_coloum.setCellValueFactory(new PropertyValueFactory<Course, String>("Title"));

        TableColumn<Course, String> credit_coloum = new TableColumn<>("Credit");
        credit_coloum.setMinWidth(200);
        credit_coloum.setCellValueFactory(new PropertyValueFactory<Course, String>("Credit"));

        TableColumn<Course, Integer> tution_credit = new TableColumn<>("Tuition/Credit");
        tution_credit.setMinWidth(200);
        tution_credit.setCellValueFactory(new PropertyValueFactory<Course, Integer>("tutionPerCredit"));

        TableColumn<Course, Integer> sub_total = new TableColumn<>("Sub Total");
        sub_total.setMinWidth(200);
        sub_total.setCellValueFactory(new PropertyValueFactory<Course, Integer>("subTotal"));

        //UI COMPONENTS VIEWS
        courseTable = new TableView<>();
        courseTable.getColumns().addAll(id_coloum, title_coloum, credit_coloum, tution_credit, sub_total);

        (courseAdd = new TextField()).setMaxSize(200, 50);
        courseAdd.paddingProperty().set(new Insets(10, 10, 10, 10));
        (subTotalTuition = new TextField()).setAlignment(Pos.CENTER_RIGHT);
        subTotalTuition.setMaxWidth(200);
        subTotalTuition.setPadding(new Insets(10, 10, 10, 10));


        courseAddLabel = new Label("Course ID ");
        courseAddLabel.paddingProperty().set(new Insets(5, 5, 5, 5));
        totalTuitionLabel = new Label("Total Tuition: ");
        totalTuitionLabel.paddingProperty().set(new Insets(5, 5, 5, 5));

        newRegistration = new Button("New Registration");
        newRegistration.paddingProperty().set(new Insets(10, 10, 10, 10));


        addCourse = new Button("Add Course");
        addCourse.paddingProperty().set(new Insets(10, 10, 10, 10));

        //ADD COURSE BUTTON METHOD
        addCourse.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {

                String id = courseAdd.getText();
                id=id.toUpperCase();
                Course course = new Course();

                if (id.equals("CSE 327")) {
                    course = courseController.getCourse("CSE 327");
                    courseController.addCourse("CSE 327");
                } else if (id.equals("CSE 323")) {
                    course = courseController.getCourse("CSE 323");
                    courseController.addCourse("CSE 323");
                } else if (id.equals("CSE 338")) {
                    course = courseController.getCourse("CSE 338");
                    courseController.addCourse("CSE 338");
                }else if (id.equals("CSE 338L")) {
                    course = courseController.getCourse("CSE 338L");
                    courseController.addCourse("CSE 338L");
                } else if (id.equals("CSE 332")) {
                    course = courseController.getCourse("CSE 332");
                    courseController.addCourse("CSE 332");
                } else if (id.equals("CSE 231")) {
                    course = courseController.getCourse("CSE 231");
                    courseController.addCourse("CSE 231");
                } else if (id.equals("PHY 108")) {
                    course = courseController.getCourse("PHY 108");
                    courseController.addCourse("PHY 108");
                } else if (id.equals("MAT 350")) {
                    course = courseController.getCourse("MAT 350");
                    courseController.addCourse("MAT 350");
                }

                courseTable.getItems().add(course);
                subTotalTuition.setText(String.valueOf((courseController.getRegistration()).getTotal()) + "/TK");
                subTotalTuition.editableProperty().setValue(false);
            }
        });

        //NEW REGISTRATION BUTTON METHOD
        newRegistration.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {

                courseController.makeNewRegistration();
                courseTable.getItems().clear();
                subTotalTuition.clear();
            }
        });


        //ATTACHING OBJECTS TO STAGE
        HBox hBox = new HBox();
        hBox.getChildren().addAll(courseAddLabel, courseAdd, addCourse, newRegistration);
        hBox.setSpacing(20);

        HBox totalHbox = new HBox();
        totalHbox.getChildren().addAll(totalTuitionLabel, subTotalTuition);
        totalHbox.setAlignment(Pos.CENTER_RIGHT);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox, courseTable, totalHbox);
        vBox.paddingProperty().set(new Insets(10, 10, 10, 10));
        vBox.setSpacing(10);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }


//    public ObservableList<Course> getCourses() {
//
//
//
//        courseController.makeNewRegistration();
//        courseController.addCourse("CSE 323");
//        courseController.addCourse("CSE 327");
//        courseController.addCourse("CSE 338");
//
//
//        Registration registration=courseController.getRegistration();
//
//        System.out.println(registration.getTotal());
//
//        ObservableList<Course> courses= FXCollections.observableArrayList();
//        for (int i = 0; i <(registration.getCourseList()).size() ; i++) {
//            courses.add((registration.getCourseList()).get(i));
//        }
//        return courses;
//    }
}


