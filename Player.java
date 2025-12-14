//First child of Character class
import java.util.Random;
public class Player extends Character
{
    private int lvl;
    private int expNxtLvl;
    boolean goUp;
    Random random = new Random();

    public Player(String n)
    {
        super();
        setName(n);
    }
    public void setLvl(int l)
    {
        lvl = l;
    }
    public int getLvl()
    {
        return lvl;
    }
    public void setNxtLvl(int n)
    {
        expNxtLvl = n;
    }
    public int getNxtLvl()
    {
        return expNxtLvl;
    }
    public void gainExp(int g)
    {
        setExp(getExp() + g);
    }
    public boolean lvlUp()
    {
        if(getExp() >= getNxtLvl())
        {
            while(getExp() >= getNxtLvl())
            {               
                setExp(getExp() - getNxtLvl());
                nxtLvlUp();
                lvl++;
            }
            goUp = true;
        }
        else
        {
            goUp = false;
        }
        return goUp;
    }
    public void nxtLvlUp()
    {
        int newGoalExp = (int)Math.round(getNxtLvl() / ((getLvl() -1) / getLvl()));
        expNxtLvl = newGoalExp;
    }
    @Override
    public int attack()
    {
        System.out.println(getName() + " attacks");
        int minDmg = (int)Math.round(getStr() + 1.15);
        int maxDmg = (int)Math.round(getStr() + 1.30);
        return random.nextInt(minDmg, maxDmg);
    }
    @Override
    public void useSpecial()
    {
        System.out.println(getName() + " uses special");
    }
}
