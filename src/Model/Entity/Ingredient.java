package Model.Entity;

public class Ingredient {
    private final String name;
    private int amount;

    public Ingredient(String name) {
        this.name = name;
        this.amount = 1;
    }

    public String getName() {
        return name;
    }

    public int getAmount(){
        return amount;
    }

    public void increaseAmount(){
        if(amount < 10) amount++;
    }

    public void decreaseAmount(){
         if (amount > 0) amount--;
    }

}
