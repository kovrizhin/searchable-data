package it.devv.database;

import it.devv.data.Data;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created by oleg on 7/20/17
 * <br/>
 *
 * Interface for taking raw data for search engine
 */
public interface Database {

    @NotNull
    List<Data> getAllData();
}
