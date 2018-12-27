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
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `formdata_data_key` varchar(100) NOT NULL DEFAULT '' COMMENT '����������',
  `type` char(2) NOT NULL DEFAULT '' COMMENT '���������ͣ�\n1��ö��\n2��ʱ��',
  `enumeration_name` varchar(45) NOT NULL DEFAULT '' COMMENT 'ö������',
  `expression` char(1) NOT NULL DEFAULT '' COMMENT '������ʽ��\n>\n=\n<',
  `condition` varchar(45) NOT NULL DEFAULT '' COMMENT '����',
  `level` int(11) NOT NULL DEFAULT '0' COMMENT '���ȼ�������Խ�����ȼ�Խ��',
  `workflow_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `parent_id` int(11) NOT NULL COMMENT '����id',
  `template_id` int(11) NOT NULL COMMENT '����ģ��id',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `delete_flag` char(1) NOT NULL DEFAULT '0' COMMENT 'ɾ����ǣ�\n0��δɾ��\n1�� ɾ��',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='����ģ�岻ͬѡ����ò�ͬ�Ĺ�����';

-- ----------------------------
-- Table structure for flxoa_approve_form
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_approve_form`;
CREATE TABLE `flxoa_approve_form` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `template_id` int(11) NOT NULL DEFAULT '0' COMMENT 'aprv_formtemplate���id',
  `status` char(2) NOT NULL DEFAULT '' COMMENT '����״̬',
  `submit_status` char(2) NOT NULL DEFAULT '' COMMENT '�ύ״̬��0δ�ύ 1����� 2����� 3ͨ�� 4δͨ��',
  `submit_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `workflow_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT 'ɾ����ǣ�\n0��δɾ��\n1�� ɾ��',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id,Ҳ���ύ��id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id,Ҳ���ύ�˲���id,�͹�����Ȩ�����',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id,Ҳ��������id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id,Ҳ�������˲���id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='�����¼��';

-- ----------------------------
-- Table structure for flxoa_approve_formdata
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_approve_formdata`;
CREATE TABLE `flxoa_approve_formdata` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `data_key` varchar(100) NOT NULL DEFAULT '' COMMENT '���������ƣ���formtamplate��layout����',
  `data_value` text NOT NULL COMMENT '�������ֵ',
  `data_description` varchar(100) NOT NULL DEFAULT '' COMMENT '��������������',
  `form_id` int(11) NOT NULL DEFAULT '0' COMMENT 'aprv_form���id',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT 'ɾ����ǣ�\n0��δɾ��\n1�� ɾ��',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8 COMMENT='�������ݱ�';

-- ----------------------------
-- Table structure for flxoa_approve_formlog
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_approve_formlog`;
CREATE TABLE `flxoa_approve_formlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `now_status` char(2) NOT NULL DEFAULT '' COMMENT '��ǰ״̬',
  `approve_user` varchar(45) NOT NULL DEFAULT '' COMMENT '������',
  `approve_time` int(11) NOT NULL COMMENT '����ʱ��',
  `next_status` char(2) NOT NULL DEFAULT '' COMMENT '��һ״̬',
  `approve_remark` varchar(400) NOT NULL DEFAULT '' COMMENT '������ע',
  `approve_idea` varchar(30) NOT NULL DEFAULT '' COMMENT '������� 1ͨ�� 2��ͨ�� 3�˻�',
  `form_id` int(11) NOT NULL DEFAULT '0' COMMENT 'aprv_from���id',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT 'ɾ����ǣ�\n0��δɾ��\n1�� ɾ��',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='������¼��';

-- ----------------------------
-- Table structure for flxoa_approve_formtemplate
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_approve_formtemplate`;
CREATE TABLE `flxoa_approve_formtemplate` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `name` varchar(45) NOT NULL DEFAULT '' COMMENT 'ģ������',
  `layout` text NOT NULL COMMENT 'ģ������',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `delete_flag` char(1) NOT NULL DEFAULT '0' COMMENT 'ɾ����ǣ�\n0��δɾ��\n1�� ɾ��',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COMMENT='����ģ���';

