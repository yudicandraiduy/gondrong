package com.iduy.gondrong.repository;

import com.iduy.gondrong.models.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal,Integer> {
}
