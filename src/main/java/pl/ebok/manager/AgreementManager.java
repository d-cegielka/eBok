package pl.ebok.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;
import pl.ebok.IAgreement;
import pl.ebok.model.Agreement;
import pl.ebok.model.AgreementService;
import pl.ebok.model.Hardware;
import pl.ebok.model.Service;
import pl.ebok.repository.AgreementRepository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories(basePackageClasses = AgreementRepository.class)
@RestController
public class AgreementManager implements IAgreement {
    private final AgreementRepository agreementRepository;

    @Autowired
    public AgreementManager(AgreementRepository agreementRepository) {
        this.agreementRepository = agreementRepository;
    }

    @Override
    public List<Agreement> getAll() {
        return agreementRepository.findAll();
    }

    @Override
    public Optional<Agreement> getById(Integer id) {
        return agreementRepository.findById(id);
    }

    @Override
    public Agreement addAgreement(Agreement agreement, List<Service> services, List<Hardware> hardwares) {
//        Agreement added = agreementRepository.save(agreement);
        for (Service service : services) {
            agreement.getAgreementServices().add(new AgreementService(agreement, service, service.getFee()));
        }
        agreement.getHardwares().addAll(hardwares);
        return agreementRepository.save(agreement);
    }

    @Override
    public Agreement updateAgreement(Agreement changedAgreement, Integer id) {
        Optional<Agreement> agreement = agreementRepository.findById(id);
        if (agreement.isEmpty())
            return null;
        changedAgreement.setIdAgreement(id);
        return agreementRepository.save(changedAgreement);
    }
}
