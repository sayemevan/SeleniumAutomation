package com.ababil.common.actions.tools.utilities.dateTimeUtils;

import com.ababil.common.actions.data.ConstantData;
import com.ababil.common.actions.enums.DateTimeMask;
import com.ababil.common.actions.enums.PropertyFileName;
import com.ababil.common.actions.maps.StorageMaps;
import com.ababil.common.actions.services.reports.ReportMsgs;
import com.ababil.common.actions.services.repositories.RepositoryTools;
import com.ababil.common.actions.services.utilities.dateTimeUtils.DateFormatters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateFormattersImpl implements DateFormatters {

    @Autowired
    private ReportMsgs reportMsgs;

    @Autowired
    private RepositoryTools repositoryTools;

    @Override
    public boolean UtlDateTimeStringFormat(String FormatOutputMask, String FormatInputMask, String InputDateTimeString, String OutDateTimeString, String ExtraParam) {
        return false;
    }

    @Override
    public String formatDateTimeAsString(String formatOutputMask, String formatInputMask, String inputDateTimeString, String outDateTimeString, String extraParam) {
        try {
            LocalDateTime dateTimeObject = LocalDateTime.now();
            DateTimeFormatter dateTimeFormatter;
            String dateTime;

            if (formatOutputMask.equals(DateTimeMask.DATETIMESTAMP.toString())) {
                dateTimeFormatter = DateTimeFormatter.ofPattern(repositoryTools.getPropertyValue(PropertyFileName.CURRENT_GLOBAL_PARAMS.toString(), "GblDateTimeFormat").split("~")[0]);
            } else if (formatOutputMask.equals(DateTimeMask.TIMESTAMP.toString())) {
                dateTimeFormatter = DateTimeFormatter.ofPattern(repositoryTools.getPropertyValue(PropertyFileName.CURRENT_GLOBAL_PARAMS.toString(), "GblTimeFormat").split("~")[0]);
            } else if (formatOutputMask.equals(DateTimeMask.DATESTAMP.toString())) {
                dateTimeFormatter = DateTimeFormatter.ofPattern(repositoryTools.getPropertyValue(PropertyFileName.CURRENT_GLOBAL_PARAMS.toString(), "GblDateFormat").split("~")[0]);
            } else {
                dateTimeFormatter = DateTimeFormatter.ofPattern(formatOutputMask);
            }

            dateTime = dateTimeObject.format(dateTimeFormatter);

            if(outDateTimeString != null){
                StorageMaps.setParamsMapValue(ConstantData.TEST_PARAMS, outDateTimeString, dateTime);
            }

            return dateTime;

        } catch (Exception e) {
            reportMsgs.insertErrorMsgToArray(reportMsgs.printStackTraceError(e), null);
            return null;
        }
    }
}
