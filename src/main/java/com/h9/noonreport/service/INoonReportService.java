package com.h9.noonreport.service;

import com.h9.noonreport.entity.NoonReport;
import com.baomidou.mybatisplus.extension.service.IService;
import com.h9.noonreport.vo.NoonReportVo;

/**
 * <p>
 * 午报数据表 服务类
 * </p>
 *
 * @author 9h
 * @since 2023-11-15
 */
public interface INoonReportService extends IService<NoonReport> {

    NoonReportVo getNoonReportById(Long id);
}
