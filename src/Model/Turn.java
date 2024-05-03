package Model;
import Model.Player;

public class Turn {
     int turn;

    /**
     * initialise the turn to 2
     */
    public Turn(){
        turn = 2;
    }

    /**
     * @return 1 if the value of turn is 2 and 2 if the value of turn is 1
     */
    public  int getTurn(){
        if(turn == 2) {
            turn = 1;
        }
        else{
            turn = 2;
        }
        return turn;
    }

    /**
     * @return the value of turn,  1 or 2
     */
    public int readTurn(){
        return turn;
    }
}
