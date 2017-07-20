package it.devv.processor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by oleg on 7/20/17.
 */
@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class StringProcessorImplTest {
    @Autowired
    private StringProcessor stringProcessor;

    @Test
    public void parseIncludeString() throws Exception {
        assertArrayEquals(new String[]{"test", "estest", "c#"}, stringProcessor.parseIncludeString("test, estest -setest, c#"));
        assertArrayEquals(new String[]{"test1", "tes2++", "test3#"}, stringProcessor.parseIncludeString("test1, tes2++, ? test3# -test4"));
    }

    @Test
    public void parseExcludeString() throws Exception {
        assertArrayEquals(new String[]{"setest"}, stringProcessor.parseExcludeString("test, estest -setest, c#"));
        assertArrayEquals(new String[]{"test4"}, stringProcessor.parseExcludeString("test1, tes2++, ? 1 test3# -test4"));

    }

    @Test
    public void normalize() throws Exception {
        assertArrayEquals(new String[]{"TEST"}, stringProcessor.normalize("test,"));
        assertArrayEquals(new String[]{"TEST", "ESTEST", "-SETEST", "C#"}, stringProcessor.normalize("test, estest -setest, c#"));
        assertArrayEquals(new String[]{"TEST1", "TES2++", "EST3#", "-TEST4"}, stringProcessor.normalize("test1, tes2++, ? ! est3# -test4"));

    }

}