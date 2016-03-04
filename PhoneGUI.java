/**
This program is the demo program for Phone.java. It will test the Phone object.
Leihulu Kenui
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;

public class PhoneGUI
{
    Phone phone = new Phone();
    JFrame frame = new JFrame();
    GridLayout numButtons = new GridLayout(4,3);
    GridLayout otherButtons = new GridLayout(3,2);
    FlowLayout flow = new FlowLayout();
    JLabel num;
    JButton num1, num2, num3, num4, num5, num6, num7, num8, num9, num0, star, pound, erase, clear, redial, call, end, exit;
    JPanel numPanel, otherPanel, display;
    Font buttonFont = new Font("Impact", Font.BOLD, 36);
    Font otherFont = new Font("Impact", Font.BOLD, 18);
	boolean inCall = false;
    
    public PhoneGUI()
    {
        num = new JLabel("");
        buildNumPanel();
        buildOtherPanel ();
        enableKeys();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());
        frame.add(numPanel, BorderLayout.SOUTH);
        frame.add(otherPanel, BorderLayout.CENTER);
        frame.add(display, BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);
    }
    /* This calls the action listeners and adds color and font to the digit keypad
    buttons.
    */
    public void buildNumPanel()
    {
        numPanel = new JPanel(numButtons);
        
        num1 = new JButton("1");
        num1.setFont(buttonFont);
        num1.setForeground(Color.PINK);
		num1.setBackground(Color.WHITE);
        num1.addActionListener(new numButtonsListener());
        numPanel.add(num1);
        
        num2 = new JButton("2");
        num2.setFont(buttonFont);
        num2.setForeground(Color.PINK);
		num2.setBackground(Color.WHITE);
        num2.addActionListener(new numButtonsListener());
        numPanel.add(num2);
        
        num3 = new JButton("3");
        num3.setFont(buttonFont);
        num3.setForeground(Color.PINK);
		num3.setBackground(Color.WHITE);
        num3.addActionListener(new numButtonsListener());
        numPanel.add(num3);
        
        num4 = new JButton("4");
        num4.setFont(buttonFont);
        num4.setForeground(Color.PINK);
		num4.setBackground(Color.WHITE);
        num4.addActionListener(new numButtonsListener());
        numPanel.add(num4);
        
        num5 = new JButton("5");
        num5.setFont(buttonFont);
        num5.setForeground(Color.PINK);
		num5.setBackground(Color.WHITE);
        num5.addActionListener(new numButtonsListener());
        numPanel.add(num5);
        
        num6 = new JButton("6");
        num6.setFont(buttonFont);
        num6.setForeground(Color.PINK);
		num6.setBackground(Color.WHITE);
        num6.addActionListener(new numButtonsListener());
        numPanel.add(num6);
        
        num7 = new JButton("7");
        num7.setFont(buttonFont);
        num7.setForeground(Color.PINK);
		num7.setBackground(Color.WHITE);
        num7.addActionListener(new numButtonsListener());
        numPanel.add(num7);
        
        num8 = new JButton("8");
        num8.setFont(buttonFont);
        num8.setForeground(Color.PINK);
		num8.setBackground(Color.WHITE);
        num8.addActionListener(new numButtonsListener());
        numPanel.add(num8);
        
        num9 = new JButton("9");
        num9.setFont(buttonFont);
        num9.setForeground(Color.PINK);
		num9.setBackground(Color.WHITE);
        num9.addActionListener(new numButtonsListener());
        numPanel.add(num9);
        
        star = new JButton("*");
        star.setFont(buttonFont);
        star.setForeground(Color.PINK);
		star.setBackground(Color.WHITE);
        star.addActionListener(new numButtonsListener());
        numPanel.add(star);
        
        num0 = new JButton("0");
        num0.setFont(buttonFont);
        num0.setForeground(Color.PINK);
		num0.setBackground(Color.WHITE);
        num0.addActionListener(new numButtonsListener());
        numPanel.add(num0);
        
        pound = new JButton("#");
        pound.setFont(buttonFont);
        pound.setForeground(Color.PINK);
		pound.setBackground(Color.WHITE);
        pound.addActionListener(new numButtonsListener());
        numPanel.add(pound);
    }
    /* This calls the buttons and holds the design of the GUI as well as the action listers
    in the other phone buttons.
    */
    public void buildOtherPanel()
    {
        display = new JPanel(flow);
        display.add(num);

        otherPanel = new JPanel(otherButtons);

        call = new JButton("Call");
        call.setFont(otherFont);
        call.setForeground(Color.PINK);
		call.setBackground(Color.WHITE);       
        call.addActionListener(new otherButtonsListener());
        otherPanel.add(call);
        
        end = new JButton("End");
        end.setFont(otherFont);
        end.addActionListener(new otherButtonsListener());
        end.setForeground(Color.PINK);
		end.setBackground(Color.WHITE);
        otherPanel.add(end);
		
        redial = new JButton("Redial");
        redial.setFont(otherFont);
        redial.setForeground(Color.PINK);
		redial.setBackground(Color.WHITE);
        redial.addActionListener(new otherButtonsListener());
        otherPanel.add(redial);

        erase = new JButton("Erase");
        erase.setFont(otherFont);
        erase.addActionListener(new numButtonsListener());
        erase.setForeground(Color.PINK);
		erase.setBackground(Color.WHITE);
        otherPanel.add(erase);

        clear = new JButton("Clear");
        clear.setFont(otherFont);
        clear.setForeground(Color.PINK);
		clear.setBackground(Color.WHITE);
        clear.addActionListener(new numButtonsListener());
        otherPanel.add(clear);
        
        exit = new JButton("Exit");
        exit.setFont(otherFont);
        exit.addActionListener(new exitListener());
        exit.setForeground(Color.PINK);
		exit.setBackground(Color.WHITE);
        otherPanel.add(exit);
    }
    /* This is the action listener for the other phone buttons. It creates the calling
    and attaches the phone number, and displays ending call when End is pressed
    */
    private class otherButtonsListener implements ActionListener
    {
        public void actionPerformed(ActionEvent evt)
        {
            JButton e = (JButton)evt.getSource();
            if(e.getText().equals("Call"))
            {
                phone.setLastNum(phone.getNum());
                num.setText("Calling " + phone.getNum());
                flipCallStatus();
            }
            else if(e.getText().equals("End"))
            {
                num.setText("Ending Call... ");
                phone.setNum("");
                flipCallStatus();  
            }
            else
            {
                if(phone.getLastNum().equals(""))
                {
                    num.setText("");
                }
                else
                {
                    num.setText("Calling " + phone.getLastNum());
                    flipCallStatus();
                }
            }
        }
    }

    /*This is the action listener for the digit keypad. It tells what to do when 
    the user presses erase, clear, and what to do if neither buttons are pressed.*/
    private class numButtonsListener implements ActionListener
	{
        public void actionPerformed(ActionEvent evt)
        {
            JButton e = (JButton)evt.getSource();
            if(e.getText().equals("Erase"))
            {
                phone.takeFromNum();
            }
            else if(e.getText().equals("Clear"))
            {
                phone.clear();
            }
            else
            {
                phone.addToNum(e.getText().charAt(0));
            }
            num.setText(phone.getNum());
        }
    }
    
  // This class is an actionListener class for the "Exit" button.
  private class exitListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      System.exit(0);
    }   
  }
  
  /*This method creates a flag to be called in the action listeners above. It describes
  whether to enable or disable keys on a given button press*/
  public void flipCallStatus()
  {
	  inCall = !inCall;
	  if(inCall) disableKeys();
	  else enableKeys();
  }
  
  /*This class consists of the booleans to determine whether or not
  a given button is enabled or disabled at a particular time. This is called
  in the action listeners*/
  public void disableKeys()
  {
        num1.setEnabled(false);
        num2.setEnabled(false);
        num3.setEnabled(false);
        num4.setEnabled(false);
        num5.setEnabled(false);
        num6.setEnabled(false);
        num7.setEnabled(false);
        num8.setEnabled(false);
        num9.setEnabled(false);
        star.setEnabled(false);
        num0.setEnabled(false);
        pound.setEnabled(false);
        call.setEnabled(false);
        redial.setEnabled(false);
        erase.setEnabled(false);
        clear.setEnabled(false);
        end.setEnabled(true);
        exit.setEnabled(false);
    }

    public void enableKeys()
    {
        num1.setEnabled(true);
        num2.setEnabled(true);
        num3.setEnabled(true);
        num4.setEnabled(true);
        num5.setEnabled(true);
        num6.setEnabled(true);
        num7.setEnabled(true);
        num8.setEnabled(true);
        num9.setEnabled(true);
        star.setEnabled(true);
        num0.setEnabled(true);
        pound.setEnabled(true);
        call.setEnabled(true);
        redial.setEnabled(true);
        erase.setEnabled(true);
        clear.setEnabled(true);
        end.setEnabled(false);
        exit.setEnabled(true);
    }
    public static void main (String [] args){
        new PhoneGUI();
    }
}
