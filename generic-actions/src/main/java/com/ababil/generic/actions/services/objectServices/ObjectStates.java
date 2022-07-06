package com.ababil.generic.actions.services.objectServices;

public interface ObjectStates {
    boolean ObjectCurrentStateAssert(String ObjectName, String StateToAssert, String ExtraParam);
    boolean ObjectCurrentStateCheck(String ObjectName, String StateToCheck, String OutCheckStatus, String ExtraParam);
}
