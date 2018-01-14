package wz.study.jdk.spi;

import java.util.ServiceLoader;

public class SpiTest {

    public static void main(String[] args) {

        ServiceLoader<HelloService> helloServiceLoader= ServiceLoader.load(HelloService.class);

        for(HelloService item:helloServiceLoader){
            item.hello();
        }
    }
}
