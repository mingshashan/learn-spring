package com.mingshashan.learn.learnmybatis.converter;

import com.mingshashan.learn.learnmybatis.entity.Test02;
import com.mingshashan.learn.learnmybatis.vo.Test02VO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TestMapStruct {

    TestMapStruct INSTANCE = Mappers.getMapper(TestMapStruct.class);

    Test02 TestVO2Entity(Test02VO test02VO);
}
