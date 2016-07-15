package com.liuyfly.biz.dal.dao;

import com.liuyfly.biz.dal.dataobject.CardBinDO;
import java.util.List;
import org.springframework.dao.DataAccessException;

/**
 * 数据访问对象接口
 * @since 2016-07-05
 */
public interface CardBinDAO {

    /**
     * 插入数据
     * @param cardBinDO
     * @return 插入数据的主键
     */
    public Long insertCardBinDO(CardBinDO cardBinDO) throws DataAccessException;

    /**
     * 统计记录数
     * @param cardBinDO
     * @return 查出的记录数
     */
    public Integer countCardBinDOByExample(CardBinDO cardBinDO) throws DataAccessException;

    /**
     * 更新记录
     * @param cardBinDO
     * @return 受影响的行数
     */
    public Integer updateCardBinDO(CardBinDO cardBinDO) throws DataAccessException;

    /**
     * 获取对象列表
     * @param cardBinDO
     * @return 对象列表
     */
    public List<CardBinDO> findListByExample(CardBinDO cardBinDO) throws DataAccessException;

    /**
     * 根据主键获取cardBinDO
     * @param id
     * @return cardBinDO
     */
    public CardBinDO findCardBinDOByPrimaryKey(Long id) throws DataAccessException;

    /**
     * 删除记录
     * @param id
     * @return 受影响的行数
     */
    public Integer deleteCardBinDOByPrimaryKey(Long id) throws DataAccessException;
    
    public List<CardBinDO> queryPageCardBin(int start, int limit, CardBinDO cardBinDO) throws DataAccessException;

}