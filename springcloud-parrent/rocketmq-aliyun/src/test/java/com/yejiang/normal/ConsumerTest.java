package com.yejiang.normal;

import com.yejiang.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class ConsumerTest {

    @Test
    public void testConsumer(){
        //方便测试，运行这个方法时启动
       new ImportSelector(){
           @Override
           public String[] selectImports(AnnotationMetadata annotationMetadata) {
                return new String[]{"com.yejiang.normal.ConsumerClient"};
           }
       };
    }

}
