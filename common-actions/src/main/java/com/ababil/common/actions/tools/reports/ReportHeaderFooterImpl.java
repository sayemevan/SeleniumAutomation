package com.ababil.common.actions.tools.reports;

import com.ababil.common.actions.services.reports.ReportHeaderFooter;
import org.springframework.stereotype.Component;

@Component
public class ReportHeaderFooterImpl implements ReportHeaderFooter {
    @Override
    public boolean setReportHeader(String HeaderFlag, String extraParam) {
        return false;
    }

    @Override
    public boolean setReportHeaderFooter(String FooterFlag, String extraParam) {
        return false;
    }
}
