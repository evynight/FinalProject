public class SaveDetectionException extends Exception
{
    public SaveDetectionException()
    {
        super("No save file currently in use. Start a new file or load one from memory.");
    }
}
