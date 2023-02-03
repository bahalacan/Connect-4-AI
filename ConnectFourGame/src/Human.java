import java.util.Scanner;

public class Human extends Player {

    public Human() { //Player's symbol is X
        super('X');
    }

    @Override
    public int play(Game game, int move) {
        char[][] gameBoard = game.getGameBoard();           
        if(checkIsMoveLegal(move, gameBoard)){
            return move;
        }
        return -1;
           
    }

    private boolean checkIsMoveLegal(int movement, char gameBoard[][]) {
        if(movement < 0 || movement >= gameBoard[0].length || gameBoard[0][movement] != '.' ){ // check for environment constraints
            return false;
        }
        return true;
    }
}
