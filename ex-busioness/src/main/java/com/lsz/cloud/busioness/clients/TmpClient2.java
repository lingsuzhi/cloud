package com.lsz.cloud.busioness.clients;

import com.lsz.cloud.constants.ServiceConstant;
import com.lsz.cloud.util.ResponseInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = ServiceConstant.apply, path = "")
public interface TmpClient2 {

    @RequestMapping(value = "/tmp", method = RequestMethod.GET)
    ResponseInfo<String> tmp();
}
