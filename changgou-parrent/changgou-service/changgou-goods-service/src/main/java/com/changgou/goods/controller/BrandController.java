package com.changgou.goods.controller;

import com.changgou.goods.service.BrandService;
import com.changgou.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description: <br/>
 * date: 2020/9/10 0:33<br/>
 *
 * @author MuyerJ<br   />
 */
@RestController
@RequestMapping(value = "/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping
    public List<Brand> findAll() {
        return brandService.findAll();
    }
}
