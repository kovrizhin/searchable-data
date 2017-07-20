package it.devv.database;

import it.devv.data.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

/**
 * Created by oleg on 7/20/17
 * <br/>
 * Interface for providing prepare data for search engine
 */

public interface SearchEngineDataProvider {
    /**
     * @return prepared data for search engine
     */
    @NotNull
    Map<Integer, Set<Data>> getSearchEngineData();
}
