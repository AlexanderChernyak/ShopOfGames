<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Магазин - Вопросы и ответы</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<!-- templatemo 341 web store -->
<!-- 
Web Store Template 
http://www.templatemo.com/preview/templatemo_341_web_store 
-->
<link href="${pageContext.request.contextPath}/resources/css/templatemo_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/ddsmoothmenu.css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ddsmoothmenu.js">

/***********************************************
* Smooth Navigational Menu- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/

</script>

<script type="text/javascript">

ddsmoothmenu.init({
	mainmenuid: "templatemo_menu", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})

function clearText(field)
{
    if (field.defaultValue == field.value) field.value = '';
    else if (field.value == '') field.value = field.defaultValue;
}
</script>

</head>

<body id="subpage">

<div id="templatemo_wrapper">
	<div id="templatemo_header">
    	<div id="site_title">
        	<h1><a href="http://vk.com/mr.black_g">Александр Черняк</a></h1>
        </div>
        
        <div id="header_right">
        <a href="registration">Регистрация</a>
        <div class="cleaner"></div>
        <a href="enter">Вход</a>
            <div class="cleaner"></div>
            <div id="templatemo_search">
					<form name='search' action="${pageContext.request.contextPath}/search/search_results/1" method='GET' role="form">
						<input type="text" value="Поиск" name='name' id="keyword"
							title="keyword" onfocus="clearText(this)"
							onblur="clearText(this)" class="txt_field" /> <input
							type="submit" name="submit" value="" alt="Search"
							id="searchbutton" title="Search" class="sub_btn" />
					</form>
				</div>
         </div> <!-- END -->
    </div> <!-- END of header -->
    
    <div id="templatemo_menu" class="ddsmoothmenu">
        <ul>
            <li><a href="${pageContext.request.contextPath}/index">Главная</a></li>
            <li><a href="${pageContext.request.contextPath}/products">Продукты</a></li>
            <li><a href="${pageContext.request.contextPath}/about_us">О нас</a></li>
            <li><a href="${pageContext.request.contextPath}/faqs" class="selected">Вопросы и ответы</a></li>
            <li><a href="${pageContext.request.contextPath}/contact">Контакты</a></li>
            <%
					if (session.getAttribute("authorized") != null
							&& session.getAttribute("authorized").equals("user")) {
				%>
				<li><a href="${pageContext.request.contextPath}/shoppingcart">Корзина</a></li>
				<%} %>
        </ul>
        <br style="clear: left" />
    </div> <!-- end of templatemo_menu -->
    
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
        </div> <!-- END of sidebar -->
        
        <div id="content" class="faq">
        	<h2>Вопросы и ответы</h2>
            <h3>Чем подтверждается качество вашей продукции?</h3>
            <p>Качество нашей продукции подтверждается сертификатом качества РБ,  а также сертификатом качества страны производителя.</p>
            
            <h3>Могу ли я вернуть бракованный товар?</h3>
            <p>Можете, если у вас сохранился чек об оплате продукции и на продукте нет механических повреждений.</p>
            
            <h3>Какие платежные способы вы поддерживаете?</h3>
            <p>Оплата нашего товара производится на почте при получении посылки. Либо наличными в офисах продаж. В разработке оплата при помощи WebMoney.</p>
            
            <h3>Где находится Ваш офис?</h3>
            <p>Наши контакты указаны во вкладке <a href="contact.html">Контакты</a>.</p>
            
            <h3>Как оформить заказ?</h3>
            <p>Оформить заказ очень просто! Достаточно несколько "кликов". Схема действий следующая:

			Сначала надо положить понравившиеся товары в корзину. Для этого достаточно нажать на кнопку "Добавить в корзину" рядом с выбранными Вами товарами.

			После того, как Вы положили в корзину все, что Вас заинтересовало, надо перейти на страницу "Корзина". Для этого достаточно нажать на кнопку "Корзина". Она есть на каждой странице сайта в правом верхнем углу.

			В корзине надо нажать кнопку "Оформить заказ" и перейти к стадии оформления заказа.

			Процедура оформления заказа представляет собой несколько шагов, в ходе которых Вам будет предложено ввести адрес, на который заказ будет доставлен, способ доставки и форму оплаты. Не забывайте о последнем шаге оформления, нажать: "Подтвердить и оформить заказ".

			После этого заказ поступит к нам, мы его соберем и доставим Вам.</p>
			            
        </div> <!-- END of content -->
        <div class="cleaner"></div>
    </div> <!-- END of main -->
    
        
    <div id="templatemo_footer">
        <div class="cleaner h40"></div>
		<center>
			Copyright © 2015 Alex & Co Все права защищены!
		</center>
    </div> <!-- END of footer -->   
   
</div>

</body>
</html>