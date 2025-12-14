public class Monster extends Character
{
    public static final int WEAK_MON = 0;
    public static final int STRONG_MON = 1;
    private int activeMon;
    private String[] poolMon = {"(weak placeholder)",
                                "(strong placeholder)"};

    public Monster(int n)
    {
        super();
        activeMon = n;
        setName(poolMon[activeMon]);
    }
    public void setName(int m)
    {
        activeMon = m;
        super.setName(poolMon[activeMon]);
    }
    @Override
    public int attack()
    {
        System.out.println(poolMon[activeMon] + " attacks");
        return getStr();
    }
    @Override
    public void useSpecial()
    {
        System.out.println(poolMon[activeMon] + " uses special");
    }
}