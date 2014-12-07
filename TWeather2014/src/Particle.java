import java.awt.*;
import java.awt.geom.*;
import java.util.Random;


public class Particle {
	float width;
	float height;
	ParticleElement[] elements;
	int size = 5000;
	Image img;
	float speed = 25f;
	public Particle(float w, float h)
	{
		//Toolkit toolkit = Toolkit.getDefaultToolkit();
		//toolkit.getImage("")
		//img = ImageIO.read(new File("strawberry.jpg"))
		img = Toolkit.getDefaultToolkit().getImage( this.getClass().getResource("/images/snowflake.png"));
		width = w;
		height = h;
		elements = new ParticleElement[size];
		Random rand = new Random();
		for(int i = 0; i<size;i++)
		{
			elements[i] = new ParticleElement();
			elements[i].size = rand.nextFloat()*0.9f+0.1f;
			elements[i].dx = rand.nextFloat() - 0.5f;
			elements[i].dx *=2f;
			elements[i].dy = rand.nextFloat() + 1f;
			elements[i].dy *=3f;
			elements[i].x = rand.nextFloat()*(width+100f)-50f;
			elements[i].y = rand.nextFloat()*(height+100f)-50f;
		}
	}
	
	void Do(float delta)
	{
		for(ParticleElement el : elements)
		{
			el.x += el.dx * el.size*delta*speed;
			el.y += el.dy * el.size*delta*speed;
			
			if(el.x<-50f) 			el.x = width + 49f;
			if(el.x>width + 50f) 	el.x = -49f;
			if(el.y>height + 50f) 	el.y = -50f;
			
			///
			el.x1 = (int)(el.x - el.size*5f);
			el.y1 = (int)(el.y - el.size*5f);
			el.s = (int)(el.size*25f);
		}
	}
	
	void Draw(Graphics2D g2d)
	{
		//g2d.setPaint ( Color.GRAY );
		//Area area = new Area ( new Ellipse2D.Double ( 0, 0, 50, 50 ) );
	    //  area.subtract ( new Area (
	    //      new Ellipse2D.Double ( 25, 25, 50 - 50, 50 - 50 ) ) );
	    //  g2d.fill ( area );
		//Thread.sleep(100);
		//java.util.concurrent.TimeUnit.SECONDS.sleep(1);
		for(ParticleElement el : elements)
		{
			g2d.drawImage(img, el.x1, el.y1, el.s, el.s ,null);
		}
		
	}
	
}
