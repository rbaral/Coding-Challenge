/*
Webserver Logs: Rate limit requests

You are working as a backend engineer for acme.com. Recently, various users started abusing the company's API server with a flood of requests, 
and your team has decided to limit the rate at which a user can access certain API endpoints.

The domain api.acme.com is served by an application server, placed behind an Nginx frontend proxy. To study the effectiveness of various rate-limiting 
algorithms with realistic traffic, you have collected several Nginx access logfiles (available at /home/candidate/candidate_files/java/inputs), 
where Nginx records each request to the API server. 
The structure of the access logfile is described in /home/candidate/candidate_files/java/log_structure.txt.

Although many rate-limiting algorithms exist, you are interested in a sliding-window strategy, which limits the number of 
API calls to a maximum of 10 requests per second, per IP address. This means that for an arbitrary window of one-second duration, 
the API server responds to 10 or fewer API requests, per IP address.

Write a function rate_limit_traffic that simulates the sliding-window limiter described above. 
Specifically, the function accepts the path of the Nginx access logfile, and returns a list of integers representing the request_id of the 
requests that are rejected by the rate-limiter, e.g., [23, 24, 25, 70, 71, 73, 74].

Additional requirements

The duration of the sliding-window is exactly one second, and includes both extremes of the interval.
Requests that are rejected also count towards the limit of 10 per second.
Requests from the IP address 123.221.14.56 should never be rate-limited, because it's an IP used by the internal Acme crawler that indexes the site.
Requests to any URL starting with /administrator/ should never be rate-limited, because they correspond to the administrator pages of the Acme site.
Assumptions

All entries in the log file will be chronologically ordered.
There are no simultaneous requests.
Requests to administrator pages do not count towards the limit of 10 per second for that ip.
All fields described in log_structure.txt are guaranteed to be present, and have a valid value.
The log_path supplied to the rate_limit_traffic function is guaranteed to point to a file that exists, and can be read.
Save your code in /home/candidate/candidate_files/java/Answer.java

Please refer to the Debug tab for the instructions on how to test your answer.
 */
package com.alg.realtest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author rbaral
 */
public class Pinterest_ws_logs {
    
    /**
     * fields in log file: id, remote_addr, unix_timestamp,request, status, http_user_agent
     * @param log_path is the path of log file
     * return a list of integers representing the IDs of the rejected requests
     */
    
    public static int[] rate_limit_traffic(String log_path){
        List<Integer> rejects = new ArrayList<Integer>();
        try {
            //read the file
            //put the ip, timestamp lines to be filtered in a hash
            //for every ip, check if the timestamp falls within a second of the last added entry, if so, and it doesnt fit within 10 place, its a reject
            //BufferedInputStream bf = new BufferedInputStream(new FileInputStream(new File(log_path)));
            BufferedReader bf = new BufferedReader(new FileReader(new File(log_path)));
            HashMap<String,List<Integer>> requests = new HashMap<String, List<Integer>>();//nested list to retain the order of timestamp and access the last timestamp when needed
            String line;
            String id, ip, timestamp, req;
            String tokens[];
            while((line = bf.readLine())!=null){
                //parse the line
                tokens = line.split(" ");
                ip = tokens[1];
                req = tokens[3];
                //dont rate limit this ip
                if(ip.trim().equals("123.221.14.56"))
                    continue;
                //Requests to any URL starting with /administrator/ not limited
                if(req.trim().split(" ")[1].startsWith("/administrator"))
                    continue;
                timestamp = tokens[2];
                //if the ip and timestamp is within 10 seconds and the count reaches 10
                if(!requests.containsKey(ip)){//first time this ip is seen
                    List<Integer> timestamps = new ArrayList<Integer>();
                    timestamps.add(Integer.parseInt(timestamp));
                    requests.put(ip, timestamps);
                }else{
                    //get the last timestamp of request from this ip
                    List<Integer> timestamps = requests.get(ip);
                    //check if the timestamp is within 10 second limit
                    if(isReject(timestamps, timestamp)){
                        rejects.add(Integer.parseInt(tokens[0])); //add the request as a reject
                    }
                    timestamps.add(Integer.parseInt(timestamp));
                    requests.put(ip, timestamps);
                }
            }
        } catch (FileNotFoundException ex) {
            System.err.println("File not found");
        } catch (IOException ex) {
            System.err.println("Fileread problem");
        }
        return null;
    }
    
    public static boolean isReject(List<Integer> timestamps, String timestamp){
        //find the count of this seconds logged
        int count = Collections.frequency(timestamps, Integer.parseInt(timestamp));
        return count>=10;
    }
}
