package nl.ru.ai.rj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JTextField;

public class InputHandler implements ActionListener, MouseListener, MouseMotionListener
{
    public enum Command
    {
        RECTANGLE, LINE, ELLIPSE, DELETE, DRAG, COLOR, TOBOTTOM, ONTOP, RESHAPE, ADDTEXT
    }

    private DrawPanel rp;
    public Command    shape = Command.RECTANGLE;
    public String     text  = "Typ your text here";

    public InputHandler(DrawPanel rp)
    {
        this.rp = rp;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        switch (command)
        {
            case "Change color":
                shape = Command.COLOR;
                break;
            case "Delete":
                shape = Command.DELETE;
                break;
            case "Delete all":
                rp.deleteAll();
                break;
            case "Rectangle":
                shape = Command.RECTANGLE;
                break;
            case "Line":
                shape = Command.LINE;
                break;
            case "Ellipse":
                shape = Command.ELLIPSE;
                break;
            case "To foreground":
                shape = Command.ONTOP;
                break;
            case "To background":
                shape = Command.TOBOTTOM;
                break;
            case "Reshape":
                shape = Command.RESHAPE;
                break;
            case "textTyped":
                if (e.getSource() instanceof JTextField)
                {
                    JTextField s = (JTextField) (e.getSource());
                    text = s.getText();
                }
                break;
            case "Add text":
                shape = Command.ADDTEXT;
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        double x = e.getX();
        double y = e.getY();
        switch (shape)
        {
            case DELETE:
                rp.delete(x, y);
                break;
            case RECTANGLE:
                rp.updateLastShape(x, y);
                break;
            case ELLIPSE:
                rp.updateLastShape(x, y);
                break;
            case LINE:
                rp.updateLastShape(x, y);
                break;
            case RESHAPE:
                rp.rishape(x, y);
                break;
            default:
                System.out.println("No command for mouseDragged");
        }
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        double x = e.getX();
        double y = e.getY();
        switch (shape)
        {
            case COLOR:
                rp.setColor(x, y);
                break;
            case RECTANGLE:
                rp.addRectangle(x, y);
                break;
            case ELLIPSE:
                rp.addEllipse(x, y);
                break;
            case LINE:
                rp.addLine(x, y);
                break;
            case DELETE:
                rp.delete(x, y);
                break;
            case ONTOP:
                rp.toTop(x, y);
                break;
            case TOBOTTOM:
                rp.toBottom(x, y);
                break;
            case RESHAPE:
                rp.selectGlobalShape(x, y);
                break;
            case ADDTEXT:
                rp.addText(x, y, text);
                break;
            default:
                System.out.println("No action available");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        // TODO Auto-generated method stub
    }
}
