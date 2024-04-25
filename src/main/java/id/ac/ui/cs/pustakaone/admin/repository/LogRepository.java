package id.ac.ui.cs.pustakaone.admin.repository;

import org.springframework.stereotype.Repository;

import id.ac.ui.cs.pustakaone.admin.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LogRepository extends JpaRepository<Log, String>{

}
