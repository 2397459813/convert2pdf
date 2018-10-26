package com.sbr.converter.components.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;

import com.aspose.slides.License;
import com.aspose.slides.Presentation;
import com.aspose.slides.SaveFormat;
import com.sbr.converter.components.AbstractPDFConverter;


/**
 * 
  * 将PPT转换为PDF
  *
  * @author 曹传红
  * @date 2018年9月21日 下午2:55:23
  * @version 1.0 
  *
 */
public class PDF2PPTConverter extends AbstractPDFConverter {

	private static Logger logger = Logger.getLogger(PDF2PPTConverter.class);
	@Override
	protected void initFileType() {
		fileTypes.add("ppt");
		fileTypes.add("pptx");
		fileTypes.add("dps");
	}

	@Override
	protected boolean matchLicense() {
		boolean result = false;
		InputStream is = PDF2PPTConverter.class.getClassLoader().getResourceAsStream("com/sbr/converter/components/licenses/license.xml");
		License pptLicense = new License();
		try {
			pptLicense.setLicense(is);
			result = true;
		} catch (Exception e) {
			logger.warn("载入ppt授权文件失败");
		}
		return result;
	}

	@Override
	protected void convert2PDF(File sourceFile, File targetFile) {
		FileOutputStream fileOS = null;
		InputStream slides = null;
		try {
			slides = new FileInputStream(sourceFile);
			Presentation pres = new Presentation(slides);
			File pptFile = new File(targetFile.getAbsolutePath());// 输出pdf路径
			fileOS = new FileOutputStream(pptFile);
			pres.save(fileOS, SaveFormat.Pdf);
		} catch (FileNotFoundException e) {
			logger.error("文件未找到:"+e);
		}finally{
			try {
				if (fileOS != null) {
					fileOS.close();
				}
				if (slides != null) {
					slides.close();
				}
			} catch (IOException e) {
				logger.error("关闭输出流出错:"+e);
			}
				
			
		}
		
	}

}
