package com.hgz;

import com.hgz.util.ThreadPoolerUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class pool {

    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        List<Future> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String msg = String.format("这是第{%s}条消息", i);
            Future<String> submit = ThreadPoolerUtils.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(300);
                    System.out.println(String.format("打印消息%s", msg));
                    return "OK";
                }
            });
            futureList.add(submit);
        }

        for (int i = 0; i < futureList.size(); i++) {
            System.out.println(futureList.get(i));
        }
        System.out.println(String.format("共计耗时{%s}毫秒", System.currentTimeMillis() - start));
    }
}
