mport java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.*; 
import javax.swing.*; 
import javax.imageio.ImageIO; 
import java.awt.image.BufferedImage; 
import java.awt.BorderLayout; 
import java.util.Random;
import java.awt.Color; 
import java.awt.Font;
import java.awt.Dimension; 
import java.awt.TextField; 
                
public class Yahtzee 
{ 
    public static void main(String [] args)
    { 
        //Create a J Frame that will hold JPanels with all elements
        JFrame frame = new JFrame("BIKINI BOTTOM YAHTZEE!"); 
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize(700, 700);
        frame.getContentPane().setBackground(new Color(173,216,230)); 
        
        //Createa  Jpanel that will hold the introductory picture, 
        //rules, starting buttons and user configuration
        JPanel rules = new JPanel(); 
        rules.setPreferredSize(new Dimension(700,500));
        rules.setLayout(new GridLayout(4,1)); 
        rules.setOpaque(false); 
        //ImageIcon Bikini = new ImageIcon(Yahtzee.class.getResource("bikinibottom.jpg"));
        JLabel intro = new JLabel(); 
                     
        // set the introductory picture and title
        /*
        intro.setIcon(Bikini); 
        intro.setText("  WELCOME TO YAHTZEE AT BIKINI BOTTOM!");             
        intro.setFont (new Font("Comic Sans MS", Font.BOLD, 24));              
        intro.setForeground(Color.YELLOW);             
        intro.setHorizontalTextPosition(JLabel.CENTER);         
        intro.setVerticalTextPosition(JButton.CENTER);  

        //create a new panel that holds the rules and add it with an object
        rules.add (intro);           
        rulesPanel panel = new rulesPanel();             
        rules.add(panel);                 
           */
        //create a new panel with the start buttons and set layout to have 2 
        JPanel startButtons = new JPanel();          
        startButtons.setLayout(new GridLayout(1,2));
        //startButtons.setPreferredSize(new Dimension(500,500));

        //create two new buttons and enable them to start the game 
        JButton start1Play = new JButton(); 
        JButton start2Play = new JButton();   
        start1Play.setEnabled(true); 
        start2Play.setEnabled(true); 

        //add the buttons to the jpanel
        startButtons.add(start1Play);           
        startButtons.add(start2Play); 
                    
        //add the rules panel to the frame 
        //frame.add(rules, BorderLayout.WEST);         
        rules.add(startButtons, BorderLayout.WEST);

        //set buttons visible 
        start1Play.setVisible(true);    
        start2Play.setVisible(true);  

        //call start the game for the button to start 
        startGame letsgo = new startGame(start1Play, start2Play); 
        rules.add(letsgo);    

        frame.setVisible(true); 
    }
      /*              
    public static class rulesPanel extends JPanel          
    {          
        private JButton play;       
        public rulesPanel()           
        {             
            // presents all the rules to the player   
            setBackground(new Color(173,216,230));          
            setLayout(new GridLayout(9,1));    

            JLabel intro = new JLabel(); 
            intro.setText("WELCOME TO YAHTZEE AT BIKINI BOTTOM!");         
            intro.setFont (new Font("Comic Sans MS", Font.BOLD, 14));              
            intro.setForeground(Color.YELLOW);             
            intro.setHorizontalTextPosition(JLabel.CENTER);         
            intro.setVerticalTextPosition(JButton.CENTER);         
                           
            JLabel rule= new JLabel ("  There are 13 rounds. Winner will get the best score with 5 dice");        
            rule.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
                           
            JLabel rule1 = new JLabel ("  Roll all the dice first, then choose to score the current dice or re-roll some (max 3 rolls/turn)");         
            rule1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
                         
            JLabel rule2 = new JLabel ("  Once you score a box, you cannot score it again, so choose wisely"); 
            rule2.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
                          
            JLabel rule3 = new JLabel ("  UPPER SECTION: \n add up all the dice with that number to score, for ex, roll four 2's, score 8 for 2");               
            rule3.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
                           
            JLabel rule4 = new JLabel ("  LOWER SECTION: \n 3 AND 4 OF A KIND: score as many points as there are for that number");        
            rule4.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
                          
            JLabel rule5 = new JLabel ("        SMALL/LARGE STRAIGHT: small is 4 consecutive die faces (30pts), large is 5 consecutive die faces (40pts)");         
            rule5.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
            
            JLabel rule6 = new JLabel ("        FULL HOUSE: 3 of one kind and 2 of another (25pts)"); 
            rule6.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
            
            JLabel rule7 = new JLabel ("        YAHTZEE: 5 of a kind (50pts), but you can choose to not score it as a yahtzee"); 
            rule7.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
            
            JLabel rule8 = new JLabel ("        CHANCE: roll anything and put it here, score the total of die faces"); 
            rule8.setFont(new Font("Comic Sans MS", Font.PLAIN, 11)); 
                
            add(rule); 
            add(rule1); 
            add(rule2); 
            add(rule3); 
            add(rule4); 
            add(rule5); 
            add(rule6); 
            add(rule7); 
            add(rule8);
        }
    }
    */
                
