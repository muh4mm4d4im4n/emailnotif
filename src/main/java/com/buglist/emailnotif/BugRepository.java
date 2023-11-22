package com.buglist.emailnotif;

// import com.buglist.emailnotif.Bug;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BugRepository extends JpaRepository<Bug, Long> {
    List<Bug> findByStatusNotIgnoreCase(String status);
}