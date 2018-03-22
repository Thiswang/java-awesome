/**
 * Copyright (C), 2011-2018, 微贷网.
 *
 * @author wangzhe 2018/2/2.
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadReadFileHelper {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
        long beginTime = System.currentTimeMillis();
        ThreadReadFileHelper helper = new ThreadReadFileHelper();
        helper.read("/Users/wangzhe/工作/face_recognition/wz01252.sql", 16, '\n', new StringCallback("UTF-8") {
            @Override
            void callback(String data) {
                int count = atomicInteger.incrementAndGet();
                System.out.println(data);
                if (count == 100000) {
                    System.out.println("总耗时毫秒：" + (System.currentTimeMillis() - beginTime));
                }
            }
        });

    }

    public void read(String path, int threadCount, char separator, StringCallback callback) throws IOException {

        RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r");

        long fileTotalLength = randomAccessFile.length();
        long gap = fileTotalLength / threadCount;
        long checkIndex = 0;
        long[] beginIndexs = new long[threadCount];
        long[] endIndexs = new long[threadCount];

        for (int n = 0; n < threadCount; n++) {
            beginIndexs[n] = checkIndex;
            if (n + 1 == threadCount) {
                endIndexs[n] = fileTotalLength;
                break;
            }
            checkIndex += gap;
            long gapToEof = getGapToEof(checkIndex, randomAccessFile, separator);

            checkIndex += gapToEof;
            endIndexs[n] = checkIndex;
        }

        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);

        for (int n = 1; n < threadCount; n++) {
            long begin = beginIndexs[n];
            long end = endIndexs[n];
            executorService.execute(() -> {
                try {
                    readData(begin, end, path, separator, callback);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private long getGapToEof(long beginIndex, RandomAccessFile randomAccessFile, char separator) throws IOException {
        randomAccessFile.seek(beginIndex);
        long count = 0;
        while (randomAccessFile.read() != separator) {
            count++;
        }
        count++;
        return count;
    }

    private void readData(long begin, long end, String path, char separator, StringCallback callback) throws FileNotFoundException, IOException {
        System.out.println("开始工作" + Thread.currentThread().getName());

        RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r");

        randomAccessFile.seek(begin);
        StringBuilder builder = new StringBuilder();

        while (true) {
            int read = randomAccessFile.read();
            begin++;
            if (separator == read) {
                if (callback != null) {
                    callback.callback0(builder.toString());
                }
                builder = new StringBuilder();
            } else {
                builder.append((char) read);
            }

            if (begin >= end) {
                break;
            }
        }
        randomAccessFile.close();
    }

    public static abstract class StringCallback {
        private String charsetName;
        private ExecutorService executorService = Executors.newSingleThreadExecutor();

        public StringCallback(String charsetName) {
            this.charsetName = charsetName;
        }

        private void callback0(String data) {
            executorService.execute(() -> {
                try {
                    callback(new String(data.getBytes("UTF-8"), charsetName));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            });

        }

        abstract void callback(String data);
    }

}