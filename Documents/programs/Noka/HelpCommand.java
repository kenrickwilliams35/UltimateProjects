/**
 * Implementation of the 'help' user command.
 * 
 * @author Michael Kolling modified by Rodrigo A. Obando (2018)
 * @version 1.0 (December 2002)
 */
public class HelpCommand extends Command
{
    private CommandWords commandWords;
    
    /**
     * Constructor for objects of class HelpCommand
     */
    public HelpCommand(CommandWords words)
    {
        super("help");
        commandWords = words;
    }
    
    /**
     * Print out some help information. Here we print some stupid, 
     * cryptic message and a list of the command words.
     * Returns always false.
     */
    public boolean execute(Player player)
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("witihin the destruction.");
        System.out.println();
        System.out.println("Your command words are:");
        commandWords.showAll();
        return false;
    }
}
