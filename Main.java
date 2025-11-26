package SimpleJavaUserRegistration;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static final int MINIMUM_LENGTH = 8;
    public static final int MAXIMUM_LENGTH = 15;

    static void main() {
        Scanner sc = new Scanner(System.in);
        ValidPassword valid = new ValidPassword();
        Person login = new Person();

        System.out.println("Create a new username: ");
        login.username = sc.nextLine();

        while (login.username.length() < MINIMUM_LENGTH) {
            System.out.println("Your username should be 8 characters long!");
            System.out.println("Write again your new username: ");
            login.username = sc.nextLine();
        }

        System.out.println("Create a new password: ");
        login.password = sc.nextLine();

        valid.isPasswordInvalid = login.password == null || login.password.trim().isEmpty() || login.password.length() < MINIMUM_LENGTH || login.password.length() >= MAXIMUM_LENGTH;
        valid.isPasswordEqualsUsername = Objects.equals(login.username, login.password);

        while (valid.isPasswordEqualsUsername || valid.isPasswordInvalid) {
            if (valid.isPasswordInvalid) {
                System.out.println("Your password should be 8 characters long!");
            }

            if (valid.isPasswordEqualsUsername) {
                System.out.println("Your password shouldn't be your username!");
            }

            System.out.println("Write again your new password: ");
            login.password = sc.nextLine();

            valid.isPasswordInvalid = login.password == null || login.password.trim().isEmpty() || login.password.length() < MINIMUM_LENGTH || login.password.length() >= MAXIMUM_LENGTH;
            valid.isPasswordEqualsUsername = Objects.equals(login.username, login.password);
        }

        System.out.println("Write your password again to check");
        login.checkPassword = sc.nextLine();

        valid.ifPasswordsDoNotMatch = Objects.equals(login.password, login.checkPassword);

        while (!valid.ifPasswordsDoNotMatch) {
            System.out.println("Your password didn't match!");
            System.out.println("Write your password again to check");
            login.password = sc.nextLine();

            valid.ifPasswordsDoNotMatch = Objects.equals(login.password, login.checkPassword);
        }

        System.out.println("username: " + login.username + ", password: " + login.password);
        sc.close();
        System.exit(0);
    }
}