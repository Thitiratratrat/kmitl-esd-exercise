package kmitl.esd.exercise2;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@SpringBootApplication
public class Client {

    private static final Logger log = LoggerFactory.getLogger(Client.class);
    private String baseUrl = "http://localhost:8000/customer/";

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Client.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8001"));
        app.run(args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    /**
     * Main entry point for the client
     */
    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            /**
             * Call add customer
             */
            CustomerDTO addedCustomer = callAddCustomer(restTemplate);

            log.info("Call add customer: " + addedCustomer.toString());

            CustomerDTO[] customers = callGetAllCustomers(restTemplate);

            /**
             * Call get all customer
             */
            log.info("Call get all customers");

            for (CustomerDTO customer : customers) {
                log.info(customer.toString());
            }

            /**
             * Call get customer
             */
            CustomerDTO customer = callGetCustomer(restTemplate, "0");

            log.info("Call get customer with Id 0: " + customer.toString());

            /**
             * Call update customer
             */
            CustomerDTO updatedCustomer = callUpdateCustomer(restTemplate);

            log.info("Call update customer with Id 0: " + updatedCustomer.toString());

            /**
             * Call delete customer
             */
            ResponseEntity responseEntity = callDeleteCustomer(restTemplate, "0");

            log.info("Call delete customer status code: " + " " + responseEntity.getStatusCode());
        };
    }


    CustomerDTO[] callGetAllCustomers(RestTemplate restTemplate) {
        String url = baseUrl + "findall";
        CustomerDTO[] customer = restTemplate.getForObject(url, CustomerDTO[].class);

        return customer;
    }

    CustomerDTO callGetCustomer(RestTemplate restTemplate, String id) {
        String url = baseUrl + "find/" + id;
        CustomerDTO customer = restTemplate.getForObject(url, CustomerDTO.class);

        return customer;
    }

    CustomerDTO callAddCustomer(RestTemplate restTemplate) throws JSONException {
        JSONObject customerData = new JSONObject();
        customerData.put("name", "John");
        customerData.put("age", 20);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestBody =
                new HttpEntity<>(customerData.toString(), headers);

        CustomerDTO customer = restTemplate.postForObject(baseUrl, requestBody, CustomerDTO.class);

        return customer;
    }

    CustomerDTO callUpdateCustomer(RestTemplate restTemplate) throws JSONException {
        JSONObject customerData = new JSONObject();
        customerData.put("id", 0);
        customerData.put("name", "Jay");
        customerData.put("age", 22);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestBody =
                new HttpEntity<>(customerData.toString(), headers);

        ResponseEntity<CustomerDTO> customer =
                restTemplate.exchange(baseUrl, HttpMethod.PUT, requestBody, CustomerDTO.class);

        return customer.getBody();
    }

    ResponseEntity<String> callDeleteCustomer(RestTemplate restTemplate, String id) {
        String url = baseUrl + "/" + id;
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);

        return response;
    }
}