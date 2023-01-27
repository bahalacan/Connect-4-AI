public class App {
    public static void main(String[] args) throws Exception {

        // Player should enter row and column number as an input
        // Player should select who is first

        Game connect4 = new Game(7, 8);
        
        Player player1 = new Human('X');
        Player player2 = new Human('O');

        
    }
}
