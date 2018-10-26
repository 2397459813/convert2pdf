package com.sbr.converter.demo;

import java.io.File;

import com.sbr.converter.PDFConverter;
import com.sbr.converter.components.impl.PDF2ExcelConverter;
import com.sbr.converter.components.impl.PDF2PPTConverter;
import com.sbr.converter.components.impl.PDF2WordConverter;

public class Demo {
	public static void main(String[] args) {
		
		//word转换为PDF
		PDFConverter wordConverter = new PDF2WordConverter();
		wordConverter.convert(new File("C:\\Users\\Administrator\\Desktop\\测试1.docx"), new File("C:\\Users\\Administrator\\Desktop\\测试1.pdf"));
		//wordConverter.convert(new File("F://test//CINCC平台管理接口规范-JSON-V1.2.1.doc"), new File("F://test//CINCC平台管理接口规范-JSON-V1.2.1.pdf"));
		//excel转换为PDF
		//PDFConverter excelConverter = new PDF2ExcelConverter();
		//excelConverter.convert(new File("C:\\Users\\Administrator\\Desktop\\真实号码.xls"), new File("C:\\Users\\Administrator\\Desktop\\真实号码.pdf"));
		
		//ppt转换为PDF
		//PDFConverter pptConverter = new PDF2PPTConverter();
		//pptConverter.convert(new File("/Users/caomei/Desktop/333.pptx"), new File("/Users/caomei/Desktop/333.pdf"));
	}
}
