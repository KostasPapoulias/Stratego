package Model.Pieces;

import Model.Pieces.Piece;

public class Board {
    public String[][] Board;
    public static Piece[][] PieceBoard;
    final int rows = 8;
    final int columns = 10;

    /**
     * Fills the PieceBoard and gives a special number for the Board
     * Boards gets the number 2 and the piece's tier for the Red team
     *
     * @param piece
     * @param i
     * @param j
     */
    public void fillBoardRed(Piece piece, int i, int j) {
        PieceBoard[i][j] = piece;
        Board[i][j] = "2" + piece.getTier();
    }

    /**
     * Fills the PieceBoard and gives a special number for the Board
     * Boards gets the number 1 and the piece's tier for the Blue team
     *
     * @param piece
     * @param i
     * @param j
     */
    public void fillBoardBlue(Piece piece, int i, int j) {
        PieceBoard[i][j] = piece;
        Board[i][j] = "1" + piece.getTier();
    }

    /**
     * Initialises the Board and PieceBoard
     * The Boards stores a special number for each team plus the tier of each Piece
     * 1 for team Blue
     * 2 for team Red
     * 11 for the Trap
     * 12 for the Flag
     * <p>
     * The PieceBoard stores the Pieces
     */
    public Board() {
        Board = new String[10][12];//1## blue, 2## red
        PieceBoard = new Piece[9][11];
        initiateBoard();
    }

