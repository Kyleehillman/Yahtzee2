import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color; 
import java.awt.Font;
import java.awt.event.*; 
import javax.swing.*; 
import java.awt.BorderLayout; 
import java.util.Random;
import java.awt.Dimension; 
import java.awt.TextField; 
                
public class Yahtzee 
{ 
    public static void main(String [] args)
    { 
        //Creates jFrame to hold panel elemnts
        JFrame jframe = new JFrame("YAHTZEE!"); 
        jframe.setLayout(new BorderLayout());
        jframe.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        jframe.setSize(700, 700);
        jframe.getContentPane().setBackground(new Color(173,216,230)); 
        
  
        JLabel start = new JLabel(); 
                     
        //intro frAME
        start.setText("  Lets PLAY YAHTZEE!");             
        start.setFont (new Font("Calibri", Font.PLAIN, 24));              
        start.setForeground(Color.YELLOW);             
        start.setHorizontalTextPosition(JLabel.CENTER);         
        start.setVerticalTextPosition(JButton.CENTER);  

        //start buttons
        JPanel startButton = new JPanel();          
        startButton.setLayout(new GridLayout(1,2));
        startButton.setPreferredSize(new Dimension(500,500));

        //allow them to start the game
        JButton start1Player = new JButton(); 
        JButton start2Player = new JButton();   
        start1Player.setEnabled(true); 
        start2Player.setEnabled(true); 

        //add the buttons to the jpanel
        startButton.add(start1Player);           
        startButton.add(start2Player); 
                      

        //set buttons visible 
        start1Player.setVisible(true);    
        start2Player.setVisible(true);  

        //call start the game for the button to start 
        startGame begin = new startGame(start1Player, start2Player); 
        rules.add(begin);    

        jframe.setVisible(true); 
    }
   
                
    public static class Player extends JPanel 
    {
        static String name; 
 
        
        private JTextField input;
        
        int numPLayers;
        
        public Player (int numPlayer)
        {
        	
            setLayout (new GridLayout(1,4)); 
            
            //make a new panel to get name input from the user 
            JPanel names = new JPanel(); 
            names.setLayout(new GridLayout (2,1)); 
            names.setBackground(new Color (173, 188, 230)); 

            //ask user to enter player name
            JLabel prompt = new JLabel(); 
            prompt.setText("  Enter player name"); 
            prompt.setFont (new Font ("Calibri", Font.PLAIN, 12)); 
            prompt.setBackground (new Color (173, 188, 230)); 

            //create j text field 
            names.add(prompt); 
            input = new JTextField(15); 
            input.setFont(new Font("Calibri", Font.PLAIN, 12));   
            input.setEditable(true); 
            input.setVisible(true); 
            input.setBackground(new Color(173,216,250)); 
            names.add (input);   

            //add username enter panel
            add(names); 

            //store username
            TextFieldHandler handler = new TextFieldHandler(); 
            input.addActionListener(handler);        
        
             
        }
        private class TextFieldHandler implements ActionListener
        { 
            //text field action listener to enable when user has entered name
            public void actionPerformed ( ActionEvent event )
            { 
                //to load the name onto the string
                if (event.getSource() == input)
                name = input.getText();  
                input.setEditable(false); 
            }
        }
    }
    
    public static class startGame extends JPanel 
    { 
        private JButton players1; 
        private JButton players2; 
    
        //game for 2 players
        startGame(JButton start1Player, JButton start2Player )
        {
            super(); 
            //set the grid layout for the two buttons 
            setLayout (new GridLayout(2,1)); 

            //1 player buttons
            players1 = new JButton(); 
            players1 = start1Play; 
            players1.setText("One-player"); 
            players1.setFont(new Font("Calibri", Font.PLAIN, 30));
            players1.setHorizontalTextPosition(JButton.CENTER);
            players1.setVerticalTextPosition(JButton.CENTER);
            players1.setForeground(Color.BLACK);    
        
            //a2 player buttons
            players2 = new JButton(); 
            players2 = start2Play;
            players2.setText("Two-payer"); 
            players2.setFont(new Font("Calibri", Font.PLAIN, 30));
            players2.setHorizontalTextPosition(JButton.CENTER);
            players2.setVerticalTextPosition(JButton.CENTER);
            players2.setForeground(Color.BLACK);  

            // buttons for 1 player and two
            JButtonHandler handler = new JButtonHandler(); 
            players1.addActionListener(handler);
            players2.addActionListener(handler); 

            setBackground(new Color(173,216,230)); 
            
        } 
        
        public class JButtonHandler implements ActionListener 
        { 
            public void actionPerformed ( ActionEvent event )
            { 
                int numberofPlayers; 
                //determine how many players
                if (event.getSource() == players1)
                {
                    Player p1 = new Player(1); 
                    add(p1);
                    
                    invalidate();
                    validate();
                    repaint();
                    
                    players1.setEnabled(false);
                    players2.setEnabled(false);
 
                }
                
                else if (event.getSource() == players2)
                {
                    //add two players and refresh 
                    Player p1 = new Player(1); 
                    Player p2 = new Player(2); 
                    
                
                    add(p1); 
                    add(p2); 
                    invalidate(); 
                    validate(); 
                    repaint(); 
                
                    players2.setEnabled(false); 
                    players1.setEnabled(false);    
                }
                
                Dice dice = new Dice(); 
                dice.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                dice.setSize( 700, 100 ); // set frame size
                dice.setVisible( true ); // display frame

            }
        }
    }
}
        

