package cn.tyrone.apache.commons.io;

import org.apache.commons.io.FilenameUtils;

public class FilenameUtilsDemo {

    public static void main(String[] args) {
        String filePath= "/Users/shanglishuai/Downloads/hm.jpg";

        // hm
        String baseName = FilenameUtils.getBaseName(filePath);
        System.out.println(baseName);

        // hm.jpg
        String name = FilenameUtils.getName(filePath);
        System.out.println(name);

        // jpg
        String extension = FilenameUtils.getExtension(filePath);
        System.out.println(extension);

        // Users/shanglishuai/Downloads/
        String path = FilenameUtils.getPath(filePath);
        System.out.println(path);

        // 返回 /
        String prefix = FilenameUtils.getPrefix(filePath);
        System.out.println(prefix);

        // 返回 /Users/shanglishuai/Downloads/
        String fullPath = FilenameUtils.getFullPath(filePath);
        System.out.println(fullPath);

        // 返回 /Users/shanglishuai/Downloads/hm.jpg
        String s = FilenameUtils.separatorsToUnix(filePath);
        System.out.println(s);

        // 返回 \Users\shanglishuai\Downloads\hm.jpg
        String s1 = FilenameUtils.separatorsToWindows(filePath);
        System.out.println(s1);

    }

}
