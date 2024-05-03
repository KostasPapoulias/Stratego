package Controller;
/*
========================1=====================
public void mouseClicked(MouseEvent e) {
        if(!graphicButtons.isActivated()) {
        //selects first button
        for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 10; j++) {

        if (e.getSource() == graphicButtons.accessToButtons(i, j) ) {

        graphicButtons.accessToButtons(i, j).setBackground(Color.BLACK);
        SaveCoordinations(i, j);

        moves = boardd.PossibleMoves(i, j);

        }
        graphicButtons.activateButton(coordinationsX, coordinationsY, true);
        }
        }
        }
        else{
        //selects second button
        for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 10; j++) {
        if (e.getSource() == graphicButtons.accessToButtons(i, j)) {
        SaveTargetCoordinations(i, j);
        if (moves[i][j] == 1) {

        boardd.movePosition(coordinationsX + 1, coordinationsY + 1, targetCoordinationsX + 1, targerCoordinationsY + 1);
        graphicButtons.moveButtons(coordinationsX, coordinationsY, targetCoordinationsX, targerCoordinationsY, Integer.parseInt(boardd.Board[i+1][j+1]));
        graphicButtons.activateButton(coordinationsX, coordinationsY, false);
        graphicButtons.deactivate();

        }
        else if(moves[i][j] == 2){

        if(Piece.fight(coordinationsX, coordinationsY, targetCoordinationsX, targerCoordinationsY) == 1){
        boardd.movePosition(coordinationsX + 1, coordinationsY + 1, targetCoordinationsX + 1, targerCoordinationsY + 1);
        graphicButtons.moveButtons(coordinationsX, coordinationsY, targetCoordinationsX, targerCoordinationsY, Integer.parseInt(boardd.Board[i+1][j+1]));
        graphicButtons.activateButton(coordinationsX, coordinationsY, false);
        graphicButtons.deactivate();
        System.out.println("GETS IN");
        }
        else if(Piece.fight(coordinationsX, coordinationsY, targetCoordinationsX, targerCoordinationsY) == 2){
        boardd.deletePiece(coordinationsX, coordinationsY);
        graphicButtons.deleteButton(coordinationsX, coordinationsY);
        graphicButtons.activateButton(coordinationsX, coordinationsY, false);
        graphicButtons.deactivate();
        }
        else{
        boardd.deletePiece(coordinationsX, coordinationsY);
        boardd.deletePiece(targetCoordinationsX, targerCoordinationsY);
        graphicButtons.deleteButton(coordinationsX, coordinationsY);
        graphicButtons.deleteButton(targetCoordinationsX, targerCoordinationsY);
        graphicButtons.activateButton(coordinationsX, coordinationsY, false);
        graphicButtons.deactivate();
        }
        }
        }
        }
        }
        }
        }

@Override
public void mousePressed(MouseEvent e) {

        }

@Override
public void mouseReleased(MouseEvent e) {

        }

@Override
public void mouseEntered(MouseEvent e) {

        if(!graphicButtons.isActivated()) {
        for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 10; j++) {
        if (e.getSource() == graphicButtons.accessToButtons(i, j)) {
        System.out.println("above");

        SaveEnteredCoordinations(i, j);
        System.out.println(boardd.Board[i + 1][j + 1]);
        moves = boardd.PossibleMoves(i, j);

        }
        }
        }
        for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 10; j++) {
        if (moves[i][j] == 2)
        graphicButtons.accessToButtons(i, j).setBackground(Color.RED);
        else if (moves[i][j] == 1)
        graphicButtons.accessToButtons(i, j).setBackground(Color.GREEN);
        }
        }
        }


        }

@Override
public void mouseExited(MouseEvent e){
        for(int i=0;i< 8;i++){
        for(int j=0;j< 10;j++){
        if(moves[i][j]==1||moves[i][j]==2)
        graphicButtons.accessToButtons(i,j).setBackground(Color.WHITE);
        }
        }
        }
        ===============================
        =============================
                    2
        ============================
        ==============================




        */