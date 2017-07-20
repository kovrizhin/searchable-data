package it.devv.service;

import it.devv.data.Data;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

/**
 * Created by oleg on 7/20/17
 */
public interface SearchService {

    @NotNull
    Set<Data> search(@NotNull String searchString);
}
