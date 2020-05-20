package example;

import com.csvreader.CsvReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class csv {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\zhangxiaojun\\Desktop\\泰州学院\\17计嵌2班-Spark-数据清洗-数据仓库\\大数据实训\\test.csv");
        InputStream in = new FileInputStream(file);
//        ZIP
        CsvReader cr = new CsvReader(in, Charset.forName("utf-8"));
        // 获取CSV文件的表头
        cr.readHeaders();
        int a = 0;
        System.out.println(cr.getHeader(12));
        System.out.println(Arrays.toString(cr.getHeaders()));
        // 判断文件中是否有内容可读
        boolean b = cr.readRecord();
//cr.
//        while(cr.readRecord())
        // 读取每一行内容
        String rawRecord = cr.getRawRecord();

        System.out.println(rawRecord);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        // 获取字段数
        int columnCount = cr.getColumnCount();
        System.out.println(columnCount);
        for(int i=0; i<columnCount; i++){
            // 获取指定字段数的值
            String str = cr.get(i);
            Pattern p = Pattern.compile("\\s+|\t+|\n|\r");
            Matcher m = p.matcher(str);
            String s = m.replaceAll("~~");
//            String replace = str.replace("\\s*|\t|\r|\n", "");
            System.out.println(s);
        }

        System.out.println(a);
        cr.close();
    }



    public void add(){
        //........
    }
}
