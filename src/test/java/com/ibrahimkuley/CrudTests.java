package com.ibrahimkuley;

import com.ibrahimkuley.dao.PersonDAO;
import com.ibrahimkuley.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( "classpath:spring-contex.xml" )
public class CrudTests
{
	@Autowired
	private PersonDAO personDAO;

	@Test
	public void createTest()
	{
		Person person = new Person();
		person.setName( "Halil ibrahim" );
		person.setSurname( "Küley" );
		personDAO.create( person );
	}

	@Test
	public void deleteTest()
	{
		Person person = new Person();
		person.setId( 1L );
		personDAO.delete( person );
	}

	@Test
	public void updateTest()
	{
		Person person = new Person();
		person.setId( 4L );
		person.setName( "sevsenko" );
		person.setSurname( "kuley" );
		personDAO.update( person );
	}

	@Test
	public void findByIdTest()
	{
		Person person = personDAO.findById( 1L );
		System.out.println( person.getId() + "\n" + person.getName() + "\n" + person.getSurname() );
	}
}
