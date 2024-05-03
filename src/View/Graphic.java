package View;

import Controller.Controller;
import Model.Pieces.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Objects;


public class Graphic  {
    JFrame frame;
    JPanel buttonPanel;
    JPanel redWinnerPanel;
    JPanel blueWinnerPanel;
    JLabel finalMessage;
    JPanel scorePanel;
    JLabel statistics;
    JLabel redStatistics;
    JLabel blueStatistics;
    JLabel redScoreFight;
    JLabel blueScoreFight;


    ImageIcon hiddenImageRed = new ImageIcon("src/images/RedPieces/RedHidden.png");
    ImageIcon hiddenImageBlue = new ImageIcon("src/images/BluePieces/blueHidden.png");
    JButton[][] buttons;


    public JCheckBox noRetreat;
    public JCheckBox lessArmy;
    public boolean lessArmy2 = false;

    // which buttons can be selected
    public boolean[][] buttonEnable = new boolean[8][10];
    // when first button is selected
    boolean activated = false;
    // which place according to Board.Board[][] (converted to int) each image is saved
    public String[] imageBoard = new String[213];
    // a Board.Board[][] copy converted to int for the package View to know the position of each Piece
    public String [][] boardCopy = new String[10][12];
    // an array that saves the buttons which was enabled
    public boolean [][] actualEnabledButtons = new boolean [8][10];




