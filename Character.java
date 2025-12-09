public abstract class Character 
{
    private String name;
    private int maxHP;
    private int currentHP;

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
    public void takeDmg(int d)
    {
        currentHP = currentHP - d;
        if(currentHP <= 0)
        {
            defeat();
        }
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
    public abstract void attack();
    public abstract void useSpecial();
    public abstract void defeat();
}
