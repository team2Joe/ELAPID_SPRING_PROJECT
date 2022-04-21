<%@ include file="layout/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<h2 align="center">상품 등록</h2>
	<br>
	<div align="center">
		<form action="registerProduct" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td align="right">상품명: </td>
					<td><input type="text" name="p_name"></td>
				</tr>
				<tr>
					<td align="right">제품수량: </td>
					<td><input type="text" name="p_stock"></td>
				</tr>
				<tr>
					<td align="right">제품가격(정가): </td>
					<td><input type="text" name="p_price"></td>
				</tr>
				<tr>
					<td align="right">사이즈: </td>
					<td><input type="text" name="p_size">(55, 66, 77)</td>
				</tr>
				<tr>
					<td align="right">제품색상: </td>
					<td><input type="text" name="ps_color"></td>
				</tr>
				
				<tr>
					<td align="right">소재: </td>
					<td><input type="text" name="ps_material"></td>
				</tr>
				<tr>
					<td align="right">사이즈: </td>
					<td><input type="text" name="ps_size">(55, 66, 77)</td>
				</tr>
				<tr>
					<td align="right">높이: </td>
					<td><input type="text" name="ps_height"></td>
				</tr>
				<tr>
					<td align="right">깊이: </td>
					<td><input type="text" name="ps_depth"></td>
				</tr>
				<tr>
					<td align="right">너비: </td>
					<td><input type="text" name="ps_width"></td>
				</tr>
				<tr>
					<td align="right">용량: </td>
					<td><input type="text" name="ps_volume"></td>
				</tr>
				<tr>
					<td align="right">무게: </td>
					<td><input type="text" name="ps_weight"></td>
				</tr>
				<tr>
					<td align="right">주요기능: </td>
					<td><input type="text" name="p_mainf">(서스펜션휠, 자동제어장치, 지문인식, rfid)</td>
				</tr>
				<tr>
					<td align="right">제품분류(main): </td>
					<td><input type="text" name="ctg_main">(Luggage, Backpack)</td>
				</tr>
				<tr>
					<td align="right">제품분류(middle): </td>
					<td><input type="text" name="ctg_middle">(Small, Middle, Large)</td>
				</tr>
				<tr>
					<td align="right">제품분류(sub): </td>
					<td><input type="text" name="ctg_sub"></td>
				</tr>
				<tr>
					<td align="right">제품섬네일이미지: </td>
					<td><input type="file" name="img_thum"></td>
				</tr>
				<tr>
					<td align="right">제품사진01: </td>
					<td><input type="file" name="img_01"></td>
				</tr>
				<tr>
					<td align="right">제품사진02: </td>
					<td><input type="file" name="img_02"></td>
				</tr>
				<tr>
					<td align="right">제품사진03: </td>
					<td><input type="file" name="img_03"></td>
				</tr>
				<tr>
					<td align="right">제품사진04: </td>
					<td><input type="file" name="img_04"></td>
				</tr>
				<tr>
					<td align="right">제품사진05: </td>
					<td><input type="file" name="img_05"></td>
				</tr>
				<tr>
					<td align="right">제품사진06: </td>
					<td><input type="file" name="img_06"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" onclick="registProductCheck()" value="제품등록"></td>
				</tr>
			</table>
		</form>
	</div>











<%@ include file="layout/footer.jsp"%>	

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<script src="resources/js/basic.js"></script>
	<script src="resources/js/login.js"></script>