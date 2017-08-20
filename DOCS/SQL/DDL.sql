-- table template
/*
drop table if exists ${tableName};

create table ${tableName}(
    id varchar(20) comment '主键id',
    create_time datetime comment '创建时间',
    create_user varchar(32) comment '创建人',
    update_time datetime comment '更新时间',
    update_user varchar(32) comment '更新人',
    primary key (id)
);

alter table ${tableName} comment '';
*/


/* demo表 */
drop table if exists t_demo;

create table t_demo(
    id varchar(20) comment '主键id',
    demo_name varchar(32) comment 'demo name',
    demo_value varchar(32) comment 'demo value',
    del_flag tinyint comment '删除标识：1=删除，0=未删除',
    create_time datetime comment '创建时间',
    create_user varchar(32) comment '创建人',
    update_time datetime comment '更新时间',
    update_user varchar(32) comment '更新人',
    primary key (id)
);

alter table t_car_demo comment 'demo 表';