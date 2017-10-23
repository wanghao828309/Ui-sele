package utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import java.util.Properties;

public class PublicUtil {

  public static String getUserDir() {
    return System.getProperty("user.dir");
  }

  public static String getFileSeparator() {
    return System.getProperty("file.separator");
  }

  /**
   * 压缩文件夹
   *
   * @param dir
   *            待压缩的文件目录
   * @param zipName
   *            压缩后的文件名
   * @return
   */
  public static File zipDir(String dir, String zipName) throws Exception {
    File file = null;
    FileOutputStream fileOut = null;
    try {
      file = new File(zipName);
      fileOut = new FileOutputStream(file);
      ZipOutputStream outputStream = new ZipOutputStream(fileOut);

      File rootFile = new File(dir);
      File[] files = rootFile.listFiles();

      for (int i = 0; i < files.length; i++) {
        FileInputStream fileIn = new FileInputStream(files[i]);
        outputStream.putNextEntry(new ZipEntry(files[i].getName()));
        byte[] buffer = new byte[1024];
        int count = fileIn.read(buffer);
        while (count > 0) {
          outputStream.write(buffer, 0, count);
          count = fileIn.read(buffer);
        }
        outputStream.closeEntry();
        fileIn.close();
      }
      outputStream.close();

    }
    catch (Exception es) {
      throw es;
    }
    finally {
      if (fileOut != null) {
        try {
          fileOut.close();
        }
        catch (Exception ex) {
          fileOut = null;
        }
      }

    }
    return file;
  }

  /**
   * 得到当前日期字符
   *
   * @return String，当前日期字符
   */
  public static String getCurDateTime() {
    Calendar now = Calendar.getInstance(TimeZone.getDefault());
    String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
        DATE_FORMAT);
    sdf.setTimeZone(TimeZone.getDefault());
    return sdf.format(now.getTime());
  }

  /**
   * 得到当前日期
   *
   * @param dateFormate
   *            String，格式化字符串
   * @return String，当前日期
   */
  public static String getCurDateTime(String dateFormate) {
    try {
      Calendar now = Calendar.getInstance(TimeZone.getDefault());
      java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
          dateFormate);
      sdf.setTimeZone(TimeZone.getDefault());
      return sdf.format(now.getTime());
    }
    catch (Exception e) {
      return getCurDateTime(); // 如果无法转化，则返回默认格式的时间。
    }
  }

  /**
   * 得到当前年
   *
   * @return String，当前年
   */
  public static String getCurYear() {
    java.util.Date now = new java.util.Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
    return formatter.format(now);
  }

  /**
   * 得到当前月
   *
   * @return String，当前月
   */
  public static String getCurMonth() {
    java.util.Date now = new java.util.Date();
    SimpleDateFormat formatter = new SimpleDateFormat("MM");
    return formatter.format(now);
  }

  /**
   * 检查一个字符串，只能包含数字
   *
   * @param targetStr
   *            String，输入的字符
   * @return boolean，非法false或合法true
   */

  public static final boolean checkDigital(String targetStr) {
    return Pattern.matches("[0-9]*", targetStr);
  }

  /**
   * 根据条件解压上传的文件:不支持中文目录
   *
   */
  public static void unZipFile(String file, String targetPath) throws Exception {
    // 定义zip中的实体
    ZipEntry entry = null;
    InputStream in = null;
    BufferedOutputStream bout = null;
    ZipFile zip = null;
    try {
      zip = new ZipFile(file);
      // 将zip中的每个实体放入Enumeration中
      Enumeration num = zip.entries();
      // 遍历Enumeration，判断解压文件是否已经存在
      while (num.hasMoreElements()) {
        entry = (ZipEntry) num.nextElement();
        // 解压后每个实体的文件名
        File directory = new File(targetPath + entry.getName());
        // 判断是否为目录
        if (entry.isDirectory()) {
          // 创建目录
          directory.mkdirs();
        }
      }
      Enumeration save = zip.entries();
      // 遍历Enumeration，进行保存操作
      while (save.hasMoreElements()) {
        entry = (ZipEntry) save.nextElement();
        // 当文件不为目录时进行保存
        if (!entry.isDirectory()) {
          // 进行保存文件
          in = zip.getInputStream(entry);
          if(in == null){
        	  continue;
          }
          File temp = new File(targetPath + entry.getName());
//					if(!temp.exists()){
//						temp.createNewFile();
//					}
          bout = new BufferedOutputStream(new FileOutputStream(temp));
//          int rc = 0;
//          byte[] buf = new byte[1024];
//          while ( (rc = in.read(buf, 0, 1024)) > 0) {
//            bout.write(buf, 0, rc);
//          }
          int c = in.read();          
          while(c != -1){
        	  bout.write(c);
        	  c = in.read();
          }
          bout.flush();
          if (bout != null) {
              bout.close();
              bout = null;
            }
        }
      }
    }
    catch (Exception e) {
//			logger.error(e.getMessage(), e);
      throw e;
    }
    // 关闭文件
    finally {
      if (bout != null) {
        bout.close();
      }
      if (in != null) {
        in.close();
      }
      if (zip != null) {
        zip.close();
      }
    }
  }

  /**
   * 获取指定目录下所有的文件名
   * @param dir
   * @return
   */
  public static void putFilesIntoList(List list, File dir) {
    if (dir.isDirectory()) {
      File[] temp = dir.listFiles();
      for (int i = 0; i < temp.length; i++) {
        putFilesIntoList(list, temp[i]);
      }
    }
    else {
      list.add(dir);
    }
  }

  public static void delete(File file) {
	if(file == null){
	  return;
	}
    if (file.isDirectory()) {
      File[] list = file.listFiles();
      for (int i = 0; i < list.length; i++) {
        delete(list[i]);
      }
    }
    file.delete();
  }

  /**
   * JDK15以上支持
   * @param xmlFileName String
   * @return Properties
   */
  public static Properties getPropertiesFromXml(String xmlFileName) throws Exception{
    Properties prop = new Properties();
    FileInputStream fis = new FileInputStream(xmlFileName);
    prop.loadFromXML(fis);
    fis.close();
    return prop;
  }

  public static void main(String[] args) {
//		zipDir("D:\\temp\\20060729181438837001", "D:\\temp\\20060729181438837001.zip");
    // File file = new File("d:\\temp\\20060729180251321004.zip");
    // unZipFileggg(file, "c:\\temp\\", true);
	  try{
    unZipFile("D:\\temp\\GreenBrowserGB.zip", "D:\\temp\\release\\");
	System.out.println("sdfsdf");
	  }catch( Exception ex){
		  ex.printStackTrace();
	  }
//		List list = new ArrayList();
//		putFilesIntoList(list, new File("D:\\workspace\\cms\\src\\"));
  }
}
