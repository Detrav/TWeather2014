import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;
import javax.swing.Timer;


public class MainPanel extends JPanel implements ActionListener {

	/**
	 * Create the panel.
	 */
	private static final long serialVersionUID = 1L;
	Timer timer;
	Particle Snow;
	public MainPanel(int w, int h)
	{
		timer = new Timer(16,this);
		timer.start();
        setOpaque ( false );
        Snow = new Particle((float)w,(float)h);
    }
	
	public void actionPerformed(ActionEvent ev)
	{
	    if(ev.getSource()==timer)
	    {
	      Snow.Do();
	      repaint();// this will call at every 1 second
	    }
	}
	
	public boolean contains ( int x, int y )
    {
      return false;
    }

    public boolean contains ( Point p )
    {
      return false;
    }

    protected void paintComponent ( Graphics g )
    {
      super.paintComponent ( g );

      Graphics2D g2d = ( Graphics2D ) g;
      g2d.setRenderingHint ( RenderingHints.KEY_ANTIALIASING,
          RenderingHints.VALUE_ANTIALIAS_ON );

      g2d.setComposite ( AlphaComposite.getInstance ( AlphaComposite.SRC_OVER, 0.5f ) );
      g2d.setPaint ( Color.GRAY );
      Snow.Draw(g2d);
      //g2d.fill ( new  );
      
      //Area area = new Area ( new Ellipse2D.Double ( 0, 0, getWidth (), getHeight () ) );
      //area.subtract ( new Area (
          //new Ellipse2D.Double ( 25, 25, getWidth () - 50, getHeight () - 50 ) ) );
      //g2d.fill ( area );
      
    }

    public Dimension getPreferredSize ()
    {
      return new Dimension ( 300, 300 );
    }
    
    
}
