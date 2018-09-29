/**
 * 班级管理模型
 */
(function(global){
	
        global.modelName = "attendance";

        global.model = {
            desc : "出勤管理",
            key : "attendanceId",
            columns :[
				{
                    name : "attendanceId",
                    desc : "出勤编号",
                    type : 0,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : 0
                },
				{
                    name : "attendanceTime",
                    desc : "出勤时间",
                    type : 7,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '2017'
                },
				{
                    name: "attendanceType",
                    desc: "出勤类别",
                    type: 4,
                    needInput : true,
                    initData : [{value:0, desc:'demo课'},{value:1, desc:'第一次课'},{value:2, desc:'测评'},{value:3, desc:'回访'},{value:4, desc:'活动课'},{value:5, desc:'活动'},{value:6, desc:'异地出差'}],
                    refs:{},
                    value : 0
                },
                {
                    name : "staffId",
                    desc : "员工编号",
                    type : 4,
                    needInput : true,
                    initData :[],
                    refs:{
						model : "staff",
                        key : "staffId",
                        value : "chineseName"
					},
                    value : 0
                },
				{
                    name : "workingPay",
                    desc : "工时费",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : 0
                },
                {
                    name : "reason",
                    desc : "事由",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : ''
                }
            ]
        };
		
		global.optionalModel = undefined;

})(this);