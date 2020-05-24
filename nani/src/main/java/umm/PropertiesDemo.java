package umm;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesDemo {
	/**
	 * ������Ƽ ������ ��Ʈ������ ����
	 *
	 * @param path
	 * @throws IOException
	 */
	public Properties loadProp(String path) throws IOException {
		Properties properties = new Properties();
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
		properties.load(inputStream);
		inputStream.close();
		return properties;
	}

	public static void main(String[] args) throws IOException {
		PropertiesDemo propertiesDemo = new PropertiesDemo();

		// ������Ƽ ������ �о���̰� �ش� ���� ���
		Properties properties = propertiesDemo.loadProp("application.properties");
		properties.list(System.out);

		// ���� Ű�� �� ��� �������̵� �ϴ� ���� Ȯ��
		Properties staticProp = propertiesDemo.loadProp("application-prod.properties");
		properties.putAll(staticProp);
		properties.list(System.out);

		// ������Ƽ���� ����
		Properties dummy = new Properties();
		dummy.put("demo.type", "dummy");
		dummy.put("demo.temp", "temp"); 	// ���ο� Ű�� �߰�
		properties.putAll(dummy); 			// ���� ������Ƽ�� ���� ������Ƽ�� ����
		properties.list(System.out);

		// Ű�� �־� ���� ����
		Object type = properties.get("demo.type");
		System.out.println(type);

		// ������Ƽ Ű���� ��ȸ
		// stringPropertyNames() ��� �ٸ� �޼ҵ� ��� ����
		for (String key : properties.stringPropertyNames()) {
			Object value = properties.getProperty(key);
			System.out.println(value);
		}

		// �ش� Ű�� �ִ��� ���θ� �Ǻ��մϴ�.
		System.out.println(properties.containsKey("demo.type"));

		// �ش� ���� �ִ��� ���θ� �Ǻ��մϴ�.
		System.out.println(properties.containsValue("dummy"));
	}
}