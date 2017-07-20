package it.devv.database;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by oleg on 7/20/17.
 */
@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@TestPropertySource("classpath:wrong-application-test.properties")
public class DatabaseImplNotExistDataBaseTest {
    @Autowired
    private Database database;

    @Test
    public void getAllData() throws Exception {
        assertEquals(database.getAllData().size(), 0);
    }

}