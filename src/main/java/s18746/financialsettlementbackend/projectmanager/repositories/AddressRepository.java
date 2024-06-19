package s18746.financialsettlementbackend.projectmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import s18746.financialsettlementbackend.projectmanager.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
}
