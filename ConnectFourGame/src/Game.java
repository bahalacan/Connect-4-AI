public class Game {
    private int row;
    private int column;
    private char gameBoard[][];

    public Game(int row, int column){
        this.row = row;
        this.column = column;
        initializeGameEnvironment();
    }

    private void initializeGameEnvironment(){
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
            System.out.println();
        }
        for(int j=1; j<column+1; j++){
            System.out.print(j + " ");
        }
        System.out.println();
    
    }

    public boolean startHuman(Player p1, Player p2, int move, MyFrame frame){ // AI and Human should be inherited from Player class
        int movement = p1.play(this, move);
        if(movement != -1){
            int selectedRow = updateGameBoard(movement, p1.getSymbol());
            frame.setGame(selectedRow, movement, p1);
            if(isGameOver('X')){
                return true;
            }
            movement = p2.play(this, -1);
            selectedRow = updateGameBoard(movement, 'O');
            frame.setGame(selectedRow, movement, p2);
            if(isGameOver('O')){
                return true;
            }
        }
        return false;
    }

    private int updateGameBoard(int movement, char symbol) {
        for(int i=row-1; i>=0; i--){
            if(gameBoard[i][movement] == '.'){
                gameBoard[i][movement] = symbol;
                return i;
            }
        }
        return -1;      
    }

    public boolean isGameOver(char symbol) { 
        if(checkHorizontal(symbol) || checkVertical(symbol) || checkDiagonal(symbol)){ //think about for better method
            return true;
        }
        return false;
    }

    private boolean checkDiagonal(char symbol) {
        for(int i=0; i<row-3; i++){
            for(int j=0; j<column-3; j++){
                if(gameBoard[i][j] == symbol && gameBoard[i+1][j+1] == symbol && gameBoard[i+2][j+2] == symbol && gameBoard[i+3][j+3] == symbol){
                    return true;
                }
            }
        }
        for(int i=row-1; i>2; i--){
            for(int j=0; j<column-3; j++){
                if(gameBoard[i][j] == symbol && gameBoard[i-1][j+1] == symbol && gameBoard[i-2][j+2] == symbol && gameBoard[i-3][j+3] == symbol){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkVertical(char symbol) {
        for(int j=0; j<column; j++){
            for(int i=0; i<row-3; i++){
                if(gameBoard[i][j] == symbol && gameBoard[i+1][j] == symbol && gameBoard[i+2][j] == symbol && gameBoard[i+3][j] == symbol){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkHorizontal(char symbol) {     
        for(int i=row-1; i>=0; i--){
            for(int j=0; j<column-3; j++){
                if(gameBoard[i][j] == symbol && gameBoard[i][j+1] == symbol && gameBoard[i][j+2] == symbol && gameBoard[i][j+3] == symbol){
                    return true;
                }
            }
        }
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

    public void setGameBoard(char[][] gameBoard) {
        char[][] gameBoard2 = new char[row][column];
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                gameBoard2[i][j] = gameBoard[i][j];
            }
        }
        this.gameBoard = gameBoard2;
    }
}
