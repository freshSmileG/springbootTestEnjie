package com.enjie.service;


import com.enjie.bean.Test;

import java.util.List;

public interface TestService {
    public List<Test> selectAll();
    public Test selectById(Test test);

}
