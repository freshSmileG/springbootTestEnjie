package enjie.mapper;
import enjie.entity.Test1;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface TestDao {
    @Insert( "<script> insert into test (id,name)  VALUES <foreach collection='list' item='item' index='index' separator=','> (#{item.id},#{item.name})</foreach></script>")
    public int add(@Param("list") List<Test1> list);
    @Select("select * from test")
    public List<Map> select();
}
