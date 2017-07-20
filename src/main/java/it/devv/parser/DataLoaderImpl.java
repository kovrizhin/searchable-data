package it.devv.parser;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import it.devv.data.Data;
import it.devv.exception.DevvRuntimeException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by oleg on 7/20/17
 */
@Component
public class DataLoaderImpl implements DataLoader {
    private static final Logger logger = LogManager.getLogger(DataLoader.class);
    @Override
    public List<Data> loadData(String fileName) {
        try {
            Type listType = new TypeToken<ArrayList<Data>>(){}.getType();
            return Optional.ofNullable(this.getClass().getResourceAsStream(fileName))
                    .map(it -> new Gson().<List<Data>>fromJson(new InputStreamReader(it), listType))
                    .orElse(new ArrayList<>());

        } catch (JsonParseException e) {
            logger.log(Level.ERROR, e);
            throw new DevvRuntimeException("Can't parse input data file");
        }
    }
}
