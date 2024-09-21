package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return str -> str.get(0).matches("[A-Z]+");
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        List<Integer> evens = new ArrayList<>();
        return num -> {
            for(var val: num) {
                if (val % 2 == 0) {
                    evens.add(val);
                }
            }
            num.addAll(evens);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        List<String> results = new ArrayList<>();
        return () -> {
            for(String val: values) {
                var startValidation = Character.isUpperCase(val.charAt(0));
                var endValidation = val.endsWith(".");
                var lengthValidation = val.split("\\s+").length > 3;

                if (startValidation && endValidation && lengthValidation) {
                    results.add(val);
                }
            }
            return results;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return val -> {
            Map<String, Integer> map = new HashMap<>();
            for (String str: val) {
                map.put(str, str.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (firstList, secondList) -> {
            List<Integer> list = new ArrayList<>(firstList);
            list.addAll(secondList);
            return list;
        };
    }
}
