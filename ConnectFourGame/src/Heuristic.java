public class Heuristic { 
    private int value;

    public Heuristic(Game game){
        this.value = calculateValue(game);
    }

    private int calculateValue(Game game) {
        int fourHeurAI = calculateHeuristicValue(game, 4, 'O');
        if(fourHeurAI > 0){
            return 10000 - numberOfELement(game);
        }
        int fourHeurHuman = calculateHeuristicValue(game, 4, 'X');
        if(fourHeurHuman > 0){
            return -10000 + numberOfELement(game);
        }
        int twoHeurAI = calculateHeuristicValue(game, 2, 'O');
        int twoHeurHuman = calculateHeuristicValue(game, 2, 'X');
        int threeHeurAI = calculateHeuristicValue(game, 3, 'O');
        int threeHeurHuman = calculateHeuristicValue(game, 3, 'X');
        
        int ai_point = 7*threeHeurAI + 2*twoHeurAI;
        int player_point = 7*threeHeurHuman + 2*twoHeurHuman;
        return ai_point - player_point;
    }

    private int numberOfELement(Game game) {
        int counter = 0;
        for(int i=0; i<game.getRow(); i++){
            for(int j=0; j<game.getColumn(); j++){
               if(game.getGameBoard()[i][j] != '.'){
                    counter++;
               }
            }
        }
        return counter;
    }

    private int calculateHeuristicValue(Game game, int occurence, char symbol) {
        int horizontal = calculateHorizontal(game, occurence, symbol);
        int vertical = calculateVertical(game, occurence, symbol);
        int posDiagonal = calculatePosDiagonal(game, occurence, symbol);
        int negDiagonal = calculateNegDiagonal(game, occurence, symbol);

        
        return negDiagonal + horizontal + vertical + posDiagonal;
    }

    private int calculateNegDiagonal(Game game, int occurence, char symbol) {
        int total = 0;
        char[][] gameBoard = game.getGameBoard();
        int i=0;
        int j=0;
        for(i=0; i<game.getRow(); i++){
            for(j=0; j<game.getColumn(); j++){
                if(gameBoard[i][j] == symbol){
                    boolean control = true;
                    for(int k=occurence-1; k>0; k--){
                        if(i-k < 0 || j+k >= game.getColumn()){
                            control = false;
                            break;
                        }
                        if(gameBoard[i-k][j+k] != symbol){
                            control = false;
                        }
                    }
                    if(control && occurence == 4){
                        return 1;
                    }
                    if(control){
                        int k = 4 - occurence;
                        int a = occurence; 
                        for(; k>0; k--){
                            if(i-a < 0 || j+a >= game.getColumn()){
                                control = false;
                                break;
                            }
                            if(gameBoard[i-a][j+a] != '.'){
                                control = false;
                            }
                            a++;
                        }
                        if(control){
                            total++;
                        }
                        control = true;
                        k = 4-occurence;
                        for(; k>0; k--){
                            if(i+k >= game.getRow() || j-k < 0){
                                control=false;
                                break;
                            }
                            if(gameBoard[i+k][j-k] != '.'){
                                control = false;
                            }
                        }
                        if(control){
                            total++;
                        }
                    }
                }
            }
        }
        return total;
    }

    private int calculatePosDiagonal(Game game, int occurence, char symbol) {
        int total = 0;
        char[][] gameBoard = game.getGameBoard();
        int i=0;
        int j=0;
        for(i=0; i<game.getRow(); i++){
            for(j=0; j<game.getColumn(); j++){
                if(gameBoard[i][j] == symbol){
                    boolean control = true;
                    for(int k=occurence-1; k>0; k--){
                        if(i+k >= game.getRow() || j+k >= game.getColumn()){
                            control = false;
                            break;
                        }
                        if(gameBoard[i+k][j+k] != symbol){
                            control = false;
                        }
                    }
                    if(control && occurence == 4){
                        return 1;
                    }
                    if(control){
                        int k = 4 - occurence;
                        int a = occurence; 
                        for(; k>0; k--){
                            if(i+a >= game.getRow() || j+a >= game.getColumn()){
                                control = false;
                                break;
                            }
                            if(gameBoard[i+a][j+a] != '.'){
                                control = false;
                            }
                            a++;
                        }
                        if(control){
                            total++;
                        }
                        control = true;
                        k = 4-occurence;
                        for(; k>0; k--){
                            if(i-k < 0 || j-k < 0){
                                control=false;
                                break;
                            }
                            if(gameBoard[i-k][j-k] != '.'){
                                control = false;
                            }
                        }
                        if(control){
                            total++;
                        }
                    }
                }
            }
        }
        return total;
    }

    private int calculateVertical(Game game, int occurence, char symbol) {
        int total = 0;
        char[][] gameBoard = game.getGameBoard();
        int i=0;
        int j=0;
        for(i=0; i<game.getRow(); i++){
            for(j=0; j<game.getColumn(); j++){
                if(gameBoard[i][j] == symbol){
                    boolean control = true;
                    for(int k=occurence-1; k>0; k--){
                        if(i+k >= game.getRow()){
                            control = false;
                            break;
                        }
                        if(gameBoard[i+k][j] != symbol){
                            control = false;
                        }
                    }
                    if(control && occurence == 4){
                        return 1;
                    }
                    if(control){
                        int k = 4 - occurence;
                        int a = occurence; 
                        for(; k>0; k--){
                            if(i+a >= game.getRow()){
                                control = false;
                                break;
                            }
                            if(gameBoard[i+a][j] != '.'){
                                control = false;
                            }
                            a++;
                        }
                        if(control){
                            total++;
                        }
                        control = true;
                        k = 4-occurence;
                        for(; k>0; k--){
                            if(i-k < 0){
                                control=false;
                                break;
                            }
                            if(gameBoard[i-k][j] != '.'){
                                control = false;
                            }
                        }
                        if(control){
                            total++;
                        }
                    }
                }
            }
        }
        return total;
    }

    private int calculateHorizontal(Game game, int occurence, char symbol) {
        int total = 0;
        char[][] gameBoard = game.getGameBoard();
        int i=0;
        int j=0;
        for(i=0; i<game.getRow(); i++){
            for(j=0; j<game.getColumn(); j++){
                if(gameBoard[i][j] == symbol){
                    boolean control = true;
                    for(int k=occurence-1; k>0; k--){
                        if(j+k >= game.getColumn()){
                            control = false;
                            break;
                        }
                        if(gameBoard[i][j+k] != symbol){
                            control = false;
                        }
                    }
                    if(control && occurence == 4){
                        return 1;
                    }
                    if(control){
                        int k = 4 - occurence;
                        int a = occurence; 
                        for(; k>0; k--){
                            if(j+a >= game.getColumn()){
                                control = false;
                                break;
                            }
                            if(gameBoard[i][j+a] != '.'){
                                control = false;
                            }
                            a++;
                        }
                        if(control){
                            total++;
                        }
                        control = true;
                        k = 4-occurence;
                        for(; k>0; k--){
                            if(j-k < 0){
                                control=false;
                                break;
                            }
                            if(gameBoard[i][j-k] != '.'){
                                control = false;
                            }
                        }
                        if(control){
                            total++;
                        }
                    }
                }
            }
        }
        return total;
    }

    public int getValue() {
        return value;
    }
}
