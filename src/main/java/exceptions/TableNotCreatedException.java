package exceptions;

public class TableNotCreatedException extends Exception {
    public TableNotCreatedException() {
        super("Failed to create");
    }

    public TableNotCreatedException(String message) {
        super(message);
    }

    public TableNotCreatedException(SQLTables table) {
        super("Failed to create " + table.getMESSAGE());
    }

}
