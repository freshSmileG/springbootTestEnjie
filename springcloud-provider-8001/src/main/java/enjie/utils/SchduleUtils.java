package enjie.utils;

import com.enjie.bean.Test;
import enjie.entity.Student;
import enjie.mapper.TestMapper;
import enjie.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
public class SchduleUtils {
    private int index =1;
    @Autowired
    TestMapper testMapper;

    @Autowired
    StudentService studentService;
        @Scheduled(cron = "${job.schdule}")
        public void addStudent(){
            Test test = new Test();
            Student student = new Student();
            student.setsName("学生"+index);
            student.setsBirth(DateUtils.getDate());
            student.setsDepartment("物理系");
            if (index%2==1){
                student.setsSex("男");
            }
            else{
                student.setsSex("女");
            }
            student.setsId(index);
            index++;
            //studentService.add(student);
            studentService.add(student);
            test.setId(String.valueOf(index));
            testMapper.insert(test);
        }
}
