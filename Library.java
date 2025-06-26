import java.util.*;

public class Library {
    private Map<String, Book> books;
    private Map<String, User> users;
    private Map<String, String> issuedBooks; // bookId -> userId

    public Library() {
        books = new HashMap<>();
        users = new HashMap<>();
        issuedBooks = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public boolean issueBook(String bookId, String userId) {
        Book book = books.get(bookId);
        User user = users.get(userId);
        if (book == null || user == null || book.isIssued()) {
            return false;
        }
        book.setIssued(true);
        issuedBooks.put(bookId, userId);
        return true;
    }

    public boolean returnBook(String bookId) {
        Book book = books.get(bookId);
        if (book == null || !book.isIssued()) {
            return false;
        }
        book.setIssued(false);
        issuedBooks.remove(bookId);
        return true;
    }

    public void listBooks() {
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    public void listUsers() {
        for (User user : users.values()) {
            System.out.println(user);
        }
    }
}
