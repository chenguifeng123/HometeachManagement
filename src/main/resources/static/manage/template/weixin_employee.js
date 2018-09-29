/**
 * 外教管理模型
 */
(function(global){
	
        global.modelName = "weixin_employee";

        global.model = {
            desc : "老外管理",
            key : "foreignerId",
            columns :[
                {
                    name : "foreignerId",
                    desc : "老外编号",
                    type : 0,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : 0
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
                    name : "iconPath",
                    desc : "头像",
                    type : 1,
                    needInput : false,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "firstName",
                    desc : "姓（First Name）",
                    type : 1,
                    needInput : false,
                    initData :[],
                    refs:{},
                    value : ''
                },
                {
                    name : "lastName",
                    desc : "名（Last Name）",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : ''
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
                    name : "country",
                    desc : "国家（Country）",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : ''
                },
                {
                    name : "photo",
                    desc : "照片（Photo）",
                    type : 6,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : ""
                },		
				{
                    name: "status",
                    desc: "身份（Status）",
                    type: 2,
                    needInput : true,
                    initData : [{value:0, desc:'Student'},{value:1, desc:'Teacher'},{value:2, desc:'Others'}],
                    refs:{},
                    value : 0
                },
                {
                    name : "address",
                    desc : "住址（Address）",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },				
                {
                    name : "phone",
                    desc : "电话（Phone）",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "careerDemand",
                    desc : "职业需求（Career Demand）",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "introduction",
                    desc : "自我介绍（Self-Introduction）",
                    type : 1,
                    needInput : false,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "registerTime",
                    desc : "注册时间（Register Time）",
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