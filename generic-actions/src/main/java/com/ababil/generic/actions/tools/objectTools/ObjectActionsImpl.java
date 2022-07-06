package com.ababil.generic.actions.tools.objectTools;

import com.ababil.generic.actions.services.objectServices.ObjectActions;
import org.springframework.stereotype.Component;

@Component
public class ObjectActionsImpl implements ObjectActions {

    @Override
    public boolean ObjectActionSet(String ObjectName, String ActionType, String ValueToBeSet, String ExtraParam) {
        return false;
    }

    @Override
    public boolean ObjectGroupActionSet(String DataSheetName, String RepeatLoopCount, String RowMarkingTags, String ExtraParam) {
        return false;
    }

    @Override
    public boolean ObjectGroupActionRepeat(String DataSheetName, String RepeatLoopCount, String RowMarkingTags, String ExtraParam) {
        return false;
    }
}
