public abstract class Player {

    private char symbol;
    public abstract int play(Game game);

    public Player(char symbol){
        this.symbol = symbol;
    }

    public char getSymbol(){
        return this.symbol;
    }
}
