package com.hgz.controller;


import com.hgz.annotation.ApiOperationLog;
import com.hgz.entity.TbUser;
import com.hgz.exception.MyException;
import com.hgz.page.Pager;
import com.hgz.result.Result;
import com.hgz.result.ResultResponse;
import com.hgz.service.TbUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hgz
 * @since 2021-02-21
 */
@RestController
@RequestMapping("/hgz/user")
@Api(tags = "用户管理")
public class TbUserController {

    @Autowired
    private TbUserService tbUserService;

    @GetMapping
    @ApiOperation("分页")
    public Result<?> get(@RequestParam(value = "pageNum") int pageNum, @RequestParam(value = "pageSize") int pageSize) {
        try {
            Pager<TbUser> list = tbUserService.findAll(pageNum, pageSize);
            return ResultResponse.makeOKRsp(list);
        } catch (Exception e) {
            throw new MyException("9999", "服务器异常");
        }

    }

    @GetMapping({"/{id}"})
    @ApiOperation("查询")
    public Result<?> getByid(@PathVariable int id) {
        try {
            TbUser tbUser = tbUserService.findById(id);
            return ResultResponse.makeOKRsp(tbUser);
        } catch (Exception e) {
            throw new MyException("9999", "服务器异常");
        }

    }

    @PutMapping({"/{id}"})
    @ApiOperation("修改")
    public Result<?> put(@PathVariable int id) {
        try {
            tbUserService.update(id);
            return ResultResponse.makeOKRsp();
        } catch (Exception e) {
            throw new MyException("9999", "服务器异常");
        }

    }

    @ApiOperation("删除")
    @DeleteMapping({"/{id}"})
    public Result<?> delete(@PathVariable int id) {
        try {
            tbUserService.delete(id);
            return ResultResponse.makeOKRsp();
        } catch (Exception e) {
            throw new MyException("9999", "服务器异常");
        }

    }

    @ApiOperation("新增")
    @PostMapping
    @ApiOperationLog(resourceId = "#{tbUser.username}", operationType = "SAVE", description = "测试注解传递复杂动态参数")
    public Result<?> add(@RequestBody TbUser tbUser) {
        try {
            tbUserService.insert(tbUser);
            return ResultResponse.makeOKRsp();
        } catch (Exception e) {
            throw new MyException("9999", "服务器异常");
        }

    }

}

