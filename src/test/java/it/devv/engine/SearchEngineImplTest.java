package it.devv.engine;

import it.devv.data.Data;
import it.devv.data.Query;
import it.devv.database.Database;
import it.devv.parser.DataLoader;
import it.devv.processor.BuildDataProcessor;
import it.devv.processor.StringProcessor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleg on 7/20/17
 */
@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class SearchEngineImplTest {

    @Autowired
    private SearchEngine searchEngine;

    @Test
    public void searchOnlyOneInclude() throws Exception {
        Set<Data> data = searchEngine.search(new Query(new String[]{"a+"}, new String[]{}));
        assertEquals(data.size(), 1);
        Data[] ts = data.toArray(new Data[data.size()]);
        assertEquals("A+", ts[0].getName());
        assertEquals("Array", ts[0].getType());
        assertEquals("Arthur Whitney",ts[0].getDesignedBy());
    }

    @Test
    public void searchTwoInclude() throws Exception {
        Set<Data> data = searchEngine.search(new Query(new String[]{"Procedural"}, new String[]{}));
        assertEquals(2, data.size());
    }

    @Test
    public void searchOneIncludeExclude() throws Exception {
        Set<Data> data = searchEngine.search(new Query(new String[]{"Procedural"}, new String[]{"ada"}));
        assertEquals(1, data.size());
        Data[] ts = data.toArray(new Data[data.size()]);
        assertEquals(1, data.size());
        assertEquals("ActionScript", ts[0].getName());
    }

    @Test
    public void searchZero() throws Exception {
        assertEquals(0, searchEngine.search(new Query(new String[]{""}, new String[]{"ada"})).size());
        assertEquals(0, searchEngine.search(new Query(new String[]{""}, new String[]{""})).size());
        assertEquals(0, searchEngine.search(new Query(new String[]{"kdfnmlh"}, new String[]{""})).size());
        assertEquals(0, searchEngine.search(new Query(new String[]{"kdfnmlh"}, new String[]{"sdfdsvsd"})).size());

    }
}