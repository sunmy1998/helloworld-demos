package com.swy.domain;


import lombok.Data;
import lombok.experimental.Accessors;
import org.dromara.easyes.annotation.IndexName;

/**
 * @author: SMY
 * @time: 2025/5/21  22:31
 * @description: Document文档表
 */
@Data
@Accessors(chain = true)
@IndexName
public class Document {
    /**
     * es中的唯一id
     */
    private String id;
    /**
     * 文档标题
     */
    private String title;
    /**
     * 文档内容
     */
    private String content;
}
