package com.liuyfly.biz.dal.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liuyfly.service.SequenceService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-biz.xml" })
public class CardBinSequenceServiceTest {
    private final Logger    logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SequenceService cardBinSequenceService;

    @Test
    public void test() {
        for (int i = 0; i < 5; i++) {
            logger.info("cardBinSequenceService:[{}], i:[{}]", cardBinSequenceService, i);
            Long sequence = cardBinSequenceService.nextValue();
            logger.info("sequence:[{}]", sequence);
        }
    }

}
