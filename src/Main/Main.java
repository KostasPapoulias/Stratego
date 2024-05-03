package Main;

import Model.Pieces.Board;
import View.Graphic;
import Controller.Controller;

/**
 * The method main calls the Graphic constructor to create the frame where the game will be
 */

public class Main {
    public static void main(String[] args){

        Graphic graphic = new Graphic();
        Board board = new Board();

        new Controller(graphic, board);
    }
}
