INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (8, '当日原始数据第一条的时间（UTC）', 'first_data_utctime', 1, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (9, '当日原始数据最后一条的时间（UTC）', 'last_data_utctime', 1, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (10, '当日原始数据点数（数据量：条）', 'data_volume_day', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (11, 'SOMS报告时长（小时）', 'report_Length_Hrs_soms', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (12, '船名（英文）', 'vessel_name', 1, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (13, '经度（船位）', 'lon', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (14, '纬度（船位）', 'lat', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (15, '时区（船位）', 'time_zone', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (16, '报告日期', 'noonreport_date', 1, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (17, '报告时间（LT）', 'noonreport_lt', 1, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (18, '报告时间（UTC）', 'noonreport_utctime', 1, NULL, NULL, 2);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (19, '报告时长（小时）', 'report_length_hrs', 2, NULL, NULL, 2);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (20, '船舶载重', 'vessel_loading', 1, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (21, '观测速度（对地）_nm_H', 'observed_speed_nm_h', 2, NULL, NULL, 2);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (22, '观测速度（对地）', 'observed_speed_kn', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (23, '观测速度（对地）_0.5', 'observed_speed_0_5kn', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (24, '主机负荷', 'me_load', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (25, '主机日耗油量（吨）', 'me_cons_mt', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (26, '发电机组总日耗油量（吨）', 'ae_cons_mt', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (27, '锅炉总日耗油量（吨）', 'boiler_cons_mt', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (28, '总日耗油量（吨）', 'total_fo_cons_mt', 2, NULL, NULL, 2);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (29, '主机总运行时长（小时）', 'me_running_hours', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (30, 'SOMS生成备注', 'remarks_soms', 1, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (31, '航行距离', 'steaming_distance', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (32, '航行时间（主机运行/定速）', 'steaming_time', 2, NULL, NULL, 2);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (33, '风速-风速风向仪（相对）', 'wind_speed_soms', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (34, '风向-风速风向仪（相对）', 'wind_diretion_soms', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (35, '风力等级（BF）', 'wind_scale_bf', 2, NULL, NULL, 2);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (36, '1号发电机功率', 'no1_dg_power', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (37, '2号发电机功率', 'no2_dg_power', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (38, '3号发电机功率', 'no3_dg_power', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (39, '4号发电机功率', 'no4_dg_power', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (40, '1号发电机运行时间', 'ae_no1_power', 2, NULL, NULL, 2);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (41, '2号发电机运行时间', 'ae_no2_power', 2, NULL, NULL, 2);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (42, '3号发电机运行时间', 'ae_no3_power', 2, NULL, NULL, 2);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (43, '4号发电机运行时间', 'ae_no4_power', 2, NULL, NULL, 2);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (44, '1号发电机负荷', 'ae_no1_load', 2, NULL, NULL, 3);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (45, '2号发电机负荷', 'ae_no2_load', 2, NULL, NULL, 3);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (46, '3号发电机负荷', 'ae_no3_load', 2, NULL, NULL, 3);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (47, '4号发电机负荷', 'ae_no4_load', 2, NULL, NULL, 3);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (48, '1号锅炉日耗油量（吨）', 'boiler_no_1_cons_mt', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (49, '1号锅炉运行时间', 'boiler_no_1_running_hours', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (50, '2号锅炉日耗油量（吨）', 'boiler_no_2_cons_mt', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (51, '2号锅炉运行时间', 'boiler_no_2_running_hours', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (52, '锅炉运行时间', 'boiler_running_hours', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (53, '实时速度（对地）', 'observed_speed_realtime', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (54, '船艏向', 'heading', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (55, '艏吃水', 'fore_draft', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (56, '艉吃水', 'aft_draft', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (57, '平均吃水', 'draft', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (58, '滑失率', 'slip_rate', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (59, '主机转速', 'me_rpm', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (60, '主机1号气缸排气温度-最大值', 'me_no1_exhaust_temp_max', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (61, '主机2号气缸排气温度-最大值', 'me_no2_exhaust_temp_max', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (62, '主机3号气缸排气温度-最大值', 'me_no3_exhaust_temp_max', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (63, '主机4号气缸排气温度-最大值', 'me_no4_exhaust_temp_max', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (64, '主机5号气缸排气温度-最大值', 'me_no5_exhaust_temp_max', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (65, '主机6号气缸排气温度-最大值', 'me_no6_exhaust_temp_max', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (66, '主机7号气缸排气温度-最大值', 'me_no7_exhaust_temp_max', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (67, '主机1号气缸排气温度-最小值', 'me_no1_exhaust_temp_min', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (68, '主机2号气缸排气温度-最小值', 'me_no2_exhaust_temp_min', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (69, '主机3号气缸排气温度-最小值', 'me_no3_exhaust_temp_min', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (70, '主机4号气缸排气温度-最小值', 'me_no4_exhaust_temp_min', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (71, '主机5号气缸排气温度-最小值', 'me_no5_exhaust_temp_min', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (72, '主机6号气缸排气温度-最小值', 'me_no6_exhaust_temp_min', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (73, '主机7号气缸排气温度-最小值', 'me_no7_exhaust_temp_min', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (74, '主机1号气缸排气温度-平均值', 'me_no1_exhaust_temp_mean', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (75, '主机2号气缸排气温度-平均值', 'me_no2_exhaust_temp_mean', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (76, '主机3号气缸排气温度-平均值', 'me_no3_exhaust_temp_mean', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (77, '主机4号气缸排气温度-平均值', 'me_no4_exhaust_temp_mean', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (78, '主机5号气缸排气温度-平均值', 'me_no5_exhaust_temp_mean', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (79, '主机6号气缸排气温度-平均值', 'me_no6_exhaust_temp_mean', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (80, '主机7号气缸排气温度-平均值', 'me_no7_exhaust_temp_mean', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (81, '浪高_WNI', 'sig_wave_hgt_wni', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (82, '浪高等级_WNI', 'wave_scale', 2, NULL, NULL, 2);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (83, '流速_WNI', 'current_velocity_wni', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (84, '流向_WNI (Going To)', 'current_direction_wni', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (85, '海浪方向_WNI (Coming From)', 'wave_direction_wni', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (86, '风速_WNI', 'wind_speed_wni', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (87, '风向_WNI (Coming From)', 'wind_direction_wni', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (88, '航线种类', 'voyage_type', 1, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (89, '航向', 'course', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (90, '主机输出功率', 'me_output_power', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (91, '航次编号', 'voyage_no', 1, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (92, '理论航速', 'spd_theoretical', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (93, '涌浪高_WNI', 'swell_wave_height_wni', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (94, '涌浪方向_WNI (Coming From)', 'swell_wave_direction_wni', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (95, '海面气压_WNI', 'sea_surface_pressure_wni', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (96, '主机日耗油量_24h（吨）', 'me_cons_mt_24h', 2, NULL, NULL, 3);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (97, '发电机组总日耗油量_24h（吨）', 'ae_cons_mt_24h', 2, NULL, NULL, 3);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (98, '对水速度', 'stw', 2, NULL, NULL, 1);
INSERT INTO `t_dict_config` (`id`, `name`, `code`, `type`, `collect_code`, `parent_id`, `level`) VALUES (99, '主机功（kWh）', 'me_work', 2, NULL, NULL, 2);