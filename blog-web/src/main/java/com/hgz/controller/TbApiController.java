package com.hgz.controller;


import com.hgz.entity.TbApi;
import com.hgz.entity.TbUser;
import com.hgz.exception.MyException;
import com.hgz.result.Result;
import com.hgz.result.ResultResponse;
import com.hgz.service.TbApiService;
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
 * @since 2021-02-27
 */
@RestController
@RequestMapping("/hgz/tb-api")
public class TbApiController {

    @Autowired
    private TbApiService tbApiService;

    @GetMapping({"/{id}"})
    @ApiOperation("查询")
    public Result<?> getByid(@PathVariable int id) {
        try {
            TbApi tbApi = tbApiService.selectByPrimaryKey(id);
            return ResultResponse.makeOKRsp(tbApi);
        } catch (Exception e) {
            throw new MyException("9999", "服务器异常");
        }

    }

    @PostMapping("/page")
    @ApiOperation("分页")
    public Result<?> page(@RequestBody TbApi tbApi) {
        try {
            List<TbApi> page = tbApiService.page(tbApi);
            return ResultResponse.makeOKRsp(page);
        } catch (Exception e) {
            throw new MyException("9999", "服务器异常");
        }

    }

    @PutMapping
    @ApiOperation("修改")
    public Result<?> put(@RequestBody TbApi tbApi) {
        try {
            tbApiService.updateByPrimaryKey(tbApi);
            return ResultResponse.makeOKRsp();
        } catch (Exception e) {
            throw new MyException("9999", "服务器异常");
        }

    }

    @ApiOperation("删除")
    @DeleteMapping({"/{id}"})
    public Result<?> delete(@PathVariable int id) {
        try {
            tbApiService.deleteByPrimaryKey(id);
            return ResultResponse.makeOKRsp();
        } catch (Exception e) {
            throw new MyException("9999", "服务器异常");
        }

    }

    @ApiOperation("新增")
    @PostMapping
    public Result<?> add(@RequestBody TbApi tbApi) {
        try {
            tbApiService.insert(tbApi);
            return ResultResponse.makeOKRsp();
        } catch (Exception e) {
            throw new MyException("9999", "服务器异常");
        }

    }


}

