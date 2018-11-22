package Pontoop;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application{
	
	private Stage window;
	private Button button1;
	private Scene gameScene;
	private Button yesButton;
	private Button noButton;
	private VBox topSection;
	private HBox bottomSection;
	private Image cardImg;
	private ImageView viewImg;
	private BorderPane borderPane;
	private Game pontoonGame;
	private GameTracker tracker;
	
	public static void main(String [] args) {
		launch(args);
	}
	
	/*
	 * Overrides start method from Application (application is abstract)
	 * This is being used to set up the window initially, and run the gui
	 * along with the game itself
	*/
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		window = primaryStage;
		window.setTitle("Pontoop");
		yesButton = new Button("Yes");		//Set up yes and no buttons for future use throughout program
		noButton = new Button("No");
		pontoonGame = new Game();			//create (first) game to run behind the scenes
		tracker = new GameTracker();		//create game tracker to track results
		
		gameUI();							//run the basic game screen for the first time
		window.show();						//Opens the window 
	}
	
	//This runs a basic UI to display the users hand and ask if they want another card
	public void gameUI() {
		if(pontoonGame.getUser().getHandValue() < 21) {					//if the user isn't already equal to or above 21
			
			Text content = new Text(pontoonGame.getUser().displayNewCard() + "\n\nDraw another card?\n");		// gets the hand value
			//cardImg = new Image(pontoonGame.getUser().getImg());
			cardImg = new Image(getClass().getResource(pontoonGame.getUser().getImg()).toString());
			viewImg = new ImageView(cardImg);
			viewImg.setFitWidth(100);
			viewImg.setPreserveRatio(true);
			
			yesButton.setOnAction(e -> {
				pontoonGame.giveCard();				//if user wants another card, give them another card
				resetUI();							//Reset the UI to refresh the hand value (set all objects to new)
				gameUI();							//re-run the game UI with new objects (albeit same references)
				});
			
			noButton.setOnAction(e -> {				//(Remember - e -> is shortcut for eventHandler class)
				pontoonGame.decideResult();			//if user doesn't want another card, decide the result
				gameEndUI();						//then run the end of game UI which will display results of that game
			});
	
			resetUI();								//(reset simply sets member variable objects to new objects)
			
			topSection.getChildren().addAll(content, viewImg);				//Add content to top layout
			bottomSection.getChildren().addAll(yesButton,noButton);			//add buttons to bottom layout
			
			borderPane.setTop(topSection);									//adds content (above ^) to borderpane layout 
			borderPane.setBottom(bottomSection);							//adds buttons (above ^) to borderpane layout
			
			gameScene = new Scene(borderPane, 300, 300);						//adds borderpane layout to the scene + window dimensions 
			window.setScene(gameScene);											//Set the window to display that scene
			
		}else {																//if the user has 21 or is above 21
			pontoonGame.decideResult();										
			gameEndUI();													//swap the UI to show the results
		}
	}
	
	//Displays the results of a game that has just been played
	public void gameEndUI() {
		tracker.addResult(pontoonGame.getResult());							//send the results to game tracker to store for later
		
		Text userResult = new Text("Your hand was " + pontoonGame.getUser().getHandValue());
		Text dealerResult = new Text("The dealer's hand was " + pontoonGame.getDealer().getHandValue());
		Text gameResult = new Text("You " + pontoonGame.getResult() + "\n\nPlay Again?");
		
		yesButton.setOnAction(e -> {
			resetGame();							//if the user wants to play again then make game = new game to reset the game
			gameUI();								//go back to the game interface
		});
		noButton.setOnAction(e -> finalUI());		//if they dont want to play again, 
		
		resetUI();									
		
		//See this section explained in above method - approach is very similar
		topSection.getChildren().addAll(userResult,dealerResult,gameResult);
		bottomSection.getChildren().addAll(yesButton,noButton);
		borderPane.setTop(topSection);
		borderPane.setBottom(bottomSection);
		
		gameScene = new Scene(borderPane,300,300);
		window.setScene(gameScene);
	}
	
	//displays the final results of all games played 
	public void finalUI() {
		Text finalResult = new Text(tracker.showResults()); //displays a large string from showResults method
		
		//See start method for layout explanation
		VBox results = new VBox();
		results.setAlignment(Pos.CENTER);
		results.getChildren().add(finalResult);
		gameScene = new Scene(results,300,300);
		window.setScene(gameScene);
	}
	
	//creates new instances for layout VBox, HBox and borderpane 
	public void resetUI() {
		topSection = new VBox();
		topSection.setAlignment(Pos.CENTER);
		bottomSection = new HBox();
		bottomSection.setAlignment(Pos.CENTER);
		borderPane = new BorderPane();
	}
	
	//Creates a new instance of the game
	public void resetGame() {
		pontoonGame = new Game();
	}
 
	




}
