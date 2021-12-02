avax.swing.*;

import org.w3c.dom.events.MouseEvent;

import java.awt.*;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

public class Dice extends JFrame
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color cardCol = new Color(255,102,0);
    private int numOnDice1;
    private int numOnDice2;
    private int numOnDice3;
    private int numOnDice4;
    private int numOnDice5;
    private JLabel keptDice;
    public JLabel name;
    private JButton roll;
    private JButton doneroll;
    private JButton newroll;
    public Icon idice1;
    public Icon idice2;
    public Icon idice3;
    public Icon idice4;
    public Icon idice5;
    int maxNumRoll = 0;
    static int[] die = new int[5];
    Vector<Integer> diceSelected = new Vector<>();
    //each die as member data
    singleDie dice1 = new singleDie();
    singleDie dice2 = new singleDie();
    singleDie dice3 = new singleDie();
    singleDie dice4 = new singleDie();
    singleDie dice5 = new singleDie();
    
    singleDie dice1kept = new singleDie();
    singleDie dice2kept = new singleDie();
    singleDie dice3kept = new singleDie();
    singleDie dice4kept = new singleDie();
    singleDie dice5kept = new singleDie();
    
    //gives eahc die a number, icon and Jlabel
    public class singleDie
    {
        boolean visible;
        int valueOnDie;
        private int dieNum;
        public JLabel label;
        public ImageIcon icon;
        
        public singleDie()
        {
        
        }
        
        public int getDieNum(JLabel singleDie)
        {
            return dieNum;
        }
        public int getDieVal()
        {
            return valueOnDie;
        }
        public void visibile()
        {
            label.setVisible(true);
        }
        
        public void notVisible()
        {
             label.setVisible(false);
        }
        
        //sets die values
        public void setValueOnDie(int x)
        {
            if(x == 1)
            {
                valueOnDie = 1;
            }
            else if(x == 2)
            {
                valueOnDie = 2;
            }
            else if(x == 3)
            {
                valueOnDie = 3;
            }
            else if(x == 4)
            {
                valueOnDie = 4;
            }
            else if(x == 5)
            {
                valueOnDie = 5;
            }
            else if(x == 6)
            {
                valueOnDie = 6;
            }
        }
        //sets die numbers
        public void setDieNumber(int x)
        {
            if(x == 1)
            {
                dieNum = 1;
            }
            else if(x == 2)
            {
                dieNum = 2;
            }
            else if(x == 3)
            {
                dieNum = 3;
            }
            else if(x == 4)
            {
                dieNum = 4;
            }
            else if(x == 5)
            {
                dieNum = 5;
            }
            
        }
        //used given number to set icon to jlabel
        public void setIcon(int x)
        {
            switch(x)
            {
                case 1:
                    icon = new ImageIcon(getClass().getResource("die1.png"));
                    label = new JLabel(icon);
                    add(label);
                    label.addMouseListener(new MouseAdapter()
                    {
                        public void mouseClicked(MouseEvent mouseevent)
                        {
                            diceSelected.add(valueOnDie);
                            label.setVisible(false);
                        }
                    });
                    break;
                case 2:
                    icon = new ImageIcon(getClass().getResource("die2.png"));
                    label = new JLabel(icon);
                    add(label);
                    label.addMouseListener(new MouseAdapter()
                    {
                        public void mouseClicked(MouseEvent mouseevent)
                        {
                            diceSelected.add(valueOnDie);
                            label.setVisible(false);
                        }
                    });
                    break;
                case 3:
                    icon = new ImageIcon(getClass().getResource("die3.png"));
                    label = new JLabel(icon);
                    add(label);
                    label.addMouseListener(new MouseAdapter()
                    {
                        public void mouseClicked(MouseEvent mouseevent)
                        {
                            diceSelected.add(valueOnDie);
                            label.setVisible(false);
                        }
                    });
                    break;
                case 4:
                    icon = new ImageIcon(getClass().getResource("die4.png"));
                    label = new JLabel(icon);
                    add(label);
                    label.addMouseListener(new MouseAdapter()
                    {
                        public void mouseClicked(MouseEvent mouseevent)
                        {
                            diceSelected.add(valueOnDie);
                            label.setVisible(false);
                        }
                    });
                    break;
               case 5:
                    icon = new ImageIcon(getClass().getResource("die5.png"));
                    label = new JLabel(icon);
                    add(label);
                    label.addMouseListener(new MouseAdapter()
                    {
                        public void mouseClicked(MouseEvent mouseevent)
                        {
                            diceSelected.add(valueOnDie);
                            label.setVisible(false);
                        }
                    });
                    break;
            }
        }
        //set icon to jlabel
        public void setIHeld(singleDie die, int x)
        {
            switch(x)
            {
                   case 1:
                       if(label == null)
                       {
                            label = new JLabel();
                            //image update
                            die.label.setIcon(new ImageIcon(getClass().getResource("die1.png")));
                            add(die.label);
                        }
                        if(label != null)
                        {
                            die.label.setIcon(new ImageIcon(getClass().getResource("die1.png")));
                        }
                        break;
                    case 2:
                        if(label == null)
                        {
                            label = new JLabel();
                            //image update
                            die.label.setIcon(new ImageIcon(getClass().getResource("die2.png")));
                            add(die.label);
                        }
                        if(label != null)
                        {
                            die.label.setIcon(new ImageIcon(getClass().getResource("die2.png")));
                        }
                        break;
                    case 3:
                        if(label == null)
                        {
                            label = new JLabel();
                            //image update
                            die.label.setIcon(new ImageIcon(getClass().getResource("die3.png")));
                            add(die.label);
                        }
                        if(label != null)
                        {
                            die.label.setIcon(new ImageIcon(getClass().getResource("die3.png")));
                        }
                        break;
                    case 4:
                        if(label == null)
                        {
                            label = new JLabel();
                            //image update
                            die.label.setIcon(new ImageIcon(getClass().getResource("die4.png")));
                            add(die.label);
                        }
                        if(label != null)
                        {
                            die.label.setIcon(new ImageIcon(getClass().getResource("die4.png")));
                        }
                        break;
                    case 5:
                        if(label == null)
                        {
                            label = new JLabel();
                            //image update
                            die.label.setIcon(new ImageIcon(getClass().getResource("die5.png")));
                            add(die.label);
                        }
                        if(label != null)
                        {
                            die.label.setIcon(new ImageIcon(getClass().getResource("die5.png")));
                        }
                        break;
                    case 6:
                        if(label == null)
                        {
                            label = new JLabel();
                            //image update
                            die.label.setIcon(new ImageIcon(getClass().getResource("die6.png")));
                            add(die.label);
                        }
                        if(label != null)
                        {
                            die.label.setIcon(new ImageIcon(getClass().getResource("die6.png")));
                        }
                        break;
            }
        }
    }
    //shoes the dice being held
    void diceHeld(singleDie die, int x)
    {
        die.setIHeld(die,x);
        die.label.setVisible(true);
    }
    void endArray(singleDie die)
    {
    	if(die.label.isVisible() == true)
    		diceSelected.add(die.getDieVal());
    }
    //before restarting make false
    void restartf(singleDie die)
    {
        die.label.setVisible(false);
    }
    //after restart make true
    void restartt(singleDie die)
    {
       die.label.setVisible(true);
    }
    //if held dice is true set die to false for restart
    void heldRestart(singleDie die)
    {
        if(die.label.isVisible() == true)
            die.label.setVisible(false);
    }
    void Restart(singleDie die)
    {
        Random rand = new Random();
        int randNum = rand.nextInt(5)+1;
        
        if(randNum == 0)
            randNum = randNum + 1;
           
        //set die values with random num
        die.setValueOnDie(randNum);
        switch(randNum)
        {
            case 1:
                die.label.setIcon(new ImageIcon(getClass().getResource("die1.png")));
                break;
            case 2:
                die.label.setIcon(new ImageIcon(getClass().getResource("die2.png")));
                break;
            case 3:
                die.label.setIcon(new ImageIcon(getClass().getResource("die3.png")));
                break;
            case 4:
                die.label.setIcon(new ImageIcon(getClass().getResource("die4.png")));
                break;
            case 5:
                die.label.setIcon(new ImageIcon(getClass().getResource("die5.png")));
                break;
         }
     }
     
     void Reroll(singleDie die)
     {
         //make sure die has not been clicked already
         if(die.label.isVisible() == false)
         {
             Random rand = new Random();
             int randNum = rand.nextInt(5)+1;
             
             if(randNum == 0)
                 randNum = randNum + 1;
                 
             //set value on die to new random num
             switch(randNum)
             {
                 case 1:
                    die.label.setIcon(new ImageIcon(getClass().getResource("die1.png")));
                    break;
                 case 2:
                    die.label.setIcon(new ImageIcon(getClass().getResource("die2.png")));
                    break;
                 case 3:
                    die.label.setIcon(new ImageIcon(getClass().getResource("die3.png")));
                   break;
                 case 4:
                    die.label.setIcon(new ImageIcon(getClass().getResource("die4.png")));
                   break;
                 case 5:
                    die.label.setIcon(new ImageIcon(getClass().getResource("die5.png")));
                  break;
            }
       }
   }
   public Dice()
   {
	   super("Yahtzee Dice");
       setLayout(new FlowLayout());
       getContentPane().setBackground(cardCol);
       
       roll = new JButton("Roll the dice");
       doneroll = new JButton("Done rolling");
       newroll = new JButton("New roll");
       roll.setFont(new Font("Calibri", Font.PLAIN, 12));
       doneroll.setFont(new Font("Calibri", Font.PLAIN, 12));
       newroll.setFont(new Font("Calibri", Font.PLAIN, 12));
       roll.setBounds(100,100,50,60);
       doneroll.setBounds(100,100,50,60);
       newroll.setBounds(100,100,50,60);
       newroll.setVisible(false);
       add(roll);
       add(doneroll);
       add(newroll);
       
       Random dNum1 = new Random();
       Random dNum2 = new Random();
       Random dNum3 = new Random();
       Random dNum4 = new Random();
       Random dNum5 = new Random();
       
       idice1 = new ImageIcon(getClass().getResource("die1.png"));
       idice2 = new ImageIcon(getClass().getResource("die2.png"));
       idice3 = new ImageIcon(getClass().getResource("die3.png"));
       idice4 = new ImageIcon(getClass().getResource("die4.png"));
       idice5 = new ImageIcon(getClass().getResource("die5.png"));
       
       //get values from rolls and ensure theyre not 0
       numOnDice1 = dNum1.nextInt(5)+1;
       if(numOnDice1 == 0)
    	   numOnDice1 += 1;
           
       numOnDice2 = dNum2.nextInt(5)+1;
       if(numOnDice2 == 0)
    	   numOnDice2 += 1;
           
       numOnDice3 = dNum3.nextInt(5)+1;
       if(numOnDice3 == 0)
    	   numOnDice3 += 1;
           
       numOnDice4 = dNum4.nextInt(5)+1;
       if(numOnDice4 == 0)
    	   numOnDice4 += 1;
           
       numOnDice5 = dNum5.nextInt(5)+1;
       if(numOnDice5 == 0)
    	   numOnDice5 += 1;
           
       //set dice num, value on dice and icons
       dice1.setDieNumber(1);
       dice1.setValueOnDie(numOnDice1);
       dice1.setIcon(numOnDice1);
       dice2.setDieNumber(2);
       dice2.setValueOnDie(numOnDice2);
       dice2.setIcon(numOnDice2);
       dice3.setDieNumber(3);
       dice3.setValueOnDie(numOnDice3);
       dice3.setIcon(numOnDice3);
       dice4.setDieNumber(4);
       dice4.setValueOnDie(numOnDice4);
       dice4.setIcon(numOnDice4);
       dice5.setDieNumber(5);
       dice5.setValueOnDie(numOnDice5);
       dice5.setIcon(numOnDice1);
       
       DiceTracker tracker = new DiceTracker();
       roll.addActionListener(tracker);
       doneroll.addActionListener(tracker);
       newroll.addActionListener(tracker);
       
       //jlabel for held dice
       keptDice = new JLabel("Dice being held:");
       keptDice.setFont(new Font("Calibri", Font.PLAIN, 12));
       add(keptDice);
       keptDice.setVisible(false);
   }
   public class DiceTracker implements ActionListener
   {
   public void actionPerformed(ActionEvent event)
   {
         if (event.getSource() == roll)
         {
            StringBuilder sb = new StringBuilder("Dice being held: ");
            keptDice.setVisible(true);
            if(diceSelected.size() == 1)
               diceHeld(dice1kept,(diceSelected.get(0)));
            if(diceSelected.size() == 2)
            {
               diceHeld(dice1kept,(diceSelected.get(0)));
               diceHeld(dice2kept,(diceSelected.get(1)));
            }
            if(diceSelected.size() == 3)
            {
               diceHeld(dice1kept,(diceSelected.get(0)));
               diceHeld(dice2kept,(diceSelected.get(1)));
               diceHeld(dice3kept,(diceSelected.get(2)));
            }
            if(diceSelected.size() == 4)
            {
               diceHeld(dice1kept,(diceSelected.get(0)));
               diceHeld(dice2kept,(diceSelected.get(1)));
               diceHeld(dice3kept,(diceSelected.get(2)));
               diceHeld(dice3kept,(diceSelected.get(3)));
            }
            if(diceSelected.size() == 5)
            {
               diceHeld(dice1kept,(diceSelected.get(0)));
               diceHeld(dice2kept,(diceSelected.get(1)));
               diceHeld(dice3kept,(diceSelected.get(2)));
               diceHeld(dice4kept,(diceSelected.get(3)));
               diceHeld(dice5kept,(diceSelected.get(4)));
            }
            Reroll(dice1);
            Reroll(dice2);
            Reroll(dice3);
            Reroll(dice4);
            Reroll(dice5);
            String str = sb.toString();
            keptDice.setText(str);
            //update the dice being kept
            invalidate();
            validate();
            repaint();
            maxNumRoll++;
            if(maxNumRoll >= 3)
            {
                endArray(dice1);
                endArray(dice2);
                endArray(dice3);
                endArray(dice4);
                endArray(dice5);
                roll.setVisible(false);
                for(int i = 0; i < diceSelected.size(); i++)
                {
                    die[i] = diceSelected.get(i);
                }
                
                diceHeld(dice1kept, die[0]);
                diceHeld(dice2kept, die[1]);
                diceHeld(dice3kept, die[2]);
                diceHeld(dice4kept, die[3]);
                diceHeld(dice5kept, die[4]);
                newroll.setVisible(true);
                
                restartf(dice1);
                restartf(dice2);
                restartf(dice3);
                restartf(dice4);
                restartf(dice5);
                
                invalidate();
                validate();
                repaint();
            }
        }
        if(event.getSource() == newroll) 
        {
        	maxNumRoll = 0;
        	diceSelected.clear();
        	Arrays.fill(die,  0);
        	keptDice.setVisible(false);
        	roll.setVisible(true);
        	newroll.setVisible(false);
        	
        	 diceSelected.clear();
             Restart(dice1);
             restartt(dice1);
             Restart(dice2);
             restartt(dice2);
             Restart(dice3);
             restartt(dice3);
             Restart(dice4);
             restartt(dice4);
             Restart(dice5);
             restartt(dice5);

             heldRestart(dice1kept);
             heldRestart(dice2kept);
             heldRestart(dice3kept);
             heldRestart(dice4kept);
             heldRestart(dice5kept);


        	
        }
        if(event.getSource() == doneroll);
        {
            endArray(dice1);
            endArray(dice2);
            endArray(dice3);
            endArray(dice4);
            endArray(dice5);
            
            roll.setVisible(false);
            for(int i = 0; i < diceSelected.size(); i++)
            {
                die[i] = diceSelected.get(i);
            }
            keptDice.setVisible(true);
            diceHeld(dice1kept,die[0]);
            diceHeld(dice2kept,die[1]);
            diceHeld(dice3kept,die[2]);
            diceHeld(dice4kept,die[3]);
            diceHeld(dice5kept,die[4]);
      
            restartf(dice1);
            restartf(dice2);
            restartf(dice3);
            restartf(dice4);
            restartf(dice5);
            
            newroll.setVisible(true);;
            invalidate();
            validate();
            repaint();
            
        }
   }
   }
   public static void main(String args[]){ 
		
   }
}

        
       
       
       
       
       
       
             
             
         
                 
            
            
                    
                
                
                    
        
            
       
      
    
    
    
        
    




