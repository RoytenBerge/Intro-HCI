package nl.ru.ai.rj;

import javax.swing.SwingUtilities;

public class Colorclicker
{

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new Window();
            }
        });
    }

}
