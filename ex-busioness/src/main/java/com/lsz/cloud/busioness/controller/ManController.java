package com.lsz.cloud.busioness.controller;

import com.lsz.cloud.busioness.dto.ManDTO;
import com.lsz.cloud.busioness.dto.WoManDTO;
import com.lsz.cloud.busioness.service.TmpService;
import com.lsz.cloud.util.ResponseInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Slf4j
@Api(tags = "Man——控制器")
public class ManController {


    /***
     *
     * @param manDTO 这是一个DTO
     * @return
     */
    @RequestMapping(value = "/man", method = RequestMethod.POST)
    @ApiOperation( value = "man接口" ,notes="saaaaaaaaaaa")
    public ResponseInfo<WoManDTO> man(@RequestBody ManDTO manDTO) {
        WoManDTO woManDTO = new WoManDTO();
        woManDTO.setAge(17);
        woManDTO.setBirthday(new Date());
        woManDTO.setName(manDTO.getName() + "女");
        log.info("man打印了日志");
        return ResponseInfo.success(woManDTO);
    }
}
