package Model.Pieces;

import Model.Pieces.Piece;

public class SpecialAbilities extends Piece {
    /**
     * Gets the tier of the Piece
     * calls the Piece constructor and sets the tier, move ability to true and special to true
     * @param tier 1, 2, 3
     */
    public SpecialAbilities(int tier){
        super(tier, true, true);
    }
}
