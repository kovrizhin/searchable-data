package it.devv.processor;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static it.devv.constant.RegexpConstant.*;

/**
 * Created by oleg on 7/20/17
 */
@Service
public class StringProcessorImpl implements StringProcessor {

    /**
     * This implementation remove all spetial characters from string eg: '? ! ' ,"' , split sting by spaces and make words to upper case
     * <br/>
     * "test1, tes2++, ? 1 test3# -test4" -> ["TEST1", "TEST2++", "TEST3#", "-TEST4"]
     * @param str input string
     * @return separated words in upper case
     */
    @Override
    @NotNull
    public String[] normalize(@NotNull String str) {
        return str.toUpperCase().replaceAll(REMOVE_ALL_SPECIAL_SYMBOLS_REGEXP, "")
                .split(SPLIT_BY_SPACES_REGEXP);
    }


    /**
     * This implementation remove all spetial characters from string eg: '? ! ' ,"' , and take all words wich we should include for query
     * <br/>
     * "test1, tes2++, ? ! test3# -test4" -> ["test1", "test2++", "test3#", ]
     * @param searchQuery input string
     * @return separated words
     */
    @Override
    @NotNull
    public String[] parseIncludeString(@NotNull String searchQuery) {
        return searchQuery.replaceAll(REMOVE_ALL_EXCLUDE_CASE_REGEXP, "").replaceAll(REMOVE_ALL_SPECIAL_SYMBOLS_REGEXP, "").split(SPLIT_BY_SPACES_REGEXP);
    }

    /**
     * This implementation should return all words wich we should exclude for query
     * <br/>
     * "test1, tes2++, ? ! test3# -test4" -> ["test4"]
     * @param searchQuery input string
     * @return separated words
     */

    @Override
    @NotNull
    public String[] parseExcludeString(@NotNull String searchQuery) {
        Matcher matcher = Pattern.compile(FIND_ALL_EXCLUDE_CASE_REGEXP).matcher(searchQuery);
        ArrayList<String> excludeStrings = new ArrayList<>();
        while(matcher.find()) {
            excludeStrings.add(matcher.group());
        }
        return excludeStrings.toArray(new String[excludeStrings.size()]);
    }
}
