if (navigator.userAgent.toLowerCase().indexOf('bbs.cn666.com') !== -1) {
    $('#jumpquan').html("手机淘宝领券");
}

function showtkl() {
    $('#weixin-tt').show();
    $('#weixin-tt').css('height', innerWidth); //兼容IOS弹窗整屏
    $('#weixin-tt').addClass("quanpost");
    $('#xywxobg').show();
    $('#closed').show();
    $('.xywxti').hide();

}

$(function () {
    $('#closed').live('click', function () {
        $('#weixin-tt').css('height', 'auto');
        $('#weixin-tt').hide();
        $('#xywxobg').hide();
//		$('#closed').hide();
        $('#weixin-tt').removeClass("quanpost");
    });
});


$("#copy_key_android").live('click', function () {
    document.activeElement.blur();
});
$(function () {
    document.addEventListener("selectionchange", function (e) {
        if (window.getSelection().anchorNode.parentNode.id == 'copy_key_ios' && document.getElementById('copy_key_ios').innerText != window.getSelection()) {
            var key = document.getElementById('copy_key_ios');
            window.getSelection().selectAllChildren(key);
        }
    }, false);
});
var ua = navigator.userAgent.toLowerCase();
if (device.mobile()) {
    if (ua.match(/iphone/i) == "iphone" || ua.match(/ipad/i) == "ipad") {
        $('.xywxti').html("<img src='/static/jwap/images/ioscopy.png' style='width:100%;max-width:650px'>");
        $('.fq-explain span').css('background', 'white');
        $("#copy_key_ios").show();
        $("#copy_key_android").hide();
        $("#copy_key_pc").hide();
        $('input').focus(function () {
            window.setTimeout('scrollBottom()', 300);
        });
        $("#ccopypc").hide();
        $("#copyios").show();
        $("#copyandroid").hide();
        var clipandroid = new Clipboard('#copyios');
        clipandroid.on('success', function (e) {
            $(".copybtn").css("background-color", "#039024");
            $('#copyios').html("复制成功，请打开手机淘宝");
            e.clearSelection();
        });
        clipandroid.on('error', function (e) {
            $(".copybtn").css("background-color", "#063ede");
            $('#copyios').html("复制失败，请手动复制");
            $('.xywxti').show();
        });

    } else {
        $('.xywxti').html("<img src='/static/jwap/images/androidcopy.png' style='width:100%;max-width:650px'>");
        $("#copy_key_ios").hide();
        $("#copy_key_android").show();
        $("#copy_key_pc").hide();

        $("#ccopypc").hide();
        $("#copyios").hide();
        $("#copyandroid").show();
        var clipandroid = new Clipboard('#copyandroid');
        clipandroid.on('success', function (e) {
            $(".copybtn").css("background-color", "#039024");
            $('#copyandroid').html("复制成功，请打开手机淘宝");
            e.clearSelection();
        });
        clipandroid.on('error', function (e) {
            $(".copybtn").css("background-color", "#063ede");
            $('#copyandroid').html("复制失败，请手动复制");
            $('.xywxti').show();
        });

    }
} else {
    $('.xywxti').html("");
    $("#copy_key_ios").hide();
    $("#copy_key_android").hide();
    $("#copy_key_pc").show();
    $('#weixin-tt').hide();
    $("#copypc").show();
    $("#copyios").hide();
    $("#copyandroid").hide();
    var clipandroid = new Clipboard('#copypc');
    clipandroid.on('success', function (e) {
        $(".copybtn").css("background-color", "#039024");
        $('#copypc').html("复制成功");
        e.clearSelection();
    });
    clipandroid.on('error', function (e) {
        $(".copybtn").css("background-color", "#063ede");
        $('#copypc').html("复制失败，请手动复制");
    });
}

function scrollBottom() {
    window.scrollTo(0, 250);
}

var taokouling_value = document.getElementById("copy_key_android").value;

function regain() {
    document.getElementById('copy_key_android').value = taokouling_value;
}


function getiteminfo(itemid) {
    $("#tab1").fadeIn();
    $("#tabtxt").html('商品图文详情（加载完毕，请您查阅）');
    $.ajax({
        url: "https://hws.m.taobao.com/cache/mtop.wdetail.getItemDescx/4.1/?data=%7Bitem_num_id%3A" + itemid + "%7D&type=jsonp&dataType=jsonp",
        dataType: 'jsonp',
        jsonp: 'callback',
        success: function (result) {
            if (result.ret[0] == "SUCCESS::接口调用成功") {
                var len = result.data.images.length;
                var image = new Array();
                for (var i = 0; i < len; i++) {
                    image[i] = "<img src='" + result.data.images[i] + "' style='width:100%;max-width:100%'>";
                }
                $('.tab1').html(image);
                lazy_img();
            }
        }
    });
}

$("#bady-tab li").eq(0).addClass("active");
$('#bady-tab li').on('click', function () {
    $("#bady-tab li").removeClass("active");
    $(this).addClass("active");
    $(".tab1,.tab2").hide();
    $(".tab" + ($(this).index() + 1)).show();
});

$(document).on('click', '#get_desc', function () {
    var _this = $(this);
    var getfan;
    var itemid = _this.attr('data-itemid');
    var tpe = _this.attr('data-type');
    $.ajax({
        url: "https://h5api.m.taobao.com/h5/mtop.taobao.detail.getdesc/6.0/?data=%7B%22id%22%3A%22" + itemid + "%22%2C%22type%22%3A%221%22%2C%22f%22%3A%22%22%7D",
        timeout: 1000,
        tryCount: 0,
        dataType: 'jsonp',
        jsonp: 'callback',
        beforeSend: function (XMLHttpRequest) {
            getfan = layer.load();
        },
        success: function (result) {
            layer.close(getfan);

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

                $('.tab2').html(image);
                $('.tab1').hide();
                $(".tab2").fadeIn();
            }

        },
        error: function (xhr, textStatus, errorThrown) {
            this.tryCount++;
            //try again
            $.ajax(this);
            return;
        }
    });
});