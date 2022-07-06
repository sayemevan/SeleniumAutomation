package com.ababil.generic.actions.services.objectServices;

public interface ObjectProperties {

    boolean ObjectGroupActionVerify(String DataSheetName, String RepeatLoopCount, String RowMarkingTags, String ExtraParam);

    boolean ObjectPropertyValueGet(String ObjectName, String PropertyName, String OutPropertyValue, String ExtraParam);
}
