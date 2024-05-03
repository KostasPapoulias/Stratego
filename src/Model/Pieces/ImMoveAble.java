package Model.Pieces;

import Model.Pieces.Piece;

public class ImMoveAble extends Piece {
    /**
     * Gets the tier of the Piece
     * calls the Piece constructor and sets the tier, move ability to false and special to true
     * @param tier 11, 12
     */
    public ImMoveAble(int tier){
        super(tier, false, true); // pagida tier = 11, flag tier = 12
    }
}
