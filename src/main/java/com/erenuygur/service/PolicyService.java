package com.erenuygur.service;

import com.erenuygur.model.Policy;
import com.erenuygur.repository.PolicyRepository;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class PolicyService {
    private PolicyRepository policyRepository;

    public Policy createPolicy(Policy policy) {
        return policyRepository.create(policy);
    }

    public Policy getPolicy(int id) throws Exception {
        return policyRepository.getPolicy(id);
    }

    public List<Policy> listPolicy() {
        return policyRepository.getAllPolicy();
    }

}
