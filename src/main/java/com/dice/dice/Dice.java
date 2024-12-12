package com.dice.dice;

import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class Dice {

    // 随机数生成器
    private Random random = new Random();

    // 投掷骰子的方法
    public int roll() {
        return random.nextInt(6) + 1; // 返回 1 到 6 之间的随机整数
    }
}