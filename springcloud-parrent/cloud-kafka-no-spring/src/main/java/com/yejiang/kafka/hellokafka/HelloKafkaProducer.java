package com.yejiang.kafka.hellokafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * Description: 
 * date: 2022/1/26 17:08
 * @author YeJiang
 * @version
 */
public class HelloKafkaProducer {


    public static void main(String[] args) {

        //生产配置对象
        Properties config = new Properties();
        config.put("bootstrap.servers", "127.0.0.1:9092");
        config.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        config.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        //创建kafka生产者
        KafkaProducer<String, String> producer = new KafkaProducer<>(config);

        ProducerRecord<String, String> record;
        try {
            try {
                for (int i = 0; i < 2000; i++) {
                    record = new ProducerRecord<>("my-topic", i + "", "test data" + i);
                    producer.send(record);
                    System.out.println(1 + " , message is sent");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            producer.close();
        }
    }
}
