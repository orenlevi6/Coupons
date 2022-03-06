package exceptions;

public class TableNotCreatedException extends Exception {
    public TableNotCreatedException() {
        super("Failed to create");
    }

    public TableNotCreatedException(String message) {
        super(message);
    }

    public TableNotCreatedException(SQLTables table, Action action) {
        super("Failed to " + action.name() + " " + table.getMESSAGE());
    }

}
