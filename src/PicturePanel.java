
/**
* PicturePanel.java
 * Author: Madeline Smith
 * Date: January 19, 2015
 * Version: 1.0
 * 
 *
 *A dancing character.
 **/
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * A class draws a dancing character on the panel.
 * Perhaps make into a game later?
 *
 */
public class PicturePanel extends JPanel 
{
    // The width and height of the JPanel upon which things are drawn
    public static final int width = 1200;
    public static final int height = 631;
    
    // Fields. Hold the characteristics of the character-- color and smile
    int[][] entries;
    boolean corollaryeight; // sum of row n = 2^n
	private JFrame theFrame;

	/**
	 * The main method, which allows us to run the application without using a
	 * webpage. In other words, this is the method that is called when you run
	 * it as a Java application.
	 */
	public static void main(String[] args) {
		// Does the same thing as the init method...
		new PicturePanel();
		
	}
	
	/**
	 * Create the drawing panel and various other components that we need for
	 * our program.
	 */
	public void makeFrame() {
		theFrame = new JFrame();
		// Sets up a title!
		theFrame.setTitle("Pascel's Triangle Fun Facts");
		// This listens for the user's interaction with the window.
		theFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		;

		// Instantiate the main drawing panel
		//mainPanel = new PicturePanel();

		// Place all of the graphical components on the main window
		Container cont = theFrame.getContentPane();
		// cont.setLayout(new BorderLayout());
		cont.add(this, BorderLayout.CENTER);

		// Finish setting up the main window
		theFrame.setBackground(Color.white);
		theFrame.pack();
		theFrame.setSize(new Dimension(width, height));
		theFrame.setVisible(true);
	}
    
    /**
     * Get stuff ready so when paintComponent is called, it can draw stuff.
     * Depending on how complicated you want to get, your constructor may be blank.
     */
    public PicturePanel() 
    {
        // If you want to handle mouse events, you will need the following
        // 3 lines of code.  Just leave them as is and modify the methods
        // with "mouse" in the name toward the end of the class.
        // If you don't want to deal with mouse events, delete these lines.
        MouseHandler mh=new MouseHandler();
        addMouseListener(mh);
        addMouseMotionListener(mh);
        
        // Initialize number of clicks to 0, and characteristics to default
        corollaryeight=false;
        entries = new int[10][];
        
        for (int i=0; i<entries.length; i++)
        {
                entries[i] = new int[i+1];
                entries[i][0] = 1;
                entries[i][i] = 1;
                for (int j=1; j<i; j++)
                {
                        entries[i][j] = entries[i-1][j]+entries[i-1][j-1];
                }
        }

        makeFrame();
        
        // Generates a random number each time the counter clicks, to see 
     	// if the character should change color.
        
      
		
		// Sets up the timer so the character continuously dances
		// Starts the timer
    }
    
    /**
     * draws pascel's triangle
     * @param g
     */
    public void drawTriangle(Graphics g){
    	int count = 50;
    	int center=0;
    	int row = 50;
    	for(int i = 0; i < entries.length; i++){
    		for(int j=0; j<entries[i].length; j++){
    			g.setFont(new Font("Calibri",Font.BOLD,20));
    			g.setColor(Color.BLACK);
    			g.drawString(Integer.toString(entries[i][j]), 600+count, row);
    			if(corollaryeight){
    				g.setColor(Color.red);
    				if(j==entries[i].length-1){
    					g.drawString("= "+Integer.toString((int) Math.pow(2, i+1)) + " = 2^"+Integer.toString(i+1), 600+count+50, row);
    				} else {
    					g.drawString("+", 600+count+30, row);
    				}
    	    	}
    			count+=50;
    		}
    		row+=50;
    		count=50-(i+1)*25;
    	}
    }
    
    public void drawButtons(Graphics g){
    	int count = 0;
    	int lim = 6;
    	int w=200;
    	int h=100;
    	g.setColor(Color.gray);
    	for(int i = 0;i<lim;i++){
    		g.fill3DRect(count, i*100, w, h,true);
    	}
    	g.setColor(Color.black);
    	g.setFont(new Font("Calibri",Font.PLAIN,20));
    	g.drawString("2^n", 80, 50);
    	g.drawString("RESET", 80, 550);
    	
    	
    }
   
    
    
    
    
    

    /**
     * This method is called whenever the applet needs to be drawn.
     * This is the most important method of this class, since without
     * it, we don't see anything.
     * 
     * This is the method where you will most likely do all of your coding.
     */
    public void paintComponent(Graphics g) 
    {
        
        drawTriangle(g);
        drawButtons(g);
        
    }
    
    
    //------------------------------------------------------------------------------------------
    
     //---------------------------------------------------------------
    // A class to handle the mouse events for the applet.
    // This is one of several ways of handling mouse events.
    // If you do not want/need to handle mouse events, delete the following code.
    //
    private class MouseHandler extends MouseAdapter implements MouseMotionListener
    {
      
        public void mouseClicked(MouseEvent e) 
        {
        	if(e.getX()>=0 && e.getX()<=200 && e.getY()>=0 && e.getY()<=100){
        		// 2^n pattern
        		corollaryeight=true;
        		
        	} 
        	if(e.getX()>=0 && e.getX()<=200 && e.getY()>=500 && e.getY()<=600){
        		corollaryeight=false;
        	}
        	theFrame.repaint();
        }

        public void mouseEntered(MouseEvent e)
        {
        }
        public void mouseExited(MouseEvent e) 
        {
        }        
        public void mousePressed(MouseEvent e) 
        {
        
        }        
        public void mouseReleased(MouseEvent e) 
        {
        }
        public void mouseMoved(MouseEvent e) 
        {
        }
        public void mouseDragged(MouseEvent e) 
        {
        }
    }
    // End of MouseHandler class
    
} // Keep this line--it is the end of the PicturePanel class