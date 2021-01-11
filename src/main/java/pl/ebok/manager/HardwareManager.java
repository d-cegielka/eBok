package pl.ebok.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;
import pl.ebok.IHardware;
import pl.ebok.model.Hardware;
import pl.ebok.repository.HardwareRepository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories(basePackageClasses = HardwareRepository.class)
@RestController
public class HardwareManager implements IHardware {
    private final HardwareRepository hardwareRepository;

    @Autowired
    public HardwareManager(HardwareRepository hardwareRepository) {
        this.hardwareRepository = hardwareRepository;
    }

    @Override
    public List<Hardware> getAll() {
        return hardwareRepository.findAll();
    }

    @Override
    public Optional<Hardware> getById(Integer id) {
        return hardwareRepository.findById(id);
    }

    @Override
    public Hardware addHardware(Hardware hardware) {
        return hardwareRepository.save(hardware);
    }

    @Override
    public Hardware updateHardware(Hardware changedHardware, Integer id) {
        Optional<Hardware> hardware = hardwareRepository.findById(id);
        if (hardware.isEmpty())
            return null;

        changedHardware.setIdHardware(id);
        return hardwareRepository.save(changedHardware);
    }

    @Override
    public void deleteHardware(Integer id) {
        hardwareRepository.deleteById(id);
    }
}
