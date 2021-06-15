package com.example.service.impl;

import com.example.service.ITranslateService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TranslateServiceImpl implements ITranslateService {
    private static Map<String,String> dictionary;
    static {
        dictionary=new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");
    }
    @Override
    public String translate(String search) {
        String result=dictionary.get(search);
        String msg="not found";
        if(result!=null){
            return result;
        }else {
            return msg;
        }
    }
}
