import java.awt.event.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ScoreCard extends JFrame
{
    
	private static final long serialVersionUID = 1L;
	ScoreCardJPanel scjp;
    static int num;
    public static void main(String args[])
    {
        JFrame jframe = new JFrame("ScoreCard");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //set default background color
        jframe.getContentPane().setBackground(Color.WHITE);
        
	  	  
	    //set flow layout	
        jframe.setLayout(new FlowLayout()); 
		
        ScoreCardJPanel scjp = new ScoreCardJPanel();
	    //put scorecard in frame
        jframe.add(scjp); 
	    jframe.setVisible(true);
    }
    
    ScoreCard()
    {
    }
}

class ScoreCardJPanel extends JPanel
{
    private LowercardJPanel l;
    private UppercardJPanel u;
    //figure out pathway below
    //ImageIcon win = new ImageIcon(src/hw);
    //store lower points
    private int lower[] = new int[7];
    //store upper points
    private int upper[] = new int[6];
    //turn tracker
    static int turnTracker = 0;
    int sum = 0;
    //point tally
    private int points = 0;
    //upper points
    private int upoints = 0;
    //lower points 
    private int lpoints = 0;
    private JLabel finalTotal;
    private JLabel fTotal;
    //total number of points
    private int totalPoints;
    //setting colors 
    private Color cardC = new Color(255,0,0); //red
    private Color bC = new Color(255,245,108); //yellow
    
    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(450,550);
    }
    
    class UppercardJPanel extends JPanel
    {
        private JLabel heading;
        //category buttons
	private JButton b1, b2, b3, b4 , b5, b6;
	//point display
	private JLabel p1, p2, p3, p4, p5, p6, totalUP, totalUP2;
	
	public  UppercardJPanel()
	{
	    setBackground(cardC);
	    setLayout(new GridLayout(8,2,10,10));
	    //labels and buttons
	    heading = new JLabel("Upper Card");
	    heading.setFont(new Font("Calibri", Font.PLAIN, 12));
	    
	    b1 = new JButton("Aces");
	    b1.setPreferredSize(new Dimension(10,10));
	    b1.setFont(new Font("Calbri", Font.PLAIN, 12));
	    b1.addActionListener(new ActionUpper1());
	    
	    p1 = new JLabel(String.valueOf(upper[0]));
	    p1.setFont(new Font("Calibri", Font.PLAIN, 12));
	    
	    b2 = new JButton("Twos");
	    b2.setFont(new Font("Calbri", Font.PLAIN, 12));
	    b2.addActionListener(new ActionUpper2());
	    
	    p2 = new JLabel(String.valueOf(upper[1]));
	    p2.setFont(new Font("Calibri", Font.PLAIN, 12));
	    
	    b3 = new JButton("Threes");
	    b3.setFont(new Font("Calbri", Font.PLAIN, 12));
	    b3.addActionListener(new ActionUpper3());
	    
	    p3 = new JLabel(String.valueOf(upper[2]));
	    p3.setFont(new Font("Calibri", Font.PLAIN, 12));
	    
	    b4 = new JButton("Fours");
	    b4.setFont(new Font("Calbri", Font.PLAIN, 12));
	    b4.addActionListener(new ActionUpper4());
	    
	    p4 = new JLabel(String.valueOf(upper[3]));
	    p4.setFont(new Font("Calibri", Font.PLAIN, 12));
	    
	    b5 = new JButton("Fives");
	    b5.setFont(new Font("Calbri", Font.PLAIN, 12));
	    b5.addActionListener(new ActionUpper5());
	    
	    p5 = new JLabel(String.valueOf(upper[4]));
	    p5.setFont(new Font("Calibri", Font.PLAIN, 12));
	    
	    b6 = new JButton("Sixes");
	    b6.setFont(new Font("Calbri", Font.PLAIN, 12));
	    b6.addActionListener(new ActionUpper6());
	    
	    p6 = new JLabel(String.valueOf(upper[5]));
	    p6.setFont(new Font("Calibri", Font.PLAIN, 12));
	    
	    totalUP = new JLabel("Upper Score");
	    totalUP.setFont(new Font("Calibri", Font.PLAIN, 12));
	    
	    upoints = pointsTally(upper);
	    totalUP2 = new JLabel(String.valueOf(upoints));
	    totalUP2.setFont(new Font("Calibri", Font.PLAIN, 12));
	    
	    //add all labels and headers
	    add(heading);
	    add(new JLabel(""));
	    add(b1);
	    add(p1);
	    add(b2);
	    add(p2);
	    add(b3);
	    add(p3);
	    add(b4);
	    add(p4);
	    add(b5);
	    add(p5);
	    add(b6);
	    add(p6);
	    add(totalUP);
	    add(totalUP2);
	    }
	    //aces button
	    class ActionUpper1 implements ActionListener
	    {
	        public void actionPerformed(ActionEvent event)
	        {
		    //calculate the num of dice points
		    sum = diceSum(1);
		    upper[0] = sum;
		    //update num of points on card
		    p1.setText(String.valueOf(upper[0]));
		    sum = 0;
		    //total update on card
		    upoints = pointsTally(upper);
		    totalUP.setText(String.valueOf(upoints));
		    JButton source = (JButton) event.getSource();
		    //so you cant click twice
		    source.setEnabled(false);
		    
		    totalPoints = pointsTally(upper) + pointsTally(lower);
		    fTotal.setText(String.valueOf(totalPoints));
		    turnTracker++;
		   }
        }
	    //action lister for twos  
	    class ActionUpper2 implements ActionListener
	    {
	        public void actionPerformed(ActionEvent event)
		{
		    //calculate num on dice
		    sum = diceSum(2);
		    upper[1] = sum;
		    p2.setText(String.valueOf(upper[1]));
		    sum = 0;
		    //upper total on card updated
		    upoints = pointsTally(upper);
		    totalUP.setText(String.valueOf(upoints));
		    JButton source = (JButton) event.getSource();
		    //stops from double clicking
		    source.setEnabled(false);
		    totalPoints = pointsTally(upper) + pointsTally(lower);
		    fTotal.setText(String.valueOf(totalPoints));
		    //add number to turn tracker
		    turnTracker++;
		 }
	     }
	     //action listerns for next buttons are similar to previous two
	     class ActionUpper3 implements ActionListener
	    {
	        public void actionPerformed(ActionEvent event)
		{
		    //calculate num on dice
		    sum = diceSum(3);
		    upper[2] = sum;
		    p2.setText(String.valueOf(upper[2]));
		    sum = 0;
		    //upper total on card updated
		    upoints = pointsTally(upper);
		    totalUP.setText(String.valueOf(upoints));
		    JButton source = (JButton) event.getSource();
		    //stops from double clicking
		    source.setEnabled(false);
		    totalPoints = pointsTally(upper) + pointsTally(lower);
		    fTotal.setText(String.valueOf(totalPoints));
		    //add number to turn tracker
		    turnTracker++;
		 }
	     }
	     class ActionUpper4 implements ActionListener
	     {
	        public void actionPerformed(ActionEvent event)
		{
		    //calculate num on dice
		    sum = diceSum(4);
		    upper[3] = sum;
		    p2.setText(String.valueOf(upper[3]));
		    sum = 0;
		    //upper total on card updated
		    upoints = pointsTally(upper);
		    totalUP.setText(String.valueOf(upoints));
		    JButton source = (JButton) event.getSource();
		    //stops from double clicking
		    source.setEnabled(false);
		    totalPoints = pointsTally(upper) + pointsTally(lower);
		    fTotal.setText(String.valueOf(totalPoints));
		    //add number to turn tracker
		    turnTracker++;
		 }
	     }
	     class ActionUpper5 implements ActionListener
	     {
	        public void actionPerformed(ActionEvent event)
		{
		    //calculate num on dice
		    sum = diceSum(5);
		    upper[4] = sum;
		    p2.setText(String.valueOf(upper[4]));
		    sum = 0;
		    //upper total on card updated
		    upoints = pointsTally(upper);
		    totalUP.setText(String.valueOf(upoints));
		    JButton source = (JButton) event.getSource();
		    //stops from double clicking
		    source.setEnabled(false);
		    totalPoints = pointsTally(upper) + pointsTally(lower);
		    fTotal.setText(String.valueOf(totalPoints));
		    //add number to turn tracker
		    turnTracker++;
		 }
	     }
	     class ActionUpper6 implements ActionListener
	     {
	        public void actionPerformed(ActionEvent event)
		   {
		    //calculate num on dice
		    sum = diceSum(6);
		    upper[5] = sum;
		    p2.setText(String.valueOf(upper[5]));
		    sum = 0;
		    //upper total on card updated
		    upoints = pointsTally(upper);
		    totalUP.setText(String.valueOf(upoints));
		    JButton source = (JButton) event.getSource();
		    //stops from double clicking
		    source.setEnabled(false);
		    totalPoints = pointsTally(upper) + pointsTally(lower);
		    fTotal.setText(String.valueOf(totalPoints));
		    //add number to turn tracker
		    turnTracker++;
		 }
	     }
	 }
	 //special combinations scorecard
	 class LowercardJPanel extends JPanel
	 {
	     private JLabel heading2;
	     //buttons for dif special combos
	     private JButton Yah;
	     private JButton largeSt;
	     private JButton smallSt;
	     private JButton threeofK;
	     private JButton fourofK;
	     private JButton fullHouse;
	     private JButton chance;
	     //points in each special combo 
	     private JLabel pYah;
	     private JLabel plargeSt;
	     private JLabel psmallSt;
	     private JLabel pthreeofK;
	     private JLabel pfourofK;
	     private JLabel pfullHouse;
	     private JLabel pchance;
	     private JLabel totalLOW, totalLOW2;
	     
	     public LowercardJPanel()
	     {
	         setBackground(cardC);
	         setLayout(new GridLayout(9,2,10,10));
	         //labels and buttons
	         heading2 = new JLabel("Lower Card");
	         heading2.setFont(new Font("Calibri", Font.PLAIN, 12));
		 
		 Yah = new JButton("Yahtzee!");
		 Yah.setPreferredSize(new Dimension(10,10));
		 Yah.setFont(new Font("Calibri", Font.PLAIN, 12));
		 Yah.addActionListener(new ActionLowerYah());
		 pYah = new JLabel(String.valueOf(lower[0]));
		 pYah.setFont(new Font("Calibri", Font.PLAIN, 12));
		 
		 largeSt = new JButton("Large Straight");
		 largeSt.setPreferredSize(new Dimension(10,10));
		 largeSt.setFont(new Font("Calibri", Font.PLAIN, 12));
		 largeSt.addActionListener(new ActionLowerlargeSt());
		 plargeSt = new JLabel(String.valueOf(lower[1]));
		 plargeSt.setFont(new Font("Calibri", Font.PLAIN, 12));
		 
		 smallSt = new JButton("Small Straight");
		 smallSt.setPreferredSize(new Dimension(10,10));
		 smallSt.setFont(new Font("Calibri", Font.PLAIN, 12));
		 smallSt.addActionListener(new ActionLowersmallSt());
		 psmallSt = new JLabel(String.valueOf(lower[2]));
		 psmallSt.setFont(new Font("Calibri", Font.PLAIN, 12));
		 
		 threeofK = new JButton("Three of a Kind");
		 threeofK.setPreferredSize(new Dimension(10,10));
		 threeofK.setFont(new Font("Calibri", Font.PLAIN, 12));
		 threeofK.addActionListener(new ActionLowerthreeofK());
		 pthreeofK = new JLabel(String.valueOf(lower[3]));
		 pthreeofK.setFont(new Font("Calibri", Font.PLAIN, 12));
		 
		 fourofK = new JButton("Four of a Kind");
		 fourofK.setPreferredSize(new Dimension(10,10));
		 fourofK.setFont(new Font("Calibri", Font.PLAIN, 12));
		 fourofK.addActionListener(new ActionLowerfourofK());
		 pfourofK = new JLabel(String.valueOf(lower[4]));
		 pfourofK.setFont(new Font("Calibri", Font.PLAIN, 12));
		 
		 fullHouse = new JButton("Full House");
		 fullHouse.setPreferredSize(new Dimension(10,10));
		 fullHouse.setFont(new Font("Calibri", Font.PLAIN, 12));
		 fullHouse.addActionListener(new ActionLowerfullHouse());
		 pfullHouse = new JLabel(String.valueOf(lower[5]));
		 pfullHouse.setFont(new Font("Calibri", Font.PLAIN, 12));
		 
		 chance = new JButton("Chance");
		 chance.setPreferredSize(new Dimension(10,10));
		 chance.setFont(new Font("Calibri", Font.PLAIN, 12));
		 chance.addActionListener(new ActionLowerchance());
		 pchance = new JLabel(String.valueOf(lower[6]));
		 pchance.setFont(new Font("Calibri", Font.PLAIN, 12));
	
	     totalLOW = new JLabel("Lower Score");
		 totalLOW.setFont(new Font("Calibri", Font.PLAIN, 12));
		 
		 lpoints = pointsTally(lower);
		 totalLOW2 = new JLabel(String.valueOf(lpoints));
		 totalLOW2.setFont(new Font("Calibri", Font.PLAIN, 12));
		 
		 add(heading2);
		 add(new JLabel(""));
		 add(Yah);
		 add(pYah);
		 add(largeSt);
		 add(plargeSt);
		 add(smallSt);
		 add(psmallSt);
		 add(threeofK);
		 add(pthreeofK);
		 add(fourofK);
		 add(pfourofK);
		 add(fullHouse);
		 add(pfullHouse);
		 add(chance);
		 add(pchance);
		 add(totalLOW);
		 add(totalLOW2);
	     }
	     class ActionLowerYah implements ActionListener
	     {
	         public void actionPerformed(ActionEvent event)
		 {
		     boolean flag = false;
		     //dice array
		     int[] checkDice = countOnDice();
		     for(int i = 0; i < 6; i++)
		     {
		         //look for 5 of a kind
		         if(checkDice[i] == 5)
			     flag = true;
		     }
             if (flag = true)
		         {
		             lower[0] = 50;
			        // winnerGif.setVisible(true);
	             }
		     else
		         lower[0] = 0;
			 
	             pYah.setText(String.valueOf(lower[0]));
		     lpoints = pointsTally(lower);
		     totalLOW.setText(String.valueOf(lpoints));
		     JButton source = (JButton) event.getSource();
		     source.setEnabled(false);
		     totalPoints = pointsTally(lower)+ pointsTally(upper);
		     fTotal.setText(String.valueOf(totalPoints));
		     turnTracker++;
		 }
	     }
	     class ActionLowerlargeSt implements ActionListener
	     {
	         public void actionPerformed(ActionEvent event)
		     {
		     //boolean flag to check for large straigh
		     boolean flag = true;
		     //dice array
		     int[] checkDice = countOnDice();
		     //checks to see if theres a one
		     if(checkDice[0] > 0)
		     {
		         for(int i = 1; i < 5; i++)
			 {
			     if(checkDice[i] < 1)
			         flag = false;
			 }
		     }
		     //looks for a two
		     else if(checkDice[1] > 0)
		     {
		         for(int i = 2; i < 6; i++)
			     {
			         if(checkDice[i] < 1)
			             flag = false;
		         }
		     }
		     else
		         flag = false;
			 
		    if(flag = true)
		        lower[1] = 40;
		    else 
		        lower[1] = 0;
		    
		    plargeSt.setText(String.valueOf(lower[1]));
		    lpoints = pointsTally(lower);
		    totalLOW.setText(String.valueOf(lpoints));
		    JButton source = (JButton) event.getSource();
		    source.setEnabled(false);
		    totalPoints = pointsTally(lower)+ pointsTally(upper);
		    fTotal.setText(String.valueOf(totalPoints));
		    turnTracker++;
	        }
	    }
	    class ActionLowersmallSt implements ActionListener
	    {
	        public void actionPerformed(ActionEvent event)
		{
		    boolean flag = true;
		    //dice array
		    int[] checkDice = countOnDice();
		    //look for a one
		    if(checkDice[0] > 0) 
		    {
		        //look for 2-4
			for(int i = 1; i < 4; i++) 
			{
			    if(checkDice[i] < 1)
		                flag = false;
			}
		    }
		    //check for a 2
		    else if(checkDice[1] > 0) 
		    {
		        //look for 3-5
			for(int i = 2; i < 5; i++) 
			{
			    if(checkDice[i] < 1)
			        flag = false;
			}
		
		    }
		    //check for a three
		    else if(checkDice[2] > 0) 
		    {
		        //check for 4-6
		        for(int i = 3; i < 6; i++) 
		        {
		            if(checkDice[i] < 1)
		       	        flag = false;
		        }
		    }
		    else
			flag = false;
			
		    	 
		    if(flag = true)
		        lower[2] = 40;
		    else 
		        lower[2] = 0;
		    
		    psmallSt.setText(String.valueOf(lower[2]));
		    lpoints = pointsTally(lower);
		    totalLOW.setText(String.valueOf(lpoints));
		    JButton source = (JButton) event.getSource();
		    source.setEnabled(false);
		    totalPoints = pointsTally(lower)+ pointsTally(upper);
		    fTotal.setText(String.valueOf(totalPoints));
		    turnTracker++;
		}
	    }
	    class ActionLowerthreeofK implements ActionListener
	    {
	        public void actionPerformed(ActionEvent event)
		{
		    int[] checkDice = countOnDice();
		    int value = 0;
		    for(int i = 0; i < 6; i++)
		    {
		        //checks for 3 of a kind
			if(checkDice[i] >= 3) 
			        //calculates that value
			    value = (i+1)*3;	
		    }
		    lower[3] = value;
		    pthreeofK.setText(String.valueOf(lower[3]));
		    lpoints = pointsTally(lower);
		    totalLOW.setText(String.valueOf(lpoints));
		    JButton source = (JButton) event.getSource();
		    source.setEnabled(false);
		    totalPoints = pointsTally(lower)+ pointsTally(upper);
		    fTotal.setText(String.valueOf(totalPoints));
		    turnTracker++;
		}
	    }
	    class ActionLowerfourofK implements ActionListener
	    {
	        public void actionPerformed(ActionEvent event)
		{
		    //used for number on dice calculation
		    int value = 0;
		    //dice array
		    int[] checkDice = countOnDice();
		    for(int i = 0; i < 6; i++)
		    {
		        //checks to see if 4 of kind
			if(checkDice[i] >= 4) //checks for 4ofK
			    //calculated value of dice roll with 4 of kind
			    value = (i+1)*4;	
		    }
	            lower[4] = value;
		    pfourofK.setText(String.valueOf(lower[4]));
		    lpoints = pointsTally(lower);
		    totalLOW.setText(String.valueOf(lpoints));
		    JButton source = (JButton) event.getSource();
		    source.setEnabled(false);
		    totalPoints = pointsTally(lower)+ pointsTally(upper);
		    fTotal.setText(String.valueOf(totalPoints));
		    turnTracker++;
		}
            }
	    class ActionLowerfullHouse implements ActionListener
	    {
	        public void actionPerformed(ActionEvent event)
		    {
		    //bool for tagging if theres a full house
		    boolean flag = false;
		    //dice array
		    int[] checkDice = countOnDice();
		    //checking for a full house
		    for(int i = 0; i < 6; i++)
		    {
		        //first looks for 3 of a kind, then a pair
		        if(checkDice[i] == 3)
			{
			    for(int j = 0; j < 6; j++)
			    {
				if(checkDice[j] == 2)
				    flag = true;
			    }
			}
			if(checkDice[i] == 2) //checks for pair then 3ofK
			{
			    for(int j = 0; j < 6; j++)
			    {
				 if(checkDice[j] == 3)
				     flag = true;
			    }
			}
		    }
		    //if fh found, add 25 points to card
		    if(flag = true)
		        lower[5] = 25;
		    else 
		        lower[5] = 0;
			
	        
		    pfullHouse.setText(String.valueOf(lower[5]));
		    lpoints = pointsTally(lower);
		    totalLOW.setText(String.valueOf(lpoints));
		    JButton source = (JButton) event.getSource();
		    source.setEnabled(false);
		    totalPoints = pointsTally(lower)+ pointsTally(upper);
		    fTotal.setText(String.valueOf(totalPoints));
		    turnTracker++;
		}
	    }
	    class ActionLowerchance implements ActionListener
	    {
	        public void actionPerformed(ActionEvent event)
		{
		    //for caluclating sum of chance dice roll
		    int value = 0;
		    for(int i = 0; i < Dice.die.length; i++)
		    {
		        //sum all dice in array
			    value += Dice.die[i]; 
		    }
		    lower[6] = value;
		    pchance.setText(String.valueOf(lower[6]));
		    lpoints = pointsTally(lower);
		    totalLOW.setText(String.valueOf(lpoints));
		    JButton source = (JButton) event.getSource();
		    source.setEnabled(false);
		    totalPoints = pointsTally(lower)+ pointsTally(upper);
		    fTotal.setText(String.valueOf(totalPoints));
		    turnTracker++;
		}
            }
	}
	public ScoreCardJPanel()
	{
	    setBackground(bC);
	    setPreferredSize(new Dimension(500, 600));
	    //add lower scorecard to total
	    l = new LowercardJPanel();
	    l.setPreferredSize(new Dimension(225, 320));
	    add(l);
	    //add upper scorecard to total
	    setLayout(new FlowLayout());
	    u = new UppercardJPanel();
	    u.setPreferredSize(new Dimension(175, 300));
	    add(u);
	    //final totals
	    finalTotal = new JLabel("Grand Total: ");
	    finalTotal.setFont(new Font("Calibri", Font.PLAIN, 18));
	    add(finalTotal);
	    //calculate final totals and put on scorecard
	    totalPoints = pointsTally(lower)+pointsTally(upper);
	    fTotal = new JLabel(String.valueOf(totalPoints));
	    fTotal.setFont(new Font("Calibri", Font.PLAIN, 18));
	    add(fTotal);
	 
    }
	//calculates sum on dice roll
	int diceSum(int val)
	{
	    int sum = 0;
	    for(int i = 0; i < Dice.die.length; i++)
	    {
		    if(Dice.die[i] == val)
		    //sum all rolls for the die
		    sum += val; 
	    }
	    //return the sum value
	    return sum; 
	}
	//tallys the points
	int pointsTally (int [] numPoints)
	{
		points = 0;
		//sum whole array
		for(int i = 0; i < numPoints.length; i++)
		{
			points += numPoints[i];
		}
		//return sum of points
		return points; 
	}
	//stores number on each dice into array
	int[] countOnDice()
	{
	    int[] checkDice = new int[6];
	    for(int i = 0; i < Dice.die.length; i++)
	    {
	        if(Dice.die[i] == 1)
		    checkDice[0]++;					

		if(Dice.die[i] == 2)
		    checkDice[1]++;					
			
		if(Dice.die[i] == 3)
		    checkDice[2]++;					
		
	        if(Dice.die[i] == 4)
		    checkDice[3]++;					
		
		if(Dice.die[i] == 5)
		    checkDice[4]++;					
		
	        if(Dice.die[i] == 6)
		    checkDice[5]++;
	     }
	     //return array
             return checkDice; 
	}
}
	    
	        
		    
		    
	    
   
		 
		
		
		
		     
		     
		     

			    
	 
		    
	    
	    
       

   


