package Model;
import Model.Army;
import Model.Pieces.*;

import java.util.ArrayList;

import static Model.Utilities.getRandomVal;



public class Player {
    private final String name;
    private ArrayList<Piece> piece;
    private ArrayList<Piece> deadPiece;


    /**
     * Initialise the players
     * Sets a name for each
     * Calls the method createArmy
     * @param name
     * @param board
     * @param lessArmy
     */
    public Player(String name, Board board, int team, boolean lessArmy){
        this.name = name;
        piece = new ArrayList<>();

        createAnArmy(board, team, lessArmy);
    }

    /**
     * @param board access to Board class
     * @param team 1, 2
     * @param lessArmy true if player gets less army as game option
     */

    private void createAnArmy(Board board, int team, boolean lessArmy){

        int tier;

        if(lessArmy){
            int dragon = 1;int mage = 1;int knight = 1;int beastRider = 1;int sorceress = 1;int lavaYeti = 1;int elf = 1;int dwarf = 2;int scout = 2;int slayer = 1;int trap = 3;int flag = 1;
            if (team == 1) {
                for (int j = 6; j <= 8; j++) {
                    for (int k = 1; k <= 10; k++) {
                        for (; ; ) {
                            tier = getRandomVal(1, 12);
                            if (tier == 1 && slayer > 0) {
                                slayer--;
                                board.fillBoardBlue(new SpecialAbilities(1), j, k);
                                addPiece(new SpecialAbilities(1));
                                break;
                            } else if (tier == 2 && scout > 0) {
                                scout--;
                                board.fillBoardBlue(new SpecialAbilities(2), j, k);
                                addPiece(new SpecialAbilities(2));
                                break;
                            } else if (tier == 3 && dwarf > 0) {
                                dwarf--;
                                board.fillBoardBlue(new SpecialAbilities(3), j, k);
                                addPiece(new SpecialAbilities(3));
                                break;
                            } else if (tier == 4 && elf > 0) {
                                elf--;
                                board.fillBoardBlue(new MoveAble(4), j, k);
                                addPiece(new MoveAble(4));
                                break;
                            } else if (tier == 5 && lavaYeti > 0) {
                                lavaYeti--;
                                board.fillBoardBlue(new MoveAble(5), j, k);
                                addPiece(new MoveAble(5));
                                break;
                            } else if (tier == 6 && sorceress > 0) {
                                sorceress--;
                                board.fillBoardBlue(new MoveAble(6), j, k);
                                addPiece(new MoveAble(6));
                                break;
                            } else if (tier == 7 && beastRider > 0) {
                                beastRider--;
                                board.fillBoardBlue(new MoveAble(7), j, k);
                                addPiece(new MoveAble(7));
                                break;
                            } else if (tier == 8 && knight > 0) {
                                knight--;
                                board.fillBoardBlue(new MoveAble(8), j, k);
                                addPiece(new MoveAble(8));
                                break;
                            } else if (tier == 9 && mage > 0) {
                                mage--;
                                board.fillBoardBlue(new MoveAble(9), j, k);
                                addPiece(new MoveAble(9));
                                break;
                            } else if (tier == 10 && dragon > 0) {
                                dragon--;
                                board.fillBoardBlue(new MoveAble(10), j, k);
                                addPiece(new MoveAble(10));
                                break;
                            } else if (tier == 11 && trap > 0) {
                                trap--;
                                board.fillBoardBlue(new ImMoveAble(11), j, k);
                                addPiece(new ImMoveAble(11));
                                break;
                            } else if (tier == 12 && flag > 0) {
                                flag--;
                                board.fillBoardBlue(new MoveAble(12), j, k);
                                addPiece(new ImMoveAble(12));
                                break;
                            }
                            if(dragon == 0 && mage == 0 && knight == 0 && beastRider == 0 && sorceress == 0 && lavaYeti == 0 && elf == 0 && dwarf == 0 && scout == 0 && slayer == 0 && trap == 0 && flag == 0)
                                break;

                        }

                    }

                }

            } else if (team == 2) {
                for (int j = 2; j <= 3; j++) {

                    for (int k = 1; k <= 10; k++) {

                        for (; ; ) {
                            tier = getRandomVal(1, 12);
                            if (tier == 1 && slayer > 0) {
                                slayer--;
                                board.fillBoardRed(new SpecialAbilities(1), j, k);
                                addPiece(new SpecialAbilities(1));
                                break;
                            } else if (tier == 2 && scout > 0) {
                                scout--;
                                board.fillBoardRed(new SpecialAbilities(2), j, k);
                                addPiece(new SpecialAbilities(2));
                                break;
                            } else if (tier == 3 && dwarf > 0) {
                                dwarf--;
                                board.fillBoardRed(new SpecialAbilities(3), j, k);
                                addPiece(new SpecialAbilities(3));
                                break;
                            } else if (tier == 4 && elf > 0) {
                                elf--;
                                board.fillBoardRed(new MoveAble(4), j, k);
                                addPiece(new MoveAble(4));
                                break;
                            } else if (tier == 5 && lavaYeti > 0) {
                                lavaYeti--;
                                board.fillBoardRed(new MoveAble(5), j, k);
                                addPiece(new MoveAble(5));
                                break;
                            } else if (tier == 6 && sorceress > 0) {
                                sorceress--;
                                board.fillBoardRed(new MoveAble(6), j, k);
                                addPiece(new MoveAble(6));
                                break;
                            } else if (tier == 7 && beastRider > 0) {
                                beastRider--;
                                board.fillBoardRed(new MoveAble(7), j, k);
                                addPiece(new MoveAble(7));
                                break;
                            } else if (tier == 8 && knight > 0) {
                                knight--;
                                board.fillBoardRed(new MoveAble(8), j, k);
                                addPiece(new MoveAble(8));
                                break;
                            } else if (tier == 9 && mage > 0) {
                                mage--;
                                board.fillBoardRed(new MoveAble(9), j, k);
                                addPiece(new MoveAble(9));
                                break;
                            } else if (tier == 10 && dragon > 0) {
                                dragon--;
                                board.fillBoardRed(new MoveAble(10), j, k);
                                addPiece(new MoveAble(10));
                                break;
                            } else if (tier == 11 && trap > 0) {
                                trap--;
                                board.fillBoardRed(new ImMoveAble(11), j, k);
                                addPiece(new ImMoveAble(11));
                                break;
                            } else if (tier == 12 && flag > 0) {
                                flag--;
                                board.fillBoardRed(new ImMoveAble(12), j, k);
                                addPiece(new ImMoveAble(12));
                                break;
                            }
                            if(dragon == 0 && mage == 0 && knight == 0 && beastRider == 0 && sorceress == 0 && lavaYeti == 0 && elf == 0 && dwarf == 0 && scout == 0 && slayer == 0 && trap == 0 && flag == 0)
                                break;
                        }
                    }
                }
            }
        }else {
            int dragon = 1;int mage = 1;int knight = 2;int beastRider = 3;int sorceress = 2;int lavaYeti = 2;int elf = 2;int dwarf = 5;int scout = 4;int slayer = 1;int trap = 6;int flag = 1;

            if (team == 1) {

                for (int j = 6; j <= 8; j++) {
                    for (int k = 1; k <= 10; k++) {
                        for (; ; ) {
                            tier = getRandomVal(1, 12);
                            if (tier == 1 && slayer > 0) {
                                slayer--;
                                board.fillBoardBlue(new SpecialAbilities(1), j, k);
                                addPiece(new SpecialAbilities(1));
                                break;
                            } else if (tier == 2 && scout > 0) {
                                scout--;
                                board.fillBoardBlue(new SpecialAbilities(2), j, k);
                                addPiece(new SpecialAbilities(2));
                                break;
                            } else if (tier == 3 && dwarf > 0) {
                                dwarf--;
                                board.fillBoardBlue(new SpecialAbilities(3), j, k);
                                addPiece(new SpecialAbilities(3));
                                break;
                            } else if (tier == 4 && elf > 0) {
                                elf--;
                                board.fillBoardBlue(new MoveAble(4), j, k);
                                addPiece(new MoveAble(4));
                                break;
                            } else if (tier == 5 && lavaYeti > 0) {
                                lavaYeti--;
                                board.fillBoardBlue(new MoveAble(5), j, k);
                                addPiece(new MoveAble(5));
                                break;
                            } else if (tier == 6 && sorceress > 0) {
                                sorceress--;
                                board.fillBoardBlue(new MoveAble(6), j, k);
                                addPiece(new MoveAble(6));
                                break;
                            } else if (tier == 7 && beastRider > 0) {
                                beastRider--;
                                board.fillBoardBlue(new MoveAble(7), j, k);
                                addPiece(new MoveAble(7));
                                break;
                            } else if (tier == 8 && knight > 0) {
                                knight--;
                                board.fillBoardBlue(new MoveAble(8), j, k);
                                addPiece(new MoveAble(8));
                                break;
                            } else if (tier == 9 && mage > 0) {
                                mage--;
                                board.fillBoardBlue(new MoveAble(9), j, k);
                                addPiece(new MoveAble(9));
                                break;
                            } else if (tier == 10 && dragon > 0) {
                                dragon--;
                                board.fillBoardBlue(new MoveAble(10), j, k);
                                addPiece(new MoveAble(10));
                                break;
                            } else if (tier == 11 && trap > 0) {
                                trap--;
                                board.fillBoardBlue(new ImMoveAble(11), j, k);
                                addPiece(new ImMoveAble(11));
                                break;
                            } else if (tier == 12 && flag > 0) {
                                flag--;
                                board.fillBoardBlue(new MoveAble(12), j, k);
                                addPiece(new ImMoveAble(12));
                                break;
                            }
                        }
                    }
                }
            } else if (team == 2) {

                for (int j = 1; j <= 3; j++) {
                    for (int k = 1; k <= 10; k++) {
                        for (; ; ) {
                            tier = getRandomVal(1, 12);
                            if (tier == 1 && slayer > 0) {
                                slayer--;
                                board.fillBoardRed(new SpecialAbilities(1), j, k);
                                addPiece(new SpecialAbilities(1));
                                break;
                            } else if (tier == 2 && scout > 0) {
                                scout--;
                                board.fillBoardRed(new SpecialAbilities(2), j, k);
                                addPiece(new SpecialAbilities(2));
                                break;
                            } else if (tier == 3 && dwarf > 0) {
                                dwarf--;
                                board.fillBoardRed(new SpecialAbilities(3), j, k);
                                addPiece(new SpecialAbilities(3));
                                break;
                            } else if (tier == 4 && elf > 0) {
                                elf--;
                                board.fillBoardRed(new MoveAble(4), j, k);
                                addPiece(new MoveAble(4));
                                break;
                            } else if (tier == 5 && lavaYeti > 0) {
                                lavaYeti--;
                                board.fillBoardRed(new MoveAble(5), j, k);
                                addPiece(new MoveAble(5));
                                break;
                            } else if (tier == 6 && sorceress > 0) {
                                sorceress--;
                                board.fillBoardRed(new MoveAble(6), j, k);
                                addPiece(new MoveAble(6));
                                break;
                            } else if (tier == 7 && beastRider > 0) {
                                beastRider--;
                                board.fillBoardRed(new MoveAble(7), j, k);
                                addPiece(new MoveAble(7));
                                break;
                            } else if (tier == 8 && knight > 0) {
                                knight--;
                                board.fillBoardRed(new MoveAble(8), j, k);
                                addPiece(new MoveAble(8));
                                break;
                            } else if (tier == 9 && mage > 0) {
                                mage--;
                                board.fillBoardRed(new MoveAble(9), j, k);
                                addPiece(new MoveAble(9));
                                break;
                            } else if (tier == 10 && dragon > 0) {
                                dragon--;
                                board.fillBoardRed(new MoveAble(10), j, k);
                                addPiece(new MoveAble(10));
                                break;
                            } else if (tier == 11 && trap > 0) {
                                trap--;
                                board.fillBoardRed(new ImMoveAble(11), j, k);
                                addPiece(new ImMoveAble(11));
                                break;
                            } else if (tier == 12 && flag > 0) {
                                flag--;
                                board.fillBoardRed(new ImMoveAble(12), j, k);
                                addPiece(new ImMoveAble(12));
                                break;
                            }
                        }
                    }
                }
            }
        }
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
    public void addDeadPiece(Piece piece){
        this.piece.add(piece);
    }

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

        for(int i = 0; i < piece.size(); i++)
        {
            if(piece.get(i).isAlive())
                return false;

        }
        return true;
    }


    /**
     * return the name of the player
     * @return
     */
    public String getName(){
        return name;
    }




}
