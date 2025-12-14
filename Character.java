public abstract class Character 
{
    private String name;
    private int maxHP;
    private int currentHP;
    private int str;
    private int exp;

    public void setName(String n)
    {
        name = n;
    }
    public String getName()
    {
        return name;
    }
    public void setMaxHP(int m)
    {
        maxHP = m;
    }
    public int getMaxHP()
    {
        return maxHP;
    }
    public void setHP(int h)
    {
        currentHP = h;
    }
    public int getHP()
    {
        return currentHP;
    }
    public void setStr(int s)
    {
        str = s;
    }
    public int getStr()
    {
        return str;
    }
    public void setExp(int e)
    {
        exp = e;
    }
    public int getExp()
    {
        return exp;
    }
    public void takeDmg(int d)
    {
        currentHP = currentHP - d;
    }
    public int heal(int hl)
    {
        currentHP = currentHP + hl;
        if(currentHP > maxHP)
            {
                currentHP = maxHP;
            }
        return getHP();
    }
    public int maxHeal()
    {
        currentHP = maxHP;
        return getHP();
    }
    public boolean downed()
    {
        if(currentHP <= 0)
        {
            setHP(0);
            return true;
        }
        else
        {
            return false;
        }
    }
    public abstract int attack();
    public abstract void useSpecial();
}
