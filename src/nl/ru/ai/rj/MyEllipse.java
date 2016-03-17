package nl.ru.ai.rj;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class MyEllipse implements Drawable, PossibleToFill
{
    private Color     color;
    private Ellipse2D ellipse;
    private double    x1, x2, y1, y2;

    public MyEllipse()
    {
    }

    public MyEllipse(double x1, double y1, double x2, double y2)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void changeFillColor(Color fillColor)
    {
        this.color = fillColor;
    }

    @Override
    public boolean contains(double x, double y)
    {
        return ellipse.contains(x, y);
    }

    @Override
    public void draw(Graphics2D g)
    {
        double x = getStartX();
        double y = getStartY();
        double width = getWidth();
        double height = getHeight();
        ellipse = new Ellipse2D.Double(x, y, width, height);
        g.setPaint(color);
        g.setColor(color);
        g.fill(ellipse);
        g.draw(ellipse);
    }

    private double getHeight()
    {
        return Math.abs(y1 - y2);
    }

    private double getStartX()
    {
        return Math.min(x1, x2);
    }

    private double getStartY()
    {
        return Math.min(y1, y2);
    }

    private double getWidth()
    {
        return Math.abs(x1 - x2);
    }

    @Override
    public double getX1()
    {
        return x1;
    }

    @Override
    public double getX2()
    {
        // TODO Auto-generated method stub
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
