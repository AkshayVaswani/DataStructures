package randomStuff;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.lang.*;

public class dataReview {

	public static void main(String[] args) {
		//arraylist with numbers
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0 ;i < (int)(Math.random()*101)+50 ; i ++) {
			list.add((int)(Math.random()*100)+1);
		}
		System.out.println(list);
		
		//2d array with square dimensions
		int arraySize = (int)(Math.ceil(Math.sqrt(list.size())));
		int[][] squareArr = new int[arraySize][arraySize];
		while(list.size() > 0) {
			int x = (int)(Math.random() * arraySize);
			int y = (int)(Math.random() * arraySize);
			if(squareArr[x][y] == 0) {
				//removing from arraylist
				squareArr[x][y] = list.remove(0);
			}
		}
		//printing in square
		for(int[] a : squareArr) {
			for(int i : a) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
		
		//stack
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i<arraySize; i++) {
			for(int j = 0; j<arraySize; j++) {
				stack.push(squareArr[j][i]);
			}
		}
		//hashset and printing stack
		HashSet<Integer> hashSet = new HashSet<Integer>();
		for(int i =0; i<arraySize * arraySize; i++) {
			hashSet.add(stack.peek());
			System.out.print(stack.pop()+", ");
		}
		
		//priority queue and printing hash set with iterator
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		Iterator<Integer> itr2 = hashSet.iterator(); 
        while (itr2.hasNext()) { 
        	
        	int x = itr2.next();
            System.out.print(x+ " ");
            priorityQueue.add(x);
        }
		
        System.out.println();
        //printing priority queue
        System.out.println("PriorityQueue QUEUE");
        TreeMap<Integer, TreeSet<Integer>> tMap = new TreeMap<Integer, TreeSet<Integer>>();
        int recent = 0;
        boolean first = false;
        while (priorityQueue.peek()!=null) {
        	int x = priorityQueue.poll();
        	if(!false) {
        		if (x%2==0) {
					recent = x;
					first = true;
				}
        	}
        	if(x%2==0) {
        		if(!tMap.containsKey(recent)) {
        			tMap.put(x, new TreeSet<Integer>());
        			recent = x;
        		}
        	} else {
        		tMap.get(recent).add(x);
        	}   
            System.out.print(x+" "); 
            
        }
      //Treemap with baby treesets
      
        for (Map.Entry<Integer, TreeSet<Integer>> entry : tMap.entrySet()) {
            Integer tempKey = entry.getKey();
            TreeSet<Integer> tempTree = entry.getValue();
            System.out.println(tempKey + ": " + tempTree);
        }
        
	}
}
