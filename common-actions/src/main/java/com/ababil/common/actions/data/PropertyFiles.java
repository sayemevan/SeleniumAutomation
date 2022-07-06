package com.ababil.common.actions.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyFiles {

    private static Map<String, Properties> propertiesMap = new HashMap<>();

    public static void setPropertyFile(String propertyFileName, Properties loadedPropertyFile){
        propertiesMap.put(propertyFileName, loadedPropertyFile);
    }

    public static Properties getPropertyFile(String propertyFileName){
        return propertiesMap.getOrDefault(propertyFileName, null);
    }
}
