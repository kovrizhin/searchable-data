package it.devv.service;

import it.devv.data.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by oleg on 7/20/17
 */

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class SearchServiceImplTest {
    @Autowired
    private SearchService searchService;

    @Test
    public void searchTwoIncludeWord() throws Exception {
        assertEquals(1, searchService.search("Jean Ichbiah").size());
    }
    @Test
    public void searchIncludeExcludeWord() throws Exception {
        assertEquals(1, searchService.search("class-based -ada").size());

    }
    @Test
    public void searchComplexWord() throws Exception {
        assertEquals(2, searchService.search("class-based").size());

    }

    @Test
    public void doebleRemoveSearch() throws Exception {
        assertEquals(0, searchService.search("class-based -ada -ActionScript").size());
    }

}