    public static class Player extends JPanel 
    {
        static String name; //use THIS variable for both computer and player name 
        static ImageIcon charPicked; //to add the character that the user wants
        // picture automatically set for the computer 
        
        private JTextField input;
        //private ImageIcon Sponge = new ImageIcon(getClass().getResource("spongebob.jpg")); 
        //private ImageIcon Patrick = new ImageIcon(getClass().getResource("patrick.jpg")); 
        //private ImageIcon Plankton = new ImageIcon(getClass().getResource("plankton.jpg")); 
        private JButton sponge = new JButton(); 
        private JButton patrick = new JButton(); 
        private JButton plankton = new JButton(); 
        
        int playerNum;
        
        public Player (int playerNumber)
        {
        	
            setLayout (new GridLayout(1,4)); 
            
            //make a new panel to get name input from the user 
            JPanel userName = new JPanel(); 
            userName.setLayout(new GridLayout (2,1)); 
            userName.setBackground(new Color (173, 188, 230)); 

            //create user prompt to enter text
            JLabel prompt = new JLabel(); 
            prompt.setText("  Enter player name & pick icon"); 
            prompt.setFont (new Font ("Comic Sans MS", Font.PLAIN, 11)); 
            prompt.setBackground (new Color (173, 188, 230)); 

            //create j text field 
            userName.add(prompt); 
            input = new JTextField(15); 
            input.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));   
            input.setEditable(true); 
            input.setVisible(true); 
            input.setBackground(new Color(173,216,250)); 
            userName.add (input);   

            //add username enter panel
            add(userName); 

            //add action listeners to store user name 
            TextFieldHandler handler = new TextFieldHandler(); 
            input.addActionListener(handler);        
        
            // add pictures to all the character buttons and add to JPanel 
            //sponge.setIcon (Sponge); 
            //patrick.setIcon(Patrick); 
            //plankton.setIcon(Plankton); 
            sponge.setVisible(true); 
            patrick.setVisible(true); 
            plankton.setVisible(true); 
            sponge.setEnabled(true); 
            patrick.setEnabled(true); 
            plankton.setEnabled(true); 

            //add spongebob text to sponge button 
            sponge.setText("SPONGEBOB!"); 
            sponge.setFont(new Font("Comic Sans MS", Font.BOLD, 14)); 
            sponge.setHorizontalTextPosition(JButton.CENTER);
            sponge.setVerticalTextPosition(JButton.CENTER);
            sponge.setForeground(Color.BLACK);    

            //add patrick text to the patrick button 
            patrick.setText("PATRICK!"); 
            patrick.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
            patrick.setHorizontalTextPosition(JButton.CENTER);
            patrick.setVerticalTextPosition(JButton.CENTER);
            patrick.setForeground(Color.BLACK);    

