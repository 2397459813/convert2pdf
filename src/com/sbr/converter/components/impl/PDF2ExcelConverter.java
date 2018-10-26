package com.sbr.converter.components.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;

import com.aspose.cells.License;
import com.aspose.cells.SaveFormat;
import com.aspose.cells.Workbook;
import com.sbr.converter.components.AbstractPDFConverter;

/**
 * 
  * 将excel文件转换为PDF的转换器
  *
  * @author 曹传红
  * @date 2018年9月21日 下午2:47:23
  * @version 1.0 
  *
 */
public class PDF2ExcelConverter extends AbstractPDFConverter {

	
	private static Logger logger = Logger.getLogger(PDF2ExcelConverter.class);
	
	//初始化文件后缀
	@Override
	protected void initFileType() {
		fileTypes.add("xls");
		fileTypes.add("xlsx");
		fileTypes.add("et");
	}

	//实现匹配文件授权
	@Override
	protected boolean matchLicense() {
		boolean result = false;
		InputStream is = PDF2ExcelConverter.class.getClassLoader().getResourceAsStream("com/sbr/converter/components/licenses/license.xml");
		License excelLicense = new License();
		try {
			excelLicense.setLicense(is);
			result = true;
		} catch (Exception e) {
			logger.warn("载入excel授权文件失败");
		}
		return result;
	}

	@Override
	protected void convert2PDF(File sourceFile, File targetFile) {
		FileOutputStream fileOs = null;
		Workbook wb = null;
		try {
			fileOs = new FileOutputStream(targetFile);
			wb = new Workbook(sourceFile.getAbsolutePath());
			wb.save(fileOs, SaveFormat.PDF);
		} catch (FileNotFoundException e) {
			logger.error("输出到"+targetFile.getAbsolutePath()+"错误:"+e);
		} catch (Exception e) {
			logger.error("转换excel出错:"+e);
		}finally {
			if(fileOs!=null) {
				try {
					fileOs.close();
				} catch (IOException e) {
					logger.error("关闭输出流出错:"+e);
				}
			}
		}
		
	}

}
