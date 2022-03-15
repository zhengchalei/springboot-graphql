package com.github.zhengchalei.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 书
 *
 * @author 郑查磊
 * @date 2022/03/14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("book")
public class Book {

    @Id
    private String id;

    private String name;

    @Indexed
    private String authorId;

}
