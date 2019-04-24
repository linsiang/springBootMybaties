package com.gnnu.springbootmybaties.service;

import com.gnnu.springbootmybaties.mapper.PoetryMapper;
import com.gnnu.springbootmybaties.pojo.Poetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoetryService {
       @Autowired
       PoetryMapper poetryMapper ;

      public List<Poetry> findAll(){
          return poetryMapper.findall();
      };

    public int deletePoetryById(String poetryId) {
        return poetryMapper.deletePoetryById(poetryId);
    }

    public Poetry findById(String poetryId) {
        return poetryMapper.findById(poetryId);
    }

    public int editPoetry(Poetry poetry) {
        return poetryMapper.editPoetry(poetry);
    }

    public int addPoetry(Poetry poetry) {
        return poetryMapper.addPoetry(poetry);
    }
}
