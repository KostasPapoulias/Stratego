
package Model;


import Model.Pieces.Board;
import Model.Pieces.MoveAble;
import Model.Pieces.Piece;
import java.util.ArrayList;
import Model.Pieces.Board.*;

public class Army {

    private ArrayList<Piece> piece;
    private ArrayList<Piece> deadPiece;

    /**
     * Initialize two ArrayLists for each player
     * Calls the method createAnArmy
     * @param board
     */

    public Army(Board board){
        piece = new ArrayList<>();
        deadPiece = new ArrayList<>();
        createAnArmy(board);
    }

    /**
     * Creates new Pieces and initializes the board
     * @param board
     */
    private void createAnArmy(Board board){
        int dragon = 1;int mage = 1;int knight = 2;int beastRider = 3;int sorceress = 2;int lavaYeti = 2;int elf = 2;int dwarf = 5;int scout = 4;int slayer = 1;int Trap = 6;int Flag = 1;
        Piece Dragon;Piece Mage;Piece Knight;Piece BeastRider;Piece Sorceress;Piece LavaYeti;Piece Elf;Piece Dwarf;Piece Scout;Piece Slayer;



        Dragon = new MoveAble(10);
        addPiece(Dragon);
        board.fillBoardRed(Dragon,1,1);
        //Board.fillBoardBlue(Dragon, 1,1);

    }

    /**
     * Adds a new piece in the ArrayList piece
     * @param piece
     */
    public void addPiece(Piece piece){
        this.piece.add(piece);
    }

    /**
     * returns a piece from the ArrayList piece
     * @return
     */
    public Piece getPiece(){
        return piece.get(0);
    }

    /**
     *Adds a dead piece in the ArrayList deadPiece when the Piece is now alive
     * @param piece
     */
    public void addDeadPiece(Piece piece){}

    /**
     * return a Piece from the ArrayList deadPiece
     * @return
     */
    public Piece getDeadPieces(){
        return deadPiece.get(0);
    }
    /**
     * return True when there is no Piece in the ArrayList piece
     * @return
     */
    public boolean allDead(){
        return true;
    }
}



