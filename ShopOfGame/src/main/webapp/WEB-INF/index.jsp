<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Интернет-магазин компьютерных игр</title>
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
		mainmenuid : "templatemo_menu",
		orientation : 'h',
		classname : 'ddsmoothmenu',
		contentsource : "markup"
	})
</script>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/styles.css" />
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/resources/scripts/mootools-1.2.1-core.js"></script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/resources/scripts/mootools-1.2-more.js"></script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/resources/scripts/slideitmoo-1.1.js"></script>
<script language="javascript" type="text/javascript">
	window.addEvents({
		'domready' : function() {
			new SlideItMoo({
				overallContainer : 'SlideItMoo_outer',
				elementScrolled : 'SlideItMoo_inner',
				thumbsContainer : 'SlideItMoo_items',
				itemsVisible : 5,
				elemsSlide : 2,
				duration : 200,
				itemsSelector : '.SlideItMoo_element',
				itemWidth : 171,
				showControls : 1
			});
		},

	});

	function clearText(field) {
		if (field.defaultValue == field.value)
			field.value = '';
		else if (field.value == '')
			field.value = field.defaultValue;
	}
</script>

</head>

<body id="home">

	<div id="templatemo_wrapper">
		<div id="templatemo_header">
			<div id="site_title">
				<h1>
					<a href="http://vk.com/mr.black_g">Александр Черняк</a>
				</h1>
			</div>

			<div id="header_right">
			
				<a href="registration">Регистрация</a>
				
				<div class="cleaner"></div>
				<%
					if (session.getAttribute("authorized") == null
							|| session.getAttribute("authorized").equals("false")) {
				%>
				<a href="enter">Вход</a>
				<%
					} else {
				%>
				<p>
					Здравствуйте,
					<%=session.getAttribute("nameUser")%>! <a href="${pageContext.request.contextPath}/logout">Выйти</a>
				</p>
				<%
					}
				%>
				<%
					if (session.getAttribute("authorized") != null
							&& session.getAttribute("authorized").equals("admin")) {
				%>
				<a href="${pageContext.request.contextPath}/admin">Админ</a>
				<%} %>
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
				<li><a href="${pageContext.request.contextPath}/index" class="selected">Главная</a></li>
				<li><a href="${pageContext.request.contextPath}/products">Продукты</a></li>
				<li><a href="${pageContext.request.contextPath}/about_us">О нас</a></li>
				<li><a href="${pageContext.request.contextPath}/faqs">Вопросы и ответы</a></li>
				<li><a href="${pageContext.request.contextPath}/contact">Контакты</a></li>
				<%
					if (session.getAttribute("authorized") != null
							&& session.getAttribute("authorized").equals("user")) {
				%>
				<li><a href="${pageContext.request.contextPath}/shoppingcart">Корзина</a></li>
				<%} %>
			</ul>
			<br style="clear: left" />
		</div>
		<!-- end of templatemo_menu -->

		<div id="templatemo_middle">
			<img
				src="${pageContext.request.contextPath}/resources/images/templatemo_image_01.png"
				alt="Image 01" />
			<h1>Вы попали в интернет-магазин компьютерных игр</h1>
			<a href="${pageContext.request.contextPath}/products" class="buy_now">Посмотреть игры</a>
		</div>
		<!-- END of middle -->

		<div class="cleaner h20"></div>
		<div id="templatemo_main_top"></div>
		<div id="templatemo_main">

			<div id="product_slider">

				<div id="SlideItMoo_outer">

					<div id="SlideItMoo_inner">

						<div id="SlideItMoo_items">
							<c:forEach items="${games}" var="game">
								<div class="SlideItMoo_element">
									<a
										href="${pageContext.request.contextPath}/gameaddaddd/productdetail/${game.idGame}">
										<img src="${game.url }" alt="${game.name}" />
									</a>
								</div>
							</c:forEach>
						</div>

					</div>

				</div>
				<div class="cleaner"></div>

			</div>

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
				<c:forEach items="${games}" var="game">
					<div class="col col_14 product_gallery">

						<a
							href="${pageContext.request.contextPath}/gameaddaddd/productdetail/${game.idGame}"><img
							src="${game.url }" alt="${game.name}" /></a>
						<h3>${game.name }</h3>
						<p class="product_price">$ ${game.price }</p>
						<%
					if (session.getAttribute("authorized") != null
							&& session.getAttribute("authorized").equals("user")) {
				%>
						<form
							action="${pageContext.request.contextPath}/gameaddaddd/add_to_cart"
							method="post">
							<input type="hidden" value="${game.idGame }" name="game" /> <input
								type="submit" value="Добавить в корзину" class="add_to_cart"/>
						</form>
						<%} %>
					</div>
				</c:forEach>
			</div>
			<!-- END of content -->
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