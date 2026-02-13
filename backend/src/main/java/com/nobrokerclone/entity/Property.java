package com.nobrokerclone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "property")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String locality;

    @Column(nullable = false)
    private int rent;

    @Column(nullable = false)
    private int bhk;

    @Column(nullable = false)
    private String ownerEmail;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ModerationStatus moderationStatus = ModerationStatus.PENDING;

    @Column(nullable = false)
    private boolean active = true;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getLocality() { return locality; }
    public void setLocality(String locality) { this.locality = locality; }
    public int getRent() { return rent; }
    public void setRent(int rent) { this.rent = rent; }
    public int getBhk() { return bhk; }
    public void setBhk(int bhk) { this.bhk = bhk; }
    public String getOwnerEmail() { return ownerEmail; }
    public void setOwnerEmail(String ownerEmail) { this.ownerEmail = ownerEmail; }
    public ModerationStatus getModerationStatus() { return moderationStatus; }
    public void setModerationStatus(ModerationStatus moderationStatus) { this.moderationStatus = moderationStatus; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
