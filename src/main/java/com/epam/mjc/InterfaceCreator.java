package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            System.out.println(x);
            boolean isCorrect = true;
            for (int i = 0; i < x.size(); i++) {
                String get = x.get(i);
                get = get.toUpperCase();
                if (!get.equals(x.get(i))) {
                    isCorrect = false;
                }
            }
            return isCorrect;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < x.size(); i++) {
                int get = x.get(i);
                if (get % 2 == 0) {
                    list.add(get);
                }
            }
            for (int i = 0; i < list.size(); i++) {
                x.add(list.get(i));
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> returnList = new ArrayList<>();
            for (int i = 0; i < values.size(); i++) {
                String get = values.get(i);
                if (get.contains(".")) {

                    StringTokenizer stringTokenizer = new StringTokenizer(get, " ");
                    int k = 0;
                    while (stringTokenizer.hasMoreTokens()) {
                        k++;
                        stringTokenizer.nextToken();
                    }
                    if (k > 3) {
                        char[] getInChars = get.toCharArray();
                        String firstInUpperCase = String.valueOf(getInChars[0]);
                        firstInUpperCase = firstInUpperCase.toUpperCase();
                        if (firstInUpperCase.equals(String.valueOf(getInChars[0]))) {
                            returnList.add(get);
                        }
                    }
                }
            }
            return returnList;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            List<String> sourceList = new ArrayList<>(x);
            Map<String, Integer> returnMap = new HashMap<>();

            for (int i = 0; i < sourceList.size(); i++) {
                String get = sourceList.get(i);
                int getLength = get.length();
                returnMap.put(get, getLength);
            }
            return returnMap;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> returnList = new ArrayList<>(list1);
            for (int i = 0; i < list2.size(); i++) {
                returnList.add(list2.get(i));
            }
            return returnList;
        };
    }
}
