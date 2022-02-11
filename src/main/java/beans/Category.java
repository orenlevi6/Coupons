package beans;

public enum Category {
    FOOD,
    ELECTRICITY,
    RESTAURANT,
    VACATION;

    public final int VALUE = 1 + ordinal();

    @Override
    public String toString() {
        return "Category {" +
                "VALUE = " + Category.values()[VALUE - 1] +
                '}';
    }

}
