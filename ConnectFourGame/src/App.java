import java.util.Scanner;

public class App {
    public static void main(String[] args){
 
        // Player should enter row and column number as an input 
        // Player should select who is first
        Scanner input = new Scanner(System.in);
        System.out.print("Enter game size's...\nRow: ");
        int row = input.nextInt();
        System.out.print("Column: ");
        int column = input.nextInt();
        System.out.print("Do you want to play first? y/n: ");
        char status = input.next().charAt(0);

        Game connect4 = new Game(row, column);
        connect4.initializeGameEnvironment();
        
        Player player1 = new Human();
        Player player2 = new AI();

        connect4.startGame(player1, player2, status);
        input.close();
/* 
        char[][] gameBoard = new char[7][8];
        for(int i=0; i<7; i++){
            for(int j=0; j<8; j++){
                int x = (int)(Math.random() * 3);
                switch (x){
                    case 0: gameBoard[i][j] = '.';
                            break;
                    case 1: gameBoard[i][j] = 'X';
                            break;                   
                    case 2: gameBoard[i][j] = 'O';
                            break;
                }         
            }
        }
        
        Game x = new Game(7, 8);
        x.setGameBoard(gameBoard);
        x.printGameBoard();
        Heuristic h = new Heuristic(x);
        System.out.println(h.getValue());
        */

    }
}
