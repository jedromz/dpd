package com.dpdgroup.mailingservice;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Component
@ConfigurationProperties(prefix = "kafka")
@Data
public class KafkaProperties {

    private String topic;
}
