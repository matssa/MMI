package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {

Button[][] matrix; //names the grid of buttons

@Override
public void start(Stage primaryStage) {

    int length = 5;
    int width = 4;
    int count = 7;
    int charCount = 0;
    String operators = "="; 
    
    StackPane rootPane = new StackPane();
    
    GridPane root = new GridPane();
    Canvas canvas = new Canvas(615, 270);
    
    BorderPane firstRoot = new BorderPane();
    
    Label label = new Label("1,478");
    label.setFont(Font.font ("nyala", 140));
    label.setStyle("-fx-text-fill: white;");

    matrix = new Button[width][length]; 
    
    for (int x = 0; x < 3; x++) {
    	int y = 0;
    	matrix[x][y] = new Button(); 
        matrix[x][y].setFont(Font.font ("nyala", 70));
    	if (x == 0) {
    		matrix[x][y].setText("C");
            root.add(matrix[x][y], x, y);
    	}
    	else if (x == 1) {
    		matrix[x][y].setText("±");
            root.add(matrix[x][y], x, y);
    	}
    	else {
    		matrix[x][y].setText("%");
            root.add(matrix[x][y], x, y);
    	}
    }
    
    for (int y = 0; y < 4; y++){
    	int x = 3;
    	matrix[x][y] = new Button(); 
        matrix[x][y].setFont(Font.font ("nyala", 70));
        matrix[x][y].setStyle("-fx-base: #F99212; -fx-text-fill: white;");
        if (y == 0) {
        	matrix[x][y].setText("÷");
        	root.add(matrix[x][y], x, y);
        }
        else if (y == 1) {
        	matrix[x][y].setText("×");
        	root.add(matrix[x][y], x, y);
        }
        else if (y == 2) {
        	matrix[x][y].setText("–");
        	root.add(matrix[x][y], x, y);
        }
        else {
        	matrix[x][y].setText("+");
        	root.add(matrix[x][y], x, y);
        }
    }
    
    for(int y = 1; y < 5; y++) {
    	if (y == 4){
    		for (int x = 0; x < 3; x++) {
    			matrix[x][y] = new Button(); 
                matrix[x][y].setFont(Font.font ("nyala", 70));
                
                if (x == 0) {
                	matrix[x][y].setText("0");
                	root.add(matrix[x][y], x, y);
                } else if (x == 1) {
                	matrix[x][y].setText(".");
                	root.add(matrix[x][y], x, y);
                } else if (x == 2) {
                	matrix[x][y].setText("=");
                	matrix[x][y].setStyle("-fx-base: #F99212; -fx-text-fill: white;");
                	
                	root.add(matrix[x][y], x, y);
                }
    		}
    		
    	} else {
	            for(int x = 0; x < 3; x++)
	            {
	            	matrix[x][y] = new Button(); 
	                matrix[x][y].setFont(Font.font ("nyala", 70));
	            	if (x == 3){
	                	matrix[x][y].setStyle("-fx-base: #F99212; -fx-text-fill: white;");
	                } else {
	                	matrix[x][y].setText(Integer.toString(count));
	                    count += 1;
	                }
	
	                root.add(matrix[x][y], x, y);
	
	            } 
	            count -= 6;
    		}
    }      
    
    
    GraphicsContext gc = canvas.getGraphicsContext2D();
    gc.setFill(Color.BLACK);
    gc.fillRect(0, 0, 615, 500);
    firstRoot.getChildren().add(canvas);
    root.setTranslateY(270);
    label.setTranslateY(-330);
    label.setTranslateX(115);
    firstRoot.setTop(label);
    rootPane.getChildren().addAll(firstRoot, root, label);
    Scene scene = new Scene(rootPane, 615, 1040);

    primaryStage.setTitle("Calculator");
    primaryStage.setScene(scene);
    primaryStage.show();
}

}