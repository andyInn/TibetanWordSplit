package com.cun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class FileIO {
	/**
	 * 
	 * @param TO_SPLIT_FILE
	 * @param AFTER_SPLIT_FILE
	 * @param OUTPUT_FILE
	 */
	public void mkDirsAndFiles(File TO_SPLIT_FILE, File AFTER_SPLIT_FILE, File OUTPUT_FILE){
		try {//create dirs and files
			if(!TO_SPLIT_FILE.exists()){
				if(!TO_SPLIT_FILE.getParentFile().exists())
					TO_SPLIT_FILE.getParentFile().mkdirs();
				TO_SPLIT_FILE.createNewFile();
			}
			if(!AFTER_SPLIT_FILE.exists()){
				if(!AFTER_SPLIT_FILE.getParentFile().exists())
					AFTER_SPLIT_FILE.getParentFile().mkdirs();
				AFTER_SPLIT_FILE.createNewFile();
			}
			if(!OUTPUT_FILE.exists()){
				if(!OUTPUT_FILE.getParentFile().exists())
					OUTPUT_FILE.getParentFile().mkdirs();
				OUTPUT_FILE.createNewFile();
			}
		} catch (Exception e) {
			System.err.print("fail to create files!");
		}
	}
	
	/**
	 * 
	 * @param INPUT_FILE
	 * @return
	 */
	public BufferedReader readFile(File INPUT_FILE){
		BufferedReader br=null;
		try {//read data from files
			br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(INPUT_FILE), "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		return br;
	}
	
	/**
	 * save result to be used by search engine
	 * @param target
	 * @param list
	 */
	public void writeBackToFile(File target, List<StringBuilder> list){
		BufferedWriter bw=null;
		try {// default buffer size: 8192bit, write to after_split_files
			bw = new BufferedWriter(
					new OutputStreamWriter(
							new FileOutputStream(target), "utf-8"));
			for (StringBuilder sb : list) {
				bw.write(sb.toString());
			}
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if (bw != null) {
					bw.flush();
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
