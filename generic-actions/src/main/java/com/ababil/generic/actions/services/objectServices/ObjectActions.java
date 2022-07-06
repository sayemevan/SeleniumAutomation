package com.ababil.generic.actions.services.objectServices;

public interface ObjectActions {

    boolean ObjectActionSet(String ObjectName, String ActionType, String ValueToBeSet, String ExtraParam);

    boolean ObjectGroupActionSet(String DataSheetName, String RepeatLoopCount, String RowMarkingTags, String ExtraParam);

    boolean ObjectGroupActionRepeat(String DataSheetName, String RepeatLoopCount, String RowMarkingTags, String ExtraParam);
}
