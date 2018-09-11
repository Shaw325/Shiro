package com.shaw.controller;

import com.shaw.service.SecondsKillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @ClassName: SecondsKillController
 * @Description:
 * @Author Lindsey Shaw
 * @Date 2018/9/6
 **/
@Controller
public class SecondsKillController {

    private Logger logger = LoggerFactory.getLogger(SecondsKillController.class);

    @Autowired
    private SecondsKillService secondsKillService;

    @RequestMapping("/kill/{sid}")
    @ResponseBody
    public String kill(@PathVariable int sid){
        logger.info("sid=[{}]",sid);
        int id=0;
        try{
            id = secondsKillService.killOrder(sid);
        }catch (Exception e){
            logger.error("Exception",e);
        }
        return String.valueOf(id);
    }
}
