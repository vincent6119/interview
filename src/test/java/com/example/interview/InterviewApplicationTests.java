package com.example.interview;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class InterviewApplicationTests {

    public void matcherRemove(String input){
        Pattern pattern = Pattern.compile("([a-z])\\1{2}");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find())
        {
            input = matcher.replaceAll("");
            System.out.println(input);
            matcherRemove(input);
        }
    }

    public void matcherReplace(String input){
        Pattern pattern = Pattern.compile("([a-z])\\1{2}");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find())
        {
            StringBuffer sb = new StringBuffer(input);
            if(matcher.start() == 0){
                sb.replace(matcher.start(), matcher.end(), "");
                System.out.println(sb);
            }else{
                String rep = sb.substring(matcher.start()-1,matcher.start());
                sb.replace(matcher.start()-1,matcher.end(),rep);
                System.out.println(sb + "," + matcher.group() + " is replace by " + rep);
            }
            matcherReplace(sb.toString());
        }
    }

    @Test
    void testReplace(){
        String str = "aabcccbbad";
        matcherReplace(str);
    }

    @Test
    void testRemove(){
        String str = "aabcccbbad";
        matcherRemove(str);
    }

}
