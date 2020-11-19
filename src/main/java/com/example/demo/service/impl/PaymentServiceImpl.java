package com.example.demo.service.impl;

import com.example.demo.model.dto.ChargeRequest;
import com.example.demo.service.PaymentService;
import com.stripe.Stripe;
import com.stripe.exception.*;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService {




    @PostConstruct
    public void init(){
        Stripe.apiKey ="sk_test_51HoyOXJYSPEp87Bj8n0MmZMINu2mWAWfxXjjar0ztTWBJXc4oLMypaCGEj3SOElWG5PJjla6y8oFOPbDY1dJaBum00SBtnSNNe";
    }





    @Override
    public Charge pay(ChargeRequest chargeRequest) throws StripeException {
        Map<String,Object> chargeMap = new HashMap<>();
        chargeMap.put("amount",chargeRequest.getAmount());
        chargeMap.put("currency",chargeRequest.getCurrency());
        chargeMap.put("source",chargeRequest.getStripeToken());
        chargeMap.put("description",chargeRequest.getDescription());


        return Charge.create(chargeMap);
    }
}