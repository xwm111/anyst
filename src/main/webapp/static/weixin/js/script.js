// JavaScript Document
//地址样取get传值，返回object
var UrlRequest=getUrlRequest();
//设置平台默认路径
var root="http://192.168.199.247:8080/anyst/static/weixin/";

//设置日期、选择弹窗参数
var defaultControls={
	date:{
		preset: 'date', //日期    
		//preset: 'calendar',
		controls: ['date', 'time'],
		theme: 'jqm', //皮肤样式
		endYear: 2020, //结束年份
		lang: 'zh',
		rows: 3//行数，默认最小为3
	},
	datetime:{
		preset: 'datetime',
		theme: 'jqm', //皮肤样式
		minDate: new Date(1949, 10, 1, 0, 0),
		maxDate: new Date(2025, 10, 1, 0, 0),
		lang: 'zh',
		stepMinute: 3
	},
	time:{
		preset: 'time',
		theme: 'jqm', //皮肤样式
		lang: 'zh',
		stepMinute: 3
	},
	selects:{
		preset: 'select',
		theme: 'jqm', //皮肤样式
		showLabel: false,
		lang: 'zh',
		stepMinute: 3
	},
	selectGroup:{
		preset: 'select',
		theme: 'jqm', //皮肤样式
		showLabel: false,
		group: true,
		lang: 'zh',
	}
}

/*********************************************************************************************************************/
//页面初始化
/*********************************************************************************************************************/
//扩展文件加载方式
$.extend({
    basePath: '',
    include: function(file)
    {
        var files = typeof file == "string" ? [file] : file;
        for (var i = 0; i < files.length; i++)
        {
            var name = files[i].replace(/^\s|\s$/g, "");
            var att = name.split('.');
            var ext = att[att.length - 1].toLowerCase();
            var isCSS = ext == "css";
            var tag = isCSS ? "link" : "script";
            var attr = isCSS ? " type='text/css' rel='stylesheet' " : " language='javascript' type='text/javascript' ";
//            var link = (isCSS ? "href" : "src") + "='" + $.basePath + name+"?"+ Math.random(1000)*10000 + "'"; 开启缓存
            var link = (isCSS ? "href" : "src") + "='" + $.basePath + name+ "'";
            if ($(tag + "[" + link + "]").length == 0) document.write("<" + tag + attr + link + "></" + tag + ">");
        }
    }
});

//$.include([root+"js/src/jquery.os.js"]);//系统检测函数库
//$.include([root+"js/src/qdone.plugin.js"]);//控件自动加载
//$.include([root+"js/src/qdone.select.js"]);//select列表控件
//$.include([root+"js/src/qdone.location.js"]);//地区选择控件
//$.include([root+"js/src/qdone.linkbutton.js"]);//地区选择控件
//$.include([root+"js/src/qdone.tabs.js"]);//区域板块控件
$.include([root+"js/src/qdone.numbers.js"]);//数字输入控件
//$.include([root+"js/src/qdone.checkbox.js"]);//数字输入控件
//$.include([root+"js/src/qdone.switchbox.js"]);//checkBox开头输入控件
//$.include([root+"js/src/qdone.autoResize.js"]);//textarea自动加行
//$.include([root+"js/src/qdone.rotate.js"]);//旋转插件函数库
//$.include([root+"js/src/qdone.messages.js"]);//弹出对话框插件函数库
//$.include([root+"js/src/qdone.dialog.js"]);//弹窗函数库
//$.include([root+"js/src/qdone.layout.js"]);//前台主架构
//$.include([root+"js/src/qdone.pannel.js"]);//区域板块控件
$.include([root+"js/src/mobiscroll.core.js"]);//core基础类函数库
$.include([root+"js/src/mobiscroll.datetime.js"]);//基于core的时间选择器插件函数库
$.include([root+"js/src/mobiscroll.select.js"]);//基于core的select选择器插函数库
$.include([root+"js/src/mobiscroll.i18n.zh.js"]);//core中方式函数库
$.include([root+"js/iscroll.js"]);//自定义页面滚轴函数库


//取地址get参数
function getUrlRequest() {
   var url = location.search; //获取url中"?"符后的字
   var theRequest = new Object();
   if (url.indexOf("?") != -1) {
      var str = url.substr(1);
      strs = str.split("&");
      for(var i = 0; i < strs.length; i ++) {
         theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);
      }
   }
   return theRequest;
}
//取随机数
var chars = ['0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'];
function generateMixed(n) {
     var res = "";
     for(var i = 0; i < n ; i ++) {
         var id = Math.ceil(Math.random()*35);
         res += chars[id];
     }
     return res;
}
//设置左右满屏banner
function setBanner(settings){
	var settings=$.extend({
		elmts:'',
		data:[],
		className:'content-imgsList',
		onBefore:function(){},
		onAfter:function(){}
	},settings);
	settings.onBefore();
	
	var elmts=$(settings.elmts).addClass(settings.className);
	var _width=$(window).outerWidth();
	var lists=$("<ul></ul>").addClass('list').css({width:_width*settings.data.length}).appendTo(elmts);
	var points=$("<ul></ul>").addClass('handle').appendTo(elmts);
	for(var i=0;i<settings.data.length;i++){
		var d=settings.data[i];
		var e=$('<li></li>').addClass(i==0?'first':i==settings.data.length-1?'last':'').css({width:_width}).appendTo(lists);
		var a=$('<a></a>').appendTo(e);
		var g=$('<img src="'+d.src+'">').attr({
				onload:'$("'+settings.elmts+'").height($(this).outerHeight());'
			}).appendTo(a);
	}
	
	if(settings.data.length<2) return;
	for(var i=0;i<settings.data.length;i++){
		var p=$('<li></li>').addClass(i==0?'selected':'').appendTo(points);
			
	}
	
	var contentImg=new iScroll(elmts.attr('id'), {
		snap: true,
		momentum: false,
		hScrollbar: false,
		vScrollbar: false,
		checkDOMChanges: false,
		onScrollEnd: function () {
			elmts.find('.handle li:nth-child('+(this.currPageX+1)+')').addClass('selected').siblings().removeClass('selected');
		}
	});
	settings.onAfter();
}