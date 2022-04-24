package com.elapid.spring01.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.elapid.spring01.dao.AdminProductDao;
import com.elapid.spring01.dto.RegistProductDto;

public class ERegisterProductCommand implements ECommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		RegistProductDto dto = new RegistProductDto();
		
		AdminProductDao dao = sqlSession.getMapper(AdminProductDao.class);

		Map<String, Object> map = model.asMap();
		
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		HttpSession session = request.getSession();
		
//		String uploadPath=request.getRealPath("/resources/elapid_img");;
//		MultipartRequest mr =null; 
//				
//		try {
//			mr = new MultipartRequest(request, uploadPath,1024*1024*10,"UTF-8", new DefaultFileRenamePolicy());
//			
//		} catch (IOException e1) {
//
//			e1.printStackTrace();
//		}

		String u_id = (String)session.getAttribute("uid");
		// product table
		String p_name = request.getParameter("p_name");
		int p_stock = Integer.parseInt(request.getParameter("p_stock"));
		int p_price = Integer.parseInt(request.getParameter("p_price"));
		int p_size = Integer.parseInt(request.getParameter("p_size"));
		String p_mainf = request.getParameter("p_mainf");
		
		//product_spec
		String ps_color = request.getParameter("ps_color");
		String ps_material = request.getParameter("ps_material");
		int ps_size = Integer.parseInt(request.getParameter("ps_size"));
		int ps_height = Integer.parseInt(request.getParameter("ps_height"));
		int ps_depth = Integer.parseInt(request.getParameter("ps_depth"));
		int ps_width = Integer.parseInt(request.getParameter("ps_width"));
		int ps_volume = Integer.parseInt(request.getParameter("ps_volume"));
		int ps_weight = Integer.parseInt(request.getParameter("ps_weight"));
		
		// category
		String ctg_main = request.getParameter("ctg_main");
		String ctg_middle = request.getParameter("ctg_middle");
		String ctg_sub = request.getParameter("ctg_sub");
		
		//category_detail
		
		//product_image
//		int size = 10*1024*1024;
//		   String img_thum="";
		   String img_01="";
		   String img_02="";
		   String img_03="";
		   String img_04="";
		   String img_05="";
		   String img_06="";
		   
		//image_detail  
		   
			//데이터베이스 입력문
//			String query = "insert into purchase(purchase_user_id, purchase_cake_id, purchase_customize_id, purchase_quantity, purchase_price, purchase_text, purchase_status, purchase_img, purchase_img_fileName, purchase_pickup_date) values(?,?,?,?,?,?,?,?,?,?)";
//			File file = new File(img_fileFullPath);
//			FileInputStream inputStream = new FileInputStream(file);  	   
		   
		   // MultipartRequest
//		   try{
//		      MultipartRequest multi=new MultipartRequest(request,
//		                     uploadPath,
//		                     size, 
//		                     "utf-8",
//		            new DefaultFileRenamePolicy());
//
//		      Enumeration files=multi.getFileNames();
//		      
//		      String fileThum =(String)files.nextElement();
//		      img_thum = multi.getFilesystemName(fileThum);
//		      
//		      String file1 =(String)files.nextElement();
//		      img_01 = multi.getFilesystemName(file1);
//		      
//		      String file2 =(String)files.nextElement();
//		      img_02 = multi.getFilesystemName(file2);
//		      
//		      String file3 =(String)files.nextElement();
//		      img_03 = multi.getFilesystemName(file3);
//		      
//		      String file4 =(String)files.nextElement();
//		      img_04 = multi.getFilesystemName(file4);
//		      
//		      String file5 =(String)files.nextElement();
//		      img_05 = multi.getFilesystemName(file5);
//		      
//		      String file6 =(String)files.nextElement();
////		      img_06 = multi.getFilesystemName(file6);
//		      
//		   }catch(Exception e){
//		      e.printStackTrace();
//		   }		
//		   
		// 업로드 끝
			
			//Blob 썸네일 이미지 가져오기
	   Map<String, Object> img_thum = null;
	   
	   try {
	        img_thum = new HashMap<String, Object>();
	        img_thum.put("img_thum", dto.getImg_thum().getBytes());
	       
	    } catch(Exception e) {
	        e.printStackTrace();
	    } 
	   
	   dao.registerProduct(p_name, p_stock, p_price, p_size, p_mainf, ps_color, ps_material,
			   ps_size, ps_height, ps_depth, ps_width, ps_volume, ps_weight,
			   ctg_main, ctg_middle, ctg_sub,
			   img_thum, img_01, img_02, img_03, img_04, img_05, img_06);
		   
		// 상품ID값 받아오기
		   int selectPidNum = dao.selectPidNum().getP_id();
		   
		// 상품과 카테고리, 이미지, 스펙 사이의 릴레이션 외래키에 해당 p_id number 넣어주기
		// registerProduct 메서드를 실행해주고 해당 메서드에서 생성된 p_id값을 릴레이션 테이블에 넣어주는
	    // 메서드이다.
		   dao.insertRelationProductForeignKey(selectPidNum, selectPidNum, selectPidNum,
				   selectPidNum, selectPidNum, selectPidNum);
	}

	@Override
	public void execute_session(SqlSession sqlSession, Model model, HttpSession session, HttpServletRequest request) {
		

	}

}
