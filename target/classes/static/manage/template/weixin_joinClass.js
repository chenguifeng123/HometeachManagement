/**
 * 外教管理模型
 */
(function(global){
	
        global.modelName = "weixin_joinClass";

        global.model = {
            desc : "发起拼班",
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
                    desc : "班级编号",
                    type : 8,
                    needInput : true,
					placeholder : '格式为 PB20180001',
                    initData :[],
                    refs:{},
                    value : '0'
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
                    name : "minNum",
                    desc : "试听人数",
                    type : 1,
                    needInput : true,
                    initData :[],
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
                    desc : "详细地址",
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