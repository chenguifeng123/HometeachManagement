/* 外教 */
DROP TABLE IF EXISTS teacher;
create table if not exists teacher
(
	teacherId int auto_increment,
	firstName varchar(256),
	lastName varchar(256),
	gender int,
	brithday varchar(256),
	county varchar(256),
	visaExpiredTime varchar(256),
	motherLanguage varchar(256),
	secondLanguage varchar(256),
	secondLanguageLevel varchar(256),
	photo varchar(256),
	educationBackground int,
	degree int,
	status int,
	teachingCertificate int,
	teachingExperience int,
	studyOrWorkPlace varchar(256),
	address varchar(256),
	phone varchar(256),
	introduction varchar(256),
	video varchar(256),
	teachingTime varchar(256),
	teachingArea varchar(256),
	paymentType int,
	paymentAccount varchar(256),
	hourSalary varchar(256),
	joinTime varchar(256),
	PRIMARY KEY (teacherId)
)

/*  班级  */
DROP TABLE IF EXISTS grade;
create table if not exists grade(
	classId  int auto_increment,
	className  varchar(256),
	classType  int,
	ognizationId int,
	kidsNumber  int,
	startBook  int,,
	currentBook  int,
	teacherId  int,
	transportAllowance  int,
	classNumber  int,
	teachingTime1  varchar(256),
	classDuration1  int,
	teachingTime2	varchar(256),
	classDuration2  int,
	startTime  varchar(256),
	address  varchar(256),
	teachingAssistant  varchar(256),
	PRIMARY KEY (classId)
)

/*  授课  */
DROP TABLE IF EXISTS teaching;
create table if not exists teaching(
	teachingId  int auto_increment,
	classId  int,
	teachingType int,
	absentReason int,
	teacherId  int,
	teachingDate  varchar(256),
	teachingTime  varchar(256),
	teachingAddress  varchar(256),
	contactPhoneNumber  varchar(256),
	lastClassNumber  int,
	currentClassNumber  int,
	lastTeachingPeriod  varchar(256),
	currentTeachingPeriod  varchar(256),
	teacherArriveTime  varchar(256),
	beLate  int,
	absentStudentId  varchar(256),
	memo varchar(1024)
	PRIMARY KEY (teachingId)
)

DROP TABLE IF EXISTS student;
create table if not exists student
(
	studentId int auto_increment,
	globalId bigint,
	chineseName varchar(256),
	englishName varchar(256),
	classId int,
	gender int,
	brithday varchar(256),
	address varchar(256),
	motherPhone varchar(256),
	motherWorkPlace varchar(256),
	fatherPhone varchar(256),
	fatherWorkPlace varchar(256),
	startDate varchar(256),
	PRIMARY KEY (studentId)
)

DROP TABLE IF EXISTS staff;
create table if not exists staff
(
	staffId int auto_increment,
	chineseName varchar(256),
	englishName varchar(256),
	gender int,
	brithday varchar(256),
	education int,
	station varchar(256),
	workType int,
	salary int,
	joinDate varchar(256),
	PRIMARY KEY (staffId)
)

DROP TABLE IF EXISTS attendance;
create table if not exists attendance
(
	attendanceId int auto_increment,
	attendanceTime varchar(256),
	attendanceType int,
	staffId int,
	workingPay int,
	reason varchar(1024),
	PRIMARY KEY (attendanceId)
)

DROP TABLE IF EXISTS ognization;
create table if not exists ognization
(
	ognizationId int auto_increment,
	teachingName varchar(256),
	ognizationName varchar(256),
	ognizationOwner varchar(256),
	contact varchar(256),
	address varchar(256),
	cooperation int,
	details varchar(256),
	signTime varchar(256),
	signEnding varchar(256),
	tude  varchar(256),
	PRIMARY KEY (ognizationId)
)

DROP TABLE IF EXISTS weixin_joinClass;
create table if not exists weixin_joinClass
(
	classId int auto_increment,
	className varchar(256),
	childAge int,
	minNum int,
	openid varchar(256),
	nickName varchar(256),
	iconPath varchar(2048),
	contactName varchar(256),
	phoneNumber varchar(256),
	area varchar(256),
	address varchar(256),
	PRIMARY KEY (classId)
)

DROP TABLE IF EXISTS weixin_joinPerson;
create table if not exists weixin_joinPerson
(
	personId int auto_increment,
	classId int,
	childAge int,
	openid varchar(256),
	nickName varchar(256),
	iconPath varchar(2048),
	isStarter int,
	contactName varchar(256),
	phoneNumber varchar(256),
	area varchar(256),
	address varchar(256),
	PRIMARY KEY (personId)
)

DROP TABLE IF EXISTS weixin_employee;
create table if not exists weixin_employee
(
	foreignerId int auto_increment,
	openid varchar(256),
	iconPath varchar(2048),
	firstName varchar(256),
	lastName varchar(256),
	gender int,
	country varchar(256),
	photo varchar(256),
	status int,
	address varchar(256),
	phone varchar(256),
	careerDemand varchar(1024),
	introduction varchar(1024),
	registerTime varchar(256),
	PRIMARY KEY (foreignerId)
)

DROP TABLE IF EXISTS weixin_points;
create table if not exists weixin_points
(
	pointsId int auto_increment,
	bookId int,
	unitId int,
	lessonId int,
	ponintsDesc varchar(4096),
	voicePath varchar(2048),
	PRIMARY KEY (pointsId)
)

DROP TABLE IF EXISTS weixin_songClass;
create table if not exists weixin_songClass
(
	songClassId int auto_increment,
	songClassName varchar(256),
	songImgPath varchar(2048),
	PRIMARY KEY (songClassId)
)

DROP TABLE IF EXISTS weixin_songList;
create table if not exists weixin_songList
(
	songListId int auto_increment,
	songName varchar(256),
	songClassId int,
	songImgPath varchar(2048),
	songVedioPath varchar(2048),
	PRIMARY KEY (songListId)
)

DROP TABLE IF EXISTS en_job;
create table if not exists en_job
(
	jobId int,
	title  varchar(256),
	validTime  varchar(256),
	locaiton int,
	jobType int,
	description varchar(8192),
	openId varchar(256),
	pageview int,
	publishTime varchar(256),
	PRIMARY KEY (jobId)
)

DROP TABLE IF EXISTS en_user;
create table if not exists en_user
(
	userId int auto_increment,
	openId varchar(256),
	userType int,
	iconPath varchar(2048),
	nickName varchar(256),
	gender int,
	country varchar(256),
	province varchar(256),
	city varchar(256),
	nationality varchar(256),
	photo varchar(256),
	phone varchar(256),
	jobDemand int,
	introductionv varchar(8192),
	joinTime varchar(256),
	PRIMARY KEY (userId)
)