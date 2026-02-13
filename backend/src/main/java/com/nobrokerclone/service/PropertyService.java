package com.nobrokerclone.service;

import com.nobrokerclone.dto.PropertyRequest;
import com.nobrokerclone.entity.ModerationStatus;
import com.nobrokerclone.entity.Property;
import com.nobrokerclone.repository.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {
    private final PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public Property create(PropertyRequest request) {
        Property property = new Property();
        property.setTitle(request.getTitle());
        property.setCity(request.getCity());
        property.setLocality(request.getLocality());
        property.setRent(request.getRent());
        property.setBhk(request.getBhk());
        property.setOwnerEmail(request.getOwnerEmail());
        property.setModerationStatus(ModerationStatus.PENDING);
        property.setActive(true);
        return propertyRepository.save(property);
    }

    public List<Property> listApprovedActive() {
        return propertyRepository.findByActiveTrueAndModerationStatus(ModerationStatus.APPROVED);
    }

    public List<Property> listOwnerProperties(String ownerEmail) {
        return propertyRepository.findByOwnerEmail(ownerEmail);
    }

    public List<Property> listPendingForModerator() {
        return propertyRepository.findByModerationStatus(ModerationStatus.PENDING);
    }

    public Property moderate(Long id, ModerationStatus status) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Property not found"));
        property.setModerationStatus(status);
        if (status == ModerationStatus.REJECTED) {
            property.setActive(false);
        }
        return propertyRepository.save(property);
    }

    public Property disable(Long id) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Property not found"));
        property.setActive(false);
        return propertyRepository.save(property);
    }
}
