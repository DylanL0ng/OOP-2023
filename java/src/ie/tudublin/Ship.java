package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class Ship {
    private PVector pos;
    private PApplet p;

    private float rot;
    private float size; 
    
    private int col;

    private float halfSize;

    public Ship(float x, float y, float size, int col, PApplet p)
    {
        this.col = col;
        this.size = size;
        this.halfSize = size / 2;
        
        pos = new PVector(x, y);
        this.p = p;
    }

    public void render()
    {
        // p.beginShape();
        // p.vertex(pos.x - halfSize, pos.y + halfSize);
        // p.vertex(pos.x - halfSize, pos.y - 0);
        // p.vertex(pos.x - this.size, pos.y - this.size);
        // p.vertex(pos.x - this.size / 2, pos.y - halfSize);
        // p.vertex(pos.x - 0, pos.y + this.size);
        // p.endShape();

        p.translate(this.pos.x, this.pos.y);
        p.rotate(this.rot);

        p.stroke(this.col, 255, 255);
        p.line(- halfSize, halfSize, 0, - halfSize);
        p.line(0, - halfSize, halfSize, + halfSize);
        p.line(halfSize, halfSize, 0, 0);
        p.line(0, 0, - halfSize, + halfSize);
    }

    public void move()
    {
        if (!p.keyPressed) return;

        switch(p.keyCode)
        {
            case PApplet.LEFT:
                this.rot-= 0.1f;
                break;
            case PApplet.RIGHT:
                this.rot+= 0.1f;
            break;
            case PApplet.DOWN:
                pos.y++;
            break;
            case PApplet.UP:
                pos.y--;
            break;
        }
    }

    public PVector getPos() {
        return pos;
    }

    public void setPos(PVector pos) {
        this.pos = pos;
    }

    public float getRot() {
        return rot;
    }

    public void setRot(float rot) {
        this.rot = rot;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
