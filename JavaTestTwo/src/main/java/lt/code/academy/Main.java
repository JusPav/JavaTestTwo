package lt.code.academy;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lt.code.academy.client.MongoObjectClientProvider;
import lt.code.academy.data.BankAccount;
import lt.code.academy.data.User;

import java.util.Scanner;
import java.util.Set;

public class Main {

    private final MongoCollection<User> userCollection;

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
        } while (!action.equals("5"));
    }
    private void userSelection(Scanner sc, String action) {
        switch (action) {
            case "1" -> createUsers(sc);
            case "2" -> showUsers();
            case "4" -> System.out.println("Transfer money");
            case "5" -> System.out.println("Program is finished");
            default -> System.out.println("There is no such choice");
        }
    }
    private void menu() {
        System.out.println("""
                1. User registartion
                2. Show Users
                3. Transfer money
                4. Exit
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
        System.out.println("Enter your balance");
        double balance = Double.parseDouble(sc.nextLine());

        User user = new User(null, name, surname, Set.of(new BankAccount(bankName, account, balance)));

        userCollection.insertOne(user);
    }
    private void showUsers() {
        FindIterable<User> users = userCollection.find();
        for (User user : users) {
            System.out.println(user);
        }
    }
    private void transferMoney() {

    }
}