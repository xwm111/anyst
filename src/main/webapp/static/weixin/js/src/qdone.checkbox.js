/**
 * qCheckbox - input type of checkbox or radiobox - qdone mobile query ui
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
		var t=$(target).hide();
		var contents=$("<div></div>").addClass('qCheckbox-input-contents').insertAfter(t);
		return contents
	}
	
	//构造dialog
	function buildCheckbox(target){
		var t=$(target);
		var stats=$.data(target, 'qCheckbox');
		var opts=stats.options;
		var contents=stats.contents;
			contents.addClass($(target).attr('checked')=='checked'?'checked':'')
			contents.click(function(){
				if($(target).attr('disabled')=='disabled') return;
				setChecked(target,$(target).attr('checked')?false:true);
				//$(target).click();
				setTimeout($(target).attr('onclick'),80);
			})
		
	}
	//取值
	function getValue(target){
		return $(target).val();
	}
	//取值
	function setValue(target,param){
		$(target).val(param);
	}
	//设置禁用
	function setDisable(target,param){
		var t=$(target);
		var stats=$.data(target,'qCheckbox');
		var contents=stats.contents;
		if(param){
			t.attr('disabled','disabled');
		}else{
			t.removeAttr('disabled');
		}
		contents[!!param?'addClass':'removeClass']('disabled');
	}
	//设置选中
	function setChecked(target,param){
		var t=$(target);
		var stats=$.data(target,'qCheckbox');
		var contents=stats.contents;
		if(param){
			t.prop('checked',true).attr('checked','checked');
			if(t.attr('type')=='radio'){
				$('input[type=radio][name='+t.attr('name')+']').each(function(index, element) {
                    if(target!=element){
						setChecked(element,false);
					}
                });
			}
		}else{
			t.prop('checked',false).removeAttr('checked');
		}
		contents[!!param?'addClass':'removeClass']('checked');
	}
	//取设置
	function parseOptions(target){
		return $.extend({},eval("{"+$(target).attr('qdone-options')+"}"))
	}
	
	$.fn.qCheckbox = function(options, param){
		if (typeof options == 'string'){
			switch(options){
			case 'checked':
				return this.each(function(){
					setChecked(this,param);
				})
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
			var state = $.data(this, 'qCheckbox');
			var opts;
			if (state){
				opts=$.extend(state.options, options);
			} else {
				var t = $(this);
				opts = $.extend({},t, $.fn.qCheckbox.defaults, parseOptions(this), options);
				
				$.data(this, 'qCheckbox', {
					options: opts,
					contents: wrapContents(this)
				});
			}
			buildCheckbox(this);
			if($(this).attr('disabled')){
				setDisable(this,true)
			}
			
		});
		
		
	};
	$(function(){
		//$(".qdone-checkbox").qCheckbox();
	})
	$.fn.qCheckbox.defaults = {
	};
	
})(jQuery);
