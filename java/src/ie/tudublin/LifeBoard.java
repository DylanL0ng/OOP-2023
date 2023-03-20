package ie.tudublin;

import processing.core.PApplet;

public class LifeBoard {
    boolean[][] board;
    boolean[][] next;
    PApplet p;

    private int size;
    private float cellSize = 5;

    public LifeBoard(int size, PApplet p)
    {   
        this.size = size;
        board = new boolean[size][size];
        next = new boolean[size][size];
        this.p = p;
    }

    public int getSize() {
        return size;
    }

    public void randomise() {
        for (int row = 0; row < size; row++)
        {
            for (int col = 0; col < size; col++)
            {
                float dice = p.random(0, 1);
                board[row][col] = dice <= 0.5;
            }
        }
    }

    public void applyRules()
    {
        for (int row = 0; row < this.size; row++)
        {
            for (int col = 0; col < this.size; col++)
            {
                int count = countCells(row, col);
                // < 2 > 3 dies
                // 2-3 survives
                // dead with 3 neighbours comes to life
                
                if (this.board[row][col])
                {
                    if (count == 2 || count == 3)
                        this.next[row][col] = true;
                    else
                        this.next[row][col] = false;
                }
                else
                {
                    if (count == 3)
                        this.next[row][col] = true;
                    else
                        this.next[row][col] = false;
                }
            }
        } 

        // boolean[][] temp = new boolean[size][size];
        // temp = board;
        // this.board = this.next;
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                this.board[row][col] = this.next[row][col];
            }
        }

        // this.next = temp;
    }

    public boolean getCell(int row, int col) {
        if (row >= 0 && row < size && col >= 0 && col < size) {
            return this.board[row][col];
        } else {
            return false;
        }
    }


    public int countCells(int row, int col) {
        int count = 0; 

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col -1; j <= col + 1; j++) {
                if (i != row || j != col) {
                    if (getCell(i, j)) {
                        count++;
                    }
                }
            } // end for
        } // end for 

        return count;
    }

    public void render()
    {
        float posX = 0.0f, posY = 0.0f;
        p.background(0);
        for (int row = 0; row < this.size; row++)
        {
            for (int col = 0; col < this.size; col++)
            {
                if (this.board[row][col])
                {
                    p.fill(p.random(255), 255, 255);
                    p.rect(posX, posY, cellSize, cellSize);
                }
                posX = col * cellSize;
            }
            posY = row * cellSize;
        }
        
        p.delay(100); // 100ms delay
        applyRules();
        
        // p.delay(0);

    }


    public void setSize(int size) {
        this.size = size;
    }
}
