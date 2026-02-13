package com.nobrokerclone.repository;

import com.nobrokerclone.entity.ModerationStatus;
import com.nobrokerclone.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    List<Property> findByActiveTrueAndModerationStatus(ModerationStatus moderationStatus);
    List<Property> findByOwnerEmail(String ownerEmail);
    List<Property> findByModerationStatus(ModerationStatus moderationStatus);
}
