package lt.code.academy.data;

import org.bson.types.ObjectId;

import java.util.Set;

public class User {
    private ObjectId id;
    private String name;
    private String surname;
    private Set<BankAccount> accounts;
    public User() {}
    public User(ObjectId id, String name, String surname, Set<BankAccount> accounts) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.accounts = accounts;
    }
    public ObjectId getId() {
        return id;
    }
    public void setId(ObjectId id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public Set<BankAccount> getAccounts() {
        return accounts;
    }
    public void setAccounts(Set<BankAccount> accounts) {
        this.accounts = accounts;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
