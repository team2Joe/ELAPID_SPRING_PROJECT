package com.elapid.spring01.command;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.elapid.spring01.dao.QnaDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class EQuestionWriteCommand implements ECommand {

	@Override
	public void execute_session(SqlSession sqlSession, Model model, HttpSession session, HttpServletRequest request) {
		// TODO Auto-generated method stub

		session = request.getSession();
		
		Map<String, Object> map = model.asMap();
		request = (HttpServletRequest) map.get("request");
		
		String uploadPath=request.getRealPath("/resources/upload");;
		MultipartRequest mr =null; 
				
		try {
			mr = new MultipartRequest(request, uploadPath,1024*1024*10,"UTF-8", new DefaultFileRenamePolicy());
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
		String qc_name = mr.getParameter("qc_name");
		
		System.out.println(qc_name + "****************");
		String pq_title = mr.getParameter("pq_title");
		String pq_content= mr.getParameter("pq_content");
		String uid = (String) session.getAttribute("uid");
		//이미지파일 업로드 
		
		
		   
		   int size = 10*1024*1024;
		   String filename1="";
		   
		   try{
		      MultipartRequest multi=new MultipartRequest(request,
		                     uploadPath,
		                     size, 
		                     "utf-8",
		            new DefaultFileRenamePolicy());
      
		      Enumeration files=multi.getFileNames();
		      
		      String file1 =(String)files.nextElement();
		      filename1=multi.getFilesystemName(file1);
		   }catch(Exception e){
		      e.printStackTrace();
		   }
		   
		// 업로드 끝
		
		QnaDao dao = sqlSession.getMapper(QnaDao.class);
		//model.addAttribute("questionWrite", dao.writeDao());
		dao.writeDao(qc_name, size, pq_title, pq_content, uid);
		
		
	}
	
	@Override
	public void execute(SqlSession sqlSession, Model model) {

		
	}
	
	
}