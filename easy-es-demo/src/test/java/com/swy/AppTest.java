package com.swy;


import com.swy.domain.Document;
import com.swy.mapper.DocumentMapper;
import org.dromara.easyes.core.conditions.index.LambdaEsIndexWrapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: SMY
 * @time: 2025/5/21  23:04
 * @description: 测试
 */
@SpringBootTest
public class AppTest {

    @Autowired
    private DocumentMapper documentMapper;

    @Test
    public void testCreateIndex() {
        boolean success = documentMapper.createIndex();
        Assertions.assertTrue(success);
    }

    @Test
    public void testDeleteIndex() {
        boolean success = documentMapper.deleteIndex();
        Assertions.assertTrue(success);
    }

    @Test
    public void testInsert() {
        // 测试插入数据
        Document document = new Document()
                .setTitle("老汉")
                .setContent("推*技术过硬");

        int successCount = documentMapper.insert(document);
        System.out.println(successCount);
    }


}
