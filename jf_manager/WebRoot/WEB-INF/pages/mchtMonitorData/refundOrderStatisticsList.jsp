<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@include file="/common/common-tag.jsp"%>

<html>
<head>
	<script type="text/javascript" src="${pageContext.request.contextPath}/common/js/utils/json2.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/common/js/listModel/toolBar.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/common/js/ligerLinkageComboBox.js"></script>
	<link href="${pageContext.request.contextPath}/css/search_form.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/css/viewer.min.css" rel="stylesheet" type="text/css" />
	<script src="${pageContext.request.contextPath}/js/viewer.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/common/js/dateUtil.js"></script>
 
 <script type="text/javascript">
	$(function(){

		$(".dateEditor").ligerDateEditor({
			showTime : false,
			labelWidth : 150,
			labelAlign : 'left'
		});

		// 禁止分页
		$("#maingrid").ligerGrid({
			usePager:false
		});

		//品牌
		$("#productBrandName").ligerComboBox({
			 width: 135,
			 slide: false,
			 selectBoxWidth: 450,
			 selectBoxHeight: 300,
			 valueField: 'id',
			 textField: 'name',
			 valueFieldID:'productBrandId',
			 grid: getGridOptions(false),
			 condition:{ fields: [{ name:'name', label:'品牌名', width:90, type:'text' } ]}
		 });
	});

	function getGridOptions(checkbox){
		var options = {
			columns: [
				{display:'ID',name:'id', align:'center', isSort:false, width:100},
				{display:'品牌',name:'name', align:'center', isSort:false, width:100}
			],
			switchPageSizeApplyComboBox: false,
			url: '${pageContext.request.contextPath}/activityNew/getProductBrandList.shtml',
			pageSize: 10,
			checkbox: checkbox
		};
		return options;
	}

	function customerServiceOrderList(mchtCode) {
		var createDateBegin = $("#createDateBegin").val();
		var createDateEnd = $("#createDateEnd").val();
		$.ligerDialog.open({
			height: $(window).height(),
			width: $(window).width()-50,
			title: "售后列表",
			name: "INSERT_WINDOW",
			url: "${pageContext.request.contextPath}/order/afterService/list.shtml?createDateBegin="+createDateBegin+"&createDateEnd="+createDateEnd+"&mchtCode="+mchtCode,
			showMax: true,
			showToggle: false,
			showMin: false,
			isResize: true,
			slide: false,
			data: null
		});
	}

	var listConfig={
		url:"/mchtMonitorData/refundOrderStatisticsList.shtml",
		btnItems:[],
		listGrid:{ columns: [
				{display:'商家序号',name:'mcht_code', align:'center', isSort:false, width:100},
				{display:'公司名称',name:'company_name', align:'center', isSort:false, width:200},
				{display:'店铺名称',name:'shop_name', align:'center', isSort:false, width:200},
				{display:'经营品牌',name:'product_brand_name_s', align:'center', isSort:false, width:200},
				{display:'退款商品数量',name:'quantity_sum_A', align:'center', isSort:false, width:100},
				{display:'退款金额',name:'amount_sum_A', align:'center', isSort:false, width:100},
				{display:'退货商品数量',name:'quantity_sum_B', align:'center', isSort:false, width:100},
				{display:'退货商品金额',name:'amount_sum_B', align:'center', isSort:false, width:100},
				{display:'操作',width:80, render: function (rowdata, rowindex) {
					var html = [];
					html.push("<a href='javascript:;' onclick='customerServiceOrderList(\""+rowdata.mcht_code+"\");'>【查看】</a>");
					return html.join("");
				}}
			],
			showCheckbox : false,  //不设置默认为 true
			showRownumber: true //不设置默认为 true
		} ,
		container:{
			toolBarName:"toptoolbar",
			searchBtnName:"searchbtn",
			fromName:"dataForm",
			listGridName:"maingrid"
		}
	};


  
</script>
</head>
<body style="padding: 0px; overflow: hidden;">
<!-- <div id="toptoolbar"></div> -->
	<form id="dataForm" runat="server">
		<div class="search-pannel">
			<div class="search-tr">
				<div class="search-td" style="width: 40%;">
					<div class="search-td-label" style="float: left;width: 20%;">退款日期：</div>
					<div class="l-panel-search-item" >
						<input type="text" id="createDateBegin" name="createDateBegin" value="${createDateBegin}" class="dateEditor" style="width: 135px;" />
					</div>
					<div class="l-panel-search-item" style="margin-left: 15px;margin-right: 15px;" >至</div>
					<div class="l-panel-search-item">
						<input type="text" id="createDateEnd" name="createDateEnd" value="${createDateEnd}" class="dateEditor" style="width: 135px;" />
					</div>
				</div>
				<div class="search-td">
					<div class="search-td-label">品牌：</div>
					<div class="search-td-combobox-condition" >
						<input type="text" id="productBrandName" name="productBrandName" />
					</div>
				</div>
				<div class="search-td">
					<div class="search-td-label">商家序号：</div>
					<div class="search-td-combobox-condition" >
						<input type="text" id="mchtCode" name="mchtCode" />
					</div>
				</div>
			</div>
			<div class="search-tr">
				<div class="search-td">
					<div class="search-td-label">店铺名称：</div>
					<div class="search-td-combobox-condition" >
						<input type="text" id="shopName" name="shopName" />
					</div>
				</div>
				<div class="search-td">
					<div class="search-td-label" style="color: red;">对接人：</div>
					<div class="search-td-condition">
						<select id="platContactStaffId" name="platContactStaffId" style="width: 135px;">
							<c:if test="${isManagement == 1}">
								<option value="" selected="selected">全部商家</option>
							</c:if>
							<option value="${staffID}" selected="selected" >我自己的商家</option>
							<c:forEach items="${sysStaffInfoCustomList}" var="sysStaffInfoCustom">
								<option value="${sysStaffInfoCustom.staffId}">${sysStaffInfoCustom.staffName}的商家</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="search-td">
					<div class="search-td-label" >类目：</div>
					<div class="search-td-condition">
						<select id="productTypeId" name="productTypeId" style="width: 135px;">
							<option value="">请选择...</option>
							<c:forEach items="${sysStaffProductTypeList}" var="sysStaffProductType">
								<option value="${sysStaffProductType.productTypeId }">${sysStaffProductType.staffName }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="search-td-search-btn" >
					<div id="searchbtn" >搜索</div>
				</div>
			</div>
		</div>

	</form>

	<div id="maingrid" style="margin: 0;"></div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/common/js/listModel/listModel.js"></script>
</html>