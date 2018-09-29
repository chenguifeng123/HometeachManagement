/**
 * 外教管理模型
 */
(function(global){
	
        global.modelName = "student";

        global.model = {
            desc : "学员管理",
            key : "studentId",
            columns :[
                {
                    name : "studentId",
                    desc : "学员编号",
                    type : 0,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : 0
                },
				{
                    name : "globalId",
                    desc : "学员编号",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : 0
                },
                {
                    name : "chineseName",
                    desc : "学员中文名",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "englishName",
                    desc : "学员英文名",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "classId",
                    desc : "所在班级",
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
                    name: "gender",
                    desc: "性别",
                    type: 2,
                    needInput : true,
                    initData : [{value:0, desc:'男'},{value:1, desc:'女'}],
                    refs:{},
                    value : 0
                },
                {
                    name : "brithday",
                    desc : "出生年月",
                    type : 5,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '2017'
                },
                {
                    name : "address",
                    desc : "家庭住址",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "motherPhone",
                    desc : "母亲电话",
                    type : 1,
                    needInput : false,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "motherWorkPlace",
                    desc : "母亲工作单位",
                    type : 1,
                    needInput : false,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "fatherPhone",
                    desc : "父亲电话",
                    type : 1,
                    needInput : false,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "fatherWorkPlace",
                    desc : "父亲工作单位",
                    type : 1,
                    needInput : false,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "startDate",
                    desc : "开始日期",
                    type : 5,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                }
            ]
        };
		
		global.optionalModel = undefined;

})(this);