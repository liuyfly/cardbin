package com.liuyfly.biz.dal.dao.impl;

import com.liuyfly.biz.dal.dao.SequenceDAO;
import com.liuyfly.biz.dal.dataobject.SequenceDO;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * 数据访问对象实现类
 * @since 2016-07-06
 */
public class SequenceDAOImpl extends SqlMapClientDaoSupport implements SequenceDAO {

    /**
     * 插入数据
     * @param sequenceDO
     * @return 插入数据的主键
     */
    public Long insertSequenceDO(SequenceDO sequenceDO) throws DataAccessException {
        Object id = getSqlMapClientTemplate().insert("Sequence.insert", sequenceDO);
        return (Long) id;
    }

    /**
     * 统计记录数
     * @param sequenceDO
     * @return 查出的记录数
     */
    public Integer countSequenceDOByExample(SequenceDO sequenceDO) throws DataAccessException {
        Integer count = (Integer) getSqlMapClientTemplate().queryForObject("Sequence.countByDOExample", sequenceDO);
        return count;
    }

    /**
     * 更新记录
     * @param sequenceDO
     * @return 受影响的行数
     */
    public Integer updateSequenceDO(SequenceDO sequenceDO) throws DataAccessException {
        int result = getSqlMapClientTemplate().update("Sequence.update", sequenceDO);
        return result;
    }

    /**
     * 获取对象列表
     * @param sequenceDO
     * @return 对象列表
     */
    @SuppressWarnings("unchecked")
    public List<SequenceDO> findListByExample(SequenceDO sequenceDO) throws DataAccessException {
        List<SequenceDO> list = getSqlMapClientTemplate().queryForList("Sequence.findListByDO", sequenceDO);
        return list;
    }

    /**
     * 根据主键获取sequenceDO
     * @param id
     * @return sequenceDO
     */
    public SequenceDO findSequenceDOByPrimaryKey(Long id) throws DataAccessException {
        SequenceDO sequenceDO = (SequenceDO) getSqlMapClientTemplate().queryForObject("Sequence.findByPrimaryKey", id);
        return sequenceDO;
    }

    /**
     * 删除记录
     * @param id
     * @return 受影响的行数
     */
    public Integer deleteSequenceDOByPrimaryKey(Long id) throws DataAccessException {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("Sequence.deleteByPrimaryKey", id);
        return rows;
    }

}