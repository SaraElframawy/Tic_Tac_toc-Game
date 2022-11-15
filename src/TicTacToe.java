import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel tittle_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton [] buttons = new JButton[9];
    boolean player1_turn =true; // determine which turn for both players

    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50)); //RGB value
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("Ink Free",Font.BOLD,75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic Tac Toe"); //the first name title before we set it to whether x or o
        textField.setOpaque(true);

        tittle_panel.setLayout(new BorderLayout());
        tittle_panel.setBounds(0,0,800,100);
        tittle_panel.add(textField);

        button_panel.setLayout(new GridLayout(3,3)); // to make it like a net of 3 columns and raws
        button_panel.setBackground(new Color(150,150,150));

        for (int i=0; i<9;i++){
            buttons[i]= new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);

        }
        frame.add(tittle_panel,BorderLayout.NORTH);
        frame.add(button_panel); //adding the button panel which hold the array of buttons
        firstTurn();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i =0; i<9;i++){
            if (e.getSource()==buttons[i]){
                if(player1_turn){ //check to see if the button has text
                    if(buttons[i].getText()==""){ //check if the button is already empty
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1_turn =false;
                        textField.setText("O turn");
                        check();
                    }
                } else {
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1_turn=true;
                        textField.setText("X turn");
                        check();
                    }
                }
            }

        }

    }
    public void firstTurn (){
        try {
            Thread.sleep(2000);

        } catch (Exception e){
            e.printStackTrace();
        }
        if (random.nextInt(2)==0){
            textField.setText("X turn");
            player1_turn =true;
        } else {
            textField.setText("O turn ");
            player1_turn=false;
        }


    }
    public void check(){
        if ((buttons[0].getText().equals("X")) &&
                (buttons[1].getText().equals("X")) &&
                (buttons[2].getText().equals("X"))){
            xWins(0,1,2);

        }
        if ((buttons[3].getText().equals("X")) &&
                (buttons[4].getText().equals("X")) &&
                (buttons[5].getText().equals("X"))){
            xWins(3,4,5);

        }
        if ((buttons[6].getText().equals("X")) && //Horizontally winning
                (buttons[7].getText().equals("X")) &&
                (buttons[8].getText().equals("X"))){
            xWins(6,7,8);

        }
        if ((buttons[0].getText().equals("X")) &&
                (buttons[3].getText().equals("X")) &&
                (buttons[6].getText().equals("X"))){
            xWins(0,3,6);

        }
        if ((buttons[1].getText().equals("X")) &&
                (buttons[4].getText().equals("X")) &&
                (buttons[7].getText().equals("X"))){
            xWins(1,4,7);

        }
        if ((buttons[2].getText().equals("X")) && //Vertical winning
                (buttons[5].getText().equals("X")) &&
                (buttons[8].getText().equals("X"))){
            xWins(2,5,8);

        }
        if ((buttons[0].getText().equals("X")) &&
                (buttons[4].getText().equals("X")) &&
                (buttons[8].getText().equals("X"))){
            xWins(0,4,8);

        }


        if ((buttons[2].getText().equals("X")) && // cross winning
                (buttons[4].getText().equals("X")) &&
                (buttons[6].getText().equals("X"))){
            xWins(2,4,6);

        }

        if ((buttons[0].getText().equals("O")) && //Horizontally winning
                (buttons[1].getText().equals("O")) &&
                (buttons[2].getText().equals("O"))){
            OWins(0,1,2);

        }
        if ((buttons[3].getText().equals("O")) &&//Horizontally winning
                (buttons[4].getText().equals("O")) &&
                (buttons[5].getText().equals("O"))){
            OWins(3,4,5);

        }
        if ((buttons[6].getText().equals("O")) && //Horizontally winning
                (buttons[7].getText().equals("O")) &&
                (buttons[8].getText().equals("O"))){
            OWins(6,7,8);

        }
        if ((buttons[0].getText().equals("O")) &&  //Vertical winning
                (buttons[3].getText().equals("O")) &&
                (buttons[6].getText().equals("O"))){
            OWins(0,3,6);

        }
        if ((buttons[1].getText().equals("O")) &&  //Vertical winning
                (buttons[4].getText().equals("O")) &&
                (buttons[7].getText().equals("O"))){
            OWins(1,4,7);

        }
        if ((buttons[2].getText().equals("O")) && //Vertical winning
                (buttons[5].getText().equals("O")) &&
                (buttons[8].getText().equals("O"))){
            OWins(2,5,8);

        }
        if ((buttons[0].getText().equals("O")) && // cross winning
                (buttons[4].getText().equals("O")) &&
                (buttons[8].getText().equals("O"))){
            OWins(0,4,8);

        }
        if ((buttons[2].getText().equals("O")) && // cross winning
                (buttons[4].getText().equals("O")) &&
                (buttons[6].getText().equals("O"))){
            OWins(2,4,6);

        }





    }
    public void xWins(int a, int b,int c){
        buttons[a].setBackground(Color.GREEN); //coloring them
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i =0; i<9 ;i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("X wins");


    }
    public void OWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i =0; i<9 ;i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("O wins");



    }
}
