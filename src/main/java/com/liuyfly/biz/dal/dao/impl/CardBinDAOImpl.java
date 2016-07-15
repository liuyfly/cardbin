package com.liuyfly.biz.dal.dao.impl;

import com.liuyfly.biz.dal.dao.CardBinDAO;
import com.liuyfly.biz.dal.dataobject.CardBinDO;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * 数据访问对象实现类
 * 
 * @since 2016-07-05
 */
public class CardBinDAOImpl extends SqlMapClientDaoSupport implements CardBinDAO {

    /**
     * 插入数据
     * 
     * @param cardBinDO
     * @return 插入数据的主键
     */
    public Long insertCardBinDO(CardBinDO cardBinDO) throws DataAccessException {
        Object id = getSqlMapClientTemplate().insert("CardBin.insert", cardBinDO);
        return (Long) id;
    }

    /**
     * 统计记录数
     * 
     * @param cardBinDO
     * @return 查出的记录数
     */
    public Integer countCardBinDOByExample(CardBinDO cardBinDO) throws DataAccessException {
        Integer count = (Integer) getSqlMapClientTemplate().queryForObject("CardBin.countByDOExample", cardBinDO);
        return count;
    }

    /**
     * 更新记录
     * 
     * @param cardBinDO
     * @return 受影响的行数
     */
    public Integer updateCardBinDO(CardBinDO cardBinDO) throws DataAccessException {
        int result = getSqlMapClientTemplate().update("CardBin.update", cardBinDO);
        return result;
    }

    /**
     * 获取对象列表
     * 
     * @param cardBinDO
     * @return 对象列表
     */
    @SuppressWarnings("unchecked")
    public List<CardBinDO> findListByExample(CardBinDO cardBinDO) throws DataAccessException {
        List<CardBinDO> list = getSqlMapClientTemplate().queryForList("CardBin.findListByDO", cardBinDO);
        return list;
    }

    /**
     * 根据主键获取cardBinDO
     * 
     * @param id
     * @return cardBinDO
     */
    public CardBinDO findCardBinDOByPrimaryKey(Long id) throws DataAccessException {
        CardBinDO cardBinDO = (CardBinDO) getSqlMapClientTemplate().queryForObject("CardBin.findByPrimaryKey", id);
        return cardBinDO;
    }

    /**
     * 删除记录
     * 
     * @param id
     * @return 受影响的行数
     */
    public Integer deleteCardBinDOByPrimaryKey(Long id) throws DataAccessException {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("CardBin.deleteByPrimaryKey", id);
        return rows;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CardBinDO> queryPageCardBin(int start, int limit, CardBinDO cardBinDO) throws DataAccessException {
        List<CardBinDO> list = getSqlMapClientTemplate().queryForList("CardBin.queryPageCardBin", cardBinDO, start,
                limit);
        return list;
    }

}
