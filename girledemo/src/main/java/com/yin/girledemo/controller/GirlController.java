package com.yin.girledemo.controller;

import com.yin.girledemo.domain.Girl;
import com.yin.girledemo.domain.Result;
import com.yin.girledemo.repository.GirlRepository;
import com.yin.girledemo.service.GirlService;
import com.yin.girledemo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {
    private static final Logger log= LoggerFactory.getLogger(GirlController.class);
    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;
    @GetMapping(value = "/girls")
    public List<Girl> getGirlList(){
        log.warn("girllist");
        return girlRepository.findAll();
    }
    @DeleteMapping (value = "/girls/{id}")
    public List<Girl> delGirlBySize(@PathVariable("id")Integer cupsize){
        girlRepository.deleteById(cupsize);
        return girlRepository.findAll();
    }
    @PostMapping(value = "/girls")
    public Result<List<Girl>> addGirl(@RequestParam("cupSize")String cupSize, @RequestParam("age")Integer age){
        Girl girl=new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        girlRepository.save(girl);
        return ResultUtil.success(girlRepository.findAll());
    }
    @PostMapping(value = "/girls/insertTwo")
    public List<Girl> insertTwo(){
        girlService.insertTwo();
        return girlRepository.findAll();
    }
    //查询一个女生
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return girlRepository.findById(id).get();
    }
    //更新
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRepository.save(girl);
    }

    @GetMapping(value = "girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }

}
