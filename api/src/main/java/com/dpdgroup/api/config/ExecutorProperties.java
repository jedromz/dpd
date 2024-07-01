
package com.dpdgroup.api.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "task-executor")
@Getter
@Setter
public class ExecutorProperties {
    private int corePoolSize;
    private int maxPoolSize;
    private int queueCapacity;
}
