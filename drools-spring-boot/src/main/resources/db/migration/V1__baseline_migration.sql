create table rules_config
(
    id    int unsigned auto_increment primary key,
    scene varchar(50)  not null comment '场景',
    rule  varchar(300) not null comment '规则代码'
) engine = innodb
  default charset = utf8mb4 comment ='规则配置';
