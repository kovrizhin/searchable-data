package it.devv.engine;

import it.devv.data.Query;
import org.jetbrains.annotations.NotNull;

/**
 * Created by oleg on 7/20/17
 */
public interface SearchQueryParser {

    /**
     * @param searchQuery raw string for search request
     * @return prepared query for search engine
     */
    @NotNull
    Query parse(@NotNull String searchQuery);
}
