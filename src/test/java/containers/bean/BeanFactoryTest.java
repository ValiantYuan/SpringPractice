package containers.bean;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class BeanFactoryTest {

	@Test
	public void testSimpleLoad() {
//		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("beanFactoryTest.xml");
		MyTestBean bean = (MyTestBean) context.getBean("myTestBean");
		assertEquals("testStr", bean.getTestStr());
		IgnoreInterfaceImpl ignoreInterfaceImpl = (IgnoreInterfaceImpl) context.getBean("ignoreInterfaceImpl");
		ignoreInterfaceImpl.print();
	}

}