    /**
     * Initialises the Board
     * 0 on empty boxes
     * -1 on boxes out of the map
     */
    void initiateBoard() {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                if ((i == 4 || i == 5) && (j == 3 || j == 4 || j == 7 || j == 8))
                    Board[i][j] = "-1";
                else
                    Board[i][j] = "0";
            }
        }
    }

    /**
     * Gets the current position of the Piece
     * returns the possible moves the Piece can do
     *
     * @param i, j
     * @return an array with the possible moves. The value in the array is: 0 for no action, 1 for walk, 2 for attack
     */

    public int[][] PossibleMoves(int i, int j, boolean noBack) {
        int[][] moves = new int[8][10];
        for (int k = 0; k < 8; k++) {
            for (int l = 0; l < 10; l++) {
                moves[k][l] = 0;
            }
        }

        if (Board[i + 1][j + 1].charAt(0) == '1') {
            if (Board[i][j + 1] != null && (i - 1 >= 0)) {
                if (Board[i][j + 1].charAt(0) == '1' || Board[i][j + 1].charAt(0) == '-') {
                    moves[i - 1][j] = 0;
                } else if (Board[i][j + 1].charAt(0) == '2') {
                    moves[i - 1][j] = 2;
                } else if (Board[i][j + 1].charAt(0) == '0') {
                    moves[i - 1][j] = 1;
                }
            }
            if (Board[i + 1][j] != null && (j - 1 >= 0)) {
                if (Board[i + 1][j].charAt(0) == '1' || Board[i + 1][j].charAt(0) == '-') {
                    moves[i][j - 1] = 0;
                } else if (Board[i + 1][j].charAt(0) == '2') {
                    moves[i][j - 1] = 2;
                } else if (Board[i + 1][j].charAt(0) == '0') {
                    moves[i][j - 1] = 1;
                }
            }
            if (Board[i + 2][j + 1] != null && (i + 1 <= 10)) {
                if(!noBack)
                    {
                    if (Board[i + 2][j + 1].charAt(0) == '1' || Board[i + 2][j + 1].charAt(0) == '-') {
                        moves[i + 1][j] = 0;
                    } else if (Board[i + 2][j + 1].charAt(0) == '2') {
                        moves[i + 1][j] = 2;
                    } else if (Board[i + 2][j + 1].charAt(0) == '0') {
                        moves[i + 1][j] = 1;
                    }
                }
            }
            if (Board[i + 1][j + 2] != null && (j + 1 <= 10)) {
                if (Board[i + 1][j + 2].charAt(0) == '1' || Board[i + 1][j + 2].charAt(0) == '-') {
                    moves[i][j + 1] = 0;
                } else if (Board[i + 1][j + 2].charAt(0) == '2') {
                    moves[i][j + 1] = 2;
                } else if (Board[i + 1][j + 2].charAt(0) == '0') {
                    moves[i][j + 1] = 1;
                }
            }

        } else if (Board[i + 1][j + 1].charAt(0) == '2') {

            if (Board[i][j + 1] != null && (i - 1 >= 0)) {
                if(!noBack) {
                    if (Board[i][j + 1].charAt(0) == '1') {
                        moves[i - 1][j] = 2;
                    } else if (Board[i][j + 1].charAt(0) == '2' || Board[i][j + 1].charAt(0) == '-') {
                        moves[i - 1][j] = 0;
                    } else if (Board[i][j + 1].charAt(0) == '0') {
                        moves[i - 1][j] = 1;
                    }
                }
            }
            if (Board[i + 1][j] != null && (j - 1 >= 0)) {
                if(Board[i + 1][j]!=null && i+1>0) {
                    if (Board[i + 1][j].charAt(0) == '1') {
                        moves[i][j - 1] = 2;
                    } else if (Board[i + 1][j].charAt(0) == '2' || Board[i+1][j].charAt(0) == '-') {
                        moves[i][j - 1] = 0;
                    } else if (Board[i + 1][j].charAt(0) == '0') {
                        moves[i][j - 1] = 1;
                    }
                }
            }
            if (Board[i + 2][j + 1] != null && (i + 1 <= 10)) {
                if (Board[i + 2][j + 1].charAt(0) == '1') {
                    moves[i + 1][j] = 2;
                } else if (Board[i + 2][j + 1].charAt(0) == '2' || Board[i+2][j+1].charAt(0) == '-') {
                    moves[i + 1][j] = 0;
                } else if (Board[i + 2][j + 1].charAt(0) == '0') {
                    moves[i + 1][j] = 1;
                }
            }
            if (Board[i + 1][j + 2] != null && (j + 1 <= 10)) {
                if (Board[i + 1][j + 2].charAt(0) == '1') {
                    moves[i][j + 1] = 2;
                } else if (Board[i + 1][j + 2].charAt(0) == '2' || Board[i + 1][j + 2].charAt(0) == '-') {
                    moves[i][j + 1] = 0;
                } else if (Board[i + 1][j + 2].charAt(0) == '0') {
                    moves[i][j + 1] = 1;
                }
            }
        }
        //---------------

        int a;
        boolean flag = false;
        if (Board[i + 1][j + 1].equals("12") || Board[i + 1][j + 1].equals("22")) {
            if (Board[i + 1][j + 1].charAt(0) == '1') {
                if (Board[i][j + 1] != null && (i - 1 >= 0)) {
                    a = i;
                    while (a > 0 && flag == false) {
                        if (Board[a][j + 1].charAt(0) == '1' || Board[a][j + 1].charAt(0) == '-') {
                            moves[a - 1][j] = 0;
                            flag = true;
                        } else if (Board[a][j + 1].charAt(0) == '2') {
                            moves[a - 1][j] = 2;
                            flag = true;
                        } else if (Board[a][j + 1].charAt(0) == '0') {
                            moves[a - 1][j] = 1;
                        }
                        a--;
                    }
                }
                flag = false;
                if (Board[i + 1][j] != null && (j - 1 >= 0)) {
                    a = j;
                    while (a > 0 && flag == false) {
                        if (Board[i + 1][a].charAt(0) == '1' || Board[i + 1][a].charAt(0) == '-') {
                            moves[i][a - 1] = 0;
                            flag = true;
                        } else if (Board[i + 1][a].charAt(0) == '2') {
                            moves[i][a - 1] = 2;
                            flag = true;
                        } else if (Board[i + 1][a].charAt(0) == '0') {
                            moves[i][a - 1] = 1;
                        }
                        a--;
                    }
                }
                flag = false;
                if (Board[i + 2][j + 1] != null && (i + 1 <= 10)) {
                    a = i;
                    if(!noBack) {
                        while (a < 8 && flag == false) {
                            if(Board[a+2][j+1]!=null) {
                                if (Board[a + 2][j + 1].charAt(0) == '1' || Board[a + 2][j + 1].charAt(0) == '-') {
                                    moves[a + 1][j] = 0;
                                    flag = true;
                                } else if (Board[a + 2][j + 1].charAt(0) == '2') {
                                    moves[a + 1][j] = 2;
                                    flag = true;
                                } else if (Board[a + 2][j + 1].charAt(0) == '0') {
                                    moves[a + 1][j] = 1;
                                }

                            }
                            a++;
                        }
                    }
                }
                flag = false;
                if (Board[i + 1][j + 2] != null && (j + 1 <= 10)) {
                    a = j;
                    while (a < 10 && !flag) {
                        if(Board[i + 1][a + 2] !=null) {
                            if (Board[i + 1][a + 2].charAt(0) == '1' || Board[i + 1][a + 2].charAt(0) == '-') {
                                moves[i][a + 1] = 0;
                                flag = true;
                            } else if (Board[i + 1][a + 2].charAt(0) == '2') {
                                moves[i][a + 1] = 2;
                                flag = true;
                            } else if (Board[i + 1][a + 2].charAt(0) == '0') {
                                moves[i][a + 1] = 1;
                            }
                        }
                        a++;
                    }
                }
            }
            else if (Board[i + 1][j + 1].charAt(0) == '2') {
                a = i;


                if (Board[a][j + 1] != null && (i - 1 >= 0)) {
                    a = i;
                    flag = false;
                    if(!noBack) {
                        while (a > 0 && flag == false) {
                            if (Board[a][j + 1].charAt(0) == '1') {
                                moves[a - 1][j] = 2;
                                flag = true;
                            } else if (Board[a][j + 1].charAt(0) == '2' || Board[a][j + 1].charAt(0) == '-') {
                                moves[a - 1][j] = 0;
                                flag = true;
                            } else if (Board[i][j + 1].charAt(0) == '0') {
                                moves[a - 1][j] = 1;
                            }
                            a--;
                        }
                    }
                }

                if (Board[i + 1][j] != null && (j - 1 >= 0)) {
                    a = j;
                    while (a > 0) {
                        if (Board[i + 1][a].charAt(0) == '1') {
                            moves[i][a - 1] = 2;
                            flag = true;
                        } else if (Board[i + 1][a].charAt(0) == '2' || Board[i + 1][a].charAt(0) == '-') {
                            moves[i][a - 1] = 0;
                            flag = true;
                        } else if (Board[i + 1][j].charAt(0) == '0') {
                            moves[i][a - 1] = 1;
                            flag = true;
                        }
                        a--;
                    }
                }


                flag = false;


                if (Board[i + 2][j + 1] != null && (i + 1 <= 10)) {
                    a = i;
                    while (a < 8 && flag == false) {
                        if(Board[a + 2][j + 1]!=null) {
                            if (Board[a + 2][j + 1].charAt(0) == '1') {
                                moves[a + 1][j] = 2;
                                flag = true;
                            } else if (Board[a + 2][j + 1].charAt(0) == '2' || Board[a + 2][j + 1].charAt(0) == '-') {
                                moves[a + 1][j] = 0;
                                flag = true;
                            } else if (Board[a + 2][j + 1].charAt(0) == '0') {
                                moves[a + 1][j] = 1;
                            }
                        }
                        a++;
                    }
                }

                flag = false;
                if (Board[i + 1][j + 2] != null && (j + 1 <= 10)) {
                    a = j;
                    while (a < 10 && flag == false) {

                        if(Board[i + 1][a + 2]!=null) {
                            if (Board[i + 1][a + 2].charAt(0) == '1') {
                                moves[i][a + 1] = 2;
                                flag = true;
                            } else if (Board[i + 1][a + 2].charAt(0) == '2' || Board[i + 1][a + 2].charAt(0) == '-') {
                                moves[i][a + 1] = 0;
                                flag = true;
                            } else if (Board[i + 1][j + 2].charAt(0) == '0') {
                                moves[i][a + 1] = 1;
                            }
                        }
                        a++;
                    }
                }
            }
        }

        return moves;
    }

    /**
     * @param positionI the row
     * @param positionJ the column
     * deletes the Piece from Board and PieceBoard
     */
    public void deletePiece(int positionI, int positionJ){
        Board[positionI+1][positionJ+1] = "0";
        PieceBoard[positionI+1][positionJ+1] = null;
    }

    /**
     * @param positionI the current row
     * @param positionJ current column
     * @param newPositionI new row
     * @param newPositionJ new column
     * changes the value of Board and PieceBoard from positionI and positionJ to newPositionI and newPositionJ
     */
    public void movePosition(int positionI, int positionJ, int newPositionI, int newPositionJ){
        String temp;
        Piece tempPiece;
        temp = Board[positionI][positionJ];
        tempPiece = PieceBoard[positionI][positionJ];
/*
        Board[positionI][positionJ] = "0";
        PieceBoard[positionI][positionJ] = null;

 */
        deletePiece(positionI - 1, positionJ - 1);
        Board[newPositionI][newPositionJ] = temp;
        PieceBoard[newPositionI][newPositionJ] = tempPiece;
    }
}
