import java.awt.Graphics2D;
import java.awt.geom.*;
import java.util.Random;


public class Particle {
	float width;
	float height;
	ParticleElement[] elements;
	int size = 1000;
	public Particle(float w, float h)
	{
		width = w;
		height = h;
		elements = new ParticleElement[size];
		Random rand = new Random();
		for(int i = 0; i<size;i++)
		{
			elements[i] = new ParticleElement();
			elements[i].size = rand.nextFloat()*0.9f+0.1f;
			elements[i].dx = rand.nextFloat() - 0.5f;
			elements[i].dy = rand.nextFloat() + 1f;
			elements[i].x = rand.nextFloat()*(width+100f)-50f;
			elements[i].y = rand.nextFloat()*(height+100f)-50f;
		}
	}
	
	void Do()
	{
		for(int i = 0; i<size;i++)
		{
			elements[i].x += elements[i].dx * elements[i].size;
			elements[i].y += elements[i].dy * elements[i].size;
			
			if(elements[i].x<-50f) 			elements[i].x = width + 49f;
			if(elements[i].x>width + 50f) 	elements[i].x = -49f;
			if(elements[i].y>height + 50f) 	elements[i].y = -50f;
		}
	}
	
	void Draw(Graphics2D g2d)
	{
		//Area area = new Area ( new Ellipse2D.Double ( 0, 0, 50, 50 ) );
	    //  area.subtract ( new Area (
	    //      new Ellipse2D.Double ( 25, 25, 50 - 50, 50 - 50 ) ) );
	    //  g2d.fill ( area );
		for(int i = 0; i<size;i++)
		{
			g2d.fillRect(
				(int)elements[i].x,
				(int)elements[i].y,
				(int)(elements[i].size*10f),
				(int)(elements[i].size*10f));
		}
	}
	
}
