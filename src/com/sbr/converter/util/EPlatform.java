package com.sbr.converter.util;

//本类来自 yin_jw 的CSDN 博客 ，
//全文地址：https://blog.csdn.net/yin_jw/article/details/39966605?utm_source=copy 
public enum EPlatform {
	 
	Any("any"), Linux("Linux"), Mac_OS("Mac OS"), Mac_OS_X("Mac OS X"), Windows("Windows"), OS2("OS/2"), Solaris("Solaris"), SunOS("SunOS"), MPEiX(
			"MPE/iX"), HP_UX("HP-UX"), AIX("AIX"), OS390("OS/390"), FreeBSD("FreeBSD"), Irix("Irix"), Digital_Unix("Digital Unix"), NetWare_411(
			"NetWare"), OSF1("OSF1"), OpenVMS("OpenVMS"), Others("Others");
	
	private String description;
 
	private EPlatform(String desc) {
		this.description = desc;
	}
 
	public String toString() {
		return description;
	}
 
}

