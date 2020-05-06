package com.smart.smile.transaction.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class CustomerTransactionManager implements PlatformTransactionManager {

	@Autowired
	private PlatformTransactionManager transactionManager;

	@Override
	public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition(definition);
		def.setIsolationLevel(TransactionDefinition.ISOLATION_DEFAULT);
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus transactionStatus = transactionManager.getTransaction(def);
		return transactionStatus;
	}

	@Override
	public void commit(TransactionStatus status) throws TransactionException {
			status.flush();
	}

	@Override
	public void rollback(TransactionStatus status) throws TransactionException {
			status.setRollbackOnly();
	}
}
