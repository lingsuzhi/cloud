package com.lsz.cloud.busioness.service;


import com.lsz.cloud.busioness.clients.TmpClient2;
import com.lsz.cloud.util.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TmpService {

    @Autowired
    private TmpClient2 tmpApi;

    public String tmp() {
        ResponseInfo<String> val = tmpApi.tmp();
        return val.getData() + " busioness";
        //return "busioness TmpService do";
    }
}
