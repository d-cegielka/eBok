package pl.ebok;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import pl.ebok.model.*;
import pl.ebok.repository.ServiceRepository;
import pl.ebok.repository.UserRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@AutoConfigureJsonTesters
@SpringBootTest
@AutoConfigureMockMvc
class IAgreementTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private IAgreement agreementManager;

    @Autowired
    private UserRepository users;

    @Autowired
    private ServiceRepository services;

    private User client1;
    private Service service1;
    @BeforeEach
    void setUp() {
        // public User(String firstName, String lastName, String email, String passwordHash, Boolean enabledAccount, Boolean businessAccount, String companyName, String taxId, String phoneNumber, String address, String zipCode, String city) {
        client1 = new User("Jan", "Kowalczyk", "jkowalczyk@gmail.com", "haslo12345", true, false,"", "99892509874", "999777666", "Prosta 10", "90-001", "Łódź");
        users.save(client1);

        service1 = new Service("Internet 50/10",59.9, "Internet szerokopasmowy 50 Mb/s download, 10 Mb/s upload");
        services.save(service1);
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void getById() {
    }

    @Test
    void addAgreement() {
        Agreement agreement = new Agreement();
        agreement.setAgreementType("Umowa");
        agreement.setAgreementNumber("1/2021");
        agreement.setBillingDay(10);
        agreement.setCreationDate(LocalDate.now());
        agreement.setStartDate(LocalDate.now().plusDays(2));
        agreement.setEndDate(LocalDate.now().plusYears(2));
        agreement.setUser(client1);

        AgreementService agreementService = new AgreementService();
        agreementService.setAgreement(agreement);
        agreementService.setService(service1);
        agreementService.setFinalFee(49.90);

        List<AgreementService> agreementServiceList = new ArrayList<>();
        agreementServiceList.add(agreementService);
        System.out.println(agreementManager.addAgreement(agreement, agreementServiceList, new ArrayList<>()));

        /*MockHttpServletResponse response = mvc.perform(
                post("/agreements").contentType(MediaType.APPLICATION_JSON).content()
        )*/
    }

    @Test
    void getAll() {
        System.out.println("Users:" + users.findAll());
        System.out.println("Agreements:" + agreementManager.getAll());
    }

    @Test
    void updateAgreement() {
    }
}