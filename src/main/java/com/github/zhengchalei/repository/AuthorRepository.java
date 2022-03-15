package com.github.zhengchalei.repository;

import com.github.zhengchalei.domain.Author;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * 作者库
 *
 * @author 郑查磊
 * @date 2022/03/14
 */
public interface AuthorRepository extends ReactiveMongoRepository<Author, String> {
}
