/**
 * 班级管理模型
 */
(function(global){
	
        global.modelName = "ognization";

        global.model = {
            desc : "机构管理",
            key : "ognizationId",
            columns :[
                {
                    name : "ognizationId",
                    desc : "机构编号",
                    type : 0,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : 0
                },
				{
                    name : "teachingName",
                    desc : "教学点名称",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "ognizationName",
                    desc : "机构全称",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
				{
                    name : "ognizationOwner",
                    desc : "负责人",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
				{
                    name : "contact",
                    desc : "联系方式",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
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
                    name: "cooperation",
                    desc: "合作方式",
                    type: 2,
                    needInput : true,
                    initData : [{value:0, desc:'按比例分成'},{value:1, desc:'固定课时费'}],
                    refs:{},
                    value : 0
                },
				{
                    name : "details",
                    desc : "合作细节",
                    type : 8,
					placeholder : '请输入分成比例或每小时的课时价格',
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
				{
                    name : "signTime",
                    desc : "签约时间",
                    type : 5,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '2017'
                },
				{
                    name : "signEnding",
                    desc : "签约期限",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
				{
                    name : "tude",
                    desc : "经纬度",
                    type : 8,
					placeholder : '请输入经纬度格式和百度一致 118.800951,32.054943',
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                }
            ]
        };
		
		global.optionalModel = undefined;

})(this);