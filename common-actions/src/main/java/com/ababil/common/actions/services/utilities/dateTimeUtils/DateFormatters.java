package com.ababil.common.actions.services.utilities.dateTimeUtils;

public interface DateFormatters {

    boolean UtlDateTimeStringFormat(String FormatOutputMask, String FormatInputMask, String InputDateTimeString, String OutDateTimeString, String ExtraParam);

    String formatDateTimeAsString(String formatOutputMask, String formatInputMask, String inputDateTimeString, String outDateTimeString, String extraParam) throws Exception;
}
