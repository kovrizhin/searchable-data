package it.devv.engine;

import it.devv.data.Query;
import it.devv.processor.StringProcessor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static it.devv.constant.RegexpConstant.*;

/**
 * Created by oleg on 7/20/17
 *
 * Implementation of SearchQueryParser
 */
@Service
public class SearchQueryParserImpl implements SearchQueryParser {

    private final StringProcessor stringProcessor;

    @Autowired
    public SearchQueryParserImpl(StringProcessor stringProcessor) {
        this.stringProcessor = stringProcessor;
    }

    /**
     * @param searchQuery raw string for search request
     * @return prepared query data for search engine
     */
    @NotNull
    @Override
    public Query parse(@NotNull String searchQuery) {
        return new Query(stringProcessor.parseIncludeString(searchQuery), stringProcessor.parseExcludeString(searchQuery));
    }

}
