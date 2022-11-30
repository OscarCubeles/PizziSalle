package Model.Entity;

public class Ingredient {
    private String name;
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
        amount++;
    }

    public void decreaseAmount(){
        amount--;
    }

}
