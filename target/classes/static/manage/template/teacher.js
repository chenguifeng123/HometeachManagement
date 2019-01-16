/**
 * 外教管理模型
 */
(function(global){
	
        global.modelName = "teacher";

        global.model = {
            desc : "外教管理",
            key : "teacherId",
            columns :[
                {
                    name : "teacherId",
                    desc : "老师编号（Teacher Id）",
                    type : 0,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : 0
                },
                {
                    name : "firstName",
                    desc : "姓（First Name）",
                    type : 1,
                    needInput : false,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "lastName",
                    desc : "名（Last Name）",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name: "gender",
                    desc: "性别（Gender）",
                    type: 2,
                    needInput : true,
                    initData : [{value:0, desc:'男'},{value:1, desc:'女'}],
                    refs:{},
                    value : 0
                },
                {
                    name : "brithday",
                    desc : "生日（Brithday）",
                    type : 5,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '2017'
                },
                {
                    name : "county",
                    desc : "国家（Country）",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "visaExpiredTime",
                    desc : "签证到期时间（Visa Expired Time）",
                    type : 5,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '2017'
                },
                {
                    name : "motherLanguage",
                    desc : "母语（Mother Language）",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "secondLanguage",
                    desc : "第二语言（Second Language）",
                    type : 1,
                    needInput : false,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "secondLanguageLevel",
                    desc : "第二语言掌握程度（Second Language Level）",
                    type : 1,
                    needInput : false,
                    initData :[],
                    refs:{},
                    value : '0'
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
                    name: "educationBackground",
                    desc: "学历（Education Background）",
                    type: 4,
                    needInput : true,
                    initData : [{value:0, desc:'High school'},{value:1, desc:'College'},{value:2, desc:'University'}],
                    refs:{},
                    value : 0
                },
                {
                    name: "degree",
                    desc: "学位（Degree）",
                    type: 4,
                    needInput : false,
                    initData : [{value:0, desc:'None'},{value:1, desc:'Bachelor'},{value:2, desc:'Master'},{value:3, desc:'Doctor'}],
                    refs:{},
                    value : 0
                },
                {
                    name: "status",
                    desc: "身份（Status）",
                    type: 4,
                    needInput : true,
                    initData : [{value:0, desc:'Student'},{value:1, desc:'Teacher'},{value:2, desc:'Others'}],
                    refs:{},
                    value : 0
                },
                {
                    name: "teachingCertificate",
                    desc: "教学证书（Teaching Certificate）",
                    type: 4,
                    needInput : true,
                    initData : [{value:0, desc:'None'},{value:1, desc:'TEFL'},{value:2, desc:'TESOL'},{value:3, desc:'TKT'},{value:4, desc:'Others'}],
                    refs:{},
                    value : 0
                },
                {
                    name: "teachingExperience",
                    desc: "教学经验（Teaching Experience）",
                    type: 4,
                    needInput : true,
                    initData : [{value:0, desc:'None'},{value:1, desc:'1 year'},{value:2, desc:'2 year'},{value:3, desc:'3 year'},{value:4, desc:'more'}],
                    refs:{},
                    value : 0
                },
                {
                    name : "studyOrWorkPlace",
                    desc : "学习或工作地点（Study or work place）",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
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
                    name : "introduction",
                    desc : "自我介绍（Introduction）",
                    type : 1,
                    needInput : false,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "video",
                    desc : "视频（Video）",
                    type : 1,
                    needInput : false,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "teachingTime",
                    desc : "教学时间（Valid Teaching Time）",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "teachingArea",
                    desc : "教学区域（Valid Teaching Area）",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name: "paymentType",
                    desc: "账户类型（Payment Type）",
                    type: 4,
                    needInput : true,
                    initData : [{value:0, desc:'zhifubao'},{value:1, desc:'Wechat'},{value:2, desc:'Cash'}],
                    refs:{},
                    value : 0
                },
                {
                    name : "paymentAccount",
                    desc : "账号（Payment Account）",
                    type : 1,
                    needInput : false,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "hourSalary",
                    desc : "时薪（Hour Salary）",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "joinTime",
                    desc : "加入时间（Join Time）",
                    type : 5,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "rating",
                    desc : "评级（Rating）",
                    type : 2,
                    needInput : true,
                    initData :[{value:1, desc:'金牌'},{value:2, desc:'银牌'},{value:3, desc:'铜牌'}],
                    refs:{},
                    value : 0
                }
            ]
        };
		
		global.optionalModel = undefined;

})(this);