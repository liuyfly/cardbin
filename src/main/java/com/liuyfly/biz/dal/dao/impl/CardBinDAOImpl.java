package com.liuyfly.biz.dal.dao.impl;

import com.liuyfly.biz.dal.dao.CardBinDAO;
import com.liuyfly.biz.dal.dataobject.CardBinDO;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * ���ݷ��ʶ���ʵ����
 * 
 * @since 2016-07-05
 */
public class CardBinDAOImpl extends SqlMapClientDaoSupport implements CardBinDAO {

    /**
     * ��������
     * 
     * @param cardBinDO
     * @return �������ݵ�����
     */
    public Long insertCardBinDO(CardBinDO cardBinDO) throws DataAccessException {
        Object id = getSqlMapClientTemplate().insert("CardBin.insert", cardBinDO);
        return (Long) id;
    }

    /**
     * ͳ�Ƽ�¼��
     * 
     * @param cardBinDO
     * @return ����ļ�¼��
     */
    public Integer countCardBinDOByExample(CardBinDO cardBinDO) throws DataAccessException {
        Integer count = (Integer) getSqlMapClientTemplate().queryForObject("CardBin.countByDOExample", cardBinDO);
        return count;
    }

    /**
     * ���¼�¼
     * 
     * @param cardBinDO
     * @return ��Ӱ�������
     */
    public Integer updateCardBinDO(CardBinDO cardBinDO) throws DataAccessException {
        int result = getSqlMapClientTemplate().update("CardBin.update", cardBinDO);
        return result;
    }

    /**
     * ��ȡ�����б�
     * 
     * @param cardBinDO
     * @return �����б�
     */
    @SuppressWarnings("unchecked")
    public List<CardBinDO> findListByExample(CardBinDO cardBinDO) throws DataAccessException {
        List<CardBinDO> list = getSqlMapClientTemplate().queryForList("CardBin.findListByDO", cardBinDO);
        return list;
    }

    /**
     * ����������ȡcardBinDO
     * 
     * @param id
     * @return cardBinDO
     */
    public CardBinDO findCardBinDOByPrimaryKey(Long id) throws DataAccessException {
        CardBinDO cardBinDO = (CardBinDO) getSqlMapClientTemplate().queryForObject("CardBin.findByPrimaryKey", id);
        return cardBinDO;
    }

    /**
     * ɾ����¼
     * 
     * @param id
     * @return ��Ӱ�������
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
