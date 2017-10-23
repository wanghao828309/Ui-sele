package utils;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import listens.TestNGListener;

public class Dom4jUtils {
	
	private static Logger logger = LogManager.getLogger(TestNGListener.class.getName());
	
	
	/* 指定子节点的名字，获取其文本,如该节点不存在，返回空字符串，非null */
	public static String getText(Element e, String nodename) {
		String text = "";
		try {
			text = e.element(nodename).getTextTrim();
		} catch (Exception Ex) {
			text = "";
		}
		return text;
	}

	/* 指定子节点的名字，获取其文本,如该节点不存在，返回null */
	public static String getTextEx(Element e, String nodename) {
		String text = "";
		try {
			text = e.element(nodename).getTextTrim();
			if (text.length() == 0)
				return null;
		} catch (Exception Ex) {
			return null;
		}
		return text;
	}

	/*
	 * 指定子节点的名字，获取其数字值,如该节点不存在，默认返回0，非null 注意：如需要判断某数字值的节点是否存在，不应调用此方法，因此方法有默认值
	 */
	public static int getInt(Element e, String nodename) {
		String text = getText(e, nodename);
		if (text.length() == 0)
			text = "0";
		int iVal = Integer.parseInt(text);
		return iVal;
	}

	/*
	 * 指定子节点的名字，获取其数字值,如该节点不存在或格式错误，返回null
	 */
	public static Integer getInteger(Element e, String nodename) {
		Element eNode = e.element(nodename);
		if (eNode == null)
			return null;
		String text = eNode.getTextTrim();
		if (text.length() == 0)
			return null;
		Integer iVal = null;
		try {
			iVal = new Integer(Integer.parseInt(text));
		} catch (Exception ex) {
			return null;
		}
		return iVal;
	}
	
	public static byte[] getBytes(Element e,String name) {
        String s = getText(e, name);
        return s.getBytes();
    }

    public static Element getChild(Element e,String name) {
        try {
            return e.element(name);
        } catch (Exception Ex) {
            return null;
        }
    }
    
    public static String getLevelAttributeValue(String xml, String attributeName){
    	
    	String value = "";
    	if(attributeName==null || "".equals(attributeName)){
    		return null;
    	}
    	
    	
    	try {
            
    		// 将字符串转为XML
    		Document doc = DocumentHelper.parseText(xml); 
    		// 获取根节点
    		Element rootElt = doc.getRootElement(); 
    		
    		List<Element> rowElList = rootElt.selectNodes("//row");
    		for (Element rowEle : rowElList) {
				
    			List<Attribute> attrList = rowEle.attributes();
    			for(Attribute item : attrList){
    				
    				if(attributeName.equals(item.getName())){
    					value = item.getValue();
    					return value;
    				}
    			}
    			
			}
    		
        } catch (Exception Ex) {
            return null;
        }
    	
    	
    	return value;
    	
    }
    
//    public static String getNodeValue(String xml, String nodeName){
//		String[] valueArr = MessageParseUtil.getNodeText(xml, nodeName);
//		if(valueArr!=null && valueArr.length>0){
//			return valueArr[0];
//		}else{
//			return "";
//		}
//	}
    
    public static String getValueByTagAndAttrName(String xml, String nodeName, String attrName){
    	
    	String value = "";
    	try {
			Document document = DocumentHelper.parseText(xml);
			Element root = document.getRootElement();
			Element notifyEle = root.element("notify");
			Element element = notifyEle.element(nodeName);
	        Attribute attribute = element.attribute(attrName);
	        value = attribute.getText();
		} catch (DocumentException e) {
			logger.error("Dom4jUtils.getValueByTagAndAttrName()==>error,", e);
		}
    	return value;
    }

}
