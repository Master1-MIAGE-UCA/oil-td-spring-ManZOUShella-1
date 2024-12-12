package com.dice.dice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.time.LocalDateTime;

@Service
public class DiceRollService {

    private static final Logger logger = LoggerFactory.getLogger(DiceRollService.class);  // 创建 Logger 实例

    @Autowired
    private DiceRollLogRepository diceRollLogRepository;

    public List<Integer> rollDice(int diceCount) {
        Random random = new Random();
        List<Integer> results = new ArrayList<>();

        // 生成掷骰结果
        logger.debug("Starting dice roll with {} dice.", diceCount);  // DEBUG级别日志，记录开始掷骰子
        for (int i = 0; i < diceCount; i++) {
            results.add(random.nextInt(6) + 1);  // 生成1到6的随机数
        }

        // 创建 DiceRollLog 实例
        DiceRollLog log = new DiceRollLog();
        log.setDiceCount(diceCount);
        log.setResults(results.toString());
        log.setTimestamp(LocalDateTime.now());  // 使用当前时间

        // 打印日志，确保数据正确
        logger.info("Preparing to save DiceRollLog with the following details: ");
        logger.info("Dice Count: " + log.getDiceCount());
        logger.info("Results: " + log.getResults());
        logger.info("Timestamp: " + log.getTimestamp());

        try {
            // 执行保存操作
            logger.debug("Attempting to save DiceRollLog...");  // DEBUG日志，记录保存前的状态
            diceRollLogRepository.save(log);
            logger.info("DiceRollLog saved successfully");  // 保存成功的日志
        } catch (Exception e) {
            logger.error("Error saving DiceRollLog: " + e.getMessage(), e);  // 错误日志
        }

        return results;  // 返回掷骰结果
    }
}