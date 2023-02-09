package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

	int mode = 0;
	int colourIncrements = 255/14;
	int segmentIncrements;

	public void settings() {
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB, 360);
		segmentIncrements = width / 10;
	}

	public void keyPressed() {
		
		mode = key - '0';
		println(mode);
	}

	public void draw() {
		background(0);
		fill(255);

		// drawDiagonalLines();
		// drawDiagonalCrossLines();
		// drawColourfulCircleMatrix();
		// drawGridSystem();
		drawCheckerboard();
		// drawColourfulBars();
	}

	public void drawColourfulBars()
	{
		rectMode(CORNER);
		float x = 0;
		int colour = 0;
		for (int i = 0; i < 10; i++)
		{
			fill(colour, 360, 360);
			stroke(colour, 360, 360);
			rect(x, 0, segmentIncrements, height);

			x += segmentIncrements;
			colour += colourIncrements;
		}
	}
	public void drawColourfulCircle()
	{
		float x = width / 2;
		float y = height / 2;
		float boxH = height;
		float boxW = width;
		int colour = 280;
		
		for (int i = 0; i < 10; i++)
		{
			fill(colour, 360, 360);
			stroke(colour, 360, 360);
			ellipse(x, y, boxH, boxW);

			colour -= 25;
			boxH -= 50;
			boxW -= 50;
		}
	}
	public void drawColourfulCircles()
	{
		float y = height / 2;
		float boxW = width / 10;
		int colour = 0;
		float x = boxW / 2;
		
		for (int i = 0; i < 10; i++)
		{
			fill(colour, 360, 360);
			stroke(colour, 360, 360);
			ellipse(x, y, boxW, boxW);

			x += boxW;
			colour += 25;
		}
	}

	public void drawCheckerboard()
	{
		rectMode(CORNER);
		int boxW = width / 20;
		int boxH = height / 20;

		int colourA = 210;
		int colourB = 360;

		float x = 0.0f;
		float y = 0.0f;

		for (int i = 0; i < 20; i++)
		{
			x = 0.0f;
			for (int j = 0; j < 20; j++)
			{
				int fill = (i % 2 == 0) ? colourA : colourB;
				if (j % 2 == 0)
					fill = (i % 2 == 0) ? colourB : colourA;
				
				stroke(250, 360, fill);
				fill(250, 360, fill);
				rect(x, y, boxW, boxH);
				
				x += boxW;
			}

			y += boxH;
		}
	}

	public void drawGridSystem()
	{
		int boxSize = height / 12;
		
		float topOffset = boxSize / 2f;
		float leftOffset = boxSize / 3.0f;

		int xCoords = -5;
		int yCoords = -5;

		float x = 0.0f;
		float y = 0.0f;

		// i < amount of columns + 1 (account for header cols and rows)
		for (int i = 1; i <= 11 * 11; i++)
		{
			// Check if its at the start of the columns or rows
			// this will be used for the coordinates
			if (y == 0.0 || x == 0.0)
			{
				fill(0, 0, 360);
				// If its on the top column we offset the height so it aligns nicely
				if (x != 0.0f) {
					// Hacky fix for top coordinates not accounting for the first -5
					text(yCoords, x + boxSize, y + topOffset);
					if (x == boxSize)
						text(-5, x + boxSize - boxSize, y + topOffset);
				}
				else 
				{
					// If its on the left rows we offset the height so it aligns nicely
					text(xCoords, x + leftOffset, y + boxSize);
				}
			} else {
				fill(0, 0, 0);
				stroke(100, 360, 360);
				rect(x, y, boxSize, boxSize);
			}
			
			x+=boxSize;
			yCoords++;

			if (i % 11 == 0)
			{
				// reset if end of row
				y+=boxSize;
				xCoords++;
				x = 0;
			}
		}
	}

	public void drawColourfulCircleMatrix()
	{
		// Could do with some work for the colours
		float boxW = width / 10;
		int colour = 0;
		float x = boxW / 2;
		float y = x;
		
		// rows
		for (int j = 0; j < 10; j++)
		{
			x = boxW / 2;
			colour = j * 6;
			// columns
			for (int i = 0; i < 10; i++)
			{
				fill(colour, 360, 360);
				stroke(colour, 360, 360);
				ellipse(x, y, boxW, boxW);
	
				x += boxW;
				colour += i * 8;
			}
			y+=boxW;
		}
	}
	
	
	public void drawDiagonalLines()
	{
		float x = 0;
		float y = 0;
		int colour = 0;
		int boxSize = height / 10;

		for (int i = 0; i < 10; i++)
		{
			fill(colour, 360, 360);
			stroke(colour, 360, 360);
			rect(x, y, segmentIncrements, boxSize);

			x += segmentIncrements;
			y += boxSize;
			colour += 35;
		}
	}
	public void drawDiagonalCrossLines()
	{
		float x = 0;
		float y = 0;
		int colour = 0;
		int boxSize = height / 10;

		for (int i = 0; i <10; i++)
		{
			fill(colour, 360, 360);
			stroke(colour, 360, 360);
			rect(x, y, segmentIncrements, boxSize);
			rect(width - x, y, -segmentIncrements, boxSize);

			x += segmentIncrements;
			y += boxSize;
			colour += 35;
		}
	}
}
