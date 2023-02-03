import java.util.ArrayList;

public class AI extends Player {
    private int bestMove;
    private Heuristic h1;

    public AI() { // AI's symbol is O
        super('O');
    }

    @Override
    public int play(Game game, int move) {
        int depth = 0;
        max(game, depth);
        return getBestMove();
    }

    private int max(Game game, int depthLimit) {
        ArrayList<Game> moves = new ArrayList<Game>();
        getValidMoves(game, moves, 'O');
        if(moves.size() == 0 || game.isGameOver('X') || depthLimit == 5){
            h1 = new Heuristic(game);
            return h1.getValue();
        }
        int maxMove = Integer.MIN_VALUE;
        for(int i=0; i<moves.size(); i++){
            if(moves.get(i) == null){
                continue;
            }
            int fromMin = min(moves.get(i), depthLimit+1);
            if(fromMin >= maxMove){
                if(depthLimit == 0){
                    bestMove = i;
                }      
                maxMove = fromMin;              
            }      
        }
        return maxMove;
    }

    private int min(Game game, int depthLimit) {
        ArrayList<Game> moves = new ArrayList<Game>();
        getValidMoves(game, moves, 'X');

        if(moves.size() == 0 || game.isGameOver('O') || depthLimit == 5){
            h1 = new Heuristic(game);
            return h1.getValue();
        }
        int minMove = Integer.MAX_VALUE;
        for(int i=0; i<moves.size(); i++){
            if(moves.get(i) == null){
                continue;
            }
            int fromMax = max(moves.get(i), depthLimit+1);
            if(fromMax <= minMove){
                minMove = fromMax;
            }      
        }
        return minMove;
    }

    private void getValidMoves(Game game, ArrayList<Game> moves, char symbol) {
        char[][] gameBoard = game.getGameBoard();
        for(int i=0; i<game.getColumn(); i++){
            if(game.getGameBoard()[0][i] != '.'){
                moves.add(null);
                continue;
            }
            for(int j=game.getRow()-1; j>=0; j--){
                if(gameBoard[j][i] == '.'){
                    gameBoard[j][i] = symbol;
                    Game possibleMove = new Game(game.getRow(), game.getColumn());
                    possibleMove.setGameBoard(gameBoard);
                    moves.add(possibleMove);
                    gameBoard[j][i] = '.';
                    break;
                }
            }
        }
    }

    public int getBestMove() {
        return bestMove;
    }
}


 