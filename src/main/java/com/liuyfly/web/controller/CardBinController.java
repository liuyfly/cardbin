package com.liuyfly.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liuyfly.dto.CardBinDTO;
import com.liuyfly.service.CardBinService;

@Slf4j
@Controller
@RequestMapping("/cardbin")
public class CardBinController {
    @Autowired
    private CardBinService cardBinService;

    @RequestMapping("/index")
    public String cardbinIndex(HttpServletRequest request, Model model) {
        log.info("in CardBinController index.");
        log.info("test @slf4j");
        return "cardbin/index";
    }

    @ResponseBody
    @RequestMapping("/getCardBin")
    public Map<String, Object> getCardBin(@RequestParam(value = "cardNo", required = true) String cardNo) {
        log.info("in CardBinController getCardBin.");
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("result", "1");

        CardBinDTO dto = cardBinService.getCardBin(cardNo);
        log.info("{}", dto);
        result.put("data", dto);

        return result;
    }

    @ResponseBody
    @RequestMapping("/startThread")
    public String startThread() {
        log.info("in CardBinController startThread.");
        return "SUCCESS";
    }
    
    
}
