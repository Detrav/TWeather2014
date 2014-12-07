import java.awt.AlphaComposite;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferStrategy;

import javax.swing.JPanel;
import javax.swing.Timer;


public class MainPanel extends JPanel implements Runnable {

	/**
	 * Create the panel.
	 */
	private static final long serialVersionUID = 1L;
	Timer timer;
	Particle Snow;
	Boolean paint;
	int width;
	int height;
	public MainPanel(int w, int h)
	{
		///timer = new Timer(16,this);
		//timer.start();
        setOpaque ( false );
        Snow = new Particle((float)w,(float)h);
        width = w;
        height = h;
        paint = true;
    }
	private boolean running;
	/*
	public void actionPerformed(ActionEvent ev)
	{
	    if(ev.getSource()==timer)
	    {
	    	
	    	if(paint)
	    	{
	    		repaint();// this will call at every 1 second
	    		System.gc();
	    	}
	    }
	}*/
	
	public void Do(long delta) {
		Snow.Do(((float)delta)/1000f);
    }
	
	public void run() {
        long lastTime = System.currentTimeMillis();
        long delta;
       
        
        while(running) {
                delta = System.currentTimeMillis() - lastTime;
                lastTime = System.currentTimeMillis(); 
                this.repaint();
                
                Do(delta);
                if(delta<32)
					try {
						Thread.sleep(32L-delta);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        }
	}
	
	/*public void Draw()
	{
		BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
                createBufferStrategy(2);
                requestFocus();
                return;
        }
       
        Graphics g = bs.getDrawGraphics(); 
        g.setColor(Color.black);
        g.fillRect(0, 0, width, height);
        
        Snow.Draw((Graphics2D)g);
         
        g.dispose();
        
        bs.show(); 
	}*/
	
	public void start() {
        running = true;
        new Thread(this).start();
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
    	//paint = false;
    	//Snow.Do();
      super.paintComponent ( g );

      Graphics2D g2d = (Graphics2D)  g.create();
      g2d.setRenderingHint ( RenderingHints.KEY_ANTIALIASING,
          RenderingHints.VALUE_ANTIALIAS_ON );

      g2d.setComposite ( AlphaComposite.getInstance ( AlphaComposite.SRC_OVER, 0.5f ) );
      g2d.setPaint ( Color.GRAY );
      //Graphics2D g2 = ( Graphics2D )g.create();
      Point p = MouseInfo.getPointerInfo().getLocation();
      Snow.Draw(g2d,p);
      //g2d.fill ( new  );
      
      //Area area = new Area ( new Ellipse2D.Double ( 0, 0, getWidth (), getHeight () ) );
      //area.subtract ( new Area (
          //new Ellipse2D.Double ( 25, 25, getWidth () - 50, getHeight () - 50 ) ) );
      //g2d.fill ( area );
      //g2d
      //paint = true;
      g2d.dispose();
    }

    public Dimension getPreferredSize ()
    {
      return new Dimension ( 300, 300 );
    }
    
    
}
