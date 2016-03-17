package nl.ru.ai.rj;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class MyLine implements Drawable
{
    private static final int HIT_BOX_SIZE = 4;
    private Color            color;
    private Line2D           line;
    private double           x1, y1, x2, y2;

    public MyLine()
    {
    }

    public MyLine(double x1, double y1, double x2, double y2)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public boolean contains(double x, double y)
    {
        // source: http://stackoverflow.com/questions/1797209/how-to-select-a-line
        double boxX = x - HIT_BOX_SIZE / 2;
        double boxY = y - HIT_BOX_SIZE / 2;
        int width = HIT_BOX_SIZE;
        int height = HIT_BOX_SIZE;
        return line.intersects(boxX, boxY, width, height);
    }

    @Override
    public void draw(Graphics2D g)
    {
        line = new Line2D.Double(x1, y1, x2, y2);
        g.setPaint(color);
        g.draw(line);
    }

    @Override
    public double getX1()
    {
        return x1;
    }

    @Override
    public double getX2()
    {
        return x2;
    }

    @Override
    public double getY1()
    {
        return y1;
    }

    @Override
    public double getY2()
    {
        return y2;
    }

    @Override
    public void setColor(Color rC)
    {
        color = rC;
    }

    @Override
    public void setCoordinates(double x, double y)
    {
        this.x1 = x;
        this.y1 = y;
    }
}
