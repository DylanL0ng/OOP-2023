package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing extends PApplet
{

	public void settings()
	{
		size(400, 500);
	}

	public void setup() {
		colorMode(RGB);
		background(0);
	}

	public void draw()
	{
		stroke(255);
		line(10, 10, 100, 100);
		circle(100, 250, 70);
		rect(10, 300, 20, 100);
		stroke(255, 255, 255);
		triangle(10, 80, 50, 80, 100, 180);
		// triangle(40, 90, 300, 400, 900, 1000);
	}
}
