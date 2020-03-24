package com.web.demo.jsoup;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class JsoupFirstTest {
    @Test
    public void testUrl() throws IOException {
        // 解析url地址，第一个参数是访问的url，第二个参数是访问时候的超时时间
        Document doc =Jsoup.parse(new URL("http://www.itcast.cn"),1000);

        // 使用标签选择器，获取title标签中的内容
        String title = doc.getElementsByTag("title").first().text();

        // 打印
        System.out.println(title);
    }

    @Test
    public void  testString() throws IOException {
        // 使用工具类读取文件，获取字符串
        String content  = FileUtils.readFileToString(new File("F:\\Work\\JsoupStringTest.html"),"utf8");

        // 解析字符串
        Document doc = Jsoup.parse(content);

        // 使用标签选择器，获取title标签中的内容
        String title = doc.getElementsByTag("title").first().text();

        // 打印
        System.out.println(title);
    }

    @Test
    public void  testFile() throws IOException {
        // 解析文件
        Document doc = Jsoup.parse(new File("F:\\Work\\JsoupStringTest.html"),"utf8");

        // 使用标签选择器，获取title标签中的内容
        String title = doc.getElementsByTag("title").first().text();

        // 打印
        System.out.println(title);
    }

    @Test
    /*
    * 从DOM中获取元素
    * */
    public void testDOM() throws IOException {
        // 解析文件
        Document doc = Jsoup.parse(new File("F:\\Work\\JsoupStringTest.html"),"utf8");

        // 获取元素

        // 1.根据id查询元素getElementById
        Element element = doc.getElementById("city_bj");
        System.out.println("获取到的元素内容是"+element.text());

        // 2.根据标签获取元素getElementByTag
        Element element1 = doc.getElementsByTag("span").first();
        System.out.println("获取到的元素内容是"+element1.text());

        // 3.根据class获取元素getElementByClass
        Element element2 = doc.getElementsByClass("class_a class_b").first();
        System.out.println("获取到的元素内容是"+element2.text());
        Element element3 = doc.getElementsByClass("class_a").first();
        System.out.println("获取到的元素内容是"+element3.text());
        Element element4 = doc.getElementsByClass("class_b").first();
        System.out.println("获取到的元素内容是"+element4.text());

        // 4.根据属性获取元素getElementByAttribute
        Element element5 = doc.getElementsByAttribute("abc").first();
        System.out.println("获取到的元素内容是"+element5.text());
        Element element6 = doc.getElementsByAttributeValue("href", "http://www.itcast.cn").first();
        System.out.println("获取到的元素内容是"+element6.text());
    }

    @Test
    /*
     * 从元素中获取数据
     * */
    public void testData() throws IOException {
        // 解析文件
        Document doc = Jsoup.parse(new File("F:\\Work\\JsoupStringTest.html"),"utf8");

        // 根据id获取元素
        Element element = doc.getElementById("test");
        String str = "";

        // 1.从元素中获取id
        str = element.id();

        // 2.从元素中获取className
        str = element.className();
        Set<String> strings = element.classNames();
        /*for (String className : strings) {
            System.out.println(className);
        }*/

        // 3.从元素中获取属性的值attr
        str = element.attr("id");

        // 4.从元素中获取所有属性attributes
        Attributes attributes = element.attributes();
        System.out.println(attributes.toString());

        // 5.从元素中获取文本内容test
        str = element.text();

        System.out.println("获取到的元素内容是"+str);
    }

    @Test
    /*
     * 根据选择器获取元素
     * */
    public void testSelector() throws IOException {
        // 解析文件
        Document doc = Jsoup.parse(new File("F:\\Work\\JsoupStringTest.html"),"utf8");

        // 获取元素

        // 1.根据标签查找元素
        Elements span = doc.select("span");
        /*for (Element element : span) {
            System.out.println(element.text());
        }*/

        // 2.根据id查找元素 #id
        // Element element = doc.select("#city_bj").first();

        // 3.根据class查找元素 .class
        // Element element = doc.select(".class_a").first();

        // 4.根据属性查找元素 [abc]
        Element element = doc.select("[abc]").first();

        // 5.根据属性值查找元素 [class=s_name]
        Elements select = doc.select("[class=s_name]");
        for (Element element1:select) {
            System.out.println(element.text());
        }

        System.out.println("获取到的结果"+element.text());
    }

}
