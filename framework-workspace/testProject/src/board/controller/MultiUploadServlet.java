package board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class MultiUploadServlet
 */
@WebServlet(name = "MultiUpload", urlPatterns = { "/multiUpload" })
public class MultiUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MultiUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//1. 메모리나 파일 업로드 파일을 보관하는 fileitem의 factory설정
		DiskFileItemFactory diskFactory = new DiskFileItemFactory();
		//업로드 시 사용할 임시 메모리 크기 설정 (단위는 byte, 기본값 10240 (10kb))
		diskFactory.setSizeThreshold(4096);
		//임시 저장 폴더 지정
		diskFactory.setRepository(new File(getServletContext().getRealPath("/")+"upload/test2"));
		//2. 업로드 요청을 처리하는 SerlvetFileUpload 객체 생성
		ServletFileUpload upload = new ServletFileUpload(diskFactory);
		upload.setSizeMax(3*1024*1024); //3MB
		//setSizeMax -> 전체 파일 업로드 최대크기
		//setFileSizeMax -> 개별 파일 업로드 최대크기
		//3. servlaetFileUpload 객체를 이용해 request에서 보낸 파라미터 값 처리
		//모든 파라미터가 FileItem 객체 형태로 저장되고 List 묶어서 가져옴
		try {
			List<FileItem> items = upload.parseRequest(request);
			Iterator item = items.iterator();
			ArrayList<String> params = new ArrayList<String>();
			while(item.hasNext()) {
				FileItem fi = (FileItem)item.next();
				if(fi.isFormField()) {	//isFormField()에서 true가 리턴되면 일반 파라미터(일반 스트링)
					String descript = fi.getFieldName();
					params.add(descript);
				}else { //파일인 경우
					String fileOriginName = fi.getName();
					String files = fi.getFieldName();
					//중복파일명 처리 코드
					//aaa.txt -> aaa_1 . txt	(쪼개고 있으면 숫자 추가)
					String fileNameFront = fileOriginName.substring(0, fileOriginName.lastIndexOf('.'));
					String fileNameExtension = fileOriginName.substring(fileOriginName.lastIndexOf('.'));
					File uploadFile = null;
					StringBuilder fileName = new StringBuilder();
					int num = 0;	//중복 이름이 있는 경우 붙여줄 숫자 변수
					while(true) {
						fileName.setLength(0);	//_가 누적되지 않기 위해 파일명 초기화.						
						fileName.append(fileNameFront);
						if(num != 0) {
							fileName.append("_"+num);
						}
						fileName.append(fileNameExtension);
						uploadFile = new File(getServletContext().getRealPath("/")+"upload/test/"+fileName.toString());
						//동일한 파일명이 있으면 덮어쓰기가 되니 체크해야한다.
						if(!uploadFile.exists()) {	//같은 파일명이 존재하지 않으면,
							params.add(fileNameExtension.toString());
							try {
								fi.write(uploadFile);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}						
						num++;
					}	
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
