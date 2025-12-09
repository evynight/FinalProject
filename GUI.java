import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener
{
    private final int GAME_WIDTH = 400;
    private final int GAME_HEIGHT = 400;

    JMenuBar bar = new JMenuBar();
    JMenu gameMenu = new JMenu("Game");
    JMenu aboutMenu = new JMenu("About");
    JMenuItem newGame = new JMenuItem("New Game");
    JMenuItem saveGame = new JMenuItem("Save");
    JMenuItem loadGame = new JMenuItem("Load");
    JMenuItem exitGame = new JMenuItem("Exit");
    JMenuItem playInfo = new JMenuItem("How to Play");
    JMenuItem credits = new JMenuItem("Credits");

    public GUI()
    {
        super("Dungeon Quest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(GAME_WIDTH, GAME_HEIGHT);

        setJMenuBar(bar);
        bar.add(gameMenu);
        bar.add(aboutMenu);
        gameMenu.add(newGame);
        gameMenu.addSeparator();
        gameMenu.add(saveGame);
        gameMenu.add(loadGame);
        gameMenu.addSeparator();
        gameMenu.add(exitGame);
        aboutMenu.add(playInfo);
        aboutMenu.addSeparator();
        aboutMenu.add(credits);

        setLocationRelativeTo(null);

        newGame.addActionListener(this);
        saveGame.addActionListener(this);
        loadGame.addActionListener(this);
        exitGame.addActionListener(this);
        playInfo.addActionListener(this);
        credits.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent a)
    {
        Object source = a.getSource();

        if(source == newGame)
        {
            System.out.println("New Game clicked");
        }
        if(source == saveGame)
        {
            System.out.println("Save clicked");
        }
        if(source == loadGame)
        {
            System.out.println("Load clicked");
        }
        if(source == exitGame)
        {
            System.out.println("Exit clicked");
        }
        if(source == playInfo)
        {
            System.out.println("How to Play clicked");
        }
        if(source == credits)
        {
            System.out.println("Credits clicked");
        }
    }
}