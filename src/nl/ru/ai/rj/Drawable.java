package nl.ru.ai.rj;

import java.awt.Color;
import java.awt.Graphics2D;

public interface Drawable
{
    public void draw(Graphics2D g);

    public void setCoordinates(double x, double y);

    public double getX1();

    public double getY1();

    public double getX2();

    public double getY2();

    public void setColor(Color rC);

    public boolean contains(double x, double y);
}