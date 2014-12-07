import java.awt.Graphics2D;


public class ParticleElement {
	float x; int x1;
	float y; int y1;
	float dx; 
	float dy;
	float size; int s;

	public void Draw(Graphics2D g2d) {
		// 
		g2d.fillRect(
				x1,
				y1,
				s,
				s);
	}
}
