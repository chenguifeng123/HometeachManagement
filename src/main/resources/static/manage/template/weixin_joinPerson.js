/**
 * 外教管理模型
 */
(function(global){
	
        global.modelName = "weixin_joinPerson";

        global.model = {
            desc : "参与拼班",
            key : "personId",
            columns :[
				{
                    name : "personId",
                    desc : "拼班人员编号",
                    type : 0,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : 0
                },
                {
                    name : "classId",
                    desc : "拼班编号",
                    type : 0,
                    needInput : true,
                    initData :[],
                    refs:{
                        model : "weixin_joinClass",
                        key : "classId",
                        value : "className"
                    },
                    value : 0
                },
                {
                    name : "childAge",
                    desc : "孩子年龄",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : 0
                },
                {
                    name : "isStarter",
                    desc : "是否发起人",
                    type : 2,
                    needInput : true,
                    initData :[{value:0, desc:'否'},{value:1, desc:'是'}],
                    refs:{},
                    value : '0'
                },
                {
                    name: "openid",
                    desc: "用户编号",
                    type: 1,
                    needInput : false,
                    initData : [],
                    refs:{},
                    value : 0
                },
                {
                    name : "nickName",
                    desc : "昵称",
                    type : 1,
                    needInput : false,
                    initData :[],
                    refs:{},
                    value : '2017'
                },
                {
                    name : "iconPath",
                    desc : "头像",
                    type : 1,
                    needInput : false,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "contactName",
                    desc : "联系人",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '2017'
                },
                {
                    name : "phoneNumber",
                    desc : "手机号",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "area",
                    desc : "地区",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "address",
                    desc : "参与者地址",
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