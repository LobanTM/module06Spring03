package com.loban.spring.controller;

import com.loban.spring.dao.ManufacturerDao;
import com.loban.spring.dao.ProductDao;
import com.loban.spring.model.Manufacturer;
import com.loban.spring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ManufacturerDao manufacturerDao;

//    LIST
    @RequestMapping(value = "/admin/product/list", method = RequestMethod.GET)
    public ModelAndView productsListAdmin(){
        return new ModelAndView("adminProductList")
                .addObject("productsList", productDao.findAll());
    }

    @RequestMapping(value = "/user/product/list", method = RequestMethod.GET)
    public ModelAndView productsListUser(){
        return new ModelAndView("userProductList")
                .addObject("productsList", productDao.findAll());
    }

//    ADD
    @RequestMapping(value = "/admin/product/add", method = RequestMethod.GET)
    public ModelAndView productAddGet(){
        return new ModelAndView("adminProductAdd")
                .addObject("addProduct", new Product())
                .addObject("manufS", manufacturerDao.findAll());
    }

    @RequestMapping(value = "/admin/product/add", method = RequestMethod.POST)
    public ModelAndView productAddPost(@ModelAttribute("addProduct") Product product,
                                       @ModelAttribute("manufID") Long manufId){

        if (product!=null){
            Product p = productDao.findOne(product.getId());}

        product.setManufacturer(manufacturerDao.findOne(manufId));
        productDao.save(product);
        return new ModelAndView("adminProductList")
                .addObject("productsList", productDao.findAll());
    }

//    UPDATE
    @RequestMapping(value = "/admin/product/update/{id}", method = RequestMethod.GET)
    public ModelAndView productUpdateGet(@PathVariable("id") long id){
        return new ModelAndView("adminProductUpdate")
                .addObject("updateProduct", productDao.findOne(id))
                .addObject("manufS", manufacturerDao.findAll());
    }

    @RequestMapping(value = "/admin/product/update/{id}", method = RequestMethod.POST)
    public ModelAndView productUpdatePost(@ModelAttribute("updateProduct") Product product,
                                          @ModelAttribute("manufID") Long manufId){

        if (product!=null){
        Product p = productDao.findOne(product.getId());}


        product.setManufacturer(manufacturerDao.findOne(manufId));
        productDao.save(product);

        return new ModelAndView("adminProductList")
                .addObject("productsList", productDao.findAll());
    }
//    DELETE
    @RequestMapping(value = "/admin/product/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteProduct(@PathVariable("id") long id){
        Product product = productDao.findOne(id);
        if (product!=null)
            productDao.delete(id);
        return new ModelAndView("adminProductList")
                .addObject("productsList", productDao.findAll());
    }


}
