package com.yejiang.kafka.hellokafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Description: 
 * date: 2022/1/26 17:08
 * @author YeJiang
 * @version
 */
public class HelloKafkaConsumer {


    public static void main(String[] args) {

        //生产配置对象
        Properties config = new Properties();
        config.put("bootstrap.servers", "127.0.0.1:9092");
        config.put("key.deserializer", StringDeserializer.class);
        config.put("value.deserializer", StringDeserializer.class);
        //设置消费者群组
        config.put("group.id", "test1");

        //创建kafka生产者
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(config);

        try {
            List<String> topics = new ArrayList<>();
            topics.add("my-topic");
            consumer.subscribe(topics);
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(500));
                for (ConsumerRecord record : records) {
                    System.out.println(String.format("topic:%s，分区:%d，偏移量:%d， key:%s,value:%s",
                            record.topic(), record.partition(), record.offset(), record.key(), record.value()));
                    //do other work
                }
            }
        } finally {
            consumer.close();
        }
    }
}
