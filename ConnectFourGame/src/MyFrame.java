import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;


public class MyFrame extends JFrame implements ActionListener{
    Game game;
    Player player1;
    Player player2;
    boolean gameOver = false;
    ArrayList<JPanel> jpanels = new ArrayList<JPanel>();
    ArrayList<ArrayList<JButton>> buttons = new ArrayList<ArrayList<JButton>>();
    JPanel choosePanel;
    ArrayList<JButton> chooseButtons = new ArrayList<JButton>();

    MyFrame(int row, int column){
        game = new Game(row, column);
        player1 = new Human();
        player2 = new AI();
        this.setTitle("Connect4 Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(480,480); 
        

        int width = this.getWidth();
        int height = this.getHeight();
        int panelLocHeight = (height / (row + 1));
        int buttonWidth = width / column;

        for(int i=0; i<row; i++){
            JPanel jpanel = new JPanel();
            jpanel.setBounds(0, panelLocHeight * i, width, panelLocHeight);
            this.add(jpanel);
            ArrayList<JButton> a = new ArrayList<JButton>();
            for(int j=0; j<column; j++){                
                JButton button = new JButton();
                jpanel.add(button);
                button.setPreferredSize(new Dimension(buttonWidth - 10 , panelLocHeight - 10));
                button.setBackground(Color.white);
                a.add(button);         
            }
            jpanels.add(jpanel);
            buttons.add(a);
            
        }
        choosePanel = new JPanel();
        this.add(choosePanel);
        choosePanel.setBackground(Color.DARK_GRAY);
        choosePanel.setBounds(0, panelLocHeight * row, width, panelLocHeight);
        
        for(int i=0; i<column; i++){
            JButton button = new JButton();
            choosePanel.add(button);
            button.setPreferredSize(new Dimension(buttonWidth - 10 , 15));
            button.addActionListener(this);
            button.setBackground(Color.BLACK);
            chooseButtons.add(button);        
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!gameOver){
            for(int i=0; i<chooseButtons.size(); i++){
                if(e.getSource() == chooseButtons.get(i)){
                    gameOver = game.startHuman(player1, player2, i, this);
                    break;
                }
            }
        }
    }

    public void setGame(int row, int column, Player p){
        if(p instanceof AI){
            buttons.get(row).get(column).setBackground(Color.YELLOW);
        }else{
            buttons.get(row).get(column).setBackground(Color.GREEN);
        }        
    }
}

