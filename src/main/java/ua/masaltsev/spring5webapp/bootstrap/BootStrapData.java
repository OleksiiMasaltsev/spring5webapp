package ua.masaltsev.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ua.masaltsev.spring5webapp.domain.Author;
import ua.masaltsev.spring5webapp.domain.Book;
import ua.masaltsev.spring5webapp.repositories.AuthorRepository;
import ua.masaltsev.spring5webapp.repositories.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author taras = new Author("Taras", "Shevchenko");
        Book book1 = new Book("Kobzar", "12254");
        taras.getBooks().add(book1);
        book1.getAuthors().add(taras);

        authorRepository.save(taras);
        bookRepository.save(book1);

        Author franko = new Author("Ivan", "Franko");
        Book book2 = new Book("Leafs", "4578");
        franko.getBooks().add(book2);
        book2.getAuthors().add(franko);

        authorRepository.save(franko);
        bookRepository.save(book2);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books " + bookRepository.count());
    }
}
