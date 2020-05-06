package com.smart.smile.transaction.impl;

import com.smart.smile.aop.Person;
import com.smart.smile.transaction.PersonService;

//@Component
public class PersonServiceImpl implements PersonService {

	@Override
	public Person getPerson() throws CustomeException {
		throw new CustomeException("getPerson");
	}

	@Override
	public int updatePerson() {
		throw new UnsupportedOperationException("updatePerson");
	}

	@Override
	public int insertPerson() {
		throw new RuntimeException("insertPerson");
	}

	public static class CustomeException extends Throwable {

		private static final long serialVersionUID = 107211903948259022L;

		public CustomeException(String message) {
			super(message);
		}
	}
}
