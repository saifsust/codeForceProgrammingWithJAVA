package com.datainputfactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileFactory {

	private FileFactory() {
		try {

			reader = new FileReader("Data/in.txt");
			buffer = new BufferedReader(reader);
			scanner = new Scanner(buffer);
			writer = new FileWriter("Data/out.txt");
			bufferWriter = new BufferedWriter(writer);

		} catch (Exception ex) {
			System.out.println(ex.getCause());
		}

	}

	public static Scanner read() {
		return instanceFactory.scanner;
	}

	public static BufferedWriter write() {
		return instanceFactory.bufferWriter;
	}

	public static void close() {

		try {

			instanceFactory.scanner.close();
			instanceFactory.buffer.close();
			instanceFactory.reader.close();
			instanceFactory.bufferWriter.close();
			instanceFactory.writer.close();

		} catch (Exception ex) {
			System.out.println(ex.getCause());
		}

	}

	private static FileFactory instanceFactory = new FileFactory();
	private FileReader reader;
	private BufferedReader buffer;
	private Scanner scanner;
	private FileWriter writer;
	private BufferedWriter bufferWriter;

}
