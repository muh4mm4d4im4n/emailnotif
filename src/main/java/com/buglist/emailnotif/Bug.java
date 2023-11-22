package com.buglist.emailnotif;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "bug_list_details")
public class Bug {
    
    @Id
    @Column(name = "bug_list_id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long bugListId;
    
    @Column(name = "sr_no")
    private String srNo;

    @Column(name = "customer_name")
    private String customerName;
    
    @Column(name = "project_name")
    private String projectName;
    
    @Column(name = "bug_id")
    private String bugId;
    
    @Column(name = "environment")
    private String environment;
    
    @Column(name = "summary")
    private String summary;

    @Column(name = "incident_type")
    private String incidentType;
    
    @Column(name = "reported_date")
    private String reportedDate;
    
    @Column(name = "date_fixed")
    private String dateFixed;
    
    @Column(name = "days_to_fix")
    private int daysToFix;
    
    @Column(name = "aging")
    private int aging;
    
    @Column(name = "asignee_to")
    private String assigneeTo;

    @Column(name = "asignee_to_email")
    private String assigneeToEmail;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "assigned_by")
    private String assignedBy;
    
    @Column(name = "remarks")
    private String remarks;
}