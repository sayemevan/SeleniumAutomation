package com.ababil.common.actions.services.utilities.dateTimeUtils;

public interface DateCalculators {

    boolean UtlMathDateDiffCalculate (String DateOne, String DateTwo, String DateFormat, String OutParam, String ExtraParam);

    boolean UtlMathDateDaysAdd (String DateStr, String NumberOfDaysToAdd, String DateFormat, String OutParam, String ExtraParam);

    boolean UtlMathDateDaysSubtract (String DateStr, String NumberOfDaysToSubtract, String DateFormat, String OutParam, String ExtraParam);

    boolean UtlMathTimeDiffCalculate (String TimeOne, String TimeTwo, String TimeFormat, String OutParam, String ExtraParam);
}
