import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;



// ***********************************
//                           登录
// ***********************************


public class login extends Application {
    public String userID = "";
    public String password = "";
    @Override
    public void start(Stage stage) throws Exception {


        //设置标签显示内容
        Label label1=new Label("用户名");
        Label label2=new Label("密码");

        //设置内容的字体大小
        label1.setFont(Font.font(10));
        label2.setFont(Font.font(10));



        //创建文本区域
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();

        //设置文本排列方式
        textField1.setAlignment(Pos.CENTER_RIGHT);
        textField2.setAlignment(Pos.CENTER_RIGHT);


        //创建两按钮
        Button button1 = new Button("登录");
        Button button2 = new Button("重新输入");
        //设置按钮大小
        button1.setPrefHeight(20);
        button1.setPrefWidth(100);
        button2.setPrefHeight(20);
        button2.setPrefWidth(100);
        HBox hBox = new HBox();
        hBox.getChildren().addAll(button1, button2);
        HBox.setMargin(button1, new Insets(0, 20, 0, 0));

        //棋盘布局
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(false);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.add(label1, 0, 0);//列 行
        gridPane.add(textField1, 1, 0);
        gridPane.add(label2, 0, 1);
        gridPane.add(textField2, 1, 1);


        Label title = new Label("登录");
        title.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();

        BorderPane.setAlignment(title, Pos.CENTER);

        BorderPane.setAlignment(hBox, Pos.TOP_CENTER);

        borderPane.setPadding(new Insets(10, 0, 20, 20));

        borderPane.setTop(title);

        borderPane.setCenter(gridPane);

        borderPane.setBottom(hBox);

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                userID = textField1.getText();
                password = textField2.getText();

                if (userID.matches("^[a-zA-Z]\\w{5,9}") && password.matches("\\d{6}")) {
                    createStage("用户合法");
                }
                else {
                    createStage("用户不合法");
                }
            }
        });

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                textField1.setText("");
                textField2.setText("");

            }
        });


        stage.setScene(new Scene(borderPane));
        stage.setTitle("NextDate");
        stage.show();

    }
    public void createStage (String labelContent) {
        Label exception = new Label(labelContent);
        //创建另一个stage
        Stage newStage = new Stage();
        newStage.setScene(new Scene(new StackPane(exception)));
        //指定 stage 的模式
        newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.setTitle("tip");
        newStage.showAndWait();

    }
}



