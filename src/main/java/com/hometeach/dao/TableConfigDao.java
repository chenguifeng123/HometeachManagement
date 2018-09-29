package com.hometeach.dao;

import java.util.HashMap;
import java.util.List;

import com.hometeach.dto.TableConfig;

/**
 * 处理表关键字映射的接口
 */
public interface TableConfigDao {
    public List<TableConfig> findTableConfig();
    public List<HashMap> findTableColumn();
}
