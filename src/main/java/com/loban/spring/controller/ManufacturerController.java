package com.loban.spring.controller;

import com.loban.spring.dao.ManufacturerDao;
import com.loban.spring.model.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManufacturerController {

    @Autowired
    private ManufacturerDao manufacturerDao;

//    LIST
    @RequestMapping(value = "/admin/manufacturer/list", method = RequestMethod.GET)
    public ModelAndView manufacturerListGetAdmin(){
        return new ModelAndView("adminManufacturerList")
                .addObject("manufList", manufacturerDao.findAll());

    }
    @RequestMapping(value = "/user/manufacturer/list", method = RequestMethod.GET)
    public ModelAndView manufacturerListGetUser(){
        return new ModelAndView("userManufacturerList")
                .addObject("manufList", manufacturerDao.findAll());

    }

//    ADD
    @RequestMapping(value = "/admin/manufacturer/add", method = RequestMethod.GET)
    public ModelAndView manufacturerAddGet(){
        return new ModelAndView("adminManufacturerAdd")
                .addObject("addManuf", new Manufacturer());
    }

    @RequestMapping(value = "/admin/manufacturer/add", method = RequestMethod.POST)
    public ModelAndView manufacturerAddPost(@ModelAttribute ("addManuf") Manufacturer manufacturer){
        manufacturerDao.save(manufacturer);
        return new ModelAndView("adminManufacturerList")
                .addObject("manufList", manufacturerDao.findAll());
    }

//    UPDATE
    @RequestMapping(value = "/admin/manufacturer/update/{id}", method = RequestMethod.GET)
    public ModelAndView manufacturerUpdate(@PathVariable("id") long id){
        return new ModelAndView("adminManufacturerUpdate")
            .addObject("updateManuf", manufacturerDao.findOne(id));
}

    @RequestMapping(value = "/admin/manufacturer/update/{id}", method = RequestMethod.POST)
    public ModelAndView manufacturerUpdatePost(@ModelAttribute ("updateManuf") Manufacturer manufacturer){
        manufacturerDao.save(manufacturer);
        return new ModelAndView("adminManufacturerList")
                .addObject("manufList", manufacturerDao.findAll());
    }

//    DELETE
    @RequestMapping(value = "/admin/manufacturer/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteManufacturer(@PathVariable("id") long id){
        Manufacturer manufacturer = manufacturerDao.findOne(id);
        if (manufacturer!=null)
            manufacturerDao.delete(id);
        return new ModelAndView("adminManufacturersList")       //куда переходить
                .addObject("manufList", manufacturerDao.findAll())
                ;
    }


}
