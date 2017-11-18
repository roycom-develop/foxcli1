package linux;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Common {
	/**
	 * searchRegexString 在目标字符串中按行搜索子串后，分割取其中一列。
	 * @param srcStr 待查找字符串
	 * @param regexStr 正则字符串
	 * @param splitString 分割字符子串，一般是使用" *"来分割多个空格
	 * @param column 将使用正则表达式查询后的字符串分割后的第column列赋值给一个ArrayList的对象
	 * @return 返回查询并分割后第column列的字符串数组。
	 */
	public static ArrayList<String> searchRegexString(String srcStr, String regexStr, String splitString, int column){
		ArrayList<String> result = new ArrayList<String>();
		Pattern pattern = Pattern.compile(regexStr, Pattern.MULTILINE);
		Matcher matcher = pattern.matcher(srcStr);
		while(matcher.find()){
			String tmp = matcher.group().trim();
			String[] listA = tmp.split(String.format("%s*", splitString));
			result.add(listA[column].trim());
		}
		return result;
	}
	
	/**
	 * exeShell 运行shell命令，返回执行结果
	 * @param cmd shell命名字符串
	 * @return 返回执行结果
	 * @throws IOException 可能出现的IO异常
	 * @throws InterruptedException 异常
	 */
	public static String exeShell(String cmd) throws IOException, InterruptedException {
		ProcessBuilder builder = new ProcessBuilder("/bin/bash", "-c", cmd);
		builder.redirectErrorStream(true);
		Process p = builder.start();
		p.waitFor();
		InputStream is =  p.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();
        StringBuilder esb = new StringBuilder();
        InputStream eis = p.getErrorStream();
        InputStreamReader eisr = new InputStreamReader(eis);
        BufferedReader ebr = new BufferedReader(eisr);
        while(true){
            String line = br.readLine();
            if(line == null){
                break;
            }
            
            if(line.trim().length()>0){
                sb.append(line);
                sb.append("\n");
            }
        }
        br.close();
        isr.close();
        is.close();
        
        while(true){
            String eline = ebr.readLine();
            if(eline==null){
                break;
            }
            if(eline.trim().length()>0){
                esb.append(eline);
                esb.append("\n");
            }
        }
        ebr.close();
        eisr.close();
        eis.close();
        
        String ssb = sb.toString().trim();
        String sesb = esb.toString().trim();
        if(0 == sesb.length()){
        	return ssb;
        }else{
        	return sesb;
        }
	}
}
