package com.coreJava.test;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class CaptureScreenShot {
	static BufferedImage image = null;
	static long l = 0;

	public static void main(String[] args) {
		
		
		Thread t = new Thread(()-> {
			while (true) {
				try {
					image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
					ImageIO.write(image, "png", new File("C:/Users/Milu/Desktop/TekSystems/screenshot"+l+".png"));
					l++;
					Thread.sleep(5000);
				} catch (HeadlessException | AWTException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t.run();
	}
}
