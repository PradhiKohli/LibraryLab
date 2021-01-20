import java.util.*;

public class Library {
        // Add the missing implementation to this class
      // String LibraryHours = "9-5 daily";
    String libraryAddress;
    //Array for Bookstore
    ArrayList<Book> books;

    //Method to address and bookstore
    public Library(String address)
    {
        libraryAddress = address;
        books = new ArrayList<Book>();
    }

    //Method to address and books
    public void addBook(Book book)
    {
        books.add(book);
    }

    //method for library hours
  public static void printOpeningHours(){
      System.out.println("Libraries are open daily from 9am to 5pm.");
  }

    //Method to print Address

    public void printAddress()
    {
        System.out.println(libraryAddress);
    }

    public void printAvailableBooks(){
        Book libraryBook;
        boolean libraryIsEmpty = true;

        for(int i = 0; i<books.size(); i++){
            libraryBook = books.get(i);

            if(!(libraryBook.isBorrowed())) {
                System.out.println(libraryBook.getTitle());

                libraryIsEmpty = false;
            }
        }

        if(libraryIsEmpty){
            System.out.println("No book in catalog");
        }
}

    // method for borrowing a book
    public String borrowBook(String bookTitle){
        Book libraryBook;
        String libraryBookTitle;

        for(int i=0; i< books.size(); i++ ){
            libraryBook = books.get(i);
            libraryBookTitle = libraryBook.getTitle();


            if(libraryBookTitle.equals(bookTitle)){
                if(!libraryBook.isBorrowed());
                {
                    libraryBook.borrowed();
                    System.out.println("You successfully borrowed " + libraryBookTitle);
                    return null;
                }
            }

        }
        System.out.println("Sorry, this book is not in our catalog.");
        return null;
    }

// method to return books
    public void returnBook(String bookTitle){
        Book libraryBook;
        boolean found = false;
        String libraryBookTitle;

        for(int i=0; i<books.size(); i++ ){
            libraryBook = books.get(i);
            libraryBookTitle = libraryBook.getTitle();


            if(libraryBookTitle.equals(bookTitle)) {
                if (libraryBook.isBorrowed()) {
                    libraryBook.returned();
                    System.out.println("You successfully returned " + libraryBookTitle);
                    found = true;
                    break;
                }
            }
            
    } if(!found){
        System.out.println("Sorry, this book is not in our catalog.");
    }
}

        public static void main(String[] args) {
            // Create two libraries
            Library firstLibrary = new Library("10 Main St.");
            Library secondLibrary = new Library("228 Liberty St.");

            // Add four books to the first library
            firstLibrary.addBook(new Book("The Da Vinci Code"));
            firstLibrary.addBook(new Book("Le Petit Prince"));
            firstLibrary.addBook(new Book("A Tale of Two Cities"));
            firstLibrary.addBook(new Book("The Lord of the Rings"));

            // Print opening hours and the addresses
            System.out.println("Library hours:");
            printOpeningHours();
            System.out.println();

            System.out.println("Library addresses:");
            firstLibrary.printAddress();
            secondLibrary.printAddress();
            System.out.println();

            // Try to borrow The Lords of the Rings from both libraries
            System.out.println("Borrowing The Lord of the Rings:");
            firstLibrary.borrowBook("The Lord of the Rings");
            firstLibrary.borrowBook("The Lord of the Rings");
            secondLibrary.borrowBook("The Lord of the Rings");
            System.out.println();

            // Print the titles of all available books from both libraries
            System.out.println("Books available in the first library:");

            firstLibrary.printAvailableBooks();
            System.out.println();
            System.out.println("Books available in the second library:");
            secondLibrary.printAvailableBooks();
            System.out.println();

            // Return The Lords of the Rings to the first library
            System.out.println("Returning The Lord of the Rings:");
            firstLibrary.returnBook("The Lord of the Rings");
            System.out.println();

            // Print the titles of available from the first library
            System.out.println("Books available in the first library:");
            firstLibrary.printAvailableBooks();



        }
    }

