package com.cesar.demo.application.amendment.specifications;

import com.cesar.demo.application.amendment.Amendment;
import org.springframework.data.jpa.domain.Specification;

class AmendmentSpecifications {
    private AmendmentSpecifications(){}

    public static Specification<Amendment> codeContains(String code){
        if(code == null || code.isEmpty()){
            return null;
        }

        return (root, query, cb) -> cb.like(cb.lower(root.get("code")), "%" + code + "%");
    }
}
