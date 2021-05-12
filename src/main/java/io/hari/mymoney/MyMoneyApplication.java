package io.hari.mymoney;

import io.hari.mymoney.config.ApplicationConfig;
import io.hari.mymoney.entity.Portfolio;
import io.hari.mymoney.entity.User;
import io.hari.mymoney.entity.input.UserOperation;
import io.hari.mymoney.service.FileOperationService;
import io.hari.mymoney.service.PortfolioService;
import io.hari.mymoney.service.UserService;
import lombok.NonNull;
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

import static io.hari.mymoney.constant.UserType.INVESTOR;

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
    private final FileOperationService fileOperationService;
    private final UserService userService;
    private final ApplicationConfig config;

    public static void main(String[] args) {
        SpringApplication.run(MyMoneyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //todo: read file name from config
        final List<String> inputFileName = config.getInputFileName();
        for (final String filePath: inputFileName) {
            executeUserFileOperation(filePath);
            System.out.println();
        }
    }

    private void executeUserFileOperation(@NonNull String filePath) throws IOException {
        List<UserOperation> userOperations = new LinkedList<>();
        Files.readAllLines(Paths.get(filePath))
                .forEach(line -> fileOperationService.readInputFile(userOperations, line.toLowerCase()));

        //todo : print user operations
        userOperations.forEach(i -> log.info("user input operation : {}",i));

        //todo: create user
        final User user = User.builder().name("hariom yadav").userType(INVESTOR).build();

        //todo: create portfolio
        final Portfolio portfolio = Portfolio.builder().build();
        portfolioService.updatePortfolioInitialPercentage(portfolio, userOperations);
        portfolioService.executeUserCHANGEOperation(portfolio, userOperations);

        //todo: execute user operations
        userService.executeUserBALANCE_REBALANCEOperations(portfolio, userOperations);

        //todo: assign portfolio to user
        user.getUserPortfolios().add(portfolio);
    }
}
