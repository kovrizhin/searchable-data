package it.devv.database;

import it.devv.data.Data;
import it.devv.processor.BuildDataProcessor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Set;

/**
 * Created by oleg on 7/20/17
 * </br>
 *
 * This class provide prepare data for search engine
 */
@Service
@Scope("singleton")
public class SearchEngineDataProviderImpl implements SearchEngineDataProvider {

    private final Database database;

    private final BuildDataProcessor buildDataProcessor;

    private Map<Integer, Set<Data>> data;

    @Autowired
    public SearchEngineDataProviderImpl(Database database, BuildDataProcessor buildDataProcessor) {
        this.database = database;
        this.buildDataProcessor = buildDataProcessor;
    }

    @PostConstruct
    private void init(){
        data = buildDataProcessor.buildEngineData(database.getAllData());
    }

    /**
     * @return prepared data for search engine
     */
    @NotNull
    @Override
    public Map<Integer, Set<Data>> getSearchEngineData() {
        return data;
    }
}
