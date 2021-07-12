(function($){   

    /**
     * 不同屏幕
     * @author mumian@juanpi.com
     * @date   2014-12-05
     */
    var FunAdapt=function(){
        if($(window).width()>1024 && location.hash != "#narrow"){
            $(".jp-pc").addClass("w1200");
        }else{
            $(".jp-pc").removeClass("w1200");
        }
        if(location.hash == "#narrow"){
        	$("body,.header").css("min-width","980px");
        }
//        $(window).resize(function(){
//            if($(window).width()>1024){
//                $(".jp-pc").addClass("w1200");
//            }else{
//                $(".jp-pc").removeClass("w1200");
//            }
//        });
    }
    FunAdapt();


    /**ake 关于兼容mac retina屏 首页当为mac系统logo换成两倍的图片
     *@time 2014-09-09
     */
    if(navigator.platform.indexOf('Mac') > -1){
        $("div.logo01").addClass("juan-logo01 ")
        $(".juan-user").addClass("juan-user01")
        $(".juan-jf").addClass("juan-jf01")
        $(".juan-fanli").addClass("juan-fanli01")
        $(".juan-iphone").addClass("juan-iphone01")
        $(".juan-brand").addClass("juan-brand01")
        $(".protection").addClass("protection01")
    }else{
        $("div.logo").removeClass("juan-logo01 ")
        $(".juan-user").removeClass("juan-user01")
        $(".juan-jifen").removeClass("juan-jifen01")
        $(".juan-fanli").removeClass("juan-fanli01")
        $(".juan-iphone").removeClass("juan-iphone01")
        $(".juan-brand").removeClass("juan-brand01")
        $(".protection").removeClass("protection01")

    }

})(jQuery);