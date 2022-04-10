package SKU;

public class Customer {
    private int customerId;
    private String firstName;
    private String secondName;
    private Address address;
    private String telephoneNumber;
    public Customer(int customerId, String firstName, String secondName, Address address, String telephoneNumber) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
    }
    public Customer() {
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getSecondName() {
        return secondName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public String getTelephoneNumber() {
        return telephoneNumber;
    }
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
    @Override
    public String toString() {
        return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", secondName=" + secondName
                + ", address=" + address + ", telephoneNumber=" + telephoneNumber + "]";
    }

}
