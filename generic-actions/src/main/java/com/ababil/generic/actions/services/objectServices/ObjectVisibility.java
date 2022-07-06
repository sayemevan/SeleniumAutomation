package com.ababil.generic.actions.services.objectServices;

public interface ObjectVisibility {
    boolean ObjectVisibilityAssert(String ObjectName, String MaxTimeWait, String ExtraParam);
    boolean ObjectInvisibilityAssert(String ObjectName, String MaxTimeWait, String ExtraParam);
}
