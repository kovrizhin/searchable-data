package it.devv.engine;

import it.devv.data.Data;
import it.devv.data.Query;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

/**
 * Created by oleg on 7/20/17
 */

public interface SearchEngine {
    @NotNull Set<Data> search(@NotNull Query query);
}
