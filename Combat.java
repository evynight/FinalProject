import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Queue;

public class Combat
    implements Encounter, ActionListener
{
    private final int COMBAT_WIDTH = 350;
    private final int COMBAT_HEIGHT = 350;
    private Dimension combatDim = new Dimension(COMBAT_WIDTH, COMBAT_HEIGHT);
    JFrame frame = new JFrame("Fight!");

    private final int PLAY_WIDTH = 375;
    private final int PLAY_HEIGHT = 350;
    private Dimension playDim = new Dimension(PLAY_WIDTH, PLAY_HEIGHT);
    JPanel playPane = new JPanel();
    JPanel controlPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
    static JTextArea textBox = new JTextArea(15, 35);
    JScrollPane textPane = new JScrollPane(textBox,
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    JButton attack = new JButton("Attack");
    JButton defend = new JButton("Defend");
    JButton special = new JButton("Special");

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

    private Boolean multiMon;
    Player player;
    Monster mon1;
    Monster mon2;
    Queue<Character> turns = new LinkedList<Character>();

    public Combat(Player p, Monster m1)
    {
        player = p;
        mon1 = m1;
        multiMon = false;
    }
    public Combat(Player p, Monster m1, Monster m2)
    {
        player = p;
        mon1 = m1;
        mon2 = m2;
        multiMon = true;
    }
    @Override
    public void initiate()
    {
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(combatDim);
        frame.setResizable(false);

        frame.add(playPane, BorderLayout.CENTER);
        playPane.setPreferredSize(playDim);
        playPane.setMaximumSize(playDim);
        playPane.add(textPane, BorderLayout.CENTER);
            textBox.setLineWrap(true);
            textBox.setWrapStyleWord(true);
            textBox.setEditable(false);
            textBox.setFocusable(false);
        playPane.add(controlPane, BorderLayout.PAGE_END);
            controlPane.add(attack);
            controlPane.add(defend);
            controlPane.add(special);

        frame.add(statPane, BorderLayout.LINE_START);
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
        
        frame.setLocationRelativeTo(frame.getRootPane());
        frame.setVisible(true);

        attack.addActionListener(this);
        defend.addActionListener(this);
        special.addActionListener(this);

        if (!multiMon) 
        {
            addTxt("Encountered " + mon1.getName() + "!");
        }
        else
        {
            addTxt("Encountered " + mon1.getName() + " and " + mon2.getName() + "!");
        }
    }
    @Override
    public void addTxt(String s)
    {
        textBox.append(s + "\n");
    }
    @Override
    public void wrapUp()
    {
        System.out.println("All monsters defeated!");
        frame.dispose();
    }
    @Override
    public void actionPerformed(ActionEvent a)
    {
        Object source = a.getSource();

        if (source == attack)
        {
            System.out.println("Attack button pressed");
        }
        if (source == defend)
        {
            System.out.println("Defend button pressed");
        }
        if (source == special)
        {
            System.out.println("Special button pressed");
        }
    }
}
