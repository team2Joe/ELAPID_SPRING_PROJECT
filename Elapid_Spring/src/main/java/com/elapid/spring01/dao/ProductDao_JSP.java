//package com.elapid.spring01.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//
//import javax.sql.DataSource;
//
//import com.elapid.spring01.dto.ProductListDto;
//
//public class ProductDao_JSP {
//
//	DataSource dataSource = null;
//	
//	// 백팩리스트 전체 출력
//	public ArrayList<ProductListDto> backpackList(int startPage, int onePageCount){
//		ArrayList<ProductListDto> dtos = new ArrayList<ProductListDto>();
//		
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		
//		try {
//			conn = dataSource.getConnection();
//			String query = "select *"
//					+ "from product_image i"
//					+ "join image_detail id"
//					+ "on i.img_id = id.img_id"
//					+ "join product p"
//					+ "on p.p_id = id.p_id"
//					+ "join category_detail cd"
//					+ "on p.p_id = cd.p_id"
//					+ "join category c"
//					+ "on c.ctg_id = cd.ctg_id"
//					+ "join product_detail pd"
//					+ "on pd.p_id = p.p_id"
//					+ "join product_spec s"
//					+ "on s.ps_id = pd.ps_id"
//					+ "where c.ctg_main = 'backpack'"
//					+ "limit " + startPage + ", " + onePageCount;
//			
//			stmt = conn.prepareStatement(query);
//			
//			rs = stmt.executeQuery();
//			
//			while(rs.next()) {
//				// product 정보 가져오기 
//				int p_id = rs.getInt("p_id");
//				String p_name = rs.getString("p_name");
//				int p_stock = rs.getInt("p_stock");
//				int price = rs.getInt("p_price");
//				int discountPrice = rs.getInt("p_discountPrice");
//				int p_size = rs.getInt("p_size");
//				String p_mainf = rs.getString("p_mainf");
//				String p_colorimg = rs.getString("p_colorimg");
//				String p_colorname = rs.getString("p_colorname");
//				Timestamp p_date = rs.getTimestamp("p_date");
//				String p_desc = rs.getString("p_desc");
//				String p_clickcount = rs.getString("p_clickcount");
//				String ctg_id = rs.getString("ctg_id");
//				String ctg_main = rs.getString("ctg_main");
//				String ctg_middle = rs.getString("ctg_middle");
//				String ctg_sub = rs.getString("ctg_sub");
//				String img_thum = rs.getString("img_thum");
//				String ps_color = rs.getString("ps_color");
//				
//				ProductListDto dto = new ProductListDto(p_id, p_name, p_stock, price, discountPrice,
//						p_size, p_mainf, p_colorimg, p_colorname, p_date, p_desc, p_clickcount,
//						ctg_id, ctg_main, ctg_middle, ctg_sub, img_thum, ps_color);
//				
//				dtos.add(dto);
//			}
//
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//			
//		}finally {
//			
//			try {
//				if(rs != null) rs.close();
//				if(stmt != null) stmt.close();
//				if(conn != null) conn.close();
//				
//				
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//
//		
//		return dtos;
//	}
//	
//
//	// 상품 중분류 페이지 출력
//	public ArrayList<ProductListDto> middleList(String sctg_middle, int startPage, int onePageCount){
//
//		ArrayList<ProductListDto> dtos = new ArrayList<ProductListDto>();
//		
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//	
//		try {
//			conn = dataSource.getConnection();
//			String query = "select *"
//					+ "from product_image i"
//					+ "join image_detail id"
//					+ "on i.img_id = id.img_id"
//					+ "join product p"
//					+ "on p.p_id = id.p_id"
//					+ "join category_detail cd"
//					+ "on p.p_id = cd.p_id"
//					+ "join category c"
//					+ "on c.ctg_id = cd.ctg_id"
//					+ "join product_detail pd"
//					+ "on pd.p_id = p.p_id"
//					+ "join product_spec s"
//					+ "on s.ps_id = pd.ps_id where ctg_middle = ?"
//					+ "limit " + startPage + ", " + onePageCount;
//			
//			stmt = conn.prepareStatement(query);
//			stmt.setString(1, sctg_middle);
//
//			rs = stmt.executeQuery();
//			
//			while(rs.next()) {
//				// product 정보 가져오기 
//				int p_id = rs.getInt("p_id");
//				String p_name = rs.getString("p_name");
//				int p_stock = rs.getInt("p_stock");
//				int price = rs.getInt("p_price");
//				int discountPrice = rs.getInt("p_discountPrice");
//				int p_size = rs.getInt("p_size");
//				String p_mainf = rs.getString("p_mainf");
//				String p_colorimg = rs.getString("p_colorimg");
//				String p_colorname = rs.getString("p_colorname");
//				Timestamp p_date = rs.getTimestamp("p_date");
//				String p_desc = rs.getString("p_desc");
//				String p_clickcount = rs.getString("p_clickcount");
//				String ctg_id = rs.getString("ctg_id");
//				String ctg_main = rs.getString("ctg_main");
//				String ctg_middle = rs.getString("ctg_middle");
//				String ctg_sub = rs.getString("ctg_sub");
//				String img_thum = rs.getString("img_thum");
//				String ps_color = rs.getString("ps_color");
//				
//				ProductListDto dto = new ProductListDto(p_id, p_name, p_stock, price, discountPrice,
//						p_size, p_mainf, p_colorimg, p_colorname, p_date, p_desc, p_clickcount,
//						ctg_id, ctg_main, ctg_middle, ctg_sub, img_thum, ps_color);
//				
//				dtos.add(dto);
//			}
//
//		}catch(Exception e) {
//			e.printStackTrace();
//			
//		}finally {
//			
//			try {
//				if(rs != null) rs.close();
//				if(stmt != null) stmt.close();
//				if(conn != null) conn.close();
//				
//				
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//
//		return dtos;
//	}
//	
//	//기능별 상품 페이지 리스트
//	public ArrayList<ProductListDto> functionList(String sp_mainf, int startPage, int onePageCount){
//		
//		 ArrayList<ProductListDto> dtos = new ArrayList<ProductListDto>();
//		
//		 Connection conn = null;
//		 PreparedStatement stmt = null;
//		 ResultSet rs = null;
//		
//			try {
//				conn = dataSource.getConnection();
//				String query = "select *"
//						+ "from product_image i"
//						+ "join image_detail id"
//						+ "on i.img_id = id.img_id"
//						+ "join product p"
//						+ "on p.p_id = id.p_id"
//						+ "join category_detail cd"
//						+ "on p.p_id = cd.p_id"
//						+ "join category c"
//						+ "on c.ctg_id = cd.ctg_id"
//						+ "join product_detail pd"
//						+ "on pd.p_id = p.p_id"
//						+ "join product_spec s"
//						+ "on s.ps_id = pd.ps_id"
//						+ "where p.p_mainf = ?"
//						+ "limit " + startPage + ", " + onePageCount;
//				
//				stmt = conn.prepareStatement(query);
//				stmt.setString(1, sp_mainf);
//				
//				rs = stmt.executeQuery();
//				
//				while(rs.next()) {
//					// product 정보 가져오기 
//					int p_id = rs.getInt("p_id");
//					String p_name = rs.getString("p_name");
//					int p_stock = rs.getInt("p_stock");
//					int price = rs.getInt("p_price");
//					int discountPrice = rs.getInt("p_discountPrice");
//					int p_size = rs.getInt("p_size");
//					String p_mainf = rs.getString("p_mainf");
//					String p_colorimg = rs.getString("p_colorimg");
//					String p_colorname = rs.getString("p_colorname");
//					Timestamp p_date = rs.getTimestamp("p_date");
//					String p_desc = rs.getString("p_desc");
//					String p_clickcount = rs.getString("p_clickcount");
//					String ctg_id = rs.getString("ctg_id");
//					String ctg_main = rs.getString("ctg_main");
//					String ctg_middle = rs.getString("ctg_middle");
//					String ctg_sub = rs.getString("ctg_sub");
//					String img_thum = rs.getString("img_thum");
//					String ps_color = rs.getString("ps_color");
//					
//					ProductListDto dto = new ProductListDto(p_id, p_name, p_stock, price, discountPrice,
//							p_size, p_mainf, p_colorimg, p_colorname, p_date, p_desc, p_clickcount,
//							ctg_id, ctg_main, ctg_middle, ctg_sub, img_thum, ps_color);
//					
//					dtos.add(dto);
//				}
//
//			}catch(Exception e) {
//				e.printStackTrace();
//				
//			}finally {
//				
//				try {
//					if(rs != null) rs.close();
//					if(stmt != null) stmt.close();
//					if(conn != null) conn.close();
//					
//					
//				}catch(Exception e) {
//					e.printStackTrace();
//				}
//			}
//		 
//		 
//		 return dtos;
//	}
//	
//	// 기능 전체 페이지 리스트
//	public ArrayList<ProductListDto> middleFunctionList(int startPage, int onePageCount){
//		
//		 ArrayList<ProductListDto> dtos = new ArrayList<ProductListDto>();
//		
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		
//			try {
//				conn = dataSource.getConnection();
//				String query = "select *"
//						+ "from product_image i"
//						+ "join image_detail id"
//						+ "on i.img_id = id.img_id"
//						+ "join product p"
//						+ "on p.p_id = id.p_id"
//						+ "join category_detail cd"
//						+ "on p.p_id = cd.p_id"
//						+ "join category c"
//						+ "on c.ctg_id = cd.ctg_id"
//						+ "join product_detail pd"
//						+ "on pd.p_id = p.p_id"
//						+ "join product_spec s"
//						+ "on s.ps_id = pd.ps_id"
//						+ "where p.p_mainf != ''"
//						+ "limit " + startPage + ", " + onePageCount;
//				
//				stmt = conn.prepareStatement(query);
//				
//				rs = stmt.executeQuery();
//				
//
//				while(rs.next()) {
//					// product 정보 가져오기 
//					int p_id = rs.getInt("p_id");
//					String p_name = rs.getString("p_name");
//					int p_stock = rs.getInt("p_stock");
//					int price = rs.getInt("p_price");
//					int discountPrice = rs.getInt("p_discountPrice");
//					int p_size = rs.getInt("p_size");
//					String p_mainf = rs.getString("p_mainf");
//					String p_colorimg = rs.getString("p_colorimg");
//					String p_colorname = rs.getString("p_colorname");
//					Timestamp p_date = rs.getTimestamp("p_date");
//					String p_desc = rs.getString("p_desc");
//					String p_clickcount = rs.getString("p_clickcount");
//					String ctg_id = rs.getString("ctg_id");
//					String ctg_main = rs.getString("ctg_main");
//					String ctg_middle = rs.getString("ctg_middle");
//					String ctg_sub = rs.getString("ctg_sub");
//					String img_thum = rs.getString("img_thum");
//					String ps_color = rs.getString("ps_color");
//					
//					ProductListDto dto = new ProductListDto(p_id, p_name, p_stock, price, discountPrice,
//							p_size, p_mainf, p_colorimg, p_colorname, p_date, p_desc, p_clickcount,
//							ctg_id, ctg_main, ctg_middle, ctg_sub, img_thum, ps_color);
//					
//					dtos.add(dto);
//				}
//
//			}catch(Exception e) {
//				e.printStackTrace();
//				
//			}finally {
//				
//				try {
//					if(rs != null) rs.close();
//					if(stmt != null) stmt.close();
//					if(conn != null) conn.close();
//					
//					
//				}catch(Exception e) {
//					e.printStackTrace();
//				}
//			}
//		 
//		 
//		 return dtos;
//	}
//	
//}
