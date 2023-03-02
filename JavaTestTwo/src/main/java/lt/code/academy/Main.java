package lt.code.academy;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lt.code.academy.client.MongoObjectClientProvider;
import lt.code.academy.data.BankAccount;
import lt.code.academy.data.User;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private final MongoCollection<User> userCollection;
    private User user;

    public Main(MongoCollection<User> userCollection) {
        this.userCollection = userCollection;
    }

    public static void main(String[] args) {
        MongoClient client = MongoObjectClientProvider.getClient();
        MongoDatabase database = client.getDatabase("lba");

        Main main = new Main(database.getCollection("users", User.class));

        Scanner sc = new Scanner(System.in);

        String action;
        do {
            main.menu();
            action = sc.nextLine();
            main.userSelection(sc, action);
        } while (!action.equals("3"));
    }
    private void userSelection(Scanner sc, String action) {
        switch (action) {
            case "1" -> createUsers(sc);
            case "2" -> System.out.println("Show Users");
            case "3" -> System.out.println("Program is finished");
            default -> System.out.println("There is no such choice");
        }
    }
    private void menu() {
        System.out.println("""
                1. User registartion
                2. Show Users
                3. Exit
                """);
    }
    private void createUsers(Scanner sc) {
        System.out.println("Enter your name");
        String name = sc.nextLine();
        System.out.println("Enter your surname");
        String surname = sc.nextLine();
        System.out.println("Enter your Bank name");
        String bankName = sc.nextLine();
        System.out.println("Enter your account");
        String account = sc.nextLine();
        System.out.println("Enter your account");
        double balance = Double.parseDouble(sc.nextLine());

        User user = new User(null, name, surname, Set.of(new BankAccount(bankName, account, balance)));

        userCollection.insertOne(user);


    }
}