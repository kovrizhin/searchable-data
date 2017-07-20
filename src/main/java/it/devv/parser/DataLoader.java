package it.devv.parser;

import it.devv.data.Data;

import java.util.List;

/**
 * Created by oleg on 7/20/17.
 */
public interface DataLoader {

    List<Data> loadData(String fileName);
}
