/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codeFiles;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.GZIPInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Decompress {
   public static void method(File file) throws FileNotFoundException, IOException{
        String fileDirectory  = file.getParent();
        System.out.println(fileDirectory);
        FileInputStream fis = new FileInputStream(file);
        GZIPInputStream gzipIS = new GZIPInputStream(fis);
        FileOutputStream fos= new FileOutputStream(fileDirectory+"\\decompressedfile.txt");
        
        byte[] buffer = new byte[1024];
        int len;
        
        while((len=gzipIS.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        gzipIS.close();
        fis.close();
        fos.close();
   }
    
    public static void main(String args[])throws IOException{
        File path = new File("C:\\Users\\saiga\\OneDrive\\Documents\\NetBeansProjects\\CompressDecompress\\src\\compressdecompress\\compressedfile.gz");
        method(path);
    }
}
