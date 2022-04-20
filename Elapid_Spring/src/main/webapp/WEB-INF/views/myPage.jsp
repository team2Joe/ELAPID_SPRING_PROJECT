<%@ include file="layout/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>//common/scripts.isml</script>
<script defer type="text/javascript"
	src="resources/js/samso/main.js"></script>
<meta charset="UTF-8" />

<meta http-equiv="x-ua-compatible" content="ie=edge" />
<meta name="viewport"
	content="width=device-width, minimum-scale=1.0, maximum-scale=1.0" />
<title>My Account </title>

<link rel="preload" href="resources/css/samso/global.css" as="style" />
<link rel="stylesheet" href="resources/css/samso/global.css" />
<link rel="preload" href="resources/css/samso/account/dashboard.css" as="style" />
<link rel="stylesheet" href="resources/css/samso/account/dashboard.css" />
<link rel="preconnect" href="https://www.googletagmanager.com">
<link rel="icon" type="image/png" href="https://www.samsonite.co.kr/on/demandware.static/Sites-MonoSamsoniteKR-Site/-/default/dw62e44eb6/images/favicons/favicon-196x196.png" sizes="196x196" />
<link rel="icon" type="image/png" href="https://www.samsonite.co.kr/on/demandware.static/Sites-MonoSamsoniteKR-Site/-/default/dw90e8707c/images/favicons/favicon-96x96.png" sizes="96x96" />
<link rel="icon" type="image/png" href="https://www.samsonite.co.kr/on/demandware.static/Sites-MonoSamsoniteKR-Site/-/default/dw320de43b/images/favicons/favicon-32x32.png" sizes="32x32" />
<link rel="icon" type="image/png" href="https://www.samsonite.co.kr/on/demandware.static/Sites-MonoSamsoniteKR-Site/-/default/dw6a06a6e7/images/favicons/favicon-16x16.png" sizes="16x16" />
<link rel="icon" type="image/png" href="https://www.samsonite.co.kr/on/demandware.static/Sites-MonoSamsoniteKR-Site/-/default/dw2aa3899b/images/favicons/favicon-128.png" sizes="128x128" />
<script async
	src="https://www.googletagmanager.com/gtag/js?id=UA-72704116-2"></script>
<script>
	window.dataLayer = window.dataLayer || [];
	window.gtmObject = window.gtmObject ? window.gtmObject : {
		"currencyCode" : "KRW"
	};
	function gtag() {
		dataLayer.push(arguments);
	}
	gtag('js', new Date());
	gtag('config', 'UA-72704116-2', {
		"send_page_view" : false,
		"currency" : "KRW"
	});
	gtag('config', 'AW-925417941');
</script>
<script>
	(function(w, d, s, l, i) {
		w[l] = w[l] || [];
		w[l].push({
			'gtm.start' : new Date().getTime(),
			event : 'gtm.js'
		});
		var f = d.getElementsByTagName(s)[0], j = d.createElement(s), dl = l != 'dataLayer' ? '&l='
				+ l
				: '';
		j.async = true;
		j.src = 'https://www.googletagmanager.com/gtm.js?id=' + i + dl;
		f.parentNode.insertBefore(j, f);
	})(window, document, 'script', 'dataLayer', 'GTM-MQN3KMD');
</script>

<script type="text/javascript">
	/* <![CDATA[ (head-active_data.js) */
	var dw = (window.dw || {});
	dw.ac = {
		_analytics : null,
		_events : [],
		_category : "",
		_searchData : "",
		_anact : "",
		_anact_nohit_tag : "",
		_analytics_enabled : "true",
		_timeZone : "Asia/Seoul",
		_capture : function(configs) {
			if (Object.prototype.toString.call(configs) === "[object Array]") {
				configs.forEach(captureObject);
				return;
			}
			dw.ac._events.push(configs);
		},
		capture : function() {
			dw.ac._capture(arguments);
			// send to CQ as well:
			if (window.CQuotient) {
				window.CQuotient.trackEventsFromAC(arguments);
			}
		},
		EV_PRD_SEARCHHIT : "searchhit",
		EV_PRD_DETAIL : "detail",
		EV_PRD_RECOMMENDATION : "recommendation",
		EV_PRD_SETPRODUCT : "setproduct",
		applyContext : function(context) {
			if (typeof context === "object"
					&& context.hasOwnProperty("category")) {
				dw.ac._category = context.category;
			}
			if (typeof context === "object"
					&& context.hasOwnProperty("searchData")) {
				dw.ac._searchData = context.searchData;
			}
		},
		setDWAnalytics : function(analytics) {
			dw.ac._analytics = analytics;
		},
		eventsIsEmpty : function() {
			return 0 == dw.ac._events.length;
		}
	};
	/* ]]> */
