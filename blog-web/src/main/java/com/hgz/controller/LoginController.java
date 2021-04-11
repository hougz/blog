package com.hgz.controller;

import com.hgz.annotation.ApiOperationLog;
import com.hgz.annotation.Auth;
import com.hgz.entity.TbUser;
import com.hgz.result.Result;
import com.hgz.result.ResultResponse;
import com.hgz.service.TbUserService;
import com.hgz.util.MD5Utils;
import com.hgz.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping({"/login","user"})
public class LoginController {

    @Autowired
    private TbUserService tbUserService;

    @PostMapping
    @Auth
    //@ApiOperationLog(resourceId = "#{username}",operationType = "SAVE",description = "测试注解传递复杂动态参数")
    public Result<?> get(@RequestParam String username, String password) {
        TbUser tbUser = tbUserService.findByName(username, MD5Utils.getMD5(password));
        UserDto userVo = new UserDto();
        BeanUtils.copyProperties(tbUser, userVo);
        userVo.setUserRole("admin");
        return ResultResponse.makeOKRsp(userVo);
    }

}
