<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>页面查询</title>
<script type="text/javascript" src="js/jquery1.42.min.js"></script>
</head>
<body>
<script type="text/javascript">
	$(function(){
		var xiaolei = [["幼儿园/学前教育","学科教学","教师成长","课堂教学/课堂管理","教育经典名著","班主任用书","学校管理","心理健康"],["课外阅读","新课标","古诗词/文言文"],["志愿填报","高考作文","美术/音乐/广播","高考辅导","高校自主招生","高考模拟试题","对口升学"],["一般管理学","市场/营销  金融/投资","电子商务","会计","创业企业与企业家","生产与运作管理","管理信息系统","商务沟通"],["科普/百科","中国儿童文学","图画书","外国儿童文学","幼儿启蒙"],["外语考试","公务员考试","计算机考试","自学考试","成人高考","考研"],["中国当代小说","外国小说  社会","情感","世界名著","历史","科幻","作品集","青春文学"],["杂志/期刊"]];
		$("#btype1").change(function(){
			$("#btype2").empty();
			for(var i = 0;i < xiaolei[$(this).val()-1].length;i++){
				$("#btype2").append($("<option>").html(xiaolei[$(this).val() - 1][i]));
			}
		})
		
		$("#btype1").change();
		
		
		$("#save").click(function(){
			window.location = "ProductMsgServlet?method=save";
		})
		
		$("#import").click(function(){
			
		})
		
		$("#export").click(function(){
			
		})
		
		$("#remove_bat").click(function(){
			
		})
		
		
		
	})
</script>
	<form action="productMsgServlet" method="post">
		<table border='1' cellpadding="0" cellspacing="0" >
			<tr bgcolor="blue"><td colspan="8">商品基本信息查询</td></tr>
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="bookname"/></td>
				<td>商品价格</td>
				<td><input type="text" name="bookprice" /></td>
				<td>适合学科</td>
				<td>
					<select>
						<option value="0">--请选择--</option>
						<option value="1">语文</option>
						<option value="2">数学</option>
						<option value="3">英语</option>
						<option value="4">历史</option>
						<option value="5">其他</option>
						<option value="6">自然</option>
						<option value="7">思想品德</option>
						<option value="8">美术</option>
						<option value="9">地理</option>
						<option value="10">音乐</option>
					</select>
				</td>
				<td>适合年级</td>
				<td>
					<select>
						<option value="0">--请选择--</option>
						<option value="1">一年级</option>
						<option value="2">二年级</option>
						<option value="3">三年级</option>
						<option value="4">四年级</option>
						<option value="5">五年级</option>
						<option value="6">六年级</option>
						<option value="7">初一</option>
						<option value="8">初二</option>
						<option value="9">初三</option>
						<option value="10">高一</option>
						<option value="11">高二</option>
						<option value="12">高三</option>
						<option value="13">小学</option>
						<option value="14">初中</option>
						<option value="15">高中</option>
						<option value="16">不限</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>作者</td>
				<td><input type="text" name="author"/></td>
				<td>出版社</td>
				<td><input type="text" name="chubanshe"/></td>
				<td>条形码</td>
				<td><input type="text" name="isbn"/></td>
				<td>出版时间</td>
				<td><td>
			</tr>
			<tr>
				<td>商品类型</td>
				<td>
					<select id='btype1'>
						<option value="0">选择大类</option>
						<option value="1">教育理论/教师用书</option>
						<option value="2">中小学阅读</option>
						<option value="3">高考</option>
						<option value="4">管理</option>
						<option value="5">童书</option>
						<option value="6">考试</option>
						<option value="7">小说</option>
						<option value="8">杂志期刊</option>
					</select>
					<select id='btype2'>
 						<option value="0">选择小类</option> 
					</select>
				</td>
			</tr>
			<tr>
				<td align="right">
					<input type="submit" value="查询" />
					<input type="button" value="添加" id="save"/>
					<input type="button" value="导入" id="import"/>
					<input type="button" value="导出" id="export"/>
					<input type="button" value="批量删除" id="remove_bat"/>
				</td>
			</tr>
		</table>
	</form>
	
	
	<table>
		<tr>
			<td><input type="checkbox" id="allcheck"/>全选</td>
			<td>商品编号</td>
			<td>商品名称</td>
			<td>订阅期限</td>
			<td>商品价格</td>
			<td>商品折扣</td>
			<td>审核状态</td>
			<td>适合学科</td>
			<td>适合年级</td>
			<td>作者</td>
			<td>出版社</td>
			<td>出版时间</td>
			<td>条形码</td>
			<td>积分抵用数</td>
			<td>操作</td>
		</tr>
		<c:forEach var="bookinfo" items="${bookinfos}">
		<tr>
			<td><input type="checkbox" /></td>
			<td>${bookinfo.bookid}</td>
			<td>${bookinfo.bookname}</td>
			<td>${bookinfo.qixian}</td>
			<td>${bookinfo.bookprice}</td>
			<td>${bookinfo.discount}</td>
			<td>${bookinfo.state}</td>
			<td>${bookinfo.shihezhuanye}</td>
			<td>${bookinfo.shihenianji}</td>
			<td>${bookinfo.auth}</td>
			<td>${bookinfo.chubanshe}</td>
			<td>${bookinfo.shijian}</td>
			<td>${bookinfo.isbn}</td>
			<td>${bookinfo.jifen}</td>
			<td>
<script type="text/javascript">
	$(function(){
		$("#edit").click(function(){
			window.location = "";
			
		})
		
		$("#view").click(function(){
			window.location = "";
			
		})
		
		
		
		$("#delete").click(function(){
			$(this).parent().remove();
			window.location = "ProductMsgServlet?&method=delete";
		})
		
	})
</script>
				<img src="images/edit.gif" id="edit"/>
				<img src="images/view.gif" id="view"/>
				<img src="images/delete.gif" id="delete"/>
			</td>
		</tr>
		</c:forEach>
		<tr></tr>
	</table>
</body>
</html>