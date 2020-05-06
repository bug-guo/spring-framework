package com.smart.smile.transaction.impl;


import com.smart.smile.transaction.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 使用声明式事务  事务模版
 */
@Component
//@Transactional(transactionManager = "userTransaction")
public class UserServiceImpl implements UserService {
	@Autowired
	private TransactionTemplate transactionTemplate;

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	// 处理监听到的事件
	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
	public void handleTest(MyTransactionEvent event) {
		System.out.println("hello");

	}
	@Override
	public void query() {

		transactionTemplate.execute(new TransactionCallbackWithoutResult() {

			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				try {
					eventPublisher.publishEvent(new MyTransactionEvent(this,"userService"));
					throw new ArrayIndexOutOfBoundsException("array");
				} catch (Exception e) {
					System.out.println("roll back");
					status.setRollbackOnly();

				}
			}
		});

	}

	@Override
	public int update() {
		return 0;
	}
}
