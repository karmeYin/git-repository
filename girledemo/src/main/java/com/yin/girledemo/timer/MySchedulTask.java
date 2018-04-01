package com.yin.girledemo.timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class  MySchedulTask {
    private final static Logger logger = LoggerFactory.getLogger(MySchedulTask.class);
    @Scheduled(cron="0/5 * * * * ?")
    public void expressLove(){
        System.out.println("小火龙身体健康，父母身体健康，亲朋好友身体健康");
    }
}
