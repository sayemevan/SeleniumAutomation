package com.ababil.generic.actions.services.browserServices;

public interface WindowHandler {

    boolean BrowserWindowClose(String BrowserWindowName, String ExtraParam);

    boolean BrowserWindowMinimize(String BrowserWindowName, String ExtraParam);

    boolean BrowserWindowMaximize(String BrowserWindowName, String ExtraParam);

    boolean BrowserWindowRestore(String BrowserWindowName, String ExtraParam);

}
