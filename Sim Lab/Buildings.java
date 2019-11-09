import java.awt.Color;
import java.awt.Graphics;

public class Buildings
{
    private int x;
    private int y;
    private int row;
    private int col;

    public Buildings(int x, int y, int row, int col)
    {
        this.x = x;
        this.y = y;
        this.row = row;
        this.col = col;
    }

    public void drawMe(Graphics g)
    {
        for(int r=0; r<row; r++)
        {
            for(int c=0; c<col; c++)
            {
                //the building itself
                g.setColor(Color.GRAY);
                g.fillRect(x + c*70, y+r*70, 50, 70);

                for(int i=0; i<2; i++)//window space on y axis
                {
                    for(int j=0; j<2; j++)//window space on x axis
                    {
                        g.setColor(Color.WHITE);
                        g.fillRect(x+c*70 + i*25 + 7, y+r*70 + j*25 + 7, 10, 10);
                    }
                    
                }
            }
        }
    }
}