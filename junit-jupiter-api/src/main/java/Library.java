
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

   
    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void updateBook(int id, Book updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.set(i, updatedBook);
                break;
            }
        }
    }

    
}
