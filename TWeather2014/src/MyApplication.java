import java.awt.*;
import java.awt.geom.*;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.awt.AWTUtilities;


public class MyApplication extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 321953725494916861L;
	private MainPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyApplication frame = new MyApplication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyApplication() {
		super ();

	    setLayout ( new BorderLayout () );
	    int w = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
	    int h = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
	    contentPane = new MainPanel(w,h);
	    add(contentPane);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setAlwaysOnTop ( true );
	    setUndecorated ( true );
	    
	    //this.setSize(new Dimension(w,h));
	    setExtendedState(JFrame.MAXIMIZED_BOTH);
	    //setLocationRelativeTo(null);
	    AWTUtilities.setWindowOpaque ( this, false );
	    pack ();
	}

}
