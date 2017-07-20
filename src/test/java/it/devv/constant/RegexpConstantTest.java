package it.devv.constant;


import org.junit.Test;

import static it.devv.constant.RegexpConstant.REMOVE_ALL_EXCLUDE_CASE_REGEXP;
import static it.devv.constant.RegexpConstant.REMOVE_ALL_SPECIAL_SYMBOLS_REGEXP;
import static it.devv.constant.RegexpConstant.SPLIT_BY_SPACES_REGEXP;
import static org.junit.Assert.*;

/**
 * Created by oleg on 7/20/17.
 */
public class RegexpConstantTest {

    @Test
    public void test_REMOVE_ALL_SPECIAL_SYMBOLS_REGEXP(){
        String s1 = "test, t++, c#, c-c, -asd !@@%";
        assertEquals(s1.replaceAll(REMOVE_ALL_SPECIAL_SYMBOLS_REGEXP,"").trim(), "test t++ c# c-c -asd");
    }

    @Test
    public void test_REMOVE_ALL_EXCLUDE_CASE(){
        String s1 = "test, t++, c#, c-c, -asd !@@%";
        assertEquals(s1.replaceAll(REMOVE_ALL_EXCLUDE_CASE_REGEXP,"").trim(), "test, t++, c#, c-c, !@@%");
    }

    @Test
    public void test_SPLIT_BY_SPACES_REGEXP(){
        String s1 = "test, t++, c#, c-c,    -asd !@@%";
        String[] exp = new String[]{"test,", "t++,", "c#,", "c-c,", "-asd","!@@%"};
        String[] split = s1.split(SPLIT_BY_SPACES_REGEXP);
        assertArrayEquals(split, exp);
    }

}