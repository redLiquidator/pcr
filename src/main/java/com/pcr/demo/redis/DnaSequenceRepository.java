package com.pcr.demo.redis;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface DnaSequenceRepository  extends CrudRepository<DnaSequence, Integer> {

}
