package com.liuyfly.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.liuyfly.dto.CardBinDTO;

public interface CardBinService {

    /**
     * 插入数据
     * 
     * @param cardBinDO
     * @return 插入数据的主键
     */
    public Long insertCardBin(CardBinDTO cardBinDTO) throws DataAccessException;

    /**
     * 统计记录数
     * 
     * @param cardBinDO
     * @return 查出的记录数
     */
    public Integer countCardBinByExample(CardBinDTO cardBinDTO) throws DataAccessException;

    /**
     * 更新记录
     * 
     * @param cardBinDO
     * @return 受影响的行数
     */
    public Integer updateCardBin(CardBinDTO cardBinDTO) throws DataAccessException;

    /**
     * 获取对象列表
     * 
     * @param cardBinDO
     * @return 对象列表
     */
    public List<CardBinDTO> findListByExample(CardBinDTO cardBinDTO) throws DataAccessException;

    /**
     * 根据主键获取cardBinDO
     * 
     * @param id
     * @return cardBinDO
     */
    public CardBinDTO findCardBinByPrimaryKey(Long id) throws DataAccessException;

    /**
     * 删除记录
     * 
     * @param id
     * @return 受影响的行数
     */
    public Integer deleteCardBinByPrimaryKey(Long id) throws DataAccessException;
    
    public List<CardBinDTO> queryPageCardBin(int start, int limit, CardBinDTO cardBinDTO) throws DataAccessException;
    
    public void refreshCardbin();
    
    public CardBinDTO getCardBin(String pan);

}
