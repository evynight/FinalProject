import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener
{
    private final int GAME_WIDTH = 550;
    private final int GAME_HEIGHT = 365;

    JMenuBar bar = new JMenuBar();
    JMenu gameMenu = new JMenu("Game");
    JMenu aboutMenu = new JMenu("About");
    JMenuItem newGame = new JMenuItem("New Game");
    JMenuItem saveGame = new JMenuItem("Save");
    JMenuItem loadGame = new JMenuItem("Load");
    JMenuItem exitGame = new JMenuItem("Exit");
    JMenuItem playInfo = new JMenuItem("How to Play");
    JMenuItem credits = new JMenuItem("Credits");

    private final int PLAY_WIDTH = 375;
    private final int PLAY_HEIGHT = 350;
    private Dimension playDim = new Dimension(PLAY_WIDTH, PLAY_HEIGHT);
    JPanel playPane = new JPanel();
    JPanel controlPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
    static JTextArea textBox = new JTextArea(15, 35);
    JScrollPane textPane = new JScrollPane(textBox,
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    JLabel titleLabel = new JLabel("Dungeon Quest");
    JButton startButton = new JButton("Start");
    JButton nextButton = new JButton("Next");

    private final int STAT_WIDTH = 120;
    private final int STAT_HEIGHT = 60;
    private Dimension statDim = new Dimension(STAT_WIDTH, STAT_HEIGHT);
    JPanel statPane = new JPanel();
    JPanel namePane = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel lvlPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel hitPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JLabel nameLabel = new JLabel("name");
    JLabel lvlLabel = new JLabel("level");
    JLabel hitLabel = new JLabel("-");
    JLabel delimLabel = new JLabel(" / ");
    JLabel maxHitLabel = new JLabel("-");

    Border blkBrdr = BorderFactory.createLineBorder(Color.black);

    public GUI()
    {
        super("Dungeon Quest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);

        setJMenuBar(bar);
        bar.add(gameMenu);
            gameMenu.add(newGame);
            gameMenu.addSeparator();
            gameMenu.add(saveGame);
            gameMenu.add(loadGame);
            gameMenu.addSeparator();
            gameMenu.add(exitGame);
        bar.add(aboutMenu);
            aboutMenu.add(playInfo);
            aboutMenu.addSeparator();
            aboutMenu.add(credits);

        add(playPane, BorderLayout.CENTER);
        playPane.setPreferredSize(playDim);
        playPane.setMaximumSize(playDim);
        playPane.add(textPane, BorderLayout.CENTER);
            textBox.setLineWrap(true);
            textBox.setWrapStyleWord(true);
            textBox.setEditable(false);
            textBox.setFocusable(false);
        playPane.add(controlPane, BorderLayout.PAGE_END);
            controlPane.add(startButton);
            controlPane.add(nextButton);

        add(statPane, BorderLayout.LINE_START);
        statPane.setLayout(new BoxLayout(statPane, BoxLayout.Y_AXIS));
        statPane.setBorder(BorderFactory.createTitledBorder(blkBrdr, "Stats"));
        statPane.add(namePane);
            namePane.add(nameLabel);
            namePane.setPreferredSize(statDim);
            namePane.setMaximumSize(statDim);
            namePane.setBorder(BorderFactory.createTitledBorder(blkBrdr, "Player",
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        statPane.add(lvlPane);
            lvlPane.add(lvlLabel);
            lvlPane.setPreferredSize(statDim);
            lvlPane.setMaximumSize(statDim);
            lvlPane.setBorder(BorderFactory.createTitledBorder(blkBrdr, "Level",
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        statPane.add(hitPane);
            hitPane.add(hitLabel);
            hitPane.add(delimLabel);
            hitPane.add(maxHitLabel);
            hitPane.setPreferredSize(statDim);
            hitPane.setMaximumSize(statDim);
            hitPane.setBorder(BorderFactory.createTitledBorder(blkBrdr, "HP",
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        
        //pack();
        setLocationRelativeTo(null);

        newGame.addActionListener(this);
        saveGame.addActionListener(this);
        loadGame.addActionListener(this);
        exitGame.addActionListener(this);
        playInfo.addActionListener(this);
        credits.addActionListener(this);
        startButton.addActionListener(this);
        nextButton.addActionListener(this);
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
        if(source == startButton)
        {
            System.out.println("Start button pressed");
        }
        if(source == nextButton)
        {
            System.out.println("Next button pressed");
        }
    }
    public static void addTxt(String s)
    {
        textBox.append(s + "\n");
    }
}