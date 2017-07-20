package it.devv.constant;

/**
 * Created by oleg on 7/20/17
 * </br>
 * This class contains constants for REGEXP expression
 */
public interface RegexpConstant {
    String REMOVE_ALL_SPECIAL_SYMBOLS_REGEXP = "[^0-9a-zA-Z\\s\\#\\+\\-]+";
    String SPLIT_BY_SPACES_REGEXP = "\\s+";
    String REMOVE_ALL_EXCLUDE_CASE_REGEXP = "(\\s\\-[0-9a-zA-Z\\#\\+\\-]+)";
    String FIND_ALL_EXCLUDE_CASE_REGEXP = "(?<=(\\s)[\\-])([0-9a-zA-Z\\#\\+\\-]+)";
}
