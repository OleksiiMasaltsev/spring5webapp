package ua.masaltsev.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.masaltsev.spring5webapp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
