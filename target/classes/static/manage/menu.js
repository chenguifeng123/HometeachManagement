/**
 * 菜单模型
 */
(function(global){

        global.menu = [
            {
                group : "教务管理",
                subMenu :[
                    {
                        index : "template/teacher",
                        desc : "外教管理"
                    },
                    {
                        index : "template/grade",
                        desc : "班级管理"
                    },
                    {
                        index : "template/teaching",
                        desc : "授课管理"
                    },
                    {
                        index : "template/student",
                        desc : "学员管理"
                    },
                    {
                        index : "template/course",
                        desc : "当日课程"
                    }
                ]
            },
            {
                group : "市场管理",
                subMenu :[
					{
                        index : "template/ognization",
                        desc : "机构管理"
                    },
                ]
            },
            {
                group : "行政管理",
                subMenu :[
					{
                        index : "template/staff",
                        desc : "员工管理"
                    },
                    {
                        index : "template/attendance",
                        desc : "出勤管理"
                    }
                ]
            },
            {
                group : "财务管理",
                subMenu :[
					{
                        index : "template/salary",
                        desc : "外教工资统计"
                    }
                ]
            },			
			{
                group : "小程序管理",
                subMenu :[
					{
                        index : "template/weixin_joinClass",
                        desc : "发起拼班"
                    },
                    {
                        index : "template/weixin_joinPerson",
                        desc : "参与拼班"
                    },
                    {
                        index : "template/weixin_points",
                        desc : "学习要点"
                    },
					{
                        index : "template/weixin_songClass",
                        desc : "儿歌分类"
                    },
					{
                        index : "template/weixin_songList",
                        desc : "儿歌列表"
                    },
                    {
                        index : "template/weixin_employee",
                        desc : "老外管理"
                    }
                ]
            },
        ];

})(this);