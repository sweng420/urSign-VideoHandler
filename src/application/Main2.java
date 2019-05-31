package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
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
			
			//Root pane
			Pane rootPane = new Pane();
			
			//Video Node
			HBox videoBox = new HBox();
			
			//Initialise scene and add to stage
			Scene scene = new Scene(rootPane,800,600);
			Canvas canvas = new Canvas(250,400);
			
			//State = 0 for singleVideo
			vidplayer  = new Player(canvas,0,0, stage, 0);
			vidplayer.controls.disableButtons(true);
			String [] paths = {"hello.mp4"};

			//Load videos
			vidplayer.loadPaths(paths);
			vidplayer.setMaxHeight(vidplayer.getHeight());
			vidplayer.setMaxWidth(vidplayer.getWidth());
			
			videoBox .getChildren().add(vidplayer);
			
			rootPane.getChildren().add(vidplayer);
			stage.setScene(scene);
			stage.show();
			
			vidplayer.loadVideo(0);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}