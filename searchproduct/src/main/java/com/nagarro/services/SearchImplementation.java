package com.nagarro.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nagarro.exceptions.NotExistsException;
import com.nagarro.models.Tshirt;
import com.nagarro.utils.HibernateUtilities;

public class SearchImplementation {

	public List<Tshirt> searchTshirt(String color, String size, String gender, String outputPreference)
			throws NotExistsException {

		try (Session session = HibernateUtilities.getSessionInstance()) {
			session.getTransaction().begin();

			String hql = "from Tshirt where color = '" + color + "' AND size = '" + size + "' AND gender = '" + gender
					+ "'";
			Query query = session.createQuery(hql);
			List<Tshirt> results = query.list();

			int choice = Integer.parseInt(outputPreference);

			switch (choice) {
			case 1:
				try {
					Collections.sort(results, new Comparator<Tshirt>() {
						public int compare(Tshirt p1, Tshirt p2) {
							return Integer.parseInt(p1.getPrice()) - Integer.parseInt(p2.getPrice());
						}
					});
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					Collections.sort(results, new Comparator<Tshirt>() {
						public int compare(Tshirt p1, Tshirt p2) {
							return Integer.parseInt(p1.getRating()) - Integer.parseInt(p2.getRating());
						}
					});
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					Collections.sort(results, new Comparator<Tshirt>() {
						public int compare(Tshirt p1, Tshirt p2) {
							return (Integer.parseInt(p1.getPrice())
									- Integer.parseInt(p2.getPrice()) / Integer.parseInt(p1.getRating())
									- Integer.parseInt(p2.getRating()));
						}
					});
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("Wrong input");
			}
			if (results.isEmpty())
				throw new NotExistsException("Sorry...Product not available");

			session.getTransaction().commit();
			return results;
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
