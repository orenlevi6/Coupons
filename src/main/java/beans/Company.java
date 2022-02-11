package beans;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private final int ID;
    private String name;
    private String email;
    private String password;
    private List<Coupon> coupons;

    public Company(int ID, String name, String email, String password) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.coupons = new ArrayList<>();
    }

    public int getID() {
        return ID;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }

    @Override
    public String toString() {
        return "Company{" +
                "ID = " + ID +
                ", Name = '" + name + '\'' +
                ", Email = '" + email + '\'' +
                ", Password = '" + password + '\'' +
                ", Coupons = " + coupons +
                '}';
    }

}
