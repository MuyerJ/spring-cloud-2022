package com.yejiang.cloud.service;


import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Description: 
 * date: 2022/5/1 1:49
 * @author YeJiang
 * @version
 */
@Component
public class HealthStatusService implements HealthIndicator {


    private boolean status = true;

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public Health health() {
        if (status) {
            return Health.up().build();
        }
        return Health.down().build();
    }
}
