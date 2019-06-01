package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import player.Player;

//Single Video for quizzes and slide shows
public class Main2 extends Application {
	
	ComboBox<String> videosList;
	Player vidplayer;
	
	
	public static void main(String[] args) {
		// Notify the program of where to find VLCJ	
        launch(args);
    }

	@Override
	public void start(Stage stage) {		
		try{
			Label top = new Label("top");
			Label bot = new Label("bot");

			//Video Node
			VBox videoBox = new VBox();
			
			//Initialise scene and add to stage
			Scene scene = new Scene(videoBox,800,600);
			Canvas canvas = new Canvas(250,450);
			
			//State = 0 for singleVideo
			vidplayer  = new Player(canvas,0,0, stage, 0);
			vidplayer.controls.disableButtons(true);
			String [] paths = {"hello.mp4"};

			//Load videos
			vidplayer.loadPaths(paths);
			vidplayer.setMaxHeight(canvas.getHeight());
			vidplayer.setMaxWidth(canvas.getWidth());
			
			videoBox.getChildren().add(top);
			videoBox.getChildren().add(vidplayer);
			videoBox.getChildren().add(bot);
			
			stage.setScene(scene);
			stage.show();
			
			vidplayer.loadVideo(0);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}