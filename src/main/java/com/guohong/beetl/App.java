package com.guohong.beetl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.exception.BeetlException;
import org.beetl.core.resource.ClasspathResourceLoader;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			/*StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
			Configuration cfg = Configuration.defaultConfiguration();
			GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
			Template t = gt.getTemplate("hello,${name}");
			t.binding("name", "beetl");
			String str = t.render();
			System.out.println(str);*/
			
			
			ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("templates/");
			Configuration cfg = Configuration.defaultConfiguration();
			GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
			Template t = gt.getTemplate("/demo.html");
			
			t.binding("name", "guohong");
			
			List<String> list = new ArrayList<String>();
			list.add("java");
			list.add("python");
			list.add("ruby");
			Map<String, List<String>> map = new HashMap<String, List<String>>();
			map.put("languages", list);
			
			t.binding(map);
			
			String str = t.render();
			System.out.println(str);
			
			
		} catch (BeetlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
