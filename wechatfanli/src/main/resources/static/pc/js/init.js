(function($){
    $.fn.slowShow = function(ele,time){
        time = time == undefined?100:time;
        var timer=null;
        clearInterval(timer);
        this.hover(function(){
                clearTimeout(timer);
                timer=setTimeout(function(){
                    ele.show();
                },time);
            },
            function(){
                clearTimeout(timer);
                timer=setTimeout(function(){
                    ele.hide();
                },time);
            }
        )
    }



})(jQuery);

(function($){
    

   

    /**
     * 右侧返回顶部
     * @author xueli@juanpi.com
     * @date   2014-10-14
     * @return {[type]}   [description]
     */
    var $navFun_2 = function() {
        var st = $(document).scrollTop(),
            winh = $(window).height(),
            doch = $(document).height(),
            headh = $("#toolbar").height(),
            header = $(".header").height(),
            $nav_classify = $("div.side_right");

        if(st > headh + header){
            $nav_classify.show()
            $nav_classify.addClass('fix')
        } else {

            $nav_classify.hide()
            $nav_classify.removeClass('fix')
        }
    };

    var $navFun = function(){
        $navFun_1();
        $navFun_2();
    }

    /**
     * fangfang，绑定滚动函数
     * @param {}
     * @time 2014-02-12
     */
    

    $('a.go-top').click(function(){
        $('body,html').animate({scrollTop:0},500);
    });
    $('#J_sidebar .side-box a#J_backtop').click(function(){
        $('body,html').animate({scrollTop:0},500);
    });
    //显示回到顶部按钮
    var backtop_show=function(){
        $(window).scroll(function(){
            var st=$(window).scrollTop();
            if(st>0){
               $("a#J_backtop").css("display","block"); 
            }
            else{
                $("a#J_backtop").css("display","none");
                $("a#J_backtop").parents().find(".tab-tips").css({"opacity":"0","display":"none","right":"62px"});
            }
        })
    }
    backtop_show();
   
    

    


    /**
     * 右侧购物袋交互
     * Author:phpdance
     * 2015-03-26新增
     * */
    var $obj=null;
    var timer=null;
    var normal_show_fun=function(){
        clearInterval(timer);
        $('#J_sidebar .side-oper li').hover(function(){
                $('#J_sidebar .side-oper li').find(".tab-tips").css({"opacity":"0","display":"none","right":"62px"})
                $('#J_sidebar .side-oper li').removeClass("curr");
                $("#J_sidebar .side-oper li.side-cart").removeClass("selected");
                $obj=$(this);
                clearTimeout(timer);
                timer=setTimeout(function(){
                    $obj.addClass("curr");
                    if($obj.hasClass("side-cart")){
                        if($obj.find(".carttime").html()=="" || $obj.find("em.cartnum").html()=="0"){
                            $('.carttime').hide();
                            return;
                        }
                    }
                    if(($obj.hasClass("side-backtop") && $obj.find("a.links").css("display")=="none")||($obj.hasClass("side-cart") && $obj.find("#side-empty").css("display")=="block")){
                        return;
                    }else{
					  if($obj.hasClass("side-ad")){
                    $obj.find(".tab-tips").css({"opacity":"1","display":"none","right":"250px","top":"-50px"});
                        $obj.find(".tab-tips").animate({
                            right: 208,opacity: 'show'
                        }, 300);
                }else{
                        $obj.find(".tab-tips").css("opacity","1");
                        $obj.find(".tab-tips").animate({
                            right: 36,opacity: 'show'
                        }, 300);
                    }
					}
                },100);
                if($obj.hasClass("side-user")){
                    $obj.find(".close").on('click',function(){
                        $obj.find(".tab-tips").css({"opacity":"0","display":"none","right":"62px"});
                    })
                }
				
            },
            function(){
                clearTimeout(timer);
                timer=setTimeout(function(){
                    $obj.removeClass("curr");
                    $obj.find(".tab-tips").css({"opacity":"0","display":"none","right":"62px"});
                    if($obj.hasClass("side-cart")){
                        $obj.removeClass("selected");
                    }
                },100);
            }
        )

        //会员中心特殊处理
        $('#J_sidebar .side-oper li.side-user').hover(function(){
            if (cn666.uid == '') {
                //未登录
                $(this).find('#side-login .user-box p.txt').html('快来<a target="_blank" href="'+cn666.loginurl+'">登录</a>吧，么么哒！');
            }else{
                $(this).find('#side-login .user-box p.txt').html('<a target="_blank" href="'+cn666.userurl+'">你好！'+cn666.username+'</a>');
                var _partten = /.*?\/default(\_60)?.jpg$/;
                if ( !_partten.test(cn666.face) ) {
                    $(this).find('#side-login .user-box .pic img').attr('src', cn666.face);
                }
            }
        })
        
    }
    normal_show_fun(); //鼠标移入在左侧显示信息的效果

    

})(jQuery);
