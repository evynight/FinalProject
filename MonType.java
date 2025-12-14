public interface MonType
{
    public static final int SLIME = 0;
    public static final int GIANT_RAT = 1;
    public static final int GOBLIN = 2;
    public static final int REANIMATED_SKELETON = 3;
    public static final int GIANT_SPIDER = 4;
    public static final int TROLL = 5;
    public static final int STONE_GOLEM = 6;
    public static final int MINOTAUR = 7;
    public static final int LESSER_DEMON = 8;
    public static final int DRAGON_WYRMLING = 9;

    public static final int WEAK_MON = 3;
    public static final int MID_MON = 6;
    public static final int STRONG_MON = 9;
    public static final int BOSS_MON = 10;
    public static final int TOTAL_MON = 10;

    public static final String[] MON_NAME = {"Slime",
                                                "Giant Rat",
                                                "Goblin",
                                                "Reanimated Skeleton",
                                                "Giant Spider",
                                                "Troll",
                                                "Minotaur",
                                                "Stone Golem",
                                                "Lesser Demon",
                                                "Dragon Wyrmling"};
    public static final int[] MON_HP = {6,11,16,28,44,65,78,85,100};
    public static final int[] MON_STR = {1,3,5,9,16,24,33,41,52,65};
    public static final int[] MON_EXP = {2,4,7,16,21,27,35,47,55,65};
}
