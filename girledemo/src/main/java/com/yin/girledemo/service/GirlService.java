package com.yin.girledemo.service;

import com.yin.girledemo.domain.Girl;
import com.yin.girledemo.enums.ResultEnum;
import com.yin.girledemo.exception.GirlException;
import com.yin.girledemo.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GirlService {
    @Autowired
    GirlRepository girlRepository;
    @Transactional
    public void insertTwo(){
        Girl girl=new Girl();
        girl.setAge(25);
        girl.setCupSize("A");
        girlRepository.save(girl);
        Girl girl2=new Girl();
        girl2.setAge(28);
        girl2.setCupSize("DDD");
        girlRepository.save(girl2);
    }


    public void getAge(Integer id) throws Exception {
       Girl girl =  girlRepository.findById(id).get();
        Integer age=girl.getAge();
        if (age<12){
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age>=12 && age<18){
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }
}
