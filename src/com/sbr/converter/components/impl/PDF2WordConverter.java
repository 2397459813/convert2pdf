package com.sbr.converter.components.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


import org.apache.log4j.Logger;

import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;
import com.sbr.converter.components.AbstractPDFConverter;

/**
 * 
  * 将word转换为PDF
  *
  * @author 曹传红
  * @date 2018年9月21日 下午2:54:55
  * @version 1.0 
  *
 */
public class PDF2WordConverter extends AbstractPDFConverter {

	
	private static Logger logger = Logger.getLogger(PDF2WordConverter.class);
	
	
	public PDF2WordConverter() {
		super();
	}
	
	public PDF2WordConverter(String fontDir) {
		super(fontDir);
	}

	@Override
	protected void initFileType() {
		fileTypes.add("txt");
		fileTypes.add("doc");
		fileTypes.add("docx");
		fileTypes.add("wps");
	}

	@Override
	protected boolean matchLicense() {
		boolean result = false;
		InputStream is = PDF2WordConverter.class.getClassLoader().getResourceAsStream("com/sbr/converter/components/licenses/license.xml");
		License wordLicense = new License();
		try {
			wordLicense.setLicense(is);
			result = true;
		} catch (Exception e) {
			logger.warn("载入word授权文件失败");
		}
		return result;
	}

	@Override
	protected void convert2PDF(File sourceFile,File targetFile) {
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(targetFile);
			Document doc = new Document(sourceFile.getAbsolutePath());
			doc.save(os, SaveFormat.PDF);
		} catch (FileNotFoundException e) {
			logger.error("输出到"+targetFile.getAbsolutePath()+"错误:"+e);
		} catch (Exception e) {
			logger.error("转换word出错:"+e);
		}finally {
			if(os!=null) {
				try {
					os.close();
				} catch (IOException e) {
					logger.error("关闭输出流出错:"+e);
				}
			}
		}
	}
	
	

}
