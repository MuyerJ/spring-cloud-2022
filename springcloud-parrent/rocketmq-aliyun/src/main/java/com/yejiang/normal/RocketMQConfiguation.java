package com.yejiang.normal;

import com.aliyun.openservices.ons.api.bean.ProducerBean;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Author yiliang
 * @Date 2020/10/28
 * mq 配置
 */
@Configuration
@EnableConfigurationProperties({MqConfig.class})
public class RocketMQConfiguation {

    @Autowired
    private MqConfig mqConfig;

    /**
     * 注入一个默认的生产者
     *
     * @return
     * @throws MQClientException
     */
    @Bean(initMethod = "start", destroyMethod = "shutdown")
    public ProducerBean buildProducer() throws MQClientException {
        ProducerBean producer = new ProducerBean();
        producer.setProperties(mqConfig.getMqPropertie());
        return producer;
    }
}
