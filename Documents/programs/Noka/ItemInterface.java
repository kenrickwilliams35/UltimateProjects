
/**
 * Write a description of interface ItemInteface here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface ItemInterface
{
    String getLongName();
    String getName();
    float getWeight();
    float getVolume();
    float getValue();
    float getBuyValue();
    void addDecorator(ItemInterface decorator);
    boolean isContainer();
    void addItem(ItemInterface item);
    void getBenefit(Player player);
}
