package beans;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<Coupon> Coupons;

    public Customer(int id, String firstName, String lastName, String email, String password) {
        this.id = id;
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
        setCoupons(new ArrayList<>());
    }

    public Customer(String firstName, String lastName, String email, String password) {
        this.id = 0;
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
        setCoupons(new ArrayList<>());
    }

    public Customer() {

    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Coupon> getCoupons() {
        return Coupons;
    }

    public void setCoupons(List<Coupon> Coupons) {
        this.Coupons = Coupons;
    }

    @Override
    public String toString() { // TODO: show password only to certified users.
        StringBuilder builder = new StringBuilder();

        builder.append("ID = ");
        builder.append(this.id);
        builder.append(", First Name = ");
        builder.append(this.firstName);
        builder.append(", Last Name = ");
        builder.append(this.lastName);
        builder.append(", Email = ");
        builder.append(this.email);
        builder.append(" password: ");
        builder.append(this.password);
        builder.append(", Coupons = ");
        builder.append(this.Coupons);

        return builder.toString();
    }

}
