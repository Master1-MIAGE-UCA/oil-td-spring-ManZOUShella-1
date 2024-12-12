package com.dice.dice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiceRollLogController {

    @Autowired
    private DiceRollLogRepository diceRollLogRepository;

    // 获取所有的 DiceRollLog
    @GetMapping("/diceLogs")
    public List<DiceRollLog> getAllDiceLogs() {
        return diceRollLogRepository.findAll();  // 从数据库中获取所有的历史记录
    }
}