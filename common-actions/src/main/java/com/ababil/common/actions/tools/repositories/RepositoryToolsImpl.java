package com.ababil.common.actions.tools.repositories;

import com.ababil.common.actions.data.FileExtensions;
import com.ababil.common.actions.data.PropertyFiles;
import com.ababil.common.actions.enums.PropertyFileName;
import com.ababil.common.actions.services.reports.ReportMsgs;
import com.ababil.common.actions.services.repositories.RepositoryTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Properties;

@Component
public class RepositoryToolsImpl implements RepositoryTools {

    @Autowired
    private ReportMsgs reportMsgs;

    @Override
    public Properties getObjectRepository(String propertyFileName) {
        try {
            Properties properties = new Properties();
            if(propertyFileName != null) {
                if (!propertyFileName.endsWith(FileExtensions.PROPERTIES_FILE)) {
                    propertyFileName = propertyFileName + FileExtensions.PROPERTIES_FILE;
                }
                InputStream stream = ClassLoader.getSystemResourceAsStream(propertyFileName);
                properties.load(stream);
            }
            return properties;

        } catch (Exception e) {
            reportMsgs.insertErrorMsgToArray(reportMsgs.printStackTraceError(e), null);
            return null;
        }
    }

    @Override
    public String[] getActiveObjectRepository(String objectName) {
        return new String[0];
    }

    @Override
    public String[] findObject(Properties properties, String propertyFileName, String objectName) {
        try {
            if (properties.isEmpty()) {
                properties = getObjectRepository(propertyFileName);
            }
            if (properties.containsKey(objectName)) {
                return properties.getProperty(objectName).split("~");
            } else if (PropertyFiles.getPropertyFile(PropertyFileName.COMMON_OBJECTS.toString()) != null) {
                return getPropertyValue(PropertyFileName.COMMON_OBJECTS.toString(), objectName).split("~");
            } else if (PropertyFiles.getPropertyFile(PropertyFileName.UTILITY_OBJECTS.toString()) != null){
                return getPropertyValue(PropertyFileName.UTILITY_OBJECTS.toString(), objectName).split("~");
            }

            System.out.println("Incorrect object name : " + objectName);
            reportMsgs.insertErrorMsgToArray("Object not found! Incorrect object name : " + objectName, null);

            return null;
        } catch (Exception e) {
            reportMsgs.insertErrorMsgToArray(reportMsgs.printStackTraceError(e), null);
            return null;
        }
    }

    @Override
    public String getPropertyValue(String propertiesFileName, String propertyKeyName) {
        return (String) PropertyFiles.getPropertyFile(propertiesFileName).getOrDefault(propertyKeyName, null);
    }

    @Override
    public void setPropertyValue(String propertiesFileName, String propertyKeyName, String propertyKeyValue) {
        PropertyFiles.getPropertyFile(propertiesFileName).put(propertyKeyName, propertyKeyValue);
    }

    @Override
    public boolean ObjectRepositoryLoad() {
        return false;
    }
}
