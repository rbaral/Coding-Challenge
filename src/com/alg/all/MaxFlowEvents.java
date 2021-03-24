/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author rbaral
 */
class Event {

    int startTime, endTime, rate;

    public Event(int st, int end, int r) {
        startTime = st;
        endTime = end;
        rate = r;
    }
}

public class MaxFlowEvents {

    public static int getMaxFlow(Event[] events) {
        PriorityQueue<Event> heap1 = new PriorityQueue<Event>(events.length, new Comparator<Event>() {
            public int compare(Event e1, Event e2) {
                return e2.startTime - e1.startTime;
            }
        });
        PriorityQueue<Event> heap2 = new PriorityQueue<Event>(events.length, new Comparator<Event>() {
            public int compare(Event e1, Event e2) {
                return e2.endTime - e1.endTime;
            }
        });
        for (Event event : events) {
            heap1.add(event);
        }
        int bestFlowRate = Integer.MIN_VALUE;
        int totalFlowRate = 0;
        while (!heap1.isEmpty()) {
            int earliest = heap1.peek().startTime;
            if (!heap2.isEmpty() && heap2.peek().endTime < earliest) {
                earliest = heap2.peek().endTime;
            }
            while (!heap1.isEmpty() && heap1.peek().startTime == earliest) {
                Event event = heap1.poll();
                totalFlowRate += event.rate;
                heap2.add(event);
            }
            while (!heap2.isEmpty() && heap2.peek().endTime == earliest) {
                Event event = heap2.poll();
                totalFlowRate -= event.rate;
            }
            if (totalFlowRate > bestFlowRate) {
                bestFlowRate = totalFlowRate;
            }
        }
        return bestFlowRate;
    }

    public static void main(String args[]) {
        Event[] events = {new Event(0, 10, 100), new Event(10, 15, 300), new Event(16, 20, 400),
            new Event(5, 15, 200)};
        int bestFlowRate = getMaxFlow(events);
        System.out.println("maxflow rate is:"+bestFlowRate);
    }
}
