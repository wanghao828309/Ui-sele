package utils;
import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLTemplateReader
{
    public static String getMessageTemplate(String fileName)
    {
        String messageBody = "";
        System.out.println("----getMessageTemplate-----");
        SAXReader reader = new SAXReader();
        try
        {
            String path = Thread.currentThread().getContextClassLoader().getResource("/").getPath();
            System.out.println(path);
            Document d = reader.read(new File(path + fileName));
            Element e = d.getRootElement();
            Element htmle = e.element("html");
            messageBody = htmle.asXML();
        }
        catch (DocumentException e)
        {
            e.printStackTrace();
        }
        return messageBody;
    }
}