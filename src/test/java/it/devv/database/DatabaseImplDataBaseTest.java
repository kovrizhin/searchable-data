package it.devv.database;

import it.devv.data.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleg on 7/20/17.
 */
@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class DatabaseImplDataBaseTest {
    @Autowired
    private Database database;

    @Test
    public void getAllData() throws Exception {
        List<Data> allData = database.getAllData();
        assertEquals(allData.size(), 3);
        assertEquals(allData.get(0).getName(), "A+");
        assertEquals(allData.get(0).getType(), "Array");
        assertEquals(allData.get(0).getDesignedBy(), "Arthur Whitney");
    }

}