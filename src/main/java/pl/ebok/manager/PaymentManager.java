package pl.ebok.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;
import pl.ebok.IPayment;
import pl.ebok.model.Payment;
import pl.ebok.repository.PaymentRepository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories(basePackageClasses = PaymentRepository.class)
@RestController
public class PaymentManager implements IPayment {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentManager(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<Payment> getById(Integer id) {
        return paymentRepository.findById(id);
    }

    @Override
    public Payment addPayment(Payment hardware) {
        return paymentRepository.save(hardware);
    }

    @Override
    public Payment updatePayment(Payment changedPayment, Integer id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        if (payment.isEmpty())
            return null;

        changedPayment.setIdPayment(id);
        return paymentRepository.save(changedPayment);
    }

}
