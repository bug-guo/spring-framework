package com.smart.smile.transaction;

import com.smart.smile.aop.Person;
import com.smart.smile.transaction.impl.PersonServiceImpl;

public interface PersonService {
	 Person getPerson() throws PersonServiceImpl.CustomeException;

	 int updatePerson() ;

	 int insertPerson() ;
}
