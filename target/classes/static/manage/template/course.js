/**
 * 班级管理模型
 */
(function(global){

        global.modelName = "course";
		
        global.model = {
            desc : "当日课程",
            key : "classId",
			searchPlaceholder : "请输入星期英文简称",
            columns :[
                {
                    name : "classId",
                    desc : "班级编号",
                    type : 0,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : 0
                },
                {
                    name : "className",
                    desc : "班级名称",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name: "teacherId",
                    desc: "授课老师",
                    type: 4,
					needInput : true,
                    initData : [],
                    refs:{
                        model : "teacher",
                        key : "teacherId",
                        value : "lastName"
                    },
                    value : 0
                },
                {
                    name : "teachingTime",
                    desc : "上课时间",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : ''
                },
				{
                    name : "remainClassNumber",
                    desc : "剩余课时",
                    type : 1,
                    needInput : false,
					disabled : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "teachingAssistant",
                    desc : "班主任",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                }
            ]
        };
		
		global.optionalModel = {
			model : "grade",
			key : "classId"
		}

})(this);