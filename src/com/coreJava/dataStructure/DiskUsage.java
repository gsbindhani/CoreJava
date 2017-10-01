package com.coreJava.dataStructure;

import java.io.File;

public class DiskUsage {
	public static void main(String[] args) {
		System.out.println(diskUsage(new File("E:/Study Materials")));
	}
	
	private static long diskUsage(File root){
		long total = root.length();
		if(root.isDirectory()){
			for(String subDir :root.list()){
				File f = new File(root,subDir);
				total += diskUsage(f);
			}
		}
		return total;
	}

}
