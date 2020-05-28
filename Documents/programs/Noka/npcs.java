
/**
 * Write a description of class npcs here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.*;

public class npcs extends organism

{
    // instance variables - replace the example below with your own
    private String reply;
    private ArrayList<String> replies;
    private String name;
    
    public npcs(double Health, String name)
    {
       super(Health, name);
       this.name = name;
       replies = new ArrayList<String>();
       
    }
    
    public void Dialouge(Player player)
    {
        if(this.name.equals("General Tulius")){
           System.out.println("The general is here");
        }else if(this.name.equals("Lone Sniper")){
            System.out.println("The sniper is here");
        }else if(this.name.equals("Lost Warrior")){
            System.out.println("The lost warrior is here");
        }else if(this.name.equals("Mother Teresa")){
            String reply4 = "";
            Scanner scan = new Scanner(System.in);
            System.out.println("ahhh welcome my child ... how can I help you?");
            
            System.out.println("\nBlessing\nQuest\nStrength");
            while (!reply4.equals("leave")){
                
                 System.out.println("\nWhat will you choose?(Type leave to exit)\n");
                 reply4 = scan.nextLine();
                 if(reply4.equals("Blessing")){
                     
                    if(player.getItems().containsKey("Vile")){
                        player.setCurrentHealth(500.0);
                        System.out.println("I have restored your health my child ... do be careful in the waste.");
                        player.getItems().remove("Vile");
                    }else{
                        System.out.println("Im sorry, but you do not contain a vile.");
                    }
                     
                  }else if(reply4.equals("Quest")){
                      if(player.getItems().containsKey("Blood")){
                          if(!player.getItems().containsKey("bossKey")){
                          System.out.println("Here is the key my child.");
                          Items bossKey = new Items("bossKey", 0, 0);
                          player.getItems().put("bossKey", bossKey);
                          player.getItems().remove("Blood");
                        }else{
                            System.out.println("you already have the key.");
                        }
                        }else{
                             System.out.println("Bring me blood child and I will give you the key.");
                        }
                     
                       
                    }else if(reply4.equals("Strength")){
                        System.out.println("you have aquired strength");
                    }else if(reply4.equals("leave")){
                        System.out.println("See you soon.");
                    }else{
                        System.out.println("Say it again dear?");
                    }
        }
        } 
    }
  

}
