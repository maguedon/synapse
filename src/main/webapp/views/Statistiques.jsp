<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Synapse Gaming | Statistiques</title>
    <!-- Meta -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- CSS -->
    <link rel="shortcut icon" type="image/x-icon" href="<c:url value="/resources/img/favicon.ico" />"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/common.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/header.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/menu.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/news.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/slider.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/blogs.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/footer.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/statistiques.css" />">
    <!-- JS -->
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-2.0.3.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/menu.js" />"></script>
</head>
<body>
<div id="page-wrapper">
	<div id="header-wrapper">
		<jsp:include page="portal/Header.jsp"/>
	</div>
	<div id="persistent-menu-wrapper">
		<jsp:include page="portal/PersistentMenu.jsp"/>
	</div>
	<div id="menu-wrapper">
		<jsp:include page="portal/Menu.jsp"/>
	</div>
	<div id="news-wrapper">
		<jsp:include page="portal/News.jsp"/>
	</div>
	<div id="stat-wrapper">
		<div id="stat-container">
			<div id="stat">
				<h3>Top 5 des classes les plus utilisées</h3>
				<div>
					<c:forEach items="${fiveClassesMostPlayed}" var="clazz">
							<div>${clazz.name} (${clazz.nbUsers})</div>
					</c:forEach>
				</div>
				
				<h3>Top 5 des races les plus utilisées</h3>
				<div>
					<c:forEach items="${fiveRacesMostPlayed}" var="race">
							<div>${race.name} (${race.nbUsers})</div>
					</c:forEach>
				</div>
				
				<h3>Top 5 des spécialisations les plus utilisées</h3>
				<div>
					<c:forEach items="${fiveSpecMostPlayed}" var="spec">
							<div>${spec.name} (${spec.nbUsers})</div>
					</c:forEach>
				</div>
				
				<h3>Top 5 des utilisateurs les plus actifs</h3>
				<div>
					<c:forEach items="${fiveUsersMostActive}" var="user">
							<div>${user.name} (${user.nbReplies})</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<div id="footer-wrapper">
		<jsp:include page="portal/Footer.jsp"/>
	</div>
</div>
</body>
</html>