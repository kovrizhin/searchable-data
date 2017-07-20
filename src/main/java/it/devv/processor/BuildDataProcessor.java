package it.devv.processor;

import it.devv.data.Data;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by oleg on 7/20/17
 * <br/>
 * Interface for transform raw data to prepared data for seach engine
 */

public interface BuildDataProcessor {
    /**
     * @param data raw data for search engine
     * @return prepared data for seach engine
     */
    @NotNull
    Map<Integer, Set<Data>> buildEngineData(@NotNull List<Data> data);
}
