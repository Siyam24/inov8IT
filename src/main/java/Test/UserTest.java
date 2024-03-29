package Test;

import Models.User;
public class UserTest {

    public static void main(String[] args) {
        // Known username and password for testing
        String username = "hi";
        String password = "hi";

        // Create a User object with the known credentials
        User user = new User(username, password);

        // Attempt to log in with the known credentials
        boolean loggedIn = user.login();

        // Check if login was successful and print the result
        if (loggedIn) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}

