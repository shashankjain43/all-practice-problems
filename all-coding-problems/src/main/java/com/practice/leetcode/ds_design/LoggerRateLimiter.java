package com.practice.leetcode.ds_design;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LoggerRateLimiter {

    PriorityQueue<Log> recentLogs;
    Set<String> recentMessages;

    /** Initialize your data structure here. */
    public LoggerRateLimiter() {
        recentLogs = new PriorityQueue<Log>(10, new Comparator<Log>() {
            public int compare(Log l1, Log l2) {
                return l1.timestamp - l2.timestamp;
            }
        });
        recentMessages = new HashSet<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        while (recentLogs.size() > 0)   {
            Log log = recentLogs.peek();
            // discard the logs older than 10 minutes
            if (timestamp - log.timestamp >= 10) {
                recentLogs.poll();
                recentMessages.remove(log.message);
            } else
                break;
        }
        boolean res = !recentMessages.contains(message);
        if (res) {
            recentLogs.add(new Log(timestamp, message));
            recentMessages.add(message);
        }
        return res;
    }

    class Log {
        int timestamp;
        String message;
        public Log(int aTimestamp, String aMessage) {
            timestamp = aTimestamp;
            message = aMessage;
        }
    }
}
