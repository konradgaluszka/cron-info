package com.galuszka.croninfo;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage java com.galuszka.Main \"<cron> command\"");
            return;
        }
        var cronJob = args[0];
        var cronInfo = new CronInfo(cronJob);
        System.out.println(cronInfo.get());
    }
}