/**
 * 班级管理模型
 */
(function(global){
	
        global.modelName = "staff";

        global.model = {
            desc : "员工管理",
            key : "staffId",
            columns :[
                {
                    name : "staffId",
                    desc : "员工编号",
                    type : 0,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : 0
                },
				{
                    name : "chineseName",
                    desc : "中文名",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "englishName",
                    desc : "英文名",
                    type : 1,
                    needInput : false,
                    initData :[],
                    refs:{},
                    value : '0'
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
                    name: "education",
                    desc: "学历",
                    type: 4,
                    needInput : true,
                    initData : [{value:0, desc:'高中'},{value:1, desc:'大专'},{value:2, desc:'本科'},{value:3, desc:'硕士'},{value:4, desc:'博士'}],
                    refs:{},
                    value : 0
                },
                {
                    name : "station",
                    desc : "岗位",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name: "workType",
                    desc: "工作类型",
                    type: 2,
                    needInput : true,
                    initData : [{value:0, desc:'全职'},{value:1, desc:'兼职'}],
                    refs:{},
                    value : 0
                },
                {
                    name : "salary",
                    desc : "月薪",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : 0
                },
                {
                    name : "joinDate",
                    desc : "入职时间",
                    type : 5,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '2017'
                }
            ]
        };
		
		global.optionalModel = undefined;

})(this);