import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

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
        
    }
}
