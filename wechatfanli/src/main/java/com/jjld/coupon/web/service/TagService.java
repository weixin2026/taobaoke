package com.jjld.coupon.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjld.coupon.web.entity.Tag;
import com.jjld.coupon.web.mapper.TagMapper;

@Service
public class TagService {

    @Autowired
    private TagMapper TagMapper;
 
    public List<Tag> list() {
        return TagMapper.selectAll();
    }

}
