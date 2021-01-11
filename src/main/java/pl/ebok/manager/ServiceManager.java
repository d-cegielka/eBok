package pl.ebok.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;
import pl.ebok.IService;
import pl.ebok.model.Service;
import pl.ebok.repository.ServiceRepository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories(basePackageClasses = ServiceRepository.class)
@RestController
public class ServiceManager implements IService {
    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceManager(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public List<Service> getAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Optional<Service> getById(Integer id) {
        return serviceRepository.findById(id);
    }

    @Override
    public Service addService(Service hardware) {
        return serviceRepository.save(hardware);
    }

    @Override
    public Service updateService(Service changedService, Integer id) {
        Optional<Service> service = serviceRepository.findById(id);
        if (service.isEmpty())
            return null;

        changedService.setIdService(id);
        return serviceRepository.save(changedService);
    }

    @Override
    public void deleteService(Integer id) {
        serviceRepository.deleteById(id);
    }
}
