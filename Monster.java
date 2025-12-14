//Second child of Character class
import java.util.Random;
public class Monster extends Character implements MonType
{
    int randNum;
    private Random random = new Random();

    public Monster() {}
    public Monster(int m)
    {
        setName(MON_NAME[m]);
        setMaxHP(MON_HP[m]);
        setHP(getMaxHP());
        setExp(MON_EXP[m]);
    }
    public void setName(int n)
    {
        setName(MON_NAME[n]);
    }
    @Override
    public int attack()
    {
        System.out.println(getName() + " attacks");
        int dmgMin = (int)Math.round((getStr() * 0.8));
        int dmgMax = (int)Math.round((getStr() * 1.2));
        return random.nextInt(dmgMin, dmgMax);
    }
    @Override
    public void useSpecial()
    {
        System.out.println("Monster specific special moves");
    }
    public void takeTurn()
    {
        System.out.println("Potentially vary monster actions");
    }
    public int giveExp()
    {
        int minGive = (int)Math.round(getExp() * 0.85);
        int maxGive = (int)Math.round(getExp() * 1.15);
        if(getExp() < 15)
        {
            minGive = (int)Math.round(getExp());
        }
        return random.nextInt(minGive, maxGive);
    }
    public Monster randMon()
    {
        randNum = random.nextInt(TOTAL_MONS);
        Monster randMon = new Monster(randNum);
        return randMon;
    }
    public Monster randWeakMon()
    {
        randNum = random.nextInt(WEAK_MONS);
        Monster weakMon = new Monster(randNum);
        return weakMon;
    }
    public Monster randMidMon()
    {
        randNum = random.nextInt(MID_MONS);
        Monster midMon = new Monster(randNum);
        return midMon;
    }
    public Monster randStrongMon()
    {
        randNum = random.nextInt(MID_MONS);
        Monster strongMon = new Monster(randNum);
        return strongMon;
    }
    public Monster bossMon()
    {
        Monster bossMon = new Monster(BOSS_MON);
        return bossMon;
    }
}