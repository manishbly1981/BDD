package util;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.sql.SQLOutput;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class CompactUtil {

    public static void main(String args[]){
//        System.out.println(new CompactUtil().removeSpecialCharacterInFileName("man /:*?\"<>|ish"));
    }
    //To be used in Reporting to create the folder and file
    public String getCurrentTimeStemp(String pattern){
        return new SimpleDateFormat(pattern).format(new Timestamp(System.currentTimeMillis()));
    }

    //To create the folder on hard drive
    public void createFolder(String directory){
        File fileLocation= new File(directory);
        if(!fileLocation.exists())
            new File(directory).mkdirs();
    }

    public String getSystemName(){
        try {
            InetAddress ip = InetAddress.getLocalHost();
            return ip.getHostName();
        }catch(Exception e){
            new ExceptionHandler().customizedException("Cannot get the host name of execution machine");
         return "";
        }
    }

    public String removeSpecialCharacterInFileName(String fileName){
        fileName=fileName.replace(" ", "_");
        fileName=fileName.replace("\\", "");
        fileName=fileName.replace("/", "");
        fileName=fileName.replace(":", "");
        fileName=fileName.replace("*", "");
        fileName=fileName.replace("?", "");
        fileName=fileName.replace("\"", "");
        fileName=fileName.replace("<", "");
        fileName=fileName.replace(">", "");
        fileName=fileName.replace("|", "");
        return fileName;
    }

    public static void closeSpecificProcess(String processName){
        try {
            Process process = Runtime.getRuntime().exec("taskkill /F /IM "+ processName);
            process.waitFor();
        }catch(IOException | InterruptedException e){
            e.printStackTrace();
        }

    }
}
