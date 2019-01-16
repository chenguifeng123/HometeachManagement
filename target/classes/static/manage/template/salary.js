/**
 * 外教管理模型
 */
(function(global){
	
        global.modelName = "salary";

        global.model = {
            desc : "外教工资统计",
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
                    name : "lastName",
                    desc : "姓名",
                    type : 1,
                    needInput : true,
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
                    name: "classNumber",
                    desc: "课时数",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
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
                    name : "counts",
                    desc : "上课次数",
                    type : 1,
                    needInput : false,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "salary",
                    desc : "工资",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                }
            ]
        };
		
		global.optionalModel = {
			model : "salary",
			key : "teacherId"
		};

})(this);