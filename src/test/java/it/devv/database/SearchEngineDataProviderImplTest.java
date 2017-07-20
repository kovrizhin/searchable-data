package it.devv.database;

import it.devv.engine.SearchEngine;
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
public class SearchEngineDataProviderImplTest {

    @Autowired
    private SearchEngineDataProvider searchEngineDataProvider;
    @Test
    public void getSearchEngineData() throws Exception {
        assertEquals(searchEngineDataProvider.getSearchEngineData().size(), 20);
    }

}