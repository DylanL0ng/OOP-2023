package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{



	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		background(0, 0, 0);
		
		playerX = width / 2.0f;
		playerY = height / 2.0f;
		playerWidth = 40.0f;
		playerSpeed = 5.0f;
		playerHeight = 0.0f;
		playerBounds = (playerWidth / 2);

		bugWidth = 10.0f;
	}
	
	float playerX, playerY, playerWidth, playerHeight, playerBounds, playerSpeed, bugWidth = 0.0f;
	
	public void draw()
	{	
		background(0, 0, 0);
		drawPlayer(playerX, playerY, playerWidth, playerHeight);
		drawBug(100, 100);
		smooth();
	}

	public void keyPressed()
	{
		// Y is inverted since it starts from top left
		if (keyCode == LEFT || key == 'a')
		{
			playerX -= playerSpeed;
			if (
				(playerX - playerBounds > width) ||
				(playerX - playerBounds < 0)
			)
				playerX += playerSpeed;
		}
		else if (keyCode == RIGHT || key == 'd')
		{
			playerX += playerSpeed;
			if ((playerX + playerBounds) > width || (playerX + playerBounds) < 0)
				playerX -= playerSpeed;
		}
		
		if (keyCode == UP || key == 'w')
		{
			playerY -= playerSpeed;
			if ((playerY - playerBounds > height) || (playerY - playerBounds < 0) )
				playerY += playerSpeed;
		}
		else if (keyCode == DOWN || key == 's')
		{
			playerY += playerSpeed;
			if ((playerY + playerBounds > height) || (playerY + playerBounds < 0))
				playerY -= playerSpeed;
		}
	
		if (key == ' ')
		{
			stroke(255, 0, 0);
			strokeWeight(1.0f);
			line(playerX, playerY, mouseX, mouseY);
		}
	}

	private void drawBug(float x, float y)
	{
		stroke(0, 255, 0);
		strokeWeight(bugWidth);
		line(x, y, x, y);
	}

	private void drawPlayer(float x, float y, float w, float h)
	{
		stroke(255, 255, 255);
		strokeCap(ROUND	);
		strokeWeight(w);
		line(x, y, x, y);

		strokeWeight(w/2);
		drawCannon(x, y, mouseX, mouseY, 35f);
	}

	private void drawCannon(float x1, float y1, float x2, float y2, float maxLen) {
		float lineLen = (float) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
		if (lineLen > maxLen) {
			float ratio = maxLen / lineLen;
			x2 = x1 + (x2 - x1) * ratio;
			y2 = y1 + (y2 - y1) * ratio;
		}

		strokeCap(SQUARE);
		line(x1, y1, x2, y2);
	}
	

}