            //add plankton text to the plankton button
            plankton.setText("PLANKTON!"); 
            plankton.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
            plankton.setHorizontalTextPosition(JButton.CENTER);
            plankton.setVerticalTextPosition(JButton.CENTER);
            plankton.setForeground(Color.BLACK);    
            
            //add three buttons to the panel
            add (sponge); 
            add (patrick); 
            add (plankton); 
            
            //add picture handler 
            PictureHandler handle = new PictureHandler(); 
            //add action listeners to all three buttons
            sponge.addActionListener(handle); 
            patrick.addActionListener(handle); 
            plankton.addActionListener(handle); 
        }
        private class TextFieldHandler implements ActionListener
        { 
            //text field action listener to enable when user has entered name
            public void actionPerformed ( ActionEvent event )
            { 
                //to load the name onto the string
                if (event.getSource() == input)
                name = input.getText();  //store the name in member data string 
                input.setEditable(false); 
            }
        }

        private class PictureHandler implements ActionListener
        {
            public void actionPerformed (ActionEvent event)
            {
            	/*
                //decide which character to assign to the user based on what they pick
                if (event.getSource() == sponge)
                    charPicked = Sponge;
                
                else if (event.getSource() == patrick)
                    charPicked = Patrick;
                
                else if (event.getSource() == plankton)
                    charPicked = Plankton; 
            */
                ScoreCard.main(null);
                //disable buttons
                sponge.setEnabled(false); 
                patrick.setEnabled(false); 
                plankton.setEnabled(false); 
                invalidate();
                validate();
                repaint();
            }
        }
    }
    
    public static class startGame extends JPanel 
    { 
        private JButton play1; 
        private JButton play2; 
    
        
        //add two buttons for single and two players 
        //ImageIcon Play1 = new ImageIcon(getClass().getResource("solo.png"));
        //ImageIcon Play2 = new ImageIcon(getClass().getResource("2players.png")); 
        startGame(JButton start1Play, JButton start2Play )
        {
            super(); 
            //set the grid layout for the two buttons 
            setLayout (new GridLayout(2,1)); 

            //add 1 player button 
            play1 = new JButton(); 
            play1 = start1Play; 
            //play1.setIcon (Play1);
            play1.setText("ONE PLAYER"); 
            play1.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
            play1.setHorizontalTextPosition(JButton.CENTER);
            play1.setVerticalTextPosition(JButton.CENTER);
            play1.setForeground(Color.BLACK);    
        
            //add 2 player buttons 
            play2 = new JButton(); 
            play2 = start2Play; 
            //play2.setIcon(Play2); 
            play2.setText("TWO PLAYER"); 
            play2.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
            play2.setHorizontalTextPosition(JButton.CENTER);
            play2.setVerticalTextPosition(JButton.CENTER);
            play2.setForeground(Color.BLACK);  

            // add button handlers for 1 and 2 players 
            JButtonHandler handler = new JButtonHandler(); 
            play1.addActionListener(handler);
            play2.addActionListener(handler); 

            setBackground(new Color(173,216,230)); 
            
        }//end startgame constructor 
        
        public class JButtonHandler implements ActionListener 
        { 
            public void actionPerformed ( ActionEvent event )
            { 
                int numberofPlayers; 
                //determine how many players to add based on number of players 
                if (event.getSource() == play1)
                {
                    Player player1 = new Player(1); 
                    add(player1);
                    
                    invalidate();
                    validate();
                    repaint();
                    
                    play1.setEnabled(false);
                    play2.setEnabled(false);
 
                }
                
                else if (event.getSource() == play2)
                {
                    //add two players and refresh 
                    Player player1 = new Player(1); 
                    Player player2 = new Player(2); 
                    
                
                    add(player1); 
                    add(player2); 
                    invalidate(); 
                    validate(); 
                    repaint(); 
                
                    play2.setEnabled(false); 
                    play1.setEnabled(false);    
                }
                
                Dice dice = new Dice(); 
                dice.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                dice.setSize( 700, 100 ); // set frame size
                dice.setVisible( true ); // display frame

            }
        }
    }
}
        

