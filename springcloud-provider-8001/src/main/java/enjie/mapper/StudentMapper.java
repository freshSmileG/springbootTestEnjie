package enjie.mapper;

import enjie.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {

    public int add(Student student);

}
