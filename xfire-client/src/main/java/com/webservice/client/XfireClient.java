package com.webservice.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.xfire.client.Client;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class XfireClient {

	public static Map map = new HashMap<Object, Object>();

	public static void main(String[] args) {
		try {
			String url = "http://localhost:8080/xfire-webservice/service//BookService?wsdl";
			Client client = new Client(new URL(url));
			Object[] results = client
					.invoke("sayHello", new Object[] { "吉凌夷" });
			Object[] results2 = client
					.invoke("getBookById", new Object[] { 1 });
			System.out.println(results[0]);
			// 返回对象解析
			Document xmlTree = (Document) results2[0];
			Element root = xmlTree.getDocumentElement();
			parseElement(root);
			System.out.println(map.get("bookId") + "->" + map.get("name"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 解析返回树
	 * 
	 * @param root
	 */
	private static void parseElement(Element root) {
		String key = root.getNodeName();
		NodeList list = root.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			if (node instanceof Element) {
				Element e = (Element) node;
				parseElement(e);
			} else if (node instanceof Text) {
				Text t = (Text) node;
				map.put(key, t.getNodeValue());
			}
		}
	}
}
