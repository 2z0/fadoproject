package com.fado.repository;

import com.fado.entitiy.InvestarMove;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoveRepository extends JpaRepository<InvestarMove, Integer> {

    InvestarMove findByAgen(long agen);
    InvestarMove findByFore(long fore);
}
