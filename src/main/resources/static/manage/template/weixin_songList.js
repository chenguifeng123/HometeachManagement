/**
 * 外教管理模型
 */
(function(global){
	
        global.modelName = "weixin_songList";

        global.model = {
            desc : "儿歌列表",
            key : "songListId",
            columns :[
                {
                    name : "songListId",
                    desc : "儿歌编号",
                    type : 0,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : 0
                },
				{
                    name : "songClassId",
                    desc : "儿歌分类",
                    type : 4,
                    needInput : true,
                    initData :[],
                    refs:{
                        model : "weixin_songClass",
                        key : "songClassId",
                        value : "songClassName"
                    },
                    value : 0
                },
				{
                    name : "songName",
                    desc : "儿歌名称",
                    type : 1,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : '0'
                },
                {
                    name : "songImgPath",
                    desc : "儿歌图片",
                    type : 9,
                    needInput : true,
                    initData :[],
                    refs:{},
                    value : ''
                },
                {
                    name : "songVedioPath",
                    desc : "儿歌视频",
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