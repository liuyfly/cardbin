package com.liuyfly.biz.dal.dao;

import com.liuyfly.biz.dal.dataobject.CardBinDO;
import java.util.List;
import org.springframework.dao.DataAccessException;

/**
 * ���ݷ��ʶ���ӿ�
 * @since 2016-07-05
 */
public interface CardBinDAO {

    /**
     * ��������
     * @param cardBinDO
     * @return �������ݵ�����
     */
    public Long insertCardBinDO(CardBinDO cardBinDO) throws DataAccessException;

    /**
     * ͳ�Ƽ�¼��
     * @param cardBinDO
     * @return ����ļ�¼��
     */
    public Integer countCardBinDOByExample(CardBinDO cardBinDO) throws DataAccessException;

    /**
     * ���¼�¼
     * @param cardBinDO
     * @return ��Ӱ�������
     */
    public Integer updateCardBinDO(CardBinDO cardBinDO) throws DataAccessException;

    /**
     * ��ȡ�����б�
     * @param cardBinDO
     * @return �����б�
     */
    public List<CardBinDO> findListByExample(CardBinDO cardBinDO) throws DataAccessException;

    /**
     * ����������ȡcardBinDO
     * @param id
     * @return cardBinDO
     */
    public CardBinDO findCardBinDOByPrimaryKey(Long id) throws DataAccessException;

    /**
     * ɾ����¼
     * @param id
     * @return ��Ӱ�������
     */
    public Integer deleteCardBinDOByPrimaryKey(Long id) throws DataAccessException;
    
    public List<CardBinDO> queryPageCardBin(int start, int limit, CardBinDO cardBinDO) throws DataAccessException;

}