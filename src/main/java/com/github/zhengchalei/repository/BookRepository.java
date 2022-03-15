package com.github.zhengchalei.repository;

import com.github.zhengchalei.domain.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

/**
 * 书籍库
 *
 * @author 郑查磊
 * @date 2022/03/14
 */
public interface BookRepository extends ReactiveMongoRepository<Book, String> {

    /**
     * 查找图书作者id
     *
     * @param authorId 作者id
     * @return {@link Flux}<{@link Book}>
     */
    Flux<Book> findBooksByAuthorId(String authorId);

}
