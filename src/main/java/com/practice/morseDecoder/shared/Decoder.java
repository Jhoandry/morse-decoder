package com.practice.morseDecoder.shared;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Decoder {

    public String decodeMorse(String input) {
        List<String> values = formatElements(input);
        Map<String, Definition> uniqValues = getUniqueValues(values);
        return buildSentence(values, uniqValues);
    }

    private String buildSentence(List<String> values, Map<String, Definition> uniqValues) {
        StringBuilder result = new StringBuilder();
        for (String value : values) {
            result.append(uniqValues.get(value).getValue());
        }

        return result.toString();
    }

    private Map<String, Definition> getUniqueValues(List<String> inputValues) {
        List<Definition> morseValues = Arrays.stream(Definition.values()).toList();

        return inputValues.stream()
                .distinct()
                .collect(Collectors.toMap(
                        code -> code,
                        code -> getMorseElement(code, morseValues)
                ));
    }


    private Definition getMorseElement(String code, List<Definition> morseValues) {
        for (Definition definition : morseValues) {
            if (definition.getCode().equals(code)) {
                return definition;
            }
        }
        return Definition.NONE;
    }

    private List<String> formatElements(String input) {
        return Arrays.stream(input.split(" ")).map(code -> {
            if (code.equals(" ")) {
                return code;
            }

            return code.trim();
        }).toList();
    }
}
