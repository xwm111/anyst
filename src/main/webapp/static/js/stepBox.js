
function setStepBox(settings){
	var settings=$.extend({
		elmt:"",
		className:"stepBox",
		actionStyle:{
			dont:"no",
			doing:"do",
			done:"ok"
		},
		data:[],
		//selectIdx:0,
		mode:"STEP", //STEP or SELECT
		index:1
	},settings)
	var elmts=$(settings.elmt).addClass(settings.className);
	var list=$("<ul></ul>").appendTo(elmts)
	var okLine=$('<div class="okLine" style="width:0%;"></div>').appendTo(list);
	var doLine=$('<div class="doLine" style="width:0%;"></div>').appendTo(list);
	var size=1/(settings.data.length-1);
	for(var i=0;i<settings.data.length;i++){
		var d=settings.data[i]
		var e=$('<li></li>').css("left",size*i*100+"%").appendTo(list);
			e.click(d.click)
		var action=$('<a class="do"></a>').appendTo(e)
		if(!!d.tip){
			var tip=$('<span class="tips">'+d.tip+'</span>').appendTo(action);
		}else{
			var tip=$('<span class="tips" style="display:none;"></span>').appendTo(action);
		}
		var state=$('<span class="state"></span>').appendTo(action);
		var step=$('<span class="step"> '+(i+1)+' </span>').appendTo(action);
		var title=$('<span class="stepCont"> '+d.title+' </span>').appendTo(action);
		var line=$('<span class="line"></span>').appendTo(action);
		  
	}
	
	switch(settings.mode){
		case "STEP":
			setActionStep(settings.index)
			break;
		case "SELECT":
			setActionSelect(settings.index)
			list.children("li").each(function(index, element) {
				$(this).click(function(){
					$(this).addClass("selected").siblings("li").removeClass("selected");
				})
			});
	}
	
	function setActionSelect(index){
		var lists=list.find('li');
		var w=lists.length;
		$(lists[index<=w?index-1:w-1]).addClass("selected").siblings().removeClass("selected");
	}
	
	function setActionStep(index){
		var lists=list.find('li');
		lists.each(function(n){
			if(n==index-1){
				var c="doing";
			}else if(n<index-1){
				var c="done";
			}else{
				var c="dont";
			}
			$(this).children("a").attr("class",settings.actionStyle[c])
		})
		var w=lists.length;
		okLine.css("width",size*(index<=w?index-1:w-1)*100+"%")
		doLine.css("width",size*(index<w?index:w-1)*100+"%")
	}
}