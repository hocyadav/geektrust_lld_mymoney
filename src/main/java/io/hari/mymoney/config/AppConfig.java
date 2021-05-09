package io.hari.mymoney.config;

import io.hari.mymoney.constant.ActionType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author Hariom Yadav
 * @create 5/8/2021
 */
@Getter
@Setter
@ToString
@Component
@ConfigurationProperties(prefix = "app-config")
public class AppConfig {
    private Integer reBalanceLimit;
    private Set<ActionType> validOperations;
    private List<String> inputFileName;
}

