import java.util.HashMap;

/**
 * This class is the main class of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.
 * 
 * This class holds a collection of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes modified by Rodrigo A. Obando (2018)
 * @version 2.0 (December 2002)
 */

public class CommandWords
{
    private HashMap<String, Command> commands;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        commands = new HashMap<String, Command>();
        Command command = new GoCommand();
        commands.put(command.getName(), command);
        command = new HelpCommand(this);
        commands.put(command.getName(), command);
        command = new QuitCommand();
        commands.put(command.getName(), command);
        command = new fightCommand();
        commands.put(command.getName(), command);
        command = new searchCommand();
        commands.put(command.getName(), command);
        command = new displayCommand();
        commands.put(command.getName(), command);
        command = new speakCommand();
        commands.put(command.getName(), command);
        command = new backCommand();
        commands.put(command.getName(), command);
        command = new equipCommand();
        commands.put(command.getName(), command);
        command = new pickupCommand();
        commands.put(command.getName(), command);
        command = new dropCommand();
        commands.put(command.getName(), command);
        command = new useCommand();
        commands.put(command.getName(), command);
        command = new bossKey();
        commands.put(command.getName(), command);
        command = new saveCommand();
        commands.put(command.getName(), command);
    }

    /**
     * Given a command word, find and return the matching command object.
     * Return null if there is no command with this name.
     */
    public Command get(String word)
    {
        return commands.get(word);
    }

    /*
     * Print all valid commands to System.out.
     */
    public void showAll() 
    {
        for(String commandName : commands.keySet())
        {
            System.out.print(commandName + "  ");
        }
        System.out.println();
    }
}
