/**
 * Copyright (C), 2011-2018, 微贷网.
 */
package bigfile_read;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
/**
 * @author wangzhe 2018/4/24.
 */
public class MappedFileReader {

    //映射指示器
    private int count=0;
    //映射最大长度
    private int number;
    //映射存储
    private MappedByteBuffer[]  mappedByteBuffers;

    //最终数据存储
    private  byte[] array;

    //单次最大数据长度
    private  int arraySize;
    //文件句柄
    private FileInputStream fileInputStream;


    public MappedFileReader(String fileName, int arraySize) throws IOException {
        this.fileInputStream = new FileInputStream(fileName);
        FileChannel fileChannel = fileInputStream.getChannel();
        long lTotalSize = fileChannel.size();

        int number=(int)Math.ceil((double)lTotalSize/(double)Integer.MAX_VALUE);
        mappedByteBuffers=new MappedByteBuffer[number];

        long preLength=0;
        long regionSize=Integer.MAX_VALUE;

        for(int j=0;j<number;j++)
        {
            if(lTotalSize-preLength < Integer.MAX_VALUE)
            {
                regionSize=lTotalSize-preLength;
            }
            mappedByteBuffers[j]=fileChannel.map(FileChannel.MapMode.READ_ONLY,preLength,regionSize);
            preLength+=regionSize;
        }

        this.arraySize = arraySize;
    }

    public int read() throws IOException {
        if(count>= number)
        {
            return -1;
        }

        int limit=mappedByteBuffers[count].limit();
        int position=mappedByteBuffers[count].position();

        if(limit-position > arraySize)
        {
            array=new byte[arraySize];
            mappedByteBuffers[count].get(array);
            return arraySize;
        }
        else
        {
            array=new byte[limit-position];
            mappedByteBuffers[count].get(array);
            if(count<number)
            {
                count++;
            }
            return limit-position;
        }
    }

    public void close() throws IOException {
        fileInputStream.close();
    }


    public static void main(String[] args) throws IOException {
        MappedFileReader reader = new MappedFileReader("/Users/wangzhe/Downloads/test.txt", 65536);
        long start = System.currentTimeMillis();
        while (reader.read() != -1);
        long end = System.currentTimeMillis();
        System.out.println("MappedFileReader: " + (end - start));
        reader.close();
    }
}