package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class Ship {
    private PVector pos;
    private PVector fwd;
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
        fwd = new PVector(0, 0);
        this.p = p;
    }

    public void render()
    {
        p.pushMatrix();
        p.translate(this.pos.x, this.pos.y);
        p.rotate(this.rot);

        p.stroke(this.col, 255, 255);
        p.line(- halfSize, halfSize, 0, - halfSize);
        p.line(0, - halfSize, halfSize, + halfSize);
        p.line(halfSize, halfSize, 0, 0);
        p.line(0, 0, - halfSize, + halfSize);
        p.popMatrix();
    }

    public void move()
    {
        fwd.x = PApplet.sin(rot);
        fwd.y = -PApplet.cos(rot);

        if (!p.keyPressed) return;

        // fwd.x = 
        switch(p.keyCode)
        {
            case PApplet.LEFT:
                this.rot-= 0.1f;
                break;
            case PApplet.RIGHT:
                this.rot+= 0.1f;
            break;
            case PApplet.DOWN:
                pos.x -= fwd.x;
                pos.y -= fwd.y;
                break;
                case PApplet.UP:
                pos.y += fwd.y;
                pos.x += fwd.x;
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
