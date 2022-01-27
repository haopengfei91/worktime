package com.faymax.server.config;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.faymax.server.entity.MailConstants;
import com.faymax.server.entity.MailSendLog;
import com.faymax.server.service.MailSendLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Faymax
 * @Description: RabbitMQ配置类
 */
@Configuration
public class RabbitMQConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConfig.class);

    @Autowired
    private CachingConnectionFactory connectionFactory;
    @Autowired
    private MailSendLogService mailSendLogService;

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        /**
         * 消息确认回调，确认消息是否到达broker
         * data: 消息唯一
         * ack: 确认结果
         * cause： 失败原因
         */
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                String msgId = correlationData.getId();
                if (ack) {
                    LOGGER.info("{}========>消息发送成功", msgId);
                    mailSendLogService.update(new UpdateWrapper<MailSendLog>().set("status", 1).eq("msgId", msgId));
                } else {
                    LOGGER.error("{}========>消息发送失败", msgId);
                }
            }
        });

        /**
         * 消息失败回调
         */
        rabbitTemplate.setReturnsCallback(new RabbitTemplate.ReturnsCallback() {
            @Override
            public void returnedMessage(ReturnedMessage returnedMessage) {
                LOGGER.error("{}========>消息发送queue时失败", returnedMessage.getMessage());
            }
        });
        return rabbitTemplate;
    }

    @Bean
    public Queue queue() {
        return new Queue(MailConstants.MAIL_QUEUE_NAME);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(MailConstants.MAIL_EXCHANGE_NAME);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(directExchange()).with(MailConstants.MAIL_ROUTING_KEY_NAME);
    }
}
