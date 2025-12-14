public class Player extends Character
{
    private int lvl;
    private int expNxtLvl;
    boolean goUp;

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
            goUp = true;
            lvl++;
            setExp(getExp() - getNxtLvl());
        }
        else
        {
            goUp = false;
        }
        return goUp;
    }
    @Override
    public int attack()
    {
        System.out.println(getName() + " attacks");
        return getStr();
    }
    @Override
    public void useSpecial()
    {
        System.out.println(getName() + " uses special");
    }
}
