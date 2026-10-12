import java.util.ArrayList;

public class LibraryManager {

    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public LibraryManager() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    // ================= ADD BOOK =================

    public void addBook(Book book) {

        books.add(book);

        System.out.println("Book added successfully!");
    }

    // ================= DISPLAY BOOKS =================

    public void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available!");
            return;
        }

        for (Book book : books) {
            book.displayBook();
        }
    }

    // ================= SEARCH BOOK =================

    public Book searchBook(int bookId) {

        for (Book book : books) {

            if (book.getBookId() == bookId) {
                return book;
            }
        }

        return null;
    }

    // ================= UPDATE BOOK =================

    public void updateBook(int bookId, String newTitle, String newAuthor) {

        Book book = searchBook(bookId);

        if (book != null) {

            book.setTitle(newTitle);
            book.setAuthor(newAuthor);

            System.out.println("Book updated successfully!");

        } else {

            System.out.println("Book not found!");
        }
    }

    // ================= DELETE BOOK =================

    public void deleteBook(int bookId) {

        Book book = searchBook(bookId);

        if (book == null) {

            System.out.println("Book not found!");

        } else if (!book.isAvailable()) {

            System.out.println(
                    "Book cannot be deleted because it is currently issued!");

        } else {

            books.remove(book);

            System.out.println("Book deleted successfully!");
        }
    }

    // ================= ADD MEMBER =================

    public void addMember(Member member) {

        members.add(member);

        System.out.println("Member added successfully!");
    }

    // ================= DISPLAY MEMBERS =================

    public void displayMembers() {

        if (members.isEmpty()) {

            System.out.println("No members available!");
            return;
        }

        for (Member member : members) {
            member.displayMember();
        }
    }

    // ================= SEARCH MEMBER =================

    public Member searchMember(int memberId) {

        for (Member member : members) {

            if (member.getMemberId() == memberId) {
                return member;
            }
        }

        return null;
    }

    // ================= ISSUE BOOK =================

    public void issueBook(int bookId, int memberId) {

        Book book = searchBook(bookId);
        Member member = searchMember(memberId);

        if (book == null) {

            System.out.println("Book not found!");
            return;
        }

        if (member == null) {

            System.out.println("Member not found!");
            return;
        }

        if (!book.isAvailable()) {

            System.out.println("Book is already issued!");
            return;
        }

        book.setAvailable(false);

        System.out.println("Book issued successfully!");
        System.out.println("Book: " + book.getTitle());
        System.out.println("Issued to: " + member.getName());
    }

    // ================= RETURN BOOK =================

    public void returnBook(int bookId) {

        Book book = searchBook(bookId);

        if (book == null) {

            System.out.println("Book not found!");
            return;
        }

        if (book.isAvailable()) {

            System.out.println("This book is already available!");

        } else {

            book.setAvailable(true);

            System.out.println("Book returned successfully!");
        }
    }
}