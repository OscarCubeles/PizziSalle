package Model.Entity;

public class Customer {
    private String name;
    private String phoneNumber;
    private String deliveryAddress;
    private boolean isFirstOrder;
    private int delegationID;
    private int age;

    public Customer() {
        this.isFirstOrder = false;
        this.delegationID = -1;
        this.deliveryAddress = "undefined";
        this.phoneNumber = "undefined";
        this.age = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setIsFirstOrder(boolean isFirstOrder) {
        this.isFirstOrder = isFirstOrder;
    }

    public void setDelegationID(int delegationID) {
        this.delegationID = delegationID;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public boolean isFirstOrder() {
        return isFirstOrder;
    }

    public int getDelegationID() {
        return delegationID;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge(){
        return age;
    }
}
