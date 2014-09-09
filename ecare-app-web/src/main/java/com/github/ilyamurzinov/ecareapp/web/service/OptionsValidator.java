package com.github.ilyamurzinov.ecareapp.web.service;

import com.github.ilyamurzinov.ecareapp.common.domain.Option;

import java.util.Set;

/**
 * @author ilya-murzinov
 */
public class OptionsValidator {
    private OptionsValidator() {}

    public static String validate(Set<Option> options) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Option option : options) {
            for (Option requiredOption : option.getRequiredOptions()) {
                if (!options.contains(requiredOption)) {
                    stringBuilder.append("Option \"");
                    stringBuilder.append(requiredOption);
                    stringBuilder.append("\" is required for option \"");
                    stringBuilder.append(option);
                    stringBuilder.append("\"\n");
                }
            }
            for (Option incompatibleOption : option.getIncompatibleOptions()) {
                if (options.contains(incompatibleOption)) {
                    stringBuilder.append("Option \"");
                    stringBuilder.append(incompatibleOption);
                    stringBuilder.append("\" is incompatible with option \"");
                    stringBuilder.append(option);
                    stringBuilder.append("\"\n");
                }
            }
        }
        if (stringBuilder.length() != 0) {
            return stringBuilder.toString();
        }
        return null;
    }
}
