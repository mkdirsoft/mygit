/*
Navicat MySQL Data Transfer

Source Server         : 192.168.112.39
Source Server Version : 50720
Source Host           : 192.168.112.39:3306
Source Database       : flxoa

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-04-21 18:28:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for flxoa_approve_condition_workflow
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_approve_condition_workflow`;
CREATE TABLE `flxoa_approve_condition_workflow` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `formdata_data_key` varchar(100) NOT NULL DEFAULT '' COMMENT '数据项名称',
  `type` char(2) NOT NULL DEFAULT '' COMMENT '数据项类型：\n1：枚举\n2：时间',
  `enumeration_name` varchar(45) NOT NULL DEFAULT '' COMMENT '枚举名称',
  `expression` char(1) NOT NULL DEFAULT '' COMMENT '条件公式：\n>\n=\n<',
  `condition` varchar(45) NOT NULL DEFAULT '' COMMENT '条件',
  `level` int(11) NOT NULL DEFAULT '0' COMMENT '优先级，数字越大优先级越高',
  `workflow_id` int(11) NOT NULL DEFAULT '0' COMMENT '工作流id',
  `parent_id` int(11) NOT NULL COMMENT '父级id',
  `template_id` int(11) NOT NULL COMMENT '申请模板id',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `delete_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记：\n0：未删除\n1： 删除',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人所属部门id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人所属部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='申请模板不同选项调用不同的工作流';

-- ----------------------------
-- Table structure for flxoa_approve_form
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_approve_form`;
CREATE TABLE `flxoa_approve_form` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `template_id` int(11) NOT NULL DEFAULT '0' COMMENT 'aprv_formtemplate表的id',
  `status` char(2) NOT NULL DEFAULT '' COMMENT '审批状态',
  `submit_status` char(2) NOT NULL DEFAULT '' COMMENT '提交状态：0未提交 1待审核 2审核中 3通过 4未通过',
  `submit_time` int(11) NOT NULL DEFAULT '0' COMMENT '申请时间',
  `workflow_id` int(11) NOT NULL DEFAULT '0' COMMENT '工作流id',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT '删除标记：\n0：未删除\n1： 删除',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人id,也是提交人id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人所属部门id,也是提交人部门id,和工作流权限相关',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人id,也是审批人id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人所属部门id,也是审批人部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='申请记录表';

-- ----------------------------
-- Table structure for flxoa_approve_formdata
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_approve_formdata`;
CREATE TABLE `flxoa_approve_formdata` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `data_key` varchar(100) NOT NULL DEFAULT '' COMMENT '数据项名称，和formtamplate的layout关联',
  `data_value` text NOT NULL COMMENT '数据项的值',
  `data_description` varchar(100) NOT NULL DEFAULT '' COMMENT '数据项中文描述',
  `form_id` int(11) NOT NULL DEFAULT '0' COMMENT 'aprv_form表的id',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT '删除标记：\n0：未删除\n1： 删除',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人所属部门id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人所属部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8 COMMENT='申请数据表';

-- ----------------------------
-- Table structure for flxoa_approve_formlog
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_approve_formlog`;
CREATE TABLE `flxoa_approve_formlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `now_status` char(2) NOT NULL DEFAULT '' COMMENT '当前状态',
  `approve_user` varchar(45) NOT NULL DEFAULT '' COMMENT '审批人',
  `approve_time` int(11) NOT NULL COMMENT '审批时间',
  `next_status` char(2) NOT NULL DEFAULT '' COMMENT '下一状态',
  `approve_remark` varchar(400) NOT NULL DEFAULT '' COMMENT '审批备注',
  `approve_idea` varchar(30) NOT NULL DEFAULT '' COMMENT '审批意见 1通过 2不通过 3退回',
  `form_id` int(11) NOT NULL DEFAULT '0' COMMENT 'aprv_from表的id',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT '删除标记：\n0：未删除\n1： 删除',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人所属部门id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人所属部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='审批记录表';

-- ----------------------------
-- Table structure for flxoa_approve_formtemplate
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_approve_formtemplate`;
CREATE TABLE `flxoa_approve_formtemplate` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(45) NOT NULL DEFAULT '' COMMENT '模板名称',
  `layout` text NOT NULL COMMENT '模板内容',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `delete_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记：\n0：未删除\n1： 删除',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人所属部门id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人所属部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COMMENT='申请模板表';

-- ----------------------------
-- Table structure for flxoa_approve_workflow
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_approve_workflow`;
CREATE TABLE `flxoa_approve_workflow` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `workflow_name` varchar(45) NOT NULL DEFAULT '' COMMENT '工作流名称',
  `workflow_json` text NOT NULL COMMENT '工作流json',
  `company_id` int(11) NOT NULL DEFAULT '0' COMMENT '工作流公司id',
  `department_id` int(11) NOT NULL DEFAULT '0' COMMENT '工作流部门id',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT '删除标记：\n0：未删除\n1： 删除',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人所属部门id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人所属部门id',
  `templage_ids` varchar(200) NOT NULL DEFAULT '' COMMENT '申请表模板ids',
  `templage_names` varchar(400) NOT NULL DEFAULT '' COMMENT '申请表模板names',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='工作流表';

-- ----------------------------
-- Table structure for flxoa_attendance_holidayset
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_attendance_holidayset`;
CREATE TABLE `flxoa_attendance_holidayset` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `legal_holidays` int(11) NOT NULL DEFAULT '0' COMMENT '法定节假日',
  `types` char(2) NOT NULL DEFAULT '0' COMMENT '类型：\n0：周末\n1：节假日2：上班',
  `years` char(4) NOT NULL DEFAULT '' COMMENT '年份',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT '删除标记：\n0：未删除\n1：删除',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人所属部门id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人所属部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6814 DEFAULT CHARSET=utf8 COMMENT='节假日设置';

-- ----------------------------
-- Table structure for flxoa_attendance_signdetails
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_attendance_signdetails`;
CREATE TABLE `flxoa_attendance_signdetails` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sign_date` int(11) NOT NULL COMMENT '签到日期',
  `sign_time` int(11) NOT NULL DEFAULT '0' COMMENT '签到时间',
  `sign_locale` varchar(150) NOT NULL DEFAULT '' COMMENT '签到地点',
  `sign_longitude` varchar(45) NOT NULL DEFAULT '' COMMENT '签到点所在经度',
  `sign_latitude` varchar(45) NOT NULL DEFAULT '' COMMENT '签到点所在纬度',
  `commens` varchar(300) NOT NULL DEFAULT '' COMMENT '签到备注(手机打公出，出差，请假必填)',
  `sign_type` char(2) NOT NULL DEFAULT '0' COMMENT '签到类型有5种类型：\n0：手机签到\n1：门禁刷卡\n2：请假\n3：公出\n4：出差 ',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT '删除标记：\n0：未删除\n1： 删除',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人id（即签到人员id）',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人所属部门id（即签到人所属部门id）',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人所属部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=623 DEFAULT CHARSET=utf8 COMMENT='签到明细表（手机和门禁刷卡）';

-- ----------------------------
-- Table structure for flxoa_attendance_specialtimeset
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_attendance_specialtimeset`;
CREATE TABLE `flxoa_attendance_specialtimeset` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `special_start_date` int(11) NOT NULL DEFAULT '0' COMMENT '特殊时间开始日期',
  `special_end_date` int(11) NOT NULL DEFAULT '0' COMMENT '特殊截止日期',
  `gotoworktime` varchar(25) NOT NULL DEFAULT '0' COMMENT '特殊日期上班时间',
  `afterworktime` varchar(25) NOT NULL DEFAULT '0' COMMENT '特殊日期的下班时间',
  `special_group` char(2) NOT NULL DEFAULT '' COMMENT '针对特殊上班、下班时间的群体:\n0：个人\n1：部门人\n2：性别\n',
  `special_group_details` varchar(400) NOT NULL DEFAULT '' COMMENT '特殊群体的详细(包括 部门id ，人员id ，男，女)',
  `flag` char(2) NOT NULL DEFAULT '0' COMMENT '记录是否有效：\n0：有效\n1：无效',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人部门id',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT '删除标记:\n0：未删除\n1：删除',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '修改人id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '修改人部门',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 COMMENT='考勤模块_特殊日期(假期)设置表';

-- ----------------------------
-- Table structure for flxoa_attendance_summary
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_attendance_summary`;
CREATE TABLE `flxoa_attendance_summary` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sign_status` char(2) NOT NULL DEFAULT '0' COMMENT '考勤状态标志有10种：\n0：正常\n1：迟到\n2：周末\n3：节假日\n4：节假日加班\n5：请假\n6：请假中\n\n\n7：打卡异常8：早退9：迟到、早退',
  `sign_data` int(11) NOT NULL DEFAULT '0' COMMENT '签到日期',
  `sign_earliest_time` int(11) NOT NULL DEFAULT '0' COMMENT '最早签到时间',
  `sign_earliest_type` char(2) NOT NULL DEFAULT '0' COMMENT '最早签到类型有5种类型：\n0：手机签到\n1 ：门禁刷卡\n2：请假\n3：公出\n4：出差 ',
  `sign_earliest_comments` varchar(500) NOT NULL DEFAULT '' COMMENT '最早签到备注',
  `sign_earliest_address` varchar(150) NOT NULL DEFAULT '' COMMENT '最早签到地点',
  `sign_latest_time` int(11) NOT NULL DEFAULT '0' COMMENT '最晚签到时间',
  `sign_latest_type` char(2) NOT NULL DEFAULT '0' COMMENT '最晚签到类型有5种类型:\n0：手机签到\n1 ：门禁刷卡\n2：请假\n3：公出\n4：出差 ',
  `sign_latest_comments` varchar(500) NOT NULL DEFAULT '' COMMENT '最晚签到备注',
  `sign_latest_adress` varchar(150) NOT NULL DEFAULT '' COMMENT '最晚签到地点',
  `leader_comments` varchar(500) NOT NULL DEFAULT '' COMMENT '领导批注',
  `commets_time` int(11) NOT NULL DEFAULT '0' COMMENT '备注时间',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT '删除标记（0：未删除；1：删除）',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人id（即签到人id）',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人所属部门id（即签到人所属部门id）',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人所属部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=462 DEFAULT CHARSET=utf8 COMMENT='考勤汇总表';

-- ----------------------------
-- Table structure for flxoa_cashcollection_claim_affirm
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_cashcollection_claim_affirm`;
CREATE TABLE `flxoa_cashcollection_claim_affirm` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `caro_id` int(11) NOT NULL DEFAULT '0' COMMENT '回款记录表id',
  `project_id` int(11) NOT NULL DEFAULT '0' COMMENT '项目id',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT '删除标记：\n0：未删除\n1： 删除',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人所属部门id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人所属部门id',
  `status` char(2) NOT NULL COMMENT '状态:\n0：认领；\n1：审核通过;\n2：审核退回;\n3：拆分',
  `revocation_reason` varchar(500) NOT NULL DEFAULT '' COMMENT '撤销原因',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='回款认领审核记录';

-- ----------------------------
-- Table structure for flxoa_cashcollection_record
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_cashcollection_record`;
CREATE TABLE `flxoa_cashcollection_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `fund_source` varchar(300) NOT NULL DEFAULT '' COMMENT '款项来源',
  `account_number` varchar(150) NOT NULL DEFAULT '' COMMENT '账号',
  `caro_org_name` varchar(600) NOT NULL DEFAULT '' COMMENT '回款单位名称',
  `caro_money` decimal(15,2) NOT NULL DEFAULT '0.00' COMMENT '回款金额',
  `caro_use` varchar(1500) NOT NULL DEFAULT '' COMMENT '用途',
  `caro_type` char(2) NOT NULL DEFAULT '' COMMENT '回款类别：\n0：预付款\n1：进度款\n2：贷款\n3：投标保证金\n4：履约保证金\n5：质保金\n6：押金\n7：安全保证金\n8：其他',
  `project_id` int(11) NOT NULL DEFAULT '0' COMMENT '项目id',
  `claim_id` int(11) NOT NULL DEFAULT '0' COMMENT '认领人',
  `claim_time` int(11) NOT NULL DEFAULT '0' COMMENT '认领时间',
  `affirm_id` int(11) NOT NULL DEFAULT '0' COMMENT '确认人',
  `affirm_time` int(11) NOT NULL DEFAULT '0' COMMENT '确认时间',
  `status` char(2) NOT NULL DEFAULT '0' COMMENT '拆分状态：0：待认领；1：已认领；2：已导入U8；3：审核通过；4：已拆分；',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT '删除标记：\n0：未删除\n1： 删除',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人所属部门id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人所属部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8 COMMENT='回款记录';

-- ----------------------------
-- Table structure for flxoa_project_bid_information
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_project_bid_information`;
CREATE TABLE `flxoa_project_bid_information` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `project_id` int(32) NOT NULL COMMENT '项目id\n',
  `bidding_director` varchar(45) NOT NULL COMMENT '投标负责人',
  `bidding_date` int(11) NOT NULL COMMENT '招标日期',
  `follower_id` int(32) NOT NULL COMMENT '跟单人id',
  `project_bidding_status` char(2) NOT NULL COMMENT '投标准备进度\n0 投标负责人\n1 上传方案书\n2 标书及标书电子版\n3 写标书\n4 确定投标时间\n5 申请保证金\n6 投标准备工作结束',
  `bidding_results` char(2) NOT NULL COMMENT '投标结果\n0:中标\n1:未中标\n2:投标准备\n3:延标\n4:流标\n5:弃标\n',
  `create_time` int(11) NOT NULL COMMENT '创建时间',
  `update_time` int(11) NOT NULL COMMENT '更新时间',
  `delete_flag` char(2) NOT NULL COMMENT '删除标记\n0:未删除\n1: 删除\n0为默认值',
  `create_user_id` int(32) NOT NULL COMMENT '创建人id',
  `create_department_id` int(32) NOT NULL COMMENT '创建人所属部门id',
  `update_user_id` int(32) NOT NULL COMMENT '更新人id',
  `update_department_id` int(32) NOT NULL COMMENT '更新人所属部门id',
  `bid_schedule` char(32) NOT NULL DEFAULT '0' COMMENT '投标进度0:未报名\n1:报名审批中\n2:已报名\n3:投标准备中\n4:投标中\n5:投标结束\n',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='投标信息表';

-- ----------------------------
-- Table structure for flxoa_project_bid_record
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_project_bid_record`;
CREATE TABLE `flxoa_project_bid_record` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `bid_id` int(32) NOT NULL COMMENT '投标信息表id',
  `name` varchar(45) NOT NULL DEFAULT '' COMMENT '阶段名称',
  `name_value` varchar(150) NOT NULL DEFAULT '' COMMENT '阶段值',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT '删除标记，0：未删除，1： 删除；0为默认值',
  `create_user_id` int(32) NOT NULL COMMENT '创建人id',
  `create_department_id` int(32) NOT NULL COMMENT '创建人所属部门id',
  `update_user_id` int(32) NOT NULL COMMENT '更新人id',
  `update_department_id` int(32) NOT NULL COMMENT '更新人所属部门id',
  `url` varchar(150) DEFAULT NULL,
  `accessory_name` varchar(150) DEFAULT NULL,
  `accessory_true_name` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='投标信息表中的投标状态信息记录表';

-- ----------------------------
-- Table structure for flxoa_project_information
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_project_information`;
CREATE TABLE `flxoa_project_information` (
  `id` int(45) NOT NULL AUTO_INCREMENT,
  `proj_number` varchar(45) DEFAULT '' COMMENT '项目编号',
  `proj_name` varchar(150) NOT NULL DEFAULT '' COMMENT '项目名称',
  `proj_attribute` char(2) NOT NULL DEFAULT '0' COMMENT '项目属性：\n0：会议\n1：弱电\n2：集成\n3：安防\n4：智慧城市\n5：软件销售\n6：软件开发',
  `bus_classification` char(2) NOT NULL DEFAULT '0' COMMENT '业务类型：\n0：直接用户\n1：渠道用户\n2：维保\n3：软件\n4：其他',
  `design_company` char(2) NOT NULL DEFAULT '' COMMENT '设计单位：\n0：公司设计\n1：自设计\n2：其他(此字段不知道用途，待定)',
  `proj_state` char(2) NOT NULL DEFAULT '0' COMMENT '项目状态： \n0： 未立项\n1： 立项中 \n2：已立项 \n3：投标申请\n4：投标准备\n5：投标中\n6：投标结束\n7：实施\n8：运维\n9：暂停\n10：已关闭\n11：以结束',
  `proj_start_time` int(11) NOT NULL DEFAULT '0' COMMENT '项目开始时间',
  `proj_end_time` int(11) NOT NULL DEFAULT '0' COMMENT '项目结束时间',
  `signatory` varchar(45) NOT NULL DEFAULT '' COMMENT '甲方/项目对邮箱',
  `signatory_name` varchar(150) NOT NULL DEFAULT '' COMMENT '甲方/项目对接人姓名',
  `signatory_telephone` varchar(150) NOT NULL DEFAULT '' COMMENT '甲方/项目对接人电话',
  `proj_stage` char(2) NOT NULL DEFAULT '0' COMMENT '项目阶段:\n1：前期设计\n2：深化设计\n3：需求调研\n4：实施\n5：运维',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `create_user_id` int(32) NOT NULL COMMENT '创建人id',
  `create_department_id` int(32) NOT NULL COMMENT '创建人所属部门id',
  `update_user_id` int(32) NOT NULL COMMENT '更新人id',
  `update_department_id` int(32) NOT NULL COMMENT '更新人所属部门id',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT '删除标记，\n0：未删除，\n1： 删除；\n0为默认值',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `whether_follow` char(100) NOT NULL DEFAULT '0' COMMENT '是否关注：\n0：否\n1：关注 改为 关注人',
  `client_name` varchar(50) NOT NULL COMMENT '客户名称',
  `predict_contract_money` varchar(100) NOT NULL COMMENT '预计合同额',
  `predict_bids_time` int(11) NOT NULL COMMENT '预计招标时间',
  `project_leader` varchar(50) DEFAULT NULL COMMENT '项目负责人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='项目信息表';

-- ----------------------------
-- Table structure for flxoa_project_invoice
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_project_invoice`;
CREATE TABLE `flxoa_project_invoice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `invoice_id` int(11) NOT NULL DEFAULT '0' COMMENT '申请表id，申请表类型：\n支票领用单、开票申请单',
  `accessory` varchar(45) NOT NULL DEFAULT '' COMMENT '发票附件',
  `accessory_status` char(2) NOT NULL DEFAULT '' COMMENT '附件状态：0：未上传;1：已上传',
  `invoice_type` char(2) NOT NULL DEFAULT '' COMMENT '发票类型：\n 0：收入\n 1：支出',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT '删除标记:\n0：未删除\n1： 删除',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人所属部门id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人所属部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发票管理';

-- ----------------------------
-- Table structure for flxoa_project_invoice_check
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_project_invoice_check`;
CREATE TABLE `flxoa_project_invoice_check` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `invoice_manager_id` int(11) NOT NULL DEFAULT '0' COMMENT '发票管理表id',
  `remark` varchar(500) NOT NULL DEFAULT '' COMMENT '备注',
  `is_receive` char(2) NOT NULL DEFAULT '' COMMENT '是否收到：\n 0：收到\n 1：未收到',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT '删除标记:\n0：未删除\n1： 删除',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人所属部门id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人所属部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发票审核';

-- ----------------------------
-- Table structure for flxoa_project_team
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_project_team`;
CREATE TABLE `flxoa_project_team` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `proj_information_id` int(11) DEFAULT NULL COMMENT '项目id',
  `proj_team` varchar(150) DEFAULT '0' COMMENT '团队人员名称',
  `update_time` int(45) DEFAULT '0' COMMENT '更新时间',
  `create_time` int(45) DEFAULT '0' COMMENT '创建时间',
  `delete_flag` char(2) DEFAULT '0' COMMENT '删除标记。0：未删除，1：删除，',
  `update_department_id` int(11) DEFAULT NULL COMMENT '更新人所属部门id',
  `update_user_id` int(11) DEFAULT NULL COMMENT '更新人id',
  `create_department_id` int(11) DEFAULT NULL COMMENT '创建人所属部门id',
  `create_user_id` int(11) DEFAULT NULL COMMENT 'create_user_id',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `work_day` int(11) DEFAULT '0' COMMENT '总计天数',
  `join_time` int(45) DEFAULT NULL,
  `leave_time` int(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for flxoa_system_department
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_system_department`;
CREATE TABLE `flxoa_system_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(45) NOT NULL DEFAULT '' COMMENT '部门名称',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父级部门id',
  `company_id` int(11) NOT NULL DEFAULT '0' COMMENT '公司id',
  `organization_type` char(2) NOT NULL DEFAULT '1' COMMENT '组织机构类型：\n0：公司\n1：部门',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT '删除标记：\n0：未删除\n1： 删除',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人所属部门id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人所属部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='系统部门表';

-- ----------------------------
-- Table structure for flxoa_system_enumeration
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_system_enumeration`;
CREATE TABLE `flxoa_system_enumeration` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enumeration_name` varchar(45) NOT NULL DEFAULT '' COMMENT '枚举名称',
  `enumeration_key` varchar(45) NOT NULL DEFAULT '' COMMENT '枚举的键,如01,02,03',
  `enumeration_value` varchar(45) NOT NULL DEFAULT '' COMMENT '枚举的值,如未提交,已提交,撤回',
  `enumeration_description` varchar(400) NOT NULL COMMENT '枚举描述',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT '删除标记，0：未删除，1： 删除；0为默认值',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人所属部门id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人所属部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=254 DEFAULT CHARSET=utf8 COMMENT='枚举表';

-- ----------------------------
-- Table structure for flxoa_system_funcation
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_system_funcation`;
CREATE TABLE `flxoa_system_funcation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(45) NOT NULL DEFAULT '' COMMENT '功能名称',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父级功能id',
  `url` varchar(500) NOT NULL DEFAULT '' COMMENT '功能url',
  `is_menu` char(2) NOT NULL DEFAULT '0' COMMENT '是否是菜单：\n0：是\n1：否',
  `button_id` varchar(100) NOT NULL DEFAULT '' COMMENT '前台按钮id',
  `function_sort` int(255) NOT NULL,
  `description` varchar(400) NOT NULL DEFAULT '' COMMENT '功能项描述',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT '删除标记：\n0：未删除\n1： 删除',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人所属部门id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人所属部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COMMENT='功能表';

-- ----------------------------
-- Table structure for flxoa_system_role
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_system_role`;
CREATE TABLE `flxoa_system_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(45) NOT NULL DEFAULT '' COMMENT '角色名称',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT '删除标记：\n0：未删除\n1： 删除',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人所属部门id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人所属部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='系统角色表';

-- ----------------------------
-- Table structure for flxoa_system_role_funcation
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_system_role_funcation`;
CREATE TABLE `flxoa_system_role_funcation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(11) NOT NULL DEFAULT '0' COMMENT '角色id,和sys_role表的id关联',
  `funcation_id` int(11) NOT NULL DEFAULT '0' COMMENT '功能id,和sys_funcation表的id关联',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT '删除标记：\n0：未删除\n1： 删除',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人所属部门id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人所属部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8 COMMENT='角色和功能关系表';

-- ----------------------------
-- Table structure for flxoa_system_user
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_system_user`;
CREATE TABLE `flxoa_system_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(45) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(45) NOT NULL DEFAULT '' COMMENT '密码',
  `real_name` varchar(45) NOT NULL DEFAULT '' COMMENT '用户姓名',
  `phone` varchar(45) NOT NULL DEFAULT '' COMMENT '手机号码',
  `weixin_id` varchar(200) NOT NULL DEFAULT '',
  `company_id` int(11) NOT NULL DEFAULT '0' COMMENT '公司id,和sys_department表的id相关',
  `department_id` int(11) NOT NULL DEFAULT '0' COMMENT '部门id,和sys_department表的id相关',
  `status` char(2) NOT NULL DEFAULT '0' COMMENT '状态标志：\n0：在职\n1：转任出机关\n2：调出\n3：离职\n4：退休\n5：辞去公职',
  `gender` char(2) NOT NULL DEFAULT '0' COMMENT '性别:\n0：男\n1：女',
  `types` char(2) NOT NULL DEFAULT '0' COMMENT '人员类别:\n0：在职人员\n1：离退人员\n2：调转人员\n3：企业正式员工\n4：待查人员\n5：事业单位技术人员\n6：机关工勤人员\n7：临时人员\n8：企业管理人员\n9：企业技术人员\n10：企业工勤人员\n11：其他人员',
  `birthday` varchar(45) NOT NULL DEFAULT '' COMMENT '出生日期',
  `enter_unit_time` int(11) NOT NULL DEFAULT '0' COMMENT '进入单位时间',
  `identification_number` varchar(45) NOT NULL DEFAULT '' COMMENT '证件号码',
  `unit_name` varchar(45) NOT NULL DEFAULT '' COMMENT '所属单位名称',
  `employment_time` int(11) NOT NULL DEFAULT '0' COMMENT '聘用时间',
  `valid_document_category` char(2) NOT NULL DEFAULT '0' COMMENT '有效证件类别:\n0：居民身份证\n1：军官证\n2：士兵证\n3：文职干部证\n4：部队离退休证\n5：香港特区护照/身份证明\n6：台湾居民来往大陆通行证\n7：境外永久居住证\n8：其他',
  `highest_degree_education` char(2) NOT NULL DEFAULT '3' COMMENT '最高学历等级:\n0：博士以上\n1：博士\n2：硕士\n3：学士\n4：专科\n5：专科以下',
  `card_id` int(11) NOT NULL DEFAULT '0' COMMENT '员工考情卡id',
  `email` varchar(45) NOT NULL DEFAULT '' COMMENT '邮箱',
  `is_phone_sign` char(2) NOT NULL DEFAULT '0' COMMENT '是否能用手机签到:\n0：能\n1：不能',
  `position` varchar(45) NOT NULL DEFAULT '' COMMENT '职位',
  `work_place` varchar(45) NOT NULL DEFAULT '' COMMENT '工作地点',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT '删除标记：\n0：未删除\n1： 删除',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人所属部门id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人所属部门id',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8 COMMENT='系统用户表';

-- ----------------------------
-- Table structure for flxoa_system_user_group
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_system_user_group`;
CREATE TABLE `flxoa_system_user_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '用户组名称',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT '删除标记：\n0：未删除\n1： 删除',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人所属部门id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人所属部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='用户组表';

-- ----------------------------
-- Table structure for flxoa_system_user_group_department
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_system_user_group_department`;
CREATE TABLE `flxoa_system_user_group_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_group_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户组id,和sys_user_group表的id关联',
  `department_id` int(11) NOT NULL DEFAULT '0' COMMENT '部门id',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT '删除标记：\n0：未删除\n1： 删除',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人所属部门id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人所属部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for flxoa_system_user_group_role
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_system_user_group_role`;
CREATE TABLE `flxoa_system_user_group_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_group_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户组id,和sys_user_group表的id关联',
  `role_id` int(11) NOT NULL DEFAULT '0' COMMENT '角色id,和sys_role表的id关联',
  `department_id` int(11) NOT NULL DEFAULT '0' COMMENT '部门id',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT '删除标记：\n0：未删除\n1： 删除',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人所属部门id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人所属部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='用户组和角色关系表';

-- ----------------------------
-- Table structure for flxoa_system_user_group_user
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_system_user_group_user`;
CREATE TABLE `flxoa_system_user_group_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_group_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户组id,和sys_user_group表的id关联',
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户id,和sys_user表的id关联',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT '删除标记：\n0：未删除\n1： 删除',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人所属部门id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人所属部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='用户组和用户关系表';

-- ----------------------------
-- Table structure for flxoa_system_user_role
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_system_user_role`;
CREATE TABLE `flxoa_system_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户id,和sys_user表的id关联',
  `role_id` int(11) NOT NULL DEFAULT '0' COMMENT '角色id,和sys_role表的id关联',
  `department_id` int(11) NOT NULL DEFAULT '0' COMMENT '部门id',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT '删除标记：\n0：未删除\n1： 删除',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '创建人所属部门id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '更新人所属部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=311 DEFAULT CHARSET=utf8 COMMENT='用户和角色关系表';
