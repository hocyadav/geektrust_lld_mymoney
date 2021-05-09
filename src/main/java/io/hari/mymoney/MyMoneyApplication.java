package io.hari.mymoney;

import io.hari.mymoney.config.AppConfig;
import io.hari.mymoney.constant.UserType;
import io.hari.mymoney.entity.Portfolio;
import io.hari.mymoney.entity.User;
import io.hari.mymoney.entity.input.UserOperation;
import io.hari.mymoney.service.FileInputService;
import io.hari.mymoney.service.PortfolioService;
import io.hari.mymoney.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Hariom Yadav
 * @create 5/8/2021
 * git link : https://github.com/hocyadav/geektrust_lld_mymoney
 */
@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class MyMoneyApplication implements CommandLineRunner {
	private final PortfolioService portfolioService;
    private final FileInputService fileInputService;
    private final UserService userService;
    private final AppConfig config;

    public static void main(String[] args) {
        SpringApplication.run(MyMoneyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //todo: read file name from config
        final List<String> inputFileName = config.getInputFileName();
        for (String filePath: inputFileName) {
            executeUserFileOperation(filePath);
            System.out.println();
        }
    }

    private void executeUserFileOperation(String filePath) throws IOException {
        List<UserOperation> userOperations = new LinkedList<>();
        Files.readAllLines(Paths.get(filePath)).forEach(line -> fileInputService.readInputFile(userOperations, line.toLowerCase()));

        //todo : print user operations
        userOperations.forEach(i -> log.info("user input operation : {}",i));

        //todo: create user
        final User hariom = User.builder().name("hariom").type(UserType.investor).build();

        //todo: create portfolio
        final Portfolio portfolio = Portfolio.builder().build();
        portfolioService.updatePortfolioInitialPercentage(portfolio, userOperations);
        portfolioService.executeUserCHANGEOperation(portfolio, userOperations);

        //todo: execute user operations
        userService.executeUserBALANCE_REBALANCEOperations(userOperations, portfolio);

        //todo: assign portfolio to user
        hariom.getPortfolios().add(portfolio);
    }
}
