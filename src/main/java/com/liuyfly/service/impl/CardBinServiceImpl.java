package com.liuyfly.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.liuyfly.biz.dal.dao.CardBinDAO;
import com.liuyfly.biz.dal.dataobject.CardBinDO;
import com.liuyfly.common.tree.BinaryTree;
import com.liuyfly.dto.CardBinDTO;
import com.liuyfly.helper.TransformationHelper;
import com.liuyfly.service.CardBinService;
import com.liuyfly.service.SequenceService;

@Slf4j
public class CardBinServiceImpl implements CardBinService, InitializingBean {
    @Autowired
    private CardBinDAO      cardBinDAO;

    @Autowired
    private SequenceService cardBinSequenceService;

    private BinaryTree      binaryTree;

    @Override
    public Long insertCardBin(CardBinDTO cardBinDTO) throws DataAccessException {
        Long sequence = cardBinSequenceService.nextValue();
        CardBinDO cardBinDO = TransformationHelper.convertCardBinDO(cardBinDTO);
        cardBinDO.setId(sequence);
        return cardBinDAO.insertCardBinDO(cardBinDO);
    }

    @Override
    public Integer countCardBinByExample(CardBinDTO cardBinDTO) throws DataAccessException {
        CardBinDO cardBinDO = TransformationHelper.convertCardBinDO(cardBinDTO);
        return cardBinDAO.countCardBinDOByExample(cardBinDO);
    }

    @Override
    public Integer updateCardBin(CardBinDTO cardBinDTO) throws DataAccessException {
        CardBinDO cardBinDO = TransformationHelper.convertCardBinDO(cardBinDTO);
        return cardBinDAO.updateCardBinDO(cardBinDO);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CardBinDTO> findListByExample(CardBinDTO cardBinDTO) throws DataAccessException {
        List<CardBinDTO> listDTO = null;
        CardBinDO cardBinDO = TransformationHelper.convertCardBinDO(cardBinDTO);
        List<CardBinDO> list = cardBinDAO.findListByExample(cardBinDO);
        if (CollectionUtils.isNotEmpty(list)) {
            listDTO = TransformationHelper.changeListObj(list, CardBinDTO.class);
        }
        return listDTO;
    }

    @Override
    public CardBinDTO findCardBinByPrimaryKey(Long id) throws DataAccessException {
        CardBinDO cardBinDO = cardBinDAO.findCardBinDOByPrimaryKey(id);
        return TransformationHelper.convertCardBinDTO(cardBinDO);
    }

    @Override
    public Integer deleteCardBinByPrimaryKey(Long id) throws DataAccessException {
        return cardBinDAO.deleteCardBinDOByPrimaryKey(id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CardBinDTO> queryPageCardBin(int start, int limit, CardBinDTO cardBinDTO) throws DataAccessException {
        List<CardBinDTO> listDTO = null;
        CardBinDO cardBinDO = TransformationHelper.convertCardBinDO(cardBinDTO);
        List<CardBinDO> list = cardBinDAO.queryPageCardBin(start, limit, cardBinDO);
        if (CollectionUtils.isNotEmpty(list)) {
            listDTO = TransformationHelper.changeListObj(list, CardBinDTO.class);
        }
        return listDTO;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        refreshCardbin();
    }

    @Override
    public void refreshCardbin() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        Date now = new Date();
        log.info("刷新缓存开始----[{}]", formatter.format(now));
        binaryTree = new BinaryTree();
        List<CardBinDO> list = cardBinDAO.findListByExample(new CardBinDO());
        if (CollectionUtils.isNotEmpty(list)) {
            for (CardBinDO cardBinDO : list) {
                binaryTree.insert(cardBinDO.getPanPri(), cardBinDO);
            }
        }
        now = new Date();
        log.info("刷新缓存结束----[{}]", formatter.format(now));
    }

    @Override
    public CardBinDTO getCardBin(String pan) {
        CardBinDO cardBinDO = binaryTree.search(pan);
        if (cardBinDO != null) {
            return TransformationHelper.convertCardBinDTO(cardBinDO);
        }
        return null;
    }

}
