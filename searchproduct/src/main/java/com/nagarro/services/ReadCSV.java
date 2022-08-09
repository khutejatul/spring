package com.nagarro.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.hibernate.Session;

import com.nagarro.models.Tshirt;
import com.nagarro.utils.HibernateUtilities;

public class ReadCSV implements Runnable {

	public void readCSVData() {
		String csvFilePath = "C:/resources";
		final File directoryPath = new File(csvFilePath);
		File filesList[] = directoryPath.listFiles();

		try {
			for (File file : filesList) {
				BufferedReader lineReader = new BufferedReader(new FileReader(file));

				CSVParser records = CSVParser.parse(lineReader,
						CSVFormat.EXCEL.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim().withDelimiter('|'));

				try (Session session = HibernateUtilities.getSessionInstance()) {
					session.getTransaction().begin();
					for (CSVRecord record : records) {
						Tshirt tshirt = new Tshirt();
						tshirt.setId(record.get(0));
						tshirt.setName(record.get(1));
						tshirt.setColor(record.get(2));
						tshirt.setGender(record.get(3));
						tshirt.setSize(record.get(4));
						tshirt.setPrice(record.get(5));
						tshirt.setRating(record.get(6));
						tshirt.setAvailability(record.get(7));
						session.save(tshirt);
					}
					session.getTransaction().commit();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String csvFilePath = "C:\\Users\\aayushigupta01\\eclipse-workspace\\searchproduct\\src\\main\\resources";
		final File directoryPath = new File(csvFilePath);
		File filesList[] = directoryPath.listFiles();
		try {
			for (File file : filesList) {
				BufferedReader lineReader = new BufferedReader(new FileReader(file));

				CSVParser records = CSVParser.parse(lineReader,
						CSVFormat.EXCEL.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim().withDelimiter('|'));

				// SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				// .addAnnotatedClass(Tshirt.class).buildSessionFactory();
				// Session session = factory.openSession();

				try (Session session = HibernateUtilities.getSessionInstance()) {
					session.getTransaction().begin();
					// Tshirt user = session.get(Tshirt.class,id);
					// session.beginTransaction();
					for (CSVRecord record : records) {
						Tshirt tshirt = new Tshirt();
						tshirt.setId(record.get(0));
						tshirt.setName(record.get(1));
						tshirt.setColor(record.get(2));
						tshirt.setGender(record.get(3));
						tshirt.setSize(record.get(4));
						tshirt.setPrice(record.get(5));
						tshirt.setRating(record.get(6));
						tshirt.setAvailability(record.get(7));
						session.save(tshirt);
					}
					session.getTransaction().commit();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

	}

}
