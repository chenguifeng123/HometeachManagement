/**
 * 班级管理模型
 */
(function(global){
	
        global.modelName = "grade";

        global.model = {
            desc : "班级管理",
            key : "classId",
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
                    name: "classStatus",
                    desc: "班级状态",
                    type: 2,
                    needInput : true,
                    initData : [{value:0, desc:'正常'},{value:1, desc:'停课'},{value:2, desc:'完课'}],
                    refs:{},
                    value : 0
                },
                {
                    name: "classType",
                    desc: "班级类型",
                    type: 2,
                    needInput : true,
                    initData : [{value:0, desc:'家庭'},{value:1, desc:'教学点'}],
                    refs:{},
                    value : 0
                },
				{
                    name : "ognizationId",
                    desc : "教学点",
                    type : 4,
                    needInput : false,
                    initData :[],
                    refs:{
                        model : "ognization",
                        key : "ognizationId",
                        value : "teachingName"
                    },
                    value : ''
                },
                {
                    name : "kidsNumber",
                    desc : "人数",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name: "startBook",
                    desc: "初始教材",
                    type: 4,
                    needInput : true,
                    initData : [{value:0, desc:'Fingerprints 1A'},{value:1, desc:'Fingerprints 1B'},{value:2, desc:'Fingerprints 2A'},
                        {value:3, desc:'Fingerprints 2B'},{value:4, desc:'Fingerprints 3A'},{value:5, desc:'Fingerprints 3B'},
                        {value:6, desc:'Phonics'},{value:7, desc:'Nursery Rhyme'},{value:8, desc:'First Friends 1'},{value:9, desc:'First Friends 2'},
						{value:10, desc:'First Friends 3'}],
                    refs:{},
                    value : 0
                },
                {
                    name: "currentBook",
                    desc: "当前教材",
                    type: 4,
                    needInput : true,
                    initData : [{value:0, desc:'Fingerprints 1A'},{value:1, desc:'Fingerprints 1B'},{value:2, desc:'Fingerprints 2A'},
                        {value:3, desc:'Fingerprints 2B'},{value:4, desc:'Fingerprints 3A'},{value:5, desc:'Fingerprints 3B'},
                        {value:6, desc:'Phonics'},{value:7, desc:'Nursery Rhyme'},{value:8, desc:'First Friends 1'},{value:9, desc:'First Friends 2'},
						{value:10, desc:'First Friends 3'}],
                    refs:{},
                    value : 0
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
                    name : "transportAllowance",
                    desc : "交通补贴",
                    type : 1,
                    needInput : false,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "classNumber",
                    desc : "课时数",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
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
                    name : "teachingTime1",
                    desc : "上课时间1",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '2017'
                },
                {
                    name : "classDuration1",
                    desc : "上课时间时长1（小时）",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "teachingTime2",
                    desc : "上课时间2",
                    type : 1,
                    needInput : false,
                    initData :[],
                    refs:{},
                    value : '2017'
                },
                {
                    name : "classDuration2",
                    desc : "上课时间时长2（小时）",
                    type : 1,
                    needInput : false,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "startTime",
                    desc : "开班时间",
                    type : 5,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '2017'
                },
                {
                    name : "address",
                    desc : "地址",
                    type : 1,
                    needInput : true,
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
		
		global.optionalModel = undefined;

})(this);