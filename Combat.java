//First child class of Encounter interface
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Queue;

public class Combat extends JFrame
    implements Encounter, ActionListener
{
    private final int COMBAT_WIDTH = 550;
    private final int COMBAT_HEIGHT = 315;
    private Dimension combatDim = new Dimension(COMBAT_WIDTH, COMBAT_HEIGHT);

    private final int PLAY_WIDTH = 375;
    private final int PLAY_HEIGHT = 350;
    private Dimension playDim = new Dimension(PLAY_WIDTH, PLAY_HEIGHT);
    JPanel playPane = new JPanel();
    JPanel controlPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JTextArea textBox = new JTextArea(15, 35);
    JScrollPane textPane = new JScrollPane(textBox,
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    JButton attack = new JButton("Attack");
    JButton defend = new JButton("Defend");
    JButton special = new JButton("Special");
    JButton next = new JButton("Next");
    JButton atkMon1 = new JButton();
    JButton atkMon2 = new JButton();

    private final int STAT_WIDTH = 120;
    private final int STAT_HEIGHT = 60;
    private Dimension statDim = new Dimension(STAT_WIDTH, STAT_HEIGHT);
    JPanel statPane = new JPanel();
    JPanel namePane = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel lvlPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel hitPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel strPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel expPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JLabel nameLabel = new JLabel("-");
    JLabel lvlLabel = new JLabel("-");
    JLabel hitLabel = new JLabel("-");
    JLabel hitDelim = new JLabel(" / ");
    JLabel maxHitLabel = new JLabel("-");
    JLabel strLabel = new JLabel("-");
    JLabel expLabel = new JLabel("-");
    JLabel expDelim = new JLabel(" / ");
    JLabel nxtExpLabel = new JLabel("-");

    Border blkBrdr = BorderFactory.createLineBorder(Color.black);

    private final int SEL_ATK = 1;
    private final int SEL_DFN = 2;
    private final int SEL_SPE = 3;
    private final int SEL_MON1 = 0;
    private final int SEL_MON2 = 1;
    private int select;
    private int selectMon;
    private int earnedExp = 0;
    private boolean multiMon;
    private boolean end = false;
    Player player;
    Monster mon1;
    Monster mon2;
    //Two Queues for working through turn order and displaying the actions of every Characters' turn
    Queue<Character> turn = new LinkedList<Character>();
    Queue<String> combatMsg = new LinkedList<String>();

    public Combat(Player p, Monster m1)
    {
        player = p;
        mon1 = m1;
        multiMon = false;
        selectMon = SEL_MON1;
    }
    //Above and below are overloaded constructors
    public Combat(Player p, Monster m1, Monster m2)
    {
        player = p;
        mon1 = m1;
        mon2 = m2;
        multiMon = true;
        if(mon1.getName().equals(mon2.getName()))
        {
            mon1.setName(mon1.getName() + "(1)");
            mon2.setName(mon2.getName() + "(2)");
        }
    }
    //Five overrideden methods here
    @Override
    public void initiate()
    {
        setTitle("Fight!");
        setUndecorated(true);
        setSize(combatDim);
        setResizable(false);

        add(playPane, BorderLayout.CENTER);
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
            controlPane.add(next);
                next.setVisible(false);
            controlPane.add(atkMon1);
                atkMon1.setVisible(false);
            controlPane.add(atkMon2);
                atkMon2.setVisible(false);

        buildStatBar();
        updateStats();
        
        setLocationRelativeTo(getRootPane());
        setVisible(true);

        attack.addActionListener(this);
        defend.addActionListener(this);
        special.addActionListener(this);
        next.addActionListener(this);
        atkMon1.addActionListener(this);
        atkMon2.addActionListener(this);

        if (!multiMon) 
        {
            addTxt("Encountered " + mon1.getName() + "!");
        }
        else
        {
            addTxt("Encountered " + mon1.getName() + " and " + mon2.getName() + "!");
        }
        prompt();
    }
    @Override
    public void prompt()
    {
        addTxt("\nWhat will " + player.getName() + " do?\n");
    }
    @Override
    public void addTxt(String s)
    {
        textBox.append(s + "\n");
        textBox.getCaret().setDot(Integer.MAX_VALUE);
    }
    @Override
    public void wrapUp()
    {
        System.out.println("Ending combat");
        dispose();
    }
    @Override
    public void actionPerformed(ActionEvent a)
    {
        Object source = a.getSource();

        if(source == attack)
        {
            System.out.println("Attack button pressed");
            if(multiMon && (!mon1.downed() || mon2.downed()))
            {
                attack.setVisible(false);
                defend.setVisible(false);
                special.setVisible(false);
                atkMon1.setText("Attack " + mon1.getName());
                atkMon1.setVisible(true);
                atkMon2.setText("Attack " + mon2.getName());
                atkMon2.setVisible(true);
            }
            else
            {
                startRound(SEL_ATK);
            }
        }
        if(source == defend)
        {
            System.out.println("Defend button pressed");
            startRound(SEL_DFN);
        }
        if(source == special)
        {
            System.out.println("Special button pressed");
            System.out.println(getRootPane());
        }
        if(source == next)
        {
            System.out.println(turn);
            System.out.println("Next button pressed");
            if(!combatMsg.isEmpty())
            {
                addTxt(combatMsg.poll());
                updateStats();
            }
            else if(combatMsg.isEmpty() && end)
            {
                wrapUp();
            }
            else
            {
                takeTurn();
            }

        }
        if(source == atkMon1)
        {
            System.out.println("atkMon1 button pressed");
            selectMon = SEL_MON1;
            atkMon1.setVisible(false);
            atkMon2.setVisible(false);
            startRound(SEL_ATK);
        }
        if(source == atkMon2)
        {
            System.out.println("atkMon2 button pressed");
            selectMon = SEL_MON2;
            atkMon1.setVisible(false);
            atkMon2.setVisible(false);
            startRound(SEL_ATK);
        }
    }
    public void startRound(int s)
    {
        select = s;
        turn.offer(player);
        if(multiMon)
        {
            if(!mon1.downed())
            {
                turn.offer(mon1);
            }
            if(!mon2.downed())
            {
                turn.offer(mon2);
            }
        }
        else
        {
          turn.offer(mon1);
        }
        attack.setVisible(false);
        defend.setVisible(false);
        special.setVisible(false);
        next.setVisible(true);
        takeTurn();
    }
    public void endRound()
    {
        if (player.downed())
        {
            defeat();
        }
        if(multiMon)
        {
            if(mon1.downed() && mon2.downed())
            {
                victory();
            }
            else
            {
                if(!mon1.downed())
                {
                    selectMon = SEL_MON1;
                }
                if(!mon2.downed())
                {
                    selectMon = SEL_MON2;
                }
            }    
        }
        else if(!multiMon && mon1.downed())
        {
            victory();
        }
        if(!end)
        {
            attack.setVisible(true);
            defend.setVisible(true);
            special.setVisible(true);
            next.setVisible(false);
            prompt();
        }   
    }
    public void takeTurn()
    {
        int dmg;
        if(turn.peek() != null)
        {
            if(turn.peek() == player)
            {
                if(select == SEL_ATK)
                {
                    dmg = turn.poll().attack();
                    if(selectMon == SEL_MON1)
                    {
                        addTxt(player.getName() + " attacks the " + mon1.getName() + "!");
                        mon1.takeDmg(dmg);
                        combatMsg.offer(mon1.getName() + " takes " + dmg + " damage!" + " (" + mon1.getHP() + " remaining)");
                        if(mon1.downed())
                        {
                            combatMsg.offer(mon1.getName() + " was slain!");
                            earnedExp = earnedExp +  mon1.giveExp();
                            if(mon2.downed())
                            {
                                endRound();
                                turn.clear();
                            }
                        }
                    }
                    else
                    {
                        addTxt(player.getName() + " attacks the " + mon2.getName() + "!");
                        mon2.takeDmg(dmg);
                        combatMsg.offer(mon2.getName() + " takes " + dmg + " damage!" + " (" + mon2.getHP() + " remaining)");
                        if(mon2.downed())
                            {
                            combatMsg.offer(mon2.getName() + " was slain!");
                            earnedExp = earnedExp +  mon2.getExp();
                                if(mon1.downed())
                                {
                                    endRound();
                                    turn.clear();
                                } 
                            }
                    }
                }
                else if(select == SEL_DFN)
                {
                    addTxt(player.getName() + " takes a defensive stance!");
                    turn.poll();
                }
                else if(select == SEL_SPE)
                {
                    addTxt(player.getName() + " does another thing we'll figure out soon!");
                    turn.poll();
                }
            }
            else
            {
                if(turn.peek().downed())
                {
                    turn.poll();
                    takeTurn();
                }
                else
                {
                    addTxt(turn.peek().getName() + " attacks " + player.getName() + "!");
                    dmg = turn.poll().attack();
                    player.takeDmg(dmg);
                    combatMsg.offer(player.getName() + " takes " + dmg + " damage!");
                    if(player.downed())
                    {
                        combatMsg.offer(player.getName() + " was dealt a fatal blow...");
                        endRound();
                        turn.clear();
                    }
                }

            }
        }
        else
        {
            endRound();
        }
    }
    public void victory()
    {
        System.out.println("Victory > Player defeated monster(s)");
        end =  true;
        combatMsg.offer(player.getName() + " has won the battle!");
        combatMsg.offer("Gained " + earnedExp + " experience points!");
        int prevLvl = player.getLvl();
        player.gainExp(earnedExp);
        if (player.lvlUp())
        {
            combatMsg.offer("Level up! Raised from " + prevLvl + " to " + player.getLvl() + "!");    
        }
    }
    public void defeat()
    {
        System.out.println("Defeat > Player dies");
        end = true;
        combatMsg.offer(player.getName() + "'s body crumples beneath them in a broken heap.");
        combatMsg.offer("Maybe they weren't meant to be an adventurer, after all...");
    }
        public void updateStats()
    {
        nameLabel.setText(player.getName());
        lvlLabel.setText(String.valueOf(player.getLvl()));
        hitLabel.setText(String.valueOf(player.getHP()));
        maxHitLabel.setText(String.valueOf(player.getMaxHP()));
        strLabel.setText(String.valueOf(player.getStr()));
        expLabel.setText(String.valueOf(player.getExp()));
        nxtExpLabel.setText(String.valueOf(player.getNxtLvl()));
    }
    public void buildStatBar()
    {
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
            hitPane.add(hitDelim);
            hitPane.add(maxHitLabel);
            hitPane.setPreferredSize(statDim);
            hitPane.setMaximumSize(statDim);
            hitPane.setBorder(BorderFactory.createTitledBorder(blkBrdr, "HP",
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        statPane.add(strPane);
            strPane.add(strLabel);
            strPane.setBorder(BorderFactory.createTitledBorder(blkBrdr, "STR",
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        statPane.add(expPane);
            expPane.add(expLabel);
            expPane.add(expDelim);
            expPane.add(nxtExpLabel);
            expPane.setBorder(BorderFactory.createTitledBorder(blkBrdr, "EXP",
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        }
    }