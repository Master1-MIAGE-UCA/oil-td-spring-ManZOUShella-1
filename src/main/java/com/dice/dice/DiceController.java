package com.dice.dice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiceController {

    // 处理 GET 请求 /rollDice，返回一个随机的骰子结果
    @GetMapping("/rollDice")
    public String rollOneDice() {
        int result = (int) (Math.random() * 6) + 1;  // 生成1到6之间的随机数
        return "Result of the dice roll: " + result;
    }

    // 处理 GET 请求 /rollDices/{X}，X为动态参数，掷X个骰子
    @GetMapping("/rollDices/{count}")
    public String rollMultipleDices(@PathVariable int count) {
        StringBuilder results = new StringBuilder();
        for (int i = 0; i < count; i++) {
            int result = (int) (Math.random() * 6) + 1;  // 生成1到6之间的随机数
            results.append(result).append(" ");  // 将每个结果追加到字符串中
        }
        return "Results of the " + count + " dice rolls: " + results.toString();
    }
}