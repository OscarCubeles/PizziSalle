package Model.Entity;

public class Customer {
    private String name;
    private String phoneNumber;
    private String deliveryAddress;
    private boolean isFirstOrder;
    private int delegationID;

    public Customer() {
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
}
