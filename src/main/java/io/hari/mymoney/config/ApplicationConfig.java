package io.hari.mymoney.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author Hariom Yadav
 * @create 5/8/2021
 */
@Getter
@Setter
@ToString
@Component
@ConfigurationProperties(prefix = "app-config")
public class ApplicationConfig {
    private Integer reBalanceLimit;
    private List<String> inputFileName;
}

