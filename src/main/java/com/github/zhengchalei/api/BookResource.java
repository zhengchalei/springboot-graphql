package com.github.zhengchalei.api;

import com.github.zhengchalei.domain.Author;
import com.github.zhengchalei.domain.Book;
import com.github.zhengchalei.repository.AuthorRepository;
import com.github.zhengchalei.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 书资源
 *
 * @author 郑查磊
 * @date 2022/03/14
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class BookResource {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @SchemaMapping(typeName = "Query", field = "findBooks")
    public Flux<Book> findBooks() {
        return this.bookRepository.findAll();
    }

    @SchemaMapping(typeName = "Query", field = "findAuthorsById")
    public Mono<Author> findAuthorsById(@Argument String id) {
        return this.authorRepository.findById(id);
    }

    @SchemaMapping(typeName = "Author")
    public Flux<Book> books(Author author)  {
        return this.bookRepository.findBooksByAuthorId(author.getId());
    }

    @SchemaMapping(typeName = "Book")
    public Mono<Author> author(Book book)  {
        return this.authorRepository.findById(book.getAuthorId());
    }
}
