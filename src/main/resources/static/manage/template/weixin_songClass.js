/**
 * 外教管理模型
 */
(function(global){
	
        global.modelName = "weixin_songClass";

        global.model = {
            desc : "儿歌分类",
            key : "songClassId",
            columns :[
                {
                    name : "songClassId",
                    desc : "儿歌分类编号",
                    type : 0,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : 0
                },
				{
                    name : "songClassName",
                    desc : "儿歌分类名称",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "songImgPath",
                    desc : "分类图片",
                    type : 9,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : ''
                }
            ]
        };
		
		global.optionalModel = undefined;

})(this);