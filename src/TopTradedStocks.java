/**
 * Created by dullam on 4/6/18.
 */

// This is the text editor interface.
// Anything you type or change here will be seen by the other person in real time.

/*
Given a stream of stocks and trades, allow a user to query the top-most traded stocks

Ex.
IBM 1000
AAPL 500
AAPL 600
NFLX 1000
AMZN 700

IBM
NFLX


*/

import java.util.List;
        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.Map;
        import java.util.PriorityQueue;
        import java.util.Comparator;


public class TopTradedStocks {

    public static class Stock {
        String name;
        int count;
        public Stock(String name, int count) {
            this.name = name;
            this.count = count;
        }

    }

    public  ArrayList<String> getTopTradedStocks(int k, ArrayList<Stock> stocks) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(Stock s: stocks) {
            if(map.containsKey(s.name))
                map.put(s.name,map.get(s.name)+s.count);
            else
                map.put(s.name,s.count);
        }

        PriorityQueue<Stock> pq = new PriorityQueue<Stock>(1000, new Comparator<Stock>() {
            public int compare(Stock s1, Stock s2) {
                return s2.count - s1.count;
            }
        });

        for(Map.Entry<String,Integer>  entry: map.entrySet()) {
            pq.add(new Stock(entry.getKey(), entry.getValue()));
        }

        ArrayList<String> res = new ArrayList<String>();
        int last=0;
        while(res.size() < k) {
            Stock st = pq.poll();
            last = st.count;
            res.add(st.name);
        }

        while(pq.peek() != null && pq.peek().count == last) {
            res.add(pq.poll().name);
        }


        return res;


    }

    public static void main(String[] args) {

        String[] stocks = new String[]{"IBM"};

        TopTradedStocks sol = new TopTradedStocks();

        ArrayList<Stock> aList = new ArrayList<Stock>();
        Stock s1 = new Stock("IBM", 700);
        Stock s2 = new Stock("AAPL", 100);
        Stock s3 = new Stock("AAPL", 2000);
        Stock s4 = new Stock("TSLA", 2100);
        Stock s5 = new Stock("BLM", 3300);
        Stock s6 = new Stock("FB", 100);

        aList.add(s1);
        aList.add(s2);
        aList.add(s3);
        aList.add(s4);
        aList.add(s5);
        aList.add(s6);
        ArrayList<String> result = sol.getTopTradedStocks(2, aList);

        System.out.println(" Top traded stocks are:  ");
        for(String s: result)
            System.out.println(" " + s);
    }



}