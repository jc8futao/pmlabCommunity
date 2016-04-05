#如果复制到mysql中执行时 加上
#DELIMITER ;;

truncate `sys_user`;;
/*默认admin/123456*/
insert into `sys_user`
(`id`, `username`, `openid`,`email`, `mobilePhoneNumber`, `password`, `salt`, `createDate`, `admin`)
  values
  (1, 'admin', 'admin@pmlabs.cn', '','13412345671', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', sysdate(), 1);;

truncate table `sys_role`;;
insert into `sys_role` (`id`, `name`, `role`, `description`, `is_show`) values (1,  '超级管理员', 'admin', '拥有所有权限', 1);;
truncate table `sys_permission`;;
insert into `sys_permission` (`id`, `name`, `permission`, `description`, `is_show`) values (1, '所有', '*', '所有数据操作的权限', 1);;

truncate table `sys_auth`;;
insert into sys_auth (`id`, `user_id`, `role_ids`)
  values(1, 1, '1');;