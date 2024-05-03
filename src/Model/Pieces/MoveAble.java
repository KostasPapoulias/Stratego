package Model.Pieces;

import Model.Pieces.Piece;

public class MoveAble extends Piece {
    /**
     * Gets the tier of the Piece
     * calls the Piece constructor and sets the tier, move ability to true and special to false
     * @param tier 4, 5, 6, 7, 8, 9, 10
     */
    public MoveAble(int tier){
        super(tier, true, false);
    }
}
