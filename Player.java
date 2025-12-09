public class Player extends Character
{
    private int lvl;
    private int EXP;
    private int nextLvlExp;

    public Player()
    {
        super();
    }
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
    public void setExp(int e)
    {
        EXP = e;
    }
    public int getExp()
    {
        return EXP;
    }
    public void setNxtLvl(int n)
    {
        nextLvlExp = n;
    }
    public int getNxtLvl()
    {
        return nextLvlExp;
    }
    public void lvlUp()
    {
        lvl++;
    }
    @Override
    public void attack()
    {
        System.out.println(getName() + " attacks");
    }
    @Override
    public void useSpecial()
    {
        System.out.println(getName() + " uses special");
    }
    @Override
    public void defeat()
    {
        System.out.println(getName() + " defeated");
    }
    public void flee()
    {
        System.out.println(getName() + " runs from battle");
    }
}