// -->
</script>
<script type="text/javascript">
	/* <![CDATA[ (head-cquotient.js) */
	var CQuotient = window.CQuotient = {};
	CQuotient.clientId = 'aawq-MonoSamsoniteKR';
	CQuotient.realm = 'AAWQ';
	CQuotient.siteId = 'MonoSamsoniteKR';
	CQuotient.instanceType = 'prd';
	CQuotient.locale = 'ko_KR';
	CQuotient.fbPixelId = '__UNKNOWN__';
	CQuotient.activities = [];
	CQuotient.cqcid = '';
	CQuotient.cquid = '';
	CQuotient.cqeid = '';
	CQuotient.cqlid = '';
	/* Turn this on to test against Staging Einstein */
	/* CQuotient.useTest= true; */
	CQuotient.initFromCookies = function() {
		var ca = document.cookie.split(';');
		for (var i = 0; i < ca.length; i++) {
			var c = ca[i];
			while (c.charAt(0) == ' ')
				c = c.substring(1, c.length);
			if (c.indexOf('cqcid=') == 0) {
				CQuotient.cqcid = c.substring('cqcid='.length, c.length);
			} else if (c.indexOf('cquid=') == 0) {
				var value = c.substring('cquid='.length, c.length);
				if (value) {
					var split_value = value.split("|", 3);
					if (split_value.length > 0) {
						CQuotient.cquid = split_value[0];
					}
					if (split_value.length > 1) {
						CQuotient.cqeid = split_value[1];
					}
					if (split_value.length > 2) {
						CQuotient.cqlid = split_value[2];
					}
				}
			}
		}
	}
	CQuotient.getCQCookieId = function() {
		if (window.CQuotient.cqcid == '')
			window.CQuotient.initFromCookies();
		return window.CQuotient.cqcid;
	};
	CQuotient.getCQUserId = function() {
		if (window.CQuotient.cquid == '')
			window.CQuotient.initFromCookies();
		return window.CQuotient.cquid;
	};
	CQuotient.getCQHashedEmail = function() {
		if (window.CQuotient.cqeid == '')
			window.CQuotient.initFromCookies();
		return window.CQuotient.cqeid;
	};
	CQuotient.getCQHashedLogin = function() {
		if (window.CQuotient.cqlid == '')
			window.CQuotient.initFromCookies();
		return window.CQuotient.cqlid;
	};
	CQuotient.trackEventsFromAC = function(/* Object or Array */events) {
		try {
			if (Object.prototype.toString.call(events) === "[object Array]") {
				events.forEach(_trackASingleCQEvent);
			} else {
				CQuotient._trackASingleCQEvent(events);
			}
		} catch (err) {
		}
	};
	CQuotient._trackASingleCQEvent = function( /* Object */event) {
		if (event && event.id) {
			if (event.type === dw.ac.EV_PRD_DETAIL) {
				CQuotient.trackViewProduct({
					id : '',
					alt_id : event.id,
					type : 'raw_sku'
				});
			} // not handling the other dw.ac.* events currently
		}
	};
	CQuotient.trackViewProduct = function(/* Object */cqParamData) {
		var cq_params = {};
		cq_params.cookieId = CQuotient.getCQCookieId();
		cq_params.userId = CQuotient.getCQUserId();
		cq_params.emailId = CQuotient.getCQHashedEmail();
		cq_params.loginId = CQuotient.getCQHashedLogin();
		cq_params.product = cqParamData.product;
		cq_params.realm = cqParamData.realm;
		cq_params.siteId = cqParamData.siteId;
		cq_params.instanceType = cqParamData.instanceType;
		cq_params.locale = CQuotient.locale;
		if (CQuotient.sendActivity) {
			CQuotient
					.sendActivity(CQuotient.clientId, 'viewProduct', cq_params);
		} else {
			CQuotient.activities.push({
				activityType : 'viewProduct',
				parameters : cq_params
			});
		}
	};
	/* ]]> */
// -->
	
