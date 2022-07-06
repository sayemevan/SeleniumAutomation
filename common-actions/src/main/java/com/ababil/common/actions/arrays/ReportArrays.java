package com.ababil.common.actions.arrays;

import java.util.ArrayList;

public class ReportArrays {
    private static ArrayList<String> TEST_DETAIL_LOG, TEST_RESULT_REPORT, BATCH_RUN_REPORT;

    public static ArrayList<String> getTestDetailLog() {
        return TEST_DETAIL_LOG;
    }

    public static ArrayList<String> getTestResultReport() {
        return TEST_RESULT_REPORT;
    }

    public static ArrayList<String> getBatchRunReport() {
        return BATCH_RUN_REPORT;
    }
}
