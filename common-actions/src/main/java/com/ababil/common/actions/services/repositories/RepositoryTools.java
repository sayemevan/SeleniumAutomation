package com.ababil.common.actions.services.repositories;

import java.util.Properties;

public interface RepositoryTools {

    Properties getObjectRepository(String propertyFileName) throws Exception;

    String[] getActiveObjectRepository(String objectName);

    String[] findObject(Properties properties, String propertyFileName, String objectName) throws Exception;

    String getPropertyValue(String propertiesFileName, String propertyKeyName);

    void setPropertyValue(String propertiesFileName, String propertyKeyName, String propertyKeyValue);

    boolean ObjectRepositoryLoad();
}
