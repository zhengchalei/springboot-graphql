package com.github.zhengchalei.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 作者
 *
 * @author 郑查磊
 * @date 2022/03/14
 */
@Data
@Document("author")
public class Author {

    @Id
    private String id;

    @Indexed(unique = true)
    private String name;

}
