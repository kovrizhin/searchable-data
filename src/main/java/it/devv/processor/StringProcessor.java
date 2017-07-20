package it.devv.processor;

import org.jetbrains.annotations.NotNull;

/**
 * Created by oleg on 7/20/17
 * <p>
 * Interface for parcing and tranform Strings
 */
public interface StringProcessor {
    /**
     * @param str input string
     * @return string array in upper case
     */
    @NotNull String[] normalize(@NotNull String str);

    /**
     * @param searchQuery search string
     * @return strings which we should include to search request
     */
    @NotNull String[] parseIncludeString(@NotNull String searchQuery);

    /**
     * @param searchQuery search string
     * @return strings which we should exclude to search request
     */
    @NotNull String[] parseExcludeString(@NotNull String searchQuery);
}
