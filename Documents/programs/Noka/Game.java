/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.
 * 
 * @author  Michael Kolling and David J. Barnes modified by Rodrigo A. Obando (2018)
 * @version 1.1 (December 2002)
 */
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.util.StringTokenizer;

class Game 
{
    private Parser parser;
    private Player player;
    private String name;
    private GameWorld gameWorld;
    private Trader trader;
    private boolean loader = false;
    /**
     * Create the game and initialise its internal map.
     */
    public Game(String name) 
    {
        Scanner scan = new Scanner(System.in);
        String answer = "";
        this.name = name;
        GameWorld gameWorld = new GameWorld();
        trader = new Trader("Charlie", gameWorld.getRooms().get("bunkerHill"));
        Items potion = new Items("Potion", 5, 20); 
        trader.addItem("Potion", potion);
        Items vile = new Items("Vile", 5, 100);
        trader.addItem("Vile", vile);
        Items vile2 = new Items("Vile2", 5, 30);
        trader.addItem("Vile2", vile2);
        System.out.println("Type 'LOAD' to load " + name + " or 'NEW' to create new game or 'Quit' to quit");
       do
       {
          answer = scan.nextLine(); 
          if(!answer.equals("LOAD") && !answer.equals("NEW") && !answer.equals("Quit")){
              System.out.println("Wrong input");
        }else if(answer.equals("LOAD")){
            try{
                
            File file = new File("./saves/" + name + "Save.txt");
            FileReader read = new FileReader(file);
            List<String> lines = Files.readAllLines(file.toPath());
         
            player = new Player(String.valueOf(lines.get(0)), Double.valueOf(lines.get(1)), Float.valueOf(lines.get(2)), Float.valueOf(lines.get(3)), String.valueOf(lines.get(4)),lines.get(5), gameWorld.getRooms().get(lines.get(6)));
            
         
          
        }catch(IOException e){
            System.out.println("File not found");
            
            e.printStackTrace();
            System.exit(0);
        }
        }else if(answer.equals("NEW")){
             player = new Player(name, gameWorld.getRooms().get("bunkerHill"));
             loader = true;
        }else if(answer.equals("Quit")){
            System.out.println("Till next time....");
           System.exit(0);
        }else{
            System.out.println("an error has occured.");
            
        }
       }while(loader = false);
        
        
       
        parser = new Parser();
        play();
    }
    

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while(! finished) {
            Command command = parser.getCommand();
            
            if(command == null) {
                System.out.println("That command is not correct...");
            } else {
                
               
                if(command.getName().equals("go") || command.getName().equals("back")){
                    if(!command.getName().equals("back")){
                           trader.walk();
                      }else{
                        if(player.getRooms().size() != 0){
                        trader.walk();
                    }
                 }
                }
                finished = command.execute(player);
                 Win win = new Win();
                
                 orgWeapon death = new orgWeapon("DeathSword", 1000.0, 0);
                 // String words = "";
                 // Room room = new Room(words);
                 // room = gameWorld.getRooms().get("ultraLuxe");
                 // System.out.println(room);
                 //System.out.println(gameWorld.getRooms().get("utraLuxe"));
                 if(command.getName().equals("go") || command.getName().equals("back")){
                     if(player.getCurrentRoom().getName().equals("ultraLuxe")){
                     if(player.getCurrentRoom().hasEnemy()){
                          System.out.println("The Blood Beast must be defeated.");
                          
                        }else{
                              System.out.println(win.word);
                              player.addWeapon("Death", death);
                        }
                   
                }
            }
                 
                  
                 if(player.getCurrentRoom() == trader.getCurrentRoom()){
                     player.getCurrentRoom().setTrader(trader.getName(), trader);
                 }else if(player.getCurrentRoom().hasTrader()){
                        if(player.getCurrentRoom() != trader.getCurrentRoom())
                            player.getCurrentRoom().removeTrader(trader.getName());
                 }
                   
            }
            
        }
        System.out.println("Thank you for playing, survivor.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        //Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("Welcome to noka");
        System.out.println(" This is the apocalyptic game based in the reminants of a nuclear utopia");
        System.out.println("\nType 'help' if you need help.");
        System.out.println();
        
        System.out.println("Here is your current location");
        
        //put a way for the player to automcatically put their name inside of this

        System.out.println(player.getCurrentRoom().getLongDescription(player.getName()));
    }
}
