package com.ababil.common.actions.tools.reports;

import com.ababil.common.actions.arrays.ReportArrays;
import com.ababil.common.actions.data.ConstantData;
import com.ababil.common.actions.maps.StorageMaps;
import com.ababil.common.actions.services.reports.ReportHeaderFooter;
import com.ababil.common.actions.services.utilities.dateTimeUtils.DateFormatters;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReportHeaderFooterImpl implements ReportHeaderFooter {

    @Autowired
    private DateFormatters dateFormatters;

    @Override
    public boolean setReportHeader(String HeaderFlag, String extraParam) {
        try{
            int maxLength = 0;
            String testRunDate = dateFormatters.formatDateTimeAsString("EEEE, MMMM dd, yyyy", null, null, null, null),
                    testRunStartTime = dateFormatters.formatDateTimeAsString("hh:mm:ss:SSS a", null, null, "OutStartTime", null),
                    testTitleName = "",
                    testerName = "",
                    autName = StorageMaps.getParamsMapValue(ConstantData.BATCH_TEST_PARAMS, "AutName"),
                    autVersion = StorageMaps.getParamsMapValue(ConstantData.BATCH_TEST_PARAMS, "AutVersion"),
                    osName = System.getProperties().getProperty("os.name"),
                    osVersion = System.getProperties().getProperty("os.version"),
                    webBrowserName = StorageMaps.getParamsMapValue(ConstantData.BATCH_TEST_PARAMS, "WebBrowserName"),
                    webBrowserVersion = StorageMaps.getParamsMapValue(ConstantData.BATCH_TEST_PARAMS, "WebBrowserVersion"),
                    testToolName = StorageMaps.getParamsMapValue(ConstantData.BATCH_TEST_PARAMS, "TestToolName"),
                    testToolVersion = StorageMaps.getParamsMapValue(ConstantData.BATCH_TEST_PARAMS, "TestToolVersion"),
                    //math expression to find max length.
                    mathExpression = "max(" + testRunDate.length() + "," + testRunStartTime.length() + "," + testTitleName.length() + "," + testerName.length() + "," + autName.length() + "," +
                            autVersion.length() + "," + osName.length() + "," + osVersion.length() + "," + webBrowserName.length() + "," + webBrowserName.length() + "," + webBrowserVersion.length() + "," +
                            testToolName.length() + "," + testToolVersion.length() + "," + ")";

                    //UtlMathExpressionCompute(mathExpression,"OutMaxLength","NULL");
                    maxLength = Integer.valueOf(StorageMaps.getParamsMapValue(ConstantData.TEST_PARAMS, "OutMaxLength")) + 5;

                    //common report header msg.
                    String reportHeader = " " + StringUtils.repeat("_", maxLength + 43) + " " + System.lineSeparator() +
                            "|" + padRight("", maxLength + 43) + "|" + System.lineSeparator() +
                            "|" + padRight("\t\t\tTest Run Date", 30) + ":\t" + padRight(testRunDate, maxLength) + "|" + System.lineSeparator() +
                            "|" + padRight("\t\t\tTest Run Start Time", 30) + ":\t" + padRight(testRunStartTime, maxLength) + "|" + System.lineSeparator() +
                            "|" + padRight("\t\t\tTest Name", 30) + ":\t" + padRight(testTitleName, maxLength) + "|" + System.lineSeparator() +
                            "|" + padRight("\t\t\tTester Name", 30) + ":\t" + padRight(testerName, maxLength) + "|" + System.lineSeparator() +
                            "|" + padRight("\t\t\tAUT Name", 30) + ":\t" + padRight(autName, maxLength) + "|" + System.lineSeparator() +
                            "|" + padRight("\t\t\tAUT Version", 30) + ":\t" + padRight(autVersion, maxLength) + "|" + System.lineSeparator() +
                            "|" + padRight("\t\t\tWindows OS Name", 30) + ":\t" + padRight(osName, maxLength) + "|" + System.lineSeparator() +
                            "|" + padRight("\t\t\tWindows OS Version", 30) + ":\t" + padRight(osVersion, maxLength) + "|" + System.lineSeparator() +
                            "|" + padRight("\t\t\tWeb Browser Name", 30) + ":\t" + padRight(webBrowserName, maxLength) + "|" + System.lineSeparator() +
                            "|" + padRight("\t\t\tWeb Browser Version", 30) + ":\t" + padRight(webBrowserVersion, maxLength) + "|" + System.lineSeparator() +
                            "|" + padRight("\t\t\tTest Tool Name", 30) + ":\t" + padRight(testToolName, maxLength) + "|" + System.lineSeparator() +
                            "|" + padRight("\t\t\tTest Tool Version", 30) + ":\t" + padRight(testToolVersion, maxLength) + "|" + System.lineSeparator() +
                            "|" + StringUtils.repeat("_", maxLength + 43) + "|" + System.lineSeparator();



            if (HeaderFlag.equals("TESTHEADER")) {
                //Result report array
                ReportArrays.getTestResultReport().add(reportHeader + System.lineSeparator());
                ReportArrays.getTestResultReport().add(System.lineSeparator() + System.lineSeparator());

                //Detail log report array
                ReportArrays.getTestDetailLog().add(reportHeader + System.lineSeparator());
                ReportArrays.getTestDetailLog().add(System.lineSeparator() + System.lineSeparator());

            }
            return true;
        } catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean setReportHeaderFooter(String FooterFlag, String extraParam) {
        return false;
    }

    @Override
    public String padLeft(String text, int length) {
        return String.format("%" + length + "." + length + "s", text);
    }

    @Override
    public String padRight(String text, int length) {
        return String.format("%-" + length + "." + length + "s", text);
    }
}
