package it.devv.engine;

import it.devv.data.Query;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleg on 7/20/17
 */
@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class SearchQueryParserImplTest {
    @Autowired
    private SearchQueryParser searchQueryParser;
    @Test
    public void parse() throws Exception {
        Query test = searchQueryParser.parse("test");
        assertEquals(1, test.getIncludeWords().length);
        assertEquals(0, test.getExcludeWords().length);
        assertEquals("test", test.getIncludeWords()[0]);

        test = searchQueryParser.parse("test -array  -verg sdg#");
        assertEquals(2, test.getIncludeWords().length);
        assertEquals(2, test.getExcludeWords().length);
        assertEquals("test", test.getIncludeWords()[0]);
        assertEquals("sdg#", test.getIncludeWords()[1]);
        assertEquals("array", test.getExcludeWords()[0]);
        assertEquals("verg", test.getExcludeWords()[1]);
    }

    @Test
    public void complexCase(){
        Query test = searchQueryParser.parse("test-wer");
        assertEquals("test-wer", test.getIncludeWords()[0]);
        assertEquals(0, test.getExcludeWords().length);
    }

}