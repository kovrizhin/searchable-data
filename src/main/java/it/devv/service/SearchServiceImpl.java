package it.devv.service;

import it.devv.data.Data;
import it.devv.data.Query;
import it.devv.database.SearchEngineDataProvider;
import it.devv.engine.SearchEngine;
import it.devv.engine.SearchQueryParser;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

/**
 * Created by oleg on 7/20/17
 */
@Service
public class SearchServiceImpl implements SearchService {
    private final SearchQueryParser searchQueryParser;

    private final SearchEngine searchEngine;

    @Autowired
    public SearchServiceImpl(SearchQueryParser searchQueryParser, SearchEngine searchEngine) {
        this.searchQueryParser = searchQueryParser;
        this.searchEngine = searchEngine;
    }


    @NotNull
    @Override
    public Set<Data> search(@NotNull String searchString) {
        Query query = searchQueryParser.parse(searchString);
        return searchEngine.search(query);
    }
}
