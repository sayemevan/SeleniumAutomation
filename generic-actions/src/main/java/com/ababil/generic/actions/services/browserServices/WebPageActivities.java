package com.ababil.generic.actions.services.browserServices;

public interface WebPageActivities {

    boolean BrowserPageViaUrlOpen(String WebUrlAddress, String BrowserType, String NewBrowserWindow, String NewPageTab, String ExtraParam);

    boolean WebPageRefresh(String MaxTimeWait, String ExtraParam);

    boolean UtlWebPageLoadWait (String MaxWaitTimeInSec, String ExtraParam);
}
