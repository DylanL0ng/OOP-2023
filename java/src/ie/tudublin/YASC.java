package ie.tudublin;

import processing.core.PApplet;

public class YASC extends PApplet
{

	Ship ship;
	Ship ship2;

	public void settings()
	{
		size(500, 500);
	}
	
	public void setup() {
		ship = new Ship(width / 2, height / 2, 50.0f, 70, this);
		ship2 = new Ship(width * 0.2f, height / 2, 50.0f, 70, this);
		colorMode(HSB);
	}

	public void draw()
	{	
		background(0);

		ship.render();
		ship.move();
		
		ship2.render();
		ship2.move();
	}
}
