package com.liuyfly.helper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liuyfly.biz.dal.dataobject.CardBinDO;
import com.liuyfly.dto.CardBinDTO;

public class TransformationHelper {

    private static Logger log = LoggerFactory.getLogger(TransformationHelper.class);

    public static CardBinDO convertCardBinDO(CardBinDTO cardBinDTO) {
        CardBinDO cardBinDO = new CardBinDO();
        objCopy(cardBinDTO, cardBinDO);
        return cardBinDO;
    }

    public static CardBinDTO convertCardBinDTO(CardBinDO cardBinDO) {
        CardBinDTO cardBinDTO = new CardBinDTO();
        objCopy(cardBinDO, cardBinDTO);
        return cardBinDTO;
    }

    @SuppressWarnings({ "rawtypes" })
    public static List changeListObj(List list, Class cs) {
        List result = null;
        try {
            result = ReflectTool.changeListObj(list, cs);
        } catch (Exception e) {
            log.error("", e);
            result = new ArrayList();
        }
        return result;
    }

    public static void objCopy(Object src, Object dest) {
        try {
            ReflectTool.objCopy(src, dest);
        } catch (Exception e) {
            log.error("", e);
        }
    }

}