-- ----------------------------
-- Table structure for flxoa_approve_workflow
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_approve_workflow`;
CREATE TABLE `flxoa_approve_workflow` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `workflow_name` varchar(45) NOT NULL DEFAULT '' COMMENT '����������',
  `workflow_json` text NOT NULL COMMENT '������json',
  `company_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������˾id',
  `department_id` int(11) NOT NULL DEFAULT '0' COMMENT '����������id',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT 'ɾ����ǣ�\n0��δɾ��\n1�� ɾ��',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  `templage_ids` varchar(200) NOT NULL DEFAULT '' COMMENT '�����ģ��ids',
  `templage_names` varchar(400) NOT NULL DEFAULT '' COMMENT '�����ģ��names',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='��������';

-- ----------------------------
-- Table structure for flxoa_attendance_holidayset
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_attendance_holidayset`;
CREATE TABLE `flxoa_attendance_holidayset` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `legal_holidays` int(11) NOT NULL DEFAULT '0' COMMENT '�����ڼ���',
  `types` char(2) NOT NULL DEFAULT '0' COMMENT '���ͣ�\n0����ĩ\n1���ڼ���2���ϰ�',
  `years` char(4) NOT NULL DEFAULT '' COMMENT '���',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT 'ɾ����ǣ�\n0��δɾ��\n1��ɾ��',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6814 DEFAULT CHARSET=utf8 COMMENT='�ڼ�������';

-- ----------------------------
-- Table structure for flxoa_attendance_signdetails
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_attendance_signdetails`;
CREATE TABLE `flxoa_attendance_signdetails` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sign_date` int(11) NOT NULL COMMENT 'ǩ������',
  `sign_time` int(11) NOT NULL DEFAULT '0' COMMENT 'ǩ��ʱ��',
  `sign_locale` varchar(150) NOT NULL DEFAULT '' COMMENT 'ǩ���ص�',
  `sign_longitude` varchar(45) NOT NULL DEFAULT '' COMMENT 'ǩ�������ھ���',
  `sign_latitude` varchar(45) NOT NULL DEFAULT '' COMMENT 'ǩ��������γ��',
  `commens` varchar(300) NOT NULL DEFAULT '' COMMENT 'ǩ����ע(�ֻ��򹫳��������ٱ���)',
  `sign_type` char(2) NOT NULL DEFAULT '0' COMMENT 'ǩ��������5�����ͣ�\n0���ֻ�ǩ��\n1���Ž�ˢ��\n2�����\n3������\n4������ ',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT 'ɾ����ǣ�\n0��δɾ��\n1�� ɾ��',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id����ǩ����Աid��',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id����ǩ������������id��',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=623 DEFAULT CHARSET=utf8 COMMENT='ǩ����ϸ���ֻ����Ž�ˢ����';

-- ----------------------------
-- Table structure for flxoa_attendance_specialtimeset
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_attendance_specialtimeset`;
CREATE TABLE `flxoa_attendance_specialtimeset` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `special_start_date` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ�俪ʼ����',
  `special_end_date` int(11) NOT NULL DEFAULT '0' COMMENT '�����ֹ����',
  `gotoworktime` varchar(25) NOT NULL DEFAULT '0' COMMENT '���������ϰ�ʱ��',
  `afterworktime` varchar(25) NOT NULL DEFAULT '0' COMMENT '�������ڵ��°�ʱ��',
  `special_group` char(2) NOT NULL DEFAULT '' COMMENT '��������ϰࡢ�°�ʱ���Ⱥ��:\n0������\n1��������\n2���Ա�\n',
  `special_group_details` varchar(400) NOT NULL DEFAULT '' COMMENT '����Ⱥ�����ϸ(���� ����id ����Աid ���У�Ů)',
  `flag` char(2) NOT NULL DEFAULT '0' COMMENT '��¼�Ƿ���Ч��\n0����Ч\n1����Ч',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '�����˲���id',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT 'ɾ�����:\n0��δɾ��\n1��ɾ��',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '�޸���id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '�޸��˲���',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 COMMENT='����ģ��_��������(����)���ñ�';

