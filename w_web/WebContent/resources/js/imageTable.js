(function ($) { 
	$.fn.ImageTable = function(options) {
		 var table = this;  
		 var defaults = {
			id:$(file).attr("id"),				//当前图集的容器ID
			url:null,							//加载数据的地址（url和data同时存在的情况下，优先加载url返回的数据）默认加载数据格式为:{"result":[{"base64":"XX","id":"XX","title":"XX"}],"status":1}
			param:{},							//加载URL数据的参数
			data:[]							//需填充的数据,默认为空	（url和data同时存在的情况下，优先加载url返回的数据）默认加载数据格式为:[{"base64":"XX","id":"XX","title":"XX"}]
		};
		var settings = $.extend(defaults, options);
		//初始化回显控件
		file.init=function(){
			$(file).addClass("div_list");
			//清空所有元素
			$(file).empty();
			var html = '';
			//多图模式
			if(settings.model == "multiple"){
				$(file).attr("align","left");
				//多图模式下file为多选模式
				html = '<input type="file" class="fielinput" multiple="multiple" style="display: none;">';
			//单图模式
			} else if(settings.model == "single") {
				$(file).attr("align","center");
				html = '<input type="file" class="fielinput" style="display: none;">';
			}
			$(file).after(html);
			//注册事件
			file.build();
			//加载数据
			file.initcreate();
		};
		//构建控件,注册事件
		file.build=function(){
			file.changeFile();
			file.clickFile();
			file.top_ico();
			file.left_ico();
			file.right_ico();
			file.del_ico();
		};
		//注册file的选择事件
		file.changeFile=function(){
			var input = $(file).next()[0];
			input.addEventListener('change', function(){
				for(i = 0;i<this.files.length;i++){
					var file = this.files[i];
					//判断是否是图片类型
					if (!/image\/\w+/.test(file.type)) {
						alert("只能选择图片");
						return false;
					}
					var name = file.name;
					//alert(name);
					var reader = new FileReader();
					reader.readAsDataURL(this.files[i]);
					var name = this.files[i].name;
					var base = ''
					reader.onload = function (e) { 
						create(settings,this.result,"","0");
					}
				}
				//清空已选择了文件的input元素
				var files = $(file).next();
                files.replaceWith(files.clone());
				
			});
			
			
		};
		//注册点击事件，以button的点击事件触发file的点击事件
		file.clickFile=function(){
			document.getElementById(settings.checkfile).addEventListener('click',function(){
				var input = $(file).next()[0];
				//var input = document.getElementById("fielinput");
				input.addEventListener('click',function(){
					if (typeof (FileReader) === 'undefined') {
						result.innerHTML = "抱歉，你的浏览器不支持 FileReader，请使用现代浏览器操作！";
						input.setAttribute('disabled', 'disabled');
						alert("抱歉，你的浏览器不支持 FileReader，请使用现代浏览器操作！");
					}
				});
				input.click();
			});
		};
		//注册置顶按钮的点击事件
		file.top_ico=function(){
			$("#"+settings.id).on('click',".top_ico",function(){
				var firstimg = $("#"+settings.id+" img[name='img']")[0];
				if($(firstimg).attr("ref-id")!=$(this).attr("ref-id")){
					var uuid = $(this).attr("ref-name");
					$("#"+settings.id).prepend($("div[name='"+uuid+"']"));
				}
			});
		}
		//注册左移按钮的点击事件
		file.left_ico=function(){
			$("#"+settings.id).on('click',".left_ico",function(){
				var firstimg = $("#"+settings.id+" img[name='img']")[0];
				if($(firstimg).attr("ref-id")!=$(this).attr("ref-id")){
					var uuid = $(this).attr("ref-name");
					$("div[name='"+uuid+"']").prev().before($("div[name='"+uuid+"']"));
				}
			});
		}
		//注册右移按钮的点击事件
		file.right_ico=function(){
			$("#"+settings.id).on('click',".right_ico",function(){
				var firstimg = $("#"+settings.id+" img[name='img']")[0];
				if($(firstimg).attr("ref-id")!=$(this).attr("ref-id")){
					var uuid = $(this).attr("ref-name");
					$("div[name='"+uuid+"']").next().after($("div[name='"+uuid+"']"));
				}
			});
		}
		//注册s删除按钮的点击事件
		file.del_ico=function(){
			$("#"+settings.id).on('click',".del_ico",function(){
				var uuid = $(this).attr("ref-name");
				var id = $("div[name='"+uuid+"']").find(".id").val();
				//如果配置删除地址，且图片有ID，则请求后台删除图片
				if(settings.delurl != null && id != "0"){
					if(window.confirm('此操作会删除数据库保存的图片,是否执行操作')){
						$.ajax({
							type: 'POST',
							url: settings.delurl,
							data: {id:id},
							success:function(data){
								var json = eval('(' + data + ')');
								if(json.status == 1){
									alert(json.msg);
									$("div[name='"+uuid+"']").remove();
								} else {
									alert(json.msg);
								}      
							} 
						});
					}
					
				} else {
					$("div[name='"+uuid+"']").remove();
				}
			});
		}
		//初始化后台图集
		file.initcreate=function(){
			//加载URL返回数据
			if(settings.url != null){
				$.ajax({
					type: 'POST',
					url: settings.url,
					data:settings.param,
					success:function(data){
						var json = eval('(' + data + ')');
						if(json.status == 1){
							var list = json.result;
							if(settings.model == "multiple"){
								for(var i = 0;i < list.length ;i++){
									create(settings,list[i][settings.value],list[i][settings.txt],list[i][settings.key]);
								}
							} else {
								create(settings,list[0][settings.value],list[0][settings.txt],list[0][settings.key]);
							}
						} else {
							alert(json.msg);
						}      
					} 
				});
			}
			//加载data数据
			if(settings.data.length > 0){
				if(settings.model == "multiple"){
					for(var i = 0;i < settings.data.length ;i++){
						create(settings,settings.data[i][settings.value],settings.data[i][settings.txt],settings.data[i][settings.key]);
					}
				} else {
					create(settings,settings.data[0][settings.value],settings.data[0][settings.txt],settings.data[0][settings.key]);
				}
			}
		}
		//获取加载的所有值,序列化为json字符串
		file.getValue=function(){
			//将数据放入零时from中，序列化取值
			var form = $('<form></form>');  
			form.append($(file).clone());
			var json = form.serializeJson();
			form=null;
			return json;
		};
		//构建回显图片
		create=function(settings,base64,title,id){
			var html = '';
			var uuid = getUuid();
			var html = '<div class="div_unit div_unit'+IMGSIZE[settings.size]+' ui-state-default" ref-id="'+uuid+'_nuit" name="'+uuid+'">';
			var type='http';
			if(id != "0"){
				type='http';
				html+='<input type="hidden" value="'+id+'" name="'+settings.key+'" class="id" type="'+type+'">';
			} else {
				type='base64';
				html+='<input type="hidden" value="'+0+'" name="'+settings.key+'" class="id" type="'+type+'">';
			}
			html+='<input type="hidden" value="'+base64+'" name="'+settings.value+'">';
			html+='<img src="'+base64+'" class="img_unit" type="'+type+'">';
			if(settings.model == "multiple"){
				if(settings.btn){
					html+="<div class='b'>";
					
					if(settings.topbtn){
						html+="<li><img src='image/top.png' name='img' class='top_ico top_ico"+IMGSIZE[settings.size]+"' ref-id='"+uuid+"_left_ico' ref-name='"+uuid+"' title='点我设置头图'></li>";
					}
					if(settings.leftbtn){
						html+="<li><img src='image/left.png' name='img' class='left_ico btn_ico"+IMGSIZE[settings.size]+"' ref-id='"+uuid+"_left_ico' ref-name='"+uuid+"'></li>";
					}
					if(settings.delbtn){
						html+="<li><img src='image/del.png' name='img' class='del_ico btn_ico"+IMGSIZE[settings.size]+" del_ico"+IMGSIZE[settings.size]+"' ref-id='"+uuid+"_del_ico' ref-name='"+uuid+"' ></li>";
					}
					if(settings.rightbtn){
						html+="<li><img src='image/right.png' name='img' ref-id='"+uuid+"_right_ico' ref-name='"+uuid+"' class='right_ico btn_ico"+IMGSIZE[settings.size]+"'></li>";
					}
					
					html+="</div>";
				}
			} else if(settings.model == "single"){
				$("#"+settings.id).empty();
				if(settings.btn){
					html+="<div class='b'>";
					if(settings.delbtn){
						html+="<li><img src='image/del.png' name='img' class='del_ico btn_ico"+IMGSIZE[settings.size]+" del_ico"+IMGSIZE[settings.size]+"' ref-id='"+uuid+"_del_ico' ref-name='"+uuid+"' ></li>";
					}
					html+="</div>";
				}
			}
			if(settings.title){
				if(title == null || title == ''){
					html+='<div class="input"><input type="text" class="text_input"  name="title" placeholder="'+settings.titletxt+'"/></div></div>';
				} else {
					html+='<div class="input"><input type="text" class="text_input" value="'+title+'" name="'+settings.txt+'" placeholder="'+settings.titletxt+'"/></div></div>';
				}
				//html+='<div class="input"><input type="text" class="text_input" value="'+title+'" name="title" placeholder="'+settings.titletxt+'"/></div></div>';
			}
			$("#"+settings.id).append(html);
		};
		//获取一个32位的随机码
		getUuid = function(){
	  		var len=32;//32长度
	  		var radix=16;//16进制
	  		var chars='0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');
			var uuid=[],i;radix=radix||chars.length;if(len){for(i=0;i<len;i++)uuid[i]=chars[0|Math.random()*radix];}else{var r;uuid[8]=uuid[13]=uuid[18]=uuid[23]='-';uuid[14]='4';for(i=0;i<36;i++){if(!uuid[i]){r=0|Math.random()*16;uuid[i]=chars[(i==19)?(r&0x3)|0x8:r];}}}
	  		return uuid.join('');
		};
		file.init();
		return this;  
	};
})(jQuery);
