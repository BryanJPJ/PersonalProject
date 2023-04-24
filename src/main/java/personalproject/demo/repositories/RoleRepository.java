package personalproject.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import personalproject.demo.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
    
}