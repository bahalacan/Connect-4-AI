import java.util.Scanner;

public class Human extends Player {

    public Human() { //Player's symbol is X
        super('X');
    }

    @Override
    public int play(char gameBoard[][]) {
        while(true){
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("Enter move: ");
                int movement = input.nextInt();
                --movement; //when user enters 1 it means 0 for array representation
                if(!checkIsMoveLegal(movement, gameBoard)){
                    throw new Exception();
                }
                return movement;
            } catch (Exception e) {
                System.out.println("Enter correct input");
            }
        }
    }

    private boolean checkIsMoveLegal(int movement, char gameBoard[][]) {
        if(movement < 0 || movement >= gameBoard[0].length || gameBoard[0][movement] != '.' ){ // check for environment constraints
            return false;
        }
        return true;
    }
}
