package com.adrbook.spring.controller;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.adrbook.spring.model.AdrbookDaoIMP;
import com.adrbook.spring.model.AdrbookVO;
import com.google.gson.Gson;







@Controller
@RequestMapping("/AdrbookServlet")
public class AdrbookController  {
	String brow_ver ="";
	String ip="";
	AdrbookVO adk_vo;

	@RequestMapping(value="/query", method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public  String adrbookQuery(HttpServletRequest request) throws  IOException{
		//��l�� spring
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		// spring Ū�� applicationContext.xml �Ыع��� abkDao
		AdrbookDaoIMP abkDao = (AdrbookDaoIMP) applicationContext.getBean("adrbookDaoIMP");//DaoIMP�����W�A�w�]���r�p�g
		List<AdrbookVO> abks = abkDao.getAll();
		String json = new Gson().toJson(abks);
		System.out.println(json);
		return json;
	}
	@RequestMapping(value="/insert", method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public  void adrbookInsert(HttpServletRequest request) throws  IOException{
		webInit(request);
		//��l�� spring
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		// spring Ū�� applicationContext.xml �Ыع��� abkDao
		AdrbookDaoIMP abkDao = (AdrbookDaoIMP) applicationContext.getBean("adrbookDaoIMP");//DaoIMP�����W�A�w�]���r�p�g
		List<AdrbookVO> abks = abkDao.getAll();

		Map dataMap = (Map) new Gson().fromJson(request.getReader(), Map.class);//�N����json�r���ন����
		Map insert_data =  (Map) dataMap.get("data");
    	System.out.println("fronent-data : "+insert_data);
    	adk_vo.setName(insert_data.get("name").toString());
    	adk_vo.setTel(insert_data.get("tel").toString());
    	adk_vo.setNotes(insert_data.get("notes").toString());
    	adk_vo.setType(insert_data.get("type").toString());
    	adk_vo.setType_index(Integer.parseInt(insert_data.get("type_index").toString()));
    	adk_vo.setGender(insert_data.get("gender").toString());
    	adk_vo.setIp(ip);
    	adk_vo.setBrow_ver(brow_ver);

    	//insert
    	abkDao.insert(adk_vo);
    	System.out.println("insert__complete");
    	webDestory(applicationContext);
	}
	@RequestMapping(value="/update", method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public  void adrbookUpdate(HttpServletRequest request) throws  IOException{
		webInit(request);
		//��l�� spring
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		// spring Ū�� applicationContext.xml �Ыع��� abkDao
		AdrbookDaoIMP abkDao = (AdrbookDaoIMP) applicationContext.getBean("adrbookDaoIMP");//DaoIMP�����W�A�w�]���r�p�g
		Map dataMap = (Map) new Gson().fromJson(request.getReader(), Map.class);//�N����json�r���ন����
		Map update_data =  (Map) dataMap.get("data");
    	System.out.println("fronent-data : "+update_data);
    	adk_vo.setName(update_data.get("name").toString());
    	adk_vo.setTel(update_data.get("tel").toString());
    	adk_vo.setGender(update_data.get("gender").toString());
    	adk_vo.setType(update_data.get("type").toString());
    	adk_vo.setType_index(Integer.parseInt(update_data.get("type_index").toString()));
    	adk_vo.setNotes(update_data.get("notes").toString());
    	adk_vo.setXuid(update_data.get("xuid").toString());
    	adk_vo.setIp(ip);
    	adk_vo.setBrow_ver(brow_ver);
    	System.out.println(adk_vo);

    	//update
    	abkDao.update(adk_vo);
    	System.out.println("update__complete");
    	webDestory(applicationContext);
	}

    @RequestMapping(value="/delete", method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public  void adrbookDelete(HttpServletRequest request) throws  IOException{
		webInit(request);
		//��l�� spring
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		// spring Ū�� applicationContext.xml �Ыع��� abkDao
		AdrbookDaoIMP abkDao = (AdrbookDaoIMP) applicationContext.getBean("adrbookDaoIMP");//DaoIMP�����W�A�w�]���r�p�g
		Map dataMap = (Map) new Gson().fromJson(request.getReader(), Map.class);//�N����json�r���ন����
		Map delete_data =  (Map) dataMap.get("data");
    	System.out.println("fronent-data : "+delete_data);

    	String xuid = delete_data.get("xuid").toString();

    	//delete
    	abkDao.delete(xuid);
    	System.out.println("delete__complete");
    	webDestory(applicationContext);

	}
	private void webInit(HttpServletRequest request) throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8"); // �ѨM����r��J���D
		brow_ver = request.getHeader("User-agent");//���o�t�Ӫ������B����
		ip = request.getRemoteAddr();//���o�t�Ӫ�ip�a�}
		adk_vo= new AdrbookVO();
	}
	private void webDestory(ApplicationContext applicationContext){
		 ((ConfigurableApplicationContext) applicationContext).close();
	}


}
