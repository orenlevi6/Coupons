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

    public Customer() {
    }

    public Customer(int id, String firstName, String lastName, String email, String password) {
        this.id = id;
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        this.password = password;
        setCoupons(new ArrayList<>());
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

    public List<Coupon> getCoupons() {
        return Coupons;
    }

    public void setCoupons(List<Coupon> Coupons) {
        this.Coupons = Coupons;
    }

    @Override
    public String toString() {
        // TODO: 12/02/2022 show password only to certified users.
        return "Customer {" +
                "ID =" + id +
                ", First Name = '" + firstName + '\'' +
                ", Last Name = '" + lastName + '\'' +
                ", Email = '" + email + '\'' +
                ", Password = '" + password + '\'' +
                ", Coupons = " + Coupons +
                '}';
    }

}
