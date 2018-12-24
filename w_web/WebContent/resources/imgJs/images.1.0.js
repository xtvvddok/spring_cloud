
//可选择的图片显示规格,若新增需增加相对应的css样式
var IMGSIZE = new Array();
IMGSIZE[0] = '_300_190';
IMGSIZE[1] = '_190_120';
IMGSIZE[2] = '_150_150';
IMGSIZE[3] = '_90_90';

(function ($) { 
	$.fn.Imagefile = function(options) {
		 var file = this;  
		 var defaults = {
			id:$(file).attr("id"),				//当前图集的容器ID
			url:null,							//加载数据的地址（url和data同时存在的情况下，优先加载url返回的数据）默认加载数据格式为:{"result":[{"base64":"XX","id":"XX","title":"XX"}],"status":1}
			param:{},							//加载URL数据的参数
			data:[],							//需填充的数据,默认为空	（url和data同时存在的情况下，优先加载url返回的数据）默认加载数据格式为:[{"base64":"XX","id":"XX","title":"XX"}]
			image:null,
			topbtn: true,						//是否需要置顶按钮,默认true
			rightbtn: true,						//是否需要右移按钮,默认true
			leftbtn: true,						//是否需要左移按钮,默认true
			delbtn:true,						//是否需要删除按钮,默认true
			btn:true,							//是否需要按钮,默认true,为false时所有按钮不显示
			size:0,								//图片显示大小，默认为0，详细规格看IMGSIZE数组值
			checkfile:'checkfile',				//触发文本选择器的按钮ID
			titletxt:'请设置标题',				//标题文本框的默认显示文字
			title : true,						//是否需要标题文本框,默认true,
			model:"multiple",					//图片展示模式，single单图展示，multiple多图展示模式
			delurl:null,						//删除按钮点击事件,如需请求后台删除数据库，配置该地址
			
			value:"base64",						//图片的BASE64的值。配置加载的数据对应字段
			key:"id",							//图片的ID的值。配置加载的数据对应字段
			txt:"title"                         //图片的TITLE的值。配置加载的数据对应字段
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
			alert(settings.image);
			if(settings.image.length > 0){
				
				create(settings,settings.image,null,null);
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
			if(settings.model == "multiple"){
//				alert(1);
				var uuid = getUuid();
				var html = '<span class="div_unit div_unit'+IMGSIZE[settings.size]+' ui-state-default" ref-id="'+uuid+'_nuit" name="'+uuid+'">';
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
						html+='<div class="input"><input type="text" class="text_input"  name="title" placeholder="'+settings.titletxt+'"/></div></span>';
					} else {
						html+='<div class="input"><input type="text" class="text_input" value="'+title+'" name="'+settings.txt+'" placeholder="'+settings.titletxt+'"/></div></span>';
					}
					//html+='<div class="input"><input type="text" class="text_input" value="'+title+'" name="title" placeholder="'+settings.titletxt+'"/></div></div>';
				}
				
			} else if(settings.model == "single"){
				var uuid = getUuid();
				var html = '<span class="div_unit div_unit'+IMGSIZE[settings.size]+' ui-state-default" ref-id="'+uuid+'_nuit" name="'+uuid+'">';
				if(settings.image == null){
					html+='<input type="hidden" value="'+base64+'" name="'+settings.value+'">';
					html+='<img src="'+base64+'" class="img_unit" type="'+type+'">';
					$("#"+settings.id).empty();
				} else {
					html+='<img src="'+settings.image+'" class="img_unit" type="'+type+'">';
				}
				if(settings.btn){
					html+="<div class='b'>";
					if(settings.delbtn){
						html+="<li><img src='image/del.png' name='img' class='del_ico btn_ico"+IMGSIZE[settings.size]+" del_ico"+IMGSIZE[settings.size]+"' ref-id='"+uuid+"_del_ico' ref-name='"+uuid+"' ></li>";
					}
					html+="</div>";
				}
				if(settings.title){
					if(title == null || title == ''){
						html+='<div class="input"><input type="text" class="text_input"  name="title" placeholder="'+settings.titletxt+'"/></div></span>';
					} else {
						html+='<div class="input"><input type="text" class="text_input" value="'+title+'" name="'+settings.txt+'" placeholder="'+settings.titletxt+'"/></div></span>';
					}
					//html+='<div class="input"><input type="text" class="text_input" value="'+title+'" name="title" placeholder="'+settings.titletxt+'"/></div></div>';
				}
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

(function($){
    $.fn.serializeJson = function(){
        var jsonData1 = {};
        var serializeArray = this.serializeArray();
        // 先转换成{"id": ["12","14"], "name": ["aaa","bbb"], "pwd":["pwd1","pwd2"]}这种形式
        $(serializeArray).each(function () {
            if (jsonData1[this.name]) {
                if ($.isArray(jsonData1[this.name])) {
                    jsonData1[this.name].push(this.value);
                } else {
                    jsonData1[this.name] = [jsonData1[this.name], this.value];
                }
            } else {
                jsonData1[this.name] = this.value;
            }
        });
        // 再转成[{"id": "12", "name": "aaa", "pwd":"pwd1"},{"id": "14", "name": "bb", "pwd":"pwd2"}]的形式
        var vCount = 0;
        // 计算json内部的数组最大长度
        for(var item in jsonData1){
            var tmp = $.isArray(jsonData1[item]) ? jsonData1[item].length : 1;
            vCount = (tmp > vCount) ? tmp : vCount;
        }
        if(vCount > 1) {
            var jsonData2 = new Array();
            for(var i = 0; i < vCount; i++){
                var jsonObj = {};
                for(var item in jsonData1) {
                    jsonObj[item] = jsonData1[item][i];
                }
                jsonData2.push(jsonObj);
            }
            return JSON.stringify(jsonData2);
        }else{
            return "[" + JSON.stringify(jsonData1) + "]";
        }
       };
  })(jQuery); 

//按钮显示
$(document).on("mouseover",".div_unit",function(){
	$(this).find('.b').show();
});
//按钮隐藏
$(document).on("mouseout",".div_unit",function(){
	$(this).find('.b').hide();
});

