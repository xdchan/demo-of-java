package cn.cxd.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class MyPlayer {

	public static void main(String[] args) throws Exception {

		// BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(new
		// File("E:/李荣浩 - 老街.mp3")));
		//
		// Player player = new Player(buffer);
		//
		// player.play();
		while (true) {
			new Player(new BufferedInputStream(new FileInputStream(new File("E:/李荣浩 - 老街.mp3")))).play();
		}
	}

}
