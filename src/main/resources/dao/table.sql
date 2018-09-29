/* 数据表模型 */
create table if not exists table_config(
	table_name varchar(100),
	key_name varchar(512)
)

truncate table table_config;
insert into table_config(table_name, key_name) values('teacher','teacherId'), ('grade','classId') ,('teaching','teachingId');
insert into table_config(table_name, key_name) values('student','studentId');
insert into table_config(table_name, key_name) values('staff','staffId');
insert into table_config(table_name, key_name) values('attendance','attendanceId');
insert into table_config(table_name, key_name) values('ognization','ognizationId');
insert into table_config(table_name, key_name) values('weixin_joinClass','classId');
insert into table_config(table_name, key_name) values('weixin_joinPerson','personId');
insert into table_config(table_name, key_name) values('weixin_employee','foreignerId');
insert into table_config(table_name, key_name) values('weixin_points','pointsId');
insert into table_config(table_name, key_name) values('weixin_songClass','songClassId');
insert into table_config(table_name, key_name) values('weixin_songList','songListId');