package com.elapid.spring01.command;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.elapid.spring01.dao.AdminProductDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ERegisterProductCommand implements ECommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		
		AdminProductDao dao = sqlSession.getMapper(AdminProductDao.class);
		
		Map<String, Object> map = model.asMap();
		
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		HttpSession session = request.getSession();
		
		String uploadPath=request.getRealPath("/resources/upload");;
		MultipartRequest mr =null; 
				
		try {
			mr = new MultipartRequest(request, uploadPath,1024*1024*10,"UTF-8", new DefaultFileRenamePolicy());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String u_id = (String)session.getAttribute("uid");
		// product table
		String p_name = mr.getParameter("p_name");
		int p_stock = Integer.parseInt(mr.getParameter("p_stock"));
		int p_price = Integer.parseInt(mr.getParameter("p_price"));
		int p_size = Integer.parseInt(mr.getParameter("p_size"));
		String p_mainf = mr.getParameter("p_mainf");
		
		//product_spec
		String ps_color = mr.getParameter("ps_color");
		String ps_material = mr.getParameter("ps_material");
		int ps_size = Integer.parseInt(mr.getParameter("ps_size"));
		int ps_height = Integer.parseInt(mr.getParameter("ps_height"));
		int ps_depth = Integer.parseInt(mr.getParameter("ps_depth"));
		int ps_width = Integer.parseInt(mr.getParameter("ps_width"));
		int ps_volume = Integer.parseInt(mr.getParameter("ps_volume"));
		int ps_weight = Integer.parseInt(mr.getParameter("ps_weight"));
		
		//product_detail
		
		
		// category
		String ctg_main = mr.getParameter("ctg_main");
		String ctg_middle = mr.getParameter("ctg_middle");
		String ctg_sub = mr.getParameter("ctg_sub");
		
		//category_detail
		
		
		//product_image
		int size = 10*1024*1024;
		   String img_thum="";
		   String img_01="";
		   String img_02="";
		   String img_03="";
		   String img_04="";
		   String img_05="";
		   String img_06="";
		   
		//image_detail   
		   
		   try{
		      MultipartRequest multi=new MultipartRequest(request,
		                     uploadPath,
		                     size, 
		                     "utf-8",
		            new DefaultFileRenamePolicy());

		      
		      Enumeration files=multi.getFileNames();
		      
		      String fileThum =(String)files.nextElement();
		      String file1 =(String)files.nextElement();
		      String file2 =(String)files.nextElement();
		      String file3 =(String)files.nextElement();
		      String file4 =(String)files.nextElement();
		      String file5 =(String)files.nextElement();
		      String file6 =(String)files.nextElement();
		      
		      
		      img_thum = multi.getFilesystemName(fileThum);
		      img_01 = multi.getFilesystemName(file1);
		      img_02 = multi.getFilesystemName(file2);
		      img_03 = multi.getFilesystemName(file3);
		      img_04 = multi.getFilesystemName(file4);
		      img_05 = multi.getFilesystemName(file5);
		      img_06 = multi.getFilesystemName(file6);
		      
		   }catch(Exception e){
		      e.printStackTrace();
		   }		   
		// 업로드 끝

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
