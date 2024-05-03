package Controller;
import Model.Pieces.Board;
import Model.Pieces.MoveAble;
import Model.Pieces.Piece;
import Model.Player;
import View.*;
import Model.Turn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Objects;

public class Controller implements MouseListener{

        private Player playerBlue;
        private Player playerRed;
        Graphic graphicButtons;
        Board boardd;
        int coordinationsX;
        int coordinationsY;
        int targetCoordinationsX;
        int targerCoordinationsY;
        int enteredX;
        int enteredY;
        int [][] moves = new int[8][10];
        boolean isClicked = false;
        boolean escape;
        Turn turni;
        boolean bruh = false;
        boolean noBack = false;
        static boolean lessArmy = false;
        float totalAttacksBlue = 0;
        float totalAttacksRed = 0;
        float totalWinAttacksBlue = 0;
        float totalWinAttacksRed = 0;




        /**
         * Controller gets called
         */
        public Controller(Graphic graphic, Board board ){
                graphicButtons = graphic;
                boardd = board;

                playerBlue = new Player("Blue", board, 1, graphic.lessArmy.isSelected());
                playerRed = new Player("Red", board, 2, graphic.lessArmy.isSelected());

                graphic.initializeImages(board, graphic);
                Turn turn = new Turn();
                turni = turn;

                graphicButtons.getPlayersTurn(turn.getTurn());
                graphic.actionPerformed((MouseListener) this);
        }

        /**
         * The game begins
         */
        void battle(){

        }



        /**
         * This method is responsible for the buttons
         */
        public static void buttonControl(){


        }

        /**
         * @param i the row
         * @param j the column
         * saves the current i and j in the place of array that the mouse clicked (first click)
         */
        public void SaveCoordinations(int i, int j){
                coordinationsX = i;
                coordinationsY = j;
        }
        /**
         * @param i the row
         * @param j the column
         * saves the target i and j in the place of array that the mouse clicked (second click)
         */
        public void SaveTargetCoordinations(int i, int j){
                targetCoordinationsX = i;
                targerCoordinationsY = j;
        }
        /**
         * @param i the row
         * @param j the column
         * saves the i and j in the place of array that the mouse entered
         */
        public void SaveEnteredCoordinations(int i, int j){
                enteredX = i;
                enteredY = j;
        }

