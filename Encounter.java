public interface Encounter
{
    public abstract void initiate();
    public abstract void prompt();
    public abstract void addTxt(String s);
    public abstract void wrapUp();
}
