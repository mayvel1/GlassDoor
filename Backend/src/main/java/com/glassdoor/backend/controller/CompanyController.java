package com.glassdoor.backend.controller;

import com.glassdoor.backend.dto.CompanyDTO;
import com.glassdoor.backend.dto.common.ApiResponse;
import com.glassdoor.backend.entity.Company;
import com.glassdoor.backend.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public ApiResponse<CompanyDTO> addCompany( @RequestHeader("Authorization") String authHeader,
                                               @RequestBody CompanyDTO companyDTO) {
        return companyService.createCompany(authHeader,companyDTO );
    }

    @PutMapping("/{id}")
    public ApiResponse<CompanyDTO> updateCompany(@PathVariable String id, @RequestBody CompanyDTO dto) {
        return companyService.updateCompany(id, dto);
    }

    @GetMapping
    public ApiResponse<List<CompanyDTO>> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/{id}")
    public ApiResponse<CompanyDTO> getCompanyById(@PathVariable String id) {
        return companyService.getCompanyById(id);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteCompany(@PathVariable String id) {
        return companyService.deleteCompany(id);
    }

    @GetMapping("/search")
    public ApiResponse<List<CompanyDTO>> searchCompaniesByName(@RequestParam String name) {
        return companyService.searchByName(name);
    }
}