        /**
         * @param e a button has clicked
         *
         */
        @Override
        public void mouseClicked(MouseEvent e) {
                if(graphicButtons.noRetreat.isSelected())
                        noBack = true;

                if(!graphicButtons.firstButtonStatus()) {
                        //selects first button

                        for (int i = 0; i < 8; i++) {
                                for (int j = 0; j < 10; j++) {
                                        //breaks if a button that shouldn't be clicked is activated
                                        //uses escape variable to break in loops below
                                        if(e.getSource() == graphicButtons.accessToButtons(i, j) && !graphicButtons.getButtonEnable(i ,j)){
                                                escape = true;
                                                break;
                                        }
                                        else
                                                escape = false;
                                        if (e.getSource() == graphicButtons.accessToButtons(i, j)) {
                                                SaveCoordinations(i, j);
                                                moves = boardd.PossibleMoves(i, j, noBack);
                                                isClicked = true;
                                                graphicButtons.firstButtonOn();
                                                graphicButtons.showPossibleMoves(moves);
                                        }
                                }
                                if(escape){
                                        break;
                                }
                        }
                }

                else{
                        //selects second button
                        for (int i = 0; i < 8; i++) {
                                bruh = false;
                                if(escape) {
                                        break;
                                }
                                for (int j = 0; j < 10; j++) {
                                        if (e.getSource() == graphicButtons.accessToButtons(i, j)) {
                                                SaveTargetCoordinations(i, j);
                                                if (moves[i][j] == 1) {
                                                        boardd.movePosition(coordinationsX + 1, coordinationsY + 1, targetCoordinationsX + 1, targerCoordinationsY + 1);
                                                        graphicButtons.switchPlace(coordinationsX, coordinationsY, targetCoordinationsX, targerCoordinationsY, Integer.parseInt(boardd.Board[i+1][j+1]));
                                                }
                                                else if(moves[i][j] == 2){
                                                        informAttacks();
                                                        if(Piece.fight(coordinationsX, coordinationsY, targetCoordinationsX, targerCoordinationsY) == 1){
                                                                graphicButtons.attackerWins(coordinationsX, coordinationsY, targetCoordinationsX, targerCoordinationsY, Integer.parseInt(boardd.Board[i+1][j+1]));
                                                                if(boardd.Board[targetCoordinationsX + 1][targerCoordinationsY + 1].equals("112") || boardd.Board[targetCoordinationsX + 1][targerCoordinationsY + 1].equals("212"))
                                                                        graphicButtons.endGame(i,j);
                                                                boardd.movePosition(coordinationsX + 1, coordinationsY + 1, targetCoordinationsX + 1, targerCoordinationsY + 1);
                                                        }
                                                        else if(Piece.fight(coordinationsX, coordinationsY, targetCoordinationsX, targerCoordinationsY) == 2){
                                                                boardd.deletePiece(coordinationsX, coordinationsY);
                                                                graphicButtons.defencerWins(coordinationsX, coordinationsY);
                                                        }
                                                        else{
                                                                boardd.deletePiece(coordinationsX, coordinationsY);
                                                                boardd.deletePiece(targetCoordinationsX, targerCoordinationsY);
                                                                graphicButtons.drawFight(coordinationsX, coordinationsY, targetCoordinationsX, targerCoordinationsY);
                                                        }
                                                }
                                                else{
                                                        i = 0;
                                                        j = 0;
                                                        bruh = true;
                                                        break;
                                                }
                                                isClicked = false;
                                                graphicButtons.unDoPossibleMoves(moves);
                                                graphicButtons.getPlayersTurn(turni.getTurn());
                                        }
                                        if(bruh)
                                                break;
                                }
                                if(bruh)
                                        break;
                        }
                }
        }

        /**
         * when an attack in taking place this method is responsible to change the percentage of successful attacks for each player
         */
        void informAttacks(){
                float perRed = 0, perBlue = 0;
                if(turni.readTurn() == 1){
                        totalAttacksBlue++;
                        if(Piece.fight(coordinationsX, coordinationsY, targetCoordinationsX, targerCoordinationsY) == 1)
                                totalWinAttacksBlue++;
                }
                else{
                        totalAttacksRed++;
                        if(Piece.fight(coordinationsX, coordinationsY, targetCoordinationsX, targerCoordinationsY) == 1)
                                totalWinAttacksRed++;
                }
                try {
                        perRed = totalWinAttacksRed / totalAttacksRed;
                        perBlue = totalWinAttacksBlue/totalAttacksBlue;
                }
                catch(ArithmeticException e){}

                graphicButtons.informStatistics(perRed, perBlue);
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        /**
         * @param e when the mouse enters a button
         */
        @Override
        public void mouseEntered(MouseEvent e) {

                if(!graphicButtons.firstButtonStatus()){
                        for (int i = 0; i < 8; i++) {
                                for (int j = 0; j < 10; j++) {
                                        if (e.getSource() == graphicButtons.accessToButtons(i, j)) {
                                                SaveEnteredCoordinations(i, j);
                                                moves = boardd.PossibleMoves(i, j, noBack);
                                        }
                                }
                        }
                        if(graphicButtons.getButtonEnable(enteredX, enteredY))
                                graphicButtons.showPossibleMoves(moves);
                }
        }

        /**
         * @param e when the mouse exits from a button
         */
        @Override
        public void mouseExited(MouseEvent e) {
                if(!isClicked) {
                        graphicButtons.unDoPossibleMoves(moves);
                }
        }
}
