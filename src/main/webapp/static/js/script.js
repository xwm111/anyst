// JavaScript Document

/*********************************************************************************************************************/
//初始设置
/*********************************************************************************************************************/
var hostUrl="";
var root="../";//设置平台默认路径
var theme="default";//设置默认调用皮肤
var UrlRequest=getUrlRequest();//地址样取get传值，返回object
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
            var link = (isCSS ? "href" : "src") + "='" + $.basePath + name+"?"+ Math.random(1000)*10000 + "'";
            if ($(tag + "[" + link + "]").length == 0) document.write("<" + tag + attr + link + "></" + tag + ">");
        }
    }
});

//加载系统样式
$.include([hostUrl+"static/js/jquery/easyUI/jquery.easyui.min.js",hostUrl+"static/js/jquery/easyUI/locale/easyui-lang-zh_CN.js"]);


$(function(){
})
/*********************************************************************************************************************/
//常用函数
/*********************************************************************************************************************/

//页面跳转
function getUrl(url,taget){
	//alert(url)
	var taget=!!taget?taget:"_mainframe";
	if($("#"+taget).length>0){
		$("#"+taget).panel({href:url})
	}else{
		window.open(url,taget);
	}
	
	
}
//打开弹窗
function qDialog(settings){
	var settings=$.extend({
			elmt:'#dlg_example',
			href:'',
			closed:false,
			title:'example',
			width:800,
			height:480,
			modal:true
		},settings)
	$(settings.elmt).dialog(settings);
}
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
function setClockView(settings){
	var settings=$.extend({
		id:"",
		className:"listGroup-timer"
	},settings)
	var elmts=$("<div></div>").appendTo($("#"+settings.id));
		elmts.addClass(settings.className);
	var week=$("<span class=\"d\"></span>").appendTo(elmts);
    var day=$("<span class=\"m\"></span>").appendTo(elmts);
    var time=$("<span class=\"t\"></span>").appendTo(elmts);
	setInterval(function(){
		var now = new Date(); 
		var y = now.getFullYear(); // getFullYear getYear 
		var m = now.getMonth();
		var de = now.getDate(); 
		var d = now.getDay(); 
		var h = now.getHours(); 
		var mi = now.getMinutes(); 
		var w=["星期日","星期一","星期二","星期三","星期四","星期五","星期六"]
		week.html(w[d])
		day.html(y+"."+(m+1)+"."+de)
		time.html((h<10?"0"+h:h)+":"+(mi<10?"0"+mi:mi))
	},500)
}

/*********************************************************************************************************************/
//样式控制函数
/*********************************************************************************************************************/
//重制表格中的各类按钮
function dataGridOnloadSuccess(data){
	$(".easyui-linkbutton").each(function() {
        $(this).linkbutton();
    });
	$(".easyui-numberspinner").each(function() {
        $(this).numberspinner();
    });
	
}
//设置页面中输入框的状态样式

//设置主页导航菜单
function setNavMenu(settings){
	var settings=$.extend({
		id:'',
		className:'nav',
		data:[],
		links:[],
		defaultIcon:'../theme/default/images/icon/mIco_5.png',
		idx:0,
		target:'_mainframe'
	},settings)
	var elmts=$("#"+settings.id);
		elmts.children().remove();
	var menus=$("<ul></ul>").appendTo(elmts);
	for(var i=0;i<settings.data.length;i++){
		var d=settings.data[i];
		var icon=!!d.icon?d.icon:settings.defaultIcon;
		//var urls=!!d.url?'href="'+d.url+'" target="'+settings.target+'"':'';
		var urls=" onclick=\"getUrl('"+d.url+"')\""
		var isSelected=i==settings.idx?'selected':'default';
		var e=$('<li><a '+urls+' class="'+isSelected+'"><img src="'+icon+'"><span>'+d.title+'</span></a></li>').appendTo(menus);
			e.click(d.click)
			e.click(function(){
				$(this).children('a').attr('class','selected');
				$(this).siblings().children('a').attr('class','default');
			})
	}
	if(settings.length<1) return
	var stepLine=$("<span class='stepLine'></span>").appendTo(elmts);
	var links=$("<ul></ul>").appendTo(elmts);
	for(var i=0;i<settings.links.length;i++){
		var d=settings.links[i];
		var icon=!!d.icon?d.icon:settings.defaultIcon;
		var urls=!!d.url?'href="'+d.url+'" target="'+settings.target+'"':'';
		var isSelected='default';
		var e=$('<li><a '+urls+' class="'+isSelected+'"><img src="'+icon+'"><span>'+d.title+'</span></a></li>').appendTo(links);
			e.click(d.click)
	}
}
/*********************************************************************************************************************/
//自定义mRadioBox切换值
/*********************************************************************************************************************/
function bindingMRadioBox(settings){
	var setting=$.extend({
		elmt:'',
		idx:0
	},settings)
	var mrb=$(".mRadioBox").find("li a").each(function(index, element) {
		$(this).click(function(){
			$(this).parent().addClass('selected').siblings("li").removeClass('selected');
		})
		if(!!$(this).attr("href")){
			$(this).click(function(){
				getUrl($(this).attr("href"),$(this).attr("target"));
				return false
			});
		}
	});
}