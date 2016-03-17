package nl.ru.ai.rj;

import java.awt.Color;
import java.awt.Graphics2D;

public class MyText implements Drawable
{
    private String text;
    private double x1, y1, x2, y2;
    private Color  color;

    public MyText(double x, double y, String text)
    {
        this.text = text;
        this.x1 = x;
        this.y1 = y;
    }

    @Override
    public void draw(Graphics2D g)
    {
        g.drawString(text, (int) x1, (int) y1);
        g.setColor(color);
        x2 = g.getFontMetrics().stringWidth(text) + x1;
        y2 = y1 + g.getFontMetrics().getHeight();
    }

    @Override
    public void setCoordinates(double x, double y)
    {
        this.x1 = x;
        this.y1 = y;
    }

    @Override
    public double getX1()
    {
        return x1;
    }

    @Override
    public double getY1()
    {
        return y1;
    }

    @Override
    public double getX2()
    {
        return x2;
    }

    @Override
    public double getY2()
    {
        return y2;
    }

    @Override
    public void setColor(Color rC)
    {
        this.color = rC;
    }

    @Override
    public boolean contains(double x, double y)
    {
        if (x1 <= x && x <= x2)
            if (y1 >= y && y <= y2)
                return true;
        return false;
    }
}
