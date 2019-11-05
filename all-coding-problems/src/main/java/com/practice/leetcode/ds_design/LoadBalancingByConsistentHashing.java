package com.practice.leetcode.ds_design;

import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class LoadBalancingByConsistentHashing {

    public static void main(String[] args) throws InterruptedException {

        final int max = 100;

        SortedMap<Integer, String> locToServerIdMap = new TreeMap<>();

        for (int i = 1; i < 10; i++) {
            String serverId = "Server" + i;
            int hash = ((((Math.abs(serverId.hashCode()) % max )* 31 ) % max + 31) * 31) % max;
            System.out.println("hashcode of "+serverId+" is "+hash);
            locToServerIdMap.put(hash, serverId);
        }
        System.out.println(locToServerIdMap);
        Thread loadBalancer = new Thread(new LoadBalancerTask(locToServerIdMap, max));
        loadBalancer.start();
        loadBalancer.join();
    }

    static class LoadBalancerTask implements Runnable {

        SortedMap<Integer, String> locToServerIdMap;
        int maxLocations;
        Random random = new Random();

        LoadBalancerTask(SortedMap<Integer, String> map, int max) {
            locToServerIdMap = map;
            maxLocations = max;
        }

        @Override
        public void run() {

            while (true) {
                String randomUserId = "User" + random.nextInt(Integer.MAX_VALUE);
                SortedMap<Integer, String> mapWithHigherOrderThanCurrentUser = locToServerIdMap.tailMap(randomUserId.hashCode() % maxLocations);
                Integer assignedLoc = mapWithHigherOrderThanCurrentUser.isEmpty() ?
                        locToServerIdMap.firstKey() : mapWithHigherOrderThanCurrentUser.firstKey();
                String assignedServerId = locToServerIdMap.get(assignedLoc);
                System.out.println("User: " + randomUserId + " is assigned to server: " + assignedServerId);
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }


}