</script>

	
	<!-------------------------- END HEADER ---------------------------->
	<!-------------------------- END HEADER ---------------------------->
	<!-------------------------- END HEADER ---------------------------->
	
	<noscript>
		<iframe src="https://www.googletagmanager.com/ns.html?id=GTM-MQN3KMD"
			height="0" width="0" style="display: none; visibility: hidden"></iframe>
	</noscript>
	<div class="page" data-action="Account-Show" data-activelocale="ko_KR"
		data-querystring="">
		<div > 
			<div class="title-contain col-11" style="text-align:center; padding-top :100px;padding-bottom :50px;">
				<h1 >${profiledto.u_name }님 정보</h1>
				<ul class="profile-level">
					<li><span> 회원등급 </span></li>
					<li><span> ${profiledto.u_grade } </span></li>
				</ul>
			</div>
		</div>
		<div class="container account-page">
			<div class="justify-content-center account-cards">
				<div class="row order-card">
					<div class="col-3 col-md-2 image-card">
						<a href="userOrderHistory"><i class="wishlist-icon fa-solid fa-basket-shopping"></i>
						</a>
					</div>
					<div class="text-card col-7 col-md-8">
						<a href="userOrderHistory">
							<h4>나의 구매내역</h4>
						</a>
					</div>
					<div class="arrowed col-2 col-md-2" style="padding-top:15px">
						<a href="userOrderHistory">
							<div class="arrow-1"></div>
						</a>
					</div>
				</div>
				<div class="row profile-card">
					<div class="col-3 col-md-2 image-card">
						<a href="profileView"> <i class="wishlist-icon fa-solid fa-id-badge"></i>
						</a>
					</div>
					<div class="text-card col-7 col-md-8">
						<a href="profileView">
							<h4>내 프로필 보기</h4>
						</a>
					</div>
					<div class="arrowed col-2 col-md-2" style="padding-top:15px">
						<a href="profileView">
							<div class="arrow-1"></div>
						</a>
					</div>
				</div>
				<div class=" row address-book-card">
					<div class="col-3 col-md-2 image-card">
						<a href="addressBookView"> <i class="wishlist-icon fa-solid fa-map-location"></i>
						</a>
					</div>
					<div class="text-card col-7 col-md-8">
						<a href="addressBookView">
							<h4>주소록</h4>
						</a>
					</div>
					<div class="arrowed col-2 col-md-2" style="padding-top:15px">
						<a href="addressBookView">
							<div class="arrow-1"></div>
						</a>
					</div>
				</div>
				<div class="row payment-card">
					<div class="col-3 col-md-2 image-card">
						<a href="/accountcoupon"><i class="wishlist-icon fa-solid fa-money-bill-1-wave"></i>
						</a>
					</div>
					<div class="text-card col-7 col-md-8">
						<a href="/accountcoupon">
							<h4>쿠폰 현황</h4>
						</a>
					</div>
					<div class="arrowed col-2 col-md-2" style="padding-top:15px">
						<a href="/orders">
							<div class="arrow-1"></div>
						</a>
					</div>
				</div>
				<div class="content-asset">
					<div class="row payment-card">
						<div class="col-3 col-md-2 image-card">
							<a href="/accountpoint"> <i class="wishlist-icon fa-solid fa-coins"></i>
							</a>
						</div>
						<div class="text-card col-7 col-md-8">
							<a href="/accountpoint">
								<h4>내 포인트</h4>
							</a>
						</div>
						<div class="arrowed col-2 col-md-2" style="padding-top:15px">
							<a href="/orders">
								<div class="arrow-1"></div>
							</a>
						</div>
					</div>

					<div class="row my-qa-card">
						<div class="col-3 col-md-2 image-card">
							<a href="questionList"> 
								<i class="wishlist-icon fa-solid fa-circle-question"></i>
							</a>
						</div>
						<div class="text-card col-7 col-md-8">
							<a href="questionList">
								<h4>1:1문의</h4>
							</a>
						</div>
						<div class="arrowed col-2 col-md-2" style="padding-top:15px">
							<a href="questionList">
								<div class="arrow-1"></div>
							</a>
						</div>
					</div>

					<div class="row wishlist-account-card">
						<div class="col-3 col-md-2 image-card">
							<a
								href="https://www.samsonite.co.kr/on/demandware.store/Sites-MonoSamsoniteKR-Site/ko_KR/Wishlist-Show">
								<i class="wishlist-icon fa fa-heart-o"></i>
							</a>
						</div>
						<div class="text-card col-7 col-md-8">
							<a
								href="https://www.samsonite.co.kr/on/demandware.store/Sites-MonoSamsoniteKR-Site/ko_KR/Wishlist-Show">
								<h4>위시리스트</h4>
							</a>
						</div>
						<div class="arrowed col-2 col-md-2" style="padding-top:15px">
						<a href="/orders">
							<div class="arrow-1"></div>
						</a>
						</div>
					</div>
				</div>
			</div>
	`	</div>
	</div>
		
	<div class="error-messaging"></div>
	<div class="modal-background"></div>
  <div class="footer">
		ELAPID's Work copyright。
  </div>	
  
	<script src="https://kit.fontawesome.com/e181140022.js" crossorigin="anonymous"></script>
	<script type="text/javascript" src="js/samso/dwanalytics-22.2.js"
		async="async" onload="trackPage()"></script>

	<script src="resources/js/samso/dwac-21.7.js" type="text/javascript"
		async="async"></script>
	<script src="https://cdn.cquotient.com/js/v2/gretel.min.js"
		type="text/javascript" async="async"></script>
	<script src="resources/js/basic.js"></script>
	
</body>
</html>