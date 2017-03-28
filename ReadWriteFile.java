package com.migu.reconciliation.utils;


import java.io.*;



public class ReadWriteFile {
    public static BufferedReader bufread;
    


    public static File creatTxtFile(String path) throws IOException{
    	File filename = new File(path);
        if (!filename.exists()) {
            filename.createNewFile();
        }else {
			filename.delete();
			filename.createNewFile();
		}
        return filename;
    }
    

    public static void deleteFile(String path) throws IOException{
    	File filename = new File(path);
        if (filename.exists()) {
            filename.delete();
            System.err.println(filename + "��ɾ����");
        }
    }
    

    public static String readTxtFile(File filename){
        String read;
        FileReader fileread;
        String readStr="";
        try {
            fileread = new FileReader(filename);
            bufread = new BufferedReader(fileread);
            try {
                while ((read = bufread.readLine()) != null) {
                    readStr = readStr + read+ "\r\n";
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return readStr;
    }

    public static void resetFile(File filename) throws IOException{
        String filein ="";
        RandomAccessFile mm = null;
        try {
            mm = new RandomAccessFile(filename, "rw");
            mm.writeBytes(filein);
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (mm != null) {
                try {
                    mm.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
    public static void writeTxtFile(File filename,String newStr) throws IOException{
    	String readStr=readTxtFile(filename);
        String filein = newStr + "\r\n" + readStr + "\r\n";
        RandomAccessFile mm = null;
        try {
            mm = new RandomAccessFile(filename, "rw");
            mm.writeBytes(filein);
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (mm != null) {
                try {
                    mm.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
    public static void replaceTxtByStr(String path,String oldStr,String replaceStr) {
        String temp = "";
        try {
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer buf = new StringBuffer();

            for (int j = 1; (temp = br.readLine()) != null
                    && !temp.equals(oldStr); j++) {
                buf = buf.append(temp);
                buf = buf.append(System.getProperty("line.separator"));
            }

            buf = buf.append(replaceStr);

            while ((temp = br.readLine()) != null) {
                buf = buf.append(System.getProperty("line.separator"));
                buf = buf.append(temp);
            }

            br.close();
            FileOutputStream fos = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(fos);
            pw.write(buf.toString().toCharArray());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}