    public Graphic(){

        noRetreat = new JCheckBox("Χωρίς υποχώρηση");
        lessArmy = new JCheckBox("Μειωμένος στρατός");

        frame = new JFrame(String.valueOf(new BorderLayout()));
        buttonPanel = new JPanel();

        scorePanel = new JPanel();
        redStatistics = new JLabel("Στατιστικά για την κοκκινη ομαδα:", JLabel.LEFT);
        blueStatistics = new JLabel("Στατιστικά για την μπλε ομαδα:", JLabel.LEFT);
        redScoreFight = new JLabel();
        blueScoreFight = new JLabel();

        redWinnerPanel = new JPanel(new BorderLayout());
        blueWinnerPanel = new JPanel(new BorderLayout());
        redWinnerPanel.setVisible(false);
        blueWinnerPanel.setVisible(false);

        redStatistics.setFont(new Font("Serif", Font.PLAIN, 25));
        blueStatistics.setFont(new Font("Serif", Font.PLAIN, 25));

        buttonPanel.setLayout(new GridLayout(8,10));

        //scorePanel.setBounds(1500, 50, 1750, 1000);
        scorePanel.setLayout(new BoxLayout(scorePanel, BoxLayout.Y_AXIS));

        //redStatistics.setBounds(1500, 1000, 1750, 1040);
        scorePanel.add(lessArmy);
        scorePanel.add(noRetreat);
        scorePanel.add(redStatistics);
        scorePanel.add(redScoreFight);
        scorePanel.add(blueStatistics);
        scorePanel.add(blueScoreFight);


        buttons = new JButton[8][10];
        createButtons();

        frame.setSize(1750,1040);
        frame.add(buttonPanel, BorderLayout.WEST);
        frame.add(scorePanel, BorderLayout.EAST);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Stratego");
        frame.setVisible(true);

        //lessArmy.addActionListener(this);


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /*@Override
    public void actionPerformed(ActionEvent e) {
        lessArmy2 = true;
        Controller c = new Controller(this, new Board());
    }

     */


    /**
     * @param board to have access to the Board class
     * @param graphic in order to have access to Graphic class
     * initialises each button with images
     * stores the images in imageBoard
     * creates a clone of Board array to boardCopy
     * disables a button if needed via ButtonEnable to false
     */
    public void initializeImages(Board board, Graphic graphic){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 10; j++){
                if(Objects.equals(board.Board[i + 1][j + 1], "11")){
                    graphic.accessToButtons(i,j).setIcon(new ImageIcon("src/images/BluePieces/slayerB.png"));
                    graphic.imageBoard[Integer.parseInt(board.Board[i+1][j+1])] = "src/images/BluePieces/slayerB.png";
                    graphic.boardCopy[i][j] = board.Board[i+1][j+1];
                }
                if(Objects.equals(board.Board[i + 1][j + 1], "12")){
                    graphic.accessToButtons(i,j).setIcon(new ImageIcon("src/images/BluePieces/scoutB.png"));
                    graphic.imageBoard[Integer.parseInt(board.Board[i+1][j+1])] = "src/images/BluePieces/scoutB.png";
                    graphic.boardCopy[i][j] = board.Board[i+1][j+1];
                }
                if(Objects.equals(board.Board[i + 1][j + 1], "13")){
                    graphic.accessToButtons(i,j).setIcon(new ImageIcon("src/images/BluePieces/dwarfB.png"));
                    graphic.imageBoard[Integer.parseInt(board.Board[i+1][j+1])] = "src/images/BluePieces/dwarfB.png";
                    graphic.boardCopy[i][j] = board.Board[i+1][j+1];
                }
                if(Objects.equals(board.Board[i + 1][j + 1], "14")){
                    graphic.accessToButtons(i,j).setIcon(new ImageIcon("src/images/BluePieces/elfB.png"));
                    graphic.imageBoard[Integer.parseInt(board.Board[i+1][j+1])] = "src/images/BluePieces/elfB.png";
                    graphic.boardCopy[i][j] = board.Board[i+1][j+1];
                }
                if(Objects.equals(board.Board[i + 1][j + 1], "15")){
                    graphic.accessToButtons(i,j).setIcon(new ImageIcon("src/images/BluePieces/yeti.png"));
                    graphic.imageBoard[Integer.parseInt(board.Board[i+1][j+1])] = "src/images/BluePieces/yeti.png";
                    graphic.boardCopy[i][j] = board.Board[i+1][j+1];
                }
                if(Objects.equals(board.Board[i + 1][j + 1], "16")){
                    graphic.accessToButtons(i,j).setIcon(new ImageIcon("src/images/BluePieces/sorceressB.png"));
                    graphic.imageBoard[Integer.parseInt(board.Board[i+1][j+1])] = "src/images/BluePieces/sorceressB.png";
                    graphic.boardCopy[i][j] = board.Board[i+1][j+1];
                }
                if(Objects.equals(board.Board[i + 1][j + 1], "17")){
                    graphic.accessToButtons(i,j).setIcon(new ImageIcon("src/images/BluePieces/beastRiderB.png"));
                    graphic.imageBoard[Integer.parseInt(board.Board[i+1][j+1])] = "src/images/BluePieces/beastRiderB.png";
                    graphic.boardCopy[i][j] = board.Board[i+1][j+1];
                }
                if(Objects.equals(board.Board[i + 1][j + 1], "18")){
                    graphic.accessToButtons(i,j).setIcon(new ImageIcon("src/images/BluePieces/knightB.png"));
                    graphic.imageBoard[Integer.parseInt(board.Board[i+1][j+1])] = "src/images/BluePieces/knightB.png";
                    graphic.boardCopy[i][j] = board.Board[i+1][j+1];
                }
                if(Objects.equals(board.Board[i + 1][j + 1], "19")){
                    graphic.accessToButtons(i,j).setIcon(new ImageIcon("src/images/BluePieces/mageB.png"));
                    graphic.imageBoard[Integer.parseInt(board.Board[i+1][j+1])] = "src/images/BluePieces/mageB.png";
                    graphic.boardCopy[i][j] = board.Board[i+1][j+1];
                }
                if(Objects.equals(board.Board[i + 1][j + 1], "110")){
                    graphic.accessToButtons(i,j).setIcon(new ImageIcon("src/images/BluePieces/dragonB.png"));
                    graphic.imageBoard[Integer.parseInt(board.Board[i+1][j+1])] = "..\\images\\BluePieces\\dragonB.png";
                    graphic.boardCopy[i][j] = board.Board[i+1][j+1];
                }
                if(Objects.equals(board.Board[i + 1][j + 1], "111")){
                    graphic.accessToButtons(i,j).setIcon(new ImageIcon("src/images/BluePieces/trapB.png"));
                    graphic.imageBoard[Integer.parseInt(board.Board[i+1][j+1])] = "src/images/BluePieces/trapB.png";
                    graphic.ButtonEnable(i, j, false);
                    graphic.boardCopy[i][j] = board.Board[i+1][j+1];
                }
                if(Objects.equals(board.Board[i + 1][j + 1], "112")){
                    graphic.accessToButtons(i,j).setIcon(new ImageIcon("src/images/BluePieces/flagB.png"));
                    graphic.imageBoard[Integer.parseInt(board.Board[i+1][j+1])] = "src/images/BluePieces/flagB.png";
                    graphic.ButtonEnable(i, j, false);
                    graphic.boardCopy[i][j] = board.Board[i+1][j+1];
                }
                if(Objects.equals(board.Board[i + 1][j + 1], "21")){
                    graphic.accessToButtons(i,j).setIcon(new ImageIcon("src/images/BluePieces/slayerR.png"));
                    graphic.imageBoard[Integer.parseInt(board.Board[i+1][j+1])] = "src/images/BluePieces/slayerR.png";
                    graphic.boardCopy[i][j] = board.Board[i+1][j+1];
                }
                if(Objects.equals(board.Board[i + 1][j + 1], "22")){
                    graphic.accessToButtons(i,j).setIcon(new ImageIcon("src/images/RedPieces/scoutB.png"));
                    graphic.imageBoard[Integer.parseInt(board.Board[i+1][j+1])] = "src/images/RedPieces/scoutB.png";
                    graphic.boardCopy[i][j] = board.Board[i+1][j+1];
                }
                if(Objects.equals(board.Board[i + 1][j + 1], "23")){
                    graphic.accessToButtons(i,j).setIcon(new ImageIcon("src/images/RedPieces/dwarfR.png"));
                    graphic.imageBoard[Integer.parseInt(board.Board[i+1][j+1])] = "src/images/RedPieces/dwarfR.png";
                    graphic.boardCopy[i][j] = board.Board[i+1][j+1];
                }
                if(Objects.equals(board.Board[i + 1][j + 1], "24")){
                    graphic.accessToButtons(i,j).setIcon(new ImageIcon("src/images/RedPieces/elfR.png"));
                    graphic.imageBoard[Integer.parseInt(board.Board[i+1][j+1])] = "src/images/RedPieces/elfR.png";
                    graphic.boardCopy[i][j] = board.Board[i+1][j+1];
                }
                if(Objects.equals(board.Board[i + 1][j + 1], "25")){
                    graphic.accessToButtons(i,j).setIcon(new ImageIcon("src/images/RedPieces/lavaBeast.png"));
                    graphic.imageBoard[Integer.parseInt(board.Board[i+1][j+1])] = "src/images/RedPieces/lavaBeast.png";
                    graphic.boardCopy[i][j] = board.Board[i+1][j+1];
                }
                if(Objects.equals(board.Board[i + 1][j + 1], "26")){
                    graphic.accessToButtons(i,j).setIcon(new ImageIcon("src/images/RedPieces/sorceressR.png"));
                    graphic.imageBoard[Integer.parseInt(board.Board[i+1][j+1])] = "src/images/RedPieces/sorceressR.png";
                    graphic.boardCopy[i][j] = board.Board[i+1][j+1];
                }
                if(Objects.equals(board.Board[i + 1][j + 1], "27")){
                    graphic.accessToButtons(i,j).setIcon(new ImageIcon("src/images/RedPieces/beastRiderR.png"));
                    graphic.imageBoard[Integer.parseInt(board.Board[i+1][j+1])] = "src/images/RedPieces/beastRiderR.png";
                    graphic.boardCopy[i][j] = board.Board[i+1][j+1];
                }
                if(Objects.equals(board.Board[i + 1][j + 1], "28")){
                    graphic.accessToButtons(i,j).setIcon(new ImageIcon("src/images/RedPieces/knightR.png"));
                    graphic.imageBoard[Integer.parseInt(board.Board[i+1][j+1])] = "src/images/RedPieces/knightR.png";
                    graphic.boardCopy[i][j] = board.Board[i+1][j+1];
                }
                if(Objects.equals(board.Board[i + 1][j + 1], "29")){
                    graphic.accessToButtons(i,j).setIcon(new ImageIcon("src/images/RedPieces/mageR.png"));
                    graphic.imageBoard[Integer.parseInt(board.Board[i+1][j+1])] = "src/images/RedPieces/mageR.png";
                    graphic.boardCopy[i][j] = board.Board[i+1][j+1];
                }
                if(Objects.equals(board.Board[i + 1][j + 1], "210")){
                    graphic.accessToButtons(i,j).setIcon(new ImageIcon("src/images/RedPieces/dragonR.png"));
                    graphic.imageBoard[Integer.parseInt(board.Board[i+1][j+1])] = "src/images/RedPieces/dragonR.png";
                    graphic.boardCopy[i][j] = board.Board[i+1][j+1];
                }
                if(Objects.equals(board.Board[i + 1][j + 1], "211")){
                    graphic.accessToButtons(i,j).setIcon(new ImageIcon("src/images/RedPieces/trapR.png"));
                    graphic.imageBoard[Integer.parseInt(board.Board[i+1][j+1])] = "src/images/RedPieces/trapR.png";
                    graphic.ButtonEnable(i, j, false);
                    graphic.boardCopy[i][j] = board.Board[i+1][j+1];
                }
                if(Objects.equals(board.Board[i + 1][j + 1], "212")){
                    graphic.accessToButtons(i,j).setIcon(new ImageIcon("src/images/RedPieces/flagR.png"));
                    graphic.imageBoard[Integer.parseInt(board.Board[i+1][j+1])] = "src/images/RedPieces/flagR.png";
                    graphic.ButtonEnable(i, j, false);
                    graphic.boardCopy[i][j] = board.Board[i+1][j+1];
                }
            }
        }
    }


    /**
     * @param i
     * @param j
     * Gets parameters i, j in order to take the value of boardCopy and see which team won
     * Creates and sets visible final frame that advertise the end of the game and the team that won
     */
    public void endGame(int i,int j){

        if(boardCopy[i][j].charAt(0) == '2'){
            finalMessage = new JLabel("RED WON");
            finalMessage.setFont(new Font("Serif", Font.PLAIN, 40));
            redWinnerPanel.add(finalMessage, BorderLayout.CENTER);
            redWinnerPanel.setBackground(Color.RED);
            buttonPanel.setVisible(false);
            redWinnerPanel.setVisible(true);
            frame.add(redWinnerPanel);
        }
        else if(boardCopy[i][j].charAt(0) == '1'){
            finalMessage = new JLabel("BLUE WON");
           // finalMessage.setBounds(50, 50, 600, 300);
            finalMessage.setFont(new Font("Serif", Font.PLAIN, 40));
            blueWinnerPanel.add(finalMessage, BorderLayout.CENTER);
            blueWinnerPanel.setBackground(Color.BLUE);
            buttonPanel.setVisible(false);

            blueWinnerPanel.setVisible(true);
            frame.add(blueWinnerPanel);
        }
    }

    /**
     * @param forRed is the percentage of successful attacks for team red
     * @param forBlue is the percentage of successful attacks for team blue
     */
    public void informStatistics(float forRed, float forBlue){
        redScoreFight.setText("Ποσοστό επιτυχημένων επιθεσεων: "+forRed+ "%");
        blueScoreFight.setText("Ποσοστό επιτυχημένων επιθεσεων: "+forBlue+ "%");
    }

    /**
     * @param e
     * precondition : mouse clicked or entered a button
     */
    public void actionPerformed(MouseListener e) {
        for(int i = 0; i < 8; i++){
            for(int j = 0; j< 10; j++){
                buttons[i][j].addMouseListener(e);
            }
        }
    }

    /**
     * @param turn is a number 1 or 2
     * preconditions turn is 1 or 2
     * hid or reveals cards of each team
     */
    public void getPlayersTurn(int turn){
        if(turn == 1){

            for(int i = 0; i < 8; i++) {
                for (int j = 0; j < 10; j++) {
                    if(boardCopy[i][j] != null) {
                        if (boardCopy[i][j].charAt(0) == '2' && boardCopy[i][j] != null) {
                            buttonEnable[i][j] = false;
                            buttons[i][j].setIcon(hiddenImageRed);
                        } else if (boardCopy[i][j].charAt(0) == '1' && boardCopy[i][j] != null) {
                            buttonEnable[i][j] = actualEnabledButtons[i][j];
                            buttons[i][j].setIcon(new ImageIcon(imageBoard[Integer.parseInt(boardCopy[i][j])]));
                        }
                    }
                }
            }
        }else{
            for(int i = 0; i < 8; i++) {
                for (int j = 0; j < 10; j++) {
                    if(boardCopy[i][j] != null) {
                        if (boardCopy[i][j].charAt(0) == '1' && boardCopy[i][j] != null) {
                            buttonEnable[i][j] = false;
                            buttons[i][j].setIcon(hiddenImageBlue);
                        } else if (boardCopy[i][j].charAt(0) == '2' && boardCopy[i][j] != null) {
                            buttonEnable[i][j] = actualEnabledButtons[i][j];
                            buttons[i][j].setIcon(new ImageIcon(imageBoard[Integer.parseInt(boardCopy[i][j])]));
                        }
                    }
                }
            }
        }
    }

    /**
     * @param i
     * @param j
     * @param on gets the value true or false
     * enables or disables buttons
     */
    public void ButtonEnable(int i, int j, boolean on){
        actualEnabledButtons[i][j] = on;
    }
    /**
     * makes activated true when button is clicked for the first time when a player has turn
     */
    public void firstButtonOn(){
        activated = true;
    }
    /**
     * activated is false meaning seconding button is clicked and the other player has turn
     */
    public void firstButtonOff(){
        activated = false;
    }
    /**
     * @return if activated is true or false
     */
    public boolean firstButtonStatus(){
        return activated;
    }
    /**
     * @param i
     * @param j
     * @return true if the button can be clicked or entered by the mouse and it's valid to make an action
     */
    public boolean getButtonEnable(int i, int j){
        return buttonEnable[i][j];
    }

    /**
     * @param coordinationsX position current's button in rows
     * @param coordinationsY position current's button in columns
     * @param targetCoordinationsX position target's button in rows
     * @param targerCoordinationsY position target's button in columns
     * @param positionForBoard is a value that is used to ImageBoard where the images are stored
     * calls moveButton, ButtonEnable and firstButtonOff
     * it's responsible for moving buttons in free spaces
     */
    public void switchPlace(int coordinationsX, int coordinationsY, int targetCoordinationsX, int targerCoordinationsY, int positionForBoard){
        moveButtons(coordinationsX, coordinationsY, targetCoordinationsX, targerCoordinationsY, positionForBoard);
        ButtonEnable(coordinationsX, coordinationsY, false);
        ButtonEnable(targetCoordinationsX, targerCoordinationsY, true);
        firstButtonOff();
    }
    /**
     * @param coordinationsX position current's button in rows
     * @param coordinationsY position current's button in columns
     * @param targetCoordinationsX position target's button in rows
     * @param targerCoordinationsY position target's button in columns
     * @param positionForImageBoard is a value that is used to ImageBoard where the images are stored
     * calls moveButton, ButtonEnable and firstButtonOff
     * it's responsible for moving buttons in enemy's place
     */
    public void attackerWins(int coordinationsX, int coordinationsY, int targetCoordinationsX, int targerCoordinationsY, int positionForImageBoard){
        moveButtons(coordinationsX, coordinationsY, targetCoordinationsX, targerCoordinationsY, positionForImageBoard);
        ButtonEnable(coordinationsX, coordinationsY, false);
        ButtonEnable(targetCoordinationsX, targerCoordinationsY, true);
        firstButtonOff();
    }
    /**
     * @param coordinationsX position current's button in rows
     * @param coordinationsY position current's button in columns
     * calls deleteButton, firstButtonOff and ButtonEnable
     * it's responsible for deleting attacker's button when is defeated
     */
    public void defencerWins(int coordinationsX, int coordinationsY){
        deleteButton(coordinationsX, coordinationsY);
        ButtonEnable(coordinationsX, coordinationsY, false);
        firstButtonOff();
    }
    /**
     * @param coordinationsX position current's button in rows
     * @param coordinationsY position current's button in columns
     * @param targetCoordinationsX position target's button in rows
     * @param targerCoordinationsY position target's button in columns
     * calls deleteButton, ButtonEnable and firstButtonOff
     * it's responsible for deleting both team's buttons when the attacker and defender are equal
     */
    public void drawFight(int coordinationsX, int coordinationsY, int targetCoordinationsX, int targerCoordinationsY){
        deleteButton(coordinationsX, coordinationsY);
        deleteButton(targetCoordinationsX, targerCoordinationsY);
        ButtonEnable(coordinationsX, coordinationsY, false);
        ButtonEnable(targetCoordinationsX, targerCoordinationsY, false);
        firstButtonOff();
    }

    /**
     * @param moves is an array that contains 0, 1, 2
     * it's responsible for reading the moves and showing the buttons where the current button can move giving colour to possible moves, red for attacking a button and green for moving in free space
     */
    public void showPossibleMoves(int[][] moves){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                if (moves[i][j] == 2)
                    buttons[i][j].setBackground(Color.RED);
                else if (moves[i][j] == 1)
                    buttons[i][j].setBackground(Color.GREEN);
            }
        }
    }
    /**
     * @param moves is an array that contains 0, 1, 2
     * it's responsible for erasing any coloured button back to white
     */
    public void unDoPossibleMoves(int[][] moves){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                if (moves[i][j] == 1 || moves[i][j] == 2)
                    buttons[i][j].setBackground(Color.WHITE);
            }
        }
    }

    /**
     * @param positionI position current's button in rows
     * @param positionY position current's button in columns
     * initialises the button in position positionI and positionY
     */
    public void deleteButton(int positionI, int positionY){
        buttons[positionI][positionY].setIcon(null);
        buttons[positionI][positionY].setBackground(Color.WHITE);
        boardCopy[positionI][positionY] = "0";
    }
    /**
     * @param positionI position current's button in rows
     * @param positionJ position current's button in columns
     * @param newPositionI position target's button in rows
     * @param newPositionJ position target's button in columns
     * @param imagePosition is a value that is used to ImageBoard where the images are stored
     * it's responsible for transferring button from positionI and positionJ to newPositionI and newPositionJ
     * calls deleteButton
     */
    public void moveButtons(int positionI, int positionJ, int newPositionI, int newPositionJ, int imagePosition){
        buttons[newPositionI][newPositionJ].setIcon(new ImageIcon(imageBoard[imagePosition]));
        boardCopy[newPositionI][newPositionJ] = boardCopy[positionI][positionJ];
        deleteButton(positionI, positionJ);
    }

    /**
     * @param i is the row
     * @param j is the column
     * @return the value of the array buttons in the i and j place
     */
    public JButton accessToButtons(int i,int j){
        return buttons[i][j];
    }

    /**
     * initialises the array of buttons
     */
    void createButtons(){
        for(int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                buttons[i][j] = new JButton();
                buttonPanel.add(buttons[i][j]);
                buttons[i][j].setBackground(Color.WHITE);

                actualEnabledButtons[i][j] = true;
                buttonEnable[i][j] = true;

                if((i == 3||i == 4) && (j == 2||j == 3||j == 6||j == 7)) {

                    buttons[i][j].setBackground(Color.YELLOW);
                    buttons[i][j].setEnabled(false);
                    buttons[i][j].setBorderPainted(false);
                    actualEnabledButtons[i][j] = false;
                    buttonEnable[i][j] = false;
                }
                if(i>2 && i<5) {
                    ButtonEnable(i, j, false);
                    buttonEnable[i][j] = false;
                }
            }
        }
    }
}

