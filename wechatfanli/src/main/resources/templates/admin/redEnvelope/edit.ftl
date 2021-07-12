<!DOCTYPE html>
<html class="x-admin-sm">

    <head>
        <title>返利红包活动编辑</title>
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
                            <span class="x-red">*</span>红包类型：
                        </label>
                        <div class="layui-input-inline">
                            <select title="红包类型" class="ui selection search dropdown" required="" lay-verify="required" lay-search  name="type" id="type" >
                                <option value="">请选择</option>
                                    <option value="1" <#if info?? && info.type?? && info.type==1> selected</#if> >支付宝红包</option>
									<option value="2" <#if info?? && info.type?? && info.type==2> selected</#if> >饿了么红包</option>
                            </select>
                        </div>
                    </div>
	               
	               <div class="layui-form-item">
                          <label class="layui-form-label">
                              <span class="x-red">*</span>口令：
                         </label>
                        <div class="layui-input-inline">
                              <input type="text" name="kl" required="" lay-verify="required"
                                autocomplete="off" class="layui-input" value="${(info.kl)!}" maxlength="100" >
                          </div>
                    </div>
                    
                   <div class="layui-form-item">
                          <label class="layui-form-label">
                              <span class="x-red">*</span>内容：
                         </label>
                        <div class="layui-input-inline">
                              <input type="text" name="content" required="" lay-verify="required"
                                autocomplete="off" class="layui-input" value="${(info.content)!}" maxlength="100" >
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
                 
                form.on('submit(add)', function (data) {
                    $('.layui-form-item .layui-btn').prop('disabled', true);
                    $('.layui-form-item .layui-btn').text('提交中...');
                    var id = $("input[name='id']").val();
                    var url = (id == null || id === '') ? '/cms/redenvelope/add' : '/cms/redenvelope/update';
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
