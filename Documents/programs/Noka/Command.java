/**
 * This class is an abstract superclass for all command classes in the game.
 * Each user command is implemented by a specific command subclass.
 *
 * Objects of class Command can store an optional argument word (a second
 * word entered on the command line). If the command had only one word, 
 * then the second word is <null>.
 * 
 * @author  Michael Kolling and David J. Barnes modified by Rodrigo A. Obando (2018)
 * @version 2.0 (December 2002)
 */

public abstract class Command
{
    private String secondWord;
    private String name;
    private String thirdWord;

    /**
     * Create a command object. First and second word must be supplied, but
     * either one (or both) can be null. The command word should be null to
     * indicate that this was a command that is not recognised by this game.
     */
    public Command(String name)
    {
        secondWord = null;
        this.name = name;
        thirdWord = null;
    }

    /**
     * Return the second word of this command. If no
     * second word was entered, the result is null.
     */
    public String getSecondWord()
    {
        return secondWord;
    }
    public String getThirdWord(){
        return thirdWord;
    }

    /**
     * Check whether a second word was entered for this 
     * command.
     */
    public boolean hasSecondWord()
    {
        return secondWord != null;
    }
    public boolean hasThirdWord(){
        return thirdWord != null;
    }
    /**
     * Define the second word of this command (the word
     * entered after the command word). Null indicates that 
     * there was no second word.
     */
    public void setSecondWord(String secondWord)
    {
        this.secondWord = secondWord;
    }
    public void setThirdWord(String thirdWord){
        this.thirdWord = thirdWord;
    }
    
    /**
     * Returns the name of the command.
     * Useful to store it in the CommandWords class
     */
    public String getName()
    {
        return name;
    }

    /**
     * Execute this command. A flag is returned indicating whether
     * the game is over as a result of this command.
     * 
     * @return True, if game should exit; false otherwise.
     */
    public abstract boolean execute(Player player);
}

