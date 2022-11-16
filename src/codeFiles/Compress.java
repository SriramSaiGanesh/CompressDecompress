/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codeFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.GZIPOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Compress {
     public static void method(File file)throws IOException{
        String fileDirectory  = file.getParent();
        System.out.println(fileDirectory);
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos= new FileOutputStream(fileDirectory+ "\\compressedfile.gz");
        GZIPOutputStream gzipOs = new GZIPOutputStream(fos);
        byte[] buffer = new byte[1024];
        int len;
        
        while((len=fis.read(buffer))!=-1){
            gzipOs.write(buffer,0,len);
        }
        fis.close();
        gzipOs.close();
        fos.close();
        
    }
    
    public static void main(String args[])throws IOException{
        File path = new File("C:\\Users\\saiga\\OneDrive\\Documents\\NetBeansProjects\\CompressDecompress\\src\\compressdecompress\\text.txt");
        method(path);
    }
    
}
