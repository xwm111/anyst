/**
 * qNumbers - input type of number - qdone mobile query ui
 * 
 * Designer: pcboby
 * Coder:pcboby
 * QQ:54257013
 *
 * Copyright 2015 in whty-qdone co. [ pcboby@126.com ] 
 * 
 * 
 */
(function($){
	//封装内容
	function wrapContents(target){
		$(target).attr('qQuery',generateMixed(16))
		var t=$(target);
		var contents=$("<div></div>").addClass('qNumbers-input-contents').insertAfter(t).append(t);
		return contents
	}
	
	//构造dialog
	function buildInputs(target){
		var t=$(target);
		var stats=$.data(target, 'qNumbers');
		var opts=stats.options;
		var contents=stats.contents;
		if(!!opts.buttons&&!opts.disControl){
			contents.addClass('hasBtn');
			for(var i=0;i<opts.buttons.length;i++){
				var d=opts.buttons[i];
				var modeCls='';
				var btn=$('<a></a>').addClass(d.mode=='left'?'btn-l':d.mode=='right'?'btn-r':'').appendTo(contents)
					btn.append(!!d.iconCls?'<span class="icon-l '+d.iconCls+'"></span>':'')
					btn.append(!!d.text?'<span>'+d.text+'</span>':'')
					btn.click(d.click);
			}
		}
		
			
		
	}
	//取值
	function getValue(target){
		return $(target).val();
	}
	//取值
	function setValue(target,param){
		var opts=$.data(target,'qNumbers').options;
		$(target).val(Number(param)>Number(opts.max)?Number(opts.max):Number(param)<Number(opts.min)?Number(opts.min):Number(param));
	}
	//设置禁用
	function setDisable(target,param){
		var t=$(target);
		var stats=$.data(target,'qNumbers');
		var contents=stats.contents;
		if(param){
			t.attr('disabled','disabled');
		}else{
			t.removeAttr('disabled');
		}
		contents[!!param?'addClass':'removeClass']('disabled');
	}
	//取设置
	function parseOptions(target){
		return $.extend({buttons:[
			{
				text:'',
				mode:'right',
				iconCls:'icon-Increase',
				click:function(){
					if($(target).attr('disabled')=='disabled') return;
					var opts=$.data(target,'qNumbers').options;
					var t=$(target);
					var v=Number(t.val())+Number(opts.step);
					t.val(v>Number(opts.max)?Number(opts.max):v);
					return false;
				}
			},
			{
				text:'',
				mode:'left',
				iconCls:'icon-Reduce',
				click:function(){
					if($(target).attr('disabled')=='disabled') return;
					var opts=$.data(target,'qNumbers').options;
					var t=$(target);
					var v=Number(t.val())-Number(opts.step);
					t.val(v<Number(opts.min)?Number(opts.min):v);
					return false;
				}
			}
		]},eval("{"+$(target).attr('qdone-options')+"}"),{buttons:$(target).attr('buttons'),disControl:$(target).attr('disControl'),step:$(target).attr('step'),max:$(target).attr('max'),min:$(target).attr('min')})
	}
	
	$.fn.qNumbers = function(options, param){
		if (typeof options == 'string'){
			switch(options){
			case 'disabled':
				return this.each(function(){
					setDisable(this,param);
				})
			case 'getValue':
				return this.each(function(){
					getValue(this);
				})
			case 'setValue':
				return this.each(function(){
					setValue(this,param);
				})
			}
			return
		}
		
		options = options || {};
		return this.each(function(){
			if(!!$(this).attr('qQuery')) return
			var state = $.data(this, 'qNumbers');
			var opts;
			if (state){
				opts=$.extend(state.options, options);
			} else {
				var t = $(this);
				opts = $.extend({},t, $.fn.qNumbers.defaults, parseOptions(this), options);
				
				$.data(this, 'qNumbers', {
					options: opts,
					contents: wrapContents(this)
				});
			}
			buildInputs(this);
			if($(this).attr('disabled')){
				setDisable(this,true)
			}
			
		});
		
		
	};
	$(function(){
		$(".qdone-numbers").qNumbers();
	})
	$.fn.qNumbers.defaults = {
		max:999999,
		min:0,
		step:1,
		disControl:false
	};
	
})(jQuery);
