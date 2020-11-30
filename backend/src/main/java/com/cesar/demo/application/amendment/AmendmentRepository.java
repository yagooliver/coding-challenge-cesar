package com.cesar.demo.application.amendment;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin
public interface AmendmentRepository extends CrudRepository<Amendment, Long>, JpaSpecificationExecutor<Amendment> {
}
