package com.faymax.server.task;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.faymax.server.entity.Employee;
import com.faymax.server.entity.MailConstants;
import com.faymax.server.entity.MailSendLog;
import com.faymax.server.service.EmployeeService;
import com.faymax.server.service.MailSendLogService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: Faymax
 * @Description: 邮件发送定时任务
 */

@Component
public class MailTask {

    @Autowired
    private MailSendLogService mailSendLogService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 10秒执行一次
     */
    @Scheduled(cron = "0/10 * * * * ?")
    public void mailTask(){
        List<MailSendLog> list = mailSendLogService.list(new QueryWrapper<MailSendLog>()
                .eq("status", 0)
                .lt("tryTime", LocalDateTime.now()));
        list.forEach(mailSendLog -> {
            if (3 <= mailSendLog.getCount()) {
                mailSendLogService.update(new UpdateWrapper<MailSendLog>()
                        .set("status", 2)
                        .eq("msgId", mailSendLog.getMsgId()));
            }
            mailSendLogService.update(new UpdateWrapper<MailSendLog>()
                    .set("count", mailSendLog.getCount() + 1)
                    .set("updateTime", LocalDateTime.now())
                    .set("tryTime", LocalDateTime.now().plusMinutes(MailConstants.MSG_TIMEOUT))
                    .eq("msgId", mailSendLog.getMsgId()));
            Employee emp = employeeService.getEmployee(mailSendLog.getEmpId()).get(0);
            rabbitTemplate.convertAndSend(MailConstants.MAIL_EXCHANGE_NAME, MailConstants.MAIL_ROUTING_KEY_NAME,
                    emp, new CorrelationData(mailSendLog.getMsgId()));
        });
    }
}
