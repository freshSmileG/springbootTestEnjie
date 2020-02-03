package com.enjie.mapper;
import org.apache.ibatis.annotations.Mapper;
import com.enjie.bean.Test;
import java.util.List;

@Mapper
public interface TestMapper {

    public List<Test> selectAll();
    public Test selectById(Test test);

}
