package com.liuyfly.biz.dal.service;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liuyfly.dto.CardBinDTO;
import com.liuyfly.service.CardBinService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-biz.xml" })
public class CardBinServiceTest {
    private final Logger   logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CardBinService cardBinService;

    @Test
    public void testCountCardBinDOByExample() {
        CardBinDTO cardBinDTO = new CardBinDTO();
        cardBinDTO.setPanPri("955990161");
        int i = cardBinService.countCardBinByExample(cardBinDTO).intValue();
        logger.info("{}", i);
    }

    @Test
    public void testFindListByExample() {
        CardBinDTO cardBinDTO = new CardBinDTO();
        cardBinDTO.setPanPri("955990161");
        List<CardBinDTO> list = cardBinService.findListByExample(cardBinDTO);
        logger.info("{}", list);
    }

    @Test
    public void testFindCardBinByPrimaryKey() {
        CardBinDTO dto = cardBinService.findCardBinByPrimaryKey(10007240L);
        logger.info("{}", dto);
    }

    @Test
    public void testQueryPageCardBin() {
        CardBinDTO queryDTO = new CardBinDTO();
        queryDTO.setInstName("成都商业银行");
        List<CardBinDTO> list = cardBinService.queryPageCardBin(0, 5, queryDTO);
        if (CollectionUtils.isNotEmpty(list)) {
            for (CardBinDTO dto : list) {
                logger.info("{}", dto);
            }
        } else {
            logger.info("list is null");
        }
    }

    @Test
    public void testInsert() {
        CardBinDTO cardBinDTO = new CardBinDTO();
        cardBinDTO.setCardName("测试");
        cardBinDTO.setCardType("01");
        cardBinDTO.setInstCode("10000000");
        cardBinDTO.setInstName("测试");
        cardBinDTO.setPanLen(19);
        cardBinDTO.setPanPri("62250000");
        cardBinDTO.setPanPriLen(8);
        cardBinService.insertCardBin(cardBinDTO);
    }

    @Test
    public void testDelete() {
        cardBinService.deleteCardBinByPrimaryKey(10007263L);
    }

    @Test
    public void testGetCardBin() {
        String pan = "6225768710264111";
        CardBinDTO dto = cardBinService.getCardBin(pan);
        logger.info("{}", dto);
    }

}
