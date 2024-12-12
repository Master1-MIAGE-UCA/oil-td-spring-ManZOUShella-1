package com.dice.dice;

import org.springframework.data.jpa.repository.JpaRepository;

// 继承 JpaRepository，参数为实体类和主键类型
public interface DiceRollLogRepository extends JpaRepository<DiceRollLog, Long> {
    // 这里可以添加额外的自定义查询方法，如果需要的话
}