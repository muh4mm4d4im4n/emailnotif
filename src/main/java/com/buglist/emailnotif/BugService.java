package com.buglist.emailnotif;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BugService {

    @Autowired
    private BugRepository bugRepository;

    public List<Bug> findBugsWithOpenStatus() {
        return bugRepository.findByStatusNotIgnoreCase("Closed");
    }
}