/**
 * qSelect list - qdone mobile query ui
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
	function wrapQSelect(target){
		var warp=$('<div class="list-inputGroup-qSelect"></div>').insertAfter(target);
		$(target).attr('qQuery',generateMixed(16)).hide();
		return warp;
	}
		
	//构造dialog
	function buildQSelect(target){
		var state=$.data(target, 'qSelect');
		var opts = $.data(target, 'qSelect').options;
		
		var contents = $.data(target, 'qSelect').contents;
		var selectedIdx=0;
		var lists=$('<ul></ul>').appendTo(contents)
		$(target).children("option").each(function(index, element) {
			if(!!$(this).attr('selected')) selectedIdx=index;
			var e=$("<li></li>").appendTo(lists);
				e.click(function(){
					setSelectedIdx(target,index)
					if(!!target.onchange)target.onchange();
					
				})
			var t=$('<span class="title"></span>').text($(this).text()).appendTo(e);
			var m=$('<span class="mode"></span>').appendTo(e);
        });
		setSelectedIdx(target,selectedIdx)
	}
	
	//取选中序列号
	function getSelectedIdx(target){
		return $(target).get(0).selectedIndex;
	}
	//取选中值
	function getSelectedVal(target){
		return $(target).val();
	}
	//取选中标签
	function getSelectedLab(target){
		return $(target).find("option:selected").text(); 
	}
	
	//设置选中
	function setSelectedIdx(target,idx){
		$(target).get(0).selectedIndex=idx;
		$($(target).next('.list-inputGroup-qSelect').find('ul li')[idx]).addClass('selected').siblings('li').removeClass('selected');
	}
	//根据文字索引显示
	function setViewByIndexes(target,param){
		//alert($(target).next('.inputGroup-qSelect').find('ul li span:not:(contains("'+param+'"))').length)
		$(target).next('.list-inputGroup-qSelect').find('ul li').each(function(index, element) {
            $(this)[$(this).children('span').text().indexOf(param)>-1?"show":"hide"]();
        });
	}
	
	$.fn.qSelect = function(options, param){
		if (typeof options == 'string'){
			switch(options){
				case 'setSelectedIdx':
					return this.each(function(){
						setSelectedIdx(this,param)
					})
				case 'setViewByIndexes':
					return this.each(function(){
						setViewByIndexes(this,param)
					})
				
				case 'getSelectedIdx':
					return getSelectedIdx(this)
				case 'getSelectedVal':
					return getSelectedVal(this)
				case 'getSelectedLab':
					return getSelectedLab(this)
			}
		}
		
		options = options || {};
		return this.each(function(){
			if(!!$(this).attr('qQuery')) return
			
			var state = $.data(this, 'qSelect');
			var opts
			if (state){
				opts=$.extend(state.options, options);
			} else {
				var t = $(this);
				opts = $.extend({}, $.fn.qSelect.defaults, {
					title:(t.attr('title') ? t.attr('title') : undefined)
				}, options);
				$.data(this, 'qSelect', {
					options: opts,
					contents: wrapQSelect(this)
				});
			}
			
			$.fn.qSelect.defaults.onBefore();
			buildQSelect(this);
			$.fn.qSelect.defaults.onAfter();
			
		});
		
		
	};
	$(function(){
		//$(".qdone-select").qSelect();
	})
	$.fn.qSelect.defaults = {
		title: '',
		onBefore:function(){},
		onAfter:function(){}
	};
	
})(jQuery);
