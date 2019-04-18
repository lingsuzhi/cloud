package com.lsz.cloud.busioness.controller;

import com.lsz.cloud.util.ResponseInfo;

import com.lsz.cloud.busioness.service.TmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TmpController {

    @Autowired
    private TmpService tmpService;

    @RequestMapping(value = "/tmp", method = RequestMethod.GET)
    public ResponseInfo<String> tmp() {
        return ResponseInfo.success(tmpService.tmp());
    }
}
