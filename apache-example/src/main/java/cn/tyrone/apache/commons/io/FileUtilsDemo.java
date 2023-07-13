package cn.tyrone.apache.commons.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileUtilsDemo {

    public static void main(String[] args) throws IOException {

        File file = new File("/Users/shanglishuai/temp/tmp.txt");

        String string = FileUtils.readFileToString(file, "UTF-8");

        System.out.println(string);
    }

}
