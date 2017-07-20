package it.devv.engine;

import it.devv.data.Data;
import it.devv.data.Query;
import it.devv.database.SearchEngineDataProvider;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by oleg on 7/20/17
 * </br>
 * Implementaion of search engine here is used hash codes as a key for words
 */
@Service
public class SearchEngineImpl implements SearchEngine {

    @Autowired
    private SearchEngineDataProvider provider;

    @Override
    @NotNull
    public Set<Data> search(@NotNull Query query) {
        Set<Data> removeSet = concatData(query.getExcludeWords(), provider.getSearchEngineData());
        Set<Data> findSet = findData(query.getIncludeWords(), provider.getSearchEngineData());
        findSet.removeAll(removeSet);
        return findSet;
    }

    /**
     * Return concatenated data which founded in input data using hash function from search data
     *
     * @param searchData possible to be empty list
     * @param data possible to be empty
     * @return new set of data
     */
    @NotNull
    private Set<Data> concatData(@NotNull String[] searchData, @NotNull Map<Integer, Set<Data>> data) {
        return Stream.of(searchData)
                .map(String::toUpperCase)
                .map(String::hashCode)
                .map(data::get)
                .filter(Objects::nonNull)
                .map(HashSet::new)
                .reduce((s1, s2) -> {
                    s1.addAll(s2);
                    return s1;
                })
                .orElse(new HashSet<>());
    }


    /**
     * Return retail data which founded in input data using hash function from search data
     *
     * @param searchData possible to be empty list
     * @param data possible to be empty
     * @return new set of data
     */
    @NotNull
    private Set<Data> findData(@NotNull String[] searchData, @NotNull Map<Integer, Set<Data>> data) {
        return Stream.of(searchData)
                .map(String::toUpperCase)
                .map(String::hashCode)
                .map(data::get)
                .filter(Objects::nonNull)
                .map(HashSet::new)
                .reduce((s1, s2) -> {
                    s1.retainAll(s2);
                    return s1;
                })
                .orElse(new HashSet<>());
    }
}
