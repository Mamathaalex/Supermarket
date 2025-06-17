package utilities;

import com.github.javafaker.Address;
import com.github.javafaker.Book;
import com.github.javafaker.Faker;

public class FakerUtility 
{
	public String getFakeFirstName() {

		Faker faker = new Faker();

		Address address = faker.address();

		String text = address.firstName();

		return text;

	}
public String getPassword() {

		Faker faker = new Faker();

		Address address = faker.address();

		String text = address.lastName();

		return text;
	}
public String getFakeCityName() {

		Faker faker = new Faker();

		Address address = faker.address();

		String text = address.cityName();

		return text;

	}
public String getFakeCategoryNameBook() //to use in ManageCategorypage
{

	Faker faker = new Faker();

	Book book = faker.book();

	String text = book.title();

	return text;

}
}