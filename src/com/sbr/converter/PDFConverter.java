package com.sbr.converter;

import java.io.File;

/**
 * 
  * 文档转换器接口
  *
  * @author 曹传红
  * @date 2018年9月20日 下午7:29:23
  * @version 1.0 
  *
 */
public interface PDFConverter {

	public static String defualtFontDir = "C:\\WINDOWS\\Fonts";
	
	/**
	 * 
	  * 转换文档，将传递过来的文档转换成PDF
	  * @param sourceFile word文件，excel文件，ppt文件
	  * @param targetFile new出来到一个File对象，pdf内容会输出到这个文件
	  * @author 曹传红
	  * @date 2018年9月20日 下午7:31:50
	  * @version 1.0
	 */
	public void convert(File sourceFile,File targetFile);
}
