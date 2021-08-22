package com.atm.atmloc.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.springframework.util.CollectionUtils;


public class ConvertUtils {
	
	private ConvertUtils() {}

	/**
	   * Converts into Map with given Function as key and value as object.
	   */
	  public static <K, T> Map<K, T> convertToMap(List<T> objects, Function<T, K> keyFunction) {
	    Map<K, T> result = new HashMap<>();
	    if (CollectionUtils.isEmpty(objects)) {
	      return result;
	    }
	    objects.forEach(o -> result.put(keyFunction.apply(o), o));
	    return result;
	  }

	  /**
	   * Converts into Map with given Function as key and value as list of objects.
	   */
	  public static <K, T> Map<K, List<T>> convertToMapWithList(List<T> objects, Function<T, K> keyFunction) {
	    Map<K, List<T>> result = new HashMap<>();
	    if (CollectionUtils.isEmpty(objects)) {
	      return result;
	    }
	    for (T object : objects) {
	      List<T> objectList = result.getOrDefault(keyFunction.apply(object), new ArrayList<>());
	      objectList.add(object);
	      result.put(keyFunction.apply(object), objectList);
	    }
	    return result;
	  }
	  

}
