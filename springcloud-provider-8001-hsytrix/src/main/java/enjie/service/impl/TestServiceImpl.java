package enjie.service.impl;
import com.enjie.bean.Test;
import enjie.mapper.TestMapper;
import enjie.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;
    public List<Test> selectAll() {
        return testMapper.selectAll();
    }

    public Test selectById(Test test) {
        return testMapper.selectById(test);
    }
}
