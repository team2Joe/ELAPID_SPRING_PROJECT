<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@ include file="layout/header.jsp"%>

	<!-- content에 자신의 OAuth2.0 클라이언트ID를 넣습니다. -->



	<div class="row" style="height: 700px">
		<div class="col-lg-7">
			<img alt="loginForm" src="resources/elapid_img/loginform.jpeg" width="100%"
				height="100%">
		</div>
		<div class="col-lg-5">
			<form action="loginCheck" method="post">
				<div class="row"
					style="text-align: center; padding-top: 100px; padding-bottom: 100px">
					<h1>sign in</h1>
				</div>
				<div class="mb-3 row" style="text-algin: center;">
					<label style="width: 40%; height: 40px; text-align: right"
						for="inputPassword" class="col-sm-2 col-form-label">아이디 :
					</label>
					<div class="col-sm-3">
						<input type="text" name="uid" class="form-control" id="inputId"
							onkeyup="idformcheck()">
					</div>

				</div>
				<div class="mb-3 row">
					<label style="width: 40%; height: 40px; text-align: right"
						for="inputPassword" class="col-sm-2 col-form-label">비밀번호 :
					</label>
					<div class="col-sm-3">
						<input type="password" name="upassword" class="form-control"
							id="inputPassword">
					</div>
				</div>
				<div class="col-sm-6"
					style="width: 100%; height: 40px; text-align: center; padding-top: 50px">
					<input style="width: 20%; height: 40px; text-align: center;"
						type="submit" class="btn btn-dark" value="sign in">
				</div>
				<div class="col-sm-6"
					style="width: 100%; height: 40px; text-align: center; padding-top: 60px">
					<button style="width: 20%; height: 40px; text-align: center;"
						type="button" class="btn btn-dark"
						onclick="location.href='registerForm'">sign up</button>
					<br>
					

					

				</div>
				<div class="col-sm-6"
					style="width: 200%; height: 40px; text-align: center; padding: 100px 0px 0px 280px">
					<div class="g-signin2" style="width:250px" data-onsuccess="onSignIn"></div></div>


			</form>
		</div>
			<form action="googleLogin" id="gform" method='post'>
				<input type="hidden" name="gname" id="gname" value="1"> <input
					type="hidden" name="gemail" id="gemail" value="1"> <input
					type="hidden" name="gimg" id="gimg" value="1">
			</form>
	</div>



	<%@ include file="layout/footer.jsp"%>