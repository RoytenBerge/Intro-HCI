package nl.ru.ai.rj;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ButtonPanel extends JPanel
{
    public ButtonPanel(DrawPanel rp, InputHandler ih)
    {
        super();
        // Add a button to the panel. The argument to the JButton constructor
        // will become the text on the button.
        JButton b = new JButton("Change color");
        JButton del = new JButton("Delete");
        JButton delAll = new JButton("Delete all");
        JButton addRect = new JButton("Rectangle");
        JButton addLine = new JButton("Line");
        JButton addEllipse = new JButton("Ellipse");
        JButton onTop = new JButton("To foreground");
        JButton onBottom = new JButton("To background");
        JButton reshape = new JButton("Reshape");
        JTextField text = new JTextField("Typ your text here");
        JButton addText = new JButton("Add text");
        //
        add(text);
        add(addText);
        add(addRect);
        add(addLine);
        add(addEllipse);
        add(b);
        add(del);
        add(delAll);
        add(onTop);
        add(onBottom);
        add(reshape);
        //
        text.addActionListener(ih);
        addText.addActionListener(ih);
        b.addActionListener(ih);
        del.addActionListener(ih);
        delAll.addActionListener(ih);
        addRect.addActionListener(ih);
        addLine.addActionListener(ih);
        addEllipse.addActionListener(ih);
        onTop.addActionListener(ih);
        onBottom.addActionListener(ih);
        reshape.addActionListener(ih);
        //
        text.setActionCommand("textTyped");
    }
}
