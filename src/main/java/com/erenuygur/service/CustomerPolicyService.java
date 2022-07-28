package com.erenuygur.service;

import com.erenuygur.model.Customer;
import com.erenuygur.model.CustomerPolicy;
import com.erenuygur.model.Policy;
import com.erenuygur.repository.CustomerPolicyRepository;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.List;

@NoArgsConstructor
@Data
public class CustomerPolicyService {
    CustomerPolicyRepository customerPolicyRepository;

    public CustomerPolicy getCustomerPolicy(int id) throws Exception {
        return customerPolicyRepository.getCustomerPolicy(id);
    }

    public List<CustomerPolicy> listCustomerPolicy() {
        return customerPolicyRepository.getAllCustomerPolicy();
    }

    public LinkedHashMap<String, Double> getReportByYear() {
        return this.customerPolicyRepository.getTotalAmountByYear();
    }
}
