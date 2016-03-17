package nl.ru.ai.rj;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame
{
    public Window()
    {
        // ‘super’ calls a function inherited from the parent class (JFrame)
        super();
        setTitle("Callbacks");
        setSize(new Dimension(1200, 1000));
        // Make sure the window appears in the middle of your screen
        setLocationRelativeTo(null);
        // Determines what should happen when the frame is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Chooses a certain layout type for the elements in this frame
        getContentPane().setLayout(new BorderLayout());
        // TODO: add elements to the content pane
        // Set the window to visible! Yup... This is necessary
        setVisible(true);
        //
        // Component window = new Component();
        //
        DrawPanel rp = new DrawPanel();
        InputHandler ih = new InputHandler(rp);
        ButtonPanel bp = new ButtonPanel(rp, ih);
        rp.addInputHandler(ih);
        // Places the DrawPanel in the center of the frame
        getContentPane().add(rp, BorderLayout.CENTER);
        // Places the ButtonPanel in the top of the frame
        getContentPane().add(bp, BorderLayout.NORTH);
    }
}