import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. List Books");
            System.out.println("6. List Users");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(bookId, title, author));
                    System.out.println("Book added.");
                    break;
                case 2:
                    System.out.print("Enter User ID: ");
                    String userId = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    library.addUser(new User(userId, name));
                    System.out.println("User added.");
                    break;
                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    bookId = scanner.nextLine();
                    System.out.print("Enter User ID: ");
                    userId = scanner.nextLine();
                    if (library.issueBook(bookId, userId)) {
                        System.out.println("Book issued.");
                    } else {
                        System.out.println("Issue failed. Check IDs or book status.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Book ID to return: ");
                    bookId = scanner.nextLine();
                    if (library.returnBook(bookId)) {
                        System.out.println("Book returned.");
                    } else {
                        System.out.println("Return failed. Check Book ID or status.");
                    }
                    break;
                case 5:
                    library.listBooks();
                    break;
                case 6:
                    library.listUsers();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
