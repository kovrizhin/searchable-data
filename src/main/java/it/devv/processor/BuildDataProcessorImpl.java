package it.devv.processor;

import it.devv.data.Data;
import it.devv.data.ParseData;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

/**
 * Created by oleg on 7/20/17
 *
 */
@Service
public class BuildDataProcessorImpl implements BuildDataProcessor {

    private static final String CONCAT_DELIMETER = ", ";
    private final StringProcessor stringProcessor;

    @Autowired
    public BuildDataProcessorImpl(StringProcessor stringProcessor) {
        this.stringProcessor = stringProcessor;
    }

    /**
     * We concatenate all string in the data by ", " and split it by spaces to array of string after
     * we take hash code from string and build a set of data where this code exist
     *
     * @param data raw data for search engine
     * @return prepared data for seach engine
     */
    @Override
    @NotNull
    public Map<Integer, Set<Data>> buildEngineData(@NotNull List<Data> data) {
        return data.parallelStream()
                .map(d -> Stream
                        .of(handleData(d))
                        .map(t -> new ParseData(t.hashCode(), d)))
                .flatMap(Function.identity())
                .collect(groupingBy(ParseData::getHash, Collectors.mapping(ParseData::getData, Collectors.toSet())));
    }

    @NotNull
    private String[] handleData(@NotNull Data d) {
        return stringProcessor.normalize((d.getType() + CONCAT_DELIMETER
                + d.getName() + CONCAT_DELIMETER
                + d.getDesignedBy()).toUpperCase());
    }
}
