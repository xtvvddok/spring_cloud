
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.junit.Test;
/***
 * 根据模版每生成action,service,dao以及相应的接口实现类
 * @author twl
 *
 */
public class CreateCmsCode {
	private boolean flag = false;
	//项目的绝对路径，在工作空间中,必须以‘/’结尾
//	private String project = "C:/Users/twl/workspace/Project_Temp/src/com/sofmit/fits/";
	
	private String project = "E:/gz/w_web/w_web/src/com/sofmit/fits/";
	//根据实体bean来生成每个bean的接口和实现类
	
	/*******接口端*******/
	
//	//使用接口端模版生成地址
//	private static final String  PATH_MODEL = "Interface/";
//	//使用接口端模版生成实体标志
//	private static final String  PATH_MODEL_CODE = "I";
	/*******接口端*******/
	
	
	/*******管理端*******/
	//使用管理端模版生成地址
	private static final String  PATH_MODEL = "manage/";
	//使用接口端模版生成实体标志
	private static final String  PATH_MODEL_CODE = "M";
	/*******管理端*******/
	
	
	
	
	
	
	private String[] entitys = { "CityMenu"};
	
	//调用的模版名称
	private String[] templates = { 
			"Action.java",
			"Dao.java",
			"DaoImpl.java",
			"Service.java",
			"ServiceImpl.java", };

	/**
	 * 接口端模版生成地址
	 */
	private String[] files = { 
			PATH_MODEL+"action/", 
			PATH_MODEL+"dao/", 
			PATH_MODEL+"dao/impl/", 
			PATH_MODEL+"service/", 
			PATH_MODEL+"service/impl/" };

	@Test
	public void createCode() throws Exception {
		for (int i = 0; i < entitys.length; i++) {
			VelocityContext context = new VelocityContext();
			context.put("entity", entitys[i]);
			String lowerCase = entitys[i].substring(0, 1).toLowerCase() + entitys[i].substring(1);
			context.put("lowerEntity", lowerCase);
			for (int j = 0; j < templates.length; j++) {
				Template template = Velocity.getTemplate("template/cms/" + PATH_MODEL+templates[j], "UTF-8");
				String filePath = project + files[j] + PATH_MODEL_CODE+entitys[i] + templates[j];
				if ("Service.java".equals(templates[j])) {
					filePath = project + files[j] + PATH_MODEL_CODE+entitys[i] + templates[j];
				} else if ("Dao.java".equals(templates[j])) {
					filePath = project + files[j] + PATH_MODEL_CODE+entitys[i] + templates[j];
				} else if (templates[j].indexOf(".jsp") != -1) {
					filePath = project + files[j] + lowerCase + "/" + lowerCase + "_" + templates[j];
				}
				File savefile = new File(filePath);
				if (savefile.exists()) {
					if (!flag) {
						continue;
					}
				}
				File parentFile = savefile.getParentFile();
				if (!parentFile.exists()) {
					parentFile.mkdirs();
				}
				FileOutputStream outstream = new FileOutputStream(savefile);
				OutputStreamWriter writer = new OutputStreamWriter(outstream, "UTF-8");
				BufferedWriter bufferWriter = new BufferedWriter(writer);
				template.merge(context, bufferWriter);
				bufferWriter.flush();
				outstream.close();
				bufferWriter.close();
				System.out.println("filePath:" + filePath);
			}
		}
		System.out.println("请刷新项目");
	}

}
