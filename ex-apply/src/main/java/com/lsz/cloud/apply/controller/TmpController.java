package com.lsz.cloud.apply.controller;

import com.lsz.cloud.apply.service.TmpService;
import com.lsz.cloud.util.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TmpController {

    @Autowired
    private TmpService tmpService;

    @RequestMapping(value = "/tmp", method = RequestMethod.GET)
    public ResponseInfo<String> index() {
        return ResponseInfo.success(tmpService.tmp());
    }
}
