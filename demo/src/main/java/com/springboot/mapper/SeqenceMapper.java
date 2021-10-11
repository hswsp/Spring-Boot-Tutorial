package com.springboot.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SeqenceMapper {
    @Select("select nextval('${seqName}')")
    Long getSequence(@Param("seqName") String seqName);
}