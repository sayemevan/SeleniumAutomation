package com.ababil.generic.actions.services.browserServices;

public interface TabActivities {

    boolean BrowserTabSwitch(String TabObjectName, String InstanceNum, String ExtraParam);

    boolean BrowserTabClose(String TabObjectName, String InstanceNum, String ExtraParam);

}
