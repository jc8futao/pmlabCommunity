SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for pmlab_enroll
-- ----------------------------
DROP TABLE IF EXISTS `pmlab_enroll`;
CREATE TABLE `pmlab_enroll` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `eventId` bigint(20) NOT NULL,
  `userId` bigint(20) NOT NULL,
  `realName` varchar(64) NOT NULL,
  `mobilePhoneNumber` varchar(32) NOT NULL,
  `company` varchar(64) NOT NULL DEFAULT '',
  `jobTitle` varchar(32) NOT NULL DEFAULT '',
  `enrollTime` datetime NOT NULL,
  `enrollStatus` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `index_eventId` (`eventId`),
  KEY `index_userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pmlab_enroll
-- ----------------------------

-- ----------------------------
-- Table structure for pmlab_event
-- ----------------------------
DROP TABLE IF EXISTS `pmlab_event`;
CREATE TABLE `pmlab_event` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creatorId` bigint(20) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  `title` varchar(512) NOT NULL,
  `coverUrl` varchar(512) NOT NULL DEFAULT '',
  `content` text NOT NULL,
  `limited` int(11) NOT NULL DEFAULT '0',
  `enrollNum` int(11) NOT NULL DEFAULT '0',
  `target` int(11) NOT NULL DEFAULT '0',
  `address` varchar(512) NOT NULL DEFAULT '',
  `published` tinyint(1) NOT NULL DEFAULT '0',
  `publishTime` datetime DEFAULT NULL,
  `closingTime` datetime NOT NULL,
  `startTime` datetime NOT NULL,
  `finishDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pmlab_event
-- ----------------------------

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(64) NOT NULL,
  `permission` varchar(64) NOT NULL,
  `description` varchar(512) NOT NULL DEFAULT '',
  `show` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(64) NOT NULL,
  `name` varchar(64) NOT NULL,
  `description` varchar(512) NOT NULL DEFAULT '',
  `buildIn` tinyint(1) NOT NULL DEFAULT '0',
  `show` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `index_role` (`role`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_role_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission_relation`;
CREATE TABLE `sys_role_permission_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleId` bigint(20) NOT NULL,
  `permissionId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission_relation
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `openid` varchar(64) NOT NULL DEFAULT '',
  `username` varchar(64) NOT NULL,
  `realName` varchar(64) NOT NULL,
  `mobilePhoneNumber` varchar(32) NOT NULL,
  `email` varchar(128) NOT NULL DEFAULT '',
  `password` varchar(64) NOT NULL,
  `salt` varchar(64) NOT NULL,
  `createDate` datetime NOT NULL,
  `createSources` tinyint(4) NOT NULL,
  `companyName` varchar(256) NOT NULL DEFAULT '',
  `jobTitle` varchar(64) NOT NULL,
  `jobType` tinyint(4) NOT NULL,
  `jobDescription` varchar(512) NOT NULL DEFAULT '',
  `admin` tinyint(1) NOT NULL DEFAULT '0',
  `locked` tinyint(1) NOT NULL DEFAULT '0',
  `description` varchar(512) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_openId` (`openid`),
  UNIQUE KEY `index_mobile` (`mobilePhoneNumber`),
  KEY `index_credential` (`username`,`password`,`salt`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role_relation`;
CREATE TABLE `sys_user_role_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) NOT NULL,
  `roleId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `index_userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role_relation
-- ----------------------------