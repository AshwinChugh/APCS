import java.awt.Color;
import java.awt.Graphics;

public class Houses
{
    private int x;
    private int y;
    private int row;
    private int col;

    Color brown = new Color(222, 184, 135);

    public Houses(int x, int y, int row, int col)
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
                g.setColor(brown);
                g.fillRect(x + c*35, y+r*25, 30, 20);

                g.setColor(Color.WHITE);
                g.fillRect(x+c*35 +2, y+r*25 + 4, 10, 10);
            }
        }
    }
}