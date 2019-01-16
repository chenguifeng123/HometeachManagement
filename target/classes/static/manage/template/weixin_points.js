/**
 * 外教管理模型
 */
(function(global){
	
        global.modelName = "weixin_points";

        global.model = {
            desc : "学习要点",
            key : "pointsId",
            columns :[
                {
                    name : "pointsId",
                    desc : "要点编号",
                    type : 0,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : 0
                },
                {
                    name: "bookId",
                    desc: "教材",
                    type: 4,
                    needInput : true,
                    initData : [{value:0, desc:'Fingerprints 1A'},{value:1, desc:'Fingerprints 1B'},{value:2, desc:'Fingerprints 2A'},
                        {value:3, desc:'Fingerprints 2B'},{value:4, desc:'Fingerprints 3A'},{value:5, desc:'Fingerprints 3B'},
                        {value:6, desc:'Phonics'},{value:7, desc:'Nursery Rhyme'},{value:8, desc:'First Friends 1'},{value:9, desc:'First Friends 2'},
						{value:10, desc:'First Friends 3'},{value:11, desc:'剑桥少儿英语1上'},{value:12, desc:'剑桥少儿英语1下'},
						{value:13, desc:'剑桥少儿英语2上'},{value:14, desc:'剑桥少儿英语2下'},{value:15, desc:'剑桥少儿英语3上'},{value:16, desc:'剑桥少儿英语3下'}],
                    refs:{},
                    value : 0
                },
                {
                    name : "unitId",
                    desc : "单元",
                    type : 11,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : 0
                },
                {
                    name : "lessonId",
                    desc : "课程",
                    type : 11,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : 0
                },
                {
                    name : "voicePath",
                    desc : "语音",
                    type : 9,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : ''
                },		
                {
                    name: "ponintsDesc",
                    desc: "课程要点",
                    type: 10,
                    needInput : true,
                    initData : [],
                    refs:{},
                    value : ''
                }
            ]
        };
		
		global.optionalModel = undefined;

})(this);