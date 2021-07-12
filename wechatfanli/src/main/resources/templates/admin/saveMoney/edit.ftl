<!DOCTYPE html>
<html class="x-admin-sm">

    <head>
        <title>超级省钱活动编辑</title>
        <#include "/admin/common/common.ftl">
        <script type="text/javascript" src="/static/xadmin/js/jquery.min.js"></script>
    </head>
    <body style="background-color:#fff">
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form" lay-filter="example">
                    <input type="hidden" name="tokens" value="${tokens!}">
                    <input type="hidden" name="id" value="${(info.id)!}">
                     
                    <div class="layui-form-item">
                          <label class="layui-form-label">
                              <span class="x-red">*</span>活动名：
                         </label>
                        <div class="layui-input-inline">
                              <input type="text" name="name" required="" lay-verify="required"
                                autocomplete="off" class="layui-input" value="${(info.name)!}" maxlength="100" >
                          </div>
                    </div>
                    
                    <div class="layui-form-item">
		                <label class="layui-form-label">
		                   <span class="x-red">*</span>活动banner图：
		                </label>
		                <div class="layui-input-inline">
		                  <input name="banner" required="" lay-verify="required" id="imgPath1" placeholder="banner图地址"  value="${(info.banner)!}" class="layui-input">
		                </div>
		                <div class="layui-input-inline layui-btn-container" style="width: auto;">
		                  <input type="file" id="fileToUpload1" class="layui-btn"  style="width: 85px;background: white;" />
		                </div>
	               </div>
	               
	               <div class="layui-form-item">
                          <label class="layui-form-label">
                              <span class="x-red">*</span>活动链接：
                         </label>
                        <div class="layui-input-inline">
                              <input type="text" name="link" required="" lay-verify="required"
                                autocomplete="off" class="layui-input" value="${(info.link)!}" maxlength="100" >
                          </div>
                    </div>
                    
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class="x-red">*</span>活动状态：
                        </label>
                        <div class="layui-input-inline">
                            <select title="活动状态" class="ui selection search dropdown" required="" lay-verify="required" lay-search  name="status" id="status" >
                                <option value="">请选择</option>
                                    <option value="0" <#if info?? && info.status?? && info.status==0> selected</#if> >正常</option>
									<option value="1" <#if info?? && info.status?? && info.status==1> selected</#if> >失效</option>
                            </select>
                        </div>
                    </div>
	               
                    
                    <div class="layui-form-item">
                        <label class="layui-form-label"></label>
                        <button class="layui-btn" lay-filter="add" lay-submit="">提交</button>
                    </div>
              </form>
            </div>
        </div>
        <script type="text/javascript">
            layui.use(['form', 'layer'], function () {
                var form = layui.form;
                var layer = layui.layer;
                var $ = layui.$;
                
                
                $('#fileToUpload1').change(function(){
					var formdata = new FormData();
					url = "/cms/imageUpload";
					var fileObj = $(this).get(0).files;
					formdata.append("myfile", fileObj[0]);
					jQuery.ajax({
						url : url,
						type : 'post',
						data : formdata,
						cache : false,
						contentType : false,
						processData : false,
						dataType : "json",
						success : function(data) {
							if (data.code == 200) {
								$("#imgPath1").val(data.url);
								layer.msg('上传成功');
							}else{
								layer.msg('上传失败');
							}
						}
					});
				})

                
                form.on('submit(add)', function (data) {
                    $('.layui-form-item .layui-btn').prop('disabled', true);
                    $('.layui-form-item .layui-btn').text('提交中...');
                    var id = $("input[name='id']").val();
                    var url = (id == null || id === '') ? '/cms/savemoney/add' : '/cms/savemoney/update';
                    $.ajax({
                        type: 'post',
                        url: url,
                        data: data.field,
                        dataType: 'json',
                        success: function (data) {
                            if (data.code !== 0) {
                                $('.layui-form-item .layui-btn').prop('disabled', false);
                                $('.layui-form-item .layui-btn').text('提交');
                                layer.msg(data.msg);
                                return false;
                            }
                            xadmin.close();
                            layer.closeAll();
                            parent.reload();
                        },
                        error: function (XMLHttpRequest, textStatus, errorThrown) {
                            $('.layui-form-item .layui-btn').prop('disabled', false);
                            $('.layui-form-item .layui-btn').text('提交');
                            layer.msg('系统异常');
                        }
                    });
                    return false;
                });
            });
            
        </script>
        <style type="text/css">
            .layui-form-label {
                width: 200px;
            }
        </style>
    </body>
</html>
