/*
 Navicat Premium Data Transfer

 Source Server         : 47.100.14.134
 Source Server Type    : MySQL
 Source Server Version : 50642
 Source Host           : 47.100.14.134:3306
 Source Schema         : zstu

 Target Server Type    : MySQL
 Target Server Version : 50642
 File Encoding         : 65001

 Date: 13/12/2018 20:48:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `users` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', '123');
INSERT INTO `admin` VALUES ('admin1', '123456');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teacher_id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`course_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '高等数学', 'T0001', 30);
INSERT INTO `course` VALUES (2, '高等数学', 'T0002', 30);
INSERT INTO `course` VALUES (3, '高等数学', 'T0003', 30);
INSERT INTO `course` VALUES (4, '数据库', 'T0004', 80);
INSERT INTO `course` VALUES (5, '数据结构', 'T0004', 50);
INSERT INTO `course` VALUES (6, '计算机组成', 'T0004', 30);
INSERT INTO `course` VALUES (7, '英语', 'T0005', 40);
INSERT INTO `course` VALUES (8, '汇编', 'T0006', 40);
INSERT INTO `course` VALUES (9, '机器学习', 'T0007', 100);

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`  (
  `grade_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(255) NULL DEFAULT NULL,
  `student_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `garde` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`grade_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 203 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES (1, 3, 'Xb16610222', 21);
INSERT INTO `grade` VALUES (2, 3, 'Xb16610222', 21);
INSERT INTO `grade` VALUES (3, 2, 'Xb16610226', 69);
INSERT INTO `grade` VALUES (4, 7, 'Xb16620101', 45);
INSERT INTO `grade` VALUES (5, 6, 'Xb16620102', 84);
INSERT INTO `grade` VALUES (6, 3, 'Xb16620103', 60);
INSERT INTO `grade` VALUES (7, 8, 'Xb16620104', 36);
INSERT INTO `grade` VALUES (8, 2, 'Xb16620105', 64);
INSERT INTO `grade` VALUES (9, 9, 'Xb16620106', 43);
INSERT INTO `grade` VALUES (10, 9, 'Xb16620107', 42);
INSERT INTO `grade` VALUES (11, 5, 'Xb16620108', 85);
INSERT INTO `grade` VALUES (12, 5, 'Xb16620109', 64);
INSERT INTO `grade` VALUES (13, 6, 'Xb16620110', 84);
INSERT INTO `grade` VALUES (14, 8, 'Xb16620111', 45);
INSERT INTO `grade` VALUES (15, 5, 'Xb16620112', 88);
INSERT INTO `grade` VALUES (16, 7, 'Xb16620113', 60);
INSERT INTO `grade` VALUES (17, 3, 'Xb16620114', 59);
INSERT INTO `grade` VALUES (18, 4, 'Xb16620115', 60);
INSERT INTO `grade` VALUES (19, 8, 'Xb16620116', 23);
INSERT INTO `grade` VALUES (20, 3, 'Xb16620117', 84);
INSERT INTO `grade` VALUES (21, 6, 'Xb16620118', 51);
INSERT INTO `grade` VALUES (22, 8, 'Xb16620119', 89);
INSERT INTO `grade` VALUES (23, 6, 'Xb16620120', 23);
INSERT INTO `grade` VALUES (24, 1, 'Xb16620121', 65);
INSERT INTO `grade` VALUES (25, 3, 'Xb16620122', 45);
INSERT INTO `grade` VALUES (26, 7, 'Xb16620123', 43);
INSERT INTO `grade` VALUES (27, 6, 'Xb16620124', 57);
INSERT INTO `grade` VALUES (28, 8, 'Xb16620125', 60);
INSERT INTO `grade` VALUES (29, 2, 'Xb16620126', 81);
INSERT INTO `grade` VALUES (30, 6, 'Xb16620127', 89);
INSERT INTO `grade` VALUES (31, 4, 'Xb16620128', 69);
INSERT INTO `grade` VALUES (32, 1, 'Xb16620129', 57);
INSERT INTO `grade` VALUES (33, 3, 'Xb16620130', 62);
INSERT INTO `grade` VALUES (34, 8, 'Xb16620131', 64);
INSERT INTO `grade` VALUES (35, 8, 'Xb16620201', 24);
INSERT INTO `grade` VALUES (36, 6, 'Xb16620202', 40);
INSERT INTO `grade` VALUES (37, 5, 'Xb16620203', 39);
INSERT INTO `grade` VALUES (38, 7, 'Xb16620205', 57);
INSERT INTO `grade` VALUES (39, 3, 'Xb16620206', 64);
INSERT INTO `grade` VALUES (40, 7, 'Xb16620207', 65);
INSERT INTO `grade` VALUES (41, 8, 'Xb16620208', 91);
INSERT INTO `grade` VALUES (42, 8, 'Xb16620209', 77);
INSERT INTO `grade` VALUES (43, 5, 'Xb16620210', 68);
INSERT INTO `grade` VALUES (44, 6, 'Xb16620211', 83);
INSERT INTO `grade` VALUES (45, 1, 'Xb16620212', 96);
INSERT INTO `grade` VALUES (46, 7, 'Xb16620213', 35);
INSERT INTO `grade` VALUES (47, 4, 'Xb16620214', 32);
INSERT INTO `grade` VALUES (48, 3, 'Xb16620215', 24);
INSERT INTO `grade` VALUES (49, 1, 'Xb16620216', 98);
INSERT INTO `grade` VALUES (50, 2, 'Xb16620217', 49);
INSERT INTO `grade` VALUES (51, 3, 'Xb16620218', 41);
INSERT INTO `grade` VALUES (52, 2, 'Xb16620219', 35);
INSERT INTO `grade` VALUES (53, 3, 'Xb16620220', 95);
INSERT INTO `grade` VALUES (54, 4, 'Xb16620221', 90);
INSERT INTO `grade` VALUES (55, 5, 'Xb16620222', 42);
INSERT INTO `grade` VALUES (56, 9, 'Xb16620223', 43);
INSERT INTO `grade` VALUES (57, 2, 'Xb16620224', 97);
INSERT INTO `grade` VALUES (58, 8, 'Xb16620225', 67);
INSERT INTO `grade` VALUES (59, 4, 'Xb16620226', 29);
INSERT INTO `grade` VALUES (60, 7, 'Xb16620227', 25);
INSERT INTO `grade` VALUES (61, 4, 'Xb16620228', 70);
INSERT INTO `grade` VALUES (62, 1, 'Xb16620229', 81);
INSERT INTO `grade` VALUES (63, 5, 'Xb16620230', 82);
INSERT INTO `grade` VALUES (64, 9, 'Xb16620231', 78);
INSERT INTO `grade` VALUES (65, 9, 'Xb16620233', 38);
INSERT INTO `grade` VALUES (66, 4, 'Xb16680108', 90);
INSERT INTO `grade` VALUES (67, 4, 'Xc16560217', 64);
INSERT INTO `grade` VALUES (68, 8, 'Xf16220132', 70);
INSERT INTO `grade` VALUES (69, 7, 'Xb16610222', 89);
INSERT INTO `grade` VALUES (70, 3, 'Xb16610226', 62);
INSERT INTO `grade` VALUES (71, 4, 'Xb16620101', 36);
INSERT INTO `grade` VALUES (72, 6, 'Xb16620102', 91);
INSERT INTO `grade` VALUES (73, 2, 'Xb16620103', 24);
INSERT INTO `grade` VALUES (74, 8, 'Xb16620104', 89);
INSERT INTO `grade` VALUES (75, 1, 'Xb16620105', 34);
INSERT INTO `grade` VALUES (76, 9, 'Xb16620106', 58);
INSERT INTO `grade` VALUES (77, 9, 'Xb16620107', 97);
INSERT INTO `grade` VALUES (78, 9, 'Xb16620108', 99);
INSERT INTO `grade` VALUES (79, 1, 'Xb16620109', 54);
INSERT INTO `grade` VALUES (80, 5, 'Xb16620110', 81);
INSERT INTO `grade` VALUES (81, 1, 'Xb16620111', 50);
INSERT INTO `grade` VALUES (82, 5, 'Xb16620112', 32);
INSERT INTO `grade` VALUES (83, 5, 'Xb16620113', 32);
INSERT INTO `grade` VALUES (84, 6, 'Xb16620114', 91);
INSERT INTO `grade` VALUES (85, 7, 'Xb16620115', 29);
INSERT INTO `grade` VALUES (86, 6, 'Xb16620116', 93);
INSERT INTO `grade` VALUES (87, 9, 'Xb16620117', 69);
INSERT INTO `grade` VALUES (88, 9, 'Xb16620118', 47);
INSERT INTO `grade` VALUES (89, 2, 'Xb16620119', 64);
INSERT INTO `grade` VALUES (90, 2, 'Xb16620120', 38);
INSERT INTO `grade` VALUES (91, 2, 'Xb16620121', 37);
INSERT INTO `grade` VALUES (92, 7, 'Xb16620122', 49);
INSERT INTO `grade` VALUES (93, 4, 'Xb16620123', 62);
INSERT INTO `grade` VALUES (94, 7, 'Xb16620124', 27);
INSERT INTO `grade` VALUES (95, 3, 'Xb16620125', 91);
INSERT INTO `grade` VALUES (96, 6, 'Xb16620126', 76);
INSERT INTO `grade` VALUES (97, 4, 'Xb16620127', 85);
INSERT INTO `grade` VALUES (98, 1, 'Xb16620128', 62);
INSERT INTO `grade` VALUES (99, 4, 'Xb16620129', 80);
INSERT INTO `grade` VALUES (100, 6, 'Xb16620130', 72);
INSERT INTO `grade` VALUES (101, 3, 'Xb16620131', 29);
INSERT INTO `grade` VALUES (102, 6, 'Xb16620201', 70);
INSERT INTO `grade` VALUES (103, 8, 'Xb16620202', 46);
INSERT INTO `grade` VALUES (104, 6, 'Xb16620203', 22);
INSERT INTO `grade` VALUES (105, 7, 'Xb16620205', 42);
INSERT INTO `grade` VALUES (106, 5, 'Xb16620206', 57);
INSERT INTO `grade` VALUES (107, 2, 'Xb16620207', 72);
INSERT INTO `grade` VALUES (108, 9, 'Xb16620208', 46);
INSERT INTO `grade` VALUES (109, 8, 'Xb16620209', 77);
INSERT INTO `grade` VALUES (110, 1, 'Xb16620210', 80);
INSERT INTO `grade` VALUES (111, 5, 'Xb16620211', 96);
INSERT INTO `grade` VALUES (112, 3, 'Xb16620212', 77);
INSERT INTO `grade` VALUES (113, 9, 'Xb16620213', 20);
INSERT INTO `grade` VALUES (114, 7, 'Xb16620214', 43);
INSERT INTO `grade` VALUES (115, 1, 'Xb16620215', 87);
INSERT INTO `grade` VALUES (116, 9, 'Xb16620216', 76);
INSERT INTO `grade` VALUES (117, 3, 'Xb16620217', 77);
INSERT INTO `grade` VALUES (118, 9, 'Xb16620218', 38);
INSERT INTO `grade` VALUES (119, 5, 'Xb16620219', 76);
INSERT INTO `grade` VALUES (120, 8, 'Xb16620220', 60);
INSERT INTO `grade` VALUES (121, 6, 'Xb16620221', 49);
INSERT INTO `grade` VALUES (122, 3, 'Xb16620222', 81);
INSERT INTO `grade` VALUES (123, 6, 'Xb16620223', 21);
INSERT INTO `grade` VALUES (124, 7, 'Xb16620224', 74);
INSERT INTO `grade` VALUES (125, 6, 'Xb16620225', 33);
INSERT INTO `grade` VALUES (126, 6, 'Xb16620226', 93);
INSERT INTO `grade` VALUES (127, 1, 'Xb16620227', 66);
INSERT INTO `grade` VALUES (128, 8, 'Xb16620228', 59);
INSERT INTO `grade` VALUES (129, 4, 'Xb16620229', 70);
INSERT INTO `grade` VALUES (130, 7, 'Xb16620230', 49);
INSERT INTO `grade` VALUES (131, 7, 'Xb16620231', 63);
INSERT INTO `grade` VALUES (132, 2, 'Xb16620233', 70);
INSERT INTO `grade` VALUES (133, 3, 'Xb16680108', 85);
INSERT INTO `grade` VALUES (134, 3, 'Xc16560217', 97);
INSERT INTO `grade` VALUES (135, 7, 'Xf16220132', 22);
INSERT INTO `grade` VALUES (136, 6, 'Xb16610222', 48);
INSERT INTO `grade` VALUES (137, 4, 'Xb16610226', 69);
INSERT INTO `grade` VALUES (138, 4, 'Xb16620101', 99);
INSERT INTO `grade` VALUES (139, 7, 'Xb16620102', 68);
INSERT INTO `grade` VALUES (140, 9, 'Xb16620103', 94);
INSERT INTO `grade` VALUES (141, 7, 'Xb16620104', 59);
INSERT INTO `grade` VALUES (142, 8, 'Xb16620105', 65);
INSERT INTO `grade` VALUES (143, 9, 'Xb16620106', 25);
INSERT INTO `grade` VALUES (144, 2, 'Xb16620107', 70);
INSERT INTO `grade` VALUES (145, 2, 'Xb16620108', 35);
INSERT INTO `grade` VALUES (146, 5, 'Xb16620109', 70);
INSERT INTO `grade` VALUES (147, 3, 'Xb16620110', 29);
INSERT INTO `grade` VALUES (148, 1, 'Xb16620111', 37);
INSERT INTO `grade` VALUES (149, 4, 'Xb16620112', 58);
INSERT INTO `grade` VALUES (150, 6, 'Xb16620113', 80);
INSERT INTO `grade` VALUES (151, 9, 'Xb16620114', 50);
INSERT INTO `grade` VALUES (152, 6, 'Xb16620115', 63);
INSERT INTO `grade` VALUES (153, 7, 'Xb16620116', 89);
INSERT INTO `grade` VALUES (154, 8, 'Xb16620117', 57);
INSERT INTO `grade` VALUES (155, 1, 'Xb16620118', 57);
INSERT INTO `grade` VALUES (156, 4, 'Xb16620119', 33);
INSERT INTO `grade` VALUES (157, 8, 'Xb16620120', 84);
INSERT INTO `grade` VALUES (158, 9, 'Xb16620121', 83);
INSERT INTO `grade` VALUES (159, 4, 'Xb16620122', 76);
INSERT INTO `grade` VALUES (160, 7, 'Xb16620123', 89);
INSERT INTO `grade` VALUES (161, 6, 'Xb16620124', 72);
INSERT INTO `grade` VALUES (162, 7, 'Xb16620125', 62);
INSERT INTO `grade` VALUES (163, 8, 'Xb16620126', 85);
INSERT INTO `grade` VALUES (164, 2, 'Xb16620127', 97);
INSERT INTO `grade` VALUES (165, 3, 'Xb16620128', 34);
INSERT INTO `grade` VALUES (166, 8, 'Xb16620129', 88);
INSERT INTO `grade` VALUES (167, 8, 'Xb16620130', 47);
INSERT INTO `grade` VALUES (168, 7, 'Xb16620131', 66);
INSERT INTO `grade` VALUES (169, 7, 'Xb16620201', 90);
INSERT INTO `grade` VALUES (170, 8, 'Xb16620202', 23);
INSERT INTO `grade` VALUES (171, 9, 'Xb16620203', 40);
INSERT INTO `grade` VALUES (172, 6, 'Xb16620205', 46);
INSERT INTO `grade` VALUES (173, 7, 'Xb16620206', 36);
INSERT INTO `grade` VALUES (174, 4, 'Xb16620207', 46);
INSERT INTO `grade` VALUES (175, 8, 'Xb16620208', 74);
INSERT INTO `grade` VALUES (176, 3, 'Xb16620209', 43);
INSERT INTO `grade` VALUES (177, 7, 'Xb16620210', 82);
INSERT INTO `grade` VALUES (178, 6, 'Xb16620211', 91);
INSERT INTO `grade` VALUES (179, 4, 'Xb16620212', 59);
INSERT INTO `grade` VALUES (180, 4, 'Xb16620213', 70);
INSERT INTO `grade` VALUES (181, 8, 'Xb16620214', 70);
INSERT INTO `grade` VALUES (182, 6, 'Xb16620215', 66);
INSERT INTO `grade` VALUES (183, 4, 'Xb16620216', 28);
INSERT INTO `grade` VALUES (184, 2, 'Xb16620217', 95);
INSERT INTO `grade` VALUES (185, 3, 'Xb16620218', 81);
INSERT INTO `grade` VALUES (186, 9, 'Xb16620219', 96);
INSERT INTO `grade` VALUES (187, 8, 'Xb16620220', 55);
INSERT INTO `grade` VALUES (188, 8, 'Xb16620221', 35);
INSERT INTO `grade` VALUES (189, 8, 'Xb16620222', 86);
INSERT INTO `grade` VALUES (190, 2, 'Xb16620223', 98);
INSERT INTO `grade` VALUES (191, 9, 'Xb16620224', 58);
INSERT INTO `grade` VALUES (192, 3, 'Xb16620225', 21);
INSERT INTO `grade` VALUES (193, 1, 'Xb16620226', 36);
INSERT INTO `grade` VALUES (194, 8, 'Xb16620227', 49);
INSERT INTO `grade` VALUES (195, 7, 'Xb16620228', 61);
INSERT INTO `grade` VALUES (196, 7, 'Xb16620229', 41);
INSERT INTO `grade` VALUES (197, 9, 'Xb16620230', 96);
INSERT INTO `grade` VALUES (198, 3, 'Xb16620231', 95);
INSERT INTO `grade` VALUES (199, 5, 'Xb16620233', 62);
INSERT INTO `grade` VALUES (200, 7, 'Xb16680108', 43);
INSERT INTO `grade` VALUES (201, 8, 'Xc16560217', 99);
INSERT INTO `grade` VALUES (202, 2, 'Xf16220132', 66);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `stu_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stu_class` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stu_dept` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`stu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('Xb16610222', '周游', '12', '男', '16计算机科学与技术（2）', '机电系', 21, '15558016606');
INSERT INTO `student` VALUES ('Xb16610226', '牛小璐', '23', '女', '16计算机科学与技术（1）', '机电系', 21, '13290928379');
INSERT INTO `student` VALUES ('Xb16620101', '鲍佳忠', '13', '男', '16计算机科学与技术（1）', '机电系', 20, '15868178656');
INSERT INTO `student` VALUES ('Xb16620102', '查晨威', '13', '男', '16计算机科学与技术（1）', '机电系', 21, '17826871109');
INSERT INTO `student` VALUES ('Xb16620103', '陈辉', '14', '男', '16计算机科学与技术（1）', '机电系', 20, '18758820407');
INSERT INTO `student` VALUES ('Xb16620104', '陈杰', '15', '男', '16计算机科学与技术（1）', '机电系', 21, '18305871862');
INSERT INTO `student` VALUES ('Xb16620105', '陈镪', '16', '男', '16计算机科学与技术（1）', '机电系', 20, '13958906173');
INSERT INTO `student` VALUES ('Xb16620106', '陈钰博', NULL, '男', '16计算机科学与技术（1）', '机电系', 20, '18805873328');
INSERT INTO `student` VALUES ('Xb16620107', '冯佳鹏', NULL, '男', '16计算机科学与技术（1）', '机电系', 20, '15868176653');
INSERT INTO `student` VALUES ('Xb16620108', '韩锦辉', NULL, '男', '16计算机科学与技术（1）', '机电系', 21, '15858243024');
INSERT INTO `student` VALUES ('Xb16620109', '李志祥', NULL, '男', '16计算机科学与技术（1）', '机电系', 21, '15158759500');
INSERT INTO `student` VALUES ('Xb16620110', '柳成昊', NULL, '男', '16计算机科学与技术（1）', '机电系', 20, '15862875751');
INSERT INTO `student` VALUES ('Xb16620111', '陆沛', NULL, '男', '16计算机科学与技术（1）', '机电系', 20, '15868176071');
INSERT INTO `student` VALUES ('Xb16620112', '罗雷', NULL, '男', '16计算机科学与技术（1）', '机电系', 20, '15888793436');
INSERT INTO `student` VALUES ('Xb16620113', '瞿如勇', NULL, '男', '16计算机科学与技术（1）', '机电系', 20, '17301851372');
INSERT INTO `student` VALUES ('Xb16620114', '滕刚峰', NULL, '男', '16计算机科学与技术（1）', '机电系', 21, '15868175021');
INSERT INTO `student` VALUES ('Xb16620115', '王子轩', NULL, '男', '16计算机科学与技术（1）', '机电系', 20, '15868173887');
INSERT INTO `student` VALUES ('Xb16620116', '温正鸿', NULL, '男', '16计算机科学与技术（1）', '机电系', 20, '17348845891');
INSERT INTO `student` VALUES ('Xb16620117', '吴润豪', NULL, '男', '16计算机科学与技术（1）', '机电系', 21, '17815514153');
INSERT INTO `student` VALUES ('Xb16620118', '谢栋', NULL, '男', '16计算机科学与技术（1）', '机电系', 21, '15868173623');
INSERT INTO `student` VALUES ('Xb16620119', '许俊杰', NULL, '男', '16计算机科学与技术（1）', '机电系', 21, '17815514385');
INSERT INTO `student` VALUES ('Xb16620120', '杨思誉', NULL, '男', '16计算机科学与技术（1）', '机电系', 20, '17348846507');
INSERT INTO `student` VALUES ('Xb16620121', '姚光虎', NULL, '男', '16计算机科学与技术（1）', '机电系', 20, '18226711519');
INSERT INTO `student` VALUES ('Xb16620122', '臧苏云', NULL, '男', '16计算机科学与技术（1）', '机电系', 21, '17348847363');
INSERT INTO `student` VALUES ('Xb16620123', '张鑫磊', NULL, '男', '16计算机科学与技术（1）', '机电系', 20, '15727835736');
INSERT INTO `student` VALUES ('Xb16620124', '朱清尧', NULL, '男', '16计算机科学与技术（1）', '机电系', 21, '15868171732');
INSERT INTO `student` VALUES ('Xb16620125', '丁滢', NULL, '女', '16计算机科学与技术（1）', '机电系', 21, '13777446398');
INSERT INTO `student` VALUES ('Xb16620126', '方巧梨', NULL, '女', '16计算机科学与技术（1）', '机电系', 21, '15868171527');
INSERT INTO `student` VALUES ('Xb16620127', '黄诺琳', NULL, '女', '16计算机科学与技术（1）', '机电系', 21, '15868171201');
INSERT INTO `student` VALUES ('Xb16620128', '毛婷钰', NULL, '女', '16计算机科学与技术（1）', '机电系', 20, '15868170873');
INSERT INTO `student` VALUES ('Xb16620129', '唐倩倩', NULL, '女', '16计算机科学与技术（1）', '机电系', 21, '13515857405');
INSERT INTO `student` VALUES ('Xb16620130', '汪雨佳', NULL, '女', '16计算机科学与技术（1）', '机电系', 20, '18758140745');
INSERT INTO `student` VALUES ('Xb16620131', '周晓姌', NULL, '女', '16计算机科学与技术（1）', '机电系', 21, '18297960291');
INSERT INTO `student` VALUES ('Xb16620201', '蔡克建', NULL, '男', '16计算机科学与技术（2）', '机电系', 21, '15868170211');
INSERT INTO `student` VALUES ('Xb16620202', '常梦然', NULL, '男', '16计算机科学与技术（2）', '机电系', 21, '17815513172');
INSERT INTO `student` VALUES ('Xb16620203', '陈柯奇', NULL, '男', '16计算机科学与技术（2）', '机电系', 21, '18368548059');
INSERT INTO `student` VALUES ('Xb16620205', '李凯旋', NULL, '男', '16计算机科学与技术（2）', '机电系', 20, '17815513159');
INSERT INTO `student` VALUES ('Xb16620206', '廖晓峰', NULL, '男', '16计算机科学与技术（2）', '机电系', 20, '18767873401');
INSERT INTO `student` VALUES ('Xb16620207', '林炜祎', NULL, '男', '16计算机科学与技术（2）', '机电系', 21, '13757006078');
INSERT INTO `student` VALUES ('Xb16620208', '陆宇豪', NULL, '男', '16计算机科学与技术（2）', '机电系', 21, '15868168532');
INSERT INTO `student` VALUES ('Xb16620209', '毛克杰', NULL, '男', '16计算机科学与技术（2）', '机电系', 21, '15706811257');
INSERT INTO `student` VALUES ('Xb16620210', '宁清晨', NULL, '男', '16计算机科学与技术（2）', '机电系', 20, '15868167293');
INSERT INTO `student` VALUES ('Xb16620211', '沈锋', NULL, '男', '16计算机科学与技术（2）', '机电系', 21, '13858422964');
INSERT INTO `student` VALUES ('Xb16620212', '史佳明', NULL, '男', '16计算机科学与技术（2）', '机电系', 21, '15157363008');
INSERT INTO `student` VALUES ('Xb16620213', '唐子豪', NULL, '男', '16计算机科学与技术（2）', '机电系', 20, '15268064624');
INSERT INTO `student` VALUES ('Xb16620214', '王金旭', NULL, '男', '16计算机科学与技术（2）', '机电系', 21, '17348845309');
INSERT INTO `student` VALUES ('Xb16620215', '王俊达', NULL, '男', '16计算机科学与技术（2）', '机电系', 21, '15727885016');
INSERT INTO `student` VALUES ('Xb16620216', '王一帆', NULL, '男', '16计算机科学与技术（2）', '机电系', 20, '15868163725');
INSERT INTO `student` VALUES ('Xb16620217', '吴鑫潮', NULL, '男', '16计算机科学与技术（2）', '机电系', 20, '15868163631');
INSERT INTO `student` VALUES ('Xb16620218', '许鑫磊', NULL, '男', '16计算机科学与技术（2）', '机电系', 21, '18357616066');
INSERT INTO `student` VALUES ('Xb16620219', '叶军', NULL, '男', '16计算机科学与技术（2）', '机电系', 20, '17815513117');
INSERT INTO `student` VALUES ('Xb16620220', '张金奎', NULL, '男', '16计算机科学与技术（2）', '机电系', 21, '17348845296');
INSERT INTO `student` VALUES ('Xb16620221', '张能', NULL, '男', '16计算机科学与技术（2）', '机电系', 20, '17348845931');
INSERT INTO `student` VALUES ('Xb16620222', '张伟元', NULL, '男', '16计算机科学与技术（2）', '机电系', 20, '15755066402');
INSERT INTO `student` VALUES ('Xb16620223', '钟黎辉', NULL, '男', '16计算机科学与技术（2）', '机电系', 20, '17348845769');
INSERT INTO `student` VALUES ('Xb16620224', '朱炫翰', NULL, '男', '16计算机科学与技术（2）', '机电系', 20, '15868162125');
INSERT INTO `student` VALUES ('Xb16620225', '施嘉琪', NULL, '女', '16计算机科学与技术（2）', '机电系', 20, '18257878812');
INSERT INTO `student` VALUES ('Xb16620226', '王超群', NULL, '女', '16计算机科学与技术（2）', '机电系', 21, '15957662859');
INSERT INTO `student` VALUES ('Xb16620227', '王秀仪', NULL, '女', '16计算机科学与技术（2）', '机电系', 19, '13857591503');
INSERT INTO `student` VALUES ('Xb16620228', '王依丽', NULL, '女', '16计算机科学与技术（2）', '机电系', 21, '15215806906');
INSERT INTO `student` VALUES ('Xb16620229', '姚莹莹', NULL, '女', '16计算机科学与技术（2）', '机电系', 21, '15868160890');
INSERT INTO `student` VALUES ('Xb16620230', '张伟', NULL, '女', '16计算机科学与技术（2）', '机电系', 21, '15868160576');
INSERT INTO `student` VALUES ('Xb16620231', '章宝丹', NULL, '女', '16计算机科学与技术（2）', '机电系', 20, '15868160530');
INSERT INTO `student` VALUES ('Xb16620233', '赖博纯', NULL, '男', '16计算机科学与技术（2）', '机电系', 20, '13706610709');
INSERT INTO `student` VALUES ('Xb16680108', '李智敏', NULL, '男', '16计算机科学与技术（1）', '机电系', 20, '15868159657');
INSERT INTO `student` VALUES ('Xc16560217', '毛飞红', NULL, '女', '16计算机科学与技术（1）', '机电系', 20, '15268883533');
INSERT INTO `student` VALUES ('Xf16220132', '祝勇强', NULL, '男', '16计算机科学与技术（2）', '机电系', 21, '15868101035');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `teacher_id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `education` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `academic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`teacher_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('T0001', '蓝庆青', '1', '男', '本科', '高级', 21, '13666654939');
INSERT INTO `teacher` VALUES ('T0002', '马春生', '2', '女', '硕士', '中级', 22, '13685758573');
INSERT INTO `teacher` VALUES ('T0003', '石永锋', '3', '男', '博士', '高级', 23, '15988195009');
INSERT INTO `teacher` VALUES ('T0004', '邓斌峰', '4', '女', '本科', '中级', 24, '15058198908');
INSERT INTO `teacher` VALUES ('T0005', '陈伟平', '5', '女', '硕士', '高级', 25, '13516818660');
INSERT INTO `teacher` VALUES ('T0006', '汤宁', '7', '男', '博士', '中级', 26, '13958072003');
INSERT INTO `teacher` VALUES ('T0007', '贝金铸', '8', '女', '本科', '高级', 27, '13073678787');
INSERT INTO `teacher` VALUES ('T0008', '伍小龙', NULL, '男', '硕士', '中级', 28, '13777427187');
INSERT INTO `teacher` VALUES ('T0009', '戴小珍', NULL, '女', '博士', '高级', 29, '13958005979');
INSERT INTO `teacher` VALUES ('T0010', '贺建辉', NULL, '女', '本科', '中级', 30, '13706509464');
INSERT INTO `teacher` VALUES ('T0011', '吕洪炜', NULL, '男', '硕士', '高级', 31, '15857105099');
INSERT INTO `teacher` VALUES ('T0012', '陆晓燕', NULL, '女', '博士', '中级', 32, '13588746821');
INSERT INTO `teacher` VALUES ('T0013', '包晓安', NULL, '男', '本科', '高级', 33, '13221413078');
INSERT INTO `teacher` VALUES ('T0014', '陈江丽', NULL, '女', '硕士', '中级', 34, '13819147442');
INSERT INTO `teacher` VALUES ('T0015', '鲍小忠', NULL, '女', '博士', '高级', 35, '13706815155');
INSERT INTO `teacher` VALUES ('T0016', '周薇', NULL, '男', '本科', '中级', 36, '15858137735');
INSERT INTO `teacher` VALUES ('T0017', '王丽婷', NULL, '男', '硕士', '高级', 21, '15858260962');
INSERT INTO `teacher` VALUES ('T0018', '谢春伟', NULL, '女', '本科', '中级', 22, '18057139126');
INSERT INTO `teacher` VALUES ('T0019', '陈渭力', NULL, '男', '硕士', '高级', 23, '13867473330');
INSERT INTO `teacher` VALUES ('T0020', '陈淼', NULL, '女', '博士', '中级', 24, '15067189774');
INSERT INTO `teacher` VALUES ('T0021', '陈伟平', NULL, '女', '本科', '高级', 25, '15058178684');
INSERT INTO `teacher` VALUES ('T0022', '邓斌峰', NULL, '男', '硕士', '中级', 26, '15058198908');
INSERT INTO `teacher` VALUES ('T0023', '钱津津', NULL, '男', '博士', '高级', 27, '15267008311');
INSERT INTO `teacher` VALUES ('T0024', '潘晓丹', NULL, '女', '本科', '中级', 28, '13588144405');
INSERT INTO `teacher` VALUES ('T0025', '王燕青', NULL, '男', '硕士', '高级', 29, '15088688749');
INSERT INTO `teacher` VALUES ('T0026', '张哲丽', NULL, '男', '博士', '中级', 30, '13666651246');
INSERT INTO `teacher` VALUES ('T0027', '刘海霞', NULL, '女', '本科', '高级', 31, '15868483883');
INSERT INTO `teacher` VALUES ('T0028', '熊立本', NULL, '男', '硕士', '中级', 32, '15088639863');
INSERT INTO `teacher` VALUES ('T0029', '吕洪炜', NULL, '女', '博士', '高级', 33, '15857105099');
INSERT INTO `teacher` VALUES ('T0030', '王菊雅', NULL, '女', '本科', '中级', 34, '13735461858');
INSERT INTO `teacher` VALUES ('T0031', '张胜利', NULL, '男', '硕士', '高级', 35, '15700191299');
INSERT INTO `teacher` VALUES ('T0032', '刘天', NULL, '女', '博士', '中级', 36, '13958188413');
INSERT INTO `teacher` VALUES ('T0033', '唐柳青', NULL, '男', '本科', '高级', 21, '15158107216');
INSERT INTO `teacher` VALUES ('T0034', '王春平', NULL, '男', '硕士', '中级', 22, '13515815152');
INSERT INTO `teacher` VALUES ('T0035', '钱津津', NULL, '女', '博士', '高级', 23, '15267008311');
INSERT INTO `teacher` VALUES ('T0036', '陈淼', NULL, '男', '本科', '中级', 24, '15067189774');
INSERT INTO `teacher` VALUES ('T0037', '陈渭力', NULL, '女', '硕士', '高级', 25, '13867473330');
INSERT INTO `teacher` VALUES ('T0038', '郑春玲', NULL, '女', '博士', '中级', 26, '18057139853');
INSERT INTO `teacher` VALUES ('T0039', '邓斌峰', NULL, '男', '本科', '高级', 27, '15058198908');

SET FOREIGN_KEY_CHECKS = 1;
