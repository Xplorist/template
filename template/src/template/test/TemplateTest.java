package template.test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *	模板測試
 * @author C3005579
 * @date 2018年11月17日 上午10:22:45 
 */
public class TemplateTest {
	public static void main(String[] args) {
		/*List<SendDeptBean> querySendDeptList = new TestDao().querySendDeptList();
		for(SendDeptBean bean : querySendDeptList) {
			System.out.println(bean.getDept_name());
		}*/
		test();
	}
	
	// test
	public static void test() {
		Date date = new Date();
		String year = new SimpleDateFormat("YYYY").format(date);
		String month = new SimpleDateFormat("MM").format(date);
		String day = new SimpleDateFormat("dd").format(date);
		String path = "D:" + File.separator + year + File.separator
				+ month + File.separator + day;
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
			System.out.println(file.getAbsolutePath());
		}
	}
}


