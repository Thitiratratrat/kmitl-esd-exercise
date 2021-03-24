package kmitl.esd.exercise;

import kmitl.esd.exercise.model.Customer;
import kmitl.esd.exercise.model.Quotation;
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
    private String baseCustomerUrl = "http://localhost:8000/customer/";
    private String baseQuotationUrl = "http://localhost:8000/quotation/";

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
            Customer addedCustomer = callAddCustomer(restTemplate);

            log.info("Call add customer: " + addedCustomer.toString());

            Customer[] customers = callGetAllCustomers(restTemplate);

            /**
             * Call get all customer
             */
            log.info("Call get all customers");

            for (Customer customer : customers) {
                log.info(customer.toString());
            }

            /**
             * Call get customer
             */
            Customer customer = callGetCustomer(restTemplate, "0");

            log.info("Call get customer with Id 0: " + customer.toString());

            /**
             * Call update customer
             */
            Customer updatedCustomer = callUpdateCustomer(restTemplate);

            log.info("Call update customer with Id 0: " + updatedCustomer.toString());

            /**
             * Call delete customer
             */
            ResponseEntity responseEntity = callDeleteCustomer(restTemplate, "0");

            log.info("Call delete customer status code: " + " " + responseEntity.getStatusCode());

            /**
             * prepare quotation customer data
             */

            callAddCustomer(restTemplate);

            /**
             * Call add quotation
             */
            Quotation addedQuotation = callAddQuotation(restTemplate);

            log.info("Call add quotation: " + addedQuotation.toString());

            Quotation[] quotations = callGetAllQuotations(restTemplate);

            /**
             * Call get all quotations
             */
            log.info("Call get all quotations");

            for (Quotation quotation : quotations) {
                log.info(quotation.toString());
            }

            /**
             * Call get quotation
             */
            Quotation quotation = callGetQuotaiton(restTemplate, "0");

            log.info("Call get customer with Id 0: " + quotation.toString());

            /**
             * Call update quotation
             */
            Quotation updatedQuotation = callUpdateQuotation(restTemplate);

            log.info("Call update quotation with Id 0: " + updatedQuotation.toString());

            /**
             * Call delete quotation
             */
            ResponseEntity quotationResponseEntity = callDeleteQuotation(restTemplate, "0");

            log.info("Call delete quotation status code: " + " " + quotationResponseEntity.getStatusCode());

        };
    }


    Customer[] callGetAllCustomers(RestTemplate restTemplate) {
        String url = baseCustomerUrl + "findall";
        Customer[] customer = restTemplate.getForObject(url, Customer[].class);

        return customer;
    }

    Customer callGetCustomer(RestTemplate restTemplate, String id) {
        String url = baseCustomerUrl + "find/" + id;
        Customer customer = restTemplate.getForObject(url, Customer.class);

        return customer;
    }

    Customer callAddCustomer(RestTemplate restTemplate) throws JSONException {
        JSONObject customerData = new JSONObject();
        customerData.put("id", 0);
        customerData.put("name", "Johnson");
        customerData.put("birthday", "2000-02-11");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestBody =
                new HttpEntity<>(customerData.toString(), headers);

        Customer customer = restTemplate.postForObject(baseCustomerUrl, requestBody, Customer.class);

        return customer;
    }

    Customer callUpdateCustomer(RestTemplate restTemplate) throws JSONException {
        JSONObject customerData = new JSONObject();
        customerData.put("id", 0);
        customerData.put("name", "Johnson");
        customerData.put("birthday", "2001-02-11");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestBody =
                new HttpEntity<>(customerData.toString(), headers);

        ResponseEntity<Customer> customer =
                restTemplate.exchange(baseCustomerUrl, HttpMethod.PUT, requestBody, Customer.class);

        return customer.getBody();
    }

    ResponseEntity<String> callDeleteCustomer(RestTemplate restTemplate, String id) {
        String url = baseCustomerUrl + "/" + id;
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);

        return response;
    }

    Quotation[] callGetAllQuotations(RestTemplate restTemplate) {
        String url = baseQuotationUrl + "findall";
        Quotation[] quotations = restTemplate.getForObject(url, Quotation[].class);

        return quotations;
    }

    Quotation callGetQuotaiton(RestTemplate restTemplate, String id) {
        String url = baseQuotationUrl + "find/" + id;
        Quotation quotation = restTemplate.getForObject(url, Quotation.class);

        return quotation;
    }

    Quotation callAddQuotation(RestTemplate restTemplate) throws JSONException {
        JSONObject quotationData = new JSONObject();
        JSONObject customerData = new JSONObject();
        customerData.put("id", 0);
        customerData.put("name", "Johnson");
        customerData.put("birthday", "2001-02-11");
        quotationData.put("id", 0);
        quotationData.put("price", 200);
        quotationData.put("creationDateTime", "2021-03-18T10:46");
        quotationData.put("validUntilDateTime", "2021-10-23T10:46");
        quotationData.put("reference", "Johnson's quotation");
        quotationData.put("customer", customerData);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestBody =
                new HttpEntity<>(quotationData.toString(), headers);

        Quotation quotation = restTemplate.postForObject(baseQuotationUrl, requestBody, Quotation.class);

        return quotation;
    }

    Quotation callUpdateQuotation(RestTemplate restTemplate) throws JSONException {
        JSONObject quotationData = new JSONObject();
        JSONObject customerData = new JSONObject();
        customerData.put("id", 0);
        customerData.put("name", "Johnson");
        customerData.put("birthday", "2001-02-11");
        quotationData.put("id", 0);
        quotationData.put("price", 400);
        quotationData.put("creationDateTime", "2021-03-18T10:46");
        quotationData.put("validUntilDateTime", "2021-10-23T10:46");
        quotationData.put("reference", "Johnson's quotation");
        quotationData.put("customer", customerData);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestBody =
                new HttpEntity<>(quotationData.toString(), headers);

        ResponseEntity<Quotation> quotation =
                restTemplate.exchange(baseCustomerUrl, HttpMethod.PUT, requestBody, Quotation.class);

        return quotation.getBody();

    }

    ResponseEntity<String> callDeleteQuotation(RestTemplate restTemplate, String id) {
        String url = baseQuotationUrl + "/" + id;
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);

        return response;
    }


}