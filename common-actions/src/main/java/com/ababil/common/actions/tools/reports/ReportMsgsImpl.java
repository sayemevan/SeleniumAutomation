package com.ababil.common.actions.tools.reports;

import com.ababil.common.actions.arrays.ReportArrays;
import com.ababil.common.actions.data.ConstantData;
import com.ababil.common.actions.enums.DateTimeMask;
import com.ababil.common.actions.enums.PropertyFileName;
import com.ababil.common.actions.services.reports.ReportMsgs;
import com.ababil.common.actions.services.repositories.RepositoryTools;
import com.ababil.common.actions.services.utilities.dateTimeUtils.DateFormatters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReportMsgsImpl implements ReportMsgs {

    @Autowired
    private DateFormatters dateFormatters;

    @Autowired
    private RepositoryTools repositoryTools;

    @Override
    public boolean insertErrorMsgToArray(String errorMessage, String extraParam) {
        try {
            String message, currentMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();

            if (errorMessage.equals("DEFAULT")) {
                message = "Error Message:\t" + currentMethodName + ":: " + repositoryTools.getPropertyValue(PropertyFileName.CURRENT_GLOBAL_PARAMS.toString(), "GblFrmErrorMessage").split("~")[0] + ".\n";
            } else if(currentMethodName.equalsIgnoreCase(ConstantData.CPU_USAGE_PROCESS_METHOD_NAME)){
                message = "CPU Usage Message:\t" + currentMethodName + ":: " + errorMessage + ".\n";
            } else {
                message = "Error Message:\t" + currentMethodName + ":: " + errorMessage + ".\n";
            }

            ReportArrays.getTestDetailLog().add(dateFormatters.formatDateTimeAsString(DateTimeMask.TIMESTAMP.toString(), null, null, null, null) + " " + message);

            if(message.toLowerCase().contains(ConstantData.SYS_ERROR_MSG_JAVA) || message.toLowerCase().contains(ConstantData.SYS_ERROR_MSG_SELENIUM)){
                repositoryTools.setPropertyValue(PropertyFileName.CURRENT_GLOBAL_PARAMS.toString(), "GblCurrentTestStepTag", "TRUE");
                message = "Error Message:\t" + currentMethodName + ":: " + "Object specific system error occurred! \n";
            } else {
                repositoryTools.setPropertyValue(PropertyFileName.CURRENT_GLOBAL_PARAMS.toString(), "GblSystemSpecificError", "FALSE");
            }

            ReportArrays.getTestResultReport().add(repositoryTools.getPropertyValue(PropertyFileName.CURRENT_GLOBAL_PARAMS.toString(), "GblCurrentTestStepTag") + ": " + message);

            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean insertTextMsgToArray(String arrayName, String textMessage, String extraParam) {
        return false;
    }

    @Override
    public boolean clearDataFromArray(String arrayNameToEmpty, String extraParam) {
        return false;
    }

    @Override
    public String printStackTraceError(Exception exception) {
        return null;
    }
}
