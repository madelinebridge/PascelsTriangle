
/**
* PicturePanel.java
 * Author: Madeline Smith
 * Date: January 19, 2015
 * Version: 1.0
 * 
 *
 *A dancing character.
 *
 */
import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;

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
    public static final int width = 800;
    public static final int height = 600;
    
    // Fields. Hold the characteristics of the character-- color and smile
    private Color bodyColor;
    private Color shadowColor;
    public static boolean characterIsSmiling;
    public static int count;
    private Timer timer;
    
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
        
        bodyColor = new Color(0,0,0);
        shadowColor = new Color(0,0,0);
        characterIsSmiling=false;
        // Generates a random number each time the counter clicks, to see 
     	// if the character should change color.
        
        timer = new Timer(300, new ActionListener() {
			//Altered from cusack's project...
			public void actionPerformed(ActionEvent event) {
				
				double rand = Math.random();

				if((rand*101 > 80) && (count%2==1)) {
	                 count=0;
	            } else { // Otherwise, the character stays the same color
	                 count++;
	            }
				repaint();
			}
        });
        
        count = 0;
		
		// Sets up the timer so the character continuously dances
		// Starts the timer
		timer.start();
    }
    
    /**
     * Generates a random pastel color
     * @param mix
     * @return Color
     */
    public Color generateRandomPastelColor() {
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);

        // mix the color
        red = (red + 255) / 2;
        green = (green + 255) / 2;
        blue = (blue + 255) / 2;
        
        Color color = new Color(red, green, blue);
        return color;
    }
    
    /**
     * Generates the shadow color for a character.
     */
    public Color getShadowColor(Color color)
    {
    	int red = color.getRed();
    	int green = color.getGreen();
    	int blue = color.getBlue();
    	
    	//Get a darker color
    	red = (red - 8);
    	green = (green - 15);
    	blue = (blue + 5);
    	
    	//return new color
    	Color darkColor = new Color(red, green, blue);
    	return darkColor;
    }
    
    /**
     * Draws a cute pastel character.
     * 
     * @param g
     */
    private void drawCharacter(Graphics g)
    {
    	if((count==0)){
    		bodyColor = generateRandomPastelColor();
    		shadowColor = getShadowColor(bodyColor);
    	}
    		
    	//draw head
    	g.setColor(bodyColor);
    	g.fillOval(350,150,100,100);
    	//draw head outline
    	// g.setColor(new Color(41,41,41));
    	// g.drawOval(350,200,101,101);
    	//draw body
    	g.setColor(bodyColor);
    	g.fillRect(350,200,101,125);
    	//draw butt
    	g.fillOval(349,317,25,25);
    	g.fillOval(425,317,25,25);
    	g.fillRect(362,325,70,17);
    	//draw shadow
    	g.setColor(new Color(225,225,225));
    	g.fillOval(350,380,100,30);
    	//draw legs
    	g.setColor(bodyColor);
    	g.fillRect(365,325,10,70);
    	g.fillRect(428,325,10,70);
    	//draw feet shadow
    	g.setColor(new Color(210,210,210));
    	g.fillOval(350,390,24,13);
    	g.fillOval(426,390,23,13);
    	//draw feet
    	g.setColor(bodyColor);
    	g.fillOval(350,386,25,13);
    	g.fillOval(426,386,25,13);
    	//draw leg shadow
    	g.setColor(shadowColor);
    	g.fillRect(365,341,10,10);
    	g.fillRect(428,341,10,10);
    	//draw eye shadow
    	g.fillOval(364,203,11,11);
    	g.fillOval(426,203,11,11);
    	//draw eyes
    	g.setColor(new Color(30,30,30));
    	g.fillOval(363,202,10,10);
    	g.fillOval(425,202,10,10);
    	g.setColor(new Color(75,75,75));
    	g.fillOval(364,203,6,6);
    	g.fillOval(426,203,6,6);
    	//draw mouth, either smiling or not
    	if(characterIsSmiling){
    		g.setColor(new Color(50,0,0));
    		g.fillOval(393,217,20,20);
    		g.setColor(bodyColor);
    		g.fillRect(393,206,23,21);
    	}
    	else{
    		g.setColor(shadowColor);
    		g.fillOval(393,217,20,20);
    		g.setColor(bodyColor);
    		g.fillOval(393,214,20,20);
    	}
    }
    
    /**
     * Draws the character in the middle of a dance move.
     * 
     * @param g
     */
    public void drawDancingCharacter(Graphics g)
    {
    	//draw head
    	g.setColor(bodyColor);
    	g.fillOval(350,175,100,100);
    	//draw head outline
    	// g.setColor(new Color(41,41,41));
    	// g.drawOval(350,200,101,101);
    	//draw body
    	g.setColor(bodyColor);
    	g.fillRect(350,225,101,125);
    	//draw butt
    	g.fillOval(349,342,25,25);
    	g.fillOval(425,342,25,25);
    	g.fillRect(362,350,70,17);
    	//draw shadow
    	g.setColor(new Color(225,225,225));
    	g.fillOval(350,380,100,30);
    	//draw legs
    	g.setColor(bodyColor);
    	g.fillRect(365,325,10,70);
    	g.fillRect(428,325,10,70);
    	
    	//draw feet shadow
    	g.setColor(new Color(210,210,210));
    	g.fillOval(350,390,24,13);
    	g.fillOval(426,390,23,13);
    	//draw feet
    	g.setColor(bodyColor);
    	g.fillOval(350,386,25,13);
    	g.fillOval(426,386,25,13);
    	
    	//draw leg shadow
    	g.setColor(shadowColor);
    	g.fillRect(365,366,10,10);
    	g.fillRect(428,366,10,10);
    	
    	//draw eye shadow
    	g.setColor(shadowColor);
    	g.fillOval(364,228,11,11);
    	g.fillOval(426,228,11,11);
    	//draw eyes
    	g.setColor(new Color(30,30,30));
    	g.fillOval(363,228,10,10);
    	g.fillOval(425,228,10,10);
    	g.setColor(new Color(75,75,75));
    	g.fillOval(364,228,6,6);
    	g.fillOval(426,228,6,6);
    	//draw mouth, either smiling or not
    	if(characterIsSmiling){
    		g.setColor(new Color(50,0,0));
    		g.fillOval(393,242,20,20);
    		g.setColor(bodyColor);
    		g.fillRect(393,231,23,21);
    	}
    	else{
    		g.setColor(shadowColor);
        	g.fillOval(393,242,20,20);
        	g.setColor(bodyColor);
        	g.fillOval(393,239,20,20);
    	}
    }
    
    /**
     * Draws the background.
     */
    public void drawBackground(Graphics g)
    {
    	g.setColor(new Color(208,208,208));
    	g.fillOval(-1100, 178, 3100, 800);
    	g.setColor(new Color(215,215,215));
    	g.fillOval(-700, 180, 2200, 700);
    	g.setColor(new Color(225,225,225));
    	g.fillOval(-400, 185, 1600, 600);
    	g.setColor(new Color(230,230,230));
    	g.fillOval(-200, 200, 1200, 500);
    	g.setColor(new Color(235,235,235));
    	g.fillOval(-50, 225, 900, 400);
    	g.fillRect(0,0,800,170);
    	// Draw buildings
    	g.setColor(new Color(200,200,200));
    	g.fillRect(0,170,800,25);
    	g.fillRect(0,145,25,50);
    	g.fillRect(50,120,60,65);
    	g.fillRect(110,145,40,30);
    	g.fillRect(150,70,30,100);
    	g.fillRect(180,90,50,80);
    	g.fillRect(230,150,40,30);
    	g.fillRect(340,120,60,65);
    	g.fillRect(400,90,50,80);
    	g.fillRect(450,150,40,30);
    	g.fillRect(490,120,60,65);
    	g.fillRect(550,145,40,30);
    	g.fillRect(650,70,30,100);
    	g.fillRect(680,120,60,65);
    	//draw windows
    	g.setColor(new Color(235,235,235));
    	g.fillRect(61,130,9,9);
    	g.fillRect(86,130,9,9);
    	g.fillRect(86,154,9,9);
    	g.fillRect(155,75,7,7);
    	g.fillRect(166,103,7,7);
    	g.fillRect(166,114,7,7);
    	g.fillRect(155,114,7,7);
    	g.fillRect(155,137,7,7);
    	g.fillRect(345,125,8,8);
    	g.fillRect(370,142,8,8);
    	g.fillRect(386,142,8,8);
    	g.fillRect(665,75,7,7);
    	g.fillRect(665,85,7,7);
    	g.fillRect(655,105,7,7);
    	g.fillRect(665,135,7,7);
    	g.fillRect(61,130,9,9);
    	g.fillRect(86,130,9,9);
    	g.fillRect(690,154,9,9);
    	g.fillRect(705,130,9,9);
    }
    
    /**
     * This draws the character kicking.
     */
    public void drawCharacterKick(Graphics g)
    {
    	//draw head
    	g.setColor(bodyColor);
    	g.fillOval(350,175,100,100);
    	//draw head outline
    	// g.setColor(new Color(41,41,41));
    	// g.drawOval(350,200,101,101);
    	//draw body
    	g.setColor(bodyColor);
    	g.fillRect(350,225,101,125);
    	//draw butt
    	g.fillOval(349,342,25,25);
    	g.fillOval(425,342,25,25);
    	g.fillRect(362,350,70,17);
    	//draw shadow
    	g.setColor(new Color(225,225,225));
    	g.fillOval(350,380,100,30);
    	//draw legs
    	g.setColor(bodyColor);
    	g.fillRect(365,325,10,70);
    	g.fillRect(428,325,70,10);
    	
    	//draw feet shadow
    	g.setColor(new Color(210,210,210));
    	g.fillOval(350,390,24,13);
    	//draw feet
    	g.setColor(bodyColor);
    	g.fillOval(350,386,25,13);
    	g.fillOval(490,310,13,25);
    	
    	//draw leg shadow
    	g.setColor(shadowColor);
    	g.fillRect(365,366,10,10);
    	
    	//draw eye shadow
    	g.setColor(shadowColor);
    	g.fillOval(364,228,11,11);
    	g.fillOval(426,228,11,11);
    	//draw eyes
    	g.setColor(new Color(30,30,30));
    	g.fillOval(363,228,10,10);
    	g.fillOval(425,228,10,10);
    	g.setColor(new Color(75,75,75));
    	g.fillOval(364,228,6,6);
    	g.fillOval(426,228,6,6);
    	//draw mouth, either smiling or not
    	if(characterIsSmiling){
    		g.setColor(new Color(50,0,0));
    		g.fillOval(393,242,20,20);
    		g.setColor(bodyColor);
    		g.fillRect(393,231,23,21);
    	}
    	else{
    		g.setColor(shadowColor);
        	g.fillOval(393,242,20,20);
        	g.setColor(bodyColor);
        	g.fillOval(393,239,20,20);
    	}
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
        // Always place this as the first line in paintComponent.
        super.paintComponent(g);
        //Draws the background
        drawBackground(g);
        // Draws the character if the count is even and the count
        //is not above 1001
	    if((count%2==0)&&(count<1001)){
	    	drawCharacter(g);
	    } 
	    // A click in the background sets the click amount to 1001, 
	    // signifying that the character should kick.
	    // Once the character is set to kick, the count is reset to 1,
	    // as setting to zero would change the color.
	    else if(count==1001){
	    	drawCharacterKick(g);
	    	count=1;
	    } 
	    // If the count is odd, the character is drawn in its dance 
	    //move. This similates a dance because the character alternates
	    // between frames each second or so.
	    else{
	    	drawDancingCharacter(g);
	    }
 
	    // Draw a string which tells the user what to do, and the author
	    g.setColor(Color.black);
	    g.setFont(new Font("Calibri",Font.BOLD,30));
        g.drawString("Click me or the Background!",40,40);
        g.setFont(new Font("Calibri",Font.BOLD,20));
        g.drawString("By: Madeline Smith", 600, 550);
        
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
        	//If the mouse clicks on the background, have him kick
        	if((e.getX()<430)&&(e.getX()>350)&&(e.getY()>150)&&(e.getY()<309))
			 {
        		// not character, but background
			 }
        	else{
        		PicturePanel.count=1001;
            	repaint();
        	}
        }

        public void mouseEntered(MouseEvent e)
        {
        }
        public void mouseExited(MouseEvent e) 
        {
        }        
        public void mousePressed(MouseEvent e) 
        {
        	// If the user clicks on the character, the character
        	// opens or closes his mouth.
        	if((e.getX()<430)&&(e.getX()>350)&&(e.getY()>150)&&(e.getY()<309))
			 {
				 		PicturePanel.characterIsSmiling=!PicturePanel.characterIsSmiling;
			 }
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