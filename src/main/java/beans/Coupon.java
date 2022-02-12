package beans;

import java.sql.Date;

public class Coupon {
    private int id;
    private int companyID;
    private Category category;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private int amount;
    private double price;
    private String image;
    private int categoryIndex;

    public Coupon(int id, int companyID, int categoryIndex, String title,
                  String description, Date startDate, Date endDate, int amount, double price, String image) {
        this.id = id;
        this.companyID = companyID;
        this.category = Category.values()[categoryIndex];
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
        this.price = price;
        this.image = image;
    }

    public Coupon() {

    }

    public int getId() {
        return id;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyId) {// CHECK IF needed
        this.companyID = companyId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        for (Category item : Category.values()) {
            if (item.VALUE == category.VALUE) {
                this.category = category;
                return;
            }
        }
        this.category = category;
    }

    public int getCategoryIndex() {
        return categoryIndex;
    }

    public void setCategoryIndex(int categoryIndex) {
        this.categoryIndex = categoryIndex;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if (amount < 0) {
            this.amount = 0;
            return;
        }
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            this.price = 0;
            return;
        }
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Coupon {" +
                "ID = " + id +
                ", Company ID = " + companyID +
                ", Category = " + category +
                ", Title = '" + title + '\'' +
                ", Description = '" + description + '\'' +
                ", Start Date = " + startDate +
                ", End Date = " + endDate +
                ", Amount = " + amount +
                ", Price = " + price +
                ", Image = '" + image + '\'' +
                '}';
    }

}
