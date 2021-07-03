package com.changgou.goods.service;

import com.changgou.pojo.Brand;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Description: <br/>
 * date: 2020/9/10 0:31<br/>
 *
 * @author MuyerJ<br   />
 */
public interface BrandService {

    void update(Brand brand);

    void add(Brand brand);

    /**
     * 查询所有
     * @return
     */
    List<Brand> findAll();

    /**
     * 更加id查询
     */
    Brand findById(Integer id);

    void delete(Integer id);

    /**
     * 根据条件分页查询
     * @param page
     * @param size
     * @param brand
     * @return
     */
    PageInfo<Brand> findPages(Integer page, Integer size, Brand brand);
}
