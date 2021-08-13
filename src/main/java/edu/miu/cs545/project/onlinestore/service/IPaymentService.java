package edu.miu.cs545.project.onlinestore.service;

import edu.miu.cs545.project.onlinestore.domain.Payment;

public interface IPaymentService {
    Payment createPayment(Payment payment);
}
