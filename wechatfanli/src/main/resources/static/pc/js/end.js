function show_date_time(end,style,id){
    today=new Date(); 
	timeold=((end)*1000-today.getTime()); 
	if (timeold < 0) {
        return;
    }
    setTimeout("show_date_time("+end+','+style+','+id+")", 100); 
    sectimeold=timeold/1000;
	secondsold=Math.floor(sectimeold); 
	msPerDay=24*60*60*1000;
	e_daysold=timeold/msPerDay;
	daysold=Math.floor(e_daysold); 
	e_hrsold=(e_daysold-daysold)*24;
	hrsold=Math.floor(e_hrsold); 
	e_minsold=(e_hrsold-hrsold)*60;
	minsold=Math.floor((e_hrsold-hrsold)*60); 
	e_seconds = (e_minsold-minsold)*60;
	seconds=Math.floor((e_minsold-minsold)*60); 
	ms = e_seconds-seconds;
	ms = new String(ms);
	ms1 = ms.substr(2,1);
	ms2 = ms.substr(2,2);
	hrsold1=daysold*24+hrsold;
	if(style == 1){
		$("#end_date_"+id).html((hrsold1<10?'0'+hrsold1:hrsold1)+"小时"+(minsold<10?'0'+minsold:minsold)+"分"+(seconds<10?'0'+seconds:seconds)+"秒");
	}else if(style == 2){
		$("#end_date_"+id).html("<em id='d'>"+daysold+"</em>天<em id='h'>"+(hrsold<10?'0'+hrsold:hrsold)+"</em>时<em id='m'>"+(minsold<10?'0'+minsold:minsold)+"</em>分<em id='s'>"+(seconds<10?'0'+seconds:seconds)+"</em>秒");
	}else if(style == 3){
		$("#end_date_"+id).html((hrsold1<10?'0'+hrsold1:hrsold1)+"小时"+(minsold<10?'0'+minsold:minsold)+"分"+(seconds<10?'0'+seconds:seconds)+"."+ms1+"秒");
	}else{
		$("#end_date_"+id).html(daysold+"天"+(hrsold<10?'0'+hrsold:hrsold)+"小时"+(minsold<10?'0'+minsold:minsold)+"分"+(seconds<10?'0'+seconds:seconds)+"秒."+ms2);
	}
}
$(".buy_time").each(function() {
        var reg = /^[0-9]+$/;
        var time = $(this).attr('data-time');
        if (reg.test(time)) {
            show_date_time(time, 2, 0);
        }
	});


    $(".bady-tab:eq(0) li:eq(0)").find("a").addClass("badyactive");
    $(".bady-tab:eq(0) li:eq(0)").find("div").addClass("bady-line-top");    
    $(".bady-tab:eq(0) li").click(function(){
        $(document).scrollTop($('.bady-tab').offset().top-1);
        $(".bady-tab").not( $(".bady-tab:eq(0)")).hide();
        $(this).parents("ul").find("a").removeClass("badyactive");
        $(this).parents("ul").find("div").removeClass("bady-line-top");
        $(this).find("a").addClass("badyactive");
        $(this).find("div").addClass("bady-line-top");
		//alert($(this).index())
        if($(this).index() == 0){
        $(".bady-tab,.information").show();
		$("#desc").css({height:"50px",display:"block"});	
		$("#comm").css({height:"0px",display:"none"});
		$("#intro").css({height:"0px",display:"none"});
        }
		if($(this).index() == 1){
		$(".bady-tab02,.jp2").show();
		$(".bady-tab01,.jp1").hide();
		$(".bady-tab03,.jp3").hide();
		$("#desc").css({height:"0px",display:"none"});	
		$("#comm").css({height:"50px",display:"block"});
		$("#intro").css({height:"0px",display:"none"});
		}
		if($(this).index() == 2){
		$(".bady-tab02,.jp2").hide();
		$(".bady-tab01,.jp1").hide();				
		$(".bady-tab03,.jp3").show();
		$("#desc").css({height:"0px",display:"none"});	
		$("#comm").css({height:"0px",display:"none"});
		$("#intro").css({height:"50px",display:"block"});
		}		
    });	

    $("#J_cmt_page").find("a").live('click', function(){
	$('body,html').animate({scrollTop:580},2000);
	})
    var F_zhe800CeleMenuAni = function(){
        var jiuMenuObj = $('#bady-tab');
        var Tab01Obj= $('.tab1').find("a")
        var Tab02Obj= $('.tab1').find("div")
        var Tab03Obj= $('.tab2').find("a")
        var Tab04Obj= $('.tab2').find("div")
        var Tab05Obj= $('.tab3').find("a")
        var Tab06Obj= $('.tab3').find("div")	    
		var Tab1= $('.bady-tab01').offset().top
		var Tab2= $('.bady-tab02').offset().top
		var Tab3= $('.bady-tab03').offset().top
        var menuScrolFunc = function(){
            scrolY = $(window).scrollTop();
            if(scrolY < 580){
                jiuMenuObj.removeClass('fixed');
                $('div.gobuy').hide();
            }else{
                jiuMenuObj.addClass('fixed');
                $('div.gobuy').show();
            }
            if(scrolY >=Tab3 && !($(".information:eq(0)").is(":hidden"))){		        
                Tab03Obj.removeClass("badyactive");
                Tab04Obj.removeClass("bady-line-top");
                Tab01Obj.removeClass("badyactive");
                Tab02Obj.removeClass("bady-line-top");
				Tab05Obj.addClass("badyactive");
                Tab06Obj.addClass("bady-line-top")
            }else if(scrolY >=Tab2 && !($(".information:eq(0)").is(":hidden"))){	                        
                Tab05Obj.removeClass("badyactive");
                Tab06Obj.removeClass("bady-line-top");
                Tab01Obj.removeClass("badyactive");
                Tab02Obj.removeClass("bady-line-top");
                Tab03Obj.addClass("badyactive");
                Tab04Obj.addClass("bady-line-top")
            }else if(scrolY >=Tab1 && !($(".information:eq(0)").is(":hidden"))){           
                Tab05Obj.removeClass("badyactive");
                Tab06Obj.removeClass("bady-line-top");
                Tab03Obj.removeClass("badyactive");
                Tab04Obj.removeClass("bady-line-top");
				Tab01Obj.addClass("badyactive");
                Tab02Obj.addClass("bady-line-top")
            }

        }
        var F_nmenu_scroll = function () {
            if (!window.XMLHttpRequest) {
                return;
            }else{
                //默认执行一次
                menuScrolFunc();
                $(window).bind("scroll", menuScrolFunc);
            }
        }
        F_nmenu_scroll();
    }
    F_zhe800CeleMenuAni();



	    var pview = $(".photos-thumb");
		var w = $(window).width();
		var h = $(window).height();		
		pview.each(function(){
			$(this).hover(function(e){
				if(/.png$|.gif$|.jpg$|.bmp$|.jpeg$/.test($(this).attr("data-src"))){
					$("body").append("<div id='preview'><img src='"+$(this).attr('data-src')+"' /></div>");
				}
				var show_x = $(this).offset().left + $(this).width();
				var show_y = $(this).offset().top;
				var scroll_y = $(window).scrollTop();
				$("#preview").css({
					position:"absolute",
					padding:"4px",					
					border:"1px solid #eee",
					backgroundColor:"#eeeeee",
					top:show_y + "px",
					left:show_x + "px",
					zIndex:1000
				});				
				$("#preview > div").css({
					padding:"5px",
					backgroundColor:"white",					
					border:"1px solid #eee",					
					zIndex:1000
				});
				
				if (show_y + 230 > h + scroll_y) {
					$("#preview").css("bottom", h - show_y - $(this).height() + "px").css("top", "auto");
				} else {
					$("#preview").css("top", show_y + "px").css("bottom", "auto");
				}
				$("#preview").fadeIn("fast")
			},function(){
				$("#preview").remove();
			})					  
		});
		
		
		

