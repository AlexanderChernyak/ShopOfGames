<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Интернет-магазин - корзина</title>
<meta name="keywords" content="" />
<meta name="description" content="" />

<link
	href="${pageContext.request.contextPath}/resources/css/templatemo_style.css"
	rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/ddsmoothmenu.css" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/ddsmoothmenu.js">
	
</script>

<script type="text/javascript">
	ddsmoothmenu.init({
		mainmenuid : "templatemo_menu", //menu DIV id
		orientation : 'h', //Horizontal or vertical menu: Set to "h" or "v"
		classname : 'ddsmoothmenu', //class added to menu's outer DIV
		//customtheme: ["#1c5a80", "#18374a"],
		contentsource : "markup" //"markup" or ["container_id", "path_to_menu_file"]
	})
</script>

<script language="javascript" type="text/javascript">
	function clearText(field) {
		if (field.defaultValue == field.value)
			field.value = '';
		else if (field.value == '')
			field.value = field.defaultValue;
	}
</script>

</head>

<body id="subpage">

	<div id="templatemo_wrapper">
		<div id="templatemo_header">
			<div id="site_title">
				<h1>
					<a href="http://vk.com/mr.black_g">Александр Черняк</a>
				</h1>
			</div>

			<div id="header_right">
				<div class="cleaner"></div>
				<div id="templatemo_search">
					<form name='search'
						action="${pageContext.request.contextPath}/search/search_results/1"
						method='GET' role="form">
						<input type="text" value="Поиск" name='name' id="keyword"
							title="keyword" onfocus="clearText(this)"
							onblur="clearText(this)" class="txt_field" /> <input
							type="submit" name="submit" value="" alt="Search"
							id="searchbutton" title="Search" class="sub_btn" />
					</form>
				</div>
			</div>
			<!-- END -->
		</div>
		<!-- END of header -->

		<div id="templatemo_menu" class="ddsmoothmenu">
			<ul>
				<li><a href="${pageContext.request.contextPath}/index">Главная</a></li>
				<li><a href="${pageContext.request.contextPath}/products">Продукты</a></li>
				<li><a href="${pageContext.request.contextPath}/about_us">О
						нас</a></li>
				<li><a href="${pageContext.request.contextPath}/faqs">Вопросы
						и ответы</a></li>
				<li><a href="${pageContext.request.contextPath}/contact">Контакты</a></li>
				<li><a href="${pageContext.request.contextPath}/shoppingcart"
					class="selected">Корзина</a></li>
			</ul>
			<br style="clear: left" />
		</div>
		<!-- end of templatemo_menu -->

		<div class="cleaner h20"></div>
		<div id="templatemo_main_top"></div>
		<div id="templatemo_main">

			<div id="sidebar">
				<h3>Категории</h3>
				<ul class="sidebar_menu">

					<c:forEach items="${genres }" var="genre">
						<li><a href="${pageContext.request.contextPath}/gameaddaddd/show_genre/${genre.idGenre }">${genre.type }</a></li>
					</c:forEach>
				</ul>
				<div class="col col_16">
					<h4>Социальные сети</h4>
					<ul class="footer_menu">
						<li><a href="https://twitter.com/alex_chernyak5">Twitter</a></li>
						<li><a href="https://www.facebook.com/alexander.chernyak.9">Facebook</a></li>
						<li><a href="http://vk.com/mr.black_g">Vkontakte</a></li>
					</ul>
				</div>
			</div>
			<!-- END of sidebar -->

			<div id="content">

				<table width="700px" cellspacing="0" cellpadding="5">
					<tr bgcolor="#CCCCCC">
						<th width="220" align="left">Изображение</th>
						<th width="180" align="left">Название</th>
				
						<th width="60" align="right">Цена</th>
				
						<th width="90"></th>

					</tr>
					<c:set var="answer" value="0"></c:set>
					<c:forEach items="${baskets}" var="basket">
						<c:set var="answer" value="${answer+ basket.idGame.price}"></c:set>
						<tr>
							<td><img src="${basket.idGame.url }"
								alt="${basket.idGame.name}" /></td>
							<td>${basket.idGame.name}</td>
							<td align="right">$ ${basket.idGame.price }</td>
							<td align="center"><a href="${pageContext.request.contextPath}/gameaddaddd/delete_basket/${basket.idBasket}"><img
									src="${pageContext.request.contextPath}/resources/images/remove_x.gif"
									alt="remove" /><br />Удалить</a></td>
						</tr>
					</c:forEach>
					<tr>
			
						<td align="right" style="background: #ccc; font-weight: bold">Итого
						</td>
						<td align="right" style="background: #ccc; font-weight: bold"><c:out value="${answer }"></c:out>
						</td>
						<td style="background: #ccc; font-weight: bold"></td>
					</tr>
				</table>
				<div style="float: right; width: 215px; margin-top: 20px;">

					<!--  <div class="checkout">
						<a href="${pageContext.request.contextPath}/checkout" class="more">Подтвердить
							заказ</a>
					</div>-->
					<div class="cleaner h20"></div>
					<div class="continueshopping">
						<a href="${pageContext.request.contextPath}/products" class="more">Продолжить
							покупать</a>
					</div>

				</div>

			</div>
			<div class="cleaner"></div>
		</div>
		<!-- END of main -->


		<div id="templatemo_footer">
			<div class="cleaner h40"></div>
			<center>Copyright © 2015 Alex & Co Все права защищены!</center>
		</div>
		<!-- END of footer -->

	</div>

</body>
</html>