package com.datainputfactory;

import java.io.BufferedWriter;
import java.util.Scanner;

public interface Reader {
	public static Scanner read = FileFactory.read();
	public static BufferedWriter write = FileFactory.write();
	public  FileFactory close = null;
}
