package info.dmerej;

public class User {

    private String name;
    private String email;
    private int age;
    private boolean verified;
    private Address address;

    public User(String name, String email, Address address) {
        this.name = name;
        this.email = email;
        this.age = 10;
        this.verified = false;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public boolean isVerified() {
        return verified;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address addres) {
        this.address = addres;
    }

    public void makeVerified() {
        this.verified = true;
    }

    public void makeMajor() {
        this.age = 18;
    }
}
