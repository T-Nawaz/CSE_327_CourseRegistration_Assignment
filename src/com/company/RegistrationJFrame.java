package com.company;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.nio.Buffer;


/**
 * Created by Abid Hasan on 2/28/2017.
 */
public class RegistrationJFrame extends Application {


    //UI COMPONENTS
    Stage window;
    TableView<Course> courseTable;
    TextField courseAdd;
    TextField subTotalTuition;
    TextField totalTuition;
    TextField grandTotoal;
    Label courseAddLabel;
    Label taxTotalLabel;
    Label grandTotalLabel;
    Label totalTuitionLabel;
    Button newRegistration;
    Button addCourse;
    Button calculateDiscount;
    ComboBox<String> cbStratagy;
    ComboBox<String> cbBest;

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


        subTotalTuition = new TextField();
        subTotalTuition.setMaxSize(200, 50);
        subTotalTuition.setPadding(new Insets(10, 10, 10, 10));

        totalTuition = new TextField();
        totalTuition.setMaxSize(200, 50);
        totalTuition.paddingProperty().setValue(new Insets(10, 10, 10, 10));

        grandTotoal = new TextField();
        grandTotoal.setMaxSize(200, 50);
        grandTotoal.paddingProperty().setValue(new Insets(10, 10, 10, 10));

        totalTuitionLabel = new Label("Total Tution ");
        totalTuitionLabel.paddingProperty().set(new Insets(10, 10, 10, 10));

        courseAddLabel = new Label("Course ID ");
        courseAddLabel.paddingProperty().set(new Insets(10,0,10,10));

        taxTotalLabel = new Label("Development Fee/BD Tax");
        taxTotalLabel.paddingProperty().set(new Insets(10, 10, 10, 10));


        grandTotalLabel = new Label("Grand Total");
        grandTotalLabel.paddingProperty().setValue(new Insets(10, 10, 10, 10));


        newRegistration = new Button("New Registration");
        newRegistration.paddingProperty().set(new Insets(10, 10, 10, 10));


        addCourse = new Button("Add Course");
        addCourse.paddingProperty().set(new Insets(10, 10, 10, 10));

        calculateDiscount = new Button("Calculate Discount");
        calculateDiscount.paddingProperty().set(new Insets(10,10,10,10));

        cbStratagy = new ComboBox<>();
        cbStratagy.setMaxSize(200,50);
        cbStratagy.autosize();
        cbStratagy.getItems().addAll("AcademicExcellence",
                                        "FreedomFighter",
                                            "AboriginalORMinorityGroup");
        cbBest = new ComboBox<>();
        cbBest.autosize();
        cbBest.setMaxSize(200,50);
        cbBest.getItems().addAll("BestForStudent",
                                    "BestForNSU");

        //ADD COURSE BUTTON METHOD

        addCourse.setOnAction(e -> {

                    String id = courseAdd.getText();
                    id = id.toUpperCase();
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
                    } else if (id.equals("CSE 338L")) {
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

                    totalTuition.setText(String.valueOf((courseController.getRegistration()).getTotal()).trim() + "/TK");
                    subTotalTuition.setText(String.valueOf((courseController.getRegistration()).getExtraFeeAmonunt()).trim() + "/TK");
                    grandTotoal.setText(String.valueOf((courseController.getRegistration()).getGrandTotal()).trim() + "/TK");

                    subTotalTuition.editableProperty().setValue(false);
                    totalTuition.editableProperty().setValue(false);
                    grandTotoal.editableProperty().setValue(false);
                }
        );

        //NEW REGISTRATION BUTTON METHOD
        newRegistration.setOnAction(e -> {
            courseController.makeNewRegistration();
            courseTable.getItems().clear();
            subTotalTuition.clear();
            totalTuition.clear();
            grandTotoal.clear();
        });


        cbStratagy.setOnAction(e->{
            try {
                BufferedWriter configWriter=new BufferedWriter(new FileWriter("config/IDiscountStrategy.config"));
                configWriter.write("IDiscountStrategy.class.name="+cbStratagy.getSelectionModel().getSelectedItem()+"Discount");
                configWriter.flush();

            }catch (IOException e1) {
                e1.printStackTrace();
            }
        });



        //ATTACHING OBJECTS TO STAGE
        HBox hBox = new HBox();
        hBox.getChildren().addAll(courseAddLabel, courseAdd, addCourse, newRegistration);
        hBox.setSpacing(20);

        HBox totalHbox = new HBox();
        totalHbox.getChildren().addAll(totalTuitionLabel, totalTuition);
        totalHbox.setAlignment(Pos.CENTER_RIGHT);

        HBox taxtotalHbox = new HBox();
        taxtotalHbox.getChildren().addAll(taxTotalLabel, subTotalTuition);
        taxtotalHbox.setAlignment(Pos.CENTER_RIGHT);

        HBox grandTotalHbox = new HBox();
        grandTotalHbox.getChildren().addAll(grandTotalLabel, grandTotoal);
        grandTotalHbox.setAlignment(Pos.CENTER_RIGHT);

        VBox vbDiscount = new VBox();
        vbDiscount.getChildren().addAll(cbStratagy,cbBest,calculateDiscount);
        vbDiscount.setSpacing(10);
        vbDiscount.setAlignment(Pos.CENTER_LEFT);

        VBox vbFees = new VBox();
        vbFees.getChildren().addAll(totalHbox,taxtotalHbox,grandTotalHbox);
        vbFees.setSpacing(10);

        HBox hbFeeStratagy = new HBox();
        hbFeeStratagy.getChildren().addAll(vbDiscount,vbFees);
        hbFeeStratagy.setSpacing(500);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox, courseTable, hbFeeStratagy);
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


