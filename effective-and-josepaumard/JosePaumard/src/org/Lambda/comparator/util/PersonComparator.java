package org.Lambda.comparator.util;


@FunctionalInterface
public interface PersonComparator<T> {
    int compare (T t1, T t2);
}
