import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LibraryManager manager = new LibraryManager();

        int choice = 0;

        while (choice != 10) {

            System.out.println("\n======================================");
            System.out.println("       LIBRARY MANAGEMENT SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Add Member");
            System.out.println("7. Display Members");
            System.out.println("8. Issue Book");
            System.out.println("9. Return Book");
            System.out.println("10. Exit");
            System.out.println("======================================");

            // ================= MENU INPUT =================

            while (true) {

                try {

                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();

                    if (choice >= 1 && choice <= 10) {
                        break;
                    }

                    System.out.println(
                            "Please enter a number between 1 and 10.");

                } catch (Exception e) {

                    System.out.println(
                            "Invalid input! Please enter a number.");

                    scanner.next();
                }
            }

            // ================= SWITCH =================

            switch (choice) {

                // ================= ADD BOOK =================

                case 1:

                    int bookId;

                    while (true) {

                        try {

                            System.out.print("Enter Book ID: ");
                            bookId = scanner.nextInt();

                            if (bookId <= 0) {

                                System.out.println(
                                        "Book ID must be greater than 0!");

                            } else if (manager.searchBook(bookId) != null) {

                                System.out.println(
                                        "Book ID already exists!");

                            } else {

                                break;
                            }

                        } catch (Exception e) {

                            System.out.println(
                                    "Invalid Book ID! Please enter a number.");

                            scanner.next();
                        }
                    }

                    System.out.print("Enter Book Title: ");
                    String title = scanner.next();

                    System.out.print("Enter Author Name: ");
                    String author = scanner.next();

                    Book book = new Book(bookId, title, author);

                    manager.addBook(book);

                    break;

                // ================= DISPLAY BOOKS =================

                case 2:

                    manager.displayBooks();

                    break;

                // ================= SEARCH BOOK =================

                case 3:

                    while (true) {

                        try {

                            System.out.print(
                                    "Enter Book ID to search: ");

                            int searchId = scanner.nextInt();

                            Book foundBook =
                                    manager.searchBook(searchId);

                            if (foundBook != null) {

                                foundBook.displayBook();

                            } else {

                                System.out.println(
                                        "Book not found!");
                            }

                            break;

                        } catch (Exception e) {

                            System.out.println(
                                    "Invalid Book ID! Please enter a number.");

                            scanner.next();
                        }
                    }

                    break;

                // ================= UPDATE BOOK =================

                case 4:

                    while (true) {

                        try {

                            System.out.print(
                                    "Enter Book ID to update: ");

                            int updateId = scanner.nextInt();

                            Book bookToUpdate =
                                    manager.searchBook(updateId);

                            if (bookToUpdate == null) {

                                System.out.println(
                                        "Book not found!");

                            } else {

                                System.out.print(
                                        "Enter new title: ");

                                String newTitle =
                                        scanner.next();

                                System.out.print(
                                        "Enter new author: ");

                                String newAuthor =
                                        scanner.next();

                                manager.updateBook(
                                        updateId,
                                        newTitle,
                                        newAuthor
                                );
                            }

                            break;

                        } catch (Exception e) {

                            System.out.println(
                                    "Invalid Book ID! Please enter a number.");

                            scanner.next();
                        }
                    }

                    break;

                // ================= DELETE BOOK =================

                case 5:

                    while (true) {

                        try {

                            System.out.print(
                                    "Enter Book ID to delete: ");

                            int deleteId = scanner.nextInt();

                            manager.deleteBook(deleteId);

                            break;

                        } catch (Exception e) {

                            System.out.println(
                                    "Invalid Book ID! Please enter a number.");

                            scanner.next();
                        }
                    }

                    break;

                // ================= ADD MEMBER =================

                case 6:

                    int memberId;

                    while (true) {

                        try {

                            System.out.print(
                                    "Enter Member ID: ");

                            memberId = scanner.nextInt();

                            if (memberId <= 0) {

                                System.out.println(
                                        "Member ID must be greater than 0!");

                            } else if (manager.searchMember(memberId) != null) {

                                System.out.println(
                                        "Member ID already exists!");

                            } else {

                                break;
                            }

                        } catch (Exception e) {

                            System.out.println(
                                    "Invalid Member ID! Please enter a number.");

                            scanner.next();
                        }
                    }

                    System.out.print("Enter Member Name: ");
                    String memberName = scanner.next();

                    Member member =
                            new Member(memberId, memberName);

                    manager.addMember(member);

                    break;

                // ================= DISPLAY MEMBERS =================

                case 7:

                    manager.displayMembers();

                    break;

                // ================= ISSUE BOOK =================

                case 8:

                    int issueBookId;

                    while (true) {

                        try {

                            System.out.print(
                                    "Enter Book ID to issue: ");

                            issueBookId = scanner.nextInt();

                            break;

                        } catch (Exception e) {

                            System.out.println(
                                    "Invalid Book ID! Please enter a number.");

                            scanner.next();
                        }
                    }

                    int issueMemberId;

                    while (true) {

                        try {

                            System.out.print(
                                    "Enter Member ID: ");

                            issueMemberId = scanner.nextInt();

                            break;

                        } catch (Exception e) {

                            System.out.println(
                                    "Invalid Member ID! Please enter a number.");

                            scanner.next();
                        }
                    }

                    manager.issueBook(
                            issueBookId,
                            issueMemberId
                    );

                    break;

                // ================= RETURN BOOK =================

                case 9:

                    while (true) {

                        try {

                            System.out.print(
                                    "Enter Book ID to return: ");

                            int returnBookId = scanner.nextInt();

                            manager.returnBook(returnBookId);

                            break;

                        } catch (Exception e) {

                            System.out.println(
                                    "Invalid Book ID! Please enter a number.");

                            scanner.next();
                        }
                    }

                    break;

                // ================= EXIT =================

                case 10:

                    System.out.println(
                            "Thank you for using Library Management System!");

                    break;
            }
        }

        scanner.close();
    }
}