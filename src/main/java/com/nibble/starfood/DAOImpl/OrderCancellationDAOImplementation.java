package com.nibble.starfood.DAOImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nibble.starfood.DAOI.OrderCancellationDAO;
import com.nibble.starfood.hibernatemodel.CancelledOrderDetails;
import com.nibble.starfood.hibernatemodel.CustDet;
import com.nibble.starfood.hibernatemodel.CustOrdCancel;
import com.nibble.starfood.hibernatemodel.CustOrdDet;

@Repository
public class OrderCancellationDAOImplementation implements OrderCancellationDAO {

	@Autowired
	private SessionFactory sessionF;
	
	@Override
	public String getCheckCancelDates(String cancelDT, int orderId) {

		final Session session = sessionF.getCurrentSession();
		final Query query = session
				.createQuery("from CustOrdCancel c where c.cancelledForDate=:canceldate and c.custOrdDetId=:orderId");
		query.setParameter("canceldate", cancelDT);
		query.setParameter("orderId", orderId);

		if (query.list().size() == 0) {
			return null;
		} else {
			return "already cancelled";
		}
	}

	@Override
	public CustOrdCancel saveOrdCal(CustOrdCancel ord) {

		final org.hibernate.Session session = sessionF.getCurrentSession();
		session.save(ord);
		return ord;
	}

	@Override
	public CustDet findCustDetBYId(int id) {
		final org.hibernate.Session session = sessionF.getCurrentSession();
		final CustDet cust = (CustDet) session.load(CustDet.class, id);
		return cust;
	}

	@Override
	public void updateCustDet(CustDet custdev) {
		final org.hibernate.Session session = sessionF.getCurrentSession();
		session.saveOrUpdate(custdev);

	}
	
	@Override
	public CustOrdDet getCustOrdDetById(int OrderDetails) {

		final Session session = sessionF.getCurrentSession();
		final Query query = session
				.createQuery("From CustOrdDet c where c.id =:orderId");
		query.setParameter("orderId", OrderDetails);
		final CustOrdDet order = (CustOrdDet) query.list().get(0);
		return order;
	}

	@Override
	public int updateCustOrdDetails(CustOrdDet order) {

		final Session session = sessionF.getCurrentSession();
		session.merge(order);
		System.out.println("Details are saving");
		return 1;
	}

	@Override
	public CustDet custdet(int custId) {
		CustDet custDetList = new CustDet();
		final Session session = sessionF.getCurrentSession();
		final Query query = session
				.createQuery("From CustDet c where c.id=:customerId");
		query.setParameter("customerId", custId);

		if (query.list().size() == 0) {
			return null;
		} else {
			custDetList = (CustDet) query.list().get(0);
			return custDetList;
		}
	}
	
	@Override
	public CancelledOrderDetails saveOrderCancelDetails(CancelledOrderDetails orderCancelDetails) {

		final org.hibernate.Session session = sessionF.getCurrentSession();
		session.save(orderCancelDetails);
		return orderCancelDetails;
	}
	
	@Override
	public CustDet findCustDevBYId(int id) {
		final Session session = sessionF.getCurrentSession();
		final CustDet cust = (CustDet) session
				.createQuery("FROM  CustDet where id=:id")
				.setParameter("id", id).list().get(0);
		return cust;
	}
}
