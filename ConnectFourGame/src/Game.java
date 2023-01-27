public class Game {
    private int row;
    private int column;
    private char gameBoard[][];

    public Game(int row, int column){
        this.row = row;
        this.column = column;
        initializeGameEnvironment();
    }

    public void initializeGameEnvironment(){
        this.gameBoard = new char[this.row][this.column];
        for (int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                gameBoard[i][j] = '.';
            }
        }
    }

    public void printGameBoard(){
        for (int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void startGame(Player p1, Player p2){ // AI and Human should be inherited from Player class
        while(!isGameOver()){
            /* Pseudocode
             * Inherited method play() should be call
             * Play method return movement of the player
             * GameBoard is updated and check game is over(if it is over break the loop) if it is not over second player plays
             * Same process for player 2
             */
        }


    }

    private boolean isGameOver() { // Check environment and find whether game is over
        return false;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public char[][] getGameBoard() {
        return gameBoard;
    }
    
    
}
