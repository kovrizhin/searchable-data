package it.devv.parser;

import it.devv.data.Data;
import it.devv.exception.DevvRuntimeException;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.*;

/**
 * Created by oleg on 7/20/17.
 */
public class DataLoaderImplTest {
    @Test
    public void loadData() throws Exception {
        List<Data> data = new DataLoaderImpl().loadData("/data-test1.json");
        assertEquals(data.size(), 3);
        assertEquals(data.get(0).getName(), "A+");
        assertEquals(data.get(0).getType(), "Array");
        assertEquals(data.get(0).getDesignedBy(), "Arthur Whitney");
    }
}