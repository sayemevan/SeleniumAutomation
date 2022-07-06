package com.ababil.common.actions.services.reports;

public interface ReportMsgs {

    boolean insertErrorMsgToArray(String errorMessage, String extraParam);

    boolean insertTextMsgToArray(String arrayName, String TextMessage, String extraParam);

    boolean clearDataFromArray(String arrayNameToEmpty, String extraParam);

    String printStackTraceError(Exception exception);

}
