package com.mingshashan.learn.learnmybatis.service;

import com.mingshashan.learn.learnmybatis.converter.TestMapStruct;
import com.mingshashan.learn.learnmybatis.entity.Test02;
import com.mingshashan.learn.learnmybatis.entity.Test02Example;
import com.mingshashan.learn.learnmybatis.mapper.Test02Mapper;
import com.mingshashan.learn.learnmybatis.vo.Test02VO;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private final Test02Mapper test02Mapper;

    public TestService(Test02Mapper test02Mapper) {
        this.test02Mapper = test02Mapper;
    }


    public void saveTest(Test02VO test02VO) {
        Test02 test = TestMapStruct.INSTANCE.TestVO2Entity(test02VO);

        int result = test02Mapper.insert(test);

    }


}
