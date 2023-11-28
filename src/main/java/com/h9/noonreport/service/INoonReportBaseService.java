package com.h9.noonreport.service;

public interface INoonReportBaseService {
    void dealNoonReport();

    void deal7daysNoonReport();

    void dealNoonReport(Long timestamp, String shipCode);
}
