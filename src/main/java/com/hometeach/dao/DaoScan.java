package com.hometeach.dao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

/**
 * 扫描Mybatis映射.
 */
@Component
@MapperScan(basePackages = "com.hometeach.dao")
public class DaoScan {
}
