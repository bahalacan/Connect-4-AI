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
        
        int ai_point = 5*threeHeurAI + 2*twoHeurAI;
        int player_point = 5*threeHeurHuman + 2*twoHeurHuman;
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
        int total = 0;
        char[][] gameBoard = game.getGameBoard();
        int i=0;
        int j=0;
        int counter = 0;
        //horizontal check
        for(i=0; i<game.getRow(); i++){
            counter = 0;
            for(j=0; j<game.getColumn(); j++){
                if(gameBoard[i][j] == symbol){
                    counter++;
                } else {
                    counter = 0;
                }
                if(counter == occurence){
                    counter = 0;
                    switch (occurence){
                        case 2:
                            if(j < game.getColumn() - 2){
                                if(gameBoard[i][j+1] == '.' && gameBoard[i][j+2] == '.'){
                                    total++;
                                }
                            }
                            if(j > 2){
                                if(gameBoard[i][j-2] == '.' && gameBoard[i][j-3] == '.'){
                                    total++;
                                }         
                            }
                            break;
                        case 3:
                            if(j < game.getColumn() - 1){
                                if(gameBoard[i][j+1] == '.'){
                                    total++;
                                }
                            }
                            if(j > 2){
                                if(gameBoard[i][j-3] == '.'){
                                    total++;
                                }         
                            }
                            break;
                        case 4:
                            total++;
                            break;
                    }
                }
            }
        }
        //vertical check
        for(i=0; i<game.getColumn(); i++){
            counter = 0;
            for(j=0; j<game.getRow(); j++){
                if(gameBoard[j][i] == symbol){
                    counter++;
                } else {
                    counter = 0;
                }
                if(counter == occurence){
                    counter = 0;
                    switch (occurence){
                        case 2:
                            if(j < game.getRow() - 2){
                                if(gameBoard[j+1][i] == '.' && gameBoard[j+2][i] == '.'){
                                    total++;
                                }
                            }
                            if(j > 2){
                                if(gameBoard[j-2][i] == '.' && gameBoard[j-3][i] == '.'){
                                    total++;
                                }         
                            }
                            break;
                        case 3:
                            if(j < game.getRow() - 1){
                                if(gameBoard[j+1][i] == '.'){
                                    total++;
                                }
                            }
                            if(j > 2){
                                if(gameBoard[j-3][i] == '.'){
                                    total++;
                                }         
                            }
                            break;
                        case 4:
                            total++;
                            break;
                    }
                }
            }
        }
        //diagonal check
        for(i=0; i<game.getRow()-3; i++){
            for(j=0; j<game.getColumn()-3; j++){
                if(gameBoard[i][j] == symbol && gameBoard[i+1][j+1] == symbol && gameBoard[i+2][j+2] == symbol && gameBoard[i+3][j+3] == symbol){
                    return 1;
                }
            }
        }
        for(i=game.getRow()-1; i>2; i--){
            for(j=0; j<game.getColumn()-3; j++){
                if(gameBoard[i][j] == symbol && gameBoard[i-1][j+1] == symbol && gameBoard[i-2][j+2] == symbol && gameBoard[i-3][j+3] == symbol){
                    return 1;
                }
            }
        }

        return total;
    }

    public int getValue() {
        return value;
    }
}
