package com.yejiang.normal;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.SendResult;
import com.aliyun.openservices.ons.api.bean.ProducerBean;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RocketProducer {

    @Autowired
    private ProducerBean defaultMQProducer;

    public void sendMessage(String msg, String topics, String tags, String key, int delayTimeLevel) {
        try {
            Message message = new Message(topics, tags, key, msg.getBytes(RemotingHelper.DEFAULT_CHARSET));
            if (delayTimeLevel > 0) {
                //  自动支付预付款
                message.setStartDeliverTime(System.currentTimeMillis() + (long) delayTimeLevel * 60 * 1000);
            }
            // 发送消息到一个 Broker
            SendResult sendResult = defaultMQProducer.send(message);
            // 通过 sendResult 返回消息是否成功送达
            System.out.println("send :{}"+sendResult);
        } catch (Exception e) {
        }
    }

    public void sendMessage(String msg, String topics, String tags, String key, long overdueDate) {
        try {
            Message message = new Message(topics, tags, key, msg.getBytes(RemotingHelper.DEFAULT_CHARSET));
            if (overdueDate > 0) {
                message.setStartDeliverTime(overdueDate);
            }
            // 发送消息到一个 Broker
            SendResult sendResult = defaultMQProducer.send(message);
            // 通过 sendResult 返回消息是否成功送达
            System.out.println("send :{}"+sendResult);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg, String topics) {
        sendMessage(msg, topics, "*", "", 0);
    }

    public void sendMessage(String msg, String topics, String key) {
        sendMessage(msg, topics, "*", key, 0);
    }

    public void sendMessage(String msg, String topics, String key, int delayTimeLevel) {
        sendMessage(msg, topics, "*", key, delayTimeLevel);
    }
}
