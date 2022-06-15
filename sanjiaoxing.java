import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class sanjiaoxing extends Application {
    public int a;
    public int b;
    public int c;
    @Override
    public void start(Stage stage) throws Exception {
        //设置标签显示内容
        Label label1=new Label("A");
        Label label2=new Label("B");
        Label label3=new Label("C");
        Label label4=new Label("形状");
        //设置内容的字体大小
        label1.setFont(Font.font(10));
        label2.setFont(Font.font(10));
        label3.setFont(Font.font(10));
        label4.setFont(Font.font(10));


        //创建文本区域
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();
        //4 得出形状的结果
        TextField textField4 = new TextField();
        textField4.setEditable(false);
        //设置文本排列方式
        textField1.setAlignment(Pos.CENTER);
        textField2.setAlignment(Pos.CENTER);
        textField3.setAlignment(Pos.CENTER);
        textField4.setAlignment(Pos.CENTER);

        //创建两个按钮
        Button button1 = new Button("判断形状");
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
        gridPane.add(label3, 0, 2);
        gridPane.add(textField3, 1, 2);
        gridPane.add(label4, 0, 3);
        gridPane.add(textField4, 1, 3);

        Label title = new Label("请分别输入三个1到200的整数");
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
                a = Integer.parseInt(textField1.getText());
                b = Integer.parseInt(textField2.getText());
                c = Integer.parseInt(textField3.getText());

                if(a >= 1 && a <= 200 && b >= 1 && b <= 200 && c >= 1 && c <= 200){
                    if(a + b > c && a + c > b && b + c > a){
                        if(a == b && a == c){
                            textField4.setText("等边三角形");
                        }
                        else if(a == b || a == c || b == c){
                            textField4.setText("等腰三角形");
                        }
                        else{
                            textField4.setText("一般三角形");
                        }
                    }
                    else{
                        textField4.setText("不能构成三角形");
                    }
                }
                else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("错误提示");
                    alert.setHeaderText(null);
                    alert.setContentText("参数输入非法");
                    alert.showAndWait();
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
        stage.setTitle("三角形");
        stage.show();

    }
}


