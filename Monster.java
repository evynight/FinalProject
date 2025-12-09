public class Monster extends Character
{
    public static final int WEAK_MON = 1;
    public static final int STRONG_MON = 2;
    private int activeMon;
    private String[] poolMon = {"(weak placeholder)",
                                "(strong placeholder)"};
    public Monster()
    {
        super();
    }
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
    public void attack()
    {
        System.out.println(poolMon[activeMon] + " attacks");
    }
    @Override
    public void useSpecial()
    {
        System.out.println(poolMon[activeMon] + " uses special");
    }
    @Override
    public void defeat()
    {
        System.out.println(poolMon[activeMon] + " defeated");
    }
}