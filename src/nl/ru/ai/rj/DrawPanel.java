package nl.ru.ai.rj;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class DrawPanel extends JPanel
{
    // comment
    private Color              color;
    public ArrayList<Drawable> shapesList = new ArrayList<Drawable>();
    public int                 selected;
    public double              oldX;
    public double              oldY;

    DrawPanel()
    {
        super();
        // color = Color.BLACK;
    }

    public void addEllipse(double x, double y)
    {
        MyEllipse shape = new MyEllipse(x, y, x, y);
        shapesList.add(shape);
        repaint();
    }

    public void addInputHandler(InputHandler ih)
    {
        this.addMouseListener(ih);
        this.addMouseMotionListener(ih);
    }

    public void addLine(double x, double y)
    {
        MyLine shape = new MyLine(x, y, x, y);
        shapesList.add(shape);
        repaint();
    }

    public void addRectangle(double x, double y)
    {
        MyRectangle shape = new MyRectangle(x, y, x, y);
        shapesList.add(shape);
        repaint();
    }

    public void addText(double x, double y, String text)
    {
        MyText shape = new MyText(x, y, text);
        shapesList.add(shape);
        repaint();
    }

    public void delete(double x, double y)
    {
        if (shapesList.size() > 0)
        {
            int i = findTopObject(x, y);
            if (i != -1)
            {
                shapesList.remove(i);
                repaint();
            }
        }
    }

    public void deleteAll()
    {
        while (shapesList.size() > 0)
        {
            int x = shapesList.size() - 1;
            shapesList.remove(x);
        }
        repaint();
    }

    private int findBottomObject(double x, double y)
    {
        for (int i = 0; i < shapesList.size(); i++)
            if (shapesList.get(i).contains(x, y))
                return i;
        return -1;
    }

    private int findTopObject(double x, double y)
    {
        for (int i = shapesList.size() - 1; i >= 0; i--)
            if (shapesList.get(i).contains(x, y))
                return i;
        return -1;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(this.color);
        // Cast the graphics object to type Graphics2D
        Graphics2D g2d = (Graphics2D) g;
        // Loop through the shapesList and draw every shape
        for (Drawable shape : shapesList)
        {
            shape.draw(g2d);
            if (shape instanceof PossibleToFill)
            {
                ((PossibleToFill) shape).changeFillColor(this.color);
            }
        }
    }

    private void paintThisShape(Drawable drawable, Color rC)
    {
        drawable.setColor(rC);
    }

    public void rishape(double x, double y)
    {
        if (selected != -1)
        {
            Drawable d = shapesList.get(selected);
            d.setCoordinates(x, y);
            repaint();
        }
    }

    public void selectGlobalShape(double x, double y)
    {
        selected = findTopObject(x, y);
        oldY = y;
        oldX = x;
    }

    public void setColor(double x, double y)
    {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        Color rC = new Color(r, g, b);
        // color = rC;
        int i = findTopObject(x, y);
        if (i != -1)
        {
            paintThisShape(shapesList.get(i), rC);
            repaint();
        }
    }

    public void toBottom(double x, double y)
    {
        if (shapesList.size() > 1)
        {
            int i = findTopObject(x, y);
            if (i != -1)
            {
                Drawable s = shapesList.get(i);
                shapesList.remove(i);
                shapesList.add(0, s);
                repaint();
            }
        }
    }

    public void toTop(double x, double y)
    {
        if (shapesList.size() > 1)
        {
            int i = findBottomObject(x, y);
            if (i != -1)
            {
                Drawable s = shapesList.get(i);
                shapesList.remove(i);
                shapesList.add(s);
                repaint();
            }
        }
    }

    public void updateLastShape(double x, double y)
    {
        Drawable d = shapesList.get(shapesList.size() - 1);
        d.setCoordinates(x, y);
        shapesList.set(shapesList.size() - 1, d);
        repaint();
    }
}
