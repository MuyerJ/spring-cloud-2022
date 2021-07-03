package com.changgou.goods.controller;

import com.changgou.goods.service.BrandService;
import com.changgou.pojo.Brand;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description:
 * date: 2020/9/10 0:33
 *
 * @author MuyerJ
 */
@RestController
@RequestMapping(value = "/brand")
/**
 * 跨域:
 *  域名、端口、协议不一致的时候就跨越了
 */
@CrossOrigin
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping
    public Result<List<Brand>> findAll() {
        return new Result<>(true, StatusCode.OK, "findAll success", brandService.findAll());
    }

    @GetMapping("/{id}")
    public Result<Brand> findById(@PathVariable("id") Integer id) {
        Brand brand = brandService.findById(id);
        return new Result<>(true, StatusCode.OK, "根据id查询brand成功", brand);
    }


    @PostMapping("delete/{id}")
    public Result delete(@PathVariable("id") Integer id) {
        brandService.delete(id);
        return new Result<>(true, StatusCode.OK, "delete success");
    }

    @PostMapping("update/{id}")
    public Result update(@PathVariable("id") Integer id, @RequestBody Brand brand) {
        brand.setId(id);
        brandService.update(brand);
        return new Result<>(true, StatusCode.OK, "update success");
    }

    @PostMapping("/add")
    public Result add(@RequestBody Brand brand) {
        brandService.add(brand);
        return new Result<>(true, StatusCode.OK, "add success");
    }

    /**
     * 条件+分页搜索
     */
    @PostMapping("/list/{page}/{size}")
    public Result<PageInfo<Brand>> findPages(@PathVariable("page") Integer page, @PathVariable("size") Integer size, @RequestBody Brand brand) {
        PageInfo<Brand> list = brandService.findPages(page, size, brand);
        return new Result<PageInfo<Brand>>(true, StatusCode.OK, "findPages success", list);
    }
}
