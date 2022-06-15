import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;




// ***********************************
//                           判断日期
// ***********************************


public class Date extends Application {
    public int i;
    public int j;
    public int k;
    @Override
    public void start(Stage stage) throws Exception {

        Label label1=new Label("年");
        Label label2=new Label("月");
        Label label3=new Label("日");
        Label label4=new Label("下一天");

        label1.setFont(Font.font(10));
        label2.setFont(Font.font(10));
        label3.setFont(Font.font(10));
        label4.setFont(Font.font(10));

        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();

        TextField textField4 = new TextField();
        textField4.setEditable(false);

        textField1.setAlignment(Pos.CENTER);
        textField2.setAlignment(Pos.CENTER);
        textField3.setAlignment(Pos.CENTER);
        textField4.setAlignment(Pos.CENTER);

        Button button1 = new Button("计算下一天");
        Button button2 = new Button("重新输入");

        button1.setPrefHeight(20);
        button1.setPrefWidth(100);
        button2.setPrefHeight(20);
        button2.setPrefWidth(100);
        HBox hBox = new HBox();
        hBox.getChildren().addAll(button1, button2);
        HBox.setMargin(button1, new Insets(0, 20, 0, 0));

        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(false);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.add(label1, 0, 0);//列 行
        gridPane.add(textField1, 1, 0);
        gridPane.add(label2, 0, 1);
        gridPane.add(textField2, 1, 1);
        gridPane.add(label3, 0, 2);
        gridPane.add(textField3, 1, 2);
        gridPane.add(label4, 0, 3);
        gridPane.add(textField4, 1, 3);
        Label title = new Label("请分别输入年月日:");
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
                i = Integer.parseInt(textField1.getText());

                j = Integer.parseInt(textField2.getText());

                k = Integer.parseInt(textField3.getText());


                try {
                    DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                    LocalDate date = LocalDate.of(i, j, k);
                    LocalDate nextDate = date.plusDays(1);
                    textField4.setText(nextDate.format(dft));
                } catch (Exception e) {
                    textField4.setText("不可能");
                }

            }
        });


        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
            }
        });

        stage.setScene(new Scene(borderPane));
        stage.setTitle("NextDate");
        stage.show();

    }
}


