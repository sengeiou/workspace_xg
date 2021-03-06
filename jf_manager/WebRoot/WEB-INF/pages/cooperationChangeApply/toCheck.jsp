<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@include file="/common/common-tag.jsp"%>
<%@ taglib prefix="t" uri="/gzs_tag_lib" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link href="${pageContext.request.contextPath}/css/form.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/viewer.min.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/js/viewer.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/common/js/utils/ajaxfileupload.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/common/js/uploadImageList.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/css/upload_image_list.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/kindeditor-4.1.7/themes/default/default.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/kindeditor-4.1.7/plugins/code/prettify.css" />
<script charset="utf-8" src="${pageContext.request.contextPath}/kindeditor-4.1.7/kindeditor.js"></script>
<script charset="utf-8" src="${pageContext.request.contextPath}/kindeditor-4.1.7/lang/zh_CN.js"></script>
<script charset="utf-8" src="${pageContext.request.contextPath}/kindeditor-4.1.7/plugins/code/prettify.js"></script>
<style type="text/css">
body {font-size: 12px;padding: 10px;}
td input,td select{border:1px solid #AECAF0;}
.table-title{font-size: 14px;color: #333333;font-weight: 600;}
.title-top{padding-top:10px;padding-bottom:10px;}
.marR10{margin-right:10px;}
.marT10{margin-top:10px;}
.marB05{margin-bottom:5px;}
li{float: left;}
</style>
<script type="text/javascript">
var viewerPictures;
var editor1;
KindEditor.ready(function(K) {
	 editor1 = K.create('textarea[name="processInnerRemarks"]', {
		cssPath : '${pageContext.request.contextPath}/kindeditor-4.1.7/plugins/code/prettify.css',
		uploadJson : '${pageContext.request.contextPath}/kindeditor-4.1.7/jsp/upload_json.jsp',
		fileManagerJson : '${pageContext.request.contextPath}/kindeditor-4.1.7/jsp/file_manager_json.jsp',
		allowFileManager : true,
		afterCreate : function() {
		}
		
	});
	prettyPrint();
});
$(function(){

	viewerPictures = new Viewer(document.getElementById('viewer-pictures'), {hide:function(){
		$("#viewer-pictures").hide();
	}});

    $(".pic").click(function(){
		var imgPath = $(".pic").attr('src');
		viewerPic(imgPath);
    });
	
	$("input[name='status']").bind('click',function(){
		var status = $(this).val();
		if(status == "1"){
			$("#rejectReasonTr").hide();
			$("#processInnerRemarksTr").show();
		}else{
			$("#rejectReasonTr").show();
			$("#processInnerRemarksTr").hide();
		}
	});
	
		$("#confirm").bind('click',function(){
			var status = $("input[name='status']:checked").val();
			if(!status){
				commUtil.alertError("请选择审核结果");
				return false;
			}
			var remarks = $("#remarks").val();
			if(status == "2"){
				if(!remarks){
					commUtil.alertError("驳回原因必填");
					return false;
				}

			}
			var pictures = [];
			var lis = $(".upload_image_list").find("li");
			lis.each(function(index, item) {
				var path = $("img", item).attr("path");
				var def = ($(".def", item).length == 1 ? "1" : "0");
				var pic = {picPath: path, isPrimary: def, picOrder: index + 1};
				pictures.push(pic);
			});
			// if(pictures.length > 0){
            //			// 	if(pictures.length>5){
            //			// 		commUtil.alertError("最多只能上传5个凭证");
            //			// 		return false;
            //			// 	}else{
            //			// 		$("#complainOrderPics").val(JSON.stringify(pictures));
            //			// 	}
            //			// }
			editor1.sync('processInnerRemarks');
			var param = $("#form").serialize();
			$.ajax({
				url : "${pageContext.request.contextPath}/cooperationChangeApply/checkCooperationChangeApply.shtml",
				type : 'POST',
				dataType : 'json',
				cache : false,
				async : false,
				data : param,
				timeout : 30000,
				success : function(data) {
					if ("0000" == data.returnCode) {
						commUtil.alertSuccess("确认成功");
						setTimeout(function(){
							parent.location.reload();
							frameElement.dialog.close();
						},1000);
					}else{
						$.ligerDialog.error(data.returnMsg);
					}
				},
				error : function() {
					$.ligerDialog.error('操作超时，请稍后再试！');
				}
			});
		});
});
function viewerPic(imgPath){
	$("#viewer-pictures").empty();
	viewerPictures.destroy();
		$("#viewer-pictures").append('<li><img data-original="'+imgPath+'" src="'+imgPath+'" alt=""></li>');
		viewerPictures=new Viewer(document.getElementById('viewer-pictures'), {hide:function(){
		$("#viewer-pictures").hide();
	}});
	viewerPictures.show();
}
</script>
<html>
<body>
<form method="post" id="form" name="form" action="${pageContext.request.contextPath}/cooperationChangeApply/checkCooperationChangeApply.shtml">
			<input type="hidden" id="id" name="id" value="${id}">
			<table class="gridtable">
           	<tr>
               <td class="title" style="width: 25%;">审核结果</td>
               <td colspan="2" align="left" class="l-table-edit-td">
               		<span style="margin-left: 10PX;">
	               		<label><input type="radio" name="status" value="1" />通过</label>
               		</span>
               		<span style="margin-left: 20PX;">
	               		<label><input type="radio" name="status" value="2" checked="checked"/>驳回</label>
               		</span>
               </td>
			</tr>
				<tr>
					<td class="title" style="width:25%">变更函</td>
					<td colspan="2" align="left" class="1-table-edit-td">
						<c:forEach var="cooperationChangeUploadPic" items="${cooperationChangeUploadPics}" varStatus="varStatus">
							<input id="cooperationChangeUploadPics" name="cooperationChangeUploadPics" type="hidden" value="">
							<li id="cooperationChnageUploadPic_li_${varStatus.index}" class="pic_li" draggable="true" ondragstart="drag(event);" pic_path="${cooperationChnageUploadPic.pic}">
								<c:if test="${fn:contains(cooperationChangeUploadPic.pic,'http' )==true}">
									<img  src="${cooperationChangeUploadPic.pic}" style="height: 80px;width: 80px" class="pic">
								</c:if>
								<c:if test="${fn:contains(cooperationChangeUploadPic.pic,'http' )==false}">
									<img  src="${pageContext.request.contextPath}/file_servelt${cooperationChangeUploadPic.pic}" alt="" style="height: 80px;width: 80px" class="pic">
								</c:if>
							</li>

						</c:forEach>
					</td>
				</tr>
			<tr id="processInnerRemarksTr" style="display: none;" >
            	<td class="title">内部备注</td>
				<td align="left" class="l-table-edit-td" >
					<textarea name="processInnerRemarks" id="processInnerRemarks" style="width:100%;height:300px;visibility:hidden;"></textarea>
 				</td>
           	</tr>
           	<tr id="rejectReasonTr">
               <td class="title" style="height: 200px">驳回原因</td>
               <td colspan="3" align="left" class="l-table-edit-td">
               		<textarea id="remarks" name="remarks" rows="5" class="textarea" cols="50" style="width:100%;height:300px"></textarea>
               </td>
			</tr>
			
	        <tr>
               <td class="title">操作</td>
               <td colspan="2" align="left" class="l-table-edit-td">
					<div id="btnDiv">
						<input id="confirm" type="button" style="float:left;" class="l-button l-button-submit" value="提交"/>
					</div>
				</td>
	        </tr>
	        </table>
</form>	  
<ul class="docs-pictures clearfix td-pictures" id="viewer-pictures" style="display: none;"></ul>   
</body>
</html>
