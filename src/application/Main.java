package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application {

Button[][] matrix; //names the grid of buttons

@Override
public void start(Stage primaryStage) {

    int length = 4;
    int width = 4;
    int count = 7;
    
    StackPane rootPane = new StackPane();
    
    GridPane grid1 = new GridPane();
    Canvas canvas = new Canvas(480, 240);
    
    BorderPane firstRoot = new BorderPane();
    
    Label label = new Label("1,478");
    label.setFont(Font.font ("nyala", 120));
    label.setStyle("-fx-text-fill: white;");

    matrix = new Button[width][length]; 
    
    VBox vBox = new VBox();
    vBox.setPrefWidth(120);
    vBox.setPrefHeight(120);
    
    for (int x = 0; x < 3; x++) {
    	int y = 0;
    	matrix[x][y] = new Button();
        matrix[x][y].setFont(Font.font ("nyala", 50));
    	if (x == 0) {
    		matrix[x][y].setText("C");
            grid1.add(matrix[x][y], x, y);
    	}
    	else if (x == 1) {
    		matrix[x][y].setText("±");
            grid1.add(matrix[x][y], x, y);
    	}
    	else {
    		matrix[x][y].setText("%");
            grid1.add(matrix[x][y], x, y);
    	}
    	matrix[x][y].setMinWidth(vBox.getPrefWidth());
    	matrix[x][y].setMinHeight(vBox.getPrefHeight());
    }
    
    for (int y = 0; y < 4; y++){
    	int x = 3;
    	matrix[x][y] = new Button(); 
        matrix[x][y].setFont(Font.font ("nyala", 50));
        matrix[x][y].setStyle("-fx-base: #F99212; -fx-text-fill: white;");
        if (y == 0) {
        	matrix[x][y].setText("/");
        	grid1.add(matrix[x][y], x, y);
        }
        else if (y == 1) {
        	matrix[x][y].setText("x");
        	grid1.add(matrix[x][y], x, y);
        }
        else if (y == 2) {
        	matrix[x][y].setText("-");
        	grid1.add(matrix[x][y], x, y);
        }
        else {
        	matrix[x][y].setText("+");
        	grid1.add(matrix[x][y], x, y);
        }
        matrix[x][y].setMinWidth(vBox.getPrefWidth());
    	matrix[x][y].setMinHeight(vBox.getPrefHeight());
    }
    for(int y = 1; y < 4; y++) {
        for(int x = 0; x < 3; x++)
        {
        	matrix[x][y] = new Button(); 
            matrix[x][y].setFont(Font.font ("nyala", 50));
        	if (x == 3){
            	matrix[x][y].setStyle("-fx-base: #F99212; -fx-text-fill: white;");
            } else {
            	matrix[x][y].setText(Integer.toString(count));
                count += 1;
            }

            grid1.add(matrix[x][y], x, y);
            matrix[x][y].setMinWidth(vBox.getPrefWidth());
        	matrix[x][y].setMinHeight(vBox.getPrefHeight());

        } 
        count -= 6;
    }
    GridPane grid2 = new GridPane();
    Button[] buttonArray;
    buttonArray = new Button[3];
    
    VBox vBox0 = new VBox();
    vBox0.setPrefWidth(240);
    vBox0.setPrefHeight(120);
    
	for (int x = 0; x < 3; x++) {
		buttonArray[x] = new Button(); 
		buttonArray[x].setFont(Font.font ("nyala", 50));
        
        if (x == 0) {
        	buttonArray[x].setText("0       ");
        	buttonArray[x].setMinWidth(vBox0.getPrefWidth());
        	buttonArray[x].setMinHeight(vBox0.getPrefHeight());
        	grid2.add(buttonArray[x], x, 0);
        } else if (x == 1) {
        	buttonArray[x].setText(".");
        	buttonArray[x].setMinWidth(vBox.getPrefWidth());
        	buttonArray[x].setMinHeight(vBox.getPrefHeight());
        	grid2.add(buttonArray[x], x, 0);
        } else if (x == 2) {
        	buttonArray[x].setText("=");
        	buttonArray[x].setStyle("-fx-base: #F99212; -fx-text-fill: white;");
        	buttonArray[x].setMinWidth(vBox.getPrefWidth());
        	buttonArray[x].setMinHeight(vBox.getPrefHeight());
        	grid2.add(buttonArray[x], x, 0);
        }
	}
	
	grid2.setTranslateY(720);
    
    GraphicsContext gc = canvas.getGraphicsContext2D();
    gc.setFill(Color.BLACK);
    gc.fillRect(0, 0, 480, 240);
    firstRoot.getChildren().add(canvas);
    grid1.setTranslateY(240);
    label.setTranslateY(-250);
    label.setTranslateX(50);
    firstRoot.setTop(label);
    rootPane.getChildren().addAll(firstRoot, grid1, grid2, label);
    Scene scene = new Scene(rootPane, 480, 840);

    primaryStage.setTitle("Calculator");
    primaryStage.setScene(scene);
    primaryStage.show();
}

}