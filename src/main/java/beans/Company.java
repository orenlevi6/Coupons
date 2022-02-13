package beans;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private int id;
    private String name;
    private String email;
    private String password;
    private List<Coupon> Coupons;

    public Company(int id, String name, String email, String password) {
        this.id = id;
        setName(name);
        setEmail(email);
        setPassword(password);
        setCoupons(new ArrayList<>());
    }

    public Company() {
    }

    public int getId() {
        return id;
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
        return Coupons;
    }

    public void setCoupons(List<Coupon> Coupons) {
        this.Coupons = Coupons;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("ID = ");
        builder.append(this.id);
        builder.append(", Name = ");
        builder.append(this.name);
        builder.append(", Email = ");
        builder.append(this.email);
        // builder.append(" password: ");
        // builder.append(this.password);
        builder.append(", Coupons = ");
        builder.append(this.Coupons);

        return builder.toString();
    }

}
