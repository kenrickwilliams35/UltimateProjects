
/**
 * Write a description of class ItemContainer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class ItemContainer
{
   
     private String name;
    private float weight;
    private float volume;
    private float value;
    private float sellValue;
    private float buyValue;
    private ItemInterface decorator;
    private HashMap<String, ItemInterface> contents;
    /**
     * Constructor for objects of class ItemContainer
     */
    public ItemContainer(String name, float weight, float value)
    {
        this.name = name;
        this.weight = weight;
        this.volume = volume;
        this.value = value;
        this.sellValue = sellValue;
        this.buyValue= buyValue;
        this.decorator = null;
        contents = new HashMap<String, ItemInterface>();
    }

    public String getName()
    {
        return name;
    }
    
    public String getLongName()
    {
        return getName() + (decorator == null?"":":"+decorator.getLongName());
    }

    public float getWeight()
    {
        return weight + (decorator == null?0:decorator.getWeight());
    }

    public float getVolume()
    {
        return volume + (decorator == null?0:decorator.getVolume());
    }

    public float geValue()
    {
        return value + (decorator == null?0:decorator.getValue());
    }

    public float getBuyValue()
    {
        return buyValue + (decorator == null?0:decorator.getBuyValue());
    }

    public void addDecorator(ItemInterface decorator)
    {
        if(this.decorator == null)
        {
            this.decorator = decorator;
        }
        else
        {
            this.decorator.addDecorator(decorator);
        }
    }
    
    public boolean isContainer()
    {
        return true;
    }
    
    public void addItem(ItemInterface item)
    {
        contents.put(item.getName(), item);
    }
    
    public ItemInterface removeItem(String itemName)
    {
        return contents.remove(itemName);
    }
    
    public String[] getList()
    {
        return (String[])contents.keySet().toArray();
    }

    public String toSting()
    {
        return name +", weight: " + getWeight() + ", volume: " + getVolume();
    }
    
}


