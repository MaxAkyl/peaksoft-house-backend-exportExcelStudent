package peaksofthousebackend.services;


import peaksofthousebackend.dto.request.SaveAdminRequest;
import peaksofthousebackend.dto.response.SaveAdminResponse;
import peaksofthousebackend.repositories.AdminRepo;

public class AdminService {


    private final AdminRepo adminRepo;

    public AdminService(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }


    public SaveAdminResponse save(SaveAdminRequest saveAdminRequest) {
        return null;
    }
}
