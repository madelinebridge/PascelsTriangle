import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * PictureApplet draws a picture in an applet
 */
public class TriangleApplet extends JApplet {

	/**
	 * In applets, the init method is where things get set up. This is the only
	 * method that is needed if it is run as an applet in a webpage.
	 */
	public void init() {
		add(new PicturePanel());
	}

	/**
	 * The default constructor. In this case, we don't want it to do anything.
	 */
	public TriangleApplet() {
	}

	// -------------------------------------------------------------
	// The rest of the class fields and methods allow us
	// to run this as a stand alone application.

	// The desired dimensions of the main window
	private int width = 1200;
	private int height = 631;

	// The graphical components
	private static PicturePanel mainPanel;

	/**
	 * The main method, which allows us to run the application without using a
	 * webpage. In other words, this is the method that is called when you run
	 * it as a Java application.
	 */
	public static void main(String[] args) {
		// Does the same thing as the init method...
		TriangleApplet myPicture = new TriangleApplet();
		myPicture.makeFrame();
		
	}

	/**
	 * Create the drawing panel and various other components that we need for
	 * our program.
	 */
	public void makeFrame() {
		// Sets up the graphical components of the window.
		JFrame theFrame = new JFrame();
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
		mainPanel = new PicturePanel();

		// Place all of the graphical components on the main window
		Container cont = theFrame.getContentPane();
		// cont.setLayout(new BorderLayout());
		cont.add(mainPanel, BorderLayout.CENTER);

		// Finish setting up the main window
		theFrame.setBackground(Color.white);
		theFrame.pack();
		theFrame.setSize(new Dimension(width, height));
		theFrame.setVisible(true);
	}
}
