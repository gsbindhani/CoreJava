package com.coreJava.thread.cyclicBarrierEx;

import java.util.concurrent.CyclicBarrier;
/**
 * 
 * @author Milu
 *
 * 1. CyclicBarrier can be use when you want to perform some action after completion of
 * 	  all the dependent work has been done.
 * Ex. Suppose you want to calculate the population of India(North/South/East/West)
 * 	   For this we will calculate population of each region, then we will calculate the whole after that. 
 */
public class IndiaPopulation {

	public static void main(String[] args) {
		OneIndia oneIndia =  new OneIndia();
		CyclicBarrier barrier = new CyclicBarrier(4, oneIndia);
		
		Thread northIndia 	= new Thread(new NorthIndia(barrier),"NorthIndia");
		Thread southIndia 	= new Thread(new SouthIndia(barrier),"SouthIndia");
		Thread eastIndia 	= new Thread(new EastIndia(barrier),"EastIndia");
		Thread westIndia 	= new Thread(new WestIndia(barrier),"WestIndia");
		
		northIndia.start();
		southIndia.start();
		eastIndia.start();
		westIndia.start();
		
	}

}
