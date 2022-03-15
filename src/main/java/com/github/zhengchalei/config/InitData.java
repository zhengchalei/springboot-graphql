package com.github.zhengchalei.config;

import com.github.zhengchalei.domain.Author;
import com.github.zhengchalei.domain.Book;
import com.github.zhengchalei.repository.AuthorRepository;
import com.github.zhengchalei.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * 初始化数据
 *
 * @author 郑查磊
 * @date 2022/03/15
 */
@Slf4j
@Service
public class InitData {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public InitData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        init();
    }

    public void init() {
        create("曹雪芹", "红楼梦", "题敦诚琵琶行传奇");
        create("吴承恩", "西游记");
    }

    private void create(String authorName, String... books) {
        Author author = new Author();
        author.setName(authorName);
        this.authorRepository.save(author)
                .thenMany(
                        Flux
                                .just(books)
                                .map(name -> {
                                    Book book = new Book();
                                    book.setName(name);
                                    book.setAuthorId(author.getId());
                                    return book;
                                })
                                .flatMap(bookRepository::save)
                )
                .subscribe();
    }
}