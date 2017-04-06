package com.company;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.controlsfx.control.CheckComboBox;
import java.io.*;



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
    Button addNewCourse;

    CheckComboBox<String> cbStratagy;
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
        tution_credit.setCellValueFactory(new PropertyValueFactory<Course, Integer>("tpCredit"));

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

        totalTuitionLabel = new Label("Discount ");
        totalTuitionLabel.paddingProperty().set(new Insets(10, 10, 10, 10));

        courseAddLabel = new Label("Course ID ");
        courseAddLabel.paddingProperty().set(new Insets(10, 0, 10, 10));

        taxTotalLabel = new Label("Development Fee/BD Tax");
        taxTotalLabel.paddingProperty().set(new Insets(10, 10, 10, 10));


        grandTotalLabel = new Label("Grand Total");
        grandTotalLabel.paddingProperty().setValue(new Insets(10, 10, 10, 10));


        newRegistration = new Button("New Registration");
        newRegistration.paddingProperty().set(new Insets(10, 10, 10, 10));

        addNewCourse = new Button("New Course");
        addNewCourse.paddingProperty().set(new Insets(10, 10, 10, 10));
        addNewCourse.setAlignment(Pos.CENTER_RIGHT);

        addCourse = new Button("Add Course");
        addCourse.paddingProperty().set(new Insets(10, 10, 10, 10));

        calculateDiscount = new Button("Calculate Discount");
        calculateDiscount.paddingProperty().set(new Insets(10, 10, 10, 10));

        cbStratagy = new CheckComboBox<>();
        cbStratagy.setMaxSize(200, 50);
        cbStratagy.autosize();
        cbStratagy.getItems().addAll("AcademicExcellence",
                "FreedomFighter",
                "AboriginalORMinorityGroup");


        cbBest = new ComboBox<>();
        cbBest.autosize();
        cbBest.setMaxSize(200, 50);
        cbBest.getItems().addAll("BestForStudent",
                "BestForNSU");

        //ADD COURSE BUTTON METHOD

        addCourse.setOnAction(e -> {

                    String id = courseAdd.getText();
                    id = id.toUpperCase();
                    Course course = new Course();

                    course = courseController.getCourse(id);
                    courseController.addCourse(id);

                    courseTable.getItems().add(course);

                    //TODO need to apply appropriate expression to get Proper Values
                    totalTuition.setText("0/TK");
                    subTotalTuition.setText(String.valueOf((courseController.getRegistration()).getExtraFeeAmount()).trim() + "/TK");
                    grandTotoal.setText(String.valueOf((courseController.getRegistration()).getGrandTotal()) + "/TK");

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
            try {
                BufferedWriter discountStrategy = new BufferedWriter(new FileWriter("config/IDiscountStrategy.config"));
                BufferedWriter compositeDisount = new BufferedWriter(new FileWriter("config/CompositeDiscount.config"));
                discountStrategy.write("");
                compositeDisount.write("");
                discountStrategy.flush();
                compositeDisount.flush();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        calculateDiscount.setOnAction(e -> {
            try {
                BufferedWriter configWriter = new BufferedWriter(new FileWriter("config/IDiscountStrategy.config"));
                String classNames = String.valueOf(cbStratagy.getCheckModel().getCheckedItems());
                classNames = classNames.substring(1, classNames.length() - 1);
                if (classNames.contains(",")) {
                    configWriter.write("IDiscountStrategy.class.name=CompositeDiscount");
                    configWriter.write("\n" + "IDiscountStrategy.class.name.list=" + classNames);
                    configWriter.flush();
                } else {
                    configWriter.write("IDiscountStrategy.class.name=" + classNames + "Discount");
                    configWriter.flush();
                }
                int discountTotal = (courseController.getRegistration().getTotal() - courseController.getRegistration().getDiscountAmount());
                totalTuition.setText(String.valueOf(discountTotal).trim() + "/TK");
                grandTotoal.setText(String.valueOf(courseController.getRegistration().getTotal() - discountTotal) + "/TK");
                java.awt.Toolkit.getDefaultToolkit().beep();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

<<<<<<< HEAD
        addNewCourse.setOnAction(e -> {
            NewCourseFrame newCourseFrame=new NewCourseFrame();
                });
=======
        addNewCourse.setOnAction(e->{


            Button add=new Button("Add Course");

            TextField TFcourse_id=new TextField();
            TextField TFcourse_title=new TextField();
            TextField TFcourse_credit=new TextField();
            TextField TFtution_perCredit=new TextField();

            TFcourse_id.setMaxSize(200,50);
            TFcourse_title.setMaxSize(200,50);
            TFcourse_credit.setMaxSize(200,50);
            TFtution_perCredit.setMaxSize(200,50);


            Label  LBcourse_id= new Label("CourseId ");
            LBcourse_id.setPadding(new Insets(10,10,10,10));
            LBcourse_id.setMaxSize(100,50);

            Label  LBcourse_title=new Label("Course Title ");
            LBcourse_title.setPadding(new Insets(10,10,10,10));
            LBcourse_title.setMaxSize(100,50);

            Label  LBcourse_credit=new Label("Credit ");
            LBcourse_credit.setPadding(new Insets(10,10,10,10));
            LBcourse_credit.setMaxSize(100,50);

            Label  LBtution_perCredit=new Label("Tuition/Credit ");
            LBtution_perCredit.setPadding(new Insets(10,10,10,10));
            LBtution_perCredit.setMaxSize(100,50);


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
            grid.add(LBcourse_credit,0,3);
            grid.add(TFcourse_credit,1,3);
            grid.add(LBtution_perCredit,0,4);
            grid.add(TFtution_perCredit,1,4);
            grid.add(add,1,5);

            Stage stage = new Stage();
            stage.setTitle("Add New Course");
            Scene scene=new Scene(grid,400,500);
            stage.setScene(scene);
            stage.show();

            CourseFactory courseFactory=new CourseFactory();
            Course course=new Course();

            add.setOnAction(event->{

                course.setId(TFcourse_id.getText().trim().toUpperCase());
                course.setTitle( TFcourse_title.getText().trim());
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

        });
>>>>>>> 0ad228089319753c97525211e68b94ece272d49d

        //setting compositeDiscount Configuration File
        cbBest.setOnAction(e -> {
            try {
                BufferedWriter bestConfigWriter = new BufferedWriter(new FileWriter("config/CompositeDiscount.config"));
                bestConfigWriter.write("CompositeDiscount.class.name=" + cbBest.getSelectionModel().getSelectedItem());
                bestConfigWriter.flush();

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });


        //ATTACHING OBJECTS TO STAGE
        HBox hBox = new HBox();
        hBox.getChildren().addAll(courseAddLabel, courseAdd, addCourse, newRegistration, addNewCourse);
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
        vbDiscount.getChildren().addAll(cbStratagy, cbBest, calculateDiscount);
        vbDiscount.setSpacing(10);
        vbDiscount.setAlignment(Pos.CENTER_LEFT);

        VBox vbFees = new VBox();
        vbFees.getChildren().addAll(taxtotalHbox, totalHbox, grandTotalHbox);
        vbFees.setSpacing(10);

        HBox hbFeeStratagy = new HBox();
        hbFeeStratagy.getChildren().addAll(vbDiscount, vbFees);
        hbFeeStratagy.setSpacing(500);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox, courseTable, hbFeeStratagy);
        vBox.paddingProperty().set(new Insets(10, 10, 10, 10));
        vBox.setSpacing(10);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }


}


