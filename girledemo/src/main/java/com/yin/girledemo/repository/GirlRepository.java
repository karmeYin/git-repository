package com.yin.girledemo.repository;

import com.yin.girledemo.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GirlRepository  extends JpaRepository<Girl,Integer>{
}
