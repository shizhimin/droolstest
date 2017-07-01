import cn.szm.service.DroolService;
import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by lw-yf-040 on 2017/6/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class DroolsTest {
	@Resource
	DroolService droolService;
	@Test
	public void droolsTest2(){
		droolService.test();
	}
	@Test
	public void shengchengdrl()throws Exception{
		File file = new File("D:\\ideawork\\drools6springdemo\\src\\test\\resources\\excel\\test.xlsx");
		InputStream is = new FileInputStream(file);
		SpreadsheetCompiler converter = new SpreadsheetCompiler();
		String drl = converter.compile(is, InputType.XLS);
		System.out.println("\n\n" + drl);
	}

}
