package com.ababil.common.actions.services.reports;

public interface ReportHeaderFooter {

    boolean setReportHeader(String HeaderFlag, String extraParam);

    boolean setReportHeaderFooter(String FooterFlag, String extraParam);
}
