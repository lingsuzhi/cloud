package com.lsz.cloud.apply.controller;

import com.lsz.cloud.apply.service.TmpService;
import com.lsz.cloud.util.ResponseInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "场外交易——买方向")
@RestController
public class TmpController {

    @Autowired
    private TmpService tmpService;

    @ApiOperation("分页查询所有挂单")
    @RequestMapping(value = "/tmp", method = RequestMethod.GET)
    public ResponseInfo<String> index() {
        return ResponseInfo.success(tmpService.tmp());
    }
}
