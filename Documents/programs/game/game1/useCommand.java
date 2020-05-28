
/**
 * Write a description of class useCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class useCommand extends Command {
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class useCommand
     */
    public useCommand()
    {
       super("use");
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean execute(Player player){
        if(hasSecondWord()){
            if(player.getItems().containsKey(getSecondWord())){
                player.getItems().get(getSecondWord()).getBenefit(player);
                System.out.println("You have used " + getSecondWord() + ".");
                player.getItems().remove(getSecondWord());
            }else{
                System.out.println("you do not contain this item.");
            }
        }else{
            System.out.println("use what?");
        }
        return false;
    }
}
