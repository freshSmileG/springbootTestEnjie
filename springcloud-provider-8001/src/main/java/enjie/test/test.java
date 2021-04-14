package enjie.test;

import enjie.utils.HttpUtil;

import java.util.HashMap;
import java.util.Map;

public class test {
    public  String httpClientTest() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("id", "2");
        String url = "http://localhost:8001/selectById";
        String str = HttpUtil.doGet(url, param);
        return str;
    }
}