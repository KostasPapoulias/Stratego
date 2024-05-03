package Model.Pieces;

abstract public class Piece implements Species {
    private int tier;
    private boolean moveAble;
    private boolean alive;
    private boolean special;
    protected Piece(){}
    Piece(int tier, boolean moveAble, boolean special){
        this.tier = tier;
        this.moveAble = moveAble;
        this.special = special;
        alive = true;
    }
    public int getTier(){
        return tier;
    }
    public boolean isAlive(){
        return alive;
    }
    public void isDying(){
        alive = false;
    }
    public boolean isSpecial(){
        return special;
    }

    /**
     *
     * @param currentX the row
     * @param currentY the column
     * @param targetX target's row
     * @param targetY target's column
     * @return 1 if the attacker defeats the defence or 2 if the attacker gets defeated
     */
    public static int fight(int currentX, int currentY, int targetX, int targetY){
        Species attacker = Board.PieceBoard[currentX+1][currentY+1];
        Species defencer = Board.PieceBoard[targetX+1][targetY+1];
        if(defencer.getTier() == 12){
            defencer.isDying();
            return 1;
        }
        if(attacker.isSpecial()){
            //System.out.println("ATTACKER TIER "+attacker.getTier());
            if(attacker.getTier() == 1) {
                //System.out.println("DEFENCER TIER "+defencer.getTier());
                if (defencer.getTier() == 10) {
                    defencer.isDying();
                    return 1;
                }
                else if (defencer.getTier() > 1) {
                    attacker.isDying();
                    return 2;
                }
                else {
                    defencer.isDying();
                    attacker.isDying();
                    return 0;
                }
            }
            else if(attacker.getTier() == 3){
                if(defencer.getTier() == 11) {
                    defencer.isDying();
                    return 1;
                }
                else if (defencer.getTier() > 3) {
                    attacker.isDying();
                    return 2;
                }
                else {
                    defencer.isDying();
                    attacker.isDying();
                    return 0;
                }
            }
            else if(attacker.getTier() == 2){
                if (defencer.getTier() < attacker.getTier()) {
                    defencer.isDying();
                    return 1;
                }
                else if (defencer.getTier() > attacker.getTier()) {
                    attacker.isDying();
                    return 2;
                }
                else {
                    attacker.isDying();
                    defencer.isDying();
                    return 0;
                }
            }

        }
        else {
            //System.out.println("IS DEFENCER MOVABLE "+ (defencer instanceof MoveAble));
            if (defencer instanceof MoveAble) {
                //System.out.println("DEFENCER TIER "+defencer.getTier() +" ATTACKER TIER "+attacker.getTier());
                if (defencer.getTier() < attacker.getTier()) {
                    defencer.isDying();
                    return 1;
                }
                else if (defencer.getTier() > attacker.getTier()) {
                    attacker.isDying();
                    return 2;
                }
                else {
                    attacker.isDying();
                    defencer.isDying();
                    return 0;
                }
            } else if (defencer instanceof SpecialAbilities) {
                if (defencer.getTier() < attacker.getTier()) {
                    defencer.isDying();
                    return 1;
                }
                else if (defencer.getTier() > attacker.getTier()) {
                    attacker.isDying();
                    return 2;
                }
                else {
                    attacker.isDying();
                    defencer.isDying();
                    return 0;
                }

            } else if (defencer instanceof ImMoveAble) {
                if (defencer.getTier() == 11) {//pagida
                    attacker.isDying();
                    return 2;
                }
            }
        }
        return 1;
    }


}
