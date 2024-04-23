package DesignPatterns.Singleton;

public enum DatabaseConnection {

    INSTANCE;

    private DatabaseConnection() {
        System.out.println("Creating database connection...");

    }
}
class Program {
    public static void main(String[] args) {

        DatabaseConnection dbConnection1 = DatabaseConnection.INSTANCE;

        DatabaseConnection dbConnection2 = DatabaseConnection.INSTANCE;
    }
}
