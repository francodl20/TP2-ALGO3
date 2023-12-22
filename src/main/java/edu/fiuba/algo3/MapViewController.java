package edu.fiuba.algo3;

import java.io.IOException;
//Java
import java.net.URL;
import java.util.ResourceBundle;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Model
import edu.fiuba.algo3.modelo.D6;
import edu.fiuba.algo3.modelo.D10;
import edu.fiuba.algo3.modelo.D20;
import edu.fiuba.algo3.modelo.attributes.Coordinate;
import edu.fiuba.algo3.modelo.board.squares.ISquare;
import edu.fiuba.algo3.modelo.GameController;
import edu.fiuba.algo3.modelo.Gladiator;

//Fxml
import javafx.fxml.Initializable;
import javafx.fxml.FXML;

//Javafx
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class MapViewController implements Initializable{
    
    //Map
    private GameController gameController;
    private Integer mapHeight;
    private Integer mapWidth;
    private LinkedList<ISquare> walkableSquares;
    private List<ImageView> playersAvatars;
    private List<Image> playerPfps;

    private GridPane mapGrid;

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private SplitMenuButton diceButton;

    //PlayGame
    @FXML
    ImageView playerPfp;
    @FXML
    Label moveInfoLabel;
    @FXML
    Label prizeInfoLabel;
    @FXML
    Label obstacleInfoLabel;

    @FXML
    Label nameLabel;
    @FXML
    Label seniorityLabel;
    @FXML
    Label energyLabel;
    @FXML
    Label equipmentLabel;

    @FXML
    private void playWithD6() {
        setPfp();
        gameController.playTurn(new D6());
        setMoveInfo();
        setPrizeInfo();
        setObstacleInfo();

        setStats();
        showMap();
    }

    @FXML
    private void playWithD10() {
        setPfp();
        gameController.playTurn(new D10());
        setMoveInfo();
        setPrizeInfo();
        setObstacleInfo();

        setStats();
        showMap();
    }

    @FXML
    private void playWithD20() {
        setPfp();
        gameController.playTurn(new D20());
        setMoveInfo();
        setPrizeInfo();
        setObstacleInfo();

        setStats();
        showMap();
    }

    @FXML
    private void setD6() {
        diceButton.setText("D6");
        diceButton.setOnAction(event -> {playWithD6();});
    }

    @FXML
    private void setD10() {
        diceButton.setText("D10");
        diceButton.setOnAction(event -> {playWithD10();});
    }

    @FXML
    private void setD20() {
        diceButton.setText("D20");
        diceButton.setOnAction(event -> {playWithD20();});
    }


    //MenuBar
    @FXML
    Menu soundMenu;
    @FXML
    Slider volumeSlider;
    @FXML
    MenuItem playPause;


    @FXML
    private void returnToMenu() throws IOException{
        MenuBarController.returnToMenu();
        GameInfo.resetTurnData();
    }

    @FXML
    private void closeGame() {
        MenuBarController.closeGame();
    }

    @FXML
    private void fullScreen() {
        MenuBarController.fullScreen();
    }

    @FXML
    private void pauseMusic() {
        MenuBarController.pauseMusic();
        playPause.setText("Reproducir música");
        playPause.setOnAction(event -> {playMusic();}); 
    }

    @FXML
    private void playMusic() {
        MenuBarController.playMusic();
        playPause.setText("Pausar música");
        playPause.setOnAction(event -> {pauseMusic();});
    }

    @FXML
    private void help() throws IOException {
        MenuBarController.help();
    }   
    
    @FXML
    private void about() throws IOException {
       MenuBarController.about(); 
    }
    
    //private
    public void setMoveInfo() {
        moveInfoLabel.setText(GameInfo.getMoveInfo());
    }

    public void setPrizeInfo() {
        prizeInfoLabel.setText(GameInfo.getPrizeInfo());
    }

    public void setObstacleInfo() {
        obstacleInfoLabel.setText(GameInfo.getObstacleInfo());
    }

    public void setStats() {
        //setPfp();
        nameLabel.setText(GameInfo.getName());
        seniorityLabel.setText(GameInfo.getSeniority());
        energyLabel.setText(GameInfo.getEnergy());
        equipmentLabel.setText(GameInfo.getEquipment());
    }

    private void setPfp() {
        Integer currentIndex = gameController.getPlayers().indexOf(gameController.getCurrentPlayer());
        playerPfp.setImage(playerPfps.get(currentIndex));
    }

    private void showMap() {
        List<Gladiator> players = gameController.getPlayers();
        Integer mainPlayerPosition = GameInfo.getPosition();

        Image start = new Image("file:src/main/resources/images/startSquare.png");
        Image finish = new Image("file:src/main/resources/images/finishSquare.png");
        Image walkableImage = new Image("file:src/main/resources/images/rockTile.png");
        Image nonWalkableImage = new Image("file:src/main/resources/images/grassTile.png");

        for (int y = 1; y <= mapHeight; y++) {
            for (int x = 1; x <= mapWidth; x++) {
                StackPane cellPane = new StackPane();
                ImageView tile = new ImageView(); 
                tile.setFitWidth(60);
                tile.setFitHeight(60);

                if (isAWalkableSquare(x, y)) {

                    if (x == 1 && y == 7) {
                        tile.setImage(start);
                        cellPane.getChildren().add(tile);
                    } else if (x == 17 && y == 1) {
                        tile.setImage(finish);
                        cellPane.getChildren().add(tile);
                    } else {
                        tile.setImage(walkableImage);
                        cellPane.getChildren().add(tile);
                    }

                    for (int i = 0; i < players.size(); i++) {
                        if (getSquarePosition(x,y) == (players.get(i).getPosition() - 1)) {
                            cellPane.getChildren().add(playersAvatars.get(i));
                        }
                    }
                } else {
                    tile.setImage(nonWalkableImage);
                    cellPane.getChildren().add(tile);
                } 
            
                mapGrid.add(cellPane, x, y);
            }
        }
    }

    private boolean isAWalkableSquare(int x, int y) {
       
        Coordinate targetCoordinate = new Coordinate(x, y);
        boolean isWalkable = false;
       
        for (ISquare square : walkableSquares) {
            if (square.getSquareCoordinate().equals(targetCoordinate)) {
                isWalkable = true;
            }
        }

        return isWalkable;      
    }

    private int getSquarePosition(int x, int y) {
       
        Coordinate targetCoordinate = new Coordinate(x, y);
        int position = -1;
       
        for (int i = 0; i < walkableSquares.size(); i++) {
            if (walkableSquares.get(i).getSquareCoordinate().equals(targetCoordinate)) {
                position = i;
            }
        }

        return position;      
    }

    private void setPlayersAvatars(){

        for (Integer index = 0; index < gameController.getPlayers().size(); index++) {
           playersAvatars.add(playerFactory(index + 1));
        }

    }

    private void setPlayerPfps() {
        for (Integer index = 0; index < gameController.getPlayers().size(); index++) {
           playerPfps.add(pfpFactory(index + 1));
        }
    }

    private ImageView playerFactory(Integer numberOfPlayer){
        
        Map <Integer, ImageView> gladiators = new HashMap<>();

        ImageView firstGladiator = new ImageView("file:src/main/resources/images/gladiator.png");
        firstGladiator.setFitWidth(60);
        firstGladiator.setFitHeight(60);

        ImageView secondGladiator = new ImageView("file:src/main/resources/images/gladiator2.png");
        secondGladiator.setFitWidth(60);
        secondGladiator.setFitHeight(60);

        ImageView thirdGladiator = new ImageView("file:src/main/resources/images/gladiator3.png");
        thirdGladiator.setFitWidth(60);
        thirdGladiator.setFitHeight(60);

        ImageView fourthGladiator = new ImageView("file:src/main/resources/images/gladiator4.png");
        fourthGladiator.setFitWidth(60);
        fourthGladiator.setFitHeight(60);
        
        ImageView fifthGladiator = new ImageView("file:src/main/resources/images/gladiator5.png");
        fifthGladiator.setFitWidth(60);
        fifthGladiator.setFitHeight(60);
        
        ImageView sixthGladiator = new ImageView("file:src/main/resources/images/gladiator6.png");
        sixthGladiator.setFitWidth(60);
        sixthGladiator.setFitHeight(60);

        gladiators.put(1, firstGladiator);
        gladiators.put(2, secondGladiator);
        gladiators.put(3, thirdGladiator);
        gladiators.put(4, fourthGladiator);
        gladiators.put(5, fifthGladiator);
        gladiators.put(6, sixthGladiator);
        
        return  gladiators.get(numberOfPlayer);
    }

    private Image pfpFactory(Integer numberOfPlayer){
        
        Map <Integer, Image> gladiatorPfps = new HashMap<>();

        Image firstGladiator = new Image("file:src/main/resources/images/gladiator1pfp.png");

        Image secondGladiator = new Image("file:src/main/resources/images/gladiator2pfp.png");

        Image thirdGladiator = new Image("file:src/main/resources/images/gladiator3pfp.png");

        Image fourthGladiator = new Image("file:src/main/resources/images/gladiator4pfp.png");

        Image fifthGladiator = new Image("file:src/main/resources/images/gladiator5pfp.png");
        
        Image sixthGladiator = new Image("file:src/main/resources/images/gladiator6pfp.png");

        gladiatorPfps.put(1, firstGladiator);
        gladiatorPfps.put(2, secondGladiator);
        gladiatorPfps.put(3, thirdGladiator);
        gladiatorPfps.put(4, fourthGladiator);
        gladiatorPfps.put(5, fifthGladiator);
        gladiatorPfps.put(6, sixthGladiator);
        
        return  gladiatorPfps.get(numberOfPlayer);
    }

    private void pickRandomPlayer() {
        gameController.pickRandomPlayer(new D6());
        GameInfo.getMoveInfo();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gameController = GameInfo.getGame();

        Coordinate mapSize = gameController.getMapSize();
        mapHeight = mapSize.getYValue();
        mapWidth = mapSize.getXValue();
        walkableSquares = gameController.getSquares();
        playersAvatars = new LinkedList<>();
        playerPfps = new LinkedList<>();

        mapGrid = new GridPane();    
        scrollPane.setContent(mapGrid);

        setPlayersAvatars();
        setPlayerPfps();
        showMap();

        pickRandomPlayer();
        setMoveInfo();
        setStats();
        setPfp();

        MenuBarController.setUp(soundMenu);
        MenuBarController.setUp(volumeSlider);

        GameInfo.getSoundController().setSong("Galactic");
    }

}
