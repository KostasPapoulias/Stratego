package Model.Pieces;

public interface Species {
    /**
     * returns if the Piece is Alive or not
     * @return
     */
    boolean isAlive();

    /**
     * returns the Piece's tier
     * @return
     */
    int getTier();

    /**
     * kills the Piece
     * sets the statue of the Piece to false
     */
    void isDying();

    /**
     * returns if the Piece is special
     * @return
     */
    boolean isSpecial();
}
