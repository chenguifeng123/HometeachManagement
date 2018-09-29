/**
 * 授课管理模型
 */
(function(global){

        global.modelName = "teaching";

        global.model = {
            desc : "授课管理",
            key : "teachingId",
			searchPlaceholder : "请输入班级名称",
            columns :[
                {
                    name : "teachingId",
                    desc : "授课编号",
                    type : 0,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : 0
                },
                {
                    name : "classId",
                    desc : "班级",
                    type : 4,
                    needInput : true,
                    initData :[],
                    refs:{
                        model : "grade",
                        key : "classId",
                        value : "className"
                    },
                    value : 0
                },
				{
                    name: "teachingType",
                    desc: "类型",
                    type: 2,
                    needInput : true,
                    initData : [{value:0, desc:'正常'},{value:1, desc:'调课'},{value:2, desc:'取消'}],
                    refs:{},
                    value : 1
                },
				{
                    name: "absentReason",
                    desc: "请假原因",
                    type: 2,
                    needInput : false,
					disabled : true,
                    initData : [{value:10, desc:'家长'},{value:11, desc:'老师'},{value:12, desc:'公司'}],
                    refs:{},
                    value : 1
                },
                {
                    name : "teacherId",
                    desc : "授课老师",
                    type : 4,
                    needInput : true,
                    initData :[],
                    refs:{
                        model : "teacher",
                        key : "teacherId",
                        value : "lastName"
                    },
                    value : 0
                },
				{
                    name : "teachingDate",
                    desc : "上课日期",
                    type : 5,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "teachingTime",
                    desc : "上课时间",
                    type : 4,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "teachingAddress",
                    desc : "上课地点",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name: "contactPhoneNumber",
                    desc: "联系电话",
                    type : 1,
                    needInput : false,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name: "lastClassNumber",
                    desc: "上次课时",
                    type : 1,
                    needInput : true,
                    disabled : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name: "currentClassNumber",
                    desc: "当前课时",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name: "lastTeachingPeriod",
                    desc: "上次授课章节",
                    type : 1,
                    needInput : false,
                    disabled : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name: "currentTeachingPeriod",
                    desc: "当前授课章节",
                    type : 1,
                    needInput : false,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name: "teacherArriveTime",
                    desc: "老师到达时间",
                    type : 1,
                    needInput : false,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name: "beLate",
                    desc: "老师是否迟到",
                    type: 2,
                    needInput : false,
                    initData : [{value:20, desc:'是'},{value:21, desc:'否'}],
                    refs:{},
                    value : 1
                },
                {
                    name: "absentStudentId",
                    desc: "请假学生",
                    type: 3,
                    needInput : false,
                    initData : [],
                    refs:{},
                    value : []
                },
				{
                    name: "memo",
                    desc: "备注",
                    type: 1,
                    needInput : false,
                    initData : [],
                    refs:{},
                    value : 1
                }
            ]
        };
		
		global.optionalModel = undefined;

})(this);