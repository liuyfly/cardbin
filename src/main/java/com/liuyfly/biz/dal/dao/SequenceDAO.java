package com.liuyfly.biz.dal.dao;

import com.liuyfly.biz.dal.dataobject.SequenceDO;
import java.util.List;
import org.springframework.dao.DataAccessException;

/**
 * 数据访问对象接口
 * @since 2016-07-06
 */
public interface SequenceDAO {

    /**
     * 插入数据
     * @param sequenceDO
     * @return 插入数据的主键
     */
    public Long insertSequenceDO(SequenceDO sequenceDO) throws DataAccessException;

    /**
     * 统计记录数
     * @param sequenceDO
     * @return 查出的记录数
     */
    public Integer countSequenceDOByExample(SequenceDO sequenceDO) throws DataAccessException;

    /**
     * 更新记录
     * @param sequenceDO
     * @return 受影响的行数
     */
    public Integer updateSequenceDO(SequenceDO sequenceDO) throws DataAccessException;

    /**
     * 获取对象列表
     * @param sequenceDO
     * @return 对象列表
     */
    public List<SequenceDO> findListByExample(SequenceDO sequenceDO) throws DataAccessException;

    /**
     * 根据主键获取sequenceDO
     * @param id
     * @return sequenceDO
     */
    public SequenceDO findSequenceDOByPrimaryKey(Long id) throws DataAccessException;

    /**
     * 删除记录
     * @param id
     * @return 受影响的行数
     */
    public Integer deleteSequenceDOByPrimaryKey(Long id) throws DataAccessException;

}