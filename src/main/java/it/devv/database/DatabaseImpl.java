package it.devv.database;

import it.devv.data.Data;
import it.devv.parser.DataLoader;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by oleg on 7/20/17
 *
 * Implementation of database for providing raw data for search engine
 */
@Service
@Scope("singleton")
public class DatabaseImpl implements Database {

    private final DataLoader dataLoader;

    @Value("${search.data}")
    private String fileName;
    private List<Data> data;

    @Autowired
    public DatabaseImpl(DataLoader dataLoader) {
        this.dataLoader = dataLoader;
    }

    @PostConstruct
    private void init() throws FileNotFoundException {
        data = dataLoader.loadData(fileName);
    }

    @Override
    @NotNull
    public List<Data> getAllData() {
        return data;
    }
}
