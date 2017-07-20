package it.devv.processor;

import it.devv.data.Data;
import it.devv.database.Database;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by oleg on 7/20/17.
 */
@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class BuildDataProcessorImplTest {
    @Autowired
    private BuildDataProcessor dataProcessor;

    @Autowired
    private Database database;
    @Test
    public void buildEngineData() throws Exception {
        Map<Integer, Set<Data>> integerSetMap = dataProcessor.buildEngineData(database.getAllData());
        assertEquals(20, integerSetMap.size());
        assertEquals(1, integerSetMap.get("ADA".hashCode()).size());
        assertNull(integerSetMap.get("ada".hashCode()));
        assertEquals("Ada", integerSetMap.get("ADA".hashCode()).toArray(new Data[1])[0].getName());
        assertEquals(2, integerSetMap.get("PROCEDURAL".hashCode()).size());
    }

}