-- ----------------------------
-- Table structure for flxoa_attendance_summary
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_attendance_summary`;
CREATE TABLE `flxoa_attendance_summary` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `sign_status` char(2) NOT NULL DEFAULT '0' COMMENT '����״̬��־��10�֣�\n0������\n1���ٵ�\n2����ĩ\n3���ڼ���\n4���ڼ��ռӰ�\n5�����\n6�������\n\n\n7�����쳣8������9���ٵ�������',
  `sign_data` int(11) NOT NULL DEFAULT '0' COMMENT 'ǩ������',
  `sign_earliest_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ǩ��ʱ��',
  `sign_earliest_type` char(2) NOT NULL DEFAULT '0' COMMENT '����ǩ��������5�����ͣ�\n0���ֻ�ǩ��\n1 ���Ž�ˢ��\n2�����\n3������\n4������ ',
  `sign_earliest_comments` varchar(500) NOT NULL DEFAULT '' COMMENT '����ǩ����ע',
  `sign_earliest_address` varchar(150) NOT NULL DEFAULT '' COMMENT '����ǩ���ص�',
  `sign_latest_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ǩ��ʱ��',
  `sign_latest_type` char(2) NOT NULL DEFAULT '0' COMMENT '����ǩ��������5������:\n0���ֻ�ǩ��\n1 ���Ž�ˢ��\n2�����\n3������\n4������ ',
  `sign_latest_comments` varchar(500) NOT NULL DEFAULT '' COMMENT '����ǩ����ע',
  `sign_latest_adress` varchar(150) NOT NULL DEFAULT '' COMMENT '����ǩ���ص�',
  `leader_comments` varchar(500) NOT NULL DEFAULT '' COMMENT '�쵼��ע',
  `commets_time` int(11) NOT NULL DEFAULT '0' COMMENT '��עʱ��',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT 'ɾ����ǣ�0��δɾ����1��ɾ����',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id����ǩ����id��',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id����ǩ������������id��',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=462 DEFAULT CHARSET=utf8 COMMENT='���ڻ��ܱ�';

-- ----------------------------
-- Table structure for flxoa_cashcollection_claim_affirm
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_cashcollection_claim_affirm`;
CREATE TABLE `flxoa_cashcollection_claim_affirm` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `caro_id` int(11) NOT NULL DEFAULT '0' COMMENT '�ؿ��¼��id',
  `project_id` int(11) NOT NULL DEFAULT '0' COMMENT '��Ŀid',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT 'ɾ����ǣ�\n0��δɾ��\n1�� ɾ��',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  `status` char(2) NOT NULL COMMENT '״̬:\n0�����죻\n1�����ͨ��;\n2������˻�;\n3�����',
  `revocation_reason` varchar(500) NOT NULL DEFAULT '' COMMENT '����ԭ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='�ؿ�������˼�¼';

-- ----------------------------
-- Table structure for flxoa_cashcollection_record
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_cashcollection_record`;
CREATE TABLE `flxoa_cashcollection_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `fund_source` varchar(300) NOT NULL DEFAULT '' COMMENT '������Դ',
  `account_number` varchar(150) NOT NULL DEFAULT '' COMMENT '�˺�',
  `caro_org_name` varchar(600) NOT NULL DEFAULT '' COMMENT '�ؿλ����',
  `caro_money` decimal(15,2) NOT NULL DEFAULT '0.00' COMMENT '�ؿ���',
  `caro_use` varchar(1500) NOT NULL DEFAULT '' COMMENT '��;',
  `caro_type` char(2) NOT NULL DEFAULT '' COMMENT '�ؿ����\n0��Ԥ����\n1�����ȿ�\n2������\n3��Ͷ�걣֤��\n4����Լ��֤��\n5���ʱ���\n6��Ѻ��\n7����ȫ��֤��\n8������',
  `project_id` int(11) NOT NULL DEFAULT '0' COMMENT '��Ŀid',
  `claim_id` int(11) NOT NULL DEFAULT '0' COMMENT '������',
  `claim_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `affirm_id` int(11) NOT NULL DEFAULT '0' COMMENT 'ȷ����',
  `affirm_time` int(11) NOT NULL DEFAULT '0' COMMENT 'ȷ��ʱ��',
  `status` char(2) NOT NULL DEFAULT '0' COMMENT '���״̬��0�������죻1�������죻2���ѵ���U8��3�����ͨ����4���Ѳ�֣�',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT 'ɾ����ǣ�\n0��δɾ��\n1�� ɾ��',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8 COMMENT='�ؿ��¼';

-- ----------------------------
-- Table structure for flxoa_project_bid_information
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_project_bid_information`;
CREATE TABLE `flxoa_project_bid_information` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `project_id` int(32) NOT NULL COMMENT '��Ŀid\n',
  `bidding_director` varchar(45) NOT NULL COMMENT 'Ͷ�긺����',
  `bidding_date` int(11) NOT NULL COMMENT '�б�����',
  `follower_id` int(32) NOT NULL COMMENT '������id',
  `project_bidding_status` char(2) NOT NULL COMMENT 'Ͷ��׼������\n0 Ͷ�긺����\n1 �ϴ�������\n2 ���鼰������Ӱ�\n3 д����\n4 ȷ��Ͷ��ʱ��\n5 ���뱣֤��\n6 Ͷ��׼����������',
  `bidding_results` char(2) NOT NULL COMMENT 'Ͷ����\n0:�б�\n1:δ�б�\n2:Ͷ��׼��\n3:�ӱ�\n4:����\n5:����\n',
  `create_time` int(11) NOT NULL COMMENT '����ʱ��',
  `update_time` int(11) NOT NULL COMMENT '����ʱ��',
  `delete_flag` char(2) NOT NULL COMMENT 'ɾ�����\n0:δɾ��\n1: ɾ��\n0ΪĬ��ֵ',
  `create_user_id` int(32) NOT NULL COMMENT '������id',
  `create_department_id` int(32) NOT NULL COMMENT '��������������id',
  `update_user_id` int(32) NOT NULL COMMENT '������id',
  `update_department_id` int(32) NOT NULL COMMENT '��������������id',
  `bid_schedule` char(32) NOT NULL DEFAULT '0' COMMENT 'Ͷ�����0:δ����\n1:����������\n2:�ѱ���\n3:Ͷ��׼����\n4:Ͷ����\n5:Ͷ�����\n',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='Ͷ����Ϣ��';

