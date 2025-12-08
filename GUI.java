import javax.swing.*;

public class GUI extends JFrame
{
    private final int GAME_WIDTH = 400;
    private final int GAME_HEIGHT = 400;
    public GUI()
    {
        super("Game Title");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setLocationRelativeTo(null);
    }
}
