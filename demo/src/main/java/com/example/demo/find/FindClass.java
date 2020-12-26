package com.example.demo.find;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.tools.ant.DirectoryScanner;

/**
 * ��Ŀ¼�в��ң��򣬲�����class
 *
 * @author �¹�ҫ (mailto:chengy@primeton.com)
 */
/*
 * �޸���ʷ
 * $Log$
 */
public class FindClass {
	public static void usage() {
		System.out.println("Usage:");
		System.out.println("\tjava [-Ddebug=true|false] [-DexactMatch=false|true] FindClass className fromDir ");
		System.out.println("\nExamples:");
		System.out.println("\tjava FindClass org.apache.ant.Zip d:\\jboss4.0.5\\lib");
		System.out.println("\tjava FindClass org/apache/ant/Zip d:\\jboss4.0.5\\lib");
		System.out.println("\tjava -Ddebug=true FindClass org.apache.ant.Zip d:\\jboss4.0.5\\lib");
		System.out.println("\tjava -DexactMatch=true FindClass org.apache.ant.Zip d:\\jboss4.0.5\\lib");
	}

	private static boolean findClassInJar(String className,File dirOrFile,boolean isDebug,boolean exactMatch) {
		String baseDir=null;
		String[] jars=null;
		if(dirOrFile.isDirectory()) {
			DirectoryScanner dirscan=new DirectoryScanner();
			baseDir=dirOrFile.getAbsolutePath();
			dirscan.setBasedir(baseDir);
			dirscan.setIncludes(new String[] {"**/*.jar","**/*.zip","**/*.ecd","**/*.epd"});
			dirscan.scan();

			jars=dirscan.getIncludedFiles();
		}else {
			baseDir=dirOrFile.getParent();
			jars=new String[] { dirOrFile.getName() };
		}

		if(jars.length==0) {
			System.out.println("Not found any jars.");
			System.exit(1);
		}

		List<String> jarPaths=new ArrayList<String>();

		String searchName=getSearchName(className,exactMatch);

		List<String> findJars=new ArrayList<String>();
		List<String> findClasses=new ArrayList<String>();
		for(int i=0;i<jars.length;i++) {
			String jar=jars[i];
			String jarPath=baseDir+File.separator+jar;
			if(isDebug)
				System.out.println("\nSearching class in "+jarPath+" ...");
			try {
				jarPaths.add(jarPath);
				ZipFile zip=new ZipFile(jarPath);

				for(Enumeration entries=zip.entries();entries.hasMoreElements();) {
					ZipEntry entry=(ZipEntry)entries.nextElement();

					if(entry.isDirectory())
						continue;

					if(isDebug)
						System.out.println("\t"+entry.getName());

					if((exactMatch && entry.getName().equals(searchName))
							|| ( !exactMatch && entry.getName().indexOf(searchName)>-1)) {
						findJars.add(jar);
						String clsName=entry.getName().replaceAll("/", ".");
						findClasses.add(clsName);
					}
				}
				zip.close();
			} catch (Exception e) {
				continue;
			}
		}

		System.out.println("\nSearching class/resource ( "+ className + " ) from the following jars:");
		System.out.println("------------------------------------------------------------------");
		for(String path:jarPaths) {
			System.out.println(path);
		}
		System.out.println();

		if(findJars.size()>0) {
			System.out.println("\nFound class/resource ( "+ className + " ) in jars:");
			for(int i=0;i<findJars.size();i++) {
				String clsName=(String)findClasses.get(i);
				String jarName=(String)findJars.get(i);
				System.out.println("["+clsName+"]");
				System.out.println("\t"+baseDir+File.separator+jarName);
				System.out.println();
			}
			return true;
		}else {
			System.out.println("Not found any jars.");
			return false;
		}
	}

	private static String getSearchName(String className,boolean exactMatch) {
//		String searchNameWithoutExt=null;
//		String ext=null;
//		if(className.endsWith(".class")) {
//			ext=".class";
//			searchNameWithoutExt=deleteTailStr(className, ext);
//		}else {
//			ext=getExt(className);
//			if(ext!=null)
//				searchNameWithoutExt=deleteTailStr(className, ext);
//			else
//				searchNameWithoutExt=className;
//		}
//		if(exactMatch && ext==null)
//			ext=".class";

		String searchName = null;
		if(className.indexOf("/")==-1)
			searchName=className.replaceAll("[.]", "/");
		else
			searchName = className;

		return searchName;

	}

	private static String deleteTailStr(String str,String tailStr) {
		return str.substring(0, str.length()-tailStr.length());
	}

	private static String getExt(String filename) {
		int pos=filename.lastIndexOf(".");
		if(pos!=-1) {
			return filename.substring(pos);
		}else
			return null;
	}

	public static void main(String[] args) {
		String debug=System.getProperty("debug");
		boolean needDebug=false;

		if(debug!=null)
			needDebug=Boolean.parseBoolean(debug);

		boolean exactMatch=false;
		String exact=System.getProperty("exactMatch");
		if(exact!=null)
			exactMatch=Boolean.parseBoolean(exact);

		if(args.length<2) {
			usage();
			return;
		}

		String className=args[0];
		String baseDir=args[1];
		if(baseDir.endsWith("\r")) {
			baseDir=baseDir.substring(0,baseDir.length()-1);
		}

		findClassInJar(className, new File(baseDir), needDebug,exactMatch);
	}

}