-- ----------------------------
-- Table structure for flxoa_project_bid_record
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_project_bid_record`;
CREATE TABLE `flxoa_project_bid_record` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `bid_id` int(32) NOT NULL COMMENT 'Ͷ����Ϣ��id',
  `name` varchar(45) NOT NULL DEFAULT '' COMMENT '�׶�����',
  `name_value` varchar(150) NOT NULL DEFAULT '' COMMENT '�׶�ֵ',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT 'ɾ����ǣ�0��δɾ����1�� ɾ����0ΪĬ��ֵ',
  `create_user_id` int(32) NOT NULL COMMENT '������id',
  `create_department_id` int(32) NOT NULL COMMENT '��������������id',
  `update_user_id` int(32) NOT NULL COMMENT '������id',
  `update_department_id` int(32) NOT NULL COMMENT '��������������id',
  `url` varchar(150) DEFAULT NULL,
  `accessory_name` varchar(150) DEFAULT NULL,
  `accessory_true_name` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='Ͷ����Ϣ���е�Ͷ��״̬��Ϣ��¼��';

-- ----------------------------
-- Table structure for flxoa_project_information
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_project_information`;
CREATE TABLE `flxoa_project_information` (
  `id` int(45) NOT NULL AUTO_INCREMENT,
  `proj_number` varchar(45) DEFAULT '' COMMENT '��Ŀ���',
  `proj_name` varchar(150) NOT NULL DEFAULT '' COMMENT '��Ŀ����',
  `proj_attribute` char(2) NOT NULL DEFAULT '0' COMMENT '��Ŀ���ԣ�\n0������\n1������\n2������\n3������\n4���ǻ۳���\n5���������\n6���������',
  `bus_classification` char(2) NOT NULL DEFAULT '0' COMMENT 'ҵ�����ͣ�\n0��ֱ���û�\n1�������û�\n2��ά��\n3�����\n4������',
  `design_company` char(2) NOT NULL DEFAULT '' COMMENT '��Ƶ�λ��\n0����˾���\n1�������\n2������(���ֶβ�֪����;������)',
  `proj_state` char(2) NOT NULL DEFAULT '0' COMMENT '��Ŀ״̬�� \n0�� δ����\n1�� ������ \n2�������� \n3��Ͷ������\n4��Ͷ��׼��\n5��Ͷ����\n6��Ͷ�����\n7��ʵʩ\n8����ά\n9����ͣ\n10���ѹر�\n11���Խ���',
  `proj_start_time` int(11) NOT NULL DEFAULT '0' COMMENT '��Ŀ��ʼʱ��',
  `proj_end_time` int(11) NOT NULL DEFAULT '0' COMMENT '��Ŀ����ʱ��',
  `signatory` varchar(45) NOT NULL DEFAULT '' COMMENT '�׷�/��Ŀ������',
  `signatory_name` varchar(150) NOT NULL DEFAULT '' COMMENT '�׷�/��Ŀ�Խ�������',
  `signatory_telephone` varchar(150) NOT NULL DEFAULT '' COMMENT '�׷�/��Ŀ�Խ��˵绰',
  `proj_stage` char(2) NOT NULL DEFAULT '0' COMMENT '��Ŀ�׶�:\n1��ǰ�����\n2������\n3���������\n4��ʵʩ\n5����ά',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `create_user_id` int(32) NOT NULL COMMENT '������id',
  `create_department_id` int(32) NOT NULL COMMENT '��������������id',
  `update_user_id` int(32) NOT NULL COMMENT '������id',
  `update_department_id` int(32) NOT NULL COMMENT '��������������id',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT 'ɾ����ǣ�\n0��δɾ����\n1�� ɾ����\n0ΪĬ��ֵ',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `whether_follow` char(100) NOT NULL DEFAULT '0' COMMENT '�Ƿ��ע��\n0����\n1����ע ��Ϊ ��ע��',
  `client_name` varchar(50) NOT NULL COMMENT '�ͻ�����',
  `predict_contract_money` varchar(100) NOT NULL COMMENT 'Ԥ�ƺ�ͬ��',
  `predict_bids_time` int(11) NOT NULL COMMENT 'Ԥ���б�ʱ��',
  `project_leader` varchar(50) DEFAULT NULL COMMENT '��Ŀ������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='��Ŀ��Ϣ��';

-- ----------------------------
-- Table structure for flxoa_project_invoice
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_project_invoice`;
CREATE TABLE `flxoa_project_invoice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `invoice_id` int(11) NOT NULL DEFAULT '0' COMMENT '�����id����������ͣ�\n֧Ʊ���õ�����Ʊ���뵥',
  `accessory` varchar(45) NOT NULL DEFAULT '' COMMENT '��Ʊ����',
  `accessory_status` char(2) NOT NULL DEFAULT '' COMMENT '����״̬��0��δ�ϴ�;1�����ϴ�',
  `invoice_type` char(2) NOT NULL DEFAULT '' COMMENT '��Ʊ���ͣ�\n 0������\n 1��֧��',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT 'ɾ�����:\n0��δɾ��\n1�� ɾ��',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��Ʊ����';

-- ----------------------------
-- Table structure for flxoa_project_invoice_check
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_project_invoice_check`;
CREATE TABLE `flxoa_project_invoice_check` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `invoice_manager_id` int(11) NOT NULL DEFAULT '0' COMMENT '��Ʊ�����id',
  `remark` varchar(500) NOT NULL DEFAULT '' COMMENT '��ע',
  `is_receive` char(2) NOT NULL DEFAULT '' COMMENT '�Ƿ��յ���\n 0���յ�\n 1��δ�յ�',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT 'ɾ�����:\n0��δɾ��\n1�� ɾ��',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��Ʊ���';

-- ----------------------------
-- Table structure for flxoa_project_team
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_project_team`;
CREATE TABLE `flxoa_project_team` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `proj_information_id` int(11) DEFAULT NULL COMMENT '��Ŀid',
  `proj_team` varchar(150) DEFAULT '0' COMMENT '�Ŷ���Ա����',
  `update_time` int(45) DEFAULT '0' COMMENT '����ʱ��',
  `create_time` int(45) DEFAULT '0' COMMENT '����ʱ��',
  `delete_flag` char(2) DEFAULT '0' COMMENT 'ɾ����ǡ�0��δɾ����1��ɾ����',
  `update_department_id` int(11) DEFAULT NULL COMMENT '��������������id',
  `update_user_id` int(11) DEFAULT NULL COMMENT '������id',
  `create_department_id` int(11) DEFAULT NULL COMMENT '��������������id',
  `create_user_id` int(11) DEFAULT NULL COMMENT 'create_user_id',
  `role` varchar(100) DEFAULT NULL COMMENT '��ɫ',
  `work_day` int(11) DEFAULT '0' COMMENT '�ܼ�����',
  `join_time` int(45) DEFAULT NULL,
  `leave_time` int(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for flxoa_system_department
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_system_department`;
CREATE TABLE `flxoa_system_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `name` varchar(45) NOT NULL DEFAULT '' COMMENT '��������',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������id',
  `company_id` int(11) NOT NULL DEFAULT '0' COMMENT '��˾id',
  `organization_type` char(2) NOT NULL DEFAULT '1' COMMENT '��֯�������ͣ�\n0����˾\n1������',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT 'ɾ����ǣ�\n0��δɾ��\n1�� ɾ��',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='ϵͳ���ű�';

-- ----------------------------
-- Table structure for flxoa_system_enumeration
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_system_enumeration`;
CREATE TABLE `flxoa_system_enumeration` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `enumeration_name` varchar(45) NOT NULL DEFAULT '' COMMENT 'ö������',
  `enumeration_key` varchar(45) NOT NULL DEFAULT '' COMMENT 'ö�ٵļ�,��01,02,03',
  `enumeration_value` varchar(45) NOT NULL DEFAULT '' COMMENT 'ö�ٵ�ֵ,��δ�ύ,���ύ,����',
  `enumeration_description` varchar(400) NOT NULL COMMENT 'ö������',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT 'ɾ����ǣ�0��δɾ����1�� ɾ����0ΪĬ��ֵ',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=254 DEFAULT CHARSET=utf8 COMMENT='ö�ٱ�';

-- ----------------------------
-- Table structure for flxoa_system_funcation
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_system_funcation`;
CREATE TABLE `flxoa_system_funcation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `name` varchar(45) NOT NULL DEFAULT '' COMMENT '��������',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������id',
  `url` varchar(500) NOT NULL DEFAULT '' COMMENT '����url',
  `is_menu` char(2) NOT NULL DEFAULT '0' COMMENT '�Ƿ��ǲ˵���\n0����\n1����',
  `button_id` varchar(100) NOT NULL DEFAULT '' COMMENT 'ǰ̨��ťid',
  `function_sort` int(255) NOT NULL,
  `description` varchar(400) NOT NULL DEFAULT '' COMMENT '����������',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT 'ɾ����ǣ�\n0��δɾ��\n1�� ɾ��',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COMMENT='���ܱ�';

-- ----------------------------
-- Table structure for flxoa_system_role
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_system_role`;
CREATE TABLE `flxoa_system_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `name` varchar(45) NOT NULL DEFAULT '' COMMENT '��ɫ����',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT 'ɾ����ǣ�\n0��δɾ��\n1�� ɾ��',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='ϵͳ��ɫ��';

-- ----------------------------
-- Table structure for flxoa_system_role_funcation
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_system_role_funcation`;
CREATE TABLE `flxoa_system_role_funcation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `role_id` int(11) NOT NULL DEFAULT '0' COMMENT '��ɫid,��sys_role���id����',
  `funcation_id` int(11) NOT NULL DEFAULT '0' COMMENT '����id,��sys_funcation���id����',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT 'ɾ����ǣ�\n0��δɾ��\n1�� ɾ��',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8 COMMENT='��ɫ�͹��ܹ�ϵ��';

-- ----------------------------
-- Table structure for flxoa_system_user
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_system_user`;
CREATE TABLE `flxoa_system_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `user_name` varchar(45) NOT NULL DEFAULT '' COMMENT '�û���',
  `password` varchar(45) NOT NULL DEFAULT '' COMMENT '����',
  `real_name` varchar(45) NOT NULL DEFAULT '' COMMENT '�û�����',
  `phone` varchar(45) NOT NULL DEFAULT '' COMMENT '�ֻ�����',
  `weixin_id` varchar(200) NOT NULL DEFAULT '',
  `company_id` int(11) NOT NULL DEFAULT '0' COMMENT '��˾id,��sys_department���id���',
  `department_id` int(11) NOT NULL DEFAULT '0' COMMENT '����id,��sys_department���id���',
  `status` char(2) NOT NULL DEFAULT '0' COMMENT '״̬��־��\n0����ְ\n1��ת�γ�����\n2������\n3����ְ\n4������\n5����ȥ��ְ',
  `gender` char(2) NOT NULL DEFAULT '0' COMMENT '�Ա�:\n0����\n1��Ů',
  `types` char(2) NOT NULL DEFAULT '0' COMMENT '��Ա���:\n0����ְ��Ա\n1��������Ա\n2����ת��Ա\n3����ҵ��ʽԱ��\n4��������Ա\n5����ҵ��λ������Ա\n6�����ع�����Ա\n7����ʱ��Ա\n8����ҵ������Ա\n9����ҵ������Ա\n10����ҵ������Ա\n11��������Ա',
  `birthday` varchar(45) NOT NULL DEFAULT '' COMMENT '��������',
  `enter_unit_time` int(11) NOT NULL DEFAULT '0' COMMENT '���뵥λʱ��',
  `identification_number` varchar(45) NOT NULL DEFAULT '' COMMENT '֤������',
  `unit_name` varchar(45) NOT NULL DEFAULT '' COMMENT '������λ����',
  `employment_time` int(11) NOT NULL DEFAULT '0' COMMENT 'Ƹ��ʱ��',
  `valid_document_category` char(2) NOT NULL DEFAULT '0' COMMENT '��Ч֤�����:\n0���������֤\n1������֤\n2��ʿ��֤\n3����ְ�ɲ�֤\n4������������֤\n5�������������/���֤��\n6��̨�����������½ͨ��֤\n7���������þ�ס֤\n8������',
  `highest_degree_education` char(2) NOT NULL DEFAULT '3' COMMENT '���ѧ���ȼ�:\n0����ʿ����\n1����ʿ\n2��˶ʿ\n3��ѧʿ\n4��ר��\n5��ר������',
  `card_id` int(11) NOT NULL DEFAULT '0' COMMENT 'Ա�����鿨id',
  `email` varchar(45) NOT NULL DEFAULT '' COMMENT '����',
  `is_phone_sign` char(2) NOT NULL DEFAULT '0' COMMENT '�Ƿ������ֻ�ǩ��:\n0����\n1������',
  `position` varchar(45) NOT NULL DEFAULT '' COMMENT 'ְλ',
  `work_place` varchar(45) NOT NULL DEFAULT '' COMMENT '�����ص�',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT 'ɾ����ǣ�\n0��δɾ��\n1�� ɾ��',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8 COMMENT='ϵͳ�û���';

-- ----------------------------
-- Table structure for flxoa_system_user_group
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_system_user_group`;
CREATE TABLE `flxoa_system_user_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '�û�������',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT 'ɾ����ǣ�\n0��δɾ��\n1�� ɾ��',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='�û����';

-- ----------------------------
-- Table structure for flxoa_system_user_group_department
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_system_user_group_department`;
CREATE TABLE `flxoa_system_user_group_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `user_group_id` int(11) NOT NULL DEFAULT '0' COMMENT '�û���id,��sys_user_group���id����',
  `department_id` int(11) NOT NULL DEFAULT '0' COMMENT '����id',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT 'ɾ����ǣ�\n0��δɾ��\n1�� ɾ��',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for flxoa_system_user_group_role
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_system_user_group_role`;
CREATE TABLE `flxoa_system_user_group_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `user_group_id` int(11) NOT NULL DEFAULT '0' COMMENT '�û���id,��sys_user_group���id����',
  `role_id` int(11) NOT NULL DEFAULT '0' COMMENT '��ɫid,��sys_role���id����',
  `department_id` int(11) NOT NULL DEFAULT '0' COMMENT '����id',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT 'ɾ����ǣ�\n0��δɾ��\n1�� ɾ��',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='�û���ͽ�ɫ��ϵ��';

-- ----------------------------
-- Table structure for flxoa_system_user_group_user
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_system_user_group_user`;
CREATE TABLE `flxoa_system_user_group_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `user_group_id` int(11) NOT NULL DEFAULT '0' COMMENT '�û���id,��sys_user_group���id����',
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '�û�id,��sys_user���id����',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT 'ɾ����ǣ�\n0��δɾ��\n1�� ɾ��',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='�û�����û���ϵ��';

-- ----------------------------
-- Table structure for flxoa_system_user_role
-- ----------------------------
DROP TABLE IF EXISTS `flxoa_system_user_role`;
CREATE TABLE `flxoa_system_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '�û�id,��sys_user���id����',
  `role_id` int(11) NOT NULL DEFAULT '0' COMMENT '��ɫid,��sys_role���id����',
  `department_id` int(11) NOT NULL DEFAULT '0' COMMENT '����id',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '����ʱ��',
  `delete_flag` char(2) NOT NULL DEFAULT '0' COMMENT 'ɾ����ǣ�\n0��δɾ��\n1�� ɾ��',
  `create_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `create_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  `update_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '������id',
  `update_department_id` int(11) NOT NULL DEFAULT '0' COMMENT '��������������id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=311 DEFAULT CHARSET=utf8 COMMENT='�û��ͽ�ɫ��ϵ��';
