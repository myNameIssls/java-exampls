package cn.tyrone.apache.commons.io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Base64;

public class IOUtilsDemo {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/shanglishuai/temp/tmp.txt");

        InputStream inputStream = FileUtils.openInputStream(file);

        // 输入流转化为字符串
        String ciphertext = IOUtils.toString(inputStream, "UTF-8");

        // 输入流转换字节流
        byte[] bytes = IOUtils.toByteArray(inputStream);

        // URL网络资源转化字节数组
        URL url = new URL("https://image.baidu.com/search/albumsdetail?tn=albumsdetail&word=%E5%9F%8E%E5%B8%82%E5%BB%BA%E7%AD%91%E6%91%84%E5%BD%B1%E4%B8%93%E9%A2%98&fr=searchindex_album%20&album_tab=%E5%BB%BA%E7%AD%91&album_id=7&rn=30");
        byte[] byteArray = IOUtils.toByteArray(url);
        String bufferString = Base64.getEncoder().encodeToString(byteArray);
        System.out.printf(bufferString);

    }

}
