package com.ababil.common.actions.maps;

import java.util.HashMap;
import java.util.Map;

public class StorageMaps {
    private static Map<String, Map<String, String>> paramsMap = new HashMap<>();

    public static Map<String, Map<String, String>> getParamsMap() {
        return paramsMap;
    }

    public static void setParamsMapValue(String paramMapName, String paramKeyName, String paramKeyValue){
        if(!getParamsMap().containsKey(paramMapName)){
            getParamsMap().put(paramMapName, new HashMap<>());
        }
        getParamsMap().get(paramMapName).put(paramKeyName, paramKeyValue);
    }

    public static String getParamsMapValue(String paramMapName, String paramKeyName){
        if(!getParamsMap().containsKey(paramMapName)){
            return null;
        }
        return getParamsMap().get(paramMapName).getOrDefault(paramKeyName, null);
    }
}