function getiteminfo(itemid) {
	$("#tabtxt").html('商品图文详情（加载中......）');
	$("#descimg").fadeIn();
	$.ajax({
		url: "https://h5api.m.taobao.com/h5/mtop.taobao.detail.getdesc/6.0/?data=%7B%22id%22%3A%22" + itemid + "%22%2C%22type%22%3A%221%22%2C%22f%22%3A%22%22%7D",
		timeout: 1000,
		tryCount: 0,
		retryLimit: 3,
		dataType: 'jsonp',
		jsonp: 'callback',
		success: function(result) {
			if (result.ret[0] == "SUCCESS::调用成功") {
				var img = result.data.pcDescContent;
				var image = new Array();
				var imgReg = /<img.*?(?:>|\/>)/gi;
				var srcReg = /src=[\'\"]?([^\'\"]*)[\'\"]?/i;
				var arr = img.match(imgReg);
				for (var i = 0; i < arr.length; i++) {
					var src = arr[i].match(srcReg);
					if (src[1]) {
						if (src[1].indexOf("spaceball") != -1) {
							image[i] = ""
						} else {
							image[i] = "<img src='" + src[1] + "' style='width:100%;max-width:100%'>"
						}
					}
				}
				$(".descimg").html(image);
				$("#tabtxt").html('商品图文详情（加载完毕，请您查阅）')
			}
		},
		error: function(xhr, textStatus, errorThrown) {
			this.tryCount++;
			$("#tabtxt").html('商品图文详情（加载中' + this.tryCount + '......）');
			$.ajax(this);
			return
		}
	})
}
	