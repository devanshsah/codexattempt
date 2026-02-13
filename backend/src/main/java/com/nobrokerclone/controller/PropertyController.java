package com.nobrokerclone.controller;

import com.nobrokerclone.dto.PropertyRequest;
import com.nobrokerclone.entity.ModerationStatus;
import com.nobrokerclone.entity.Property;
import com.nobrokerclone.service.PropertyService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
@CrossOrigin(origins = "*")
public class PropertyController {
    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping
    public Property create(@Valid @RequestBody PropertyRequest request) {
        return propertyService.create(request);
    }

    @GetMapping("/tenant")
    public List<Property> listTenantView() {
        return propertyService.listApprovedActive();
    }

    @GetMapping("/owner/{email}")
    public List<Property> listOwnerView(@PathVariable String email) {
        return propertyService.listOwnerProperties(email);
    }

    @GetMapping("/moderator/pending")
    public List<Property> listPending() {
        return propertyService.listPendingForModerator();
    }

    @PutMapping("/moderator/{id}/approve")
    public Property approve(@PathVariable Long id) {
        return propertyService.moderate(id, ModerationStatus.APPROVED);
    }

    @PutMapping("/moderator/{id}/reject")
    public Property reject(@PathVariable Long id) {
        return propertyService.moderate(id, ModerationStatus.REJECTED);
    }

    @PutMapping("/admin/{id}/disable")
    public Property disableByAdmin(@PathVariable Long id) {
        return propertyService.disable(id);
    }
}
