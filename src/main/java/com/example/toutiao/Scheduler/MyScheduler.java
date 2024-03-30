package com.example.toutiao.Scheduler;

import com.example.toutiao.mapper.ShowMapper;
import com.example.toutiao.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class MyScheduler {

    @Autowired
    private ShowMapper showMapper;
    
    @Scheduled(cron = "0 0 0 * * ?") // 每天凌晨执行，可以根据需求修改cron表达式
    public void updateField() {
        // 将show表的入场时间更新成当天日期
        showMapper.updateAllShowDate();
    }
}
