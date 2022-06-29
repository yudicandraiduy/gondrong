package com.iduy.gondrong.repository;

import com.iduy.gondrong.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    boolean existsByAddressAndRegency(String address, String regency);


}
