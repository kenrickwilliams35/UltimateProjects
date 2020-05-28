
/**
 * Write a description of class Trader here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;
public class Trader
{
    private Room startingRoom;
    private HashMap<String, Items> tradeItems;
    private organism trader;
    private Room currentRoom;
    private HashMap<String, Room> exits;
    private HashMap<Integer, String> exitsNumber;
    private ArrayList<String> directions;
    private String name;
    
    public Trader(String name, Room startingRoom){
        this.name = name;
        currentRoom = startingRoom;
        tradeItems = new HashMap<String, Items>();
        directions = new ArrayList<String>();
       
      
    }
    public void getTrade(Player player){
        String reply = "";
        
        
        System.out.println("Hello, my name is " + name + " and I am a Trader.");
        System.out.println(player.getName() + "'s currency is " + player.getCurrency());
        for(String key : tradeItems.keySet()){
            System.out.println("I have: " + key + " Price: " + tradeItems.get(key).getValue());
        }
        while(!reply.equals("Leave")){
        Scanner scan = new Scanner(System.in);
      
        System.out.println(player.getName() + "'s currency is " + player.getCurrency());
        System.out.println("What would you like to buy?(Sell to sell goods)(Leave to exit)");
        reply = scan.next();
        //for(String key : tradeItems.keySet()){
            if(tradeItems.containsKey(reply)){
                if(player.getCurrency() >= tradeItems.get(reply).getValue()){
                    if(!player.getItems().containsKey(reply)){
                    if(((player.getWeight() - tradeItems.get(reply).getWeight()) >= 0)){
                        System.out.println("You have purchased " + reply);
                        float currency = player.getCurrency() - tradeItems.get(reply).getValue();
                        player.setCurrency(currency);
                        // for(String keyy : player.getItems().keySet())
                        // {
                            // if(key.equals(keyy)){
                                // int match = player.getItems().get(keyy).getQuantity() + 1;
                                // player.getItems().get(keyy).setQuantity(match);
                            // }
                        // }
                        //player.getItems().get(key).setOrginal(player.getItems().get(key).getQuantity());
                        player.addItem(reply, tradeItems.get(reply));
                    }else{
                        System.out.println("Im sorry, you dont have enough space for that item");
                    }
                }else{
                    System.out.println("Im sorry, you already contain this item.");
                }
                }else{
                    System.out.println("You do not have enough currency for this item.");
                }
            }else if(reply.equals("Leave")){
                System.out.println("Till next time friend.");
            }else if(reply.equals("Sell")){
                System.out.println("which item would you like to sell?");
                String item = "";
                Scanner sin = new Scanner(System.in);
                item = sin.next();
                if(player.getItems().containsKey(item)){
                    tradeItems.put(item, player.getItems().get(item));
                    float currency = player.getCurrency() + player.getItems().get(item).getValue();
                    player.setCurrency(currency);
                    player.getItems().remove(item);
                    System.out.println("Thank you for the " + item);
                    
                }else{
                    System.out.println("You do not contain that item.");
                }
                
                
            }else{
                System.out.println("Thats not the right option.");
            }
        }
        }
        
    
    public void addItem(String name, Items item)
    {
        tradeItems.put(name, item);
    }
    public String getName()
    {
        return name;
    }
    public Room getCurrentRoom()
    {
        return currentRoom;
    }
    public void setCurrentRoom(Room room)
    {
        currentRoom = room;
    }
    public void setMove(String direction){
        directions.add(direction);
    }

    public void walk(){
        exits = new HashMap<String, Room>();
        exitsNumber = new HashMap<Integer, String>();
        String direction = "";
        Random rand = new Random();
        int counter = 1;
        for(String key : currentRoom.getExits().keySet()){
            exitsNumber.put(counter, key);
            counter ++;
           
        }
        
       
        // int x = rand.nextInt(currentRoom.getExits().size());
        // for(String key : currentRoom.getExits().keySet()){
            
            // exits.put(key, currentRoom.getExit(key));
            // boolean truth = exitsNumber.containsKey(x);
            // if(truth){
                // while(truth){
                    
                    // x = rand.nextInt(currentRoom.getExits().size());
                   
                    // if(!exitsNumber.containsKey(x)){
                        // exitsNumber.put(x, existNumber.get(key));
                        // truth = false;
                    // }
                // }
                // }else{
                    // exitsNumber.put(x, key);
                // }
            // }
        
        // if(x = 1){
        // }else if(x == 2){
        // }else if(x == 3){
        // }else{
        // }
        // Try to leave current room. 
        int y = rand.nextInt(exitsNumber.size()) + 1;
        
        Room nextRoom = currentRoom.getExit(exitsNumber.get(y));
        
        if (nextRoom == null)
            System.out.println("oops, dont think im going that way...");
        else if(nextRoom.lockCheck() == true) {
            System.out.println("This room is locked.");
        }else{
            setCurrentRoom(nextRoom);
            currentRoom = nextRoom;
            if(name.equals("Charlie")){
                Trader trader = new Trader(name, currentRoom);
                currentRoom.setTrader(name, trader);
            }
            //Notification notification = new Notification("PlayedEnteredRoom", this);
            //NotifcationCenter.getInstance().postNotifcation(notification);
            System.out.println("===== * Trader * =====");
            System.out.println(nextRoom.getLongDescription("Trader"));
            System.out.println("===== * ====== * =====");
        }
    }
}
