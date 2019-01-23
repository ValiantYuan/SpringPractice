package containers.bean;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
@SuppressWarnings("deprecation")
public class BeanFactoryTest {

	@Test
	public void testSimpleLoad() {
		
		XmlBeanFactory context = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
//		@SuppressWarnings("resource")
//		ApplicationContext context = new ClassPathXmlApplicationContext("beanFactoryTest.xml");
		MyTestBean bean = (MyTestBean) context.getBean("myTestBean");
		assertEquals("testStr", bean.getTestStr());
	}
	
	@Test
	public void testIgnoreDependency() {
		XmlBeanFactory context = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
		/**
		 * Type指定类型可以让beanFactory中该类型的属性不会自动装配
		 * Interface指定类型可以让beanFactory中在Interface中设置值的属性不会被自动装配,被忽略属性的类必须继承自该接口
		 */
		context.ignoreDependencyInterface(IgnoreInterface.class);
//		context.ignoreDependencyType(ArrayList.class);
		IgnoreInterfaceImpl ignoreInterfaceImpl = (IgnoreInterfaceImpl) context.getBean("ignoreInterfaceImpl");
		ignoreInterfaceImpl.print();
	}

}
