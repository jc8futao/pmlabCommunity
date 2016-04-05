#如果复制到mysql中执行时 加上
#DELIMITER ;;

drop table if exists `sys_user`;;
drop table if exists `sys_role`;;
drop table if exists `sys_permission`;;
drop table if exists `sys_role_resource_permission`;;
drop table if exists `sys_auth`;;

##user
create table `sys_user`(
  `id`         bigint not null auto_increment,
  `openid`  varchar(100),
  `username`  varchar(100),
  `email`  varchar(100),
  `mobilePhoneNumber`  varchar(20),
  `password`  varchar(100),
  `salt`       varchar(100),
  `createDate` timestamp default 0,
  `admin`     bool,
  constraint `pk_sys_user` primary key(`id`),
  constraint `unique_sys_user_username` unique(`username`),
  constraint `unique_sys_user_email` unique(`email`),
  constraint `unique_sys_user_mobile_phone_number` unique(`mobilePhoneNumber`)
) charset=utf8 ENGINE=InnoDB;;
alter table `sys_user` auto_increment=1000;;

create table `sys_permission`(
  `id`         bigint not null auto_increment,
  `name`      varchar(100),
  `permission`  varchar(100),
  `description`      varchar(200),
  `show`       bool,
  constraint `pk_sys_permission` primary key(`id`),
  index idx_sys_permission_name (`name`),
  index idx_sys_permission_permission (`permission`),
  index idx_sys_permission_show (`show`)
) charset=utf8 ENGINE=InnoDB;;
alter table `sys_permission` auto_increment=1000;;

create table `sys_role`(
  `id`         bigint not null auto_increment,
  `name`      varchar(100),
  `role`  varchar(100),
  `description`      varchar(200),
  `show`       bool,
  constraint `pk_sys_role` primary key(`id`),
  index `idx_sys_role_name` (`name`),
  index `idx_sys_role_role` (`role`),
  index `idx_sys_role_show` (`show`)
) charset=utf8 ENGINE=InnoDB;;
alter table `sys_role` auto_increment=1000;;

create table `sys_role_resource_permission`(
  `id`         bigint not null auto_increment,
  `role_id`   bigint,
  `resource_id` bigint,
  `permission_ids` varchar(500),
  constraint `pk_sys_role_resource_permission` primary key(`id`),
  constraint `unique_sys_role_resource_permission` unique(`role_id`, `resource_id`)
) charset=utf8 ENGINE=InnoDB;;
alter table `sys_role_resource_permission` auto_increment=1000;;

create table `sys_auth`(
  `id`         bigint not null auto_increment,
  `user_id`        bigint,
  `role_ids`       varchar(500),
  constraint `pk_sys_auth` primary key(`id`),
  index `idx_sys_auth_user` (`user_id`)
) charset=utf8 ENGINE=InnoDB;;
alter table `sys_auth` auto_increment=1000